package bookip.demo.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookip.demo.Repository.Clientes;
import bookip.demo.models.clientes;

@Service
public interface ClientesServices extends Clientes {

        @Query(value = "SELECT * FROM clientes WHERE nombrecliente like :nombrecliente", nativeQuery = true)
        List<clientes> buscarpornombrecliente(@Param("nombrecliente") String nombrecliente);

        @Query(value = "SELECT * FROM clientes WHERE nombreusuario like :nombreusuario", nativeQuery = true)
        List<clientes> buscarporusuario(@Param("nombreusuario") String nombreusuario);

        @Query(value = "SELECT * FROM clientes WHERE ciudad like :ciudadabuscar", nativeQuery = true)
        List<clientes> buscarporciudad(@Param("ciudadabuscar") String ciudadabuscar);

        @Query(value = "SELECT * FROM clientes WHERE activo like :activo", nativeQuery = true)
        List<clientes> buscarclientesactivos(@Param("activo") boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET nombrecliente = :nombrecliente, nombreusuario = :nombreusuario, ciudad = :ciudad, activo = :activo WHERE nombrecliente = :nombrecliente", nativeQuery = true)
        void borrarcliente(@Param("activo") boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET nombrecliente = :nombrecliente, nombreusuario = :nombreusuario, ciudad = :ciudad WHERE nombrecliente = :nombrecliente", nativeQuery = true)
        void modificarcliente(@Param("nombrecliente") String nombrecliente,
                        @Param("nombreusuario") String nombreusuario,
                        @Param("ciudad") String ciudad);

}
