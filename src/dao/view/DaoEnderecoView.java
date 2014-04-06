/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.view;

import entidades.Endereco;
import entidades.EnderecoView;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author netservidor
 */
public class DaoEnderecoView {
 
    public List<EnderecoView> BuscarTodosEnderecos() {
        
        List<EnderecoView> endereco = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from EnderecoView ");
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
