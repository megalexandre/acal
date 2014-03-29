/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;


import entidades.Saida;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface SaidasInterface {
    
    public void AdicionarSaida(Saida saida);
    public void AlterarSaida  (Saida saida);
    public void ApagarSaida   (Saida saida);
    
     public BigDecimal SomaSaidas(Date inicio, Date fim);
    public List<Saida> SaidasPorFuncionario(int IdFuncionario);
    public List<Saida> SaidasPorData(Date DataInicio, Date DataFim);
    public List<Saida> SaidaPorDataPorFuncionario(int IdFuncionario, Date DataInicio, Date DataFim) ;
    public List<Saida> SaidaPorFuncionarioPorMotivo(int Motivo, int IdFuncionario);
    public List<Saida> SaidasPorMotivo(int IdMotivoSaidas);
    public List<Saida> BuscarSaidaFavorecidoLikeNome(String nome);
     public List<Saida> BuscarTodasSaidas();
      public Saida BuscarSaidaId(int id); 
   
}
