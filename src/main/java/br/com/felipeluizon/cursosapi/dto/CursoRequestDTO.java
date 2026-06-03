package br.com.felipeluizon.cursosapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(
   @NotBlank(message = "Nome é obrigatório")
   String name,

   @NotBlank(message = "Categoria é obrigatória")
   String category,

   @NotBlank(message = "Professor é obrigatório")
   String professor
) {
}
