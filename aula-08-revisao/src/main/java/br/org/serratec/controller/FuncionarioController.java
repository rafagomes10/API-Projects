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

import br.org.serratec.model.Funcionario;
import br.org.serratec.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public List<Funcionario> listar() {
		return funcionarioRepository.findAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<Funcionario> buscar(@PathVariable Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario inserir( @RequestBody Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	@PutMapping("{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setIdFuncionario(id);
		funcionario = funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}