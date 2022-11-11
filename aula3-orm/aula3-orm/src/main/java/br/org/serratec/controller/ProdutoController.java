package br.org.serratec.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Produto;
import br.org.serratec.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	@GetMapping
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Produto> buscar(@PathVariable long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto inserir (@Valid @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@PostMapping("/salvarTodos")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Produto> inserirTodos(@Valid @RequestBody List<Produto> produtos) {
		return produtoRepository.saveAll(produtos);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable long id){
		 if (! produtoRepository.existsById(id)) {
			 return ResponseEntity.notFound().build();
		 }
		produtoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
