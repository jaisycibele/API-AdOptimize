package br.com.adOptimize.api_adOptimize.repository;

import br.com.adOptimize.api_adOptimize.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}