import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class gui extends JFrame {

	
	JPanel contentPane = new JPanel();
	JTextArea input = new JTextArea();
	JTextArea chatbox = new JTextArea();


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 365, 487);
		
		contentPane.setBackground(UIManager.getColor("Button.disabledText"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Text Input
		input.setBounds(19, 72, 322, 329);
		contentPane.add(input);
		
		//Text Area Chatbox
		chatbox.setBounds(19, 411, 238, 38);
		contentPane.add(chatbox);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setBackground(SystemColor.activeCaption);
		btnSend.setBounds(263, 409, 80, 43);
		contentPane.add(btnSend);
		
		JLabel lblTheratalk = new JLabel("Theratalk");
		lblTheratalk.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheratalk.setFont(new Font("Apple LiGothic", Font.PLAIN, 58));
		lblTheratalk.setBounds(19, 6, 231, 59);
		contentPane.add(lblTheratalk);
		
	}
	
	public void keyReleased(KeyEvent e){
	
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		chatbox.setText(chatbox.getText()+str);
	}
		
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			
		}
	}
}
