package fr.dorian_ferreira.exam.service;

import fr.dorian_ferreira.exam.dto.ListingDTO;
import fr.dorian_ferreira.exam.entity.Listing;
import fr.dorian_ferreira.exam.exception.NotFoundCentralishException;
import fr.dorian_ferreira.exam.repository.ListingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListingService implements DAOServiceInterface<Listing> {

    private ListingRepository listingRepository;

    private ModelService modelService;
    private UserService userService;

    public List<Listing> findAll() {
        return listingRepository.findAll();
    }

    @Override
    public Listing getObjectById(Long id) {
        Optional<Listing> optionalListing = listingRepository.findById(id);
        if (optionalListing.isEmpty()) {
            throw new NotFoundCentralishException("Listing", "id", id);
        }
        return optionalListing.get();
    }

    public Listing findBySlug(String slug) {
        Optional<Listing> optionalListing = listingRepository.findBySlug(slug);
        if (optionalListing.isEmpty()) {
            throw new NotFoundCentralishException("Listing", "slug", slug);
        }
        return optionalListing.get();
    }

    public Listing persist(ListingDTO listingDTO, Long id) {
        if (id != null && listingRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                "Listing", "id", id
            );
        }

        Listing listing = new Listing();

        listing.setId(id);
        listing.setTitle(listingDTO.getTitle());
        listing.setDescription(listingDTO.getDescription());
        listing.setImage(listingDTO.getImage());
        listing.setPrice(listingDTO.getPrice());
        listing.setMileage(listingDTO.getMileage());
        listing.setProducedYear(listingDTO.getProducedYear());
        listing.setModel(modelService.getObjectById(listingDTO.getModelId()));
        listing.setUser(userService.getObjectById(listingDTO.getUserId()));
        listing.setCreatedAt(new Date());

        return listingRepository.saveAndFlush(listing);
    }

    public List<Listing> findLast12() {
        return listingRepository.findTop12ByOrderByCreatedAtDesc();
    }

    public ListingDTO getDto() {
        ListingDTO listingDTO = new ListingDTO();

        listingDTO.setUserId(getRandomBetween(1, 1800));

        return listingDTO;
    }

    public static long getRandomBetween(int min, int max) {
        return (long)Math.floor((Math.random() * (max - min)) + min);
    }
}
