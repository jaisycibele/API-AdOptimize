package br.com.adOptimize.api_adOptimize.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "email")
    private String email;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "senha")
    private String senha;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "ds_chave_googleads")
    private String chaveGoogleAds;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getChaveGoogleAds() {
        return chaveGoogleAds;
    }

    public void setChaveGoogleAds(String chaveGoogleAds) {
        this.chaveGoogleAds = chaveGoogleAds;
    }
}
