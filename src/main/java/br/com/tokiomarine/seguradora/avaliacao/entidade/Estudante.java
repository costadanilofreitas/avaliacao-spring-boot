package br.com.tokiomarine.seguradora.avaliacao.entidade;

import org.hibernate.ObjectNotFoundException;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="ESTUDANTE_TESTE")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identificador_estudante")
    private int id;

    @NotNull(message = "Nome é obrigatório")
    @Column(name = "nome_estudante")
    private String nome;

    @Email(message = "O formato do email é invalido")
    @NotNull(message = "Email é obrigatório")
    @Column(name = "email_estudante")
    private String email;

    @Column(name = "telefone_estudante")
    private int telefone;

    @NotNull(message = "Matrícula é obrigatória")
    @Column(name = "matricula_estudante")
    private int matricula;

    @Column(name = "curso_estudante")
    private String curso;

    public Estudante() {

    }

    public Estudante(String nome, String email, int telefone, int matricula, String curso) throws ObjectNotFoundException {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.curso = curso;
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

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
