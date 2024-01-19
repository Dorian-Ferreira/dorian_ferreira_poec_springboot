package fr.dorian_ferreira.exam.service;

import fr.dorian_ferreira.exam.dto.ModelDTO;
import fr.dorian_ferreira.exam.entity.Model;
import fr.dorian_ferreira.exam.exception.NotFoundCentralishException;
import fr.dorian_ferreira.exam.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelService implements DAOServiceInterface<Model> {

    private ModelRepository modelRepository;

    private BrandService brandService;

    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    @Override
    public Model getObjectById(Long id) {
        Optional<Model> optionalModel = modelRepository.findById(id);
        if (optionalModel.isEmpty()) {
            throw new NotFoundCentralishException("Model", "id", id);
        }
        return optionalModel.get();
    }

    public Model persist(ModelDTO modelDTO, Long id) {
        if (id != null && modelRepository.findById(id).isEmpty()) {
            throw new NotFoundCentralishException(
                "Model", "id", id
            );
        }

        Model model = new Model();

        model.setId(id);
        model.setName(modelDTO.getName());
        model.setBrand(brandService.getObjectById(modelDTO.getBrandId()));

        return modelRepository.saveAndFlush(model);
    }

//    public CountryDTO getDTOById(Long id) {
//        Country country = getObjectById(id);
//        CountryDTO dto = new CountryDTO();
//        dto.setName(country.getName());
//        dto.setCode(country.getCode());
//        dto.setNationality(country.getNationality());
//        return dto;
//    }
}
