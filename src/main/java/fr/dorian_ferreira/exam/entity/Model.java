package fr.dorian_ferreira.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.dorian_ferreira.exam.entity.interfaces.SluggerInterface;
import fr.dorian_ferreira.exam.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Model implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(JsonViews.ListingView.class)
    private String name;

    @ManyToOne
    @JsonView(JsonViews.ListingView.class)
    private Brand brand;

    private String slug;

    @Override
    public String getField() {
        return name;
    }
}
