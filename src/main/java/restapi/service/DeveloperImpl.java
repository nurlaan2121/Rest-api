package restapi.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.entities.Developer;
import restapi.repo.DeveloperRepoInterface;

import java.beans.Transient;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DeveloperImpl implements DeveloverService {
    private final DeveloperRepoInterface developerRepoInterface;

    @Override
    public List<Developer> getAll() {
        return developerRepoInterface.findAll();
    }

    @Override
    public Developer save(Developer developer) {
        return developerRepoInterface.save(developer);
    }

    @Override
    public String deleteById(Long id) {
        Developer developer = developerRepoInterface.findById(id).orElse(null);
        if (developer != null) {
            developerRepoInterface.deleteById(id);
            return "Success";
        }
        return "Not found";
    }
    @Override @Transactional
    public Developer update(Developer developer, Long id) {
        Developer developer1 = developerRepoInterface.findById(id).orElse(null);
        if (developer1!=null) {
            developer1.setUpdated(developer.getUpdated());
            developer1.setSalary(developer.getSalary());
            developer1.setEmail(developer.getEmail());
            developer1.setFullName(developer.getFullName());
            return developer1;
        }
        return null;
    }

    @Override
    public Developer findById(Long id) {
        return developerRepoInterface.findByIdMeniki(id);
    }
}
