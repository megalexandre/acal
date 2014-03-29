/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.TaxasInterface;
import entidades.Taxa;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


/**
 *
 * @author alexandre
 */
public class DaoTaxa implements TaxasInterface {

    @Override
    public void AdicionarTaxa(Taxa taxa) {
        
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(taxa); 
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
    public void ApagarTaxa(Taxa taxa) {
      Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(taxa); 
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
    public void AlterarTaxa(Taxa taxa) {
         Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(taxa); 
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
    public Taxa TaxaPorId(int id) {
      
        Taxa taxa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Taxa t where t.id = :id");
           //query.setString("nome","%"+nome+"%");
           query.setParameter("id",id);
           taxa = (Taxa) query.uniqueResult();
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
    return taxa;
    }
    

    @Override
    public Taxa TaxasPorNome(String nome) {
       
        Taxa taxa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Taxa t where t.nome = :nome");
           query.setParameter("nome",nome);
           //query.setParameter("id",id);
           taxa = (Taxa)query.uniqueResult();
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
    return taxa;
    }

    @Override
    public List<Taxa> BuscarTaxaNomeLike(String nome) {
     
        List<Taxa> taxas = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Taxa e where e.nome LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           taxas = query.list();
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
    return taxas;
    }
        
    @Override
    public List<Taxa> TaxasTodas() {
      
        List<Taxa> taxa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Taxa ");
           //query.setString("nome","%"+nome+"%");
           //query.setParameter("id",id);
           // taxa = (Taxa) query.uniqueResult();
           taxa = query.list();
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
    return taxa;
    }
   
    
}
