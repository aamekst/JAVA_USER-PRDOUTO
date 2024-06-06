package com.users.produtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {
    private String nome;
    private String cnpj;
    private List<ProdutoDto> produtos;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDto> produtos) {this.produtos = produtos;
    }
}
