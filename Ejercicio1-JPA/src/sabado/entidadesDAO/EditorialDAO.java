/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sabado.entidadesDAO;

import java.util.List;
import sabado.entidades.Editorial;

/**
 *
 * @author andrelo
 */
public class EditorialDAO extends PadreDAO<Editorial> {

    public Editorial buscarPorId(Integer Id) throws Exception {
        try {
            Editorial editorial = em.find(Editorial.class, Id);
            return editorial;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar la editorial por ID");
        }
    }

    public List<Editorial> buscarPorNombre(String nombre) throws Exception {
        try {
            List<Editorial> editoriales = em.createQuery("SELECT f from Editorial f WHERE f.nombre LIKE :nombre1", Editorial.class)
                    .setParameter("nombre1", nombre)
                    .getResultList();
            return editoriales;

        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el editorial por Nombre");
        }

    }

    public List<Editorial> buscarTodos() throws Exception {
        try {
            List<Editorial> editoriales = em.createQuery("SELECT f from Editorial f", Editorial.class
            )
                    .getResultList();
            return editoriales;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el editorial por ID");
        }

    }

    public List<Editorial> buscarEnAlta() throws Exception {
        try {
            List<Editorial> editoriales = em.createQuery("SELECT e from Editorial e where e.alta=1", Editorial.class
            ).getResultList();

            return editoriales;
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new Exception("ERROR al buscar el editorial por ID");
        }

    }
}
