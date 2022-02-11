/*
 * Name : MessageShowUI.java
 *
 * Function : To show the notice
 * 
 * Author : Chen Zewen
 * 
 * Student Number : 18301154
 * 
 * Date : 2019/12/23
 */

package allUI;

import java.awt.BorderLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import actions.Focus;

/**
 * This class is used to show the notice
 * @author Zevin
 *
 */
public class NoticeUI extends JFrame {

	private JPanel contentPane;
	private Focus f = Focus.getInstance();

	/**
	 * Create the frame.
	 * 
	 * @param type1
	 */
	public NoticeUI(String type, String message, final String type1) {
		
		// Set the frame
		setResizable(false);
		setAlwaysOnTop(true);

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Add the window listener
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (type1.equals("NO") == false) {
					f.setDefault();
					dispose();
				}

			}
		});

		// Set the different types of title
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\LoginTank.png"));
		if (type.equals("Game Rule")) {
			type = "��Ϸ����";
		} else if (type.equals("Ready")) {
			type = "׼��";
		} else if (type.equals("Waiting")) {
			type = "���Ժ�";
		} else if (type.equals("Highest Score")) {
			type = "Ĥ�ݴ���";
		} else if (type.equals("Success")) {
			type = "�ɹ�";
		} else if (type.equals("Warning")) {
			type = "����";
		} else if (type.equals("Error")) {
			type = "������";
		}
		setTitle(type);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		// NO means you can't close the ui
		if (type1.equals("NO") == false) {
			
			// Add the confirm button
			JButton btnNewButton = new JButton("\u786E\u5B9A");
			btnNewButton.addMouseListener(new MouseAdapter() {

				public void mouseReleased(MouseEvent e) {
					f.setDefault();
					dispose();
				}

			});
			btnNewButton.setFont(new Font("����", Font.BOLD, 20));
			contentPane.add(btnNewButton, BorderLayout.SOUTH);
		}

		// Set the message
		if (message.contains("�����û���")) {
			JTextArea lblMessage = new JTextArea(message);
			lblMessage.setFont(new Font("����", Font.BOLD, 20));
			contentPane.add(lblMessage, BorderLayout.CENTER);
		} else if (message.equals("RULES")) {
			setBounds(100, 100, 425, 300);
			JLabel ruleLabel = new JLabel();
			ruleLabel.setIcon(new ImageIcon("img\\rule.png"));
			contentPane.add(ruleLabel, BorderLayout.CENTER);
		} else {
			JLabel lblMessage = new JLabel(message);
			lblMessage.setFont(new Font("����", Font.BOLD, 20));
			lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
			contentPane.add(lblMessage, BorderLayout.CENTER);
		}

		f.setFocus(contentPane);

		setVisible(true);
	}

	/** To close the ui */
	public void closeUI() {
		dispose();
	}
}
