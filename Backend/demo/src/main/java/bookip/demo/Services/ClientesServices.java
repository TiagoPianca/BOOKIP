package bookip.demo.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookip.demo.Repository.ClientesRepository;
import bookip.demo.models.Clientes;

@Service
public interface ClientesServices extends ClientesRepository {

        List<Clientes> findByNombrecliente(String nombrecliente);

        // List<Clientes> findByNombreusuario(String nombreusuario);

        List<Clientes> findByCiudad(String ciudad);

        List<Clientes> findByActivo(Boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET activo = :activo WHERE nombrecliente = :nombrecliente", nativeQuery = true)
        void borrarcliente(@Param("nombrecliente") String nombrecliente, @Param("activo") Boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET nombrecliente = :nombrecliente, nombreusuario = :nombreusuario, ciudad = :ciudad, activo = :activo WHERE nombrecliente = :nombrecliente", nativeQuery = true)
        void modificarcliente(@Param("nombrecliente") String nombrecliente,
                        @Param("nombreusuario") String nombreusuario,
                        @Param("ciudad") String ciudad, @Param("activo") Boolean activo);

}
