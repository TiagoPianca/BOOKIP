package bookip.demo.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.clientes;

public interface Clientes extends CrudRepository<clientes, Long> {
    
}
