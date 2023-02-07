package br.com.laurielcio.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.laurielcio.consumer.entity.Usuario;

/**
 * 
 * @author Lau
 *
 */

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
