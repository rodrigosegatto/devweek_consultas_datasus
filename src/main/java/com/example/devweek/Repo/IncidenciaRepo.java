package com.example.devweek.Repo;

import com.example.devweek.Entity.IncidenciaExame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepo extends JpaRepository<IncidenciaExame, Long>  {
}
