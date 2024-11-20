package com.br.empoderatech.cursos.services;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LoginListenerService {

    private String token;

    @RabbitListener(queues = "${rabbitmq.queue.login.cursos}")
    public void tokenConsumer(String tokenRecebido) {
        this.token = tokenRecebido; // Armazena o token recebido
        System.out.println("Token recebido da fila RabbitMQ: " + token);
    }

    public String getToken() {
        return this.token; // Método para recuperar o token armazenado
    }
}
