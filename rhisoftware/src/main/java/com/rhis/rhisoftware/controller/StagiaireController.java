package com.rhis.rhisoftware.controller;

import com.rhis.rhisoftware.entity.Stagiaire;
import com.rhis.rhisoftware.service.StagiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/stagiaires")
public class StagiaireController {
    @Autowired
    private StagiaireService service;

    @GetMapping
    public String listStagiaires(Model model) {
        model.addAttribute("stagiaires", service.getAllStagiaires());
        return "stagiaires";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("stagiaire", new Stagiaire());
        return "add-stagiaire";
    }

    @PostMapping
    public String addStagiaire(@ModelAttribute Stagiaire stagiaire, @RequestParam String date_debut, @RequestParam(required = false) String date_fin) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            stagiaire.setDate_debut(new java.sql.Date(sdf.parse(date_debut).getTime()));
            if (date_fin != null && !date_fin.isEmpty()) {
                stagiaire.setDate_fin(new java.sql.Date(sdf.parse(date_fin).getTime()));
            }
            service.saveStagiaire(stagiaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/stagiaires";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Stagiaire stagiaire = service.getStagiaireById(id);
        if (stagiaire != null) {
            model.addAttribute("stagiaire", stagiaire);
            return "edit-stagiaire";
        }
        return "redirect:/stagiaires";
    }

    @PostMapping("/{id}")
    public String updateStagiaire(@PathVariable Long id, @ModelAttribute Stagiaire stagiaire, @RequestParam String date_debut, @RequestParam(required = false) String date_fin) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            stagiaire.setId(id);
            stagiaire.setDate_debut(new java.sql.Date(sdf.parse(date_debut).getTime()));
            if (date_fin != null && !date_fin.isEmpty()) {
                stagiaire.setDate_fin(new java.sql.Date(sdf.parse(date_fin).getTime()));
            }
            service.saveStagiaire(stagiaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/stagiaires";
    }

    @GetMapping("/{id}/delete")
    public String deleteStagiaire(@PathVariable Long id) {
        service.deleteStagiaire(id);
        return "redirect:/stagiaires";
    }
}