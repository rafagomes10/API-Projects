package br.com.serratec.pizzariaserratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.pizzariaserratec.model.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

}
