/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Conta;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface ContasInterface {
   
    public void AdicionarConta (Conta conta);
    public void ApagarConta    (Conta conta);
    public void AtualizarConta (Conta conta);
  
    public Conta ContasPorId(int id);
    public List<Conta> ContasAbertas(Date inicio, Date fim);
    public List<Conta> ContasAbertasCliente(int id);
    public List<Conta> ContasAbertasCliente(String nome);
    public List<Conta> ContasVencidas(Date data);
    public List<Conta> ContasVencidasPorCliente(Date data, int id); 
    public List<Conta> ContasVencidasPorCliente(Date data, String nome) ;
    public List<Conta> ContasTotalAbertas();
    public List<Conta> ContasPorRua(int IdRua);
    public List<Conta> ContaSomaPorData(Date dataInicial, Date dataFinal);
    public List<Conta> ContasAbertas(Date data);
    
    
}
