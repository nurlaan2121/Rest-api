package restapi.api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restapi.entities.Developer;
import restapi.service.DeveloperImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dev")
public class DeveloperApi {

    private final DeveloperImpl developerimpl;
    @GetMapping("/getAll")
    public List<Developer> getAll() {
        return developerimpl.getAll();
    }
    @PostMapping("/save")
    public Developer save(@RequestBody Developer developer){
       return developerimpl.save(developer);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteDevById(@PathVariable Long id){
        return developerimpl.deleteById(id);
    }
    @PutMapping("/updateById/{id}")
    public Developer update(@RequestBody Developer developer,@PathVariable Long id){
        return developerimpl.update(developer,id);
    }
    @GetMapping("/findById/{id}")
    public Developer findById(@PathVariable Long id){
        return developerimpl.findById(id);
    }
}
