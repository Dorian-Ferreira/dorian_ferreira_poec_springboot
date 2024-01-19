package fr.dorian_ferreira.exam.controler_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.dorian_ferreira.exam.dto.UserDTO;
import fr.dorian_ferreira.exam.entity.User;
import fr.dorian_ferreira.exam.jsonview.JsonViews;
import fr.dorian_ferreira.exam.mapping.UrlRoute;
import fr.dorian_ferreira.exam.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping
public class UserRestController {

    private UserService userService;

    @GetMapping(UrlRoute.URL_API_USER)
    @JsonView(JsonViews.UserView.class)
    public List<User> list() {
        return this.userService.findAll();
    }

    @GetMapping(UrlRoute.URL_API_USER+"/{id}")
    @JsonView(JsonViews.UserShow.class)
    public User show(@PathVariable Long id) {
        return userService.getObjectById(id);
    }

//    @PostMapping(UrlRoute.URL_API_USER)
//    public User persist(@Valid @RequestBody UserDTO userDTO) {
//        return userService.persist(userDTO, null);
//    }
//
//    @PutMapping(UrlRoute.URL_API_USER+"/{id}")
//    public User persist(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id) {
//        return userService.persist(userDTO, id);
//    }

}