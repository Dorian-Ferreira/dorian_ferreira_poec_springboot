package fr.dorian_ferreira.exam.controler_api;

import fr.dorian_ferreira.exam.dto.BrandDTO;
import fr.dorian_ferreira.exam.dto.ModelDTO;
import fr.dorian_ferreira.exam.entity.Brand;
import fr.dorian_ferreira.exam.entity.Model;
import fr.dorian_ferreira.exam.mapping.UrlRoute;
import fr.dorian_ferreira.exam.service.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping
public class BrandRestController {

    private BrandService brandService;

    @GetMapping(UrlRoute.URL_API_BRAND)
    public List<Brand> list() {
        return this.brandService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_API_BRAND + "/{id}")
    public Brand show(@PathVariable Long id) {
        return brandService.getObjectById(id);
    }

    @PostMapping(UrlRoute.URL_API_BRAND)
    public Brand persist(@Valid @RequestBody BrandDTO brandDTO) {
        return brandService.persist(brandDTO, null);
    }

    @PutMapping(UrlRoute.URL_API_BRAND + "/{id}")
    public Brand persist(@Valid @RequestBody BrandDTO brandDTO, @PathVariable Long id) {
        return brandService.persist(brandDTO, id);
    }

}