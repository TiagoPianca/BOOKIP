package bookip.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
public class clientes {

    @Id
    @GeneratedValue

    @Getter
    @Setter
    private String nombrecliente;

    @Getter
    @Setter
    private String nombreusuario;

    @Getter
    @Setter
    private String ciudad;
}
