/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Motivodespesa;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface MotivoDespesasInterface {
     
    public void AdicionarMotivoDespesa      (Motivodespesa motivo);
    public void ApagarMotivoDespesa         (Motivodespesa motivo);
    public void AlterarMotivoDespesa        (Motivodespesa motivo);
    
    public List<Motivodespesa> BuscarMotivo   (String nome);
    public List<Motivodespesa> BuscarTodosMotivos ();
    public List<Motivodespesa> BuscarMotivoDespesaLikeNome(String nome);
     public Motivodespesa BuscarMotivoDespesaId(int id);
}
