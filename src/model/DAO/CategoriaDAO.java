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
import util.Sessao;
import model.domain.Categoria;
import model.domain.Setor;
import model.domain.Usuario;

public class CategoriaDAO {
	
		
public int salvar(Categoria categoria) {
			
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(categoria);
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
	public List<Categoria> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> categorias = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Categoria.listar");
			categorias = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categorias;
	}	
	
	
	public List<Categoria> preenche() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> categorias = null;
		
		try {
		
			  
			   Usuario usu = new Usuario();
		        usu=Sessao.getInstance().getUsuario();
				
		        Setor setor = new Setor();
		        setor=usu.getSetor();
			
			Query consulta = sessao.getNamedQuery("Categoria.preenche").setParameter("IdSetor", setor.getIdSetor());
			categorias = consulta.list();
			//System.out.println(categorias);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categorias;
	}	
	
	
	
	public List<Categoria> preencheBusca(String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> categorias = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Categoria.buscaCaractere");
			consulta.setString("palavra", palavra);
			categorias = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categorias;
	}	
	
	/*
	public Categoria buscaTabela(int index) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		   List <Categoria> categorias = null;
		   Categoria categoria = null;
		  try {
				Query consulta = sessao.getNamedQuery("Categoria.preenche");
				categorias = consulta.list();
				categoria = categorias.get(index);		
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		return categoria;
	}
	
	*/
	public Categoria buscarLinha(int linha,String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Categoria> categorias = null;
	   Categoria categoria = null;

	   if(palavra.equalsIgnoreCase("N")) {//Busca normal
		   try {
			   
			   Usuario usu = new Usuario();
		        usu=Sessao.getInstance().getUsuario();
				
		        Setor setor = new Setor();
		        setor=usu.getSetor();
			   
			   
				Query consulta = sessao.getNamedQuery("Categoria.listar1").setParameter("IdSetor", setor.getIdSetor());
				categorias = consulta.list();
				categoria = categorias.get(linha);	
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		   
	   }else{//busca por nome da categoria
	   
	   try {
			Query consulta = sessao.getNamedQuery("Categoria.listar");
			consulta.setString("palavra",palavra);	
			categorias = consulta.list();
			categoria = categorias.get(linha);	
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
	   
	   }
		return categoria;
	}	

	
	
	
	
	public Categoria buscarPerfil(int linha,String perfil) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Categoria> categorias = null;
	   Categoria categoria = null;
		try {
			Query consulta = sessao.getNamedQuery("Categoria.buscaCaractere");
			consulta.setString("palavra",perfil);	

			categorias = consulta.list();
		
			
			
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categoria;
	}	
	
	
	
	
	
	
	
	public List<Categoria>preencheCombo(int idSetor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> categorias = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Categoria.preencheCombo");
			consulta.setLong("IdSetor", idSetor);		
			categorias = consulta.list();
			
			} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categorias;
		
	}
	
	
	
	public Categoria buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Categoria categoria = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Categoria.buscarPorCodigo");
			consulta.setLong("idCategoria", codigo);
			categoria = (Categoria) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categoria;
	}
	
	
	
	public Categoria buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Categoria categoria = null;

		try {
			Query consulta = sessao.getNamedQuery("Categoria.buscarUltimo");
			consulta.setMaxResults(1);
			
			categoria = (Categoria)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return categoria;
		
	}
	
	
	public void excluir(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(categoria);
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
	
	public int editar(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
        int retorno=0;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(categoria);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	
