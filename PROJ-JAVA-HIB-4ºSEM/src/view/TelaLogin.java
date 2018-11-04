package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import conf.ConexaoBd;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tfLogin;
	private JPasswordField pswSenha;
	private JLabel lbLogo;
	private JLabel lbLogoEscrito;
	private JButton btnEntrar;
    int i = 3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setFont(new Font("Dialog", Font.BOLD, 20));
		setForeground(SystemColor.textText);
		setBackground(SystemColor.infoText);
		setTitle("Sistema de Placas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 641);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setToolTipText("Sistema de Placas ");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoAo = new JLabel("Bem vindo ao:");
		lblBemVindoAo.setForeground(new Color(255, 0, 0));
		lblBemVindoAo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		lblBemVindoAo.setBounds(266, 74, 173, 43);
		contentPane.add(lblBemVindoAo);
		
		JLabel lbSenha = new JLabel("");
		lbSenha.setIcon(new ImageIcon(TelaLogin.class.getResource("/image/icons8-password-32.png")));
		lbSenha.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbSenha.setBounds(210, 377, 39, 31);
		contentPane.add(lbSenha);
		
		JLabel lbLogin = new JLabel("");
		lbLogin.setIcon(new ImageIcon(TelaLogin.class.getResource("/image/icons8-customer-32.png")));
		lbLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbLogin.setBounds(210, 302, 33, 31);
		contentPane.add(lbLogin);
		
		tfLogin = new JTextField();
		tfLogin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		tfLogin.setBounds(295, 302, 288, 31);
		contentPane.add(tfLogin);
		tfLogin.setColumns(10);
		
		pswSenha = new JPasswordField();
		pswSenha.setBounds(295, 377, 173, 31);
		contentPane.add(pswSenha);
		
		lbLogo = new JLabel("");
		lbLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/image/icons8-car-insurance-100.png")));
		lbLogo.setBounds(297, 178, 100, 64);
		contentPane.add(lbLogo);
		
		lbLogoEscrito = new JLabel("System Plates SA");
		lbLogoEscrito.setForeground(new Color(255, 0, 0));
		lbLogoEscrito.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		lbLogoEscrito.setBounds(252, 119, 181, 43);
		contentPane.add(lbLogoEscrito);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		btnSair.setBounds(418, 472, 115, 29);
		contentPane.add(btnSair);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String login,senha;
					

					login = tfLogin.getText();
					senha = String.valueOf(pswSenha.getPassword());
					
					//variável con receberá como valor a função faz_conexao() dentro da class ConexaoBd. Onde o intuito é estabelecer a conexão nesta classe. 
					 
					try {
						Connection con = ConexaoBd.faz_conexao();
						
						String comandoSql = "select * from tb_dados_usuarios where nm_user = ? and senha_user = ?";
						PreparedStatement stmt =  con.prepareStatement(comandoSql);
						
						stmt.setString(1,login);
						stmt.setString(2,senha);
						
						ResultSet rs = stmt.executeQuery();
						i--;
						
						TelaMenu telaMenu = new TelaMenu();
						if(rs.next()) {
							
							JOptionPane.showMessageDialog(null, "Seja Bem-Vindo !!! ");
							telaMenu.setVisible(true);
							dispose();
						}
						else if(i > 0) {
							JOptionPane.showMessageDialog(null, "Você tem mais "+i+" tentativas");
						}  
						else {
							JOptionPane.showMessageDialog(null, "Você não é um usuário cadastrado da Empresa !!!");
							dispose();
						}
						
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
	                
			}   
		});
						
		btnEntrar.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		btnEntrar.setBounds(163, 472, 115, 29);
		contentPane.add(btnEntrar);
	}
}
