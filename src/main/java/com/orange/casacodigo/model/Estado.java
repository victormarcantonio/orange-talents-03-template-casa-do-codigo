package com.orange.casacodigo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    @NotBlank
    private String nome;
    @ManyToOne
    @NotNull
    private Pais pais;

    public Estado() {
    }

    public Estado(@NotBlank String nome, @NotNull Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }

    public boolean pertenceAPais(Pais pais){
        return this.pais.equals(pais);
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pais=" + pais +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estado)) return false;

        Estado estado = (Estado) o;

        if (getId() != null ? !getId().equals(estado.getId()) : estado.getId() != null) return false;
        if (getNome() != null ? !getNome().equals(estado.getNome()) : estado.getNome() != null) return false;
        return pais != null ? pais.equals(estado.pais) : estado.pais == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNome() != null ? getNome().hashCode() : 0);
        result = 31 * result + (pais != null ? pais.hashCode() : 0);
        return result;
    }
}
