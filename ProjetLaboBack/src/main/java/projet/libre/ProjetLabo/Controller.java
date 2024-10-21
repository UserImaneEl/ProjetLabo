package projet.libre.ProjetLabo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


   @GetMapping("/getMessage")
    public ResponseEntity<Utilisateur> Hello() {
       Utilisateur user=new Utilisateur();
       user.setMessage("Hello From The Back!");
        return ResponseEntity.ok(user);


    }

}
