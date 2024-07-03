package br.com.erudio.Controller;

import br.com.erudio.Model.Person;
import br.com.erudio.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired //injeção de dependencia para não precisar instanciar a service
    private PersonService personService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable String id) {

        return personService.findById(id);

    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {

        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {

        return personService.create(person);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person udpate(@RequestBody Person person) {

        return personService.update(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void udpate(@PathVariable(value = "id") String id) {

        personService.delete(id);
    }

}
