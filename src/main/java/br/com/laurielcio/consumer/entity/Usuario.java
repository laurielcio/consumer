package br.com.laurielcio.consumer.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.laurielcio.consumer.dto.EnderecoDto;
import br.com.laurielcio.consumer.enums.UsuarioStatusEnum;
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
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -712390625202850606L;

	@Id
	@Column(name = "ID", nullable = false)
	private Long idUsuario;
	
	@Column(name = "NOME", nullable = false)
	private String nome;	
	
	@Column(name = "CPF", nullable = false)
	private String cpf;
	
	@Column(name = "DT_NASCIMENTO", nullable = false)
	private LocalDate dtNascimento;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "TELEFONE", nullable = false)
	private String telefone;
	
	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private UsuarioStatusEnum status;
	
	@Column(name = "DT_CADASTRO", nullable = false)
	private LocalDate dtCadastro;
	
	@Column(name = "DT_Alteracao")
	private LocalDate dtAlteracao;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO_ID", referencedColumnName = "ID")
    private Endereco endereco;
	
	public Usuario(Long idUsuario, String nome, String cpf, String dtNascimento, String email, String telefone, UsuarioStatusEnum status, String dtCadastro, String dtAlteracao, EnderecoDto endereco) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.dtNascimento = LocalDate.parse(dtNascimento, formatter);
		this.email = email;
		this.telefone = telefone;
		this.status = status;
		this.dtCadastro = LocalDate.parse(dtCadastro, formatter);
		this.dtAlteracao = LocalDate.parse(dtAlteracao, formatter);
		this.endereco = new Endereco(endereco);
	}

}
