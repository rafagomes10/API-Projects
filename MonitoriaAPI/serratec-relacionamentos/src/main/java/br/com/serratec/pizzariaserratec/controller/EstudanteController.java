package br.com.serratec.pizzariaserratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.pizzariaserratec.dto.EstudanteRequestDTO;
import br.com.serratec.pizzariaserratec.dto.EstudanteResponseDTO;
import br.com.serratec.pizzariaserratec.model.Estudante;
import br.com.serratec.pizzariaserratec.service.EstudanteService;

@RestController
@RequestMapping("/api/estudantes")
public class EstudanteController {

	@Autowired
	private EstudanteService servico;
	
	@GetMapping
	public ResponseEntity<List<EstudanteResponseDTO>> obterTodos(){		
		return ResponseEntity.ok(servico.obterTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<EstudanteResponseDTO>> oberPorId(@PathVariable Long id){
		return ResponseEntity.ok(servico.obterPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<EstudanteResponseDTO> cadastrar(@RequestBody EstudanteRequestDTO estudante) {
		EstudanteResponseDTO dto = servico.cadastrar(estudante);
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EstudanteResponseDTO> atualizar(@PathVariable Long id, @RequestBody EstudanteRequestDTO estudante) {
		EstudanteResponseDTO dto = servico.atualizar(id, estudante);		
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		servico.deletar(id);
		//return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
		return ResponseEntity.ok("O id:" + id + " foi deletado com sucesso!"); // 200
	}
}
