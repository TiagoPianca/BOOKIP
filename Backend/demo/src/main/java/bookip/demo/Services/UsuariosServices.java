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

<<<<<<< HEAD
        @Query(value = "SELECT * FROM usuarios WHERE activo like :activo", nativeQuery = true)
        List<usuarios> buscarusersactivos(@Param("activo") boolean activo);
=======
    @Query(value = "SELECT * FROM usuarios WHERE id like = :id", nativeQuery = true)
    List<usuarios> buscarporid(@Param("id") Long id);
>>>>>>> 11f4dee752058a366361df3e98f368851d5daa68

        @Modifying
        @Transactional
        @Query(value = "UPDATE usuarios SET nivelacceso = :nivelacceso, nombreusuario = :nombreusuario, password = :password, direccioncorreo = :direccioncorreo, activo = :activo  WHERE nombreusuario = :nombreusuario", nativeQuery = true)
        void borrarusuario(@Param("activo") boolean activo);

        @Modifying
        @Transactional
        @Query(value = "UPDATE usuarios SET nivelacceso = :nivelacceso, nombreusuario = :nombreusuario, password = :password, direccioncorreo = :direccioncorreo WHERE nombreusuario = :nombreusuario", nativeQuery = true)
        void modificarusuario(@Param("direccioncorreo") String direccioncorreo,
                        @Param("nivelacceso") boolean nivelacceso,
                        @Param("nombreusuario") String nombreusuario,
                        @Param("password") String password);

}
