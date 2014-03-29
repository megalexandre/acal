/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Motivoentrada;
import java.util.List;
/**
 *
 * @author netservidor
 */
public interface MotivoEntradasInterface {
    
    public void AdicionarMotivoEntrada      (Motivoentrada motivo);
    public void ApagarMotivoEntrada         (Motivoentrada motivo);
    public void AlterarMotivoEntrada        (Motivoentrada motivo);
  
    public List<Motivoentrada> BuscarMotivo (String nome);
    public List<Motivoentrada> BuscarTodosMotivos ();
     public List<Motivoentrada> BuscarMotivoEntradaLikeNome(String nome);
     public Motivoentrada BuscarMotivoEntradaId(int id);
}
