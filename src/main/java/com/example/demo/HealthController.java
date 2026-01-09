package com.example.demo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class HealthController {
  private static final Logger log = LoggerFactory.getLogger(HealthController.class);

    @GetMapping("/hello")
    public String hello() {
        log.info("Hello endpoint called");
        return "Hello from Demo Service";
    }

    @GetMapping("/time")
    public Map<String, Object> time() {
        log.debug("Time endpoint called");
        return Map.of(
                "timestamp", Instant.now().toString(),
                "status", "OK"
        );
    }

    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> payload) {
        log.info("Echo payload received: {}", payload);
        return payload;
    }

    @GetMapping("/error")
    public void error() {
        log.error("Forced error endpoint called");
        throw new RuntimeException("Simulated error for tracing");
    }
}
