package com.kafkademo.controller;

import com.kafkademo.domain.MusicEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // defining a class is a controller
@Slf4j
public class MusicEventController {
    @PostMapping("/v1/music-event")

    public ResponseEntity<MusicEvent> postMusicEvent(
            @RequestBody MusicEvent musicEvent
    ) {

        log.info("Received music event request: {}", musicEvent);

        // invoke kafka producer
        log.info("Sending music event to kafka producer");
        log.info("Returning response: {}", musicEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(musicEvent);
    }
}
