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
    agregar.setActivo(activo = true);

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
    agregar.setActivo(activo = true);

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
    agregar.setActivo(activo = true);

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
  public List<registros> buscarregistrosactivos(@RequestParam Boolean regactivos) {
    Boolean activosabuscar = regactivos = true;
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
    Boolean activosabuscar = usersactivo = true;
    return BuscarUsersActivos.buscarusersactivos(activosabuscar);
  }

  //
  // BUSCAR EN TABLA CLIENTES (BUSCARPORCIUDAD NO FUNCIONA, ERROR 404)
  //

  @Autowired
  private ClientesServices BuscarClientes;

  @PostMapping(path = "buscarclientes")
  public List<clientes> buscarcliente(@RequestParam String nombreclientetemp) {
    String clienteabuscar = "%" + nombreclientetemp + "%";
    return BuscarClientes.buscarpornombrecliente(clienteabuscar);
  }

  @Autowired
  private ClientesServices BuscarCiudad;

  @PostMapping(path = "buscarporciudad")
  public List<clientes> buscarciudad(@RequestParam String ciudadtemp) {
    String ciudadabuscar = "%" + ciudadtemp + "%";
    return BuscarCiudad.buscarporciudad(ciudadabuscar);
  }

  @Autowired
  private ClientesServices BuscarClientesActivos;

  @PostMapping(path = "buscarclientesactivos")
  public List<clientes> buscarclientesactivos(@RequestParam Boolean clienteactivo) {
    Boolean clienteabuscar = clienteactivo = true;
    return BuscarClientesActivos.buscarclientesactivos(clienteabuscar);
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
  private RegistrosServices BorrarRegistro;

  @PostMapping(path = "borrarregistro")
  public ResponseEntity<String> borrarregistro(@RequestParam String nombrecliente, @RequestParam Boolean activo) {
    if (nombrecliente instanceof String) {

      BorrarRegistro.borrarregistro(nombrecliente,activo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

  @Autowired
  private UsuariosServices BorrarUsuario;

  @PostMapping(path = "borrarusuario")
  public ResponseEntity<String> borrarusuario(@RequestParam String nombreusuario, Boolean activo) {
    if (nombreusuario instanceof String) {

      BorrarUsuario.borrarusuario(nombreusuario, activo );
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @Autowired
  private ClientesServices BorrarCliente;

  @PostMapping(path = "borrarcliente")
  public ResponseEntity<String> borrarcliente(@RequestParam String nombrecliente, Boolean activo) {
    if(nombrecliente instanceof String) {

      BorrarCliente.borrarcliente(nombrecliente, activo);
      return new ResponseEntity<>(HttpStatus.OK);
    }else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  //
  // MODIFICACION DE REGISTROS, USUARIOS Y CLIENTES
  //

  @Autowired
  private RegistrosServices ModificarRegistro;

  @PostMapping(path = "modificarregistro")
  public ResponseEntity<Long> modificarregistro(@RequestParam Long id, String numcliente, String nombrecliente,
      String maccpe, String direccionip) {
    if (id instanceof Long) {

      ModificarRegistro.modificarregistro(id, numcliente, nombrecliente, maccpe, direccionip);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @Autowired
  private UsuariosServices ModificarUsuario;

  @PostMapping(path = "modificarusuario")
  public ResponseEntity<String> modificarusuario(@RequestParam Boolean nivelacceso, String nombreusuario,
      String password) {
    if (nombreusuario instanceof String) {

      ModificarUsuario.modificarusuario(nivelacceso, nombreusuario, password);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @Autowired
  private ClientesServices ModificarCliente;

  @PostMapping(path = "modificarcliente")
  public ResponseEntity<String> modificarcliente(@RequestParam String nombrecliente, String nombreusuario,
    String ciudad) {
      if(nombrecliente instanceof String) {

        ModificarCliente.modificarcliente(nombrecliente, nombreusuario, ciudad);
        return new ResponseEntity<>(HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    }

}
