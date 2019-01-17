package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dao.UserDao;

public class ViewLogin {

	private JFrame frame;
	private JTextField nome;
	private JPasswordField password;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin window = new ViewLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ViewLogin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(148, 83, 155, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(92, 86, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(92, 137, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		password = new JPasswordField();
		password.setBounds(148, 131, 155, 20);
		frame.getContentPane().add(password);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(195, 58, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 UserDao dao = new UserDao();
			       
			       if(dao.checkLogin(nome.getText(), password.getText())){
			           new ViewHome().setVisible(true);
			        //   this.dispose();
			       }else{
			           JOptionPane.showMessageDialog(null, "Senha incorreta!");
			       }

			}
		});
		btnEnter.setBounds(178, 170, 89, 23);
		frame.getContentPane().add(btnEnter);
	}
}
