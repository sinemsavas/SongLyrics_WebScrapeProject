import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Label;
import javax.swing.ImageIcon;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textArtist;
	private JTextField textSong;
	private JLabel lblSongName;
	private JTextArea textLyrics;
	private JScrollBar scrollBar;
	private JScrollPane scroll;
	private JLabel lblLyrics;
	
	public static void main(String[] args) {

		Logger logger = Logger.getLogger(GUI.class);
		logger.info("Entering the main method");
		BasicConfigurator.configure();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
 });
		
}
	
//my frame
	public GUI() {
		
		
		Logger logger = Logger.getLogger(GUI.class);
		logger.info("Swing activated");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 641);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Artist Name:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(32, 30, 348, 63);
		contentPane.add(lblNewLabel);
		
		textArtist = new JTextField();
		textArtist.setBackground(new Color(255, 204, 204));
		textArtist.setBounds(32, 83, 252, 38);
		contentPane.add(textArtist);
		textArtist.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			new WebScraping();
			logger.info("Enter button triggered");
			String Singer = textArtist.getText();
		    String Song = textSong.getText();
	
		  logger.info("");
		  try {
			 textLyrics.setText(WebScraping.getSongLyrics(Singer, Song));
			
			}
		  catch (Exception e1) {
		    textLyrics.setText("No song or singer found, please try again.");
		    logger.error("Error Message");
		    }
         }
	});
		btnNewButton.setBounds(32, 252, 104, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Fields are reset");
				textArtist.setText("");
				textSong.setText("");
				textLyrics.setText("");

			}
	});
		btnNewButton_1.setBounds(193, 252, 91, 38);
		contentPane.add(btnNewButton_1);
		
		
		textSong = new JTextField();
		textSong.setBackground(new Color(255, 204, 204));
		textSong.setColumns(10);
		textSong.setBounds(32, 187, 252, 30);
		contentPane.add(textSong);
		
	
		
		lblSongName = new JLabel("Song Name:");
		lblSongName.setForeground(Color.BLACK);
		lblSongName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSongName.setBounds(32, 132, 348, 63);
		contentPane.add(lblSongName);
		
		textLyrics = new JTextArea();
		textLyrics.setFont(new Font("Myanmar Text", Font.BOLD, 14));
		textLyrics.setBackground(new Color(255, 204, 204));
		textLyrics.setEditable(false);
		textLyrics.setLineWrap(true);
		textLyrics.setBounds(32, 20, 323, 552);
		contentPane.add(textLyrics);
		
		JScrollPane scroll = new JScrollPane(textLyrics, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scroll);
		scroll.setBounds(388, 42, 323, 552);

		lblLyrics = new JLabel("Lyrics");
		lblLyrics.setForeground(Color.BLACK);
		lblLyrics.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLyrics.setBounds(390, 11, 305, 38);
		contentPane.add(lblLyrics);
		
	}
}
