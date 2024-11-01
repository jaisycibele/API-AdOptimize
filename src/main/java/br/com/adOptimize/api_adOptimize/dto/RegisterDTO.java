package br.com.adOptimize.api_adOptimize.dto;

import br.com.adOptimize.api_adOptimize.model.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {}
