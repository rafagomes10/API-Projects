package br.com.serratec.pizzariaserratec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.pizzariaserratec.model.Estudante;
import br.com.serratec.pizzariaserratec.model.Materia;
import br.com.serratec.pizzariaserratec.repository.EstudanteRepository;
import br.com.serratec.pizzariaserratec.repository.MateriaRepository;

@Service
public class MateriaService {

	@Autowired
	private MateriaRepository repositorio;
	
	public List<Materia> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<Materia> obterPorId(Long id){
		return repositorio.findById(id);
	}
	
	public Materia cadastrar(Materia materia) {
		materia.setId(null);
		return repositorio.save(materia);
	}
	
	public Materia atualizar(Long id, Materia materia) {
		materia.setId(id);
		return repositorio.save(materia);
	}
	
	public void deletar(Long id) {
		repositorio.deleteById(id);
	}
	
}
