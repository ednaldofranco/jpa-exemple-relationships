package br.com.jpa.exemple.jpaexemple.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trabalhos {
    @SequenceGenerator(sequenceName = "seq_endereco", name = "seq_endereco", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
    @Id
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "trabalhos")
    private List<Pessoa> funcionarios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pessoa> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Pessoa> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Trabalhos{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", funcionarios=" + funcionarios +
                '}';
    }
}
