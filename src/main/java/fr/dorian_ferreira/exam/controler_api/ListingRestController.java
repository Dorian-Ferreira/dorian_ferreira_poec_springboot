package fr.dorian_ferreira.exam.controler_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.dorian_ferreira.exam.dto.ListingDTO;
import fr.dorian_ferreira.exam.dto.ModelDTO;
import fr.dorian_ferreira.exam.entity.Listing;
import fr.dorian_ferreira.exam.entity.Model;
import fr.dorian_ferreira.exam.jsonview.JsonViews;
import fr.dorian_ferreira.exam.mapping.UrlRoute;
import fr.dorian_ferreira.exam.service.ListingService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping
public class ListingRestController {

    private ListingService listingService;

    @GetMapping(UrlRoute.URL_API_LISTING)
    @JsonView(JsonViews.ListingView.class)
    public List<Listing> list() {
        return this.listingService.findAll();
    }

    @GetMapping(path = UrlRoute.URL_API_LISTING+"/{id}")
    @JsonView(JsonViews.ListingShow.class)
    public Listing show(@PathVariable Long id) {
        return listingService.getObjectById(id);
    }

    @PostMapping(UrlRoute.URL_API_LISTING)
    @JsonView(JsonViews.ListingShow.class)
    public Listing persist(@Valid @RequestBody ListingDTO listingDTO) {
        return listingService.persist(listingDTO, null);
    }

    @PutMapping(UrlRoute.URL_API_LISTING+"/{id}")
    @JsonView(JsonViews.ListingShow.class)
    public Listing persist(@Valid @RequestBody ListingDTO listingDTO, @PathVariable Long id) {
        return listingService.persist(listingDTO, id);
    }

}