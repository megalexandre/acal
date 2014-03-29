/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Entrada;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface EntradasInterface {
    
    public void AdicionarEntrada(Entrada entrada);
    public void ApagarEntrada   (Entrada entrada);
    public void AlterarEntrada  (Entrada entrada);
   
    
    public BigDecimal SomarEntrada();
    public BigDecimal SomarEntradaPorData(Date datainicio, Date datafim);
    public BigDecimal SomarEntradaPorFuncionario(int idfuncionario);
    public BigDecimal SomarEntradaPorFuncionarioPorData(int idfuncionario, Date inicio, Date fim);
    public Entrada       EntradaPorId(int id);
    public List<Entrada> EntradaPorFuncionario(int IdFuncionario);
    public List<Entrada> EntradaPorData (Date DataInicial, Date DataFinal);
    public List<Entrada> EntradaPorValor(int MaxValor,int MinValor);
    public List<Entrada> EntradaPorFuncionarioPorMotivo(int Motivo,int IdFuncionario);
    public List<Entrada> EntradaPorMotivo( int IdMotivo);
   // public List<Entrada> EntradaPorCedente(int IdCedente);
   // public List<Entrada> EntradaPorCedentePorData(int IdCedente, Date DataInicial, Date DataFinal);
    public List<Entrada> EntradraPorSocio(int IdSocio);
   public List<Entrada> BuscarTodasEntradas();
                        
}
