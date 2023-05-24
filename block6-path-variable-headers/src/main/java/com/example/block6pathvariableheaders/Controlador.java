package com.example.block6pathvariableheaders;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @PostMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/user/{id}")
    public Greeting greeting(@PathVariable(value = "id") long id) {
        return new Greeting(id, String.format(template, "User"));
    }

    @PutMapping("/post")
    public Map<Long,String> greeting(@RequestParam("var1") long var1,
                                     @RequestParam("var2") String var2) {
        new HashMap<Long,String>();
        Map<Long,String> map = new HashMap<Long,String>();
        map.put(var1, var2);
        return map;
    }
}

