package projet.libre.ProjetLabo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

   @Autowired
   LaboratoireInterface laboratoireInterface;
   /*@GetMapping("/getMessage")
    public ResponseEntity<Utilisateur> Hello() {
       Utilisateur user=new Utilisateur();
       user.setMessage("Hello From The Back!");
        return ResponseEntity.ok(user);


    }*/
   @PostMapping("/addLabo")
   public ResponseEntity<String> addLabo(@RequestBody Laboratoire labo) {
       if (labo == null) {
           return ResponseEntity.badRequest().body("Laboratoire ne peut pas être null");
       }
       try {
           laboratoireInterface.save(labo);
           return ResponseEntity.ok("Laboratoire ajouté avec succès");
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du laboratoire");
       }
   }

}
