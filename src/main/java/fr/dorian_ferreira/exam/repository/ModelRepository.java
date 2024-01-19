package fr.dorian_ferreira.exam.repository;

import fr.dorian_ferreira.exam.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository
        extends JpaRepository<Model, Long>,
                EntityNameRepository<Model>,
                EntitySlugRepository<Model>
{

}