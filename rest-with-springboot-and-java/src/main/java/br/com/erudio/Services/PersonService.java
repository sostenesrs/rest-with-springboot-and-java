package br.com.erudio.Services;

import br.com.erudio.Exceptions.ResourceNotFoundException;
import br.com.erudio.Model.Person;
import br.com.erudio.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id) {
        logger.info("Finding by ID!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

    }

    public List<Person> findAll() {
        logger.info("Finding all persons!");

        return repository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");

        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));

        entity.setFirstName(person.getFirstName());
        entity.setLasttName(person.getLasttName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found!"));
        if(entity !=null){
            repository.delete(entity);
        }

    }


}
