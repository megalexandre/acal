/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daoInterfaces;

import entidades.Pessoa;
import java.util.List;

/**
 *
 * @author netservidor
 */
public interface PessoasInterface {
 
    //inserir, apagar, alterar, buscar por nome, por matricula
    //buscar todos, soma de todos, algo mais??
    
    public void AdicionarPessoa(Pessoa pessoa);
    public void ApagarPessoa   (Pessoa pessoa);
    public void AlterarPessoa  (Pessoa pessoa);
    
    public Pessoa       BuscarNomeCompleto(String NomeCompleto);
    public Pessoa       BuscarPessoaId(int id);
    public Pessoa       BuscarPessoaNome(String nome);
    public Pessoa       BuscarPessoaCpf(String Cpf);
    public List<Pessoa> BuscarTodos();
    
    public List<Pessoa> BuscarPessoaLikeNomeCompleto(String NomeCompleto) ;
    public List<Pessoa> BuscarPessoaLikeNome(String nome);
    public List<Pessoa> BuscarPessoaLikeSobrenome(String sobreNome);
      
}
