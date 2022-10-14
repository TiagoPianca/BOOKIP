package bookip.demo.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.usuarios;

public interface UsuariosRepository extends CrudRepository<usuarios, Long> {

}