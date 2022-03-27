package com.microservices.myapp.controller;

import com.microservices.myapp.repo.StructuralRepo;
import com.microservices.myapp.repo.model.Structural;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/structural")
public class StructuralController {
    @Autowired
    private StructuralRepo structuralRepo;

    @GetMapping
    public List<Structural> getAllStructural() {
        return structuralRepo.findAll();
    }
    @PostMapping
    public Structural addStructural(@RequestBody Structural structural){
        return structuralRepo.save(structural);
    }
}
