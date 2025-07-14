package com.rhis.rhisoftware.service;

import com.rhis.rhisoftware.entity.Stagiaire;
import com.rhis.rhisoftware.repository.StagiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StagiaireService {
    @Autowired
    private StagiaireRepository repository;

    public List<Stagiaire> getAllStagiaires() {
        return repository.findAll();
    }

    public Stagiaire getStagiaireById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Stagiaire saveStagiaire(Stagiaire stagiaire) {
        return repository.save(stagiaire);
    }

    public void deleteStagiaire(Long id) {
        repository.deleteById(id);
    }
}