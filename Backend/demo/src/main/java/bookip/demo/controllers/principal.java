package bookip.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bookip.demo.Services.*;
import bookip.demo.models.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class principal {

  //
  //LISTADO DE TABLAS(REGISTROS, USUARIOS, CLIENTES)
  //

  @Autowired

  private RegistrosServices RegistrosRepo;

  @GetMapping(path = "listarregistros")
  public List<registros> mostrarregistros() {
    return RegistrosRepo.findAll();
  }

  @Autowired
  private UsuariosServices UsuariosRepo;

  @GetMapping(path = "listarusuarios")
  public Iterable<usuarios> mostrarusuarios() {
    return UsuariosRepo.findAll();

  }

  //
  // ADD EN REGISTROS, USUARIOS Y CLIENTES
  //

  @Autowired
  private RegistrosServices Registrosadd;

  @PostMapping(path = "/agregarregistro")
  public String addNewRegistro(@RequestParam String numcliente,
      @RequestParam String nombrecliente, @RequestParam String maccpe, @RequestParam String direccionip) {

    registros agregar = new registros();
    agregar.setDireccionip(direccionip);;
    agregar.setMaccpe(maccpe);;
    agregar.setNombrecliente(nombrecliente);;
    agregar.setNumcliente(numcliente);;

    Registrosadd.save(agregar);
    return "Registro guardado exitosamente";
  }

  @Autowired
  private UsuariosServices Usuariosadd;

  @PostMapping(path = "/agregarusuario")
  public String addNewUser(@RequestParam boolean nivelacceso,
      @RequestParam String nombreusuario, @RequestParam String password) {

    usuarios agregar = new usuarios();
    agregar.setNombreusuario(nombreusuario);
    agregar.setPassword(password);
    agregar.setNivelacceso(nivelacceso);;
    Usuariosadd.save(agregar);
    return "Usuario guardado exitosamente";
  }

  //
  //BUSQUEDAS EN TABLA REGISTROS
  //

  @Autowired
  private RegistrosServices BuscarNombreCliente;

  @PostMapping(path = "buscarpornombre")
  public List<registros> buscarpornombre(@RequestParam String nombreabuscartemp) {
    String nombreabuscar = "%" + nombreabuscartemp + "%";
    return BuscarNombreCliente.buscarpornombre(nombreabuscar);
  }

  @Autowired
  private RegistrosServices BuscarNumCliente;

  @PostMapping(path = "buscarpornumcliente")
  public List<registros> buscarpornumcliente(@RequestParam String numeroabuscartemp) {
    String numabuscar = "%" + numeroabuscartemp + "%";
    return BuscarNumCliente.buscarpornumcliente(numabuscar);
  }

  @Autowired
  private RegistrosServices BuscarIP;

  @PostMapping(path = "buscarporip")
  public List<registros> buscarporip(@RequestParam String ipabuscartemp) {
    String ipabuscar = "%" + ipabuscartemp + "%";
    return BuscarIP.buscarporip(ipabuscar);
  }

  @Autowired
  private RegistrosServices BuscarMAC;

  @PostMapping(path = "buscarpormac")
  public List<registros> buscarpormac(@RequestParam String macabuscartemp) {
    String macabuscar = "%" + macabuscartemp + "%";
    return BuscarMAC.buscarpormac(macabuscar);
  }

  @Autowired
  private UsuariosServices BuscarUsuario;

  @PostMapping(path = "buscarpornombreusuario")
  public List<usuarios> buscarpornombreusuario(@RequestParam String usuariotemp) {
    String usuarioabuscar = "%" + usuariotemp + "%";
    return BuscarUsuario.buscarpornombreusuario(usuarioabuscar);
  }

  //
  //LOGIN(SIN UTILIZAR POR EL MOMENTO)
  //

  @Autowired
  private UsuariosServices login;

  @PostMapping(path = "login")
  public List<usuarios> login(@RequestParam String nombreusuario, String password) {
    return login.login(nombreusuario, password);
  }

  //
  //ELIMINAR REGISTROS, USUARIOS Y CLIENTES
  //

  @Autowired
  private RegistrosServices borrar;

  @DeleteMapping(path = "borrarregistro")
  public ResponseEntity<Long> borrarregistro(@RequestParam Long id) {
    if (id instanceof Long) {

      borrar.borrarregistro(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

  @Autowired
  private UsuariosServices borraruser;

  @DeleteMapping(path = "borrarusuario")
  public ResponseEntity<Long> borrarusuario(@RequestParam Long id) {
    if (id instanceof Long) {

      borraruser.borrarusuario(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  //
  //MODIFICACION DE REGISTROS, USUARIOS Y CLIENTES
  //

  @Autowired
  private RegistrosServices modificarregistro;

  @PostMapping(path = "modificarregistro")
  public ResponseEntity<Long> modificarregistroo(@RequestParam Long id, String numcliente, String nombrecliente,
      String maccpe, String direccionip) {
    if (id instanceof Long) {

      modificarregistro.modificarregistro(id, numcliente, nombrecliente, maccpe, direccionip);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @Autowired
  private UsuariosServices modificarusuario;

  @PostMapping(path = "modificarusuario")
  public ResponseEntity<Long> modificarusuario(@RequestParam Long id, boolean nivelacceso, String nombreusuario,
      String password) {
    if (id instanceof Long) {

      modificarusuario.modificarusuario(id, nivelacceso, nombreusuario, password);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
