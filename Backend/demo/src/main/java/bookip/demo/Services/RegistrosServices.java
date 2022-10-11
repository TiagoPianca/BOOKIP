package bookip.demo.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bookip.demo.Repository.Registros;
import bookip.demo.models.registros;

@Service
public interface RegistrosServices extends Registros {

    @Query(value = "SELECT * FROM registros WHERE nombrecliente like :nombreabuscar", nativeQuery = true)
    List<registros> buscarpornombre(@Param("nombreabuscar") String nombreabuscar);

    @Query(value = "SELECT * FROM registros WHERE numcliente like :numabuscar", nativeQuery = true)
    List<registros> buscarpornumcliente(@Param("numabuscar") String numabuscar);

    @Query(value = "SELECT * FROM registros WHERE maccpe like :macabuscar", nativeQuery = true)
    List<registros> buscarpormac(@Param("macabuscar") String macabuscar);

    @Query(value = "SELECT * FROM registros WHERE direccionip like :ipabuscar", nativeQuery = true)
    List<registros> buscarporip(@Param("ipabuscar") String ipabuscar);

    @Query(value = "SELECT * FROM registros WHERE activo like :activo", nativeQuery = true)
    List<registros> buscarregistrosactivos(@Param("activo") Boolean activo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE registros SET numcliente = :numcliente, nombrecliente = :nombrecliente, maccpe = :maccpe, direccionip = :direccionip, activo = :activo WHERE id = :id", nativeQuery = true)
    void borrarregistro(@Param("id") Integer id, @Param("activo") Boolean activo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE registros SET numcliente = :numcliente, nombrecliente = :nombrecliente, maccpe = :maccpe, direccionip = :direccionip WHERE id = :id", nativeQuery = true)
    void modificarregistro(@Param("id") Long id, @Param("numcliente") String numcliente,
            @Param("nombrecliente") String nombrecliente, @Param("maccpe") String maccpe,
            @Param("direccionip") String direccionip);

}
