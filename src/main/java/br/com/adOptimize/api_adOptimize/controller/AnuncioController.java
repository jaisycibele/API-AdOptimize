package br.com.adOptimize.api_adOptimize.controller;


import br.com.adOptimize.api_adOptimize.dto.AnuncioRequest;
import br.com.adOptimize.api_adOptimize.dto.AnuncioResponse;
import br.com.adOptimize.api_adOptimize.model.Anuncio;
import br.com.adOptimize.api_adOptimize.repository.AnuncioRepository;
import br.com.adOptimize.api_adOptimize.service.AnuncioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "anuncio")
public class AnuncioController {

    @Autowired
    private AnuncioRepository anuncioRepository;
    @Autowired
    private AnuncioService anuncioService;

    // Verbos HTTP
    // POST, GET, PUT, DELETE
    // CRUD
    // CREAT, READ, UPDATE, DELETE

    //CRUD

    @PostMapping
    public ResponseEntity<AnuncioResponse> create(@Valid @RequestBody AnuncioRequest anuncioRequest) {
        Anuncio anuncioConvertido = anuncioService.requestToAnuncio(anuncioRequest);
        Anuncio anuncioPersistido = anuncioRepository.save(anuncioConvertido);
        AnuncioResponse anuncioResponse = anuncioService.anuncioToResponse(anuncioPersistido);
        return new ResponseEntity<>(anuncioResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AnuncioResponse>> read() {
        List<Anuncio> listaAnuncios = anuncioRepository.findAll();
        if (listaAnuncios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<AnuncioResponse> listaAnunciosResponse = new ArrayList<>();
        for (Anuncio anuncio : listaAnuncios) {
            AnuncioResponse anuncioResponse = anuncioService.anuncioToResponse(anuncio);
            anuncioResponse.setLink(
                    linkTo(
                            methodOn(AnuncioController.class)
                                    .read()).withSelfRel());
            listaAnunciosResponse.add(anuncioResponse);
        }
        return new ResponseEntity<>(listaAnunciosResponse, HttpStatus.OK);
    }

    @GetMapping("/{idAnuncio}")
    public ResponseEntity<AnuncioResponse> read(@PathVariable long idAnuncio) {
        Optional<Anuncio> anuncio = anuncioRepository.findById(idAnuncio);
        if (anuncio.isPresent()) {
            AnuncioResponse anuncioResponse = anuncioService.anuncioToResponse(anuncio.get());
            anuncioResponse.setLink(
                    linkTo(
                            methodOn(AnuncioController.class)
                                    .read()).withRel("Lista de anuncios"));
            return new ResponseEntity<>(anuncioResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{idAnuncio}")
    public ResponseEntity<AnuncioResponse> update(@PathVariable Long idAnuncio, @Valid @RequestBody AnuncioRequest anuncioRequest) {
        Optional<Anuncio> anuncioPersistido = anuncioRepository.findById(idAnuncio);
        if (anuncioPersistido.isPresent()) {
            Anuncio anuncio = anuncioService.requestToAnuncio(anuncioRequest);
            anuncio.setIdAnuncio(idAnuncio);
            Anuncio anuncioAtualizado = anuncioRepository.save(anuncio);
            AnuncioResponse anuncioResponse = anuncioService.anuncioToResponse(anuncioAtualizado);
            return new ResponseEntity<>(anuncioResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idAnuncio}")
    public ResponseEntity<Void> delete(@PathVariable Long idAnuncio) {
    Optional<Anuncio> anuncio = anuncioRepository.findById(idAnuncio);
    if (anuncio.isPresent()) {
        anuncioRepository.delete(anuncio.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }




}




