package br.com.adOptimize.api_adOptimize.repository;


import br.com.adOptimize.api_adOptimize.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}