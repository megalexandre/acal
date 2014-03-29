/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Endereco;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface EnderecosInterface {
      
    public void AdicionarEndereco(Endereco endereco);
    public void ApagarEndereco   (Endereco endereco);
    public void AlterarEndereco  (Endereco endereco);
   
    public List<Endereco> BuscarEnderecoNomeLike(String nome);
    public List<Endereco> BuscarTodosEnderecos();
    public Endereco BuscarPorId(int id); 
}
