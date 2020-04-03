package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProdutoController {
    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping("/produtos")
    public List<Produto> show(){
        return produtosRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    public Produto index(@PathVariable(value="id") long id){
        return produtosRepository.findById(id);
    }
    @PostMapping("/produto")
    public Produto create(@RequestBody Produto produto){
        return produtosRepository.save(produto);
    }

}
