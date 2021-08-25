package com.example.sieveoferatosthenes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SieveOfEratosthenesController {

/* Too much overhead
    @PostMapping("/sieve/{maxInt}")
    public List<Integer> getPrime(@PathVariable int maxInt) {
        return SieveOfEratosthenesService.getAllPrimes(maxInt);
    }
*/
    /*  Could use @RequestParam here and leave as /sieve but prefer more 'restful' url */
    @PostMapping("/sieve/{maxInt}")
    public String getPrimes(@PathVariable int maxInt) {
        return SieveOfEratosthenesService.getAllPrimes(maxInt);
    }
}

