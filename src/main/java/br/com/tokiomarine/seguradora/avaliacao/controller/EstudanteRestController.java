package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("atualizar/{id}")
    public Estudante atualizarEstudante(@PathVariable("id") long id, @RequestBody @Valid Estudante estudante) {
        int aux = (int) (long) id;
        estudante.setId(aux);
        try {
            Estudante estudanteObjeto = estudandeService.atualizarEstudante(estudante);
            return estudanteObjeto;
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }

    @GetMapping("listar")
    public Iterable<Estudante> listarEstudantes() {
        return estudandeService.buscarEstudantes();
    }

    @GetMapping("listar/{id}")
    public Estudante buscarEstudante(@PathVariable int id){
        Optional<Estudante> estudanteOptional = estudandeService.buscarEstudante(id);

        if(estudanteOptional.isPresent()){
            return estudanteOptional.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)
}
