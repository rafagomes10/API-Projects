package br.com.serratec.pizzariaserratec.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.pizzariaserratec.dto.EstudanteRequestDTO;
import br.com.serratec.pizzariaserratec.dto.EstudanteResponseDTO;
import br.com.serratec.pizzariaserratec.model.Estudante;
import br.com.serratec.pizzariaserratec.repository.EstudanteRepository;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository repositorio;
	
	private ModelMapper mapper = new ModelMapper();
	
	public List<EstudanteResponseDTO> obterTodos(){
		
		List<Estudante> estudantes = repositorio.findAll();
		
		// Aqui eu pega o lista de Estudante (Modelo), e converto um a uma em um EstudanteResponseDTO.
		//No final devolvo a lista convertida.
		return estudantes.stream()
				.map(estudante -> mapper.map(estudante, EstudanteResponseDTO.class))
				.collect(Collectors.toList());		
	}
	
	public Optional<EstudanteResponseDTO> obterPorId(Long id){
		
		Optional<Estudante> optEstudante = repositorio.findById(id);
		
		if(optEstudante.isEmpty()) {
			//Aqui lanço um exception
			//Not found
		}
		
		var estudanteDTO = mapper.map(optEstudante.get(), EstudanteResponseDTO.class);
		
		return Optional.of(estudanteDTO);
	}
	
	
	public EstudanteResponseDTO cadastrar(EstudanteRequestDTO estudanteDto) {
			
		var estudanteModel = mapper.map(estudanteDto, Estudante.class);
		
		
		estudanteModel.setId(null);
		estudanteModel =  repositorio.save(estudanteModel);
		
		return mapper.map(estudanteModel, EstudanteResponseDTO.class);
	}
	
	public EstudanteResponseDTO atualizar(Long id, EstudanteRequestDTO estudanteDto) {
				
		var estudanteModel = mapper.map(estudanteDto, Estudante.class);
		
		estudanteModel.setId(id);
		estudanteModel =  repositorio.save(estudanteModel);
		
		return mapper.map(estudanteModel, EstudanteResponseDTO.class);
	}
	
	
	public void deletar(Long id) {
		var optEstudante = obterPorId(id);
		
		if(optEstudante.isEmpty()) {
			// Lançar uma exception
		}
		
		repositorio.deleteById(id);
	}
	
}
