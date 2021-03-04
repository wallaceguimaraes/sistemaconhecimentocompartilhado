package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

import model.domain.Regra;

public class RegraComboBox extends AbstractListModel implements ComboBoxModel{

	private List<Regra> listaRegra;
	private Regra regraSelecionado;
	

public void comboBoxModel(){
this.listaRegra = new ArrayList<>();
} 

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return listaRegra.size();
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return this.listaRegra.get(index);
	
	}

	@Override
	public void setSelectedItem(Object anItem) {
		// TODO Auto-generated method stub
		if(anItem instanceof Regra){

			this.regraSelecionado = (Regra) anItem;
			fireContentsChanged(this.listaRegra,0,this.listaRegra.size());
			}
		
	}

	@Override
	public Object getSelectedItem() {
		// TODO Auto-generated method stub
		return this.regraSelecionado;
	
	}
	
	
	
	public void addRegra(Regra sRegra){
		
		try {
		this.listaRegra.add(sRegra);
		}catch(Exception er) {
			JOptionPane.showMessageDialog(null, er);
		}
		
		
		}


		public void reset(){
		this.listaRegra.clear(); 
		}

}
