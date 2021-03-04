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

//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;

import util.HibernateUtil;
import model.domain.Setor;

public class SetorDAO {
	
		
public int salvar(Setor setor) {
			
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(setor);
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
	public List<Setor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Setor> setors = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Setor.listar");
			setors = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setors;
	}	
	
	
	public List<Setor> preenche() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Setor> setors = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Setor.preenche");
			setors = consulta.list();
			//System.out.println(setors);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setors;
	}	
	
	public List<Setor>preencheCombo(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Setor> setors = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Setor.preencheCombo");
			setors = consulta.list();
			
			
			System.out.println("Dao "+setors);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setors;
		
	}
	
	
	public List<Setor> preencheBusca(String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Setor> setors = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Setor.buscaCaractere");
			consulta.setString("palavra", palavra);
			setors = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setors;
	}	
	
	
	public Setor buscarLinha(int linha,String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Setor> setors = null;
	   Setor setor = null;

	   if(palavra.equalsIgnoreCase("N")) {//Busca normal
		   try {
				Query consulta = sessao.getNamedQuery("Setor.listar1");
				setors = consulta.list();
				setor = setors.get(linha);		
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		   
	   }else{//busca por nome da setor
	   
	   try {
			Query consulta = sessao.getNamedQuery("Setor.listar");
			consulta.setString("palavra",palavra);	
			setors = consulta.list();
			setor = setors.get(linha);	
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
	   
	   }
		return setor;
	}	

	
	
	
	
	public Setor buscarPerfil(int linha,String perfil) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Setor> setors = null;
	   Setor setor = null;
		try {
			Query consulta = sessao.getNamedQuery("Setor.buscaCaractere");
			consulta.setString("palavra",perfil);	

			setors = consulta.list();
		
			
			
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setor;
	}	
	
	
	
	
	
	
	
	
	
	public Setor buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Setor setor = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Setor.buscarPorCodigo");
			consulta.setLong("idSetor", codigo);
			setor = (Setor) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setor;
	}
	
	
	
	public Setor buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Setor setor = null;

		try {
			Query consulta = sessao.getNamedQuery("Setor.buscarUltimo");
			consulta.setMaxResults(1);
			
			setor = (Setor)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return setor;
		
	}
	
	
	public void excluir(Setor setor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(setor);
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
	
	public int editar(Setor setor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
        int retorno=0;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(setor);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	
