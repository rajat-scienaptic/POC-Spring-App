package com.scienaptic.poc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RAJAT MEENA
 */
@RequestMapping("/poc")
@RestController
public class PocController {
    @GetMapping("/getAppName")
    public ResponseEntity<Object> getAppName(){
        Map<String, Object> outputMap = new HashMap<>();
        outputMap.put("app","POC Spring APP");
        return new ResponseEntity<>(outputMap, HttpStatus.OK);
    }
}
