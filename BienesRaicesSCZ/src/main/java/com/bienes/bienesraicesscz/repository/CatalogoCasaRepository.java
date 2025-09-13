package com.bienes.bienesraicesscz.repository;

import com.bienes.bienesraicesscz.model.CatalogoCasa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoCasaRepository extends JpaRepository<CatalogoCasa, Long> {
}