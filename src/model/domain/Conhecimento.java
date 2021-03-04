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
import javax.persistence.Table;
//import javax.validation.constraints.Size;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "conhecimento")
@NamedQueries({ @NamedQuery(name = "Conhecimento.listar", query = "SELECT conhecimento FROM Conhecimento conhecimento WHERE conhecimento.titulo LIKE CONCAT('%',CONCAT(:palavra, '%'))"),
	    @NamedQuery(name = "Conhecimento.listar1", query = "SELECT conhecimento FROM Conhecimento conhecimento ORDER BY titulo ASC"),
		@NamedQuery(name = "Conhecimento.buscarPorCodigo", query = "SELECT conhecimento FROM Conhecimento conhecimento WHERE conhecimento.idConhecimento = :idConhecimento"),
		@NamedQuery(name = "Conhecimento.buscarPorFK", query = "SELECT conhecimento FROM Conhecimento conhecimento WHERE conhecimento.categoria = :idCateg"),

		@NamedQuery(name = "Conhecimento.buscarUltimo", query = "SELECT conhecimento FROM Conhecimento conhecimento ORDER BY conhecimento.idConhecimento DESC"),
        @NamedQuery(name = "Conhecimento.preenche", query = "SELECT cct.titulo, c.nome_categoria, cct.dataCadastro FROM Conhecimento cct INNER JOIN cct.categoria c WHERE c.setor= :idSetor ORDER BY titulo ASC"),
        @NamedQuery(name = "Conhecimento.buscaCaractere", query = "SELECT conhecimento.titulo, c.nome_categoria, conhecimento.dataCadastro FROM Conhecimento conhecimento INNER JOIN conhecimento.categoria c INNER JOIN c.setor s WHERE conhecimento.titulo LIKE CONCAT('%',CONCAT(:palavra, '%')) AND s.idSetor= :idsetor"),
        @NamedQuery(name = "Conhecimento.buscaCaractere2", query = "SELECT conhecimento.titulo, categoria.nome_categoria, conhecimento.dataCadastro FROM Conhecimento conhecimento WHERE conhecimento.titulo LIKE CONCAT('%',CONCAT(:palavra, '%')) AND conhecimento.categoria=:idCateg")})

public class Conhecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conhecimento")
	private Integer idConhecimento;
	
	//@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
	//@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "titulo", length = 50, nullable = false)
	private  String titulo;
	
	@Column(name = "desc_cct", length = 1500, nullable = false)
	private  String descCct;
	
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_modificado")
	private Date dataModificacao;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria", nullable = false)
	private Categoria categoria;
	
	
	
	public Conhecimento () {		
	}



	public Integer getIdConhecimento() {
		return idConhecimento;
	}



	public void setIdConhecimento(Integer idConhecimento) {
		this.idConhecimento = idConhecimento;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getDescCct() {
		return descCct;
	}



	public void setDescCct(String descCct) {
		this.descCct = descCct;
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



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((descCct == null) ? 0 : descCct.hashCode());
		result = prime * result + ((idConhecimento == null) ? 0 : idConhecimento.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Conhecimento other = (Conhecimento) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
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
		if (descCct == null) {
			if (other.descCct != null)
				return false;
		} else if (!descCct.equals(other.descCct))
			return false;
		if (idConhecimento == null) {
			if (other.idConhecimento != null)
				return false;
		} else if (!idConhecimento.equals(other.idConhecimento))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Conhecimento [idConhecimento=" + idConhecimento + ", titulo=" + titulo + ", descCct=" + descCct
				+ ", dataCadastro=" + dataCadastro + ", dataModificacao=" + dataModificacao + ", categoria=" + categoria
				+ "]";
	}





	
}
