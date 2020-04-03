package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutosRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
    @Autowired
    ProdutosRepository produtosRepository;

    @GetMapping("/produtos")
    @ApiOperation(value="Retorna uma lista de produtos")
    public List<Produto> show(){
        return produtosRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value="Retorna um produto pelo seu Id")
    public Produto index(@PathVariable(value="id") long id){
        return produtosRepository.findById(id);
    }

    @PostMapping("/produto")
    @ApiOperation(value="Cria um produto")
    public Produto create(@RequestBody Produto produto){
        return produtosRepository.save(produto);
    }

    @DeleteMapping("/produto/{id}")
    @ApiOperation(value="Deleta um produto pelo seu ID")
    public void delete(@PathVariable(value="id") long id){
        produtosRepository.deleteById(id);
    }

    @PutMapping("/produto/{id}")
    @ApiOperation(value="Atualiza um produto")
    public Produto update(@PathVariable(value="id") long id, @RequestBody Produto produto){
        produto.setId(id);
        return produtosRepository.save(produto);
    }

}
