package icu222.roomescape.web;

import icu222.roomescape.web.dto.TestResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class testController {
    @GetMapping("/test") //
    public String hello(){
        return "test";
    }

    @GetMapping("/test/dto")
    public TestResponseDto testDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new TestResponseDto(name, amount);
    }
}





