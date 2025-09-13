package com.bienes.bienesraicesscz.controller;

import com.bienes.bienesraicesscz.model.CatalogoCasa;
import com.bienes.bienesraicesscz.service.CatalogoCasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoCasaController {

    @Autowired
    private CatalogoCasaService catalogoCasaService;

    @GetMapping("/casas")
    public List<CatalogoCasa> obtenerTodasLasCasas() {
        return catalogoCasaService.obtenerTodasLasCasas();
    }

    @PostMapping("/casas")
    public CatalogoCasa guardarCasa(@RequestBody CatalogoCasa casa) {
        return catalogoCasaService.guardarCasa(casa);
    }

    @GetMapping("/casas/{id}")
    public CatalogoCasa obtenerDetalleDeCasa(@PathVariable Long id) {
        return catalogoCasaService.obtenerCasaPorId(id);
    }
}