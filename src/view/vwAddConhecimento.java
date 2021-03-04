package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.DAO.CategoriaDAO;
import model.DAO.ConhecimentoDAO;
import model.domain.Categoria;
import model.domain.Conhecimento;
import model.domain.Regra;
import model.domain.Setor;
import model.domain.Usuario;
import util.CategoriaComboBox;
import util.Sessao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class vwAddConhecimento {

	public JFrame frmaddconhecimento;
	private JTextField textFieldTitulo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwAddConhecimento window = new vwAddConhecimento();
					window.frmaddconhecimento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwAddConhecimento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frmaddconhecimento.
	 */
	private void initialize() {
		frmaddconhecimento = new JFrame();
		frmaddconhecimento.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				
				
				try {
					vwMen window = new vwMen();
					window.frmmenu.setVisible(true);
					frmaddconhecimento.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				
				
			}
		});
		
	
		
		
		frmaddconhecimento.setResizable(false);
		frmaddconhecimento.getContentPane().setBackground(new Color(240, 248, 255));
		frmaddconhecimento.setBounds(100, 100, 989, 564);
		frmaddconhecimento.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmaddconhecimento.getContentPane().setLayout(null);
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		textFieldTitulo.setBackground(new Color(255, 250, 205));
		textFieldTitulo.setBounds(140, 54, 431, 20);
		frmaddconhecimento.getContentPane().add(textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 250, 205));
		comboBox.setBounds(700, 54, 233, 20);
		frmaddconhecimento.getContentPane().add(comboBox);
		
	    preencheComboBox();
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<Categoria> categoriaes = new ArrayList<>();
	    Categoria set = new Categoria();
		categoriaes.addAll(preencheComboBox());
        
		for(int i=0;i < categoriaes.size();i++) {
			comboBox.addItem(categoriaes.get(i));
		}
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(137, 140, 836, 337);
		frmaddconhecimento.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(0, 0, 0));
		textArea.setFont(new Font("Dialog", Font.ITALIC, 13));
		textArea.setBackground(new Color(250, 250, 210));
		
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JLabel label = new JLabel("0");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Dialog", Font.ITALIC, 12));
		label.setBounds(150, 490, 46, 14);
		frmaddconhecimento.getContentPane().add(label);
		
		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblTtulo.setBounds(140, 29, 46, 14);
		frmaddconhecimento.getContentPane().add(lblTtulo);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblCategoria.setBounds(700, 29, 91, 23);
		frmaddconhecimento.getContentPane().add(lblCategoria);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o:");
		lblDescrio.setBackground(new Color(0, 0, 0));
		lblDescrio.setForeground(new Color(0, 0, 0));
		lblDescrio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblDescrio.setBounds(140, 100, 81, 14);
		frmaddconhecimento.getContentPane().add(lblDescrio);
		
		JLabel lblDe = new JLabel("de 1500");
		lblDe.setForeground(new Color(0, 0, 0));
		lblDe.setFont(new Font("Dialog", Font.ITALIC, 12));
		lblDe.setBounds(200, 490, 46, 14);
		frmaddconhecimento.getContentPane().add(lblDe);
		
		JLabel lblltimaModificao = new JLabel("\u00DAltima modifica\u00E7\u00E3o:");
		lblltimaModificao.setFont(new Font("Dialog", Font.ITALIC, 11));
		lblltimaModificao.setBounds(10, 512, 106, 14);
		frmaddconhecimento.getContentPane().add(lblltimaModificao);
		
		JLabel labelDataMod = new JLabel("");
		labelDataMod.setFont(new Font("Dialog", Font.ITALIC, 11));
		labelDataMod.setBounds(116, 512, 149, 14);
		frmaddconhecimento.getContentPane().add(labelDataMod);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 11, 120, 520);
		frmaddconhecimento.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_Conhecimento = new JLabel("");
	
		label_Conhecimento.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sccimg.png"));
		label_Conhecimento.setToolTipText("Conhecimento");
		label_Conhecimento.setBounds(29, 76, 57, 49);
		panel.add(label_Conhecimento);
		
		JLabel label_Usuarios = new JLabel("");
		
		label_Usuarios.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\adm.png"));
		label_Usuarios.setToolTipText("Usu\u00E1rios");
		label_Usuarios.setBounds(32, 140, 50, 56);
		panel.add(label_Usuarios);
		
		JLabel label_Perfis = new JLabel("");
		
		label_Perfis.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\perfil.png"));
		label_Perfis.setToolTipText("Perfis");
		label_Perfis.setBounds(29, 206, 57, 49);
		panel.add(label_Perfis);
		
		JLabel label_Contatos = new JLabel("");
		
		label_Contatos.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\contato.png"));
		label_Contatos.setToolTipText("Contatos");
		label_Contatos.setBounds(28, 266, 50, 56);
		panel.add(label_Contatos);
		
		JLabel label_Categoria = new JLabel("");
		
		label_Categoria.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\cat.png"));
		label_Categoria.setToolTipText("Categorias");
		label_Categoria.setBounds(30, 342, 65, 49);
		panel.add(label_Categoria);
		
		JLabel label_Setores = new JLabel("");
		
		label_Setores.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\setor.png"));
		label_Setores.setToolTipText("Setores");
		label_Setores.setBounds(32, 402, 46, 49);
		panel.add(label_Setores);
		
		JLabel label_Emp = new JLabel("");
		
		label_Emp.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\emp.png"));
		label_Emp.setToolTipText("Filiais");
		label_Emp.setBounds(30, 462, 56, 42);
		panel.add(label_Emp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(135, 11, 838, 71);
		frmaddconhecimento.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(135, 93, 838, 36);
		frmaddconhecimento.getContentPane().add(panel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(135, 132, 838, 2);
		frmaddconhecimento.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(135, 85, 838, 2);
		frmaddconhecimento.getContentPane().add(separator_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBounds(116, 483, 857, 47);
		frmaddconhecimento.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.setBounds(700, 8, 73, 23);
		panel_3.add(btnImprimir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setBounds(800, 8, 34, 23);
		panel_3.add(btnSalvar);
		btnSalvar.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\sal.png"));
		btnSalvar.setBackground(new Color(173, 216, 230));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(136, 478, 837, 2);
		frmaddconhecimento.getContentPane().add(separator_2);
		
		
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(null, "Funciona!");

				
				
				if (textFieldTitulo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, preencha o campo!");

				} else {
					int var = textFieldTitulo.getText().length();
					int val = textArea.getText().length();
					System.out.println("Conhecimento "+textFieldTitulo.getText());


					if (var <= 50 && val <=1500) {

						Conhecimento conhecimento = new Conhecimento();
						conhecimento.setTitulo(textFieldTitulo.getText());
                        conhecimento.setDescCct(textArea.getText());
						
						CategoriaDAO categoriaDao = new CategoriaDAO();
						Categoria categoria = new Categoria();
						
						int index=comboBox.getSelectedIndex();
						System.out.println("Linha "+index);
						
						
	
						
						
																	
						categoria=categoriaDao.buscarLinha(index,"N");
						conhecimento.setCategoria(categoria);
                        
						salvar(conhecimento);
						
						try {
							vwConhecimento window = new vwConhecimento();
							window.frmconhecimento.setVisible(true);
							frmaddconhecimento.dispose();

						} catch (Exception er) {
							er.printStackTrace();
						}
				
									//flag = 1;

						//preencheTabela();
					} else if(var>50){
						JOptionPane.showMessageDialog(null, "O campo 'Título' deve possuir no máximo '50' caracteres! ");
					}else {
						
						JOptionPane.showMessageDialog(null, "O campo 'Descrição' deve possuir no máximo '1500' caracteres! ");

					}

				}
					
				
			}
		});
		
		
		
		label_Categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			//categoria
				try {
					vwCategoria window = new vwCategoria();
					window.frmcategoria.setVisible(true);
					frmaddconhecimento.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
			}
		});		
		
		
		label_Conhecimento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// Pagina inicial
				try {
					vwConhecimento window = new vwConhecimento();
					window.frmconhecimento.setVisible(true);
					frmaddconhecimento.dispose();

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
					frmaddconhecimento.dispose();

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
					frmaddconhecimento.dispose();

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
					frmaddconhecimento.dispose();

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
					frmaddconhecimento.dispose();

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
					frmaddconhecimento.dispose();

				} catch (Exception er) {
					er.printStackTrace();
				}
				}
			}
		});
		
		
		
		btnImprimir.setVisible(false);
		
		textArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
			String texto=textArea.getText();
			
			label.setText(Integer.toString(texto.length()));
			
			}
		});
		
	}
	
	
	public List<Categoria> preencheComboBox() {
		
		CategoriaComboBox categoriaComboModel= new CategoriaComboBox();
		
		CategoriaDAO categoriaDao = new CategoriaDAO();
		ArrayList<Categoria> categoriaes = new ArrayList<>();
		
        
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
        Setor setor = new Setor();
        setor=usu.getSetor();
		
		categoriaes.addAll(categoriaDao.preencheCombo(setor.getIdSetor()));
		
		//System.out.println("VW metodo "+categoriaes);
		//Categoria set=new Categoria();

		return categoriaes;
	
	}
	
	
	
	public void salvar(Conhecimento categoria) {
		try {
			Conhecimento conhecimento = new Conhecimento();
			ConhecimentoDAO conhecimentoDao = new ConhecimentoDAO();
			Date dat = new Date();
			Date data = new Date();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dat = new Date(formatador.format(data));
			categoria.setDataCadastro(dat);
			int retorno;
			retorno = conhecimentoDao.salvar(categoria);
			if (retorno == 1) {
				JOptionPane.showMessageDialog(null, "Conhecimento salvo com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "O conhecimento não foi salvo!");
				// JOptionPane.show
			}
		} catch (RuntimeException er) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar salvar o conhecimento:" + er);
		}
	}
}
