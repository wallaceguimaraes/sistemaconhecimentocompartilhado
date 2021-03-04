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

import model.DAO.FilialDAO;
import model.DAO.FilialDAO;
import model.domain.Filial;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class vwFilial {

	public JFrame frmfilial;
	private JTextField textFieldFilial;
	private JTable table;
	private final Action action = new SwingAction();

	Filial empresa = null;
	int flag = 1;

	private JTextField textFieldEditar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwFilial window = new vwFilial();
					window.frmfilial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwFilial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmfilial = new JFrame();
		frmfilial.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				
				try {
					vwMen window = new vwMen();
					window.frmmenu.setVisible(true);
					frmfilial.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});
	
		
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
     
		
		frmfilial.setTitle("Usu\u00E1rio: "+usu.getUsuario());
		frmfilial.setResizable(false);
		frmfilial.getContentPane().setBackground(new Color(240, 255, 255));
		frmfilial.getContentPane().setLayout(null);

		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 122, 552);
		frmfilial.getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lblimg = new JLabel("");
		lblimg.setBounds(10, 35, 102, 77);

		ImageIcon imagem = new ImageIcon("C:\\Wallace Guimaraes\\Desktop\\imagem.png");
		Image imag = imagem.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_DEFAULT);

		lblimg.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\imagem.png"));

		panel.add(lblimg);
		Panel panelFilial = new Panel();
		panelFilial.setBackground(new Color(250, 250, 210));
		panelFilial.setBounds(4, 10, 113, 23);
		panel.add(panelFilial);
		panelFilial.setLayout(null);
		
		
		
        Regra regra = new Regra();
        regra=Sessao.getInstance().getRegra();
		
        Label lblFilial = new Label(regra.getRegra());
		lblFilial.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 9));
		lblFilial.setBounds(0, 0, 107, 23);
		panelFilial.add(lblFilial);
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
		panel_2.setBounds(138, 10, 904, 34);
		frmfilial.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Label label_1 = new Label("Filiais");
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
		panel_1.setBounds(138, 68, 888, 75);
		frmfilial.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		Label label = new Label("Bem vindo(a) ao Sistema de Conhecimento Compartilhado!");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 10, 361, 23);
		panel_1.add(label);

		Label label_3 = new Label("Adicione novas filiais");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label_3.setBounds(725, 47, 112, 22);
		panel_1.add(label_3);
		JLabel label_adiciona = new JLabel("");

		label_adiciona
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adiciona.png"));
		label_adiciona.setBounds(842, 39, 25, 36);
		panel_1.add(label_adiciona);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(138, 48, 904, 2);
		frmfilial.getContentPane().add(separator);

		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(138, 149, 888, 57);
		frmfilial.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		JLabel lblFilial_1 = new JLabel("Filial:");
		lblFilial_1.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblFilial_1.setBounds(10, 13, 36, 14);
		panel_5.add(lblFilial_1);

		textFieldFilial = new JTextField();
		textFieldFilial.setBounds(44, 11, 306, 20);
		panel_5.add(textFieldFilial);
		textFieldFilial.setColumns(10);

		Button buttonSalvar = new Button("Salvar");
		buttonSalvar.setVisible(false);

		buttonSalvar.setBounds(800, 10, 70, 22);
		panel_5.add(buttonSalvar);
		buttonSalvar.setBackground(new Color(173, 216, 230));
		buttonSalvar.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		JLabel labelBuscar = new JLabel("");

		labelBuscar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\bu.png"));
		labelBuscar.setBounds(360, 5, 28, 33);
		panel_5.add(labelBuscar);

		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(1032, 58, 10, 521);
		frmfilial.getContentPane().add(panel_6);

		Panel panel_7 = new Panel();
		panel_7.setBackground(new Color(220, 220, 220));
		panel_7.setBounds(10, 568, 1032, 11);
		frmfilial.getContentPane().add(panel_7);
		panel_7.setLayout(null);

		Panel panel_8 = new Panel();
		panel_8.setBackground(new Color(220, 220, 220));
		panel_8.setBounds(138, 54, 904, 10);
		frmfilial.getContentPane().add(panel_8);
		Panel panel_10 = new Panel();
		panel_10.setBackground(new Color(240, 255, 255));
		panel_10.setBounds(138, 282, 888, 271);
		frmfilial.getContentPane().add(panel_10);
		panel_10.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(173, 216, 230));
		scrollPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		scrollPane.setBounds(0, 0, 888, 271);
		panel_10.add(scrollPane);
		table = new JTable();

		table.setSelectionBackground(new Color(176, 196, 222));
		scrollPane.setViewportView(table);
		table.setShowHorizontalLines(false);
		table.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));

		table.setBackground(new Color(250, 250, 210));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "  Filial   ", "  Cadastro   ", " Última modificação  " }) {
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
		panel_3.setBounds(138, 218, 888, 52);
		frmfilial.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		textFieldEditar = new JTextField();
		textFieldEditar.setVisible(false);
		textFieldEditar.setBounds(10, 27, 301, 20);
		panel_3.add(textFieldEditar);
		textFieldEditar.setColumns(10);
		JLabel label_empresaedit = new JLabel("Filial:");
		label_empresaedit.setVisible(false);

		label_empresaedit.setFont(new Font("Dialog", Font.ITALIC, 12));
		label_empresaedit.setBounds(10, 11, 36, 14);
		panel_3.add(label_empresaedit);
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
					frmfilial.dispose();

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
					frmfilial.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		label_Perfis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Perfis

				try {
					vwRegra window = new vwRegra();
					window.frmperfil.setVisible(true);
					frmfilial.dispose();

				} catch (Exception er) {
					er.printStackTrace();
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
				// Categorias
			
			
				try {
					vwCategoria window = new vwCategoria();
					window.frmcategoria.setVisible(true);
					frmfilial.dispose();

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
					frmfilial.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}

			}
		});

		label_Emp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Filiais

				// Se usuario tiver permissao ADM abre senao nao abre
				// vwFilial window = new vwFilial();
				// window.frmfilial.setVisible(true);
				// dispose();

			}
		});

		lbl_alterarSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FilialDAO filialDao = new FilialDAO();
				if (textFieldEditar.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Campos vazio não podem ser alterados!");
				} else {

					int val;
					val = JOptionPane.showConfirmDialog(null, "Você deseja realmente alterar o item?");

					int var = textFieldFilial.getText().length();

					if (var <= 35) {

						if (val == 0) {

							int retorno;

							Date dat = new Date();
							Date data = new Date();
							SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
							dat = new Date(formatador.format(data));
							empresa.setFilial(textFieldEditar.getText());
							empresa.setDataModificacao(dat);
							retorno = filialDao.editar(empresa);

							if (retorno == 1) {
								preencheTabela();
								JOptionPane.showMessageDialog(null, "O item da lista foi alterado com sucesso!");
								label_empresaedit.setVisible(false);
								textFieldEditar.setVisible(false);
								lbl_alterarSalvar.setVisible(false);
								textFieldFilial.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o item!");
							}
						} else {
							//
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
		lbl_alterarSalvar.setBounds(320, 26, 46, 23);
		panel_3.add(lbl_alterarSalvar);
		JLabel labelCancelar = new JLabel("");
		labelCancelar.setToolTipText("Cancelar opera\u00E7\u00E3o...");
		labelCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldFilial.setText("");

				label_empresaedit.setVisible(false);
				textFieldEditar.setVisible(false);
				// btnAltera.setVisible(false);
				lbl_alterarSalvar.setVisible(false);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);

				empresa = null;
				flag = 1;
				preencheTabela();

			}
		});
		labelCancelar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\canc.png"));
		labelCancelar.setBounds(787, 22, 25, 25);
		panel_3.add(labelCancelar);
		JLabel lbl_editar = new JLabel("");
		lbl_editar.setToolTipText("Editar item...");
		lbl_editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				label_empresaedit.setVisible(true);
				textFieldEditar.setVisible(true);
				// btnAltera.setVisible(true);
				lbl_alterarSalvar.setVisible(true);
				buttonSalvar.setVisible(false);
				labelBuscar.setVisible(true);

				// preencheTabela();

			}
		});
		lbl_editar
				.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\alterarv.png"));
		lbl_editar.setBounds(818, 22, 25, 25);
		panel_3.add(lbl_editar);
		JLabel label_excluir = new JLabel("");
		label_excluir.setToolTipText("Remover item...");
		label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (empresa != null) {

					int num = JOptionPane.showConfirmDialog(null,
							"Você tem certeza que deseja excluir a filial \n        " + empresa.getFilial()
									+ " da lista?");

					if (num == 0) {
						FilialDAO filialDao = new FilialDAO();
						Filial filial = new Filial();
						filialDao.excluir(empresa);
						empresa = null;
						preencheTabela();
						JOptionPane.showMessageDialog(null, "O item foi excluído com sucesso!");
						textFieldEditar.setText("");
						flag = 1;
						textFieldFilial.setText("");
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
		label_excluir.setBounds(853, 22, 25, 25);
		panel_3.add(label_excluir);

		label_adiciona.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				labelBuscar.setVisible(false);
				buttonSalvar.setVisible(true);
				lbl_alterarSalvar.setVisible(false);
				label_empresaedit.setVisible(false);
				textFieldEditar.setVisible(false);
				textFieldFilial.setText("");

			}
		});

		buttonSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Validar numero de caracteres

				if (textFieldFilial.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha o campo!");

				} else {
					int var = textFieldFilial.getText().length();

					if (var <= 35) {

						Filial filial = new Filial();
						filial.setFilial(textFieldFilial.getText().trim());
						salvar(filial);
						buttonSalvar.setVisible(false);
						labelBuscar.setVisible(true);

						textFieldFilial.setText("");
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

				FilialDAO filialDao = new FilialDAO();

				textFieldEditar.setText("");

				List<Filial> filials = null;
				filialDao.preencheBusca(textFieldFilial.getText());
				flag = 2;
				empresa = null;
				filials = preencheTabelaBusca();

			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(138, 274, 888, 2);
		frmfilial.getContentPane().add(separator_1);
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(138, 210, 888, 2);
		frmfilial.getContentPane().add(separator_2);

		preencheTabela();

		frmfilial.setBackground(SystemColor.inactiveCaption);
		frmfilial.setBounds(100, 100, 1058, 617);
		frmfilial.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				FilialDAO filialDao = new FilialDAO();

				int linha = table.getSelectedRow();

				if (flag == 1) {

					empresa = filialDao.buscarLinha(linha, "N");
					textFieldEditar.setText(empresa.getFilial());

				} else if (flag == 2) {
					empresa = filialDao.buscarLinha(linha, textFieldFilial.getText());
					textFieldEditar.setText(empresa.getFilial());

				}
			}
		});

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void preencheTabela() {

		FilialDAO filialDao = new FilialDAO();
		ArrayList<Filial> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Filial   ", "  Cadastro   ", " Última Modificação  " };
		dados.addAll(filialDao.preenche());
		modeloTabela modelo = new modeloTabela(dados, Colunas);
		table.setModel(modelo);
	}

	public List<Filial> preencheTabelaBusca() {

		FilialDAO filialDao = new FilialDAO();
		ArrayList<Filial> dados = new ArrayList<>();
		String[] Colunas = new String[] { "  Filial   ", "  Cadastro   ", " Última Modificação  " };
		dados.addAll(filialDao.preencheBusca(textFieldFilial.getText()));
		modeloTabela modelo = new modeloTabela(dados, Colunas);

		table.setModel(modelo);

		return dados;

	}

	public void salvar(Filial empresa) {
		try {
			Filial filial = new Filial();
			FilialDAO filialDao = new FilialDAO();
			Date dat = new Date();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dat = new Date(formatador.format(data));
			empresa.setDataCadastro(dat);
			int retorno;
			retorno = filialDao.salvar(empresa);
			if (retorno == 1) {
				JOptionPane.showMessageDialog(null, "Filial salva com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "A filial não foi salva!");
				// JOptionPane.show
			}
		} catch (RuntimeException er) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar a filial:" + er);
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