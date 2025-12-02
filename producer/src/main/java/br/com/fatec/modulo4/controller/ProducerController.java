package br.com.fatec.modulo4.controller;

import br.com.fatec.modulo4.dto.FilaProcessamento;
import br.com.fatec.modulo4.events.FilaEventProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("modulo4/v1")
public class ProducerController {
    private final FilaEventProducer filaEventProducer;

    public ProducerController(FilaEventProducer filaEventProducer) {
        this.filaEventProducer = filaEventProducer;
    }

    @PostMapping("/fila")
    public String enviarMensagem(@RequestBody FilaProcessamento filaProcessamento) {
        filaEventProducer.sendMessage(filaProcessamento);
        return "Mensagem (fila de processamento) enviada com sucesso!";
    }
}
