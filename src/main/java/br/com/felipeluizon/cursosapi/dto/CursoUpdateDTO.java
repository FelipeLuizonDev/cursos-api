package br.com.felipeluizon.cursosapi.dto;

public record CursoUpdateDTO(
        String name,
        String category,
        String professor
) {
}
