package fr.dorian_ferreira.exam.controler;

import fr.dorian_ferreira.exam.service.ListingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/", name = "AppHome")
@AllArgsConstructor
public class HomeController {

    private ListingService listingService;

    @GetMapping(name = "index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("listings", listingService.findLast12());
        return mav;
    }

}
