package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import dominio.DadosMotoristaAPS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import view.UpdateDelete;

public class Alerta extends JFrame {

	public JPanel contentPane;
    public static JRadioButton rbSim;
    public static JRadioButton rbNao;
	public static JButton btnConfirma;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public static int id;
	public static String nome;
	public static String cpf;
	public static String cel;
	public static String tel;
	public static String plate;
	
	
	/**
	 * Create the frame.
	 */
	public Alerta() {
		
		//Configuranndo o caminho do xml, criando fabrica de sessão, abrindo uma sessão e criando um objeto p/ transação
				Configuration cfg = new AnnotationConfiguration();
				cfg.configure("/conf/hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();
		
		
		setTitle("Pense com Cuidado !!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTemCertezaQue = new JLabel("Tem Certeza que desejas Inserir/ Atualizar ou Deletar\r\n estes dados ?");
		lblTemCertezaQue.setVerticalAlignment(SwingConstants.TOP);
		lblTemCertezaQue.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 16));
		lblTemCertezaQue.setBounds(15, 16, 609, 27);
		contentPane.add(lblTemCertezaQue);
		
		JRadioButton rbSim = new JRadioButton("Sim");
		buttonGroup.add(rbSim);
		rbSim.setBounds(263, 55, 59, 29);
		contentPane.add(rbSim);
		
		JRadioButton rbNao = new JRadioButton("N\u00E3o");
		buttonGroup.add(rbNao);
		rbNao.setBounds(324, 55, 82, 29);
		contentPane.add(rbNao);
		
		JButton btnConfirma = new JButton("Confirma");
		btnConfirma.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 18));
		btnConfirma.setBounds(444, 59, 115, 29);
		contentPane.add(btnConfirma);
	}

}
