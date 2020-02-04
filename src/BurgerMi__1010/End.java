package BurgerMi__1010;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class End {
	private ImageIcon ReplayBasicImage = new ImageIcon("src/images/replayButtonBasic.png");
	private ImageIcon ReplayEnteredImage = new ImageIcon("src/images/replayButtonEntered.png");
	private ImageIcon QuitBasicImage = new ImageIcon("src/images/quitButtonBasic.png");
	private ImageIcon QuitEnteredImage = new ImageIcon("src/images/quitButtonEntered.png");
	public JLabel allGrade = new JLabel("���� : " + BurgerMi.game.score.score + "��");
	private JButton replayBtn = new JButton(ReplayBasicImage);
	private JButton QuitBtn = new JButton(QuitBasicImage);
	

	End() {
		BurgerMi.game.grade.setVisible(false);
		BurgerMi.game.timer.time.setVisible(false);

		// �ܹ��Ű� �������� �� ������ ���� �־
		// �ѹ� �� �ʱ�ȭ
		BurgerMi.game.order.orderBurger.clear();
		BurgerMi.game.order.MakeBurger.clear();
		BurgerMi.game.ingredients = null;

		BurgerMi.game.gameStart = false;

		BurgerMi.game.gameMusic.close();


		BurgerMi.ranking.insert.Insert(BurgerMi.game.score.score);
		BurgerMi.ranking.update.Update();
		
		// �ٽ��ϱ� ��ư
		replayBtn.setBounds(280, 470, 340, 120);
		replayBtn.setBorderPainted(false);
		replayBtn.setContentAreaFilled(false);
		replayBtn.setFocusPainted(false);
		replayBtn.addMouseListener(new MouseListener(ReplayBasicImage, ReplayEnteredImage));
		replayBtn.setVisible(true);
		BurgerMi.game.add(replayBtn);
		
		// �����ư
		QuitBtn.setBounds(620, 470, 340, 120);
		QuitBtn.setBorderPainted(false);
		QuitBtn.setContentAreaFilled(false);
		QuitBtn.setFocusPainted(false);
		QuitBtn.addMouseListener(new MouseListener(QuitBasicImage, QuitEnteredImage));
		QuitBtn.setVisible(true);
		BurgerMi.game.add(QuitBtn);
		
		// ���� ����
		BurgerMi.Menu = true;

		JLabel GameResult = new JLabel("���� ���");
		GameResult.setFont(BurgerMi.font); // ��Ʈ ����
		GameResult.setSize(800, 800); // ũŰ ����
		GameResult.setLocation(540, -280); // ��ġ ����
		BurgerMi.game.add(GameResult);
		GameResult.setVisible(true);
		
		// �� ���� ���
		allGrade.setFont(BurgerMi.font); // ��Ʈ ����
		allGrade.setSize(700, 700); // ũŰ ����
		allGrade.setLocation(540, 30); // ��ġ ����
		BurgerMi.game.add(allGrade);
		allGrade.setVisible(true);

		BurgerMi.game.revalidate();
		BurgerMi.game.repaint();
	}

	// ���콺 ������
	class MouseListener extends MouseAdapter {
		ImageIcon Basic;
		ImageIcon Entered;

		public MouseListener(ImageIcon BasicImageIcon, ImageIcon EnteredImageIcon) {
			Basic = BasicImageIcon;
			Entered = EnteredImageIcon;
		}

		// �⺻��ư
		@Override
		public void mouseExited(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Basic);
		}

		// Ŭ����ư
		@Override
		public void mouseClicked(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);

			Music Button = new Music("buttonPressedMusic.mp3", false);
			Button.start();

			if (Entered.equals(QuitEnteredImage)) {
				System.exit(0);
			}

			button.setVisible(false);
			replayBtn.setVisible(false);
			QuitBtn.setVisible(false);
			allGrade.setVisible(false);

			BurgerMi.game.revalidate();
			BurgerMi.game.repaint();
			BurgerMi.game.getParent().repaint();

			BurgerMi.Menu = false;
			BurgerMi.replay = true;
			System.out.println("replay");
			Main.burgermi.JPanelChange();
		}

		// ��ư ���� �ø���
		@Override
		public void mouseEntered(MouseEvent e) {
			JButton button = (JButton) e.getSource();
			button.setIcon(Entered);
			button.setCursor(new Cursor(Cursor.HAND_CURSOR));

			Music Button = new Music("buttonEnteredMusic.mp3", false);
			Button.start();
		}
	}
}
