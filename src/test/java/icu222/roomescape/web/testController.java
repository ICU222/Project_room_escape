package icu222.roomescape.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {
    @GetMapping("/test") //
    public String hello(){
        return "test";
    }

}


