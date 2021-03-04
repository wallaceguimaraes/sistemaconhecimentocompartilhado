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
import model.domain.Conhecimento;
import model.domain.Setor;

public class ConhecimentoDAO {
	
		
public int salvar(Conhecimento conhecimento) {
			
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(conhecimento);
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
	public List<Conhecimento> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Conhecimento> conhecimentos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.listar");
			conhecimentos = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimentos;
	}	
	
	
	public List<Conhecimento> preenche(int idSetor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Conhecimento> conhecimentos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.preenche");
			consulta.setInteger("idSetor", idSetor);
			conhecimentos = consulta.list();
			//System.out.println(conhecimentos);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimentos;
	}	
	
	
	
	public List<Conhecimento> preencheBusca2(String palavra, int idcategoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Conhecimento> conhecimentos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.buscaCaractere2").setParameter("palavra",palavra).setParameter("idCateg", idcategoria);
			//consulta.setString("palavra", palavra);
			//consulta.setInteger("idCateg", idcategoria);
			conhecimentos = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimentos;
	}	
	
	
	
	public List<Conhecimento> preencheBusca(String palavra, int idSetor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Conhecimento> conhecimentos = null;
		//int codigo = 2;
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.buscaCaractere").setParameter("palavra",palavra).setParameter("idsetor", idSetor);
			//consulta.setString("palavra", palavra);
			conhecimentos = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimentos;
	}	
	
	/*
	public Conhecimento buscaTabela(int index) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		   List <Conhecimento> conhecimentos = null;
		   Conhecimento conhecimento = null;
		  try {
				Query consulta = sessao.getNamedQuery("Conhecimento.preenche");
				conhecimentos = consulta.list();
				conhecimento = conhecimentos.get(index);		
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		return conhecimento;
	}
	
	*/
	public Conhecimento buscarLinha(int linha,String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Conhecimento> conhecimentos = null;
	   Conhecimento conhecimento = null;

	   if(palavra.equalsIgnoreCase("N")) {//Busca normal
		   try {
				Query consulta = sessao.getNamedQuery("Conhecimento.listar1");
				conhecimentos = consulta.list();
				conhecimento = conhecimentos.get(linha);	
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		   
	   }else{//busca por nome da conhecimento
	   
	   try {
			Query consulta = sessao.getNamedQuery("Conhecimento.listar");
			consulta.setString("palavra",palavra);	
			conhecimentos = consulta.list();
			conhecimento = conhecimentos.get(linha);	
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
	   
	   }
		return conhecimento;
	}	

	
	
	
	
	public Conhecimento buscarPerfil(int linha,String perfil) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Conhecimento> conhecimentos = null;
	   Conhecimento conhecimento = null;
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.buscaCaractere");
			consulta.setString("palavra",perfil);	

			conhecimentos = consulta.list();
		
			
			
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimento;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Conhecimento buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Conhecimento conhecimento = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.buscarPorCodigo");
			consulta.setLong("idConhecimento", codigo);
			conhecimento = (Conhecimento) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimento;
	}
	
	
public List<Conhecimento >buscarPorFK(int codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Conhecimento> conhecimentos = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.buscarPorFK");
			consulta.setLong("idCateg", codigo);
			conhecimentos=consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimentos;
	}
	
	


	public Conhecimento buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Conhecimento conhecimento = null;

		try {
			Query consulta = sessao.getNamedQuery("Conhecimento.buscarUltimo");
			consulta.setMaxResults(1);
			
			conhecimento = (Conhecimento)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return conhecimento;
		
	}
	
	
	public void excluir(Conhecimento conhecimento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(conhecimento);
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
	
	public int editar(Conhecimento conhecimento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
        int retorno=0;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(conhecimento);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	
