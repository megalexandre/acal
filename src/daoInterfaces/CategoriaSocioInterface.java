/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Categoriasocio;
import java.util.List;


/**
 *
 * @author Alexandre
 */
public interface CategoriaSocioInterface {
    
    public void AdicionarCategoria(Categoriasocio categoria);
    public void ApagarCategoria   (Categoriasocio categoria);
    public void AtualizarCategoria(Categoriasocio categoria);
    
    public Categoriasocio       BuscarCategoriaPorNome(String nome);
    public List<Categoriasocio> BuscarCategoriaPorNomeLike (String nome);
    public Categoriasocio       BuscarCategoriaSocioPorId(int id);
    public List<Categoriasocio> BuscarTodasCategorias();
}
