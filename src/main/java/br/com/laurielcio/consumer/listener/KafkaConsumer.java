package br.com.laurielcio.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import br.com.laurielcio.consumer.dto.UsuarioDto;
import br.com.laurielcio.consumer.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Lau
 *
 */

@Slf4j
@Service
public class KafkaConsumer {
	
	private static final String TOPIC = ("${spring.kafka.usuario.topic}");

	private static final String GROUP_ID = ("${spring.kafka.usuario.group-id}");

	private static final String CLIENT_ID = ("${spring.kafka.usuario.client-id}");
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@KafkaListener(topics = TOPIC, groupId = GROUP_ID, clientIdPrefix = CLIENT_ID, containerFactory = "consumerListenerFactory")
	public void consumer(@Payload UsuarioDto dto, Acknowledgment ack) {
		log.info("==== consumer init... ====");
		log.info("==== Nova mensagem localizada: "	+ dto.getCpf() + " ====");
		
		try {
			usuarioRepository.save(dto.convert());
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		try {
			ack.acknowledge();
		} catch (Exception e) {
			log.error("Erro ao commitar no servidor Kafka");
			e.printStackTrace();
		}
		
		log.info("==== consumer end! ====");
	}	

}
