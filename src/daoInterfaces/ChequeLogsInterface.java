/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Chequeslog;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface ChequeLogsInterface {
    
    public Chequeslog       BuscarChequeLogPorId(int id);
    public List<Chequeslog> BuscarChequeLog(String nome);
    public List<Chequeslog> BuscarTodosChequesLog();
        
}
