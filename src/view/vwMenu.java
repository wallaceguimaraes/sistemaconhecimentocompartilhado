package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.Choice;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;

import model.domain.Conhecimento;
import model.domain.Usuario;
import util.Sessao;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Scrollbar;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class vwMenu {

	public JFrame frmmenu;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwMenu window = new vwMenu();
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
	public vwMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmmenu = new JFrame();
		
		Usuario usu = new Usuario();
        usu=Sessao.getInstance().getUsuario();
		
		frmmenu.setTitle("usu\u00E1rio: "+usu.getUsuario());
		
		frmmenu.setResizable(false);
		frmmenu.getContentPane().setBackground(new Color(240, 255, 255));
		frmmenu.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 122, 552);
		frmmenu.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblConhecimentoCompartilhado = new JLabel("");
		lblConhecimentoCompartilhado.setToolTipText("Conhecimento compartilhado");
		lblConhecimentoCompartilhado.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\sccimg.png"));
		lblConhecimentoCompartilhado.setBounds(10, 139, 50, 46);
		panel.add(lblConhecimentoCompartilhado);
		
		JLabel label_4 = new JLabel("");
		label_4.setToolTipText("Usu\u00E1rios");
		label_4.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\adm.png"));
		label_4.setBounds(10, 69, 50, 57);
		panel.add(label_4);
		
		JLabel label_9 = new JLabel("");
		label_9.setToolTipText("Contatos");
		label_9.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\contato.png"));
		label_9.setBounds(10, 196, 55, 57);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setToolTipText("Perfil");
		label_10.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\perfil.png"));
		label_10.setBounds(10, 264, 61, 51);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setToolTipText("Empresas");
		label_11.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\emp.png"));
		label_11.setBounds(10, 331, 50, 46);
		panel.add(label_11);
		
		JLabel label_12 = new JLabel("");
		label_12.setToolTipText("Setor");
		label_12.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\setor.png"));
		label_12.setBounds(10, 388, 55, 46);
		panel.add(label_12);
		
		JLabel label_13 = new JLabel("");
		label_13.setToolTipText("Categorias");
		label_13.setIcon(new ImageIcon("C:\\Users\\TiClivale\\Downloads\\cat.png"));
		label_13.setBounds(10, 445, 102, 96);
		panel.add(label_13);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(173, 216, 230));
		panel_2.setBounds(138, 10, 926, 34);
		frmmenu.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		Label label_1 = new Label("SCC - Sistema de Conhecimento Compartilhado");
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
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(138, 68, 910, 75);
		frmmenu.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Label label = new Label("Bem vindo(a) ao Sistema de Conhecimento Compartilhado!");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 10, 361, 23);
		panel_1.add(label);
		
		Label label_3 = new Label("Para encontrar as informa\u00E7\u00F5es que voc\u00EA precisa, escolha a categoria desejada  e/ou escreva parte do \"t\u00EDtulo\" da informa\u00E7\u00E3o.");
		label_3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 10));
		label_3.setBounds(10, 53, 641, 22);
		panel_1.add(label_3);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(65, 105, 225));
		separator.setBounds(138, 48, 926, 2);
		frmmenu.getContentPane().add(separator);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setBounds(138, 156, 910, 68);
		frmmenu.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_8 = new JLabel("T\u00EDtulo:");
		label_8.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		label_8.setBounds(387, 13, 36, 14);
		panel_5.add(label_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Impressora", "Formata\u00E7\u00E3o de m\u00E1quina", "Ingenium", "Smart", "Dom\u00EDnio", "Computador", "Headset"}));
		comboBox.setBounds(68, 11, 224, 20);
		panel_5.add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		lblCategoria.setBounds(0, 13, 67, 14);
		panel_5.add(lblCategoria);
		
		Button button = new Button("Buscar");
		button.setBounds(812, 11, 70, 22);
		panel_5.add(button);
		button.setBackground(new Color(173, 216, 230));
		button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		
		textField = new JTextField();
		textField.setBounds(433, 11, 334, 20);
		panel_5.add(textField);
		textField.setColumns(10);
		
		Panel panel_6 = new Panel();
		panel_6.setBackground(new Color(220, 220, 220));
		panel_6.setBounds(1054, 58, 10, 521);
		frmmenu.getContentPane().add(panel_6);
		
		Panel panel_7 = new Panel();
		panel_7.setBackground(new Color(220, 220, 220));
		panel_7.setBounds(10, 568, 1054, 11);
		frmmenu.getContentPane().add(panel_7);
		panel_7.setLayout(null);
		
		Panel panel_8 = new Panel();
		panel_8.setBackground(new Color(220, 220, 220));
		panel_8.setBounds(138, 54, 926, 10);
		frmmenu.getContentPane().add(panel_8);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(65, 105, 225));
		separator_2.setBounds(138, 148, 910, 2);
		frmmenu.getContentPane().add(separator_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(173, 216, 230));
		panel_3.setBounds(138, 237, 910, 34);
		frmmenu.getContentPane().add(panel_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(65, 105, 225));
		separator_1.setBounds(138, 230, 910, 2);
		frmmenu.getContentPane().add(separator_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 255, 255));
		panel_4.setBounds(138, 282, 910, 280);
		frmmenu.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 910, 280);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setGridColor(new Color(238, 232, 170));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Categoria", "T\u00EDtulo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(227);
		table.getColumnModel().getColumn(1).setPreferredWidth(465);
		table.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 12));
		scrollPane.setViewportView(table);
		frmmenu.setBackground(SystemColor.inactiveCaption);
		frmmenu.setBounds(100, 100, 1081, 617);
		frmmenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
