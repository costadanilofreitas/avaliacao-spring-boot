package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/estudantes/")
public class EstudanteRestController {

    @Autowired
    private EstudanteServiceImpl estudandeService;

	// TODO caso você não conheça THEMELEAF faça a implementação dos métodos em forma de RESTCONTROLLER (seguindo o padrão RESTFUL)

    @PostMapping("add")
    public ResponseEntity<Estudante> cadastrarEstudante(@RequestBody @Valid Estudante estudante) {

        Estudante estudanteObjeto = estudandeService.cadastrarEstudante(estudante);
        return ResponseEntity.status(201).body(estudanteObjeto);
    }

	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)

	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)
}
