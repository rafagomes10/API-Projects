package br.org.serratec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import br.org.serratec.model.Vendedor;
import br.org.serratec.repository.VendedorRepository;

@Service
public class VendedorService {
    
    @Autowired
    private VendedorRepository vendedorRepository;
    
    @GetMapping
    public List<Vendedor> listar(){
        return vendedorRepository.findAll();
        
    }
    
    public Page<Vendedor> listarPorPagina(Pageable pageable){
        return vendedorRepository.findAll(pageable);
        
    }

}
