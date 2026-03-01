package api.proyecto.Proyecto.entity;

import jakarta.persistence.*;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private boolean completada;

    public Tarea() {

    }

    public Long getId() {
            return id;
    }

    public void setId(Long id) {
            this.id = id;
    }

    public String getDescripcion() {
            return descripcion;
    }

    public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
    }

    public boolean isCompletada(){
            return completada;
    }

    public void setCompletada(boolean compleatada) {
            this.completada = compleatada;
    }



}
