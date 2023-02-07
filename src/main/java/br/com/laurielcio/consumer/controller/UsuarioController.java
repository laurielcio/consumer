package br.com.laurielcio.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.laurielcio.consumer.dto.UsuarioDto;
import br.com.laurielcio.consumer.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Lau
 *
 */

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuarios", description = "Endpoints de gerenciamento de Usuários")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@ApiOperation(value = "Endpoint para listar todos os Usuários", notes = "Não recebe nenhum parâmetro.")
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> listar() {
		List<UsuarioDto> dtos = usuarioService.listar();
		return ResponseEntity.ok().body(dtos);
	}

}
