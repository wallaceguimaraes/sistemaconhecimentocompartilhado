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
import java.util.List;

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

import model.DAO.SetorDAO;
import model.DAO.SetorDAO;
import model.domain.Regra;
import model.domain.Setor;
import model.domain.Usuario;
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

public class vwSetor {

	public JFrame frmsetor;
	private JTextField textFieldSetor;
	private JTable table;
	private final Action action = new SwingAction();

	Setor set = null;
	int flag = 1;

	private JTextField textFieldEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwSetor window = new vwSetor();
					window.frmsetor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwSetor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmsetor = new JFrame();
		frmsetor.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			
				try {
					vwMen window = new vwMen();
					window.frmmenu.setVisible(true);
					frmsetor.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
			
			
		});
	
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
		frmsetor.setTitle("Usu\u00E1rio: "+usu.getUsuario());
		frmsetor.setResizable(false);
		frmsetor.getContentPane().setBackground(new Color(240, 255, 255));
		frmsetor.getContentPane().setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 122, 552);
		frmsetor.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(10, 35, 102, 77);

		ImageIcon imagem = new ImageIcon("C:\\Wallace Guimaraes\\Desktop\\imagem.png");
		Image imag = imagem.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_DEFAULT);

		lblimg.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\imagem.png"));

		panel.add(lblimg);
		Panel panelSetor = new Panel();
		panelSetor.setBackground(new Color(250, 250, 210));
		panelSetor.setBounds(4, 10, 113, 23);
		panel.add(panelSetor);
		panelSetor.setLayout(null);
		
		
		
        Regra regra = new Regra();
        regra=Sessao.getInstance().getRegra();
		
		Label lblSetor = new Label(regra.getRegra());
		lblSetor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 9));
		lblSetor.setBounds(0, 0, 107, 23);
		panelSetor.add(lblSetor);
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
		panel_2.setBounds(138, 10, 942, 34);
		frmsetor.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Label label_1 = new Label("Setores");
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

				System.out.println("Informações!");
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
		panel_1.setBounds(138, 68, 926, 75);
		frmsetor.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Bem vindo(a) ao Sistema de Conhecimento Compartilhado!");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 10, 361, 23);
		panel_1.add(label);

		Label label_3 = new Label("Adicione novos setores");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label_3.setBounds(760, 47, 121, 22);
		panel_1.add(label_3);
		JLabel label_adiciona = new JLabel("");

		label_adiciona
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adiciona.png"));
		label_adiciona.setBounds(890, 39, 25, 36);
		panel_1.add(label_adiciona);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(138, 48, 942, 2);
		frmsetor.getContentPane().add(separator);

		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(138, 149, 926, 57);
		frmsetor.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblSetor_1 = new JLabel("Setor:");
		lblSetor_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblSetor_1.setBounds(10, 13, 36, 14);
		panel_5.add(lblSetor_1);

		textFieldSetor = new JTextField();
		textFieldSetor.setBounds(58, 11, 278, 20);
		panel_5.add(textFieldSetor);
		textFieldSetor.setColumns(10);

		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setVisible(false);

		buttonSalvar.setBounds(840, 10, 70, 22);
		panel_5.add(buttonSalvar);
		buttonSalvar.setBackground(new Color(173, 216, 230));
		buttonSalvar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLabel labelBuscar = new JLabel("");

		labelBuscar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\bu.png"));
		labelBuscar.setBounds(338, 5, 28, 33);
		panel_5.add(labelBuscar);

		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(1070, 58, 10, 521);
		frmsetor.getContentPane().add(panel_6);

		Panel panel_7 = new Panel();
		panel_7.setBackground(new Color(220, 220, 220));
		panel_7.setBounds(10, 568, 1070, 11);
		frmsetor.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		Panel panel_8 = new Panel();
		panel_8.setBackground(new Color(220, 220, 220));
		panel_8.setBounds(138, 54, 942, 10);
		frmsetor.getContentPane().add(panel_8);
		Panel panel_10 = new Panel();
		panel_10.setBackground(new Color(240, 255, 255));
		panel_10.setBounds(138, 282, 926, 271);
		frmsetor.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(173, 216, 230));
		scrollPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setBounds(0, 0, 926, 271);
		panel_10.add(scrollPane);
		table = new JTable();

		table.setSelectionBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));

		table.setBackground(new Color(250, 250, 210));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "  Setor   ", "  Cadastro   ", " Última modificação  " }) {
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
		panel_3.setBounds(138, 218, 926, 52);
		frmsetor.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		textFieldEditar = new JTextField();
		textFieldEditar.setVisible(false);
		textFieldEditar.setBounds(10, 27, 281, 20);
		panel_3.add(textFieldEditar);
		textFieldEditar.setColumns(10);
		JLabel label_setedit = new JLabel("Setor:");
		label_setedit.setVisible(false);

		label_setedit.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_setedit.setBounds(10, 11, 36, 14);
		panel_3.add(label_setedit);
		JLabel lbl_alterarSalvar = new JLabel("");
		lbl_alterarSalvar.setToolTipText("Alterar item...");

//CONTROLADORES E MÉTODOS

		label_Conhecimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Pagina inicial
				try {
					vwConhecimento window = new vwConhecimento();
					window.frmconhecimento.setVisible(true);
					frmsetor.dispose();

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
					frmsetor.dispose();

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
					frmsetor.dispose();

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

		label_Categorias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				try {
					vwCategoria window = new vwCategoria();
					window.frmcategoria.setVisible(true);
					frmsetor.dispose();

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
					frmsetor.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				}
			}
		});

		
		
		
		
		lbl_alterarSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SetorDAO setorDao = new SetorDAO();
				if (textFieldEditar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos vazio não podem ser alterados!");
				} else {

					int val;
					val = JOptionPane.showConfirmDialog(null, "Você deseja realmente alterar o item?");

					int var = textFieldSetor.getText().length();

					if (var <= 25) {

						if (val == 0) {

							int retorno;

							Date dat = new Date();
							Date data = new Date();
							SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							dat = new Date(formatador.format(data));
							set.setNomeSetor(textFieldEditar.getText());
							
							set.setDataModificacao(dat);
							retorno = setorDao.editar(set);

							if (retorno == 1) {
								preencheTabela();
								JOptionPane.showMessageDialog(null, "O item da lista foi alterado com sucesso!");
								label_setedit.setVisible(false);
								textFieldEditar.setVisible(false);
								lbl_alterarSalvar.setVisible(false);
								textFieldSetor.setText("");
								
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

		lbl_alterarSalvar.setVisible(false);
		lbl_alterarSalvar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sal.png"));
		lbl_alterarSalvar.setBounds(300, 26, 46, 23);
		panel_3.add(lbl_alterarSalvar);
		JLabel labelCancelar = new JLabel("");
		labelCancelar.setToolTipText("Cancelar opera\u00E7\u00E3o...");
		labelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldSetor.setText("");

				label_setedit.setVisible(false);
				textFieldEditar.setVisible(false);
				// btnAltera.setVisible(false);
				lbl_alterarSalvar.setVisible(false);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);

				set = null;
				flag = 1;
				preencheTabela();

			}
		});
		labelCancelar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\canc.png"));
		labelCancelar.setBounds(821, 22, 25, 25);
		panel_3.add(labelCancelar);
		JLabel lbl_editar = new JLabel("");
		lbl_editar.setToolTipText("Editar item...");
		lbl_editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				label_setedit.setVisible(true);
				textFieldEditar.setVisible(true);
				// btnAltera.setVisible(true);
				lbl_alterarSalvar.setVisible(true);
				buttonSalvar.setVisible(false);

				// preencheTabela();

			}
		});
		lbl_editar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\alterarv.png"));
		lbl_editar.setBounds(856, 25, 25, 25);
		panel_3.add(lbl_editar);
		JLabel label_excluir = new JLabel("");
		label_excluir.setToolTipText("Remover item...");
		label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (set != null) {

					int num = JOptionPane.showConfirmDialog(null,
							"Você tem certeza que deseja excluir o setor \n        " + set.getNomeSetor()
									+ " da lista?");

					if (num == 0) {
						SetorDAO setorDao = new SetorDAO();
						Setor setor = new Setor();
						setorDao.excluir(set);
						set = null;
						preencheTabela();
						JOptionPane.showMessageDialog(null, "O item foi excluído com sucesso!");
						textFieldEditar.setText("");
						flag = 1;
						textFieldSetor.setText("");
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
		label_excluir.setBounds(891, 24, 25, 25);
		panel_3.add(label_excluir);

		label_adiciona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				labelBuscar.setVisible(false);
				buttonSalvar.setVisible(true);
				lbl_alterarSalvar.setVisible(false);
				label_setedit.setVisible(false);
				textFieldEditar.setVisible(false);
				textFieldSetor.setText("");

			}
		});

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validar numero de caracteres

				if (textFieldSetor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha o campo!");

				} else {
					int var = textFieldSetor.getText().length();
					System.out.println("Setor "+textFieldSetor.getText());


					if (var <= 25) {

						Setor setor = new Setor();
						setor.setNomeSetor(textFieldSetor.getText().trim());
						System.out.println(setor.getNomeSetor());
						salvar(setor);
						buttonSalvar.setVisible(false);
						labelBuscar.setVisible(true);

						textFieldSetor.setText("");
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

				SetorDAO setorDao = new SetorDAO();

				textFieldEditar.setText("");

				List<Setor> setors = null;
				setorDao.preencheBusca(textFieldSetor.getText());
				flag = 2;
				set = null;
				setors = preencheTabelaBusca();

			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(138, 274, 926, 2);
		frmsetor.getContentPane().add(separator_1);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(138, 210, 926, 2);
		frmsetor.getContentPane().add(separator_2);

		preencheTabela();

		frmsetor.setBackground(SystemColor.inactiveCaption);
		frmsetor.setBounds(100, 100, 1096, 617);
		frmsetor.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SetorDAO setorDao = new SetorDAO();

				int linha = table.getSelectedRow();

				if (flag == 1) {

					set = setorDao.buscarLinha(linha, "N");
					textFieldEditar.setText(set.getNomeSetor());

				} else if (flag == 2) {
					set = setorDao.buscarLinha(linha, textFieldSetor.getText());
					textFieldEditar.setText(set.getNomeSetor());

				}
			}
		});

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void preencheTabela() {

		SetorDAO setorDao = new SetorDAO();
		ArrayList<Setor> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Setor   ", "  Cadastro   ", " Última Modificação  " };
		dados.addAll(setorDao.preenche());
		modeloTabela modelo = new modeloTabela(dados, Colunas);
		table.setModel(modelo);
	}

	public List<Setor> preencheTabelaBusca() {

		SetorDAO setorDao = new SetorDAO();
		ArrayList<Setor> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Setor   ", "  Cadastro   ", " Última Modificação  " };
		dados.addAll(setorDao.preencheBusca(textFieldSetor.getText()));
		modeloTabela modelo = new modeloTabela(dados, Colunas);

		table.setModel(modelo);

		return dados;

	}

	public void salvar(Setor set) {
		try {
			Setor setor = new Setor();
			SetorDAO setorDao = new SetorDAO();
			Date dat = new Date();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dat = new Date(formatador.format(data));
			set.setDataCadastro(dat);
			int retorno;
			retorno = setorDao.salvar(set);
			if (retorno == 1) {
				JOptionPane.showMessageDialog(null, "Setor salvo com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "O setor não foi salvo!");
				// JOptionPane.show
			}
		} catch (RuntimeException er) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar o setor:" + er);
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