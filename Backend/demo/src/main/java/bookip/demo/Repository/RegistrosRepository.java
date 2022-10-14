package bookip.demo.Repository;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.registros;

public interface RegistrosRepository extends CrudRepository<registros, Integer> {

}
