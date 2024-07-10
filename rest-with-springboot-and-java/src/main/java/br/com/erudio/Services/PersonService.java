package br.com.erudio.Services;

import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.Dto.PersonDTO;
import br.com.erudio.Mapper.DozerMapper;
import br.com.erudio.Model.Person;
import br.com.erudio.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public PersonDTO findById(Long id) {
        logger.info("Finding by ID!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        return DozerMapper.parseObject(entity, PersonDTO.class);

    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all persons!");

        return DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO person) {
        logger.info("Creating one Person!");

        var entity = DozerMapper.parseObject(person, Person.class);

        var dto = repository.save(entity);

        return DozerMapper.parseObject(dto, PersonDTO.class);
    }

    public PersonDTO update(PersonDTO person) {
        logger.info("Updating one Person!");

        var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto = repository.save(entity);

        return DozerMapper.parseObject(dto, PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        if(entity !=null){
            repository.delete(entity);
        }

    }


}
