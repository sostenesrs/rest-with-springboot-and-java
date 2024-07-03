package br.com.erudio.Services;

import br.com.erudio.Model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding all Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLasttName("Costa");
        person.setAddress("Uberlandia - MG");
        person.setGender("M");

        return new Person();
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name: " + i);
        person.setLasttName("Last name: " + i);
        person.setAddress("Addres in Brazil: " + i);
        person.setGender("Masculino: " + i);
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating one Person!");

        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one Person!");

        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one Person!");
    }

}
