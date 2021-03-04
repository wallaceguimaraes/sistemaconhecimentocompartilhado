package model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

		
	@Entity
	@Table(name = "usuario")
	@NamedQueries({ @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.usuario LIKE CONCAT('%',CONCAT(:palavra, '%'))"),
		 @NamedQuery(name = "Usuario.listar1", query = "SELECT usuario FROM Usuario usuario ORDER BY usuario.usuario ASC"),
			@NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.idUsuario = :idUsuario"),
			@NamedQuery(name = "Usuario.validaUsuario", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login"),
			@NamedQuery(name = "Usuario.buscarUltimo", query = "SELECT usuario FROM Usuario usuario ORDER BY usuario.idUsuario DESC"),
	        @NamedQuery(name = "Usuario.preenche", query = "SELECT usu.usuario, p.regra, s.nome_setor, f.filial, usu.dataCadastro FROM Usuario usu INNER JOIN usu.regra p INNER JOIN usu.setor s INNER JOIN usu.filial f ORDER BY usuario ASC"),
	        @NamedQuery(name = "Usuario.buscaCaractere", query = "SELECT usuario.usuario, regra.regra, setor.nome_setor, filial.filial, usuario.dataCadastro FROM Usuario usuario WHERE usuario.usuario LIKE CONCAT('%',CONCAT(:palavra, '%'))")})
	public class Usuario {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id_usuario")
		private Integer idUsuario;
		
		//@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
		//@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
		@Column(name = "usuario", length = 50, nullable = false)
		private  String usuario;
		
		@Column(name = "login", length = 45, nullable = false)
		private  String login;
		
		
		@Column(name = "senha", length = 45, nullable = false)
		private  String senha;
		
		
		@Temporal(value = TemporalType.TIMESTAMP)
		@Column(name = "data_cadastro", nullable = false)
		private Date dataCadastro;
		
		
		@Temporal(value = TemporalType.TIMESTAMP)
		@Column(name = "data_modificado")
		private Date dataModificacao;
		
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "fk_id_filial", referencedColumnName = "id_filial", nullable = false)
		private Filial filial;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "fk_id_setor", referencedColumnName = "id_setor", nullable = false)
		private Setor setor;
		
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "fk_id_regra", referencedColumnName = "id_regra", nullable = false)
		private Regra regra;
		
		
		public Usuario () {
			
			
		}


		public Integer getIdUsuario() {
			return idUsuario;
		}


		public void setIdUsuario(Integer idUsuario) {
			this.idUsuario = idUsuario;
		}


		public String getUsuario() {
			return usuario;
		}


		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}


		public String getLogin() {
			return login;
		}


		public void setLogin(String login) {
			this.login = login;
		}


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			this.senha = senha;
		}


		public Date getDataCadastro() {
			return dataCadastro;
		}


		public void setDataCadastro(Date dataCadastro) {
			this.dataCadastro = dataCadastro;
		}


		public Date getDataModificacao() {
			return dataModificacao;
		}


		public void setDataModificacao(Date dataModificacao) {
			this.dataModificacao = dataModificacao;
		}


		public Filial getFilial() {
			return filial;
		}


		public void setFilial(Filial filial) {
			this.filial = filial;
		}


		public Setor getSetor() {
			return setor;
		}


		public void setSetor(Setor setor) {
			this.setor = setor;
		}


		public Regra getRegra() {
			return regra;
		}


		public void setRegra(Regra regra) {
			this.regra = regra;
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
			result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
			result = prime * result + ((filial == null) ? 0 : filial.hashCode());
			result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
			result = prime * result + ((login == null) ? 0 : login.hashCode());
			result = prime * result + ((regra == null) ? 0 : regra.hashCode());
			result = prime * result + ((senha == null) ? 0 : senha.hashCode());
			result = prime * result + ((setor == null) ? 0 : setor.hashCode());
			result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (dataCadastro == null) {
				if (other.dataCadastro != null)
					return false;
			} else if (!dataCadastro.equals(other.dataCadastro))
				return false;
			if (dataModificacao == null) {
				if (other.dataModificacao != null)
					return false;
			} else if (!dataModificacao.equals(other.dataModificacao))
				return false;
			if (filial == null) {
				if (other.filial != null)
					return false;
			} else if (!filial.equals(other.filial))
				return false;
			if (idUsuario == null) {
				if (other.idUsuario != null)
					return false;
			} else if (!idUsuario.equals(other.idUsuario))
				return false;
			if (login == null) {
				if (other.login != null)
					return false;
			} else if (!login.equals(other.login))
				return false;
			if (regra == null) {
				if (other.regra != null)
					return false;
			} else if (!regra.equals(other.regra))
				return false;
			if (senha == null) {
				if (other.senha != null)
					return false;
			} else if (!senha.equals(other.senha))
				return false;
			if (setor == null) {
				if (other.setor != null)
					return false;
			} else if (!setor.equals(other.setor))
				return false;
			if (usuario == null) {
				if (other.usuario != null)
					return false;
			} else if (!usuario.equals(other.usuario))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Usuario [idUsuario=" + idUsuario + ", usuario=" + usuario + ", login=" + login + ", senha=" + senha
					+ ", dataCadastro=" + dataCadastro + ", dataModificacao=" + dataModificacao + ", filial=" + filial
					+ ", setor=" + setor + ", regra=" + regra + "]";
		}	
	}
