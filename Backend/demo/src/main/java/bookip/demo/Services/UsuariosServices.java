package bookip.demo.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import bookip.demo.Repository.Usuarios;
import bookip.demo.models.usuarios;

@Service
public interface UsuariosServices extends Usuarios {
    @Query(value = "SELECT * FROM usuarios WHERE nombreusuario like :nombreusuario AND password like :password", nativeQuery = true)
    List<usuarios> login(@Param("nombreusuario") String nombreusuario, @Param("password") String password);

    @Query(value = "SELECT * FROM usuarios WHERE nombreusuario like :nombreusuario", nativeQuery = true)
    List<usuarios> buscarpornombreusuario(@Param("nombreusuario") String nombreusuario);

    @Query(value = "SELECT * FROM usuarios WHERE id like = :id", nativeQuery = true)
    List<usuarios> buscarusuarioporid(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM usuarios WHERE id =:id", nativeQuery = true)
    void borrarusuario(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE usuarios SET nivelacceso = :nivelacceso, nombreusuario = :nombreusuario, password = :password WHERE id = :id", nativeQuery = true)
    void modificarusuario(@Param("id") Long id, @Param("nivelacceso") boolean nivelacceso,
            @Param("nombreusuario") String nombreusuario, @Param("password") String password);

}
