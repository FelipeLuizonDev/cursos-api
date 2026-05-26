package br.com.felipeluizon.cursosapi.repository;

import br.com.felipeluizon.cursosapi.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CursoRepository extends JpaRepository<Curso, UUID> {
    List<Curso> findByNameContainingIgnoreCase(String name);
    List<Curso> findByCategoryContainingIgnoreCase(String category);
    List<Curso> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
            String name,
            String category
    );
}
