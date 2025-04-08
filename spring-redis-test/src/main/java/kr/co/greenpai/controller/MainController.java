package kr.co.greenpai.controller;

import kr.co.greenpai.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @PostMapping("/redis/string")
    public void setValue(String key, String value) {
        mainService.setValue(key, value);
    }

    @GetMapping("/redis/string/{key}")
    public ResponseEntity getValue(@PathVariable("key") String key) {
        String value = mainService.getValue(key);
        return ResponseEntity.ok().body(value);
    }

    @PostMapping("/redis/addToListFromRight")
    public void addToListFromRight(String key, String value) {
        mainService.addToListFromRight(key, value);
    }

    @PostMapping("/redis/addToListFromLeft")
    public void addToListFromLeft(String key, String value) {
        mainService.addToListFromLeft(key, value);
    }

    @GetMapping("/redis/getFromList")
    public String getFromList(String key, int index) {
        return mainService.getFromList(key, index);
    }

    @GetMapping("/redis/getRangeFromList")
    public List<String> getRangeFromList(String key, int start, int end) {
        return mainService.getRangeFromList(key, start, end);
    }

    @PostMapping("/redis/addToSet")
    public void addToSet(String key, String[] values) {
        mainService.addToSet(key, values);
    }

}
