package br.com.jpa.exemple.jpaexemple.model;

import javax.persistence.*;

@Entity
public class Telefone {
    @SequenceGenerator(sequenceName = "seq_telefone", name = "seq_telefone", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_telefone")
    @Id
    private Long id;

    private String numero;

    private String ddd;

    private EnumTipo tipo;

    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    @Enumerated(EnumType.STRING)
    public EnumTipo getTipo() {
        return tipo;
    }

    public void setTipo(EnumTipo tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", ddd='" + ddd + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
