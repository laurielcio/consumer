package br.com.laurielcio.consumer.dto;

import java.time.LocalDate;

import br.com.laurielcio.consumer.entity.Endereco;
import br.com.laurielcio.consumer.enums.UsuarioStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Lau
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {
	
	private Long idEndereco;

	private String cep;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String localidade;

	private String uf;
	
	public EnderecoDto(Endereco endereco) {
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
