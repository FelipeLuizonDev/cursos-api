package br.com.felipeluizon.cursosapi.controller;

import br.com.felipeluizon.cursosapi.CursosApiApplication;
import br.com.felipeluizon.cursosapi.dto.CursoRequestDTO;
import br.com.felipeluizon.cursosapi.entity.Curso;
import br.com.felipeluizon.cursosapi.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@RequiredArgsConstructor
public class CursoController {
    private final CursoService cursoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso create(@RequestBody @Valid CursoRequestDTO cursoRequestDTO) {
        return cursoService.create(cursoRequestDTO);
    }

    @GetMapping
    public List<Curso> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category
    ) {
        return cursoService.findAll(name, category);
    }
}
