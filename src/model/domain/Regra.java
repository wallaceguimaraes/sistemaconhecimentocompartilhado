package model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
//import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//import org.hibernate.validator.constraints.NotEmpty;



//SELECT regra FROM Regra WHERE "id_regra"="perfil "LIMIT "linha", 1;

@Entity
@Table(name = "regra")
@NamedQueries({ @NamedQuery(name = "Regra.listar", query = "SELECT regra FROM Regra regra WHERE regra.regra LIKE CONCAT('%',CONCAT(:palavra, '%'))"),
	    @NamedQuery(name = "Regra.listar1", query = "SELECT regra FROM Regra regra ORDER BY regra ASC"),
		@NamedQuery(name = "Regra.buscarPorCodigo", query = "SELECT regra FROM Regra regra WHERE regra.idRegra = :idRegra"),
		@NamedQuery(name = "Regra.buscarUltimo", query = "SELECT regra FROM Regra regra ORDER BY regra.idRegra DESC"),
        @NamedQuery(name = "Regra.preenche", query = "SELECT regra.regra, regra.permissao, regra.dataCadastro, regra.dataModificacao FROM Regra regra ORDER BY regra ASC"),
        @NamedQuery(name = "Regra.preencheCombo", query = "SELECT regra.regra FROM Regra regra ORDER BY regra ASC"),
        @NamedQuery(name = "Regra.buscaCaractere", query = "SELECT regra.regra, regra.permissao, regra.dataCadastro, regra.dataModificacao FROM Regra regra WHERE regra.regra LIKE CONCAT('%',CONCAT(:palavra, '%'))")})

public class Regra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_regra")
	private Integer idRegra;
	
	//@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
	//@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "regra", length = 30, nullable = false)
	private  String regra;
	
	
	@Column(name = "permissao", length = 1, nullable = false)
	private  Integer permissao;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_modificado")
	private Date dataModificacao;
	
	
	public Regra () {
		
		
	}


	public Integer getIdRegra() {
		return idRegra;
	}


	public void setIdRegra(Integer idRegra) {
		this.idRegra = idRegra;
	}


	public String getRegra() {
		return regra;
	}


	public void setRegra(String regra) {
		this.regra = regra;
	}


	
	
	
	public Integer getPermissao() {
		return permissao;
	}


	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((idRegra == null) ? 0 : idRegra.hashCode());
		result = prime * result + ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((regra == null) ? 0 : regra.hashCode());
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
		Regra other = (Regra) obj;
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
		if (idRegra == null) {
			if (other.idRegra != null)
				return false;
		} else if (!idRegra.equals(other.idRegra))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (regra == null) {
			if (other.regra != null)
				return false;
		} else if (!regra.equals(other.regra))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Regra [idRegra=" + idRegra + ", regra=" + regra + ", permissao=" + permissao + ", dataCadastro="
				+ dataCadastro + ", dataModificacao=" + dataModificacao + "]";
	}


	

}
