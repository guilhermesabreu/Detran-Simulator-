package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("System Plates SA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 641);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 709, 38);
		contentPane.add(menuBar);
		
		JMenu mnAes = new JMenu("A\u00E7\u00F5es");
		mnAes.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		menuBar.add(mnAes);
		
		JMenuItem mntmAtualizarMotoristas = new JMenuItem("Atualizar/Excluir/Inserir Dados do Motorista");
		mntmAtualizarMotoristas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateDelete telaDelete = new UpdateDelete();
				telaDelete.setVisible(true); 
				dispose();
			}
		});
		mntmAtualizarMotoristas.setForeground(SystemColor.textHighlight);
		mntmAtualizarMotoristas.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		mnAes.add(mntmAtualizarMotoristas);
		
		JMenuItem mntmOrdenaoDosDados = new JMenuItem("Ordena\u00E7\u00E3o dos Dados");
		mntmOrdenaoDosDados.setForeground(SystemColor.textHighlight);
		mntmOrdenaoDosDados.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		mnAes.add(mntmOrdenaoDosDados);
		
		JMenuItem mntmPlacasPreviamenteCadastradas = new JMenuItem("Placas Previamente Cadastradas");
		mntmPlacasPreviamenteCadastradas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      Insert insert = new Insert();	
				  insert.setVisible(true);
				  dispose();
			}
		});
		mntmPlacasPreviamenteCadastradas.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		mntmPlacasPreviamenteCadastradas.setForeground(SystemColor.textHighlight);
		mnAes.add(mntmPlacasPreviamenteCadastradas);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmSair.setForeground(SystemColor.textHighlight);
		mntmSair.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		mnAes.add(mntmSair);
		
		JMenu mnVisualizao = new JMenu("Visualiza\u00E7\u00E3o");
		mnVisualizao.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 24));
		menuBar.add(mnVisualizao);
		
		JMenuItem mntmPdfDasPlacas = new JMenuItem("PDF das placas cadastradas");
		mntmPdfDasPlacas.setForeground(SystemColor.textHighlight);
		mntmPdfDasPlacas.setFont(new Font("Segoe UI Historic", Font.PLAIN, 18));
		mnVisualizao.add(mntmPdfDasPlacas);
		
		JTextArea txtrAds = new JTextArea();
		txtrAds.setBackground(Color.LIGHT_GRAY);
		txtrAds.setFont(new Font("Arial", Font.PLAIN, 25));
		txtrAds.setLineWrap(true);
		txtrAds.setText("A foto da placa cadastrada, s\u00F3 ser\u00E1 exposta em 1 semana, ap\u00F3s a Verifica\u00E7\u00E3o e Confirma\u00E7\u00E3o do DETRAN .\r\nPara encontrar a sua placa, pressione CTRL + F,  e digite o n\u00FAmero dela.  ");
		txtrAds.setBounds(15, 255, 668, 120);
		contentPane.add(txtrAds);
		
		JLabel label = new JLabel("Bem vindo ao:");
		label.setForeground(Color.RED);
		label.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		label.setBounds(260, 38, 173, 43);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("System Plates SA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(246, 83, 181, 43);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaMenu.class.getResource("/image/icons8-car-insurance-100.png")));
		label_2.setBounds(291, 142, 100, 64);
		contentPane.add(label_2);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.control);
		btnVoltar.setIcon(new ImageIcon(TelaMenu.class.getResource("/image/icons8-left-96.png")));
		btnVoltar.setBounds(291, 481, 100, 51);
		contentPane.add(btnVoltar);
	}
}
