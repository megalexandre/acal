/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Socio;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface SocioInterface {
    
    public void AdicionarSocio   (Socio socio);
    public void AlterarSocio     (Socio socio);
    public void ApagarSocio      (Socio socio);
   
    public List<Socio> SociosPorNomeLike(String nome);
    public List<Socio> SocioPorRua(String Rua);
    public List<Integer> TodosOsSociosPorId();
    public List<Socio> TodosOsSocios();
 public Socio BuscarSocioId(int id);
}
