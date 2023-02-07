package br.com.laurielcio.consumer.consumer;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties.AckMode;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import br.com.laurielcio.consumer.dto.UsuarioDto;

/**
 * 
 * @author lau
 *
 */

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Value("${spring.kafka.consumer.max-poll-records:1}")
	private String maxPollRecords;
	
	@Value("${spring.kafka.consumer.max-poll-interval-ms:300000}")
	private String maxPollIntervalMs;
	
	@Value("${spring.kafka.consumer.session-timeout-ms:10000}")
	private String sessionTimeoutMs;
	
	@Value("${spring.kafka.consumer.heartbeat-interval:3000}")
	private String heartbeatInterval;
	
	@Value("${spring.kafka.consumer.auto-offset-reset:earliest}")
	private String autoOffsetReset;
	
	@Value("${spring.kafka.consumer.enable-auto-commit:false}")
	private String enableAutoCommit;
	
	
	@Bean
	public ConsumerFactory<String, UsuarioDto> consumerFactory() {
		Map<String, Object> configs = new HashMap<>();
		
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
		configs.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollIntervalMs);
		configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
		configs.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, heartbeatInterval);
		configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
		configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
			
		return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(UsuarioDto.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, UsuarioDto> consumerListenerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, UsuarioDto> factory = new ConcurrentKafkaListenerContainerFactory<>();

		factory.getContainerProperties().setMissingTopicsFatal(false);
		factory.getContainerProperties().setAckMode(AckMode.MANUAL);
		factory.getContainerProperties().setSyncCommits(Boolean.TRUE);
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(20);

		return factory;
	}

	

}
