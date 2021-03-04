package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
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

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;

import model.DAO.RegraDAO;
import model.domain.Regra;
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
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class vwRegra {

	public JFrame frmperfil;
	private JTextField textFieldPerfil;
	private JTable table;
	private final Action action = new SwingAction();

	Regra perfil = null;
	int flag = 1;

	private JTextField textFieldEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwRegra window = new vwRegra();
					window.frmperfil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwRegra() {
		initialize();
	
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmperfil = new JFrame();
		frmperfil.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					vwMen window = new vwMen();
					window.frmmenu.setVisible(true);
					frmperfil.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
		
		
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
	
		frmperfil.setTitle("Usu\u00E1rio: "+usu.getUsuario());
		frmperfil.setResizable(false);
		frmperfil.getContentPane().setBackground(new Color(240, 255, 255));
		frmperfil.getContentPane().setLayout(null);
		
		
		

		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 122, 552);
		frmperfil.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(10, 35, 102, 77);

		ImageIcon imagem = new ImageIcon("C:\\Wallace Guimaraes\\Desktop\\imagem.png");
		Image imag = imagem.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_DEFAULT);

		lblimg.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\imagem.png"));

		
		
		
		
		
		
		panel.add(lblimg);
		Panel panelPerfil = new Panel();
		panelPerfil.setBackground(new Color(250, 250, 210));
		panelPerfil.setBounds(4, 10, 113, 23);
		panel.add(panelPerfil);
		panelPerfil.setLayout(null);
		
	
		
        Regra regra = new Regra();
        regra=Sessao.getInstance().getRegra();
		Label lblPerfil = new Label(regra.getRegra());
		lblPerfil.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 9));
		lblPerfil.setBounds(0, 0, 107, 23);
		panelPerfil.add(lblPerfil);
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
		panel_2.setBounds(138, 10, 901, 34);
		frmperfil.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Label label_1 = new Label("Perfis");
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("Ebrima", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(10, 10, 333, 22);
		panel_2.add(label_1);

		Label label_6 = new Label("Sair");
		label_6.setFont(new Font("Dialog", Font.ITALIC, 10));
		label_6.setBounds(858, 10, 33, 22);
		panel_2.add(label_6);

		Label label_7 = new Label("Sobre");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.out.println("Informações!");
			}
		});
		label_7.setFont(new Font("Dialog", Font.ITALIC, 10));
		label_7.setBounds(819, 10, 33, 22);
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
		label_2.setBounds(788, 7, 25, 25);
		panel_2.add(label_2);

		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(250, 250, 210));
		panel_1.setBounds(138, 68, 885, 75);
		frmperfil.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Bem vindo(a) ao Sistema de Conhecimento Compartilhado!");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 10, 361, 23);
		panel_1.add(label);

		Label label_3 = new Label("Adicione novos perfis");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label_3.setBounds(732, 40, 112, 22);
		panel_1.add(label_3);
		JLabel label_adiciona = new JLabel("");

		label_adiciona
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adiciona.png"));
		label_adiciona.setBounds(850, 33, 25, 36);
		panel_1.add(label_adiciona);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(138, 48, 901, 2);
		frmperfil.getContentPane().add(separator);

		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(138, 149, 885, 57);
		frmperfil.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblPerfil_1 = new JLabel("Perfil:");
		lblPerfil_1.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblPerfil_1.setBounds(10, 13, 36, 14);
		panel_5.add(lblPerfil_1);

		textFieldPerfil = new JTextField();
		textFieldPerfil.setBounds(44, 11, 278, 20);
		panel_5.add(textFieldPerfil);
		textFieldPerfil.setColumns(10);

		JLabel lblPermisso = new JLabel("Permiss\u00E3o:");
		lblPermisso.setVisible(false);
		lblPermisso.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblPermisso.setBounds(409, 13, 70, 14);
		panel_5.add(lblPermisso);
		JComboBox comboBoxPermissao = new JComboBox();
		comboBoxPermissao.setVisible(false);
		comboBoxPermissao.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3" }));
		comboBoxPermissao.setBounds(475, 10, 70, 22);
		panel_5.add(comboBoxPermissao);
		
		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setVisible(false);

		buttonSalvar.setBounds(571, 10, 70, 22);
		panel_5.add(buttonSalvar);
		buttonSalvar.setBackground(new Color(173, 216, 230));
		buttonSalvar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLabel labelBuscar = new JLabel("");

		labelBuscar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\bu.png"));
		labelBuscar.setBounds(328, 5, 28, 33);
		panel_5.add(labelBuscar);

		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(1029, 58, 10, 521);
		frmperfil.getContentPane().add(panel_6);

		Panel panel_7 = new Panel();
		panel_7.setBackground(new Color(220, 220, 220));
		panel_7.setBounds(10, 568, 1029, 11);
		frmperfil.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		Panel panel_8 = new Panel();
		panel_8.setBackground(new Color(220, 220, 220));
		panel_8.setBounds(138, 54, 901, 10);
		frmperfil.getContentPane().add(panel_8);
		Panel panel_10 = new Panel();
		panel_10.setBackground(new Color(240, 255, 255));
		panel_10.setBounds(138, 282, 885, 271);
		frmperfil.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(173, 216, 230));
		scrollPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setBounds(0, 0, 885, 271);
		panel_10.add(scrollPane);
		table = new JTable();

		table.setSelectionBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));

		table.setBackground(new Color(250, 250, 210));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "  Perfil   ", "  Cadastro   ", " Última modificação  " }) {
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
		panel_3.setBounds(138, 218, 885, 52);
		frmperfil.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		textFieldEditar = new JTextField();
		textFieldEditar.setVisible(false);
		textFieldEditar.setBounds(10, 27, 281, 20);
		panel_3.add(textFieldEditar);
		textFieldEditar.setColumns(10);
		JComboBox comboBoxedit = new JComboBox();
		comboBoxedit.setVisible(false);
		comboBoxedit.setModel(new DefaultComboBoxModel(new String[] { "", "1", "2", "3" }));
		comboBoxedit.setBounds(301, 27, 70, 22);
		panel_3.add(comboBoxedit);
		JLabel label_perfiledit = new JLabel("Perfil:");
		label_perfiledit.setVisible(false);

		label_perfiledit.setFont(new Font("Dialog", Font.ITALIC, 12));
		label_perfiledit.setBounds(10, 11, 36, 14);
		panel_3.add(label_perfiledit);
		JLabel label_permissaoedit = new JLabel("Permiss\u00E3o:");

		label_permissaoedit.setVisible(false);

		label_permissaoedit.setFont(new Font("Dialog", Font.ITALIC, 12));
		label_permissaoedit.setBounds(301, 11, 70, 14);
		panel_3.add(label_permissaoedit);
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
					frmperfil.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		label_Usuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Página usuários
				try {
					vwUsuario window = new vwUsuario();
					window.frmusuario.setVisible(true);
					frmperfil.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		label_Perfis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Perfis

				//

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
				// Categorias
			
				try {
					vwCategoria window = new vwCategoria();
					window.frmcategoria.setVisible(true);
					frmperfil.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			
			}
		});

		label_Setores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Setores

				try {
					vwSetor window = new vwSetor();
					window.frmsetor.setVisible(true);
					frmperfil.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});

		label_Emp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Filiais

				try {
					vwFilial window = new vwFilial();
					window.frmfilial.setVisible(true);
					frmperfil.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		lbl_alterarSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RegraDAO regraDao = new RegraDAO();
				if (textFieldEditar.getText().isEmpty() || comboBoxedit.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Campos vazio não podem ser alterados!");
				} else {

					int val;
					val = JOptionPane.showConfirmDialog(null, "Você deseja realmente alterar o item?");

					int var = textFieldEditar.getText().length();

					if (var <= 30) {

						if (val == 0) {

							int retorno;

							Date dat = new Date();
							Date data = new Date();
							SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							dat = new Date(formatador.format(data));
							perfil.setRegra(textFieldEditar.getText());
							;
							perfil.setPermissao(comboBoxedit.getSelectedIndex());
							perfil.setDataModificacao(dat);
							retorno = regraDao.editar(perfil);

							if (retorno == 1) {
								preencheTabela();
								JOptionPane.showMessageDialog(null, "O item da lista foi alterado com sucesso!");
								label_perfiledit.setVisible(false);
								textFieldEditar.setVisible(false);
								label_permissaoedit.setVisible(false);
								comboBoxedit.setVisible(false);
								lbl_alterarSalvar.setVisible(false);
								textFieldPerfil.setText("");

							} else {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o item!");
							}
						} else {
						}

					} else {
						JOptionPane.showMessageDialog(null, "O campo deve possuir no máximo '30' caracteres! ");
					}

				}
			}
		});

		lbl_alterarSalvar.setVisible(false);
		lbl_alterarSalvar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sal.png"));
		lbl_alterarSalvar.setBounds(379, 26, 46, 23);
		panel_3.add(lbl_alterarSalvar);
		JLabel labelCancelar = new JLabel("");
		labelCancelar.setToolTipText("Cancelar opera\u00E7\u00E3o...");
		labelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldPerfil.setText("");
				comboBoxPermissao.setSelectedIndex(0);

				label_perfiledit.setVisible(false);
				textFieldEditar.setVisible(false);
				label_permissaoedit.setVisible(false);
				comboBoxedit.setVisible(false);
				// btnAltera.setVisible(false);
				lbl_alterarSalvar.setVisible(false);
				lblPermisso.setVisible(false);
				buttonSalvar.setVisible(false);
				comboBoxPermissao.setVisible(false);
				labelBuscar.setVisible(true);

				perfil = null;
				flag = 1;
				preencheTabela();

			}
		});
		labelCancelar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\canc.png"));
		labelCancelar.setBounds(780, 22, 25, 25);
		panel_3.add(labelCancelar);
		JLabel lbl_editar = new JLabel("");
		lbl_editar.setToolTipText("Editar item...");
		lbl_editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				label_perfiledit.setVisible(true);
				textFieldEditar.setVisible(true);
				label_permissaoedit.setVisible(true);
				comboBoxedit.setVisible(true);
				// btnAltera.setVisible(true);
				lbl_alterarSalvar.setVisible(true);
				buttonSalvar.setVisible(false);
                comboBoxPermissao.setVisible(false);
                lblPermisso.setVisible(false);
                labelBuscar.setVisible(true);
				// preencheTabela();

			}
		});
		lbl_editar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\alterarv.png"));
		lbl_editar.setBounds(815, 22, 25, 25);
		panel_3.add(lbl_editar);
		JLabel label_excluir = new JLabel("");
		label_excluir.setToolTipText("Remover item...");
		label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (perfil != null) {

					int num = JOptionPane.showConfirmDialog(null,
							"Você tem certeza que deseja excluir o perfil \n        " + perfil.getRegra()
									+ " da lista?");

					if (num == 0) {
						RegraDAO regraDao = new RegraDAO();
						Regra regra = new Regra();
						regraDao.excluir(perfil);
						perfil = null;
						preencheTabela();
						JOptionPane.showMessageDialog(null, "O item foi excluído com sucesso!");
						textFieldEditar.setText("");
						comboBoxedit.setSelectedIndex(0);
						flag = 1;
						textFieldPerfil.setText("");
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
		label_excluir.setBounds(850, 22, 25, 25);
		panel_3.add(label_excluir);

		label_adiciona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				labelBuscar.setVisible(false);
				lblPermisso.setVisible(true);
				buttonSalvar.setVisible(true);
				lbl_alterarSalvar.setVisible(false);
				label_permissaoedit.setVisible(false);
				label_perfiledit.setVisible(false);
				comboBoxPermissao.setVisible(true);
				textFieldEditar.setVisible(false);
				comboBoxedit.setVisible(false);
				textFieldPerfil.setText("");

			}
		});

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validar numero de caracteres

				if (textFieldPerfil.getText().isEmpty() || comboBoxPermissao.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!");

				} else {

					int var = textFieldPerfil.getText().length();

					if (var <= 30) {

						Regra regra = new Regra();
						regra.setRegra(textFieldPerfil.getText().trim());

						regra.setPermissao(comboBoxPermissao.getSelectedIndex());
						salvar(regra);
						lblPermisso.setVisible(false);
						comboBoxPermissao.setVisible(false);
						buttonSalvar.setVisible(false);
						labelBuscar.setVisible(true);
						
						

						textFieldPerfil.setText("");
						flag = 1;

						preencheTabela();
					} else {

						JOptionPane.showMessageDialog(null, "O campo deve possuir no máximo '30' caracteres! ");

					}

				}
			}
		});

		labelBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RegraDAO regraDao = new RegraDAO();

				textFieldEditar.setText("");
				//comboBoxedit.setSelectedIndex(0);

				List<Regra> regras = null;
				regraDao.preencheBusca(textFieldPerfil.getText());
				flag = 2;
				perfil = null;
				regras = preencheTabelaBusca();

			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(138, 274, 885, 2);
		frmperfil.getContentPane().add(separator_1);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(138, 210, 885, 2);
		frmperfil.getContentPane().add(separator_2);

		preencheTabela();

		frmperfil.setBackground(SystemColor.inactiveCaption);
		frmperfil.setBounds(100, 100, 1055, 617);
		frmperfil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				RegraDAO regraDao = new RegraDAO();

				int linha = table.getSelectedRow();

				if (flag == 1) {

					perfil = regraDao.buscarLinha(linha, "N");
					textFieldEditar.setText(perfil.getRegra());				
					int num = perfil.getPermissao();			
					comboBoxedit.setSelectedIndex(num-1+1);

				} else if (flag == 2) {
					perfil = regraDao.buscarLinha(linha, textFieldPerfil.getText());
					textFieldEditar.setText(perfil.getRegra());				
                    int num = perfil.getPermissao();	
					comboBoxedit.setSelectedIndex(num-1+1);

				}
			}
		});

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void preencheTabela() {

		RegraDAO regraDao = new RegraDAO();
		ArrayList<Regra> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Perfil   ","   Permissão   ", "  Cadastro   ", " Última Modificação  " };
		dados.addAll(regraDao.preenche());
		modeloTabela modelo = new modeloTabela(dados, Colunas);
		table.setModel(modelo);
	}

	public List<Regra> preencheTabelaBusca() {

		RegraDAO regraDao = new RegraDAO();
		ArrayList<Regra> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Perfil   ","   Permissão   ", "  Cadastro   ", " Última Modificação  " };
		dados.addAll(regraDao.preencheBusca(textFieldPerfil.getText()));
		modeloTabela modelo = new modeloTabela(dados, Colunas);

		table.setModel(modelo);

		return dados;

	}

	public void salvar(Regra perfil) {
		try {
			Regra regra = new Regra();
			RegraDAO regraDao = new RegraDAO();
			Date dat = new Date();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dat = new Date(formatador.format(data));
			perfil.setDataCadastro(dat);
			int retorno;
			retorno = regraDao.salvar(perfil);
			if (retorno == 1) {
				JOptionPane.showMessageDialog(null, "Perfil salvo com sucesso!");

			} else {
				JOptionPane.showMessageDialog(null, "O perfil não foi salvo!");
				// JOptionPane.show
			}
		} catch (RuntimeException er) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar o perfil:" + er);
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