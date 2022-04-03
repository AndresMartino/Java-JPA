package sabado.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Editorial {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer idEdtorial;
    private String nombreEditorial;
    private Boolean alta;

    public Editorial() {
    }

    public Editorial(Integer idEdtorial, String nombreEditorial, Boolean alta) {
        this.idEdtorial = idEdtorial;
        this.nombreEditorial = nombreEditorial;
        this.alta = alta;
    }

    public Integer getIdEdtorial() {
        return idEdtorial;
    }

    public void setIdEdtorial(Integer idEdtorial) {
        this.idEdtorial = idEdtorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
    
}
