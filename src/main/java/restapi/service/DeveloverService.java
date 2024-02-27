package restapi.service;

import restapi.entities.Developer;

import java.util.List;

public interface DeveloverService {
    List<Developer> getAll();

    Developer save(Developer developer);

    String deleteById(Long id);

    Developer update(Developer developer, Long id);

    Developer findById(Long id);
}
