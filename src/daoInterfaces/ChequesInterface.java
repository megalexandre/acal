/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Cheque;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alexandre
 */
public interface ChequesInterface {
    
    public void AdicionarCheque(Cheque cheque);
    public void ApagarCheque   (Cheque cheque);
    public void AtualizarCheque(Cheque cheque);
  
    public Cheque       ChequesId(int idCheque);
    public List<Cheque> ChequesAbertos(Date dataIni, Date dataFim);
    public List<Cheque> ChequesAbertosClientesPorIdClinete(int id);
    public List<Cheque> ChequesAbertosClientesPorNomeCliente(String nome);
  
    public List<Cheque> ChequesVencidosPorCliente(Date data); 
    public List<Cheque> ChequesTotalAbertos();
    public List<Cheque> ChequesSomaPorData(Date dataInicial, Date dataFinal);

     public List<Cheque> BuscarChequeFuncionarioLikeNome(String nome);
}
