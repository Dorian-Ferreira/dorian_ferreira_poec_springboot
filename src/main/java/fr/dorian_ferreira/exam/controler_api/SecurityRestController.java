package fr.dorian_ferreira.exam.controler_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.dorian_ferreira.exam.custom_response.JwtTokenResponse;
import fr.dorian_ferreira.exam.dto.UserDTO;
import fr.dorian_ferreira.exam.entity.User;
import fr.dorian_ferreira.exam.jsonview.JsonViews;
import fr.dorian_ferreira.exam.mapping.UrlRoute;
import fr.dorian_ferreira.exam.service.UserService;
import fr.dorian_ferreira.exam.service.security.JwtAuthenticationService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@AllArgsConstructor
public class SecurityRestController {

    private UserService userService;

    private JwtAuthenticationService jwtAuthenticationService;

    @PostMapping(UrlRoute.URL_API_REGISTER)
    @JsonView(JsonViews.UserShow.class)
    public User create(@Valid @RequestBody UserDTO userDTO) {
        return userService.persist(userDTO, null);
    }

    @PostMapping(UrlRoute.URL_API_LOGIN)
    public ResponseEntity<JwtTokenResponse> login(@Valid @RequestBody UserDTO userLoginDTO) {
        return jwtAuthenticationService.authenticate(userLoginDTO);
    }

}
