package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

import java.util.Optional;

public interface EstudanteService {

	Iterable<Estudante> buscarEstudantes();

	Estudante cadastrarEstudante(@Valid Estudante estudante);

	Optional<Estudante> buscarEstudante(long id);

	Estudante atualizarEstudante(@Valid Estudante estudante);

}
