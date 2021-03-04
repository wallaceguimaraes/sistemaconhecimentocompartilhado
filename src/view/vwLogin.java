package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.DAO.RegraDAO;
import model.DAO.UsuarioDAO;
import model.domain.Regra;
import model.domain.Usuario;
import util.HibernateUtil;
import util.Sessao;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.Window.Type;
import java.awt.Frame;

public class vwLogin {

	public JFrame frmLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vwLogin window = new vwLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public vwLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setFont(new Font("Dialog", Font.PLAIN, 12));
		frmLogin.setResizable(false);
		frmLogin.setTitle("Login");
		frmLogin.setBounds(100, 100, 630, 435);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(263, 79, 312, 242);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(68, 127, 181, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(68, 172, 181, 20);
		panel.add(passwordField);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblUsurio.setBounds(70, 111, 77, 14);
		panel.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblSenha.setBounds(70, 157, 46, 14);
		panel.add(lblSenha);
		
		JLabel lblSejaBemVindoa = new JLabel("Seja bem vindo(a) ");
		lblSejaBemVindoa.setBounds(62, 58, 200, 26);
		panel.add(lblSejaBemVindoa);
		lblSejaBemVindoa.setForeground(new Color(0, 0, 0));
		lblSejaBemVindoa.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 18));
		
		Button button = new Button("Acessar");
		button.setBounds(108, 195, 100, 28);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario usuario= new Usuario();
				Regra regra = new Regra();
				
				usuario = Validar(textField.getText(), passwordField.getText());
				
				
				
				
				
				if(usuario!=null && usuario.getSenha().equalsIgnoreCase(passwordField.getText())) {

					regra=pegaPermissao(usuario.getRegra().getIdRegra());
					
					Sessao sess = Sessao.getInstance();
					sess.setUsuario(usuario);
				    sess.setRegra(regra);
					//abrir Menu
					
					try {	
						vwMen window = new vwMen();
						window.frmmenu.setVisible(true);
						frmLogin.dispose();
						JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");

					} catch (Exception er) {
						er.printStackTrace();
					}
					
					
				}else {
					
					//nada
					
				}
				
				
			}
		});
		button.setForeground(new Color(255, 255, 255));
		button.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		button.setBackground(new Color(30, 144, 255));
		
		JLabel lblScc = new JLabel("SCC");
		lblScc.setForeground(new Color(30, 144, 255));
		lblScc.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 32));
		lblScc.setBounds(109, 9, 100, 52);
		panel.add(lblScc);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 255));
		separator.setBounds(15, 55, 280, 2);
		panel.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(175, 238, 238));
		panel_2.setBounds(263, 321, 312, 35);
		frmLogin.getContentPane().add(panel_2);
		
		JLabel label = new JLabel("Login");
		label.setForeground(new Color(0, 0, 0));
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		label.setBounds(135, 4, 94, 25);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Wallace Guimaraes\\eclipse-workspace\\SCC\\imagens\\fond-bleu-formes-abstraites-dynamiques_1393-161.png"));
		lblNewLabel.setBackground(new Color(220, 20, 60));
		lblNewLabel.setBounds(0, 0, 626, 413);
		frmLogin.getContentPane().add(lblNewLabel);
		
		
		Session sessaoH= HibernateUtil.getSessionFactory().openSession();
	
	
	}
	
	
	
	
	public Usuario Validar(String login, String senha) {

		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuario = new Usuario();

		usuario = usuarioDao.validaUsuario(login);

		if (usuario != null) {
			if (usuario.getSenha().equalsIgnoreCase(senha)) {
				System.out.println(usuario);
			} else {
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Usuário não existe!");
		}
		return usuario;
	}
	
	
	
	public Regra pegaPermissao(int codigo) {
		RegraDAO regraDao = new RegraDAO();
		Regra regra = new Regra();
		regra=regraDao.buscarPorCodigo(codigo);
		return regra;
	}
	
	
	
	
}
