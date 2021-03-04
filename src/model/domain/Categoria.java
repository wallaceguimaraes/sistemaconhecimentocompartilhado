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
@Table(name = "categoria")
@NamedQueries({ @NamedQuery(name = "Categoria.listar", query = "SELECT categoria FROM Categoria categoria WHERE categoria.nome_categoria LIKE CONCAT('%',CONCAT(:palavra, '%'))"),
	    @NamedQuery(name = "Categoria.listar1", query = "SELECT categoria FROM Categoria categoria INNER JOIN categoria.setor s WHERE s.idSetor = :IdSetor ORDER BY nome_categoria ASC"),
		@NamedQuery(name = "Categoria.buscarPorCodigo", query = "SELECT categoria FROM Categoria categoria WHERE categoria.idCategoria = :idCategoria"),
		@NamedQuery(name = "Categoria.buscarUltimo", query = "SELECT categoria FROM Categoria categoria ORDER BY categoria.idCategoria DESC"),
        @NamedQuery(name = "Categoria.preenche", query = "SELECT c.nome_categoria, s.nome_setor FROM Categoria c INNER JOIN c.setor s WHERE s.idSetor = :IdSetor ORDER BY nome_categoria ASC"),
        @NamedQuery(name = "Categoria.preencheCombo", query = "SELECT c.nome_categoria FROM Categoria c INNER JOIN c.setor s WHERE s.idSetor = :IdSetor ORDER BY nome_categoria ASC"),
        @NamedQuery(name = "Categoria.buscaCaractere", query = "SELECT categoria.nome_categoria, categoria.dataCadastro, categoria.dataModificacao FROM Categoria categoria WHERE categoria.nome_categoria LIKE CONCAT('%',CONCAT(:palavra, '%'))")})

public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_categoria")
	private Integer idCategoria;
	
	//@NotEmpty(message = "O campo Nome do aluno é obrigatório!")
	//@Size(min = 8, max = 45, message = "Tamanho inválido para o campo 'Nome do aluno'! Campo deve possuir (8 - 45) caracteres.")
	@Column(name = "nome_categoria", length = 25, nullable = false)
	private  String nome_categoria;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data_modificado")
	private Date dataModificacao;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_setor", referencedColumnName = "id_setor", nullable = false)
	private Setor setor;
	
	
	
	public Categoria () {		
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNomeCategoria() {
		return nome_categoria;
	}


	public void setNomeCategoria(String nome_categoria) {
		this.nome_categoria =nome_categoria;
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


	public String getNome_categoria() {
		return nome_categoria;
	}


	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}


	public Setor getSetor() {
		return setor;
	}


	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
		result = prime * result + ((nome_categoria == null) ? 0 : nome_categoria.hashCode());
		result = prime * result + ((setor == null) ? 0 : setor.hashCode());
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
		Categoria other = (Categoria) obj;
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
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		if (nome_categoria == null) {
			if (other.nome_categoria != null)
				return false;
		} else if (!nome_categoria.equals(other.nome_categoria))
			return false;
		if (setor == null) {
			if (other.setor != null)
				return false;
		} else if (!setor.equals(other.setor))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nome_categoria=" + nome_categoria + ", dataCadastro="
				+ dataCadastro + ", dataModificacao=" + dataModificacao + ", setor=" + setor + "]";
	}
}
