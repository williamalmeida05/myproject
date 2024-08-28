package br.com.will.domain;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.Objects;

public class Pessoa {
    public Long id;
    public String nome;
    public String condiçãoSaude;

    public Pessoa(String id, String nome, String condiçãoSaude) {
        this.id = Long.valueOf(id.trim());
        this.nome = nome;
        this.condiçãoSaude = condiçãoSaude;
    }

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

    public String getCondiçãoSaude() {
        return condiçãoSaude;
    }

    public void setCondiçãoSaude(String condiçãoSaude) {
        this.condiçãoSaude = condiçãoSaude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
