package com.example.devweek.Controller;

import com.example.devweek.Entity.FaixaEtaria;
import com.example.devweek.Repo.FaixaEtariaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerFaixaEtaria {
    private final FaixaEtariaRepo repository;

    public ControllerFaixaEtaria(FaixaEtariaRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/faixaetaria")
    public ResponseEntity<?> findAllFaixaEtaria(){
        try{
            List<FaixaEtaria> lista = repository.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/faixaetaria/{id}")
    public ResponseEntity<?> findByIdFaixaEtaria(@PathVariable Long id){
        try{
            Optional<FaixaEtaria> unidOptional = repository.findById(id);
            if(unidOptional.isPresent()){
                FaixaEtaria faixaEtariaUnid = unidOptional.get();
                return new ResponseEntity<>(faixaEtariaUnid, HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/faixaetaria/novo")
    public FaixaEtaria newFaixaEtaria(@RequestBody FaixaEtaria newFaixaEtaria){
        return repository.save(newFaixaEtaria);
    }

    @DeleteMapping("/faixaetaria/delete/{id}")
    public void  deleteFaixa(@PathVariable Long id){
        repository.deleteById(id);
    }
}
