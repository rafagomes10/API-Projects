package br.org.serratec.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Documento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "id")
	private Pessoa pessoa;
	
	private String cpf;
	private String ci;
	private String orgaoExpedidor;
	private String tituloEleitor;
	private String certificadoReservista;
	
	
}