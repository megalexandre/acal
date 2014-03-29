/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.view;

import entidades.view.RcCaixaCompleto;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Head
 */
public class DaoCaixaCompletoView {
    
     public List<RcCaixaCompleto> BuscarTodosRcCaixaCompleto() {
       
        List<RcCaixaCompleto> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from RcCaixaCompleto ");
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
    
    public List<RcCaixaCompleto> BuscarTodosRcCaixaCompletoDatePagamento(Date ini, Date fim) {
        
        List<RcCaixaCompleto> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from RcCaixaCompleto where Pagamento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
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
    public List<RcCaixaCompleto> BuscarTodosRcCaixaCompletoDateVencimento(Date ini, Date fim) {
        
        List<RcCaixaCompleto> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from RcCaixaCompleto where vencimento between :ini and :fim");
           query.setParameter("ini",ini);
           query.setParameter("fim",fim);
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
}

