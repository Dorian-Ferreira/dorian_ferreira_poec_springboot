package fr.dorian_ferreira.exam.repository;

import java.util.Optional;

public interface EntitySlugRepository<T> {

    Optional<T> findBySlug(String slug);

}
