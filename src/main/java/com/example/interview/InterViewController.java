package com.example.interview;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@RestController
public class InterViewController {

    @GetMapping("/getData/{data}")
    public String getData(@PathVariable("data") String data, HttpServletResponse response) {
        RestTemplate restT = new RestTemplate();
        try {
            String result = restT.getForObject("https://" + data, String.class);
            return result.substring(result.indexOf("<body"), result.indexOf("</body>") + 7);
        } catch (Exception e){
            return "Website Not found";
        }
    }
}
