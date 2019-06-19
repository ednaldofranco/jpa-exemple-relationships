package br.com.jpa.exemple.jpaexemple.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pessoa {
    @SequenceGenerator(sequenceName = "seq_pessoa", name = "seq_pessoa", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pessoa")
    @Id
    private Long id;

    private String nome;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "pessoa")
    private List<Telefone> telefones;

    @ManyToMany
    @JoinTable(name = "trabalhos_pessoas",
        joinColumns={@JoinColumn(name = "id_pessoa")},
        inverseJoinColumns = {@JoinColumn(name="id_trabalhos")}
    )
    private List<Trabalhos> trabalhos;

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


    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Trabalhos> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<Trabalhos> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
        if (this.endereco != null) {
            this.endereco.setPessoa(this);
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void addTelefone(Telefone telefone) {
        if (this.telefones == null) {
            this.telefones = new ArrayList<>();
        }
        this.telefones.add(telefone);
    }

    public void addTrabalho(Trabalhos trabalho) {
        if (this.trabalhos == null) {
            this.trabalhos = new ArrayList<>();
        }
        this.trabalhos.add(trabalho);
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                ", telefones=" + telefones +
                '}';
    }
}
