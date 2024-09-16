package br.com.adOptimize.api_adOptimize.service;

import br.com.adOptimize.api_adOptimize.dto.UsuarioRequest;
import br.com.adOptimize.api_adOptimize.dto.UsuarioResponse;
import br.com.adOptimize.api_adOptimize.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    //Metodos Mapper

    public Usuario requestToUsuario(UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(usuarioRequest.getSenha());
        usuario.setChaveGoogleAds(usuarioRequest.getChaveGoogleAds());
        return usuario;
    }

    public UsuarioResponse usuarioToResponse(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setIdUsuario(usuario.getIdUsuario());
        usuarioResponse.setNome(usuario.getNome());
        usuarioResponse.setEmail(usuario.getEmail());
        usuarioResponse.setSenha(usuario.getSenha());
        usuarioResponse.setChaveGoogleAds(usuario.getChaveGoogleAds());
        return usuarioResponse;
    }

    public UsuarioRequest usuarioToRequest(Usuario usuario){
        UsuarioRequest usuarioRequest = new UsuarioRequest();
        usuarioRequest.setNome(usuario.getNome());
        usuarioRequest.setEmail(usuario.getEmail());
        usuarioRequest.setSenha(usuario.getSenha());
        usuarioRequest.setSenha(usuario.getChaveGoogleAds());
        return usuarioRequest;
    }
}
