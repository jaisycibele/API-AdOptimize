package br.com.adOptimize.api_adOptimize.service;

import br.com.adOptimize.api_adOptimize.dto.CampanhaRequest;
import br.com.adOptimize.api_adOptimize.dto.CampanhaResponse;
import br.com.adOptimize.api_adOptimize.model.Campanha;
import org.springframework.stereotype.Service;

@Service
public class CampanhaService {

    public Campanha requestToCampanha(CampanhaRequest campanhaRequest) {
        Campanha campanha = new Campanha();
        campanha.setNomeCampanha(campanhaRequest.getNomeCampanha());
        campanha.setOrcamento(campanhaRequest.getOrcamento());
        campanha.setDataInicio(campanhaRequest.getDataInicio());
        campanha.setDataTermino(campanhaRequest.getDataTermino());
        campanha.setStatus(campanhaRequest.getStatus());
        campanha.setTipoCampanha(campanhaRequest.getTipoCampanha());
        campanha.setAnuncio(campanhaRequest.getAnuncio());
        return campanha;
    }

    public CampanhaResponse campanhaToResponse(Campanha campanha) {
        CampanhaResponse campanhaResponse = new CampanhaResponse();
        campanhaResponse.setIdCampanha(campanha.getIdCampanha());
        campanhaResponse.setNomeCampanha(campanha.getNomeCampanha());
        campanhaResponse.setOrcamento(campanha.getOrcamento());
        campanhaResponse.setDataInicio(campanha.getDataInicio());
        campanhaResponse.setDataTermino(campanha.getDataTermino());
        campanhaResponse.setStatus(campanha.getStatus());
        campanhaResponse.setTipoCampanha(campanha.getTipoCampanha());
        campanhaResponse.setAnuncio(campanha.getAnuncio());
        return campanhaResponse;
    }

    public CampanhaRequest campanhaToRequest(Campanha campanha){
        CampanhaRequest campanhaRequest = new CampanhaRequest();
        campanhaRequest.setNomeCampanha(campanha.getNomeCampanha());
        campanhaRequest.setOrcamento(campanha.getOrcamento());
        campanhaRequest.setDataInicio(campanha.getDataInicio());
        campanhaRequest.setDataTermino(campanha.getDataTermino());
        campanhaRequest.setStatus(campanha.getStatus());
        campanhaRequest.setTipoCampanha(campanha.getTipoCampanha());
        campanhaRequest.setAnuncio(campanha.getAnuncio());
        return campanhaRequest;
    }
}
