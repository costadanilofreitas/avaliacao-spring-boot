package br.com.tokiomarine.seguradora.avaliacao.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudanteServiceImpl;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

	@Autowired
	private EstudanteServiceImpl estudandeService;

	@GetMapping("criar")
	public String iniciarCadastro(Estudante estudante) {
		return "cadastrar-estudante";
	}

	@GetMapping("listar")
	public String listarEstudantes(Model model) {
		model.addAttribute("estudantes", estudandeService.buscarEstudantes());
		return "index";
	}

	//@PostMapping("add")
	//public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
	//	if (result.hasErrors()) {
	//		return "cadastrar-estudante";
	//	}

	//	estudandeService.cadastrarEstudante(estudante);

	//	return "redirect:listar";
	//}

	@GetMapping("editar/{id}")
	public String exibirEdicaoEstudante(long id, Model model) {
		Estudante estudante = estudandeService.buscarEstudante(id);
		model.addAttribute("estudante", estudante);
		return "atualizar-estudante";
	}

	@PostMapping("atualizar/{id}")
	public String atualizarEstudante(@PathVariable("id") long id, @Valid Estudante estudante, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// estudante.setId(id);
			return "atualizar-estudante";
		}

		estudandeService.atualizarEstudante(estudante);

		model.addAttribute("estudantes", estudandeService.buscarEstudantes());
		return "index";
	}

	@GetMapping("apagar/{id}")
	public String apagarEstudante(@PathVariable("id") long id, Model model) {
		// TODO IMPLEMENTAR A EXCLUSAO DE ESTUDANTES
		model.addAttribute("estudantes", estudandeService.buscarEstudantes());
		return "index";
	}
}
