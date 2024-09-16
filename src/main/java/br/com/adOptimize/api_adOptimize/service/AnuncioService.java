package br.com.adOptimize.api_adOptimize.service;

import br.com.adOptimize.api_adOptimize.dto.AnuncioRequest;
import br.com.adOptimize.api_adOptimize.dto.AnuncioResponse;
import br.com.adOptimize.api_adOptimize.model.Anuncio;
import org.springframework.stereotype.Service;

@Service
public class AnuncioService {

    public Anuncio requestToAnuncio(AnuncioRequest anuncioRequest ) {
        Anuncio anuncio = new Anuncio();
        anuncio.setTitulo(anuncioRequest.getTitulo());
        anuncio.setTextoAnuncio(anuncioRequest.getTextoAnuncio());
        anuncio.setUrlAnuncio(anuncioRequest.getUrlAnuncio());
        anuncio.setTipoAnuncio(anuncioRequest.getTipoAnuncio());
        anuncio.setDataCriacao(anuncioRequest.getDataCriacao());
        anuncio.setImpressoes(anuncioRequest.getImpressoes());
        anuncio.setQtdCliques(anuncioRequest.getQtdCliques());
        anuncio.setCustoAnuncio(anuncioRequest.getCustoAnuncio());
        anuncio.setUsuario(anuncioRequest.getUsuario());
        return anuncio;
    }

    public AnuncioResponse anuncioToResponse(Anuncio anuncio) {
        AnuncioResponse anuncioResponse = new AnuncioResponse();
        anuncioResponse.setIdAnuncio(anuncio.getIdAnuncio());
        anuncioResponse.setTitulo(anuncio.getTitulo());
        anuncioResponse.setTextoAnuncio(anuncio.getTextoAnuncio());
        anuncioResponse.setUrlAnuncio(anuncio.getUrlAnuncio());
        anuncioResponse.setTipoAnuncio(anuncio.getTipoAnuncio());
        anuncioResponse.setDataCriacao(anuncio.getDataCriacao());
        anuncioResponse.setImpressoes(anuncio.getImpressoes());
        anuncioResponse.setQtdCliques(anuncio.getQtdCliques());
        anuncioResponse.setCustoAnuncio(anuncio.getCustoAnuncio());
        anuncioResponse.setUsuario(anuncio.getUsuario());
        return anuncioResponse;
    }

    public AnuncioRequest anuncioToRequest(Anuncio anuncio){
        AnuncioRequest anuncioRequest = new AnuncioRequest();
        anuncioRequest.setTitulo(anuncio.getTitulo());
        anuncioRequest.setTextoAnuncio(anuncio.getTextoAnuncio());
        anuncioRequest.setUrlAnuncio(anuncio.getUrlAnuncio());
        anuncioRequest.setTipoAnuncio(anuncio.getTipoAnuncio());
        anuncioRequest.setDataCriacao(anuncio.getDataCriacao());
        anuncioRequest.setImpressoes(anuncio.getImpressoes());
        anuncioRequest.setQtdCliques(anuncio.getQtdCliques());
        anuncioRequest.setCustoAnuncio(anuncio.getCustoAnuncio());
        anuncioRequest.setUsuario(anuncio.getUsuario());
        return anuncioRequest;
    }
}

