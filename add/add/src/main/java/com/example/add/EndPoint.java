package com.example.add;

import org.springframework.web.bind.annotation.*;

@RestController
public class EndPoint {
    @GetMapping("/calc1")
    public int Calc1(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/calc2/{a}/{b}")

    public int Calc2(@PathVariable  int a, @PathVariable int b) {
        return a+b;
    }
    @PostMapping("/calc3")
    public int calc3(@RequestBody Calc3 calc3){
        return calc3.a+calc3.b;
    }


}