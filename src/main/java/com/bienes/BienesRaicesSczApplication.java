package com.bienes.bienesraicesscz;

import com.bienes.bienesraicesscz.model.CatalogoCasa;
import com.bienes.bienesraicesscz.repository.CatalogoCasaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BienesRaicesSczApplication {

	public static void main(String[] args) {
		SpringApplication.run(BienesRaicesSczApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CatalogoCasaRepository repository) {
		return args -> {
			if (repository.count() == 0) {
				System.out.println("Poblando la base de datos con URLs de imágenes estables...");

				// --- LISTA DE IMÁGENES ESTABLES (PEXELS) ---
				List<String> ventaUrls = Arrays.asList(
						"https://images.pexels.com/photos/106399/pexels-photo-106399.jpeg",
						"https://images.pexels.com/photos/323780/pexels-photo-323780.jpeg",
						"https://images.pexels.com/photos/1396122/pexels-photo-1396122.jpeg",
						"https://images.pexels.com/photos/209296/pexels-photo-209296.jpeg",
						"https://images.pexels.com/photos/259588/pexels-photo-259588.jpeg",
						"https://images.pexels.com/photos/210617/pexels-photo-210617.jpeg",
						"https://images.pexels.com/photos/164558/pexels-photo-164558.jpeg",
						"https://images.pexels.com/photos/208736/pexels-photo-208736.jpeg",
						"https://images.pexels.com/photos/276724/pexels-photo-276724.jpeg",
						"https://images.pexels.com/photos/221540/pexels-photo-221540.jpeg"
				);

				List<String> alquilerUrls = Arrays.asList(
						"https://images.pexels.com/photos/271624/pexels-photo-271624.jpeg",
						"https://images.pexels.com/photos/1571460/pexels-photo-1571460.jpeg",
						"https://images.pexels.com/photos/2635038/pexels-photo-2635038.jpeg",
						"https://images.pexels.com/photos/275484/pexels-photo-275484.jpeg",
						"https://images.pexels.com/photos/1457842/pexels-photo-1457842.jpeg",
						"https://images.pexels.com/photos/271816/pexels-photo-271816.jpeg",
						"https://images.pexels.com/photos/1643383/pexels-photo-1643383.jpeg",
						"https://images.pexels.com/photos/1918291/pexels-photo-1918291.jpeg",
						"https://images.pexels.com/photos/2724749/pexels-photo-2724749.jpeg",
						"https://images.pexels.com/photos/1080721/pexels-photo-1080721.jpeg",
						"https://images.pexels.com/photos/1329711/pexels-photo-1329711.jpeg",
						"https://images.pexels.com/photos/269077/pexels-photo-269077.jpeg",
						"https://images.pexels.com/photos/277667/pexels-photo-277667.jpeg",
						"https://images.pexels.com/photos/439227/pexels-photo-439227.jpeg",
						"https://images.pexels.com/photos/2089698/pexels-photo-2089698.jpeg"
				);

				List<String> anticreticoUrls = Arrays.asList(
						"https://images.pexels.com/photos/206172/pexels-photo-206172.jpeg",
						"https://images.pexels.com/photos/1115804/pexels-photo-1115804.jpeg",
						"https://images.pexels.com/photos/280229/pexels-photo-280229.jpeg"
				);

				// El resto del código para crear las casas se mantiene igual...
				for (int i = 0; i < 10; i++) {
					CatalogoCasa casa = new CatalogoCasa();
					casa.setTipo("VENTA");
					casa.setImagenUrl(ventaUrls.get(i));
					casa.setTitulo("Casa en Venta en Zona Norte #" + (i + 1));
					casa.setDireccion("Barrio Equipetrol, Calle " + (i + 1));
					casa.setHabitaciones(3); casa.setBanos(2);
					casa.setSuperficie(150.0 + i * 5);
					casa.setPrecio(new BigDecimal(120000 + i * 5000));
					casa.setDescripcion("Una hermosa casa ideal para familias, con amplio jardín y cerca de parques.");
					repository.save(casa);
				}

				for (int i = 0; i < 15; i++) {
					CatalogoCasa casa = new CatalogoCasa();
					casa.setTipo("ALQUILER");
					casa.setImagenUrl(alquilerUrls.get(i));
					casa.setTitulo("Departamento en Alquiler en el Centro #" + (i + 1));
					casa.setDireccion("Av. Monseñor Rivero, Edificio " + (i + 1));
					casa.setHabitaciones(2); casa.setBanos(1);
					casa.setSuperficie(80.0 + i * 2);
					casa.setPrecio(new BigDecimal(500 + i * 20));
					casa.setDescripcion("Moderno departamento con excelente ubicación, ideal para estudiantes o parejas.");
					repository.save(casa);
				}

				for (int i = 0; i < 3; i++) {
					CatalogoCasa casa = new CatalogoCasa();
					casa.setTipo("ANTICRETICO");
					casa.setImagenUrl(anticreticoUrls.get(i));
					casa.setTitulo("Casa en Anticrético por la UAGRM #" + (i + 1));
					casa.setDireccion("Zona Oeste, a pasos de la universidad");
					casa.setHabitaciones(4); casa.setBanos(3);
					casa.setSuperficie(200.0);
					casa.setPrecio(new BigDecimal(35000 + i * 1000));
					casa.setDescripcion("Amplia casa en anticrético, perfecta para una familia grande. Incluye garaje.");
					repository.save(casa);
				}
			}
		};
	}
}