package br.org.serratec.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Aluno;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	private static List<Aluno> alunos = new ArrayList<>();
	
	static {
		alunos.add(new Aluno("123","Maria","m@gmail.com"));
		alunos.add(new Aluno("321","Ana","a@gmail.com"));
		alunos.add(new Aluno("124","José","j@gmail.com"));
		alunos.add(new Aluno("126","Carlos","c@gmail.com"));
	}
	
	@GetMapping
	public List<Aluno> listar(){
		return alunos;
	}
	
	// localhost:8080/alunos/123
	@GetMapping("{matricula}")
	public Aluno buscar(@PathVariable String matricula) {
		for (int i = 0; i < alunos.size(); i++) {
			if(alunos.get(i).getMatricula().equals(matricula)) {
				return alunos.get(i);
			}
		
			}
	return null;
		
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno inserir(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return aluno;
	}
	
	@DeleteMapping("{matricula}")
	public void apagar(@PathVariable String matricula) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				alunos.remove(i);
			}
		}
	}
	
	@PutMapping("{matricula}")
	public Aluno atualizar(@RequestBody Aluno aluno, @PathVariable String matricula) {
		for (int i = 0; i < alunos.size(); i++) {
			if (alunos.get(i).getMatricula().equals(matricula)) {
				Aluno a = new Aluno(matricula, aluno.getNome(), aluno.getEmail());
				alunos.set(i, a);
				return a;
			}
		}
		return null;
	}
}
