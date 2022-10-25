package bookip.demo.Repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.Usuarios;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {
    
}
//Utiliza CrudRepository para la base de datos