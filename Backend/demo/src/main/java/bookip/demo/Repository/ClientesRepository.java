package bookip.demo.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.clientes;
//import java.util.List;

public interface ClientesRepository extends CrudRepository<clientes, Long> {

}
