package bookip.demo.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import bookip.demo.Repository.UsuariosRepository;
import bookip.demo.models.usuarios;

@Service
public interface UsuariosServices extends UsuariosRepository {
    @Query(value = "SELECT * FROM usuarios WHERE nombreusuario like :nombreusuario AND password like :password", nativeQuery = true)
    List<usuarios> login(@Param("nombreusuario") String nombreusuario, @Param("password") String password);

    @Query(value = "SELECT * FROM usuarios WHERE nombreusuario like :nombreusuario", nativeQuery = true)
    List<usuarios> buscarpornombreusuario(@Param("nombreusuario") String nombreusuario);

    @Query(value = "SELECT * FROM usuarios WHERE activo like :activo", nativeQuery = true)
    List<usuarios> buscarusersactivos(@Param("activo") Boolean activo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nivelacceso = :nivelacceso, nombreusuario = :nombreusuario, password = :password, activo = :activo, direccioncorreo = :direccioncorreo WHERE nombrecliente = :nombrecliente", nativeQuery = true)
    void borrarusuario(@Param("nombreusuario") String nombreusuario,@Param("activo") Boolean activo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nivelacceso = :nivelacceso, nombreusuario = :nombreusuario, password = :password, activo = :activo, direccioncorreo = :direccioncorreo WHERE nombreusuario = :nombreusuario", nativeQuery = true)
    void modificarusuario(@Param("nivelacceso") Boolean nivelacceso,
            @Param("nombreusuario") String nombreusuario, @Param("password") String password, @Param("direccioncorreo") String direccioncorreo);

}
