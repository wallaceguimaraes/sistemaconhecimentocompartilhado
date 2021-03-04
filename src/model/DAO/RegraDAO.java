package model.DAO;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;

import util.HibernateUtil;
import model.domain.Regra;
import model.domain.Regra;

public class RegraDAO {
	
		
public int salvar(Regra regra) {
			
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(regra);
			transacao.commit();
			return 1;
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			return 0;
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Regra> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Regra> regras = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Regra.listar");
			regras = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regras;
	}	
	
	
	
	
	public List<Regra>preencheCombo(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Regra> regras = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Regra.preencheCombo");
			regras = consulta.list();
			
			
			System.out.println("Dao "+regras);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regras;
		
	}
	
	
	public List<Regra> preenche() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Regra> regras = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Regra.preenche");
			regras = consulta.list();
			//System.out.println(regras);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regras;
	}	
	
	
	
	public List<Regra> preencheBusca(String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Regra> regras = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Regra.buscaCaractere");
			consulta.setString("palavra", palavra);
			regras = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regras;
	}	
	
	
	public Regra buscarLinha(int linha,String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Regra> regras = null;
	   Regra regra = null;

	   if(palavra.equalsIgnoreCase("N")) {
		   try {
				Query consulta = sessao.getNamedQuery("Regra.listar1");
				//consulta.setString("palavra",palavra);	

				regras = consulta.list();
				regra = regras.get(linha);
				
				
				
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		   
	   }else {
	   
	   try {
			Query consulta = sessao.getNamedQuery("Regra.listar");
			consulta.setString("palavra",palavra);	

			regras = consulta.list();
			regra = regras.get(linha);
			
			
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
	   
	   
	   }
	   
		return regra;
	}	

	
	
	
	
	public Regra buscarPerfil(int linha,String perfil) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Regra> regras = null;
	   Regra regra = null;
		try {
			Query consulta = sessao.getNamedQuery("Regra.buscaCaractere");
			consulta.setString("palavra",perfil);	

			regras = consulta.list();
		
			
			
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regra;
	}	
	
	
	
	
	
	
	
	
	
	public Regra buscarPorCodigo(int codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Regra regra = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Regra.buscarPorCodigo");
			consulta.setLong("idRegra", codigo);
			regra = (Regra) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regra;
	}
	
	
	
	
	
	
	public Regra buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Regra regra = null;

		try {
			Query consulta = sessao.getNamedQuery("Regra.buscarUltimo");
			consulta.setMaxResults(1);
			
			regra = (Regra)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return regra;
		
	}
	
	
	public void excluir(Regra regra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(regra);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}

	}
	
	public int editar(Regra regra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
        int retorno=0;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(regra);
			transacao.commit();
			retorno=1;
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			
			}
			throw ex;
		} finally {
			sessao.close();
		}	
	
	return retorno;
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


