package br.org.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.serratec.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
    public Endereco findByCep(String cep);
    
    

}
