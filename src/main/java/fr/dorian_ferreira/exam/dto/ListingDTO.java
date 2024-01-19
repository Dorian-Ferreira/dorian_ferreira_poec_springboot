package fr.dorian_ferreira.exam.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListingDTO {

    @NotNull
    private String title;

    @NotNull
    private Long modelId;

    @NotNull
    private Long userId;

    @NotNull
    private String description;

    @NotNull
    private int producedYear;

    @NotNull
    private Long mileage;

    @NotNull
    private Double price;

    private String image;
}

