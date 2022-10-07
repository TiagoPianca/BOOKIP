package bookip.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "registros")
public class registros {

    @Id
    @GeneratedValue

    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String numcliente;
    @Getter
    @Setter
    private String nombrecliente;
    @Getter
    @Setter
    private String maccpe;
    @Getter
    @Setter
    private String direccionip;
    @Getter
    @Setter
    private Boolean activo;

}
