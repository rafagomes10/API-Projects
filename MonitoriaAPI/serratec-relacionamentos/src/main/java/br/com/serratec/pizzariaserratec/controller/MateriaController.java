package br.com.serratec.pizzariaserratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.pizzariaserratec.model.Estudante;
import br.com.serratec.pizzariaserratec.model.Materia;
import br.com.serratec.pizzariaserratec.service.EstudanteService;
import br.com.serratec.pizzariaserratec.service.MateriaService;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

	@Autowired
	private MateriaService servico;
	
	@GetMapping
	public List<Materia> obterTodos(){
		return servico.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Materia> oberPorId(@PathVariable Long id){
		return  servico.obterPorId(id);
	}
	
	@PostMapping
	public Materia cadastrar(@RequestBody Materia materia) {
		return servico.cadastrar(materia);
	}
}
