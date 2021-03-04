package util;

import model.domain.Conhecimento;
import model.domain.Regra;
import model.domain.Usuario;

public class Sessao{
	   private static Sessao instance = null;
	   private Conhecimento conhecimento;
	   private Usuario usuario;
	   private Regra regra;

	   private Sessao(){
	   }

	   public void setConhecimento(Conhecimento conhecimento){
	      this.conhecimento = conhecimento;
	   }

	   public Conhecimento getConhecimento(){
	       return conhecimento;
	   }
	   
	   
	   public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}

	public static Sessao getInstance(){
	         if(instance == null){
	               instance = new Sessao();
	         }
	        return instance;
	   }
	}