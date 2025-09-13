package com.bienes.bienesraicesscz.service;

import com.bienes.bienesraicesscz.model.CatalogoCasa;
import com.bienes.bienesraicesscz.repository.CatalogoCasaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoCasaService {

    @Autowired
    private CatalogoCasaRepository catalogoCasaRepository;

    /**
     * Devuelve una lista de todas las casas del catálogo.
     */
    public List<CatalogoCasa> obtenerTodasLasCasas() {
        return catalogoCasaRepository.findAll();
    }

    /**
     * Guarda una nueva casa en la base de datos.
     */
    public CatalogoCasa guardarCasa(CatalogoCasa casa) {
        return catalogoCasaRepository.save(casa);
    }

    /**
     * Devuelve los detalles de una sola casa por su ID.
     */
    public CatalogoCasa obtenerCasaPorId(Long id) {
        // findById devuelve un Optional, que es una forma segura de manejar
        // la posibilidad de que no se encuentre el objeto.
        return catalogoCasaRepository.findById(id).orElse(null);
    }
}