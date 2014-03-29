/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.MotivoDespesasInterface;
import entidades.Motivodespesa;
import java.util.ArrayList;
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
public class DaoMotivoDespesa implements MotivoDespesasInterface  {

    @Override
    public void AdicionarMotivoDespesa(Motivodespesa motivo) {
    
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.save(motivo); 
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
    public void ApagarMotivoDespesa(Motivodespesa motivo) {
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(motivo); 
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
    public void AlterarMotivoDespesa(Motivodespesa motivo) {
       
        Session sessao = null;
        Transaction transcao = null;
       
         try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.saveOrUpdate(motivo); 
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
    public List<Motivodespesa> BuscarMotivoDespesaLikeNome(String nome)
    {
        List<Motivodespesa> motivoDespesa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Motivodespesa m where m.nome LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           motivoDespesa = query.list();
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
    return motivoDespesa;
    }
    
    @Override
    public Motivodespesa BuscarMotivoDespesaId(int id) {
       
        Motivodespesa motivoDespesa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Motivodespesa where id = :id");
           query.setParameter("id",id);
           motivoDespesa = (Motivodespesa)query.uniqueResult();
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
    return motivoDespesa;
    }

    @Override
    public List<Motivodespesa> BuscarMotivo(String nome) {
       
        Session sessao= null;
        Transaction transacao = null;
        List<Motivodespesa> lista = new ArrayList<>();
        Query query = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM Motivosaida m where  lower(m.nome) like lower(:nome) order by nome";
            query = sessao.createQuery(HQL_QUERY);       
            lista = query.list();
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
    return lista;
    }

    @Override
    public List<Motivodespesa> BuscarTodosMotivos() {
        Session sessao= null;
        Transaction transacao = null;
        List<Motivodespesa> lista = new ArrayList<>();
        Query query = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            String HQL_QUERY="FROM Motivodespesa order by nome";
            query = sessao.createQuery(HQL_QUERY);       
            lista = query.list();
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
    return lista;
    }

   
}
