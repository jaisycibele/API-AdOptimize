package br.com.adOptimize.api_adOptimize.controller;

import br.com.adOptimize.api_adOptimize.dto.AnuncioRequest;
import br.com.adOptimize.api_adOptimize.dto.AnuncioResponse;
import br.com.adOptimize.api_adOptimize.model.Anuncio;
import br.com.adOptimize.api_adOptimize.repository.AnuncioRepository;
import br.com.adOptimize.api_adOptimize.service.AnuncioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AnuncioViewController {

    @Autowired
    private AnuncioService anuncioService;
    @Autowired
    private AnuncioRepository anuncioRepository;

    @GetMapping("/listaAnuncios")
    public ModelAndView listaAnuncios() {
        List<Anuncio> listaAnuncios = anuncioRepository.findAll();
        List<AnuncioResponse> listaAnunciosResponse = new ArrayList<>();
        for (Anuncio anuncio : listaAnuncios) {
            listaAnunciosResponse.add(anuncioService.anuncioToResponse(anuncio));
        }
        ModelAndView mv = new ModelAndView("anuncios");
        mv.addObject("listaAnuncios", listaAnunciosResponse);
        return mv;
    }

    @GetMapping("/anuncio/template")
    public String template() {
        return "templateVazio";
    }

    @GetMapping("/listaAnunciosTemplate")
    public ModelAndView listaAnunciosTemplate() {
        List<Anuncio> listaAnuncios = anuncioRepository.findAll();
        List<AnuncioResponse> listaAnunciosResponse = new ArrayList<>();
        for (Anuncio anuncio : listaAnuncios) {
            listaAnunciosResponse.add(anuncioService.anuncioToResponse(anuncio));
        }
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "anuncios");
        mv.addObject("content", "listaAnuncios");
        mv.addObject("listaAnuncios", listaAnunciosResponse);
        return mv;
    }

    @GetMapping("/cadastroAnuncio")
    public ModelAndView cadastroAnuncio() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "anuncioCadastro");
        mv.addObject("anuncioRequest", "formCadastro");
        mv.addObject("anuncioRequest", new AnuncioRequest());
        return mv;
    }

    @RequestMapping(value = "cadastrarAnuncio", method = RequestMethod.POST)
    public ModelAndView cadastrarAnuncio(@ModelAttribute AnuncioRequest anuncioRequest) {
        Anuncio anuncio = anuncioService.requestToAnuncio(anuncioRequest);
        anuncioRepository.save(anuncio);
        return listaAnunciosTemplate();
    }

    @GetMapping("/editaAnuncio/{idAnuncio}")
    public ModelAndView editaAnuncio(@PathVariable Long idAnuncio) {
        Optional<Anuncio> anuncio = anuncioRepository.findById(idAnuncio);
        if(anuncio.isEmpty()){
            return listaAnunciosTemplate();
        }
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "anuncioEdicao");
        mv.addObject("content", "formEdicao");
        mv.addObject("anuncioRequest", anuncioService.anuncioToRequest(anuncio.get()));
        mv.addObject("idAnuncio", idAnuncio);
        return mv;
    }

    @PostMapping("/atualizarAnuncio/{idAnuncio}")
    public ModelAndView atualizarAnuncio(@PathVariable Long idAnuncio,
                                       @Valid @ModelAttribute AnuncioRequest anuncioRequest){
        if(anuncioRepository.findById(idAnuncio).isEmpty()){
            //adicionar informação de erro
            return listaAnunciosTemplate();
        }
        Anuncio anuncio = anuncioService.requestToAnuncio(anuncioRequest);
        anuncio.setIdAnuncio(idAnuncio);
        anuncioRepository.save(anuncio);
        return listaAnunciosTemplate();
    }

    @GetMapping("/deletarAnuncio/{idAnuncio}")
    public ModelAndView deletarAnuncio(@PathVariable Long idAnuncio){
        Optional<Anuncio> anuncio = anuncioRepository.findById(idAnuncio);
        if(anuncio.isEmpty()){
            //tratar exceção
            return listaAnunciosTemplate();
        }
        anuncioRepository.delete(anuncio.get());
        return listaAnunciosTemplate();
    }








    }
