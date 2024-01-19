package fr.dorian_ferreira.exam.controler;

import fr.dorian_ferreira.exam.dto.ListingDTO;
import fr.dorian_ferreira.exam.entity.Listing;
import fr.dorian_ferreira.exam.mapping.UrlRoute;
import fr.dorian_ferreira.exam.service.ListingService;
import fr.dorian_ferreira.exam.service.ModelService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
@AllArgsConstructor
public class ListingController {

    private final ListingService listingService;
    private final ModelService modelService;

    @GetMapping(UrlRoute.URL_LISTING + "/{slug}")
    public ModelAndView show(ModelAndView mav, @PathVariable String slug) {
        Listing listing;
        try {
            listing = listingService.findBySlug(slug);
        } catch (Exception e) {
            mav.setViewName("redirect:/"); // FORCEMENT UN PATH (une URL de route !)
            return mav;
        }
        mav.setViewName("listing/show");
        mav.addObject("listing", listing);
        return mav;
    }

    @PostMapping(UrlRoute.URL_LISTING_FORM)
    public ModelAndView formHandler(
            @Valid @ModelAttribute("listing") ListingDTO listingDTO,
            BindingResult result,
            ModelAndView mav
    ) {
        return formHandle(result, mav, listingDTO);
    }

    @GetMapping(path = UrlRoute.URL_LISTING_FORM, name = "new")
    private ModelAndView create(
            ModelAndView mav,
            HttpServletRequest httpServletRequest
    ) {
        mav.setViewName("listing/form");

        mav.addObject("listing", listingService.getDto());
        mav.addObject("models", modelService.findAll());
        mav.addObject("action", httpServletRequest.getRequestURI());
        return mav;
    }

    private ModelAndView formHandle(
            BindingResult result,
            ModelAndView mav,
            ListingDTO dto
    ) {
        if (result.hasErrors()) {
            mav.setViewName("listing/form");
            mav.addObject("models", modelService.findAll());
            return mav;
        }
        Listing listing = listingService.persist(dto, null);
        mav.setViewName("redirect:/listing/"+listing.getSlug()); // FORCEMENT UN PATH (une URL de route !)
        return mav;
    }
}
