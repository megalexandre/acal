/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import daoInterfaces.EntradasLogInterface;
import entidades.Entradaslog;
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
public class DaoEntradaslog implements EntradasLogInterface {

    @Override
    public Entradaslog BuscarEntradasLogPorId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entradaslog> BuscarEntradaLog(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Entradaslog> BuscarTodasEntradasLog() {
        
        List<Entradaslog> entradaslog = null;
        Session sessao = null; 
        Query query = null;
        Transaction tx = null;
         
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           tx = sessao.beginTransaction();
           query = sessao.createQuery("from Entradaslog   ");
           entradaslog =  query.list();
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
        return entradaslog;
    }
    
}
