package bookip.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name = "usuarios")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Getter
    @Setter
    private String direccioncorreo;
    @Getter
    @Setter
    private String nombreusuario;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private Boolean nivelacceso;
    @Getter
    @Setter
    private Boolean activo;

}
