package br.com.jpa.exemple.jpaexemple.repository;

import br.com.jpa.exemple.jpaexemple.model.Pessoa;
import br.com.jpa.exemple.jpaexemple.model.Trabalhos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabalhoRepository extends JpaRepository<Trabalhos, Long> {
}
