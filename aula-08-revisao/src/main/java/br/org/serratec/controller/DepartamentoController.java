package br.org.serratec.controller;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Departamento;
import br.org.serratec.repository.DepartamentoRepository;


@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@GetMapping
	public List<Departamento> listar() {
		return departamentoRepository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Departamento> buscar(@PathVariable Long id) {
		Optional<Departamento> departamento = departamentoRepository.findById(id);
		if (departamento.isPresent()) {
			return ResponseEntity.ok(departamento.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Departamento inserir( @RequestBody Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	@PutMapping("{id}")
	public ResponseEntity<Departamento> atualizar(@PathVariable Long id, @RequestBody Departamento departamento) {
		if (!departamentoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		departamento.setIdDepartamento(id);
		departamento = departamentoRepository.save(departamento);
		return ResponseEntity.ok(departamento);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!departamentoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		departamentoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
