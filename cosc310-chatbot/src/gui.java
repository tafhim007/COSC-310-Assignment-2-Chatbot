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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class gui extends JFrame implements ActionListener {

	static ServerSocket ss;
	static Socket s;
	static DataInputStream dataIn;
	static DataOutputStream dataOut;
	
	static JPanel contentPane = new JPanel();
	static JTextArea input = new JTextArea("");
	static JTextArea chatbox = new JTextArea("");


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
		
		String msgIn = "";
		try {
			ss = new ServerSocket(1201);
			s = ss.accept();
			
			dataIn = new DataInputStream(s.getInputStream());
			dataOut = new DataOutputStream(s.getOutputStream());
			
			while(!msgIn.equals("exit")) {
				msgIn = dataIn.readUTF();
				
				chatbox.setText(chatbox.getText().trim()+"\n"+msgIn);
			}
			
		}catch(Exception e) {
			System.out.println("Error");
		}
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
		
		setVisible(true);
	}
	
	public void keyReleased(KeyEvent e){
	
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
		}
	}
	
	public void keyTyped(KeyEvent e){}
	
	public void addText(String str){
		chatbox.setText(chatbox.getText()+str);
	}
		
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(false);
			
			//get message
			String quote=input.getText();
			input.setText("");
			addText("-->You:\t"+quote);
			quote.trim();
			
			GreetUser greetClass = new GreetUser();
			greetClass.startGreetings();
			
			addText("\n");
		}
	}
	
	private void btnSendAction(java.awt.event.ActionEvent evt) {
		try {
			String msgOut = "";
			msgOut = input.getText().trim();
			dataOut.writeUTF(msgOut); //sending server message
		}catch(Exception e) {
			System.out.println("Error");
		}
		
	}
	
	public class txtInputListener implements ActionListener
	{
	    public void actionPerformed(ActionEvent event)
	    {
	        GreetUser.userName = input.getText();   //receive input from text field
	        System.out.println(input);
	    }
	}	
}
