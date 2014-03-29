
package dao;

import daoInterfaces.PessoasInterface;
import entidades.Pessoa;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DaoPessoa implements PessoasInterface {

    @Override
    public void AdicionarPessoa(Pessoa pessoa) {
      
        Session sessao= null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(pessoa); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            e.printStackTrace();
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }      
    }

    @Override
    public void ApagarPessoa(Pessoa pessoa) {
        
        Session sessao = null;
        Transaction transacao = null;
        
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.delete(pessoa); 
            transacao.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            transacao.rollback();
        }
        finally
        {
            sessao.close(); 
        }      
    }

    @Override
    public void AlterarPessoa(Pessoa pessoa) {
        
        Session session = null;
        Transaction tx = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            
           
            session.update(pessoa);
           
            tx.commit();
            System.out.println("Salvo com sucesso");  
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
            System.out.println("Erro ao iniciar a sessao para persistencia " + e);
            tx.rollback();
        }
        finally
        {
          
            session.close(); 
        }      
    }
    public boolean getSocioExclusivo(String nomeCompleto){
        Pessoa pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery
          ("from Pessoa p where lower(concat(p.nome,' ', p.sobrenome)) = lower(:nomeCompleto)");
           query.setParameter("nomeCompleto",nomeCompleto);
           pessoa = (Pessoa)query.uniqueResult();
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
        
    return pessoa.getSocio().getSocioExclusivo();
    }
    
    
    
    
    
    @Override
    public Pessoa BuscarNomeCompleto(String nomeCompleto){
        
        Pessoa pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery
          ("from Pessoa p where\n" +
          "lower(concat(p.nome,' ', p.sobrenome)) = lower(:nomeCompleto)");
           query.setParameter("nomeCompleto",nomeCompleto);
           pessoa = (Pessoa)query.uniqueResult();
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
    return pessoa;
    }  
    
    @Override
    public List<Pessoa> BuscarPessoaLikeNomeCompleto(String nomeCompleto) {
        List<Pessoa> pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa p where concat(p.nome,p.sobrenome) LIKE :nomeCompleto");
           query.setString("nome","%"+nomeCompleto+"%");
           //query.setParameter("nome",nome);
           pessoa = query.list();
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
    return pessoa;
    }
    
    @Override
    public List<Pessoa> BuscarPessoaLikeNome(String nome)
    {
        List<Pessoa> pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa p where p.nome LIKE :nome");
           query.setString("nome","%"+nome+"%");
           //query.setParameter("nome",nome);
           pessoa = query.list();
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
    return pessoa;
    }
    @Override
    public List<Pessoa> BuscarPessoaLikeSobrenome(String sobreNome)
    {
        List<Pessoa> pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa p where p.nome LIKE '%:sobrenome%'");
           query.setParameter("sobrenome",sobreNome);
           pessoa = query.list();
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
    return pessoa;
    }
 
    
    @Override
    public Pessoa BuscarPessoaId(int id) {
       
        Pessoa pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa where id = :id");
           query.setParameter("id",id);
           pessoa = (Pessoa)query.uniqueResult();
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
    return pessoa;
    }

    @Override
    public Pessoa BuscarPessoaNome(String nome) {
        
        Pessoa pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa where nome = :nome");
           query.setParameter("nome",nome);
           pessoa = (Pessoa)query.uniqueResult();
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
    return pessoa;
    }

    @Override
    public Pessoa BuscarPessoaCpf(String cpf) {
     
        Pessoa pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        try{
      
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa where cpf = :cpf");
           query.setParameter("cpf",cpf);
           pessoa = (Pessoa)query.uniqueResult();
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
        
    return pessoa;
    }

    @Override
    public List<Pessoa> BuscarTodos() {
      
        Pessoa pessoa = null;
        Session sessao = null; 
        Query query = null;
        Transaction transacao = null;
        
        List<Pessoa> lista = null;
        
        try{
           sessao = HibernateUtil.getSessionFactory().openSession();
           transacao = sessao.beginTransaction();
           query = sessao.createQuery("from Pessoa");
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
 
