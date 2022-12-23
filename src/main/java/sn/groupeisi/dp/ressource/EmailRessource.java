package sn.groupeisi.dp.ressource;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@RestController
@NoArgsConstructor @AllArgsConstructor @ToString @Data
public class EmailRessource {
    private String to;
    private String subject;
    private String message;
   
   
    
}
