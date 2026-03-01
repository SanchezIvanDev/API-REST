package api.proyecto.Proyecto.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tareas")
public class My_Rest_Controller {

    @GetMapping
    public String getTareas(){
        return "lista de tareas: Practicar Spring Boot";
    }
}
