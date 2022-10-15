package bookip.demo.Repository;

//import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.Registros;

public interface RegistrosRepository extends CrudRepository<Registros, Integer> {

}
