package fr.dorian_ferreira.exam.repository;

import fr.dorian_ferreira.exam.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository
        extends JpaRepository<Listing, Long>,
                EntitySlugRepository<Listing>
{

}