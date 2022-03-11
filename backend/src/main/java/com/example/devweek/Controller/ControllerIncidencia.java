package com.example.devweek.Controller;

import com.example.devweek.Entity.IncidenciaExame;
import com.example.devweek.Repo.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {
    private final IncidenciaRepo repository;

    public ControllerIncidencia(IncidenciaRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/incidencia")
    public ResponseEntity<List<IncidenciaExame>> findIncidencias(){
        List<IncidenciaExame> listaIncidencia = repository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencia/{id}")
    public ResponseEntity<IncidenciaExame> findOcorrenciasById(@PathVariable Long id){
        Optional<IncidenciaExame> incidenciaOptional = repository.findById(id);
        if (incidenciaOptional.isPresent()){
            IncidenciaExame incidenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/incidencia/novo")
    public IncidenciaExame putIncidencia(@RequestBody IncidenciaExame newIncidencia){
        return repository.save(newIncidencia);
    }

}
