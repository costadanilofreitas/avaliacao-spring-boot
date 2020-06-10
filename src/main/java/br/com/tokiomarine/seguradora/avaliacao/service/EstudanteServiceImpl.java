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
	public Estudante cadastrarEstudante(@Valid Estudante estudante) {
		Estudante estudanteObjeto = estudanteRepository.save(estudante);
		return estudanteObjeto;
	}

	@Override
	public Estudante atualizarEstudante(@Valid Estudante estudante) {
		return null;
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
