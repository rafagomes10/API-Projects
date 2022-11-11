package br.org.serratec.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "produto", schema = "public")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;
	
	//Vai verificar se o campo descrição está vazio ou nulo
	@NotBlank(message = "Preencha a descrição do produto")
	@Size(max = 40, min = 2, message = "Tamanho do campo inválido")
	@Column(nullable =false,length = 40)
	private String descricao;
	
	@DecimalMax(value = "10000", message = "O preço deve ser inferior a R${value}.00")
	@DecimalMin(value = "10", message = "O preço dever ser superior a R${value}.00")
	@Column
	private BigDecimal valor;
	
	
	@Column(name = "data_cadastro")
	private LocalDate dataCadastro;


	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", dataCadastro=" + dataCadastro
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}