package restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import restapi.entities.Developer;

public interface DeveloperRepoInterface extends JpaRepository<Developer,Long> {
    @Query("select d from Developer d where d.id = :id")
    Developer findByIdMeniki(Long id);

}
