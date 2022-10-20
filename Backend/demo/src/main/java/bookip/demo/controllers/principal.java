package bookip.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookip.demo.Services.*;
import bookip.demo.models.*;
import org.springframework.web.bind.annotation.PutMapping;

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
  // BUSQUEDAS EN TABLA REGISTROS
  //

  @GetMapping(path = "buscarpornombre")
  public List<Registros> buscarpornombre(@RequestParam String nombreabuscartemp) {
    return RegistrosService.findByNombrecliente(nombreabuscartemp);
  }

  @GetMapping(path = "buscarpornumcliente")
  public List<Registros> buscarpornumcliente(@RequestParam String numeroabuscartemp) {
    return RegistrosService.findByNumcliente(numeroabuscartemp);
  }

  @GetMapping(path = "buscarporip")
  public List<Registros> buscarporip(@RequestParam String ipabuscartemp) {
    return RegistrosService.findByDireccionip(ipabuscartemp);
  }

  @GetMapping(path = "buscarpormac")
  public List<Registros> buscarpormac(@RequestParam String macabuscartemp) {
    return RegistrosService.findByMaccpe(macabuscartemp);
  }

  @GetMapping(path = "buscarregistrosactivos")
  public List<Registros> buscarregistrosactivos() {
    return RegistrosService.findByActivo(true);
  }

  //
  // BUSCAR EN TABLA USUARIOS
  //

  @GetMapping(path = "buscarpornombreusuario")
  public List<Usuarios> buscarpornombreusuario(@RequestParam String usuariotemp) {
    String usuarioabuscar = "%" + usuariotemp + "%";
    return UsuariosService.buscarpornombreusuario(usuarioabuscar);
  }

  @GetMapping(path = "buscarusersactivos")
  public List<Usuarios> buscarusersactivos() {
    return UsuariosService.findByActivo(true);
  }

  //
  // BUSCAR EN TABLA CLIENTES
  //

  @GetMapping(path = "buscarclientes")
  public List<Clientes> buscarcliente(@RequestParam String nombreclientetemp) {
    return ClientesService.findByNombrecliente(nombreclientetemp);
  }

  @GetMapping(path = "buscarporciudad")
  public List<Clientes> buscarciudad(@RequestParam String ciudadtemp) {
    return ClientesService.findByCiudad(ciudadtemp);
  }

  @GetMapping(path = "buscarclientesactivos")
  public List<Clientes> buscarclientesactivos() {
    return ClientesService.findByActivo(true);
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
  // ELIMINAR REGISTROS, USUARIOS Y CLIENTES FUNCIONANDO
  //

  @PostMapping("/borrarregistro/{id}")
  public @ResponseBody String borrarregistro(@PathVariable Integer id) {
    RegistrosService.borrarregistro(id, false);
    return "Registro eliminado";

  }

  @PostMapping("/borrarusuario/{nombreusuario}")
  public @ResponseBody String borrarusuario(@PathVariable String nombreusuario) {
    UsuariosService.borrarusuario(nombreusuario, false);
    return "Usuario eliminado";
  }

  @PostMapping("/borrarcliente/{nombrecliente}")
  public @ResponseBody String borrarcliente(@PathVariable String nombrecliente) {
    ClientesService.borrarcliente(nombrecliente, false);
    return "Cliente eliminado";
  }

  //
  // MODIFICACION DE REGISTROS, USUARIOS Y CLIENTES
  //

  @PutMapping(value = "/modificarregistro")
  public String modificarregistro(@RequestParam Integer id, @RequestParam String numcliente,
      @RequestParam String nombrecliente, @RequestParam String maccpe, @RequestParam String direccionip) {

    RegistrosService.modificarregistro(id, numcliente, nombrecliente, maccpe, direccionip);
    return "Registro modificado";
  }

  @PutMapping(value = "/modificarusuario")
  public String modificarusuario(@RequestParam String nombreusuario, @RequestParam String password, @RequestParam String direccioncorreo, @RequestParam Boolean nivelacceso){
    UsuariosService.modificarusuario(nivelacceso, nombreusuario, password, direccioncorreo);
    return "Usuario modificado";
  }

  @PutMapping(value="/modificarcliente")
  public String modificarcliente(@RequestParam String nombrecliente, @RequestParam String nombreusuario, @RequestParam String ciudad) {
      ClientesService.modificarcliente(nombrecliente, nombreusuario, ciudad);
      return "Cliente modificado";
  }


}
