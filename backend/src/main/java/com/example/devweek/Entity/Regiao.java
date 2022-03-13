package com.example.devweek.Entity;

import javax.persistence.*;

@Entity
public class Regiao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String regiao;
    private Long total_exames;

    public Regiao(String regiao, Long total_exames) {
        this.regiao = regiao;
        this.total_exames = total_exames;
    }

    public Regiao(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public Long getTotalExames() {
        return total_exames;
    }

    public void setTotalExames(Long qnt_exames) {
        this.total_exames = qnt_exames;
    }
}
