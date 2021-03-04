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
import model.domain.Usuario;
import model.domain.Setor;

public class UsuarioDAO {
	
		
public int salvar(Usuario usuario) {
			
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(usuario);
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
	public List<Usuario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;
	}	
	
	
	public List<Usuario> preenche() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;
	
		
		try {
			
			  
			//   Usuario usu = new Usuario();
		      //  usu=Sessao.getInstance().getUsuario();
				
		      //  Setor setor = new Setor();
		      //  setor=usu.getSetor();
			
			Query consulta = sessao.getNamedQuery("Usuario.preenche");
			usuarios = consulta.list();
			//System.out.println(usuarios);			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;
	}	
	
	
	
	public List<Usuario> preencheBusca(String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscaCaractere");
			consulta.setString("palavra", palavra);
			usuarios = consulta.list();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;
	}	
	
	/*
	public Usuario buscaTabela(int index) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		   List <Usuario> usuarios = null;
		   Usuario usuario = null;
		  try {
				Query consulta = sessao.getNamedQuery("Usuario.preenche");
				usuarios = consulta.list();
				usuario = usuarios.get(index);		
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		return usuario;
	}
	
	*/
	public Usuario buscarLinha(int linha,String palavra) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Usuario> usuarios = null;
	   Usuario usuario = null;

	   if(palavra.equalsIgnoreCase("N")) {//Busca normal
		   try {
				Query consulta = sessao.getNamedQuery("Usuario.listar1");
				usuarios = consulta.list();
				usuario = usuarios.get(linha);	
			} catch (RuntimeException ex) {			
				throw ex;
			} finally {
				sessao.close();
			}
		   
	   }else{//busca por nome da usuario
	   
	   try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			consulta.setString("palavra",palavra);	
			usuarios = consulta.list();
			usuario = usuarios.get(linha);	
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
	   
	   }
		return usuario;
	}	

	
	
	
	
	public Usuario buscarPerfil(int linha,String perfil) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	   List <Usuario> usuarios = null;
	   Usuario usuario = null;
		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscaCaractere");
			consulta.setString("palavra",perfil);	

			usuarios = consulta.list();
		
			
			
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Usuario buscarPorCodigo(Long codigo) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorCodigo");
			consulta.setLong("idUsuario", codigo);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
	}
	
	
	
public Usuario validaUsuario(String login) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Usuario.validaUsuario");
			consulta.setString("login", login);
			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
	}
	
	
	public Usuario buscarUltimo() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarUltimo");
			consulta.setMaxResults(1);
			
			usuario = (Usuario)consulta.uniqueResult();
			
		} catch (RuntimeException ex) {			
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
		
	}
	
	
	public void excluir(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
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
	
	public int editar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
        int retorno=0;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(usuario);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	
