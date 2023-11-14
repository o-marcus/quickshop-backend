package com.quickshop.notificationservice;

import com.quickshop.notificationservice.event.EventoPedidoRealizado;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@SpringBootApplication
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notificacao")
	public void handleNotification(EventoPedidoRealizado evento){
		log.info("Received Notification for order - {}", evento.getCodigo());
	}
}
