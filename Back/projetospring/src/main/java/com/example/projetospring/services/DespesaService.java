package com.example.projetospring.services;

import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Despesa;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.CategoriaRepository;
import com.example.projetospring.repositories.DespesaRepository;
import com.example.projetospring.repositories.UsuarioRepository;
import com.example.projetospring.services.exceptions.BadRequestException;
import com.example.projetospring.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository repository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario getUsuarioLogado() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String nome;

        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }

        Optional<Usuario> usuario = usuarioRepository.findByUsername(nome);

        return usuario.get();
    }

    @Transactional(readOnly = true)
    public Page<Despesa> findAll(Pageable pageable) {
        categoriaRepository.findAll();
        Page<Despesa> result = repository.findAll(pageable);
        return result;
    }


    public List<Despesa> findDespesaByUsuario() {
        categoriaRepository.findAll();
        Usuario usuario = getUsuarioLogado();
        List<Despesa> despesas = repository.despesasbyUsuario(usuario.getUsuarioId());
        return despesas;
    }

    public List<Despesa> findDespesasByMonth(int month, int year) {
        categoriaRepository.findAll();
        Usuario usuario = getUsuarioLogado();
        List<Despesa> despesas = repository.despesasByMonth(usuario.getUsuarioId(), month, year);
        return despesas;
    }

    public Double soma() {
        Usuario usuario = getUsuarioLogado();
        return repository.soma(usuario.getUsuarioId());
    }

    @Transactional(readOnly = true)
    public List<CategoriaSoma> amountGroupedByCategoria() {
        Usuario usuario = getUsuarioLogado();
        List<CategoriaSoma> categoriaSoma = repository.amountGroupedByCategoria(usuario.getUsuarioId());
        return categoriaSoma;
    }

    public Despesa findById(Long id) {
        Optional<Despesa> obj = repository.findById(id);
        return obj.orElseThrow(
                () -> new EntityNotFoundException("Id not found " + id)
        );
    }

    public Despesa insert(Despesa despesa) {
        if(despesa.getPreco() <= 0) {
            throw new BadRequestException("O campo preço deve ser maior do que zero");
        }
        Usuario usuarioLogado = getUsuarioLogado();
        usuarioLogado.setSaldo(usuarioLogado.getSaldo() - despesa.getPreco());
        despesa.setUsuario(usuarioLogado);
        Despesa despesaa = repository.save(despesa);
        usuarioRepository.save(usuarioLogado);
        return despesaa;
    }

    public void delete(Long id) {
        Usuario usuarioLogado = getUsuarioLogado();
        Despesa despesa = findById(id);
        usuarioLogado.setSaldo(usuarioLogado.getSaldo() + despesa.getPreco());
        repository.deleteById(id);
        usuarioRepository.save(usuarioLogado);
    }

    public Despesa update(Long id, Despesa obj) {
        Despesa entity = repository.findById(id).get();
        if(entity.getPreco() != obj.getPreco()) {
            Double valor = entity.getPreco() - obj.getPreco();
            Usuario usuarioLogado = getUsuarioLogado();
            usuarioLogado.setSaldo(usuarioLogado.getSaldo() + valor);
        }
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Despesa entity, Despesa obj) {
        entity.setNome(obj.getNome());
        entity.setPreco(obj.getPreco());
        entity.setDescricao(obj.getDescricao());
        entity.setCategoria(obj.getCategoria());
    }

}

