package api.proyecto.Proyecto.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.proyecto.Proyecto.entity.Tarea;
import api.proyecto.Proyecto.repository.TareaRepository;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class My_Rest_Controller {

    private final TareaRepository repository;

    public My_Rest_Controller(TareaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List <Tarea> getTareas() {
        return repository.findAll();
    }

    @PostMapping
    public Tarea crearTarea (@RequestBody Tarea nuevaTarea) {
        return repository.save(nuevaTarea);

    }
}
