package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Choice;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JMenu;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import model.DAO.CategoriaDAO;
import model.DAO.RegraDAO;
import model.DAO.SetorDAO;
import model.DAO.CategoriaDAO;
import model.domain.Categoria;
import model.domain.Regra;
import model.domain.Setor;
import model.domain.Usuario;
import util.Sessao;
import util.SetorComboBox;
import util.modeloTabela;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Scrollbar;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class vwCategoria {

	public JFrame frmcategoria;
	private JTextField textFieldCategoria;
	private JTable table;
	//private final Action action = new SwingAction();

	Categoria cat = null;
	//List <Setor>setor = new List<Setor>() {
	int flag = 1;
	ArrayList<Categoria> categoriasArray = new ArrayList<>();


	private JTextField textFieldEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwCategoria window = new vwCategoria();
					window.frmcategoria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwCategoria() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmcategoria = new JFrame();
		frmcategoria.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				
				try {
					vwMen window = new vwMen();
					window.frmmenu.setVisible(true);
					frmcategoria.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
		frmcategoria.setTitle("Usu\u00E1rio: "+usu.getUsuario());
		frmcategoria.setResizable(false);
		frmcategoria.getContentPane().setBackground(new Color(240, 255, 255));
		frmcategoria.getContentPane().setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 122, 552);
		frmcategoria.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(10, 35, 102, 77);

		ImageIcon imagem = new ImageIcon("C:\\Wallace Guimaraes\\Desktop\\imagem.png");
		Image imag = imagem.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_DEFAULT);

		lblimg.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\imagem.png"));

		panel.add(lblimg);
		Panel panelCategoria = new Panel();
		panelCategoria.setBackground(new Color(250, 250, 210));
		panelCategoria.setBounds(4, 10, 113, 23);
		panel.add(panelCategoria);
		panelCategoria.setLayout(null);
		
		
		
		
        Regra regra = new Regra();
        regra=Sessao.getInstance().getRegra();
		
		Label lblCategoria = new Label(regra.getRegra());
		lblCategoria.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 9));
		lblCategoria.setBounds(0, 0, 107, 23);
		panelCategoria.add(lblCategoria);
		JLabel label_Usuarios = new JLabel("");
		label_Usuarios.setToolTipText("Usu\u00E1rios");
		label_Usuarios.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adm.png"));
		label_Usuarios.setBounds(37, 184, 50, 56);
		panel.add(label_Usuarios);
		JLabel label_Contatos = new JLabel("");
		label_Contatos.setToolTipText("Contatos");
		label_Contatos
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\contato.png"));
		label_Contatos.setBounds(33, 310, 50, 56);
		panel.add(label_Contatos);
		JLabel label_Perfis = new JLabel("");
		label_Perfis.setToolTipText("Perfis");
		label_Perfis
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\perfil.png"));
		label_Perfis.setBounds(34, 250, 57, 49);
		panel.add(label_Perfis);
		JLabel label_Conhecimento = new JLabel("");
		label_Conhecimento.setToolTipText("Conhecimento compartilhado");
		label_Conhecimento
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sccimg.png"));
		label_Conhecimento.setBounds(34, 120, 57, 49);
		panel.add(label_Conhecimento);
		JLabel label_Categorias = new JLabel("");
		label_Categorias.setToolTipText("Categorias");
		label_Categorias
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\cat.png"));
		label_Categorias.setBounds(35, 386, 65, 49);
		panel.add(label_Categorias);
		JLabel label_Setores = new JLabel("");
		label_Setores.setToolTipText("Setores");
		label_Setores
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\setor.png"));
		label_Setores.setBounds(37, 446, 46, 49);
		panel.add(label_Setores);
		JLabel label_Emp = new JLabel("");
		label_Emp.setToolTipText("Filiais");
		label_Emp.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\emp.png"));
		label_Emp.setBounds(35, 506, 56, 42);
		panel.add(label_Emp);

		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(138, 10, 916, 34);
		frmcategoria.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Label label_1 = new Label("Categorias");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(10, 10, 333, 22);
		panel_2.add(label_1);

		Label label_6 = new Label("Sair");
		label_6.setFont(new Font("Dialog", Font.ITALIC, 10));
		label_6.setBounds(608, 10, 33, 22);
		panel_2.add(label_6);

		Label label_7 = new Label("Sobre");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println("Informa��es!");
			}
		});
		label_7.setFont(new Font("Dialog", Font.ITALIC, 10));
		label_7.setBounds(569, 10, 33, 22);
		panel_2.add(label_7);
		JLabel label_2 = new JLabel("");

		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				System.out.println("Voltei!");


			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setForeground(Color.cyan);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setForeground(Color.RED);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				label_2.setForeground(Color.RED);

			}
		});

		label_2.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\f.png"));
		label_2.setBounds(538, 5, 25, 25);
		panel_2.add(label_2);

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(138, 68, 901, 75);
		frmcategoria.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Bem vindo(a) ao Sistema de Conhecimento Compartilhado!");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 10, 361, 23);
		panel_1.add(label);

		Label label_3 = new Label("Adicione novas categorias");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label_3.setBounds(730, 47, 140, 22);
		panel_1.add(label_3);
		JLabel label_adiciona = new JLabel("");

		label_adiciona
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adiciona.png"));
		label_adiciona.setBounds(870, 39, 25, 36);
		panel_1.add(label_adiciona);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(138, 48, 916, 2);
		frmcategoria.getContentPane().add(separator);

		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(138, 149, 901, 57);
		frmcategoria.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblCategoria_1 = new JLabel("Categoria:");
		lblCategoria_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblCategoria_1.setBounds(10, 13, 91, 14);
		panel_5.add(lblCategoria_1);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(10, 26, 250, 20);
		panel_5.add(textFieldCategoria);
		textFieldCategoria.setColumns(10);

		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setVisible(false);

		buttonSalvar.setBounds(820, 24, 70, 22);
		panel_5.add(buttonSalvar);
		buttonSalvar.setBackground(new Color(173, 216, 230));
		buttonSalvar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLabel labelBuscar = new JLabel("");

		labelBuscar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\bu.png"));
		labelBuscar.setBounds(270, 20, 28, 33);
		panel_5.add(labelBuscar);
		
		SetorComboBox setorComboModel= new SetorComboBox();

		
	    JComboBox comboBoxSetor = new JComboBox();
	    comboBoxSetor.setVisible(false);
		comboBoxSetor.setBounds(340, 25, 226, 22);
		panel_5.add(comboBoxSetor);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setVisible(false);
		lblSetor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblSetor.setBounds(340, 11, 46, 14);
		panel_5.add(lblSetor);
		
		
	    
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(1044, 58, 10, 521);
		frmcategoria.getContentPane().add(panel_6);

		Panel panel_7 = new Panel();
		panel_7.setBackground(new Color(220, 220, 220));
		panel_7.setBounds(10, 568, 779, 11);
		frmcategoria.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		Panel panel_8 = new Panel();
		panel_8.setBackground(new Color(220, 220, 220));
		panel_8.setBounds(138, 54, 916, 10);
		frmcategoria.getContentPane().add(panel_8);
		Panel panel_10 = new Panel();
		panel_10.setBackground(new Color(240, 255, 255));
		panel_10.setBounds(138, 282, 901, 271);
		frmcategoria.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(173, 216, 230));
		scrollPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setBounds(0, 0, 901, 271);
		panel_10.add(scrollPane);
		table = new JTable();

		table.setSelectionBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));

		table.setBackground(new Color(250, 250, 210));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "  Categoria   ", "  Setor   ", "  Cadastro " }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(154);
		table.getColumnModel().getColumn(1).setPreferredWidth(162);
		table.getColumnModel().getColumn(2).setPreferredWidth(142);
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBounds(138, 218, 901, 52);
		frmcategoria.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		textFieldEditar = new JTextField();
		textFieldEditar.setVisible(false);
		textFieldEditar.setBounds(10, 27, 248, 20);
		panel_3.add(textFieldEditar);
		textFieldEditar.setColumns(10);
		JLabel label_CategoriaEdit = new JLabel("Categoria:");
		label_CategoriaEdit.setVisible(false);

		label_CategoriaEdit.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_CategoriaEdit.setBounds(10, 11, 80, 14);
		panel_3.add(label_CategoriaEdit);
		JLabel lbl_alterarSalvar = new JLabel("");
		lbl_alterarSalvar.setToolTipText("Alterar item...");
		
	     JComboBox comboBoxEditar = new JComboBox();


		//listaSetores();
		
		
		//comboBoxSetor.setSelectedItem(setor.);

		
	
	
		
		
//CONTROLADORES E M�TODOS

		
		
		
	preencheComboBox();
		
		SetorDAO setorDao = new SetorDAO();
		ArrayList<Setor> setores = new ArrayList<>();
	    Setor set = new Setor();
		setores.addAll(preencheComboBox());
        
		for(int i=0;i < setores.size();i++) {
			comboBoxSetor.addItem(setores.get(i));
            comboBoxEditar.addItem(setores.get(i));			
		}
		
		
		
		
		label_Conhecimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Pagina inicial
				try {
					vwConhecimento window = new vwConhecimento();
					window.frmconhecimento.setVisible(true);
					frmcategoria.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		label_Usuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// P�gina usu�rios
				
				Regra regra = new Regra();
				regra=Sessao.getInstance().getRegra();
				
				if(regra.getPermissao()!=3) {
					
				JOptionPane.showMessageDialog(null, "Voc� n�o possui permiss�o de acesso, contate seu administrador!");	
				}else {
				
				try {
					vwUsuario window = new vwUsuario();
					window.frmusuario.setVisible(true);
					frmcategoria.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

				}
				
			}
		});

		label_Perfis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Perfis
				
				Regra regra = new Regra();
				regra=Sessao.getInstance().getRegra();
				
				if(regra.getPermissao()!=3) {
					
					JOptionPane.showMessageDialog(null, "Voc� n�o possui permiss�o de acesso, contate seu administrador!");
				}else {

				try {
					vwRegra window = new vwRegra();
					window.frmperfil.setVisible(true);
					frmcategoria.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			 }
			}
		});

		label_Contatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Contatos
			}
		});

		

		label_Setores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// 
				try {
					vwSetor window = new vwSetor();
					window.frmsetor.setVisible(true);
					frmcategoria.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				
			}
		});

		label_Emp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Filiais
				
				Regra regra = new Regra();
				regra=Sessao.getInstance().getRegra();
				
				if(regra.getPermissao()!=3) {
				JOptionPane.showMessageDialog(null, "Voc� n�o possui permiss�o de acesso, contate seu administrador!");	
					
				}else {
				
				try {
					vwFilial window = new vwFilial();
					window.frmfilial.setVisible(true);
					frmcategoria.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				}
			}
		});

		
		lbl_alterarSalvar.setVisible(false);
		lbl_alterarSalvar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sal.png"));
		lbl_alterarSalvar.setBounds(570, 25, 29, 23);
		panel_3.add(lbl_alterarSalvar);
		JLabel labelCancelar = new JLabel("");
		labelCancelar.setToolTipText("Cancelar opera\u00E7\u00E3o...");
		
		labelCancelar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\canc.png"));
		labelCancelar.setBounds(805, 22, 25, 25);
		panel_3.add(labelCancelar);
		JLabel lbl_editar = new JLabel("");
		lbl_editar.setToolTipText("Editar item...");
	
		lbl_editar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\alterarv.png"));
		lbl_editar.setBounds(835, 22, 25, 25);
		panel_3.add(lbl_editar);
		JLabel label_excluir = new JLabel("");
		label_excluir.setToolTipText("Remover item...");
		label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cat != null) {

					int num = JOptionPane.showConfirmDialog(null,
							"Voc� tem certeza que deseja excluir a categoria \n        " + cat.getNomeCategoria()
									+ " da lista?");

					if (num == 0) {
						CategoriaDAO categoriaDao = new CategoriaDAO();
						Categoria categoria = new Categoria();
						categoriaDao.excluir(cat);
						cat = null;
						preencheTabela();
						JOptionPane.showMessageDialog(null, "O item foi exclu�do com sucesso!");
						textFieldEditar.setText("");
						flag = 1;
						textFieldCategoria.setText("");
						preencheTabela();
					} else {
						// nao excl
					}
				} else {
					JOptionPane.showMessageDialog(null, "Escolha um item da lista para excluir!");
				}

			}
		});
		label_excluir
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\remover.png"));
		label_excluir.setBounds(870, 22, 25, 25);
		panel_3.add(label_excluir);
		
	     comboBoxEditar.setVisible(false);
	     
	     
	
	     
	     
		comboBoxEditar.setBounds(340, 26, 230, 22);
		panel_3.add(comboBoxEditar);
		
		JLabel lblSetorEditar = new JLabel("Setor:");
		lblSetorEditar.setVisible(false);
		lblSetorEditar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblSetorEditar.setBounds(340, 12, 46, 14);
		panel_3.add(lblSetorEditar);

		
		 
		
		
		lbl_alterarSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				CategoriaDAO categoriaDao = new CategoriaDAO();
				if (textFieldEditar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos vazio n�o podem ser alterados!");
				} else {

					int val;
					val = JOptionPane.showConfirmDialog(null, "Voc� deseja realmente alterar o item?");

					int var = textFieldCategoria.getText().length();

					if (var <= 25) {

						if (val == 0) {

							int retorno;
                            
							SetorDAO setorDao=new SetorDAO();
							Setor setor = new Setor();
							Date dat = new Date();
							Date data = new Date();
							SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							dat = new Date(formatador.format(data));
							cat.setNomeCategoria(textFieldEditar.getText());
							
						    int index = comboBoxEditar.getSelectedIndex();
							setor=setorDao.buscarLinha(index,"N");
                            cat.setSetor(setor);  
							 
							cat.setDataModificacao(dat);
							retorno = categoriaDao.editar(cat);

							if (retorno == 1) {
								preencheTabela();
								JOptionPane.showMessageDialog(null, "O item da lista foi alterado com sucesso!");
								label_CategoriaEdit.setVisible(false);
								textFieldEditar.setVisible(false);
								lbl_alterarSalvar.setVisible(false);
								lblSetorEditar.setVisible(false);
								comboBoxEditar.setVisible(false);
								textFieldCategoria.setText("");
								
							} else {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o item!");
							}
						} else {
							//
						}

					} else {
						JOptionPane.showMessageDialog(null, "O campo deve possuir no m�ximo '25' caracteres! ");

					}

				}
			}
		});

		
		
		
		
		labelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldCategoria.setText("");

				label_CategoriaEdit.setVisible(false);
				textFieldEditar.setVisible(false);
				// btnAltera.setVisible(false);
				lbl_alterarSalvar.setVisible(false);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);
                lblSetorEditar.setVisible(false);
                comboBoxEditar.setVisible(false);
                comboBoxSetor.setVisible(false);
                lblSetor.setVisible(false);
				
				
				cat = null;
				flag = 1;
				preencheTabela();

			}
		});
		
		
		
	
		lbl_editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				label_CategoriaEdit.setVisible(true);
				textFieldEditar.setVisible(true);
				// btnAltera.setVisible(true);
				lbl_alterarSalvar.setVisible(true);
				
				lblSetorEditar.setVisible(true);
				comboBoxEditar.setVisible(true);
				lblSetor.setVisible(false);
				comboBoxSetor.setVisible(false);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);
				
				

				// preencheTabela();

			}
		});
		
		
		
		
		
		label_adiciona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				labelBuscar.setVisible(false);
				buttonSalvar.setVisible(true);
				lbl_alterarSalvar.setVisible(false);
				label_CategoriaEdit.setVisible(false);
				textFieldEditar.setVisible(false);
				textFieldCategoria.setText("");
				lblSetor.setVisible(true);
				comboBoxSetor.setVisible(true);
				lblSetorEditar.setVisible(false);
				comboBoxEditar.setVisible(false);


			}
		});

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validar numero de caracteres

				if (textFieldCategoria.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha o campo!");

				} else {
					int var = textFieldCategoria.getText().length();
					System.out.println("Categoria "+textFieldCategoria.getText());


					if (var <= 25) {

						Categoria categoria = new Categoria();
						categoria.setNomeCategoria(textFieldCategoria.getText().trim());
						System.out.println(categoria.getNomeCategoria());
                 
						SetorDAO setorDao = new SetorDAO();
						Setor setor = new Setor();
						
						int index=comboBoxSetor.getSelectedIndex();
						System.out.println("Linha "+index);
												
						setor=setorDao.buscarLinha(index,"N");
						categoria.setSetor(setor);
                        
						salvar(categoria);
						buttonSalvar.setVisible(false);
						labelBuscar.setVisible(true);
						comboBoxSetor.setVisible(false);
						lblSetor.setVisible(false);
						

						textFieldCategoria.setText("");
						flag = 1;

						preencheTabela();
					} else {
						JOptionPane.showMessageDialog(null, "O campo deve possuir no m�ximo '25' caracteres! ");
					}

				}
			}
		});

		labelBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				CategoriaDAO categoriaDao = new CategoriaDAO();

				textFieldEditar.setText("");

				List<Categoria> categorias = null;
				categoriaDao.preencheBusca(textFieldCategoria.getText());
				flag = 2;
				cat = null;
				categorias = preencheTabelaBusca();

			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(138, 274, 901, 2);
		frmcategoria.getContentPane().add(separator_1);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(138, 210, 901, 2);
		frmcategoria.getContentPane().add(separator_2);

		preencheTabela();

		frmcategoria.setBackground(SystemColor.inactiveCaption);
		frmcategoria.setBounds(100, 100, 1070, 617);
		frmcategoria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		table.addMouseListener(new MouseAdapter() {//Tabela seleciona
			@Override
			public void mouseClicked(MouseEvent e) {

				CategoriaDAO categoriaDao = new CategoriaDAO();

				int linha = table.getSelectedRow();

				if (flag == 1) {

					cat = categoriaDao.buscarLinha(linha,"N");
					textFieldEditar.setText(cat.getNomeCategoria());

				} else if (flag == 2) {
					cat = categoriaDao.buscarLinha(linha, textFieldCategoria.getText());
					textFieldEditar.setText(cat.getNomeCategoria());

				}
			}
		});

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void preencheTabela() {

		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<Categoria> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Categoria   ", "  Setor   " };
		dados.addAll(categoriaDao.preenche());
		categoriasArray=dados;

		modeloTabela modelo = new modeloTabela(dados, Colunas);
		table.setModel(modelo);
	}


	public List<Setor> preencheComboBox() {
		
		SetorComboBox setorComboModel= new SetorComboBox();
		
		SetorDAO setorDao = new SetorDAO();
		ArrayList<Setor> setores = new ArrayList<>();
		setores.addAll(setorDao.preencheCombo());
		
		//System.out.println("VW metodo "+setores);
		//Setor set=new Setor();

		return setores;
	
	}
	
	/*
	 public void listaSetores(){
	
		SetorDAO setorDao = new SetorDAO();
		ArrayList<Setor> dados = new ArrayList<>();

		dados.addAll(setorDao.preenche());
        setor=dados;
		
		
		
		
		
	}
	*/
	
	public List<Categoria> preencheTabelaBusca() {

		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<Categoria> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Categoria   ", "  Setor   ", " Cadastro  " };
		dados.addAll(categoriaDao.preencheBusca(textFieldCategoria.getText()));
		modeloTabela modelo = new modeloTabela(dados, Colunas);

		table.setModel(modelo);

		return dados;

	}

	public void salvar(Categoria set) {
		try {
			Categoria categoria = new Categoria();
			CategoriaDAO categoriaDao = new CategoriaDAO();
			Date dat = new Date();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dat = new Date(formatador.format(data));
			set.setDataCadastro(dat);
			int retorno;
			retorno = categoriaDao.salvar(set);
			if (retorno == 1) {
				JOptionPane.showMessageDialog(null, "Categoria salva com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "O categoria n�o foi salva!");
				// JOptionPane.show
			}
		} catch (RuntimeException er) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar a categoria:" + er);
		}
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}