package ru.dhabits.homeworkkafkaproducer.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.dhabits.homeworkkafkaproducer.service.SenderService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final SenderService senderService;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message) {
        log.info("The message is: {}", message);
        senderService.sendMessage(message);
        return ResponseEntity.ok(message);
    }
}
