package br.com.adOptimize.api_adOptimize.repository;

import br.com.adOptimize.api_adOptimize.model.Campanha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}