package sabado.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idAutor;
 
    private String nombreAutor;
    private Boolean alta;

    public Autor() {
    }

    public Autor(Integer idAutor, String nombreAutor, Boolean alta) {
        this.idAutor = idAutor;
        this.nombreAutor = nombreAutor;
        this.alta = alta;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
    
}
