package bookip.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name = "clientes")
public class Clientes {

    @Id
    @Column
    private String nombrecliente;
    @Column
    private String nombreusuario;
    @Column
    private String ciudad;
    @Column
    private Boolean activo;
}
