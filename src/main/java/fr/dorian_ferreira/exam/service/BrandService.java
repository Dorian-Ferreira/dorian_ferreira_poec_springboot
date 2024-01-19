package fr.dorian_ferreira.exam.service;

import fr.dorian_ferreira.exam.dto.BrandDTO;
import fr.dorian_ferreira.exam.entity.Brand;
import fr.dorian_ferreira.exam.exception.NotFoundCentralishException;
import fr.dorian_ferreira.exam.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandService implements DAOServiceInterface<Brand> {

    private BrandRepository brandRepository;

    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getObjectById(Long id) {
        Optional<Brand> optionalBrand = brandRepository.findById(id);
        if (optionalBrand.isEmpty()) {
            throw new NotFoundCentralishException("Brand", "id", id);
        }
        return optionalBrand.get();
    }

    public Brand persist(BrandDTO brandDTO, Long id) {
        if (id != null && brandRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                "Brand", "id", id
            );
        }

        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(brandDTO.getName());

        return brandRepository.saveAndFlush(brand);
    }
}
