/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Funcionario;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface FuncionariosInterface {
    
   public void AdicionarFuncionario(Funcionario funcionario);
   public void ApagarFuncionario   (Funcionario funcionario);
   public void AlterarFuncionario  (Funcionario funcionario);
   
   public Funcionario BuscarFuncionarioCpf(String Cpf); 
   public Funcionario BuscarFuncionario(String nome);
   public List<Funcionario> BuscarFuncionarios();
   public List<Funcionario> BuscarFuncionarioLikeNome(String nome);
   
}
