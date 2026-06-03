package br.com.felipeluizon.cursosapi.service;

import br.com.felipeluizon.cursosapi.dto.CursoRequestDTO;
import br.com.felipeluizon.cursosapi.dto.CursoUpdateDTO;
import br.com.felipeluizon.cursosapi.entity.Curso;
import br.com.felipeluizon.cursosapi.exception.ResourceNotFoundException;
import br.com.felipeluizon.cursosapi.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursoService {
    private final CursoRepository cursoRepository;

    public Curso create(CursoRequestDTO cursoRequestDTO) {
        Curso curso = Curso.builder()
                .name(cursoRequestDTO.name())
                .category(cursoRequestDTO.category())
                .professor(cursoRequestDTO.professor())
                .active(true)
                .build();

        return cursoRepository.save(curso);
    }

    public List<Curso> findAll(String name, String category) {
        if (name != null && category != null) {
            return cursoRepository
                    .findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                            name,
                            category
                    );
        }

        if (name != null) {
            return cursoRepository
                    .findByNameContainingIgnoreCase(name);
        }

        if (category != null) {
            return cursoRepository
                    .findByCategoryContainingIgnoreCase(category);
        }

        return cursoRepository.findAll();
    }

    public Curso findById(UUID id) {
        return cursoRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Curso não encontrado"));
    }

    public Curso update(UUID id, CursoUpdateDTO cursoUpdateDTO) {
        Curso curso = findById(id);

        if (cursoUpdateDTO.name() != null) {
            curso.setName(cursoUpdateDTO.name());
        }

        if (cursoUpdateDTO.category() != null) {
            curso.setCategory(cursoUpdateDTO.category());
        }

        if (cursoUpdateDTO.professor() != null) {
            curso.setProfessor(cursoUpdateDTO.professor());
        }

        return cursoRepository.save(curso);
    }

    public void delete(UUID id) {
        Curso curso = findById(id);

        cursoRepository.delete(curso);
    }

    public Curso toggleActive(UUID id) {
        Curso curso = findById(id);

        curso.setActive(!curso.getActive());

        return cursoRepository.save(curso);
    }
}
