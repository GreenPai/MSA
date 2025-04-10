package kr.co.greenpai.controller;

import brave.Span;
import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final Tracer tracer;

    @GetMapping("/")
    public String index() {
        return "service2 index!!!";
    }

    @GetMapping("/traceId")
    public String traceId(){

        log.info("traceId...");
        Span currentSpan = tracer.currentSpan();

        String traceId = currentSpan.context().traceIdString();
        String spanId = currentSpan.context().spanIdString();

        return "[tranceId : " + traceId + "]" + "[spanId : " + spanId + "]";
    }

    @GetMapping("/user")
    public Map<String, String> user(){

        log.info("serivce2 user...");
        return Map.of(
                "uid", "a101",
                "name", "홍길동",
                "age", "23",
                "addr", "부산"
        );
    }
}
