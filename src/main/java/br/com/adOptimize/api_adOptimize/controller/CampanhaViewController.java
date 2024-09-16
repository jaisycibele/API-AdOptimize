package br.com.adOptimize.api_adOptimize.controller;

import br.com.adOptimize.api_adOptimize.dto.CampanhaRequest;
import br.com.adOptimize.api_adOptimize.dto.CampanhaResponse;
import br.com.adOptimize.api_adOptimize.model.Campanha;
import br.com.adOptimize.api_adOptimize.repository.CampanhaRepository;
import br.com.adOptimize.api_adOptimize.service.CampanhaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CampanhaViewController {

    @Autowired
    private CampanhaService campanhaService;
    @Autowired
    private CampanhaRepository campanhaRepository;

    @GetMapping("/listaCampanhas")
    public ModelAndView listaCampanhas() {
        List<Campanha> listaCampanhas = campanhaRepository.findAll();
        List<CampanhaResponse> listaCampanhasResponse = new ArrayList<>();
        for (Campanha campanha : listaCampanhas) {
            listaCampanhasResponse.add(campanhaService.campanhaToResponse(campanha));
        }
        ModelAndView mv = new ModelAndView("campanhas");
        mv.addObject("listaCampanhas", listaCampanhasResponse);
        return mv;
    }

    @GetMapping("/campanha/template")
    public String template() {
        return "templateVazio";
    }

    @GetMapping("/listaCampanhasTemplate")
    public ModelAndView listaCampanhasTemplate() {
        List<Campanha> listaCampanhas = campanhaRepository.findAll();
        List<CampanhaResponse> listaCampanhasResponse = new ArrayList<>();
        for (Campanha campanha : listaCampanhas) {
            listaCampanhasResponse.add(campanhaService.campanhaToResponse(campanha));
        }
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "campanhas");
        mv.addObject("content", "listaCampanhas");
        mv.addObject("listaCampanhas", listaCampanhasResponse);
        return mv;
    }

    @GetMapping("/cadastroCampanha")
    public ModelAndView cadastroCampanha() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "campanhaCadastro");
        mv.addObject("campanhaRequest", "formCadastro");
        mv.addObject("campanhaRequest", new CampanhaRequest());
        return mv;
    }

    @RequestMapping(value = "cadastrarCampanha", method = RequestMethod.POST)
    public ModelAndView cadastrarCampanha(@ModelAttribute CampanhaRequest campanhaRequest) {
        Campanha campanha = campanhaService.requestToCampanha(campanhaRequest);
        campanhaRepository.save(campanha);
        return listaCampanhasTemplate();
    }

    @GetMapping("/editaCampanha/{idCampanha}")
    public ModelAndView editaCampanha(@PathVariable Long idCampanha) {
        Optional<Campanha> campanha = campanhaRepository.findById(idCampanha);
        if(campanha.isEmpty()){
            return listaCampanhasTemplate();
        }
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "campanhaEdicao");
        mv.addObject("content", "formEdicao");
        mv.addObject("campanhaRequest", campanhaService.campanhaToRequest(campanha.get()));
        mv.addObject("idCampanha", idCampanha);
        return mv;
    }

    @PostMapping("/atualizarCampanha/{idCampanha}")
    public ModelAndView atualizarCampanha(@PathVariable Long idCampanha,
                                         @Valid @ModelAttribute CampanhaRequest campanhaRequest){
        if(campanhaRepository.findById(idCampanha).isEmpty()){
            //adicionar informação de erro
            return listaCampanhasTemplate();
        }
        Campanha campanha = campanhaService.requestToCampanha(campanhaRequest);
        campanha.setIdCampanha(idCampanha);
        campanhaRepository.save(campanha);
        return listaCampanhasTemplate();
    }

    @GetMapping("/deletarCampanha/{idCampanha}")
    public ModelAndView deletarCampanha(@PathVariable Long idCampanha){
        Optional<Campanha> campanha = campanhaRepository.findById(idCampanha);
        if(campanha.isEmpty()){
            //tratar exceção
            return listaCampanhasTemplate();
        }
        campanhaRepository.delete(campanha.get());
        return listaCampanhasTemplate();
    }








}
