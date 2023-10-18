package another_package.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {
    @GetMapping("/another-package")
    String aPageOfAnotherPackage(){
        return "can be scan because of the configuration";
    }
}
