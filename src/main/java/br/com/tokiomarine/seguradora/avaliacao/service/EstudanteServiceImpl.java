package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
		Optional<Estudante> estudanteOptional = buscarEstudante(estudante.getId());
		if (estudanteOptional.isPresent()){
			Estudante estudanteObjeto = estudanteRepository.save(estudante);
			return estudanteObjeto;
		}
		throw new ObjectNotFoundException(Estudante.class, "O estudante não foi encontrato");
	}

	@Override
	public Iterable<Estudante> buscarEstudantes() {
		Iterable<Estudante> estudantes = estudanteRepository.findAll();
		return estudantes;
	}

	@Override
	public Optional<Estudante> buscarEstudante(long id) {
		Integer aux = (int) (long) id;
		Optional<Estudante> estudantes = estudanteRepository.findById(aux);
		return estudantes;
	}
}
