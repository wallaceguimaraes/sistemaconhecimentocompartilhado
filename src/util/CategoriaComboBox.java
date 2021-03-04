package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import model.domain.Categoria;

public class CategoriaComboBox extends AbstractListModel implements ComboBoxModel{

	private List<Categoria> listaCategoria;
	private Categoria categoriaSelecionado;
	

public void comboBoxModel(){
this.listaCategoria = new ArrayList<>();
} 

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listaCategoria.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return this.listaCategoria.get(index);
	
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		if(anItem instanceof Categoria){

			this.categoriaSelecionado = (Categoria) anItem;
			fireContentsChanged(this.listaCategoria,0,this.listaCategoria.size());
			}
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.categoriaSelecionado;
	
	}
	
	
	
	public void addCategoria(Categoria sCategoria){
		
		try {
		this.listaCategoria.add(sCategoria);
		}catch(Exception er) {
			JOptionPane.showMessageDialog(null, er);
		}
		
		
		}


		public void reset(){
		this.listaCategoria.clear(); 
		}

}
