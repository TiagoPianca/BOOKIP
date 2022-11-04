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
import org.springframework.web.bind.annotation.PutMapping;

import bookip.demo.Services.*;
import bookip.demo.models.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class principal {

  //
  // LISTADO DE TABLAS(REGISTROS, USUARIOS, CLIENTES) FUNCIONANDO
  //

  @Autowired
  private RegistrosServices RegistrosService;
  //Inyecta las propiedades de RegistrosServices creando un objeto para permitirle inyectarla cuando sea necesario. 

  @GetMapping(path = "/listarregistros")
  public Iterable<Registros> mostrarregistros() {
    return RegistrosService.findAll();
  }

  @Autowired
  private UsuariosServices UsuariosService;
  //Inyecta las propiedades de UsuariosServices creando un objeto para permitirle inyectarla cuando sea necesario. 

  @GetMapping(path = "/listarusuarios")
  public Iterable<Usuarios> mostrarusuarios() {
    return UsuariosService.findAll();

  }

  @Autowired
  private ClientesServices ClientesService;
  //Inyecta las propiedades de ClientesServices creando un objeto para permitirle inyectarla cuando sea necesario. 

  @GetMapping(path = "/listarclientes")
  public Iterable<Clientes> mostrarclientes() {
    return ClientesService.findAll();
  }

  //
  // ADD REGISTROS, USUARIOS Y CLIENTES FUNCIONANDO
  //

  @PostMapping("/agregarreg")
  public String addNewRegistro(@RequestBody Registros registros) {

    RegistrosService.save(registros);
    return "Registro guardado exitosamente";
  }
  //Postea un nuevo registro solicitando los parametros con un @RequestBody 
  //Luego, guarda el contenido del Body dentro un objeto de entidad Registros y muestra
  //un mensaje de confirmación de guardado.

  @PostMapping(path = "/agregaruser")
  public String addNewUsuario(@RequestBody Usuarios usuarios) {

    UsuariosService.save(usuarios);
    return "Usuario guardado exitosamente";
  }
  //Postea un nuevo usuario solicitando los parametros con un @RequestBody 
  //Luego, guarda el contenido del Body dentro un objeto de entidad Usuarios y muestra
  //un mensaje de confirmación de guardado.

  @PostMapping(path = "/agregarcli")
  public String addNewCliente(@RequestBody Clientes clientes) {

    ClientesService.save(clientes);
    return "CLiente guardado exitosamente";
  }
  //Postea un nuevo cliente solicitando los parametros con un @RequestBody 
  //Luego, guarda el contenido del Body dentro un objeto de entidad Clientes y muestra
  //un mensaje de confirmación de guardado.

  //
  // BUSQUEDAS EN TABLA REGISTROS FUNCIONANDO
  //

  @GetMapping(path = "/buscarpornombre")
  public List<Registros> buscarpornombre(@RequestParam String nombreabuscartemp) {
    return RegistrosService.findByNombrecliente(nombreabuscartemp);
  }
  // Hace una busqueda avanzada de nombrecliente mediante un metodo definido en 
  // el servicio.
  // La busqueda se hace por nombre completo, no solo una parte. Ej: Pianca NO,
  // Piancatelli Inc. Si.

  @GetMapping(path = "/buscarpornumcliente")
  public List<Registros> buscarpornumcliente(@RequestParam String numeroabuscartemp) {
    return RegistrosService.findByNumcliente(numeroabuscartemp);
  }
  // La busqueda se hace con el numero completo.

  @GetMapping(path = "/buscarporip")
  public List<Registros> buscarporip(@RequestParam String ipabuscartemp) {
    return RegistrosService.findByDireccionip(ipabuscartemp);
  }
  // La busqueda se hace por la direccion Ip completa.

  @GetMapping(path = "/buscarpormac")
  public List<Registros> buscarpormac(@RequestParam String macabuscartemp) {
    return RegistrosService.findByMaccpe(macabuscartemp);
  }
  // La busqueda es con MacCpe completa.

  @GetMapping(path = "/buscarregistrosactivos")
  public List<Registros> buscarregistrosactivos() {
    return RegistrosService.findByActivo(true);
  }
  //Realiza la busqueda de registros activos mediante el método del servico
  //en donde le pasamos el parámetro true para que traiga todos los activos.

  //
  // BUSCAR EN TABLA USUARIOS FUNCIONANDO
  //

  @GetMapping(path = "/buscarpornombreusuario")
  public List<Usuarios> buscarpornombreusuario(@RequestParam String usuariotemp) {
    String usuarioabuscar = "%" + usuariotemp + "%";
    return UsuariosService.buscarpornombreusuario(usuarioabuscar);
  }
  // Buscar por nombreusuario completo.

  @GetMapping(path = "/buscarusersactivos")
  public List<Usuarios> buscarusersactivos() {
    return UsuariosService.findByActivo(true);
  }

  //
  // BUSCAR EN TABLA CLIENTES
  //

  @GetMapping(path = "/buscarclientes")
  public List<Clientes> buscarcliente(@RequestParam String nombreclientetemp) {
    return ClientesService.findByNombrecliente(nombreclientetemp);
  }
  // Buscar con el nombre del cliente completo.

  @GetMapping(path = "/buscarporciudad")
  public List<Clientes> buscarciudad(@RequestParam String ciudadtemp) {
    return ClientesService.findByCiudad(ciudadtemp);
  }
  // El nombre de la ciudad debe estar completo.

  @GetMapping(path = "/buscarclientesactivos")
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
  //Utilizo un post para el Delete para poder cambiar el valor de la columna
  //activo pasandole por parámetro con el Path el id del registro que solicita el método.
  //Luego, muestra un mensaje para que sepamos que fue realizado correctamente.

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
      @RequestParam String nombrecliente, @RequestParam String maccpe, @RequestParam String direccionip,
      @RequestParam Boolean activo) {
    RegistrosService.modificarregistro(id, numcliente, nombrecliente, maccpe, direccionip, true);
    return "Registro modificado";
  }
  //Todos los parametros deben ser puestos para que funcione, de no ser asi se obtiene
  //un error 400 por una BadRequest.
  
  @PutMapping(value = "/modificarusuario")
  public String modificarusuario(@RequestParam String nombreusuario, @RequestParam String password,
      @RequestParam String direccioncorreo, @RequestParam Boolean nivelacceso, @RequestParam Boolean activo) {
    UsuariosService.modificarusuario(nivelacceso, nombreusuario, password, direccioncorreo, true);
    return "Usuario modificado";
  }
  //Todos los parametros deben ser puestos para que funcione, de no ser asi se obtiene
  //un error 400 por una BadRequest.

  @PutMapping(value = "/modificarcliente")
  public String modificarcliente(@RequestParam String nombrecliente, @RequestParam String nombreusuario,
      @RequestParam String ciudad, @RequestParam Boolean activo) {
    ClientesService.modificarcliente(nombrecliente, nombreusuario, ciudad, true);
    return "Cliente modificado";
  }
  //Todos los parametros deben ser puestos para que funcione, de no ser asi se obtiene
  //un error 400 por una BadRequest.
  
}
