package bookip.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.Registros;

public interface RegistrosRepository extends CrudRepository<Registros, Integer> {
}
//Utiliza CrudRepository para la base de datos