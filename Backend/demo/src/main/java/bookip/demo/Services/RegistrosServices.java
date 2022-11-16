package bookip.demo.Services;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bookip.demo.Repository.RegistrosRepository;
import bookip.demo.models.Registros;

@Service
public interface RegistrosServices extends RegistrosRepository {

    List<Registros> findByNombrecliente(String nombrecliente);

    List<Registros> findByNumcliente(String numcliente);

    List<Registros> findByMaccpe(String maccpe);

    List<Registros> findByDireccionip(String direccionip);

    List<Registros> findByActivo(Boolean activo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE registros SET activo = :activo WHERE id = :id", nativeQuery = true)
    void borrarregistro(@Param("id") Integer id, @Param("activo") Boolean activo);


}
