package br.com.jpa.exemple.jpaexemple.repository;

import br.com.jpa.exemple.jpaexemple.model.Pessoa;
import br.com.jpa.exemple.jpaexemple.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
