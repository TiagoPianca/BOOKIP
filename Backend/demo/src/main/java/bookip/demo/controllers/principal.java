package bookip.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookip.demo.Repository.RegistrosRepository;
import bookip.demo.Services.*;
import bookip.demo.models.*;
//import bookip.demo.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class principal {

  //
  // LISTADO DE TABLAS(REGISTROS, USUARIOS, CLIENTES) FUNCIONANDO
  //

  @Autowired

  private RegistrosServices RegistrosService;

 

  @GetMapping(path = "listarregistros")
  public Iterable<registros> mostrarregistros() {
    return RegistrosService.findAll();
  }

  @Autowired
  private UsuariosServices UsuariosService;

  @GetMapping(path = "listarusuarios")
  public Iterable<usuarios> mostrarusuarios() {
    return UsuariosService.findAll();

  }

  @Autowired
  private ClientesServices ClientesService;

  @GetMapping(path = "listarclientes")
  public Iterable<clientes> mostrarclientes() {
    return ClientesService.findAll();
  }

  //
  // AGREGAR REGISTROS (REGISTROS, USUARIOS Y CLIENTES) NO FUNCIONA, ERROR 500
  //

  @PostMapping(path = "agregarregistro")
  public String addNewRegistro(@RequestParam String numcliente,
      @RequestParam String nombrecliente, @RequestParam String maccpe, @RequestParam String direccionip,
      @RequestParam Boolean activo) {

    registros agregar = new registros();
    agregar.setNumcliente(numcliente);
    agregar.setNombrecliente(nombrecliente);
    agregar.setMaccpe(maccpe);
    agregar.setDireccionip(direccionip);
    agregar.setActivo(activo);

   RegistrosService.save(agregar);
  // Registrorepository.save(agregar);
    return "Registro guardado exitosamente";
  }


  @PostMapping(path = "agregarusuario")
  public String addNewUser(@RequestParam boolean nivelacceso,
      @RequestParam String nombreusuario, @RequestParam String password, @RequestParam Boolean activo, @RequestParam String direccioncorreo) {

    usuarios agregar = new usuarios();
    agregar.setNombreusuario(nombreusuario);
    agregar.setPassword(password);
    agregar.setNivelacceso(nivelacceso);
    agregar.setDireccioncorreo(direccioncorreo);
    agregar.setActivo(activo = true);

    UsuariosService.save(agregar);
    return "Usuario guardado exitosamente";
  }

  @PostMapping(path = "agregarcliente")
  public String nuevoCliente(@RequestParam String nombrecliente, @RequestParam String nombreusuario,
      @RequestParam String ciudad, @RequestParam Boolean activo) {

    clientes agregar = new clientes();
    agregar.setNombrecliente(nombrecliente);
    agregar.setNombreusuario(nombreusuario);
    agregar.setCiudad(ciudad);
    agregar.setActivo(activo = true);

    ClientesService.save(agregar);
    return "CLiente guardado exitosamente";
  }

  //
  // BUSQUEDAS EN TABLA REGISTROS (BUSCARREGISTROSACTIVOS BUSCA PERO NO MUESTRA NADA )
  //

  @PostMapping(path = "buscarpornombre")
  public List<registros> buscarpornombre(@RequestParam String nombreabuscartemp) {
    String nombreabuscar = "%" + nombreabuscartemp + "%";
    return RegistrosService.buscarpornombre(nombreabuscar);
  }

  @PostMapping(path = "buscarpornumcliente")
  public List<registros> buscarpornumcliente(@RequestParam String numeroabuscartemp) {
    String numabuscar = "%" + numeroabuscartemp + "%";
    return RegistrosService.buscarpornumcliente(numabuscar);
  }

  @PostMapping(path = "buscarporip")
  public List<registros> buscarporip(@RequestParam String ipabuscartemp) {
    String ipabuscar = "%" + ipabuscartemp + "%";
    return RegistrosService.buscarporip(ipabuscar);
  }

  @PostMapping(path = "buscarpormac")
  public List<registros> buscarpormac(@RequestParam String macabuscartemp) {
    String macabuscar = "%" + macabuscartemp + "%";
    return RegistrosService.buscarpormac(macabuscar);
  }

  @PostMapping(path = "buscarregistrosactivos")
  public List<registros> buscarregistrosactivos(@RequestParam Boolean regactivos) {
    Boolean activosabuscar = regactivos;
    return RegistrosService.buscarregistrosactivos(activosabuscar);
  }

  //
  // BUSCAR EN TABLA USUARIOS(BUSCARUSERSACTIVOS BUSCA PERO NO MUESTRA)
  //

  @PostMapping(path = "buscarpornombreusuario")
  public List<usuarios> buscarpornombreusuario(@RequestParam String usuariotemp) {
    String usuarioabuscar = "%" + usuariotemp + "%";
    return UsuariosService.buscarpornombreusuario(usuarioabuscar);
  }

  @PostMapping(path = "buscarusersactivos")
  public List<usuarios> buscarusersactivos(@RequestParam Boolean usersactivo) {
    Boolean activosabuscar = usersactivo;
    return UsuariosService.buscarusersactivos(activosabuscar);
  }

  //
  // BUSCAR EN TABLA CLIENTES (BUSCARCLIENTESACTIVOS BUSCA PERO NO MUESTRA)
  //

  @PostMapping(path = "buscarclientes")
  public List<clientes> buscarcliente(@RequestParam String nombreclientetemp) {
    String clienteabuscar = "%" + nombreclientetemp + "%";
    return ClientesService.buscarpornombrecliente(clienteabuscar);
  }

  @PostMapping(path = "buscarporciudad")
  public List<clientes> buscarciudad(@RequestParam String ciudadtemp) {
    String ciudadabuscar = "%" + ciudadtemp + "%";
    return ClientesService.buscarporciudad(ciudadabuscar);
  }

  @PostMapping(path = "buscarclientesactivos")
  public List<clientes> buscarclientesactivos(@RequestParam Boolean clienteactivo) {
    Boolean clienteabuscar = clienteactivo;
    return ClientesService.buscarclientesactivos(clienteabuscar);
  }

  //
  // LOGIN(SIN UTILIZAR POR EL MOMENTO)
  //
/*
  @PostMapping(path = "login")
  public List<usuarios> login(@RequestParam String nombreusuario, String password) {
    return UsuariosService.login(nombreusuario, password);
  }
 */
  //
  // ELIMINAR REGISTROS, USUARIOS Y CLIENTES (ERROR 500)
  //

  @PostMapping(path = "borrarregistro")
  public ResponseEntity<Integer> borrarregistro(@RequestParam Integer id, @RequestParam Boolean activo) {
    if (id instanceof Integer) {

      RegistrosService.borrarregistro(id,activo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

  @PostMapping(path = "borrarusuario")
  public ResponseEntity<String> borrarusuario(@RequestParam String nombreusuario, Boolean activo) {
    if (nombreusuario instanceof String) {

      UsuariosService.borrarusuario(nombreusuario, activo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "borrarcliente")
  public ResponseEntity<String> borrarcliente(@RequestParam String nombrecliente, Boolean activo) {
    if(nombrecliente instanceof String) {

      ClientesService.borrarcliente(nombrecliente, activo);
      return new ResponseEntity<>(HttpStatus.OK);
    }else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  //
  // MODIFICACION DE REGISTROS, USUARIOS Y CLIENTES
  //

  @PostMapping(path = "modificarregistro")
  public ResponseEntity<Long> modificarregistro(@RequestParam Integer id, String numcliente, String nombrecliente,
      String maccpe, String direccionip) {
    if (id instanceof Integer) {

      RegistrosService.modificarregistro(id, numcliente, nombrecliente, maccpe, direccionip);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "modificarusuario")
  public ResponseEntity<String> modificarusuario(@RequestParam Boolean nivelacceso, String nombreusuario,
      String password, @RequestParam String direccioncorreo) {
    if (nombreusuario instanceof String) {

      UsuariosService.modificarusuario(nivelacceso, nombreusuario, password, direccioncorreo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "modificarcliente")
  public ResponseEntity<String> modificarcliente(@RequestParam String nombrecliente, String nombreusuario,
    String ciudad) {
      if(nombrecliente instanceof String) {

        ClientesService.modificarcliente(nombrecliente, nombreusuario, ciudad);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

}
