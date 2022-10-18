package bookip.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @Column
    private String nombreusuario;
    @Column
    private String direccioncorreo;
    @Column
    private String password;
    @Column
    private Boolean nivelacceso;
    @Column
    private Boolean activo;

}
