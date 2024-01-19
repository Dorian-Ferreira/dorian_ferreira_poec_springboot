package fr.dorian_ferreira.exam.controler_api;

import fr.dorian_ferreira.exam.dto.ModelDTO;
import fr.dorian_ferreira.exam.dto.UserDTO;
import fr.dorian_ferreira.exam.entity.Model;
import fr.dorian_ferreira.exam.entity.User;
import fr.dorian_ferreira.exam.mapping.UrlRoute;
import fr.dorian_ferreira.exam.service.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping
public class ModelRestController {

    private ModelService modelService;

    @GetMapping(UrlRoute.URL_API_MODEL)
    public List<Model> list() {
        return this.modelService.findAll();
    }

    @GetMapping(UrlRoute.URL_API_MODEL+"/{id}")
    public Model show(@PathVariable Long id) {
        return modelService.getObjectById(id);
    }

    @PostMapping(UrlRoute.URL_API_MODEL)
    public Model persist(@Valid @RequestBody ModelDTO modelDTO) {
        return modelService.persist(modelDTO, null);
    }

    @PutMapping(UrlRoute.URL_API_MODEL+"/{id}")
    public Model persist(@Valid @RequestBody ModelDTO modelDTO, @PathVariable Long id) {
        return modelService.persist(modelDTO, id);
    }

}