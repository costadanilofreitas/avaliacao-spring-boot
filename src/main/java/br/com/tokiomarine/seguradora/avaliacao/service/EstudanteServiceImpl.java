package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteServiceImpl implements EstudanteService {

	@Autowired
	private EstudanteRepository estudanteRepository;

	@Override
	public void cadastrarEstudante(@Valid Estudante estudante) {

	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {

	}

	@Override
	public List<Estudante> buscarEstudantes() {
		//List<Estudante> estudantes = estudanteRepository.findAll();
		//return estudantes;
		return null;
	}

	@Override
	public Estudante buscarEstudante(long id) {
		throw new IllegalArgumentException("Identificador inválido:" + id);
	}

}
