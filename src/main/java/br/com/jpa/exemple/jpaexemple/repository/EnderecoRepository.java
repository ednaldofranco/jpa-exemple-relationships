package br.com.jpa.exemple.jpaexemple.repository;

import br.com.jpa.exemple.jpaexemple.model.Endereco;
import br.com.jpa.exemple.jpaexemple.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
