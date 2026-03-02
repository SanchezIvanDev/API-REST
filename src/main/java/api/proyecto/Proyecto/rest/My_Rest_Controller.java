package api.proyecto.Proyecto.rest;

import api.proyecto.Proyecto.entity.Tarea;
import api.proyecto.Proyecto.service.TareaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class My_Rest_Controller {

    private final TareaService service;

    public My_Rest_Controller(TareaService  service) {

        this.service = service;
    }

    @GetMapping
    public List <Tarea> getTareas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea>geById(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tarea crear (@RequestBody Tarea tarea) {
        return service.guardar(tarea);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea detalles) {
        return service.buscarPorId(id)
                .map(tareaExistente -> {
                    tareaExistente.setDescripcion(detalles.getDescripcion());
                    tareaExistente.setCompletada(detalles.isCompletada());
                    return ResponseEntity.ok(service.guardar(tareaExistente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
