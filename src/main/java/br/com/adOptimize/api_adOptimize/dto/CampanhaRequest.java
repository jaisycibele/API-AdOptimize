package br.com.adOptimize.api_adOptimize.dto;

import br.com.adOptimize.api_adOptimize.model.Anuncio;
import jakarta.persistence.*;

public class CampanhaRequest {

    @Column(name="nome_campanha")
    private String nomeCampanha;

    @Column(name="orcamento")
    private String orcamento;

    @Column(name="data_inicio")
    private String dataInicio;

    @Column(name="data_termino")
    private String dataTermino;

    @Column(name="status")
    private String status;

    @Column(name="tipo_campanha")
    private String tipoCampanha;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_ANUNCIO",
            referencedColumnName = "idAnuncio",
            foreignKey = @ForeignKey(name = "FK_CAMPANHA_ANUNCIO")
    )
    private Anuncio anuncio;
    private Anuncio idAnuncio;

    public String getNomeCampanha() {
        return nomeCampanha;
    }

    public void setNomeCampanha(String nomeCampanha) {
        this.nomeCampanha = nomeCampanha;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoCampanha() {
        return tipoCampanha;
    }

    public void setTipoCampanha(String tipoCampanha) {
        this.tipoCampanha = tipoCampanha;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

}

