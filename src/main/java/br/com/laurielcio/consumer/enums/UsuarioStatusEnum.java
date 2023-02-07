package br.com.laurielcio.consumer.enums;

import lombok.Getter;

/**
 * 
 * @author Lau
 *
 */

@Getter
public enum UsuarioStatusEnum {
	
	ENDERECO_PENDENTE("Endereço Pendente"),
	ATIVO("Ativo"),
	INATIVO("Inativo");
	
	private String descricao;
	
	UsuarioStatusEnum(String descricao){
		this.descricao = descricao;
	}

}
