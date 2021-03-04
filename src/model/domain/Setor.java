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


@Entity
@Table(name = "setor")
@NamedQueries({ @NamedQuery(name = "Setor.listar", query = "SELECT setor FROM Setor setor WHERE setor.nome_setor LIKE CONCAT('%',CONCAT(:palavra, '%'))"),
	    @NamedQuery(name = "Setor.listar1", query = "SELECT setor FROM Setor setor ORDER BY nome_setor ASC"),
		@NamedQuery(name = "Setor.buscarPorCodigo", query = "SELECT setor FROM Setor setor WHERE setor.idSetor = :idSetor"),
		@NamedQuery(name = "Setor.buscarUltimo", query = "SELECT setor FROM Setor setor ORDER BY setor.idSetor DESC"),
        @NamedQuery(name = "Setor.preenche", query = "SELECT setor.nome_setor, setor.dataCadastro, setor.dataModificacao FROM Setor setor ORDER BY nome_setor ASC"),
        @NamedQuery(name = "Setor.preencheCombo", query = "SELECT setor.nome_setor FROM Setor setor ORDER BY nome_setor ASC"),
        @NamedQuery(name = "Setor.buscaCaractere", query = "SELECT setor.nome_setor, setor.dataCadastro, setor.dataModificacao FROM Setor setor WHERE setor.nome_setor LIKE CONCAT('%',CONCAT(:palavra, '%'))")})

public class Setor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_setor")
	private Integer idSetor;
	
	//@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
	//@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "nome_setor", length = 25, nullable = false)
	private  String nome_setor;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_modificado")
	private Date dataModificacao;
	
	
	
	public Setor () {
		
		
	}


	public Integer getIdSetor() {
		return idSetor;
	}


	public void setIdSetor(Integer idSetor) {
		this.idSetor = idSetor;
	}


	public String getNomeSetor() {
		return nome_setor;
	}


	public void setNomeSetor(String nome_setor) {
		this.nome_setor =nome_setor;
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
		result = prime * result + ((nome_setor == null) ? 0 : nome_setor.hashCode());
		result = prime * result + ((idSetor == null) ? 0 : idSetor.hashCode());
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
		Setor other = (Setor) obj;
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
		if (nome_setor == null) {
			if (other.nome_setor != null)
				return false;
		} else if (!nome_setor.equals(other.nome_setor))
			return false;
		if (idSetor == null) {
			if (other.idSetor != null)
				return false;
		} else if (!idSetor.equals(other.idSetor))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Setor [idSetor=" + idSetor + ", setor=" + nome_setor + ", dataCadastro=" + dataCadastro
				+ ", dataModificacao=" + dataModificacao + "]";
	}


	

}
