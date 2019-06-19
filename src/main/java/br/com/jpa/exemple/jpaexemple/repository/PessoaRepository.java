package br.com.jpa.exemple.jpaexemple.repository;

import br.com.jpa.exemple.jpaexemple.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
