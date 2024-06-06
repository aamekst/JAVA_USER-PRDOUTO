package com.users.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoControl {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity prod (@RequestBody ProdutoDto produtoDto){
        Produto prod = new Produto();
        prod.setNome(produtoDto.getNome());
        prod.setPreco(produtoDto.getPreco());
        Produto produtoCreated = produtoRepository.save(prod);
        return ResponseEntity.ok().body(produtoCreated);
    }

    @GetMapping("/listarProduto")
    public List<Produto> produtoList() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto buscarId(@PathVariable Integer id) {
        var produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return produtoOptional.get();
    }


    @GetMapping("/usuario_produtos/{id}")
    public List<Produto> listarProdutosPorUsuario(@PathVariable Integer id) {
        var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        User user = userOptional.get();
        return user.getProdutos();
    }
}





