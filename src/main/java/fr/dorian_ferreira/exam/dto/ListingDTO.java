package fr.dorian_ferreira.exam.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ListingDTO {

    @NotBlank
    private String title;

    @NotNull
    private Long modelId;

    @NotNull
    private Long userId;

    @NotBlank
    private String description;

    @NotNull
    private int producedYear;

    @NotNull
    private Long mileage;

    @NotNull
    private Double price;

    private String image;
}

