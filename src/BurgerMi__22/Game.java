package BurgerMi__22;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import BurgerMi_3.Music;

public class Game extends JPanel{
	private Image ImageGame = new ImageIcon("src/images/GameBackground.png").getImage();
	private Image ImageRules = new ImageIcon("src/images/GameRules.jpg").getImage();
	private ImageIcon ImageNext = new ImageIcon("src/images/오른쪽버튼.png");
	private Image ImageBackground = ImageRules;
	private Image ingredients;
	List<Object> BurgerArray = new ArrayList <Object>();
//	List<Object> Array = new ArrayList <Object>();
	
	private JButton NextBtn = new JButton(ImageNext);
	private Burger burger;
	private boolean bool = false;
	private int Threadx, Thready;
	public int x, y;
	Game() {
		setLayout(null);
		
		//게임방범 확인버튼
		NextBtn.setBounds(10, 350, 340, 120);
		NextBtn.setBorderPainted(false);
		NextBtn.setContentAreaFilled(false);
		NextBtn.setFocusPainted(false);
		NextBtn.addMouseListener(new MouseListener());
		NextBtn.setVisible(true);
		this.add(NextBtn);
		
		this.addKeyListener(new KeyListener());
		this.setFocusable(true);
		
	}
	
	public void Thread(Image image, int x, int y, boolean bool) {
		this.ingredients = image;
		Threadx = x;
		Thready = y;
		this.bool = bool;
		
//		System.out.println(this.y);
		
//		Array.add(this.ingredients);
//		Array.add(this.x);
//		Array.add(this.y);
//		BurgerArray.add((List<Object>) Array);
//		System.out.println(BurgerArray.get(0));
		
//		System.out.println("Thread");
//		System.out.println(((List<Object>) BurgerArray.get(0)).get(2));
//		System.out.println(Array.get(2));
	}
	
	public void dropBurger(String ingredients) {
		new Music("203.mp3", false).start();
		
		burger = new Burger(595, 100, ingredients);
		burger.start();
		

	}

	//확인버튼 마우스리스너
	class MouseListener extends MouseAdapter{

		//기본버튼
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton)e.getSource();
		}

		//클릭버튼
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			
			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();
			
			ImageBackground = ImageGame;
			button.setVisible(false);
			getParent().repaint();
		}
			
		//버튼 위에 올리면
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton)e.getSource();
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
		}
	}

	public void paintComponent(Graphics g) {
		List<Image> image = new ArrayList<Image>();
		List<Integer> x = new ArrayList<Integer>();
		List<Integer> y = new ArrayList<Integer>();
		
		super.paintComponent(g);

		g.drawImage(ImageBackground, 0, 0, this);
		
		for(int i=0; i<BurgerArray.size(); i++) {
			image.add((Image) ((List<Object>) BurgerArray.get(i)).get(0));
			x.add((Integer) ((List<Object>) BurgerArray.get(i)).get(1));
			y.add((Integer) ((List<Object>) BurgerArray.get(i)).get(2));
			g.drawImage(image.get(i), x.get(i), y.get(i), this);
		}
		
		
		if(this.bool) {
			g.drawImage(ingredients, Threadx, Thready, this);
//			System.out.println(((List<Object>) Array.get(0)).get(1));
		}
	}
}
