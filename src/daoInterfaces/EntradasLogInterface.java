/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Entradaslog;
import java.util.List;
/**
 *
 * @author alexandre
 */
public interface EntradasLogInterface {
   
    public      Entradaslog  BuscarEntradasLogPorId();
    public List<Entradaslog> BuscarEntradaLog(String nome);
    public List<Entradaslog> BuscarTodasEntradasLog();
     
}
