package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
