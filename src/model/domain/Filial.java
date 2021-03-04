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
@Table(name = "filial")
@NamedQueries({ @NamedQuery(name = "Filial.listar", query = "SELECT filial FROM Filial filial WHERE filial.filial LIKE CONCAT('%',CONCAT(:palavra, '%'))"),
	    @NamedQuery(name = "Filial.listar1", query = "SELECT filial FROM Filial filial ORDER BY filial ASC"),
		@NamedQuery(name = "Filial.buscarPorCodigo", query = "SELECT filial FROM Filial filial WHERE filial.idFilial = :idFilial"),
		@NamedQuery(name = "Filial.buscarUltimo", query = "SELECT filial FROM Filial filial ORDER BY filial.idFilial DESC"),
        @NamedQuery(name = "Filial.preenche", query = "SELECT filial.filial, filial.dataCadastro, filial.dataModificacao FROM Filial filial ORDER BY filial ASC"),
        @NamedQuery(name = "Filial.preencheCombo", query = "SELECT filial.filial FROM Filial filial ORDER BY filial ASC"),
        @NamedQuery(name = "Filial.buscaCaractere", query = "SELECT filial.filial, filial.dataCadastro, filial.dataModificacao FROM Filial filial WHERE filial.filial LIKE CONCAT('%',CONCAT(:palavra, '%'))")})

public class Filial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_filial")
	private Integer idFilial;
	
	//@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
	//@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "filial", length = 35, nullable = false)
	private  String filial;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_modificado")
	private Date dataModificacao;
	
	
	public Filial () {
		
		
	}


	public Integer getIdFilial() {
		return idFilial;
	}


	public void setIdFilial(Integer idFilial) {
		this.idFilial = idFilial;
	}


	public String getFilial() {
		return filial;
	}


	public void setFilial(String filial) {
		this.filial = filial;
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
		result = prime * result + ((filial == null) ? 0 : filial.hashCode());
		result = prime * result + ((idFilial == null) ? 0 : idFilial.hashCode());
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
		Filial other = (Filial) obj;
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
		if (idFilial == null) {
			if (other.idFilial != null)
				return false;
		} else if (!idFilial.equals(other.idFilial))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Filial [idFilial=" + idFilial + ", filial=" + filial + ", dataCadastro=" + dataCadastro
				+ ", dataModificacao=" + dataModificacao + "]";
	}


	

}
