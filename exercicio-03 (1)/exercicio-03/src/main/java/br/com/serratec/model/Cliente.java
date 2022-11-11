package br.com.serratec.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import net.bytebuddy.asm.Advice.Local;

@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id_cliente")
	private Long id;
	
	//Vai verificar se o campo descrição está vazio ou nulo
	@NotBlank(message = "Preencha o seu nome")
	@Size(max = 60, message = "Tamanho do campo inválido")
	@Column
	private String nome;
	
	@CPF(message = "Preencha com a numeração correta!")	
	@Column
	private String cpf;
	
	@Email(message = "Preencha o e-mail corretamente")
	@Column
	private String email;	
	
	@Column(name = "dataNascimento")
	private LocalDate dataNascimento;
	
	@Embedded
	Endereco endereco = new Endereco();
	

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", dataNascimento="
				+ dataNascimento + "]";
	}
	
	public Cliente(Long id,
			@NotBlank(message = "Preencha o seu nome") @Size(max = 60, message = "Tamanho do campo inválido") String nome,
			@CPF(message = "Preencha com a numeração correta!") String cpf,
			@Email(message = "Preencha o e-mail corretamente") String email, LocalDate dataNascimento,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	

}
