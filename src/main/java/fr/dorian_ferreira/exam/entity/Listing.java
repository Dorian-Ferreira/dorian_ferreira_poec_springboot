package fr.dorian_ferreira.exam.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.dorian_ferreira.exam.entity.interfaces.SluggerInterface;
import fr.dorian_ferreira.exam.jsonview.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Listing implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(JsonViews.ListingView.class)
    private Date createdAt;

    @JsonView(JsonViews.ListingView.class)
    private String title;

    @JsonView(JsonViews.ListingShow.class)
    private String description;

    @JsonView(JsonViews.ListingView.class)
    private int producedYear;

    @JsonView(JsonViews.ListingView.class)
    private Long mileage;

    @JsonView(JsonViews.ListingView.class)
    private Double price;

    private String image;

    @ManyToOne
    @JsonView(JsonViews.ListingShow.class)
    private User user;

    @ManyToOne
    @JsonView(JsonViews.ListingView.class)
    private Model model;

    private String slug;

    @Override
    public String getField() {
        return "vente-" + model.getBrand().getName() + "-" + model.getName() + "-" + producedYear + "-" + mileage;
    }
}
