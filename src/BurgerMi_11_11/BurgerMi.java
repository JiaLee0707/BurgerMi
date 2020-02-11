package BurgerMi_11_11;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BurgerMi extends JFrame{
	
	public Background background;
	
	public BurgerMi() {
		setTitle("BurgerMi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		background = new Background();
		setContentPane(background);
		setSize(1280, 720);
		setResizable(false);	//â ũ�� ����X
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);	//â��ġ ���
	}
}
class Background extends JPanel{
	private Image ImageBackground = new ImageIcon("src/images/BurgerMi���纻.png").getImage();
	private ImageIcon StartBasicImage = new ImageIcon("src/images/startButtonBasic.png");
	private ImageIcon StartEnteredImage = new ImageIcon("src/images/startButtonEntered.png");
	private ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	private ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	private Image MenuImage = new ImageIcon("src/images/�޴�ȭ��.png").getImage();
	
	private JButton StartBtn = new JButton(StartBasicImage);
	private JButton QuitBtn = new JButton(QuitBasicImage);
	
	public Background() {
		
	}
	
	
	
	// ȭ�� �׸���
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ImageBackground, 0, 0, this);
	}
}