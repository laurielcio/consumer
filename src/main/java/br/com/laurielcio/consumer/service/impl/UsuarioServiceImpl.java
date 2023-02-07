package br.com.laurielcio.consumer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.laurielcio.consumer.dto.UsuarioDto;
import br.com.laurielcio.consumer.entity.Usuario;
import br.com.laurielcio.consumer.exception.DatabaseAccessException;
import br.com.laurielcio.consumer.exception.ObjectNoContent;
import br.com.laurielcio.consumer.repository.UsuarioRepository;
import br.com.laurielcio.consumer.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Lau
 *
 */

@Slf4j
@Service("UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<UsuarioDto> listar() {
		log.info("==== listar init... ====");
		
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			usuarios = usuarioRepository.findAll();
		} catch (Exception e) {
			throw new DatabaseAccessException("Ocorreu um erro ao acessar o banco ao buscar lista de Usuarios por status! " + e.getMessage());
		}
		
		if(usuarios.isEmpty()) throw new ObjectNoContent("Nenhum Usuario encontrado no bando de dados!");
		
		log.info("==== listar end! ====");
		return UsuarioDto.convert(usuarios);
	}

}
