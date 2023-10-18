package another_package.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {
    @GetMapping("/another-package")
    String aPageOfAnotherPackage(){
        return "can not be scan of default situation!";
    }
}
