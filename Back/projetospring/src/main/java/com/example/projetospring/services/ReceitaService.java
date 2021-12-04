package com.example.projetospring.services;

import com.example.projetospring.model.CategoriaReceita;
import com.example.projetospring.model.CategoriaSoma;
import com.example.projetospring.model.Receitas;
import com.example.projetospring.model.Usuario;
import com.example.projetospring.repositories.CategoriaReceitaRepository;
import com.example.projetospring.repositories.ReceitaRepository;
import com.example.projetospring.repositories.UsuarioRepository;
import com.example.projetospring.services.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository rRep;

    @Autowired
    private CategoriaReceitaRepository categoriaRepository;

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

    public List<Receitas> listReceitas (){
        categoriaRepository.findAll();
        Usuario usuario = getUsuarioLogado();
        List<Receitas> receitas = rRep.receitasByUsuario((usuario.getUsuarioId()));
        return receitas;
    }

    public List<Receitas> findReceitasByMonth(int month, int year) {
        categoriaRepository.findAll();
        Usuario usuario = getUsuarioLogado();
        List<Receitas> receitas = rRep.receitasByMonth(usuario.getUsuarioId(), month, year);
        return receitas;
    }

    @Transactional(readOnly = true)
    public List<CategoriaSoma> amountGroupedByCategoria() {
        Usuario usuario = getUsuarioLogado();
        List<CategoriaSoma> categoriaSoma = rRep.amountGroupedByCategoria(usuario.getUsuarioId());
        return categoriaSoma;
    }

    public Receitas findReceitaById(Long id){
        Optional<Receitas> obj = rRep.findById(id);
        return obj.get();
    }

    public Receitas cadastroReceita (Receitas receita){
        if(receita.getPreco() <= 0) {
            throw new BadRequestException("O campo preço deve ser maior do que zero");
        }
        Usuario usuarioLogado = getUsuarioLogado();
        receita.setUsuario(usuarioLogado);
        Receitas receitaa = rRep.save(receita);
        return receitaa;
    }

    public void deleteReceita (Long id){
        rRep.deleteById(id);
    }

    public Receitas alterarReceita (Long id, Receitas receita){
        Receitas entity = rRep.getOne(id);
        updateData(entity, receita);
        return rRep.save(entity);
    }

    public void updateData (Receitas entity, Receitas obj){
        entity.setNome(obj.getNome());
        entity.setDescricao(obj.getDescricao());
        entity.setPreco(obj.getPreco());
    }
}

