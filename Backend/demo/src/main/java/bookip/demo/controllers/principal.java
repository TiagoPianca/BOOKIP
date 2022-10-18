package bookip.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import bookip.demo.Repository.RegistrosRepository;
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
  public Iterable<Registros> mostrarregistros() {
    return RegistrosService.findAll();
  }

  @Autowired
  private UsuariosServices UsuariosService;

  @GetMapping(path = "listarusuarios")
  public Iterable<Usuarios> mostrarusuarios() {
    return UsuariosService.findAll();

  }

  @Autowired
  private ClientesServices ClientesService;

  @GetMapping(path = "listarclientes")
  public Iterable<Clientes> mostrarclientes() {
    return ClientesService.findAll();
  }

  //
  // ADD REGISTROS, USUARIOS Y CLIENTES
  //

  @PostMapping("/agregarreg")
  public String addNewRegistro(@RequestBody Registros registros) {

    RegistrosService.save(registros);
    return "Registro guardado exitosamente";
  }

  @PostMapping(path = "/agregaruser")
  public String addNewUsuario(@RequestBody Usuarios usuarios) {
    
    UsuariosService.save(usuarios);
    return "Usuario guardado exitosamente";
  }

  @PostMapping(path = "/agregarcli")
  public String addNewCliente(@RequestBody Clientes clientes) {
   
    ClientesService.save(clientes);
    return "CLiente guardado exitosamente";
  }

  //
  // BUSQUEDAS EN TABLA REGISTROS (BUSCARREGISTROSACTIVOS BUSCA PERO NO MUESTRA NADA )
  //

  @GetMapping(path = "buscarpornombre")
  public List<Registros> buscarpornombre(@RequestParam String nombreabuscartemp) {
    String nombreabuscar = "%" + nombreabuscartemp + "%";
    return RegistrosService.buscarpornombre(nombreabuscar);
  }

  @GetMapping(path = "buscarpornumcliente")
  public List<Registros> buscarpornumcliente(@RequestParam String numeroabuscartemp) {
    String numabuscar = "%" + numeroabuscartemp + "%";
    return RegistrosService.buscarpornumcliente(numabuscar);
  }

  @GetMapping(path = "buscarporip")
  public List<Registros> buscarporip(@RequestParam String ipabuscartemp) {
    String ipabuscar = "%" + ipabuscartemp + "%";
    return RegistrosService.buscarporip(ipabuscar);
  }

  @GetMapping(path = "buscarpormac")
  public List<Registros> buscarpormac(@RequestParam String macabuscartemp) {
    String macabuscar = "%" + macabuscartemp + "%";
    return RegistrosService.buscarpormac(macabuscar);
  }

  @GetMapping(path = "buscarregistrosactivos")
  public List<Registros> buscarregistrosactivos(@RequestParam Boolean regactivos) {
    Boolean activosabuscar = regactivos;
    return RegistrosService.buscarregistrosactivos(activosabuscar);
  }

  //
  // BUSCAR EN TABLA USUARIOS(BUSCARUSERSACTIVOS BUSCA PERO NO MUESTRA)
  //

  @GetMapping(path = "buscarpornombreusuario")
  public List<Usuarios> buscarpornombreusuario(@RequestParam String usuariotemp) {
    String usuarioabuscar = "%" + usuariotemp + "%";
    return UsuariosService.buscarpornombreusuario(usuarioabuscar);
  }

  @GetMapping(path = "buscarusersactivos")
  public List<Usuarios> buscarusersactivos(@RequestParam Boolean usersactivo) {
    Boolean activosabuscar = usersactivo;
    return UsuariosService.buscarusersactivos(activosabuscar);
  }

  //
  // BUSCAR EN TABLA CLIENTES (BUSCARCLIENTESACTIVOS BUSCA PERO NO MUESTRA)
  //

  @GetMapping(path = "buscarclientes")
  public List<Clientes> buscarcliente(@RequestParam String nombreclientetemp) {
    String clienteabuscar = "%" + nombreclientetemp + "%";
    return ClientesService.buscarpornombrecliente(clienteabuscar);
  }

  @GetMapping(path = "buscarporciudad")
  public List<Clientes> buscarciudad(@RequestParam String ciudadtemp) {
    String ciudadabuscar = "%" + ciudadtemp + "%";
    return ClientesService.buscarporciudad(ciudadabuscar);
  }

  @GetMapping(path = "buscarclientesactivos")
  public List<Clientes> buscarclientesactivos(@RequestParam Boolean clienteactivo) {
    Boolean clienteabuscar = clienteactivo;
    return ClientesService.buscarclientesactivos(clienteabuscar);
  }

  //
  // LOGIN(SIN UTILIZAR POR EL MOMENTO)
  //
  /*
   * @PostMapping(path = "login")
   * public List<usuarios> login(@RequestParam String nombreusuario, String
   * password) {
   * return UsuariosService.login(nombreusuario, password);
   * }
   */
  //
  // ELIMINAR REGISTROS, USUARIOS Y CLIENTES (ERROR 500)
  //

  @PatchMapping(path = "borrarregistro")
  public ResponseEntity<Integer> borrarregistro(@PathVariable Integer id, @PathVariable Boolean activo) {
    if (id instanceof Integer) {

      RegistrosService.borrarregistro(id, activo);
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
    if (nombrecliente instanceof String) {

      ClientesService.borrarcliente(nombrecliente, activo);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {

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
    if (nombrecliente instanceof String) {

      ClientesService.modificarcliente(nombrecliente, nombreusuario, ciudad);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
