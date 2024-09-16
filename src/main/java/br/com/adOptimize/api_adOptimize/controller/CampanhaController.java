package br.com.adOptimize.api_adOptimize.controller;

import br.com.adOptimize.api_adOptimize.dto.CampanhaRequest;
import br.com.adOptimize.api_adOptimize.dto.CampanhaResponse;
import br.com.adOptimize.api_adOptimize.model.Campanha;
import br.com.adOptimize.api_adOptimize.repository.CampanhaRepository;
import br.com.adOptimize.api_adOptimize.service.CampanhaService;
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
@RequestMapping(value = "campanha")
public class CampanhaController {

    @Autowired
    private CampanhaRepository campanhaRepository;
    @Autowired
    private CampanhaService campanhaService;

    // Verbos HTTP
    // POST, GET, PUT, DELETE
    // CRUD
    // CREAT, READ, UPDATE, DELETE

    //CRUD

    @PostMapping
    public ResponseEntity<CampanhaResponse> create(@Valid @RequestBody CampanhaRequest campanhaRequest) {
        Campanha campanhaConvertido = campanhaService.requestToCampanha(campanhaRequest);
        Campanha campanhaPersistido = campanhaRepository.save(campanhaConvertido);
        CampanhaResponse campanhaResponse = campanhaService.campanhaToResponse(campanhaPersistido);
        return new ResponseEntity<>(campanhaResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CampanhaResponse>> read() {
        List<Campanha> listaCampanhas = campanhaRepository.findAll();
        if (listaCampanhas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        List<CampanhaResponse> listaCampanhasResponse = new ArrayList<>();
        for (Campanha campanha : listaCampanhas) {
            CampanhaResponse campanhaResponse = campanhaService.campanhaToResponse(campanha);
            campanhaResponse.setLink(
                    linkTo(
                            methodOn(CampanhaController.class)
                                    .read()).withSelfRel());
            listaCampanhasResponse.add(campanhaResponse);
        }
        return new ResponseEntity<>(listaCampanhasResponse, HttpStatus.OK);
    }

    @GetMapping("/{idCampanha}")
    public ResponseEntity<CampanhaResponse> read(@PathVariable long idCampanha) {
        Optional<Campanha> campanha = campanhaRepository.findById(idCampanha);
        if (campanha.isPresent()) {
            CampanhaResponse campanhaResponse = campanhaService.campanhaToResponse(campanha.get());
            campanhaResponse.setLink(
                    linkTo(
                            methodOn(CampanhaController.class)
                                    .read()).withRel("Lista de campanhas"));
            return new ResponseEntity<>(campanhaResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{idCampanha}")
    public ResponseEntity<CampanhaResponse> update(@PathVariable Long idCampanha, @Valid @RequestBody CampanhaRequest campanhaRequest) {
        Optional<Campanha> campanhaPersistido = campanhaRepository.findById(idCampanha);
        if (campanhaPersistido.isPresent()) {
            Campanha campanha = campanhaService.requestToCampanha(campanhaRequest);
            campanha.setIdCampanha(idCampanha);
            Campanha campanhaAtualizado = campanhaRepository.save(campanha);
            CampanhaResponse campanhaResponse = campanhaService.campanhaToResponse(campanhaAtualizado);
            return new ResponseEntity<>(campanhaResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idCampanha}")
    public ResponseEntity<Void> delete(@PathVariable Long idCampanha) {
        Optional<Campanha> campanha = campanhaRepository.findById(idCampanha);
        if (campanha.isPresent()) {
            campanhaRepository.delete(campanha.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

































































































}
