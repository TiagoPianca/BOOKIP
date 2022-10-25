package bookip.demo.Repository;


import org.springframework.data.repository.CrudRepository;

import bookip.demo.models.Clientes;

public interface ClientesRepository extends CrudRepository<Clientes, Long> {
}
//Utiliza CrudRepository para la base de datos
