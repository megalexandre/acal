/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidades.Enderecopessoa;
import entidades.Geracaocontas;
import entidades.Pessoa;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author alunoarea1
 */
public class DaoEnderecoPessoa {
    
    public Enderecopessoa EnderecopessoaporNumero (String numero) {
      
        Enderecopessoa end = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Enderecopessoa t where t.numero = :numero");
           query.setParameter("numero",numero);
           end  = (Enderecopessoa) query.uniqueResult();
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
    return end;
    }

   
    public boolean BuscaCnpj (String cnpj) {
      
        boolean teste = false;
        Pessoa p = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa p where p.cnpj = :cnpj");
           query.setParameter("cnpj",cnpj);
           p  = (Pessoa) query.uniqueResult();
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
        return !p.getCnpj().isEmpty();
    }
    
    
    public boolean getSocioExclusivo (String numero) {
      
        
        Enderecopessoa p = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Enderecopessoa p where p.socioExclusivo= :numero");
           query.setParameter("numero",numero);
           p  = (Enderecopessoa) query.uniqueResult();
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
        return p.getSocioExclusivo();
    }
   
    
    public int qtdRegistros(){
        
        BigInteger qtd = null;
        Session session = null;
        Query query = null;
        Transaction transaction = null;
          try{
           session = HibernateUtil.getSessionFactory().openSession();
           transaction = session.beginTransaction();
           query =  session.createSQLQuery("select count(*) from enderecopessoa");
           qtd = (BigInteger)query.uniqueResult();
          
           transaction.commit(); 
           
        }
        catch(HibernateException e)
        {
            System.out.println(e);
            transaction.rollback();
        }
        finally
        {
             session.close();
        } 
          return qtd.intValue();
    }
    
    public List<Geracaocontas> TodosOsSocios() {
        
        List<Geracaocontas> socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        Criteria c = null;
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           
           transacao = sessao.beginTransaction();
          query = sessao.createQuery("from Geracaocontas");
          //query = sessao.createQuery("from Enderecopessoa ").setFirstResult(inicio).setMaxResults(total);
           
           socio = query.list();
           
          
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
    return socio;
    }
    
    public List<Enderecopessoa> TodosOsSocios(int inicio, int total) {
        
        List<Enderecopessoa> socio = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        Criteria c = null;
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           
           transacao = sessao.beginTransaction();
          query = sessao.createQuery("from Enderecopessoa");
          //query = sessao.createQuery("from Enderecopessoa ").setFirstResult(inicio).setMaxResults(total);
           
           socio = query.list();
           
          
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
    return socio;
    }
    
     public void ApagarEnderecopessoa ( Enderecopessoa p) {
      
        Session sessao = null;
        Transaction transcao = null;
       
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transcao = sessao.beginTransaction();    
            sessao.delete(p); 
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
}
