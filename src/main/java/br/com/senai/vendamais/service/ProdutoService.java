package br.com.senai.vendamais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.vendamais.entity.Produto;
import br.com.senai.vendamais.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public Produto insertNew(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto update(Long id, Produto produtoAlterado){
        Produto produtoAtual = findById(id);
        produtoAtual.setNome(produtoAlterado.getNome());
        produtoAtual.setTelefone(produtoAlterado.getTelefone());
        return produtoRepository.save(produtoAtual);
    }

}
