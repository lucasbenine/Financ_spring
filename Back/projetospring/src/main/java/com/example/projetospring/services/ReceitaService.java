package com.example.projetospring.services;

import com.example.projetospring.model.*;
import com.example.projetospring.repositories.CategoriaReceitaRepository;
import com.example.projetospring.repositories.ReceitaRepository;
import com.example.projetospring.repositories.UsuarioRepository;
import com.example.projetospring.services.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
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

    public Double soma() {
        Usuario usuario = getUsuarioLogado();
        return rRep.soma(usuario.getUsuarioId());
    }

    public Double somaMensal() {
        Usuario usuario = getUsuarioLogado();
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        return rRep.somaMensal(usuario.getUsuarioId(), month, year);
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
        usuarioLogado.setSaldo(usuarioLogado.getSaldo() + receita.getPreco());
        receita.setUsuario(usuarioLogado);
        Receitas receitaa = rRep.save(receita);
        usuarioRepository.save(usuarioLogado);
        return receitaa;
    }

    public void deleteReceita (Long id){
        Usuario usuarioLogado = getUsuarioLogado();
        Receitas receita = findReceitaById(id);
        usuarioLogado.setSaldo(usuarioLogado.getSaldo() - receita.getPreco());
        rRep.deleteById(id);
        usuarioRepository.save(usuarioLogado);
    }

    public Receitas alterarReceita (Long id, Receitas receita){
        Receitas entity = rRep.getOne(id);
        if(entity.getPreco() != receita.getPreco()) {
            Double valor = entity.getPreco() - receita.getPreco();
            Usuario usuarioLogado = getUsuarioLogado();
            usuarioLogado.setSaldo(usuarioLogado.getSaldo() - valor);
        }
        updateData(entity, receita);
        return rRep.save(entity);
    }

    public void updateData (Receitas entity, Receitas obj){
        entity.setNome(obj.getNome());
        entity.setPreco(obj.getPreco());
        entity.setDescricao(obj.getDescricao());
        entity.setCategoria(obj.getCategoria());
    }
}

