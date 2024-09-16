package br.com.adOptimize.api_adOptimize.dto;

import br.com.adOptimize.api_adOptimize.model.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class AnuncioRequest {

    @NotBlank
    @Size(min = 2, max = 255)
    private String titulo;
    @NotBlank
    @Size(min = 2, max = 255)
    private String textoAnuncio;
    @NotBlank
    @Size(min = 2, max = 255)
    private String urlAnuncio;
    @NotBlank
    @Size(min = 2, max = 255)
    private String tipoAnuncio;
    @NotBlank
    @Size(min = 2, max = 255)
    private String dataCriacao;
    @Positive
    @NotNull
    private Long impressoes;
    @Positive
    @NotNull
    private Long qtdCliques;
    @Positive
    @NotNull
    private Double custoAnuncio;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_USUARIO",
            referencedColumnName = "idUsuario",
            foreignKey = @ForeignKey(name = "FK_ANUNCIO_USUARIO")
    )
    private Usuario usuario;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTextoAnuncio() {
        return textoAnuncio;
    }

    public void setTextoAnuncio(String textoAnuncio) {
        this.textoAnuncio = textoAnuncio;
    }

    public String getUrlAnuncio() {
        return urlAnuncio;
    }

    public void setUrlAnuncio(String urlAnuncio) {
        this.urlAnuncio = urlAnuncio;
    }

    public String getTipoAnuncio() {
        return tipoAnuncio;
    }

    public void setTipoAnuncio(String tipoAnuncio) {
        this.tipoAnuncio = tipoAnuncio;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getImpressoes() {
        return impressoes;
    }

    public void setImpressoes(Long impressoes) {
        this.impressoes = impressoes;
    }

    public Long getQtdCliques() {
        return qtdCliques;
    }

    public void setQtdCliques(Long qtdCliques) {
        this.qtdCliques = qtdCliques;
    }

    public Double getCustoAnuncio() {
        return custoAnuncio;
    }

    public void setCustoAnuncio(Double custoAnuncio) {
        this.custoAnuncio = custoAnuncio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}

