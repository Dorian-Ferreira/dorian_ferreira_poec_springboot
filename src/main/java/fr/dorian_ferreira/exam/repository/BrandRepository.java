package fr.dorian_ferreira.exam.repository;

import fr.dorian_ferreira.exam.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandRepository
        extends JpaRepository<Brand, Long>,
                EntityNameRepository<Brand>,
                EntitySlugRepository<Brand>
{

}