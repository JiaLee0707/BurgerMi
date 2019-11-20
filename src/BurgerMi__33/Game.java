package BurgerMi__33;

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
	
	public List<Object> BurgerArray = new ArrayList <Object>();
	List<Image> ListImage;
	List<Integer> ListX;
	List<Integer> ListY;
	
	private JButton NextBtn = new JButton(ImageNext);
	
//	Random random = new Random();
	
	private Burger burger;
	private boolean bool = false;
	private int Threadx, Thready;
	public Order order;
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
		
		order = new Order();
	}
	
	public void Thread(Image image, int x, int y, boolean bool) {
		this.ingredients = image;
		Threadx = x;
		Thready = y;
		this.bool = bool;
	}
	
	public void dropBurger(String ingredients) {
		new Music("203.mp3", false).start();
		
		//햄버거 재료 위치 초기화
		int xx=0, yy=500;
		
		//햄버거 재료 x좌표
		switch(ingredients) {
		case "belowBread":
			xx=500; break;
		case "topBread":
			xx=480; break;
		case "lettuce":
			xx=475; break;
		case "tomato":
			xx=490; break;
		case "patty":
			xx=480; break;
		case "cheese":
			xx=475; break;
		}
		
//		System.out.println(BurgerArray.size());
		//재료 순서에 따른 y좌표
		if(BurgerArray.size()+1>1) {
			yy = yy - (20*(BurgerArray.size()+1));
			//토마토 또는 패티면 30 더 밑으로
			if(ingredients.equals("tomato") || ingredients.equals("patty")) {
				yy = yy + 30;
			}
			//윗빵이면 50 더 위로
			else if(ingredients.equals("topBread")) {
				yy = yy - 50;
			}
		}
		
		burger = new Burger(xx, yy, ingredients);
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

	//화면 그리기
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//햄버거 재료(이미지, x좌표, y좌표) ArrayList
		ListImage = new ArrayList<Image>();
		ListX = new ArrayList<Integer>();
		ListY = new ArrayList<Integer>();
		

		//배경화면 그리기
		g.drawImage(ImageBackground, 0, 0, this);
		
		//내려온 재료
//		System.out.println(BurgerArray.size());
		for(int i=0; i<BurgerArray.size(); i++) {
			ListImage.add((Image) ((List<Object>) BurgerArray.get(i)).get(0));
			ListX.add((Integer) ((List<Object>) BurgerArray.get(i)).get(1));
			ListY.add((Integer) ((List<Object>) BurgerArray.get(i)).get(2));
			g.drawImage(ListImage.get(i), ListX.get(i), ListY.get(i), this);
		}
		
		//내려오는 재료
		if(this.bool) {
			g.drawImage(ingredients, Threadx, Thready, this);
		}
		
	}
}
