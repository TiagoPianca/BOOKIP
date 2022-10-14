package bookip.demo.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookip.demo.Repository.ClientesRepository;
import bookip.demo.models.clientes;

@Service
public interface ClientesServices extends ClientesRepository {

        @Query(value = "SELECT * FROM clientes WHERE nombrecliente like :nombrecliente", nativeQuery = true)
        List<clientes> buscarpornombrecliente(@Param("nombrecliente") String nombrecliente);

        @Query(value = "SELECT * FROM clientes WHERE nombreusuario like :nombreusuario", nativeQuery = true)
        List<clientes> buscarporusuario(@Param("nombreusuario") String nombreusuario);

        @Query(value = "SELECT * FROM clientes WHERE ciudad like :ciudad", nativeQuery = true)
        List<clientes> buscarporciudad(@Param("ciudad") String ciudad);

        @Query(value = "SELECT * FROM clientes WHERE activo like :activo", nativeQuery = true)
        List<clientes> buscarclientesactivos(@Param("activo") Boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET nombrecliente = :nombrecliente, nombreusuario = :nombreusuario, ciudad = :ciudad, activo = :activo WHERE nombrecliente = :nombrecliente", nativeQuery = true)
        void borrarcliente(@Param("nombrecliente") String nombrecliente, @Param("activo") Boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE clientes SET nombrecliente = :nombrecliente, nombreusuario = :nombreusuario, ciudad = :ciudad WHERE nombrecliente = :nombrecliente", nativeQuery = true)
        void modificarcliente(@Param("nombrecliente") String nombrecliente,
                        @Param("nombreusuario") String nombreusuario,
                        @Param("ciudad") String ciudad);

}
