package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import model.domain.Setor;

public class SetorComboBox extends AbstractListModel implements ComboBoxModel{

	private List<Setor> listaSetor;
	private Setor setorSelecionado;
	

public void comboBoxModel(){
this.listaSetor = new ArrayList<>();
} 

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listaSetor.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return this.listaSetor.get(index);
	
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		if(anItem instanceof Setor){

			this.setorSelecionado = (Setor) anItem;
			fireContentsChanged(this.listaSetor,0,this.listaSetor.size());
			}
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.setorSelecionado;
	
	}
	
	
	
	public void addSetor(Setor sSetor){
		
		try {
		this.listaSetor.add(sSetor);
		}catch(Exception er) {
			JOptionPane.showMessageDialog(null, er);
		}
		
		
		}


		public void reset(){
		this.listaSetor.clear(); 
		}

}
