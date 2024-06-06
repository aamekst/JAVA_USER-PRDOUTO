package com.users.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserControl {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping("/user")
    public ResponseEntity user (@RequestBody UserDto userDto){
        User user = new User();
        user.setNome(userDto.getNome());
        user.setCnpj(userDto.getCnpj());
        User newUser = userRepository.save(user);


        List<Produto> produtos = userDto.getProdutos().stream().map(dto -> {
            Produto produto = new Produto();
            produto.setNome(dto.getNome());
            produto.setPreco((dto.getPreco()));
            produto.setUsers(newUser);
            return produto;
        }).collect(Collectors.toList());

        produtoRepository.saveAll(produtos);

        newUser.setProdutos(produtos);

        return ResponseEntity.status(HttpStatus.OK).body(newUser);

    }
    @GetMapping("/Userlistar")
    public List<User> userList() {
        return userRepository.findAll();
    }


}
