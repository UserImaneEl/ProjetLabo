package projet.libre.ProjetLabo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


   @GetMapping("/getMessage")
    public String Hello() {
        return "Hello from the back";


    }

}
