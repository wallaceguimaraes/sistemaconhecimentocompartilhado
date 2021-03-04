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
import model.domain.Filial;
import model.domain.Setor;

public class FilialDAO {

	public int salvar(Filial filial) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(filial);
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
	public List<Filial> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filial> filials = null;

		try {
			Query consulta = sessao.getNamedQuery("Filial.listar");
			filials = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filials;
	}

	
	
	
	
	public List<Filial>preencheCombo(){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filial> filiais = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Filial.preencheCombo");
			filiais = consulta.list();
			
			
			System.out.println("Dao "+filiais);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return filiais;
		
	}
	
	
	public List<Filial> preenche() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filial> filials = null;

		try {
			Query consulta = sessao.getNamedQuery("Filial.preenche");
			filials = consulta.list();
			// System.out.println(filials);
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filials;
	}

	public List<Filial> preencheBusca(String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filial> filials = null;

		try {
			Query consulta = sessao.getNamedQuery("Filial.buscaCaractere");
			consulta.setString("palavra", palavra);
			filials = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filials;
	}

	public Filial buscarLinha(int linha, String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filial> filials = null;
		Filial filial = null;

		if (palavra.equalsIgnoreCase("N")) {// Busca normal
			try {
				Query consulta = sessao.getNamedQuery("Filial.listar1");
				filials = consulta.list();
				filial = filials.get(linha);
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}

		} else {// busca por nome da filial

			try {
				Query consulta = sessao.getNamedQuery("Filial.listar");
				consulta.setString("palavra", palavra);
				filials = consulta.list();
				filial = filials.get(linha);
			} catch (RuntimeException ex) {
				throw ex;
			} finally {
				sessao.close();
			}

		}
		return filial;
	}

	public Filial buscarPerfil(int linha, String perfil) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Filial> filials = null;
		Filial filial = null;
		try {
			Query consulta = sessao.getNamedQuery("Filial.buscaCaractere");
			consulta.setString("palavra", perfil);

			filials = consulta.list();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filial;
	}

	public Filial buscarPorCodigo(Long codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Filial filial = null;

		try {
			Query consulta = sessao.getNamedQuery("Filial.buscarPorCodigo");
			consulta.setLong("idFilial", codigo);
			filial = (Filial) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filial;
	}

	public Filial buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Filial filial = null;

		try {
			Query consulta = sessao.getNamedQuery("Filial.buscarUltimo");
			consulta.setMaxResults(1);

			filial = (Filial) consulta.uniqueResult();

		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return filial;

	}

	public void excluir(Filial filial) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(filial);
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

	public int editar(Filial filial) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		int retorno = 0;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(filial);
			transacao.commit();
			retorno = 1;
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
