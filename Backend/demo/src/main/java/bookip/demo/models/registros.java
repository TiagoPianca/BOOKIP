package bookip.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "registros")
public class Registros {

    @Id
    @GeneratedValue
    private Integer id;

    private String numcliente;

    private String nombrecliente;

    private String maccpe;

    private String direccionip;

    private Boolean activo;

}
