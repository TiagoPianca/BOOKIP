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
 
@Query (value = "SELECT * FROM registros WHERE NombreCliente like :nombreabuscar", nativeQuery = true)
List<registros> buscarpornombre(@Param("nombreabuscar") String nombreabuscar); 

@Query (value = "SELECT * FROM registros WHERE NumeroCliente like :numeroabuscar", nativeQuery = true)
List<registros> buscarpornumerocliente(@Param("numeroabuscar") String numeroabuscar);

@Query (value = "SELECT * FROM registros WHERE MacCpe like :macabuscar", nativeQuery = true)
List<registros> buscarpormac(@Param("macabuscar") String macabuscar); 

@Query (value = "SELECT * FROM registros WHERE DireccionIP like :ipabuscar", nativeQuery = true)
List<registros> buscarporip(@Param("ipabuscar") String ipabuscar) ;

@Modifying
@Transactional
@Query (value = "DELETE FROM registros WHERE ID =:id", nativeQuery = true)
void borrarregistro(@Param("id") Long id);

@Modifying
@Transactional
@Query (value = "UPDATE registros SET NumeroCliente = :numerocliente, NombreCliente = :nombrecliente, MacCpe = :maccpe, DireccionIP = :direccionip WHERE ID = :id", nativeQuery = true)
void modificarregistro(@Param("id") Long id, @Param("numerocliente") int numerocliente, @Param("nombrecliente") String nombrecliente, @Param("maccpe") String maccpe, @Param("direccionip") String direccionip);

} 


