package fr.dorian_ferreira.exam.service;

import fr.dorian_ferreira.exam.configuration.PasswordEncoderConfig;
import fr.dorian_ferreira.exam.dto.UserDTO;
import fr.dorian_ferreira.exam.entity.User;
import fr.dorian_ferreira.exam.exception.NotFoundCentralishException;
import fr.dorian_ferreira.exam.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class UserService implements DAOServiceInterface<User>, UserDetailsService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getObjectById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new NotFoundCentralishException("User", "id", id);
        }
        return optionalUser.get();
    }

    public User persist(UserDTO userDTO, Long id) {
        if (id != null && userRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                "User", "id", id
            );
        }

        User user = new User();
        user.setId(id);

        user.setEmail(userDTO.getEmail());
        user.setRoles("[]");
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setCreatedAt(new Date());

        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User user = optionalUser.get();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                userGrantedAuthority(user.getRoles())
        );
    }

    private List<GrantedAuthority> userGrantedAuthority(String role) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> roles = Collections.singletonList(role);
        roles.forEach(r -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            if (r.contains("ADMIN")) {
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            }
        });
        return authorities;
    }
}
