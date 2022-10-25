package bookip.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.*;

@Data
//Tiene todas las anotaciones de Lombok, como por ejemplo @Getter y @Setter
@Entity
//Declara la entidad de una tabla
@Table(name = "registros")
public class Registros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //GeneratedValue genera valores autoincrementables
    @Column
    private String numcliente;
    @Column
    private String nombrecliente;
    @Column
    private String maccpe;
    @Column
    private String direccionip;
    @Column
    private Boolean activo;

}
