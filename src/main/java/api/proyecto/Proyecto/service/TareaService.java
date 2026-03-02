package api.proyecto.Proyecto.service;

import api.proyecto.Proyecto.entity.Tarea;
import api.proyecto.Proyecto.repository.TareaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // lógica
public class TareaService {

    private final TareaRepository repository;

    public TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    public List<Tarea> listarTodas() {
        return repository.findAll();
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Tarea guardar(Tarea tarea){
        return repository.save(tarea);
    }

    public boolean eliminar(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
