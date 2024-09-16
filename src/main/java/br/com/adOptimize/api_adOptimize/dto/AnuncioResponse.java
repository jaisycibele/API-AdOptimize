package br.com.adOptimize.api_adOptimize.dto;

import br.com.adOptimize.api_adOptimize.model.Usuario;
import org.springframework.hateoas.Link;

public class AnuncioResponse {

    private Long idAnuncio;
    private String titulo;
    private String textoAnuncio;
    private String urlAnuncio;
    private String tipoAnuncio;
    private String dataCriacao;
    private Long impressoes;
    private Long qtdCliques;
    private Double custoAnuncio;
    private Usuario usuario;
    private Link link;

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Long getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Long idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

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
