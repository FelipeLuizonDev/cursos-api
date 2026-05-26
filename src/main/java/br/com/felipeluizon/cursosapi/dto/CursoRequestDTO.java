package br.com.felipeluizon.cursosapi.dto;

import jakarta.validation.constraints.NotBlank;

public record CursoRequestDTO(
   @NotBlank(message = "O nome do curso é obrigatório")
   String name,

   @NotBlank(message = "A categoria do curso é obrigatória")
   String category
) {
}
