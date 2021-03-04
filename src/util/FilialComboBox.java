package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import model.domain.Filial;

public class FilialComboBox extends AbstractListModel implements ComboBoxModel{

	private List<Filial> listaFilial;
	private Filial filialSelecionado;
	

public void comboBoxModel(){
this.listaFilial = new ArrayList<>();
} 

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listaFilial.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return this.listaFilial.get(index);
	
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		if(anItem instanceof Filial){

			this.filialSelecionado = (Filial) anItem;
			fireContentsChanged(this.listaFilial,0,this.listaFilial.size());
			}
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.filialSelecionado;
	
	}
	
	
	
	public void addFilial(Filial sFilial){
		
		try {
		this.listaFilial.add(sFilial);
		}catch(Exception er) {
			JOptionPane.showMessageDialog(null, er);
		}
		
		
		}


		public void reset(){
		this.listaFilial.clear(); 
		}

}
