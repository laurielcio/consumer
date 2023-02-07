package br.com.laurielcio.consumer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.laurielcio.consumer.dto.EnderecoDto;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Lau
 *
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = -2194846768940623927L;

	@Id
	@Column(name = "ID", nullable = false)
	private Long idEndereco;

	@Column(name = "CEP", nullable = false)
	private String cep;

	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;

	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@Column(name = "BAIRRO", nullable = false)
	private String bairro;

	@Column(name = "LOCALIDADE", nullable = false)
	private String localidade;

	@Column(name = "UF", nullable = false)
	private String uf;

	@OneToOne(mappedBy = "endereco")
	private Usuario usuario;

	public Endereco(String cep, String logradouro, String numero, String complemento, String bairro, String localidade, String uf) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}

	public Endereco(EnderecoDto endereco) {
		this.idEndereco = endereco.getIdEndereco();
		this.cep = endereco.getCep();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.localidade = endereco.getLocalidade();
		this.uf = endereco.getUf();		
	}

}
