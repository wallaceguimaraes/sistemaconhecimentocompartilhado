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

import model.DAO.ConhecimentoDAO;
import model.DAO.RegraDAO;
import model.DAO.CategoriaDAO;
import model.DAO.ConhecimentoDAO;
import model.domain.Conhecimento;
import model.domain.Regra;
import model.domain.Setor;
import model.domain.Usuario;
import model.domain.Categoria;
import util.CategoriaComboBox;
import util.Sessao;
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

public class vwMen {

	public JFrame frmmenu;
	private JTextField textFieldTitulo;
	private JTable table;
	//private final Action action = new SwingAction();

	Conhecimento cct = null;
	//List <Categoria>categoria = new List<Categoria>() {
	int flag = 1;
	ArrayList<Conhecimento> conhecimentosArray = new ArrayList<>();


	private JTextField textFieldEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwMen window = new vwMen();
					window.frmmenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwMen() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmmenu = new JFrame();
		frmmenu.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					vwLogin window = new vwLogin();
					window.frmLogin.setVisible(true);
					frmmenu.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
	
		frmmenu.setResizable(false);
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
		frmmenu.setTitle("Usu\u00E1rio: "+usu.getUsuario());
		
		
		frmmenu.getContentPane().setBackground(new Color(240, 255, 255));
		frmmenu.getContentPane().setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 122, 552);
		frmmenu.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(10, 35, 102, 77);

		ImageIcon imagem = new ImageIcon("C:\\Wallace Guimaraes\\Desktop\\imagem.png");
		Image imag = imagem.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_DEFAULT);

		lblimg.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\imagem.png"));

		panel.add(lblimg);
		Panel panelConhecimento = new Panel();
		panelConhecimento.setBackground(new Color(250, 250, 210));
		panelConhecimento.setBounds(4, 10, 113, 23);
		panel.add(panelConhecimento);
		panelConhecimento.setLayout(null);
		
		Regra regra = new Regra();
        regra=Sessao.getInstance().getRegra();
		
		Label lblFuncao = new Label(regra.getRegra());//Buscar perfil
		
		
		lblFuncao.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 9));
		lblFuncao.setBounds(0, 0, 107, 23);
		panelConhecimento.add(lblFuncao);
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
		label_Conhecimento.setToolTipText("Conhecimento");
		label_Conhecimento
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sccimg.png"));
		label_Conhecimento.setBounds(34, 120, 57, 49);
		panel.add(label_Conhecimento);
		JLabel label_Categoria = new JLabel("");
		label_Categoria.setToolTipText("Categorias");
		label_Categoria
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\cat.png"));
		label_Categoria.setBounds(35, 386, 65, 49);
		panel.add(label_Categoria);
		
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
		panel_2.setBounds(138, 10, 963, 34);
		frmmenu.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Label label_1 = new Label("In\u00EDcio");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(10, 10, 333, 22);
		panel_2.add(label_1);

		Label label_6 = new Label("Sair");
		label_6.setFont(new Font("Dialog", Font.ITALIC, 10));
		label_6.setBounds(920, 10, 33, 22);
		panel_2.add(label_6);

		Label label_7 = new Label("Sobre");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println("Informações!");
			}
		});
		label_7.setFont(new Font("Dialog", Font.ITALIC, 10));
		label_7.setBounds(881, 10, 33, 22);
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
		label_2.setBounds(850, 7, 25, 25);
		panel_2.add(label_2);

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(138, 68, 947, 75);
		frmmenu.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Seja bem vindo(a) ao Sistema de Conhecimento Compartilhado!");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 30, 361, 23);
		panel_1.add(label);
		JLabel label_adiciona = new JLabel("");
		label_adiciona.setVisible(false);

		label_adiciona
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adiciona.png"));
		label_adiciona.setBounds(915, 39, 25, 36);
		panel_1.add(label_adiciona);
		
		Label label_4 = new Label("Para encontrar as informa\u00E7\u00F5es que voc\u00EA precisa, escolha a categoria desejada  e/ou escreva parte do \"t\u00EDtulo\" da informa\u00E7\u00E3o.");
		label_4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label_4.setBounds(10, 53, 641, 22);
		panel_1.add(label_4);
		
		JLabel label_loginUsu = new JLabel(usu.getLogin());
		label_loginUsu.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_loginUsu.setBounds(15, 4, 282, 25);
		panel_1.add(label_loginUsu);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(138, 48, 963, 2);
		frmmenu.getContentPane().add(separator);

		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(138, 149, 947, 57);
		frmmenu.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblConhecimento_1 = new JLabel("T\u00EDtulo:");
		lblConhecimento_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblConhecimento_1.setBounds(10, 28, 41, 14);
		panel_5.add(lblConhecimento_1);

		textFieldTitulo = new JTextField();
		textFieldTitulo.setBounds(61, 26, 320, 20);
		panel_5.add(textFieldTitulo);
		textFieldTitulo.setColumns(10);

		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setVisible(false);

		buttonSalvar.setBounds(870, 24, 70, 22);
		panel_5.add(buttonSalvar);
		buttonSalvar.setBackground(new Color(173, 216, 230));
		buttonSalvar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLabel labelBuscar = new JLabel("");

		labelBuscar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\bu.png"));
		labelBuscar.setBounds(391, 20, 28, 33);
		panel_5.add(labelBuscar);
		
		CategoriaComboBox categoriaComboModel= new CategoriaComboBox();

		
	    JComboBox comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBounds(574, 11, 229, 22);
		panel_5.add(comboBoxCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setVisible(false);
		lblCategoria.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblCategoria.setBounds(494, 14, 70, 14);
		panel_5.add(lblCategoria);
		
		
	    
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(1091, 58, 10, 521);
		frmmenu.getContentPane().add(panel_6);

		Panel panel_7 = new Panel();
		panel_7.setBackground(new Color(220, 220, 220));
		panel_7.setBounds(10, 568, 973, 11);
		frmmenu.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		Panel panel_8 = new Panel();
		panel_8.setBackground(new Color(220, 220, 220));
		panel_8.setBounds(138, 54, 963, 10);
		frmmenu.getContentPane().add(panel_8);
		Panel panel_10 = new Panel();
		panel_10.setBackground(new Color(240, 255, 255));
		panel_10.setBounds(138, 282, 947, 271);
		frmmenu.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(173, 216, 230));
		scrollPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setBounds(0, 0, 947, 271);
		panel_10.add(scrollPane);
		table = new JTable();

		table.setSelectionBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));

		table.setBackground(new Color(250, 250, 210));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "  Conhecimento   ", "  Categoria   ", "  Cadastro " }) {
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
		panel_3.setBounds(138, 218, 947, 52);
		frmmenu.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		textFieldEditar = new JTextField();
		textFieldEditar.setVisible(false);
		textFieldEditar.setBounds(10, 27, 320, 20);
		panel_3.add(textFieldEditar);
		textFieldEditar.setColumns(10);
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setVisible(false);

		lblTtulo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblTtulo.setBounds(10, 11, 113, 14);
		panel_3.add(lblTtulo);
		JLabel lbl_alterarSalvar = new JLabel("");
		lbl_alterarSalvar.setVisible(false);
		lbl_alterarSalvar.setToolTipText("Alterar item...");
		
	     JComboBox comboBoxEditar = new JComboBox();
	     comboBoxEditar.setVisible(false);


		//listaCategoriaes();
		
		
		//comboBoxCategoria.setSelectedItem(categoria.);

		
	
	
		
		
//CONTROLADORES E MÉTODOS

		
		
		
	preencheComboBox();
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<Categoria> categoriaes = new ArrayList<>();
	    Categoria set = new Categoria();
		categoriaes.addAll(preencheComboBox());
        
		for(int i=0;i < categoriaes.size();i++) {
			comboBoxCategoria.addItem(categoriaes.get(i));
            comboBoxEditar.addItem(categoriaes.get(i));			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		label_Conhecimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Pagina inicial
				try {
					vwConhecimento window = new vwConhecimento();
					window.frmconhecimento.setVisible(true);
					frmmenu.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		label_Usuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Página usuários
				
				Regra regra = new Regra();
				regra=Sessao.getInstance().getRegra();
				
				if(regra.getPermissao()!=3) {
					
				JOptionPane.showMessageDialog(null, "Você não possui permissão de acesso, contate seu administrador!");	
				}else {
				
				try {
					vwUsuario window = new vwUsuario();
					window.frmusuario.setVisible(true);
					frmmenu.dispose();

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
					
					JOptionPane.showMessageDialog(null, "Você não possui permissão de acesso, contate seu administrador!");
				}else {

				try {
					vwRegra window = new vwRegra();
					window.frmperfil.setVisible(true);
					frmmenu.dispose();

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

		label_Categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				try {
					vwCategoria window = new vwCategoria();
					window.frmcategoria.setVisible(true);
					frmmenu.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				
			}
		});

		label_Setores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Categoriaes
				try {
					vwSetor window = new vwSetor();
					window.frmsetor.setVisible(true);
					frmmenu.dispose();

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
				JOptionPane.showMessageDialog(null, "Você não possui permissão de acesso, contate seu administrador!");	
					
				}else {
				
				try {
					vwFilial window = new vwFilial();
					window.frmfilial.setVisible(true);
					frmmenu.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				}
			}
		});
		
		
		
		
		lbl_alterarSalvar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sal.png"));
		lbl_alterarSalvar.setBounds(630, 25, 29, 23);
		panel_3.add(lbl_alterarSalvar);
		JLabel labelCancelar = new JLabel("");
		labelCancelar.setToolTipText("Cancelar opera\u00E7\u00E3o...");
		
		labelCancelar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\canc.png"));
		labelCancelar.setBounds(912, 22, 25, 25);
		panel_3.add(labelCancelar);
		JLabel lbl_editar = new JLabel("");
		lbl_editar.setVisible(false);
		lbl_editar.setToolTipText("Editar item...");
	
		lbl_editar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\alterarv.png"));
		lbl_editar.setBounds(837, 22, 25, 25);
		panel_3.add(lbl_editar);
		JLabel label_excluir = new JLabel("");
		label_excluir.setVisible(false);
		label_excluir.setToolTipText("Remover item...");
		label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (cct != null) {

					int num = JOptionPane.showConfirmDialog(null,
							"Você tem certeza que deseja excluir o item da base de dados?");

					if (num == 0) {
						ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
						Conhecimento conhecimento = new Conhecimento();
						conhecimentoDao.excluir(cct);
						cct = null;
						preencheTabela();
						JOptionPane.showMessageDialog(null, "O item foi excluído com sucesso!");
						textFieldEditar.setText("");
						flag = 1;
						textFieldTitulo.setText("");
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
		label_excluir.setBounds(802, 22, 25, 25);
		panel_3.add(label_excluir);
	     
	     
	
	     
	     
		comboBoxEditar.setBounds(400, 26, 230, 22);
		panel_3.add(comboBoxEditar);
		
		JLabel lblCategoriaEditar = new JLabel("Categoria:");
		lblCategoriaEditar.setVisible(false);
		lblCategoriaEditar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblCategoriaEditar.setBounds(400, 12, 98, 14);
		panel_3.add(lblCategoriaEditar);
		
		JLabel lblVer = new JLabel("");
		lblVer.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\visualizar.png"));
		lblVer.setVisible(false);
		lblVer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

        Sessao sessao = Sessao.getInstance();
        sessao.setConhecimento(cct);
				
	
			
				try {
					
				
					
					vwVerConhecimento window = new vwVerConhecimento();
					window.frmverconhecimento.setVisible(true);
					frmmenu.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		});
		lblVer.setBounds(872, 22, 30, 25);
		panel_3.add(lblVer);

		
		 
		
		
		lbl_alterarSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
				if (textFieldEditar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos vazio não podem ser alterados!");
				} else {

					int val;
					val = JOptionPane.showConfirmDialog(null, "Você deseja realmente alterar o item?");

					int var = textFieldTitulo.getText().length();

					if (var <= 50) {

						if (val == 0) {

							int retorno;
                            
							CategoriaDAO categoriaDao=new CategoriaDAO();
							Categoria categoria = new Categoria();
							Date dat = new Date();
							Date data = new Date();
							SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							dat = new Date(formatador.format(data));
							cct.setTitulo(textFieldEditar.getText());
							
						    int index = comboBoxEditar.getSelectedIndex();
							categoria=categoriaDao.buscarLinha(index,"N");
                            cct.setCategoria(categoria);  
							 
							cct.setDataModificacao(dat);
							retorno = conhecimentoDao.editar(cct);

							if (retorno == 1) {
								preencheTabela();
								JOptionPane.showMessageDialog(null, "O item da lista foi alterado com sucesso!");
								lblTtulo.setVisible(false);
								textFieldEditar.setVisible(false);
								lbl_alterarSalvar.setVisible(false);
								lblCategoriaEditar.setVisible(false);
								comboBoxEditar.setVisible(false);
								textFieldTitulo.setText("");
								
							} else {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o item!");
							}
						} else {
							//
						}

					} else {
						JOptionPane.showMessageDialog(null, "O campo deve possuir no máximo '25' caracteres! ");

					}

				}
			}
		});

		
		
		
		
		labelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldTitulo.setText("");

				lblTtulo.setVisible(false);
				textFieldEditar.setVisible(false);
				// btnAltera.setVisible(false);
				lbl_alterarSalvar.setVisible(false);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);
                lblCategoriaEditar.setVisible(false);
                comboBoxEditar.setVisible(false);
                //comboBoxCategoria.setVisible(false);
                //lblCategoria.setVisible(false);
                lblVer.setVisible(false);
				
				
				cct = null;
				flag = 1;
				preencheTabela();

			}
		});
		
		
		
	
		lbl_editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				lblTtulo.setVisible(true);
				textFieldEditar.setVisible(true);
				// btnAltera.setVisible(true);
				lbl_alterarSalvar.setVisible(true);
				
				lblCategoriaEditar.setVisible(true);
				comboBoxEditar.setVisible(true);
				lblCategoria.setVisible(false);
				comboBoxCategoria.setVisible(false);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);
				
				

				// preencheTabela();

			}
		});
		
		
		
		
		
		label_adiciona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				labelBuscar.setVisible(false);
				//buttonSalvar.setVisible(true);
				lbl_alterarSalvar.setVisible(false);
				lblTtulo.setVisible(false);
				textFieldEditar.setVisible(false);
				textFieldTitulo.setText("");
				//lblCategoria.setVisible(true);
				//comboBoxCategoria.setVisible(true);
				lblCategoriaEditar.setVisible(false);
				comboBoxEditar.setVisible(false);
				
				try {
					vwAddConhecimento window = new vwAddConhecimento();
					window.frmaddconhecimento.setVisible(true);
					frmmenu.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				
				


			}
		});

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validar numero de caracteres

				if (textFieldTitulo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha o campo!");

				} else {
					int var = textFieldTitulo.getText().length();
					System.out.println("Conhecimento "+textFieldTitulo.getText());


					if (var <= 25) {

						Conhecimento conhecimento = new Conhecimento();
						conhecimento.setTitulo(textFieldTitulo.getText().trim());
						System.out.println(conhecimento.getTitulo());
                 
						CategoriaDAO categoriaDao = new CategoriaDAO();
						Categoria categoria = new Categoria();
						
						int index=comboBoxCategoria.getSelectedIndex();
						System.out.println("Linha "+index);
												
						categoria=categoriaDao.buscarLinha(index,"N");
						conhecimento.setCategoria(categoria);
                        
						salvar(conhecimento);
						buttonSalvar.setVisible(false);
						labelBuscar.setVisible(true);
						comboBoxCategoria.setVisible(false);
						lblCategoria.setVisible(false);
						

						textFieldTitulo.setText("");
						flag = 1;

						preencheTabela();
					} else {
						JOptionPane.showMessageDialog(null, "O campo deve possuir no máximo '25' caracteres! ");
					}

				}
			}
		});

		labelBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();

				textFieldEditar.setText("");
                 
				List<Conhecimento> conhecimentos = null;
				//conhecimentoDao.preencheBusca(textFieldTitulo.getText());
				flag = 2;
				cct = null;
				
				conhecimentos = preencheTabelaBusca();
				
				
				
				/*
				if(textFieldTitulo.getText().isEmpty()) {
					System.out.println("entrou");
				
				List<Conhecimento> conhecimentos = null;
				//conhecimentoDao.preencheBusca(textFieldTitulo.getText());
				flag = 2;
				cct = null;
				
				conhecimentos = preencheTabelaBusca(comboBoxCategoria.getSelectedIndex());
				}else{
					System.out.println("entrou 2"+textFieldTitulo.getText());

					List<Conhecimento> conhecimentos = null;
					//conhecimentoDao.preencheBusca(textFieldTitulo.getText());
					flag = 2;
					cct = null;
					
					conhecimentos = preencheTabelaBusca2(comboBoxCategoria.getSelectedIndex());
					
					
				}
				
				*/
				

			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(138, 274, 947, 2);
		frmmenu.getContentPane().add(separator_1);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(138, 210, 947, 2);
		frmmenu.getContentPane().add(separator_2);

		preencheTabela();

		frmmenu.setBackground(new Color(173, 216, 230));
		frmmenu.setBounds(100, 100, 1113, 617);
		frmmenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		table.addMouseListener(new MouseAdapter() {//Tabela seleciona
			@Override
			public void mouseClicked(MouseEvent e) {
				
				

				lblVer.setVisible(true);
				
				ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();

				int linha = table.getSelectedRow();

				if (flag == 1) {

					
					
					cct = conhecimentoDao.buscarLinha(linha,"N");
					textFieldEditar.setText(cct.getTitulo());

				} else if (flag == 2) {
					cct = conhecimentoDao.buscarLinha(linha, textFieldTitulo.getText());
					textFieldEditar.setText(cct.getTitulo());

				}
			}
		});

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void preencheTabela() {

		ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
		ArrayList<Conhecimento> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Título   ", "  Categoria   ","  Cadastro  " };
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
        Setor setor = new Setor();
        
        setor=usu.getSetor();
		
		dados.addAll(conhecimentoDao.preenche(setor.getIdSetor()));
		conhecimentosArray=dados;

		modeloTabela modelo = new modeloTabela(dados, Colunas);
		table.setModel(modelo);
	}


	public List<Categoria> preencheComboBox() {
		
		CategoriaComboBox categoriaComboModel= new CategoriaComboBox();
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<Categoria> categoriaes = new ArrayList<>();
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
        
        System.out.println(usu);
		
        Setor setor = new Setor();
        
        
        if(usu.getSetor()==null) {
        	System.out.println("Esta nulo");
        }else {
        	
            setor=usu.getSetor();
            System.out.println(setor);

        	
        }
        
        setor=usu.getSetor();
		
		categoriaes.addAll(categoriaDao.preencheCombo(setor.getIdSetor()));
		
	

		return categoriaes;
	
	}
	
	
	public List<Conhecimento> preencheTabelaBusca() {

		ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
		ArrayList<Conhecimento> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Conhecimento   ", "  Categoria   ", " Cadastro  " };
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		Categoria categoria = new Categoria();
		
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
        Setor setor = new Setor();
        
        setor=usu.getSetor();
		
		//categoria=categoriaDao.buscarLinha(linha, "N");
		dados.addAll(conhecimentoDao.preencheBusca(textFieldTitulo.getText(),setor.getIdSetor()));
		
		System.out.println(dados);
		
		modeloTabela modelo = new modeloTabela(dados, Colunas);

		table.setModel(modelo);

		return dados;

	}
	
	
	
	public List<Conhecimento> preencheTabelaBusca2(int linha){
		
		ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
		ArrayList<Conhecimento> dados = new ArrayList<>();
		
		
		String[] Colunas = new String[] { "  Conhecimento   ", "  Categoria   ", " Cadastro  " };
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		Categoria categoria = new Categoria();
		categoria=categoriaDao.buscarLinha(linha, "N");
		dados.addAll(conhecimentoDao.buscarPorFK(categoria.getIdCategoria()));
		modeloTabela modelo = new modeloTabela(dados, Colunas);

		table.setModel(modelo);

		return dados;
		
	}
	
	
	

	public void salvar(Conhecimento set) {
		try {
			Conhecimento conhecimento = new Conhecimento();
			ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
			Date dat = new Date();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dat = new Date(formatador.format(data));
			set.setDataCadastro(dat);
			int retorno;
			retorno = conhecimentoDao.salvar(set);
			if (retorno == 1) {
				JOptionPane.showMessageDialog(null, "Conhecimento salva com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "O conhecimento não foi salva!");
				// JOptionPane.show
			}
		} catch (RuntimeException er) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar a conhecimento:" + er);
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