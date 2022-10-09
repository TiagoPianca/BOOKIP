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
  // LISTADO DE TABLAS(REGISTROS, USUARIOS, CLIENTES) FUNCIONANDO
  //

  @Autowired

  private RegistrosServices RegistrosRepo;

  @GetMapping(path = "listarregistros")
  public Iterable<registros> mostrarregistros() {
    return RegistrosRepo.findAll();
  }

  @Autowired
  private UsuariosServices UsuariosRepo;

  @GetMapping(path = "listarusuarios")
  public Iterable<usuarios> mostrarusuarios() {
    return UsuariosRepo.findAll();

  }

  @Autowired
  private ClientesServices ClientesRepo;

  @GetMapping(path = "listarclientes")
  public Iterable<clientes> mostrarclientes() {
    return ClientesRepo.findAll();
  }

  //
  // AGREGAR REGISTROS (REGISTROS, USUARIOS Y CLIENTES) NO FUNCIONA, ERROR 500
  //

  @Autowired
  private RegistrosServices Registrosadd;

  @PostMapping(path = "agregarregistro")
  public String addNewRegistro(@RequestParam Integer id,@RequestParam String numcliente,
      @RequestParam String nombrecliente, @RequestParam String maccpe, @RequestParam String direccionip,
      @RequestParam Boolean activo) {

    registros agregar = new registros();
    agregar.setId(id);
    agregar.setDireccionip(direccionip);
    agregar.setMaccpe(maccpe);
    agregar.setNombrecliente(nombrecliente);
    agregar.setNumcliente(numcliente);
    agregar.setActivo(activo);

    Registrosadd.save(agregar);
    return "Registro guardado exitosamente";
  }

  @Autowired
  private UsuariosServices Usuariosadd;

  @PostMapping(path = "agregarusuario")
  public String addNewUser(@RequestParam boolean nivelacceso,
      @RequestParam String nombreusuario, @RequestParam String password, @RequestParam Boolean activo) {

    usuarios agregar = new usuarios();
    agregar.setNombreusuario(nombreusuario);
    agregar.setPassword(password);
    agregar.setNivelacceso(nivelacceso);
    agregar.setActivo(activo);

    Usuariosadd.save(agregar);
    return "Usuario guardado exitosamente";
  }

  @Autowired
  private ClientesServices Clientesadd;

  @PostMapping(path = "agregarcliente")
  public String nuevoCliente(@RequestParam String nombrecliente, @RequestParam String nombreusuario,
      @RequestParam String ciudad, @RequestParam Boolean activo) {

    clientes agregar = new clientes();
    agregar.setNombrecliente(nombrecliente);
    agregar.setNombreusuario(nombreusuario);
    agregar.setCiudad(ciudad);
    agregar.setActivo(activo);

    Clientesadd.save(agregar);
    return "CLiente guardado exitosamente";
  }

  //
  // BUSQUEDAS EN TABLA REGISTROS (BUSCARACTIVOS NO FUNCIONA, ERROR 404 )
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
  private RegistrosServices BuscarRegistrosActivos;

  @PostMapping(path = "buscarregistrosactivos")
  public Iterable<registros> buscarregistrosactivos(@RequestParam Boolean regactivosabuscar) {
    Boolean activosabuscar = regactivosabuscar;
    return BuscarRegistrosActivos.buscarregistrosactivos(activosabuscar);
  }

  //
  // BUSCAR EN TABLA USUARIOS( BUSCAR USERS NO FUNCIONA, ERROR 404)
  //

  @Autowired
  private UsuariosServices BuscarUsuario;

  @PostMapping(path = "buscarpornombreusuario")
  public List<usuarios> buscarpornombreusuario(@RequestParam String usuariotemp) {
    String usuarioabuscar = "%" + usuariotemp + "%";
    return BuscarUsuario.buscarpornombreusuario(usuarioabuscar);
  }

  @Autowired
  private UsuariosServices BuscarUsersActivos;

  @PostMapping(path = "buscarusersactivos")
  public List<usuarios> buscarusersactivos(@RequestParam Boolean usersactivo) {
    Boolean activosabuscar = usersactivo;
    return BuscarUsersActivos.buscarusersactivos(activosabuscar);
  }

  //
  // LOGIN(SIN UTILIZAR POR EL MOMENTO)
  //

  @Autowired
  private UsuariosServices login;

  @PostMapping(path = "login")
  public List<usuarios> login(@RequestParam String nombreusuario, String password) {
    return login.login(nombreusuario, password);
  }

  //
  // ELIMINAR REGISTROS, USUARIOS Y CLIENTES
  //

  @Autowired
  private RegistrosServices borrar;

  @DeleteMapping(path = "borrarregistro")
  public ResponseEntity<Boolean> borrarregistro(@RequestParam Boolean activo) {
    if (activo instanceof Boolean) {

      borrar.borrarregistro(activo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

  @Autowired
  private UsuariosServices borraruser;

  @DeleteMapping(path = "borrarusuario")
  public ResponseEntity<Boolean> borrarusuario(@RequestParam Boolean activo) {
    if (activo instanceof Boolean) {

      borraruser.borrarusuario(activo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  //
  // MODIFICACION DE REGISTROS, USUARIOS Y CLIENTES
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
  public ResponseEntity<String> modificarusuario(@RequestParam Boolean nivelacceso, String nombreusuario,
      String password) {
    if (nombreusuario instanceof String) {

      modificarusuario.modificarusuario(nivelacceso, nombreusuario, password);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
