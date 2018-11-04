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

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

import dominio.DadosMotoristaAPS;
import javax.swing.JRadioButton;
import view.Alerta;


public class UpdateDelete extends JFrame {

	private JPanel contentPane;
	public static JTextField tfId;
	public static JTextField tfNome;
	public static JTextField tfCpf;
	public static JTextField tfTel;
	public static JTextField tfCel;
	public static JTextField tfEmp;
	public static JButton btnOk;
	public static Transaction tx;
	public static Session session;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDelete frame = new UpdateDelete();
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
	public UpdateDelete() {
		

		//Configuranndo o caminho do xml, criando fabrica de sessão, abrindo uma sessão e criando um objeto p/ transação
				Configuration cfg = new AnnotationConfiguration();
				cfg.configure("/conf/hibernate.cfg.xml");
				SessionFactory sf = cfg.buildSessionFactory();
				Session session = sf.openSession();
				Transaction tx = session.beginTransaction();
	
		setTitle("Update/Delete");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 641);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(UpdateDelete.class.getResource("/image/icons8-car-insurance-100.png")));
		label.setBounds(43, 27, 100, 78);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("System Plates SA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22));
		label_1.setBounds(15, -11, 181, 43);
		contentPane.add(label_1);
		
		JLabel lblInsiraOId = new JLabel("Nome");
		lblInsiraOId.setForeground(SystemColor.desktop);
		lblInsiraOId.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblInsiraOId.setBounds(335, 126, 74, 30);
		contentPane.add(lblInsiraOId);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblCpf.setBounds(344, 211, 47, 30);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblTelefone.setBounds(317, 293, 92, 30);
		contentPane.add(lblTelefone);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblCelular.setBounds(327, 387, 74, 30);
		contentPane.add(lblCelular);
		
		JLabel lblEmplacamento = new JLabel("Emplacamento");
		lblEmplacamento.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
		lblEmplacamento.setBounds(286, 470, 152, 30);
		contentPane.add(lblEmplacamento);
		
		JComboBox cbOpc = new JComboBox();
		cbOpc.setForeground(SystemColor.textHighlight);
		cbOpc.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		cbOpc.setModel(new DefaultComboBoxModel(new String[] {"Atualizar", "Deletar", "Inserir"}));
		cbOpc.setBounds(239, 27, 140, 37);
		contentPane.add(cbOpc);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		lblId.setBounds(394, 35, 69, 20);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfId.setBounds(436, 34, 56, 26);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfNome.setBounds(198, 159, 318, 26);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfCpf.setColumns(10);
		tfCpf.setBounds(198, 241, 318, 26);
		contentPane.add(tfCpf);
		
		tfTel = new JTextField();
		tfTel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfTel.setColumns(10);
		tfTel.setBounds(198, 326, 318, 26);
		contentPane.add(tfTel);
		
		tfCel = new JTextField();
		tfCel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfCel.setColumns(10);
		tfCel.setBounds(198, 417, 318, 26);
		contentPane.add(tfCel);
		
		tfEmp = new JTextField();
		tfEmp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfEmp.setColumns(10);
		tfEmp.setBounds(198, 504, 318, 26);
		contentPane.add(tfEmp);
		
		btnOk = new JButton("OK !");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String opc = String.valueOf(cbOpc.getSelectedItem());
				
				if(opc.equals("Atualizar")){
					//criando e atribuindo o valor das JTextField para as variáveis.
					String nome,cpf,tel,cel,emp;
					int id = Integer.parseInt(tfId.getText());
					nome = tfNome.getText();
					cpf = tfCpf.getText();
					tel = tfTel.getText();
					cel = tfCel.getText();
					emp = tfEmp.getText();
				
					//Enviando os dados da TextField para o parâmetro.
					DadosMotoristaAPS motorista = new DadosMotoristaAPS();
					motorista.setCod(id);
					motorista.setNome(nome);
					motorista.setCpf(cpf);
					motorista.setTel(tel);
					motorista.setCel(cel);
					motorista.setNumero(emp);
					session.update(motorista);
					
					/////////////////////////////////////////////////////////////////
					
					// JPanel Para questionar o usuário se deve ser dado o Commit
					
					String confirm ;
					
					confirm = JOptionPane.showInputDialog(null, "Tem Certeza que desejas INSERIR/ATUALIZAR/DELETAR estes dados ? Digite S = Sim | N = Não");
					
				    if(confirm.equals("N")||confirm.equals("n")){
					tx.rollback();
					JOptionPane.showMessageDialog(null, "Rollback Succefull");
				    }
				    else if(confirm.equals("S")||confirm.equals("s")){
				    tx.commit();	
				    JOptionPane.showMessageDialog(null, "Commit Succefull");
				    }
				}
				else if(opc.equals("Deletar")){
					
					JOptionPane.showMessageDialog(null,"Botão Deletar Ok !!!");
					
					//criando e atribuindo o valor das JTextField para as variáveis.
					String nome,cpf,tel,cel,emp;
					int id = Integer.parseInt(tfId.getText());
					nome = tfNome.getText();
					cpf = tfCpf.getText();
					tel = tfTel.getText();
					cel = tfCel.getText();
					emp = tfEmp.getText();
				
					//Enviando os dados da TextField para o parâmetro.
					DadosMotoristaAPS motorista = new DadosMotoristaAPS();
					motorista.setCod(id);
					motorista.setNome(nome);
					motorista.setCpf(cpf);
					motorista.setTel(tel);
					motorista.setCel(cel);
					motorista.setNumero(emp);
					
					session.delete(motorista);
					 
                    // JPanel Para questionar o usuário se deve ser dado o Commit
                    String confirm ;
					
					confirm = JOptionPane.showInputDialog(null, "Tem Certeza que desejas INSERIR/ATUALIZAR/DELETAR estes dados ? Digite S = Sim | N = Não");
					
				    if(confirm.equals("N")||confirm.equals("n")){
					tx.rollback();	
					JOptionPane.showMessageDialog(null, "Rollback Succefull");
				    }
				    else if(confirm.equals("S")||confirm.equals("s")){
				    tx.commit();	
				    JOptionPane.showMessageDialog(null, "Commit Succefull");
				    }
					
					
				}
				else if(opc.equals("Inserir")){
					 
                    JOptionPane.showMessageDialog(null,"Botão Inserir Ok !!!");
					
					//criando e atribuindo o valor das JTextField para as variáveis.
					String nome,cpf,tel,cel,emp;
					int id = Integer.parseInt(tfId.getText());
					nome = tfNome.getText();
					cpf = tfCpf.getText();
					tel = tfTel.getText();
					cel = tfCel.getText();
					emp = tfEmp.getText();
				
					//Enviando os dados da TextField para o parâmetro.
					DadosMotoristaAPS motorista = new DadosMotoristaAPS();
					motorista.setCod(id);
					motorista.setNome(nome);
					motorista.setCpf(cpf);
					motorista.setTel(tel);
					motorista.setCel(cel);
					motorista.setNumero(emp);
					
					session.save(motorista);
					 
                    // JPanel Para questionar o usuário se deve ser dado o Commit
                    String confirm ;
					
					confirm = JOptionPane.showInputDialog(null, "Tem Certeza que desejas INSERIR/ATUALIZAR/DELETAR estes dados ? Digite S = Sim | N = Não");
					
				    if(confirm.equals("N")||confirm.equals("n")){
					tx.rollback();	
					JOptionPane.showMessageDialog(null, "Rollback Succefull");
				    }
				    else if(confirm.equals("S")||confirm.equals("s")){
				    tx.commit();	
				    JOptionPane.showMessageDialog(null, "Commit Succefull");
				    }
					
					
				}
			}
		});
		btnOk.setForeground(SystemColor.textHighlight);
		btnOk.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		btnOk.setBounds(128, 540, 115, 29);
		contentPane.add(btnOk);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tfNome.setText("");
				tfCpf.setText("");
				tfTel.setText("");
				tfCel.setText("");
				tfEmp.setText("");
			}
		});
		btnLimpar.setForeground(SystemColor.textHighlight);
		btnLimpar.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		btnLimpar.setBounds(294, 540, 115, 29);
		contentPane.add(btnLimpar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaMenu telaMenu = new TelaMenu();
				telaMenu.setVisible(true);
				session.close();
				dispose();
			}
		});
		btnVoltar.setForeground(SystemColor.textHighlight);
		btnVoltar.setFont(new Font("Segoe UI Black", Font.BOLD | Font.ITALIC, 20));
		btnVoltar.setBounds(463, 540, 115, 29);
		contentPane.add(btnVoltar);
		
	}
	
}
