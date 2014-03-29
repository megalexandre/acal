/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.ChequeLogsInterface;
import entidades.Chequeslog;
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
public class DaoChequeslog implements ChequeLogsInterface {

    @Override
    public List<Chequeslog> BuscarChequeLog(String nome) {
       
        List<Chequeslog> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("nome",nome);
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
        
        
    }
    //testado
    @Override
    public List<Chequeslog> BuscarTodosChequesLog() {
        
        List<Chequeslog> cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Chequeslog ");
           cheque =  query.list();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }

    @Override
    public Chequeslog BuscarChequeLogPorId(int id) {
     
        Chequeslog cheque = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("implementar ");
           query.setParameter("id",id);
           cheque =(Chequeslog)query.uniqueResult();
           tx.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            tx.rollback();
        }
        finally
        {
             sessao.close();
        }  
    return cheque;
    }
    
}
