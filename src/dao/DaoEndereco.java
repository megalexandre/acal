/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
 
import daoInterfaces.EnderecosInterface;
import entidades.Endereco;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Alexandre
 */
public class DaoEndereco implements EnderecosInterface{

    @Override
    public void AdicionarEndereco(Endereco endereco) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(endereco); 
            transcao.commit();
             
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        }
    }

    @Override
    public void ApagarEndereco(Endereco endereco) {
      
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(endereco);
            transcao.commit();
            
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        } 
    }

    @Override
    public void AlterarEndereco(Endereco endereco) {
    
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.update(endereco);
            transcao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transcao.rollback();
        }
        finally
        {
            sessao.close(); 
        }
    }

    @Override
    public List<Endereco> BuscarEnderecoNomeLike(String nome) {
     
        List<Endereco> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Endereco e where e.nome LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           endereco = query.list();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return endereco;
    }

   public Endereco BuscarEnderecoCompleto(String nomeCompleto){
        
        Endereco endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery
          ("from Endereco p where\n" +
          "lower(concat(p.tipo,' ', p.nome)) = lower(:nomeCompleto)");
           query.setParameter("nomeCompleto",nomeCompleto);
           endereco = (Endereco)query.uniqueResult();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return endereco;
    }  
    
    @Override
    public List<Endereco> BuscarTodosEnderecos() {
        
        List<Endereco> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Endereco order by tipo,nome ");
          // query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           endereco = query.list();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return endereco;
    }

    @Override
    public Endereco BuscarPorId(int id) {
        
        Endereco endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Endereco e where e.id = :id");
           // query.setString("nome","%"+nome+"%");
          query.setParameter("id",id);
           endereco = (Endereco)query.uniqueResult();
           transacao.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transacao.rollback();
        }
        finally
        {
             
             sessao.close();
        }  
    return endereco;
    }
   

}
