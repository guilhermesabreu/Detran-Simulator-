package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import dominio.DadosMotoristaAPS;
import dominio.DadosMotoristaAPS;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.TableModel;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class Insert extends JFrame {

	private JPanel contentPane;
	public JTable table;
	public ScrollPane scrollPane;
    DefaultTableModel modelo = new DefaultTableModel();
    private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insert frame = new Insert();
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
	public Insert() {
		setTitle("Motoristas Cadastrados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 641);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTabelaMotoristasPreviamente = new JLabel("Tabela- Motoristas Previamente Cadastrados");
		lblTabelaMotoristasPreviamente.setBounds(177, 32, 506, 35);
		lblTabelaMotoristasPreviamente.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(lblTabelaMotoristasPreviamente);
		
		
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(15, 167, 668, 402);
		contentPane.add(scrollPane);
		
		table_1 = new JTable(modelo);
		table_1.setEnabled(false);
		table_1.setForeground(Color.WHITE);
		table_1.setBackground(Color.BLACK);
		scrollPane.setViewportView(table_1);
		
		
		JButton btnVisualizar = new JButton("View");
		btnVisualizar.setForeground(SystemColor.textHighlight);
		btnVisualizar.setBounds(568, 122, 115, 29);
		btnVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				carregarTable();
			}
		});
		btnVisualizar.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnVisualizar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Insert.class.getResource("/image/icons8-car-insurance-100.png")));
		label.setBounds(28, 38, 100, 78);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("System Plates SA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(0, 0, 181, 43);
		contentPane.add(label_1);
		
		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMenu menu = new TelaMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		button.setForeground(SystemColor.textHighlight);
		button.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		button.setBounds(451, 122, 115, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Limpar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setForeground(SystemColor.textHighlight);
		button_1.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		button_1.setBounds(334, 122, 115, 29);
		contentPane.add(button_1);
		
		modelo.addColumn("ID");
		modelo.addColumn("Nome");
		modelo.addColumn("Cpf");
		modelo.addColumn("Telefone");
		modelo.addColumn("Celular");
		modelo.addColumn("Nº-Placa");
	}
	public void carregarTable(){
		
		Configuration cfg = new AnnotationConfiguration();
	    cfg.configure("conf/hibernate.cfg.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Transaction tx = session.beginTransaction();
		
        DadosMotoristaAPS dados;
		
		List<?> usuariosList = session.createQuery("from DadosMotoristaAPS order by cod ASC").list();
	
		
		for(int i = 0; i < usuariosList.size(); i++)
		{
		    dados =  (DadosMotoristaAPS) usuariosList.get(i);
			/*System.out.println("Linha "+i+ "->" +dados.getLogin() +"---"+dados.getSenha());*/
			
			modelo.addRow(new Object[] {dados.getCod(),dados.getNome(),dados.getCpf(),dados.getTel(),dados.getCel(),dados.getNumero()});

		}
	
		tx.commit();
		session.close();
	    
		
	}
}
