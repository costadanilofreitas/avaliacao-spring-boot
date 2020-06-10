package br.com.tokiomarine.seguradora.avaliacao.entidade;

import org.hibernate.ObjectNotFoundException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 8, max = 100, message = "O nome deve ter entre 8 a 100 caracteres ")
    @NotNull(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "O formato do email é invalido")
    @NotNull(message = "Email é obrigatório")
    private String email;

    private int telefone;

    public Estudante() {

    }

    public Estudante(String nome, String email, int telefone) throws ObjectNotFoundException {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

}
