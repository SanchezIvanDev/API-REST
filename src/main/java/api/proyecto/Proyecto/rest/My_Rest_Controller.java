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

    @GetMapping("/{id}")
    public ResponseEntity<Tarea>getTareaById(@PathVariable Long id) {
        return repository.findById(id)
                .map(tarea -> ResponseEntity.ok(tarea))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaDetalles) {
        return repository.findById(id)
                .map(tareaExistente -> {
                    tareaExistente.setDescripcion(tareaDetalles.getDescripcion());
                    tareaExistente.setCompletada(tareaDetalles.isCompletada());
                    Tarea actualizada = repository.save(tareaExistente);
                    return ResponseEntity.ok(actualizada);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
