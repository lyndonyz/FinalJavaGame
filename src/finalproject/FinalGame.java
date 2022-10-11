package finalproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class FinalGame {

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new FinalGame();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}	
			}
		});
	}
	String levelName = "";
	double audioFade = 20.0;
	PlayerTrail[] trail = new PlayerTrail[4];
	int directionRx = (int)(Math.random()*1000);
	int directionRy = (int)(Math.random()*800);
	boolean dashCircleA = false;
	boolean dmgCircleA = false;
	int trailPosX = 0;
	int trailPosY = 0;
	int trailNum = 0;
	int playerHP = 4;
	int activeD = 0;
	int dashMulti = 1;
	int cooldown;
	boolean playerInv = false;
	boolean playerDashInv = false;
	boolean dash = true;
	int tick = 0;
	JFrame window;
	JPanel panel;
	static Rectangle[] enemy = new Rectangle[200];
	static EnemyObjectLogic[] enemyL = new EnemyObjectLogic[200];
	Rectangle player= new Rectangle(panW/2,panH/2, 25, 25);
	MyKL mainKL = new MyKL();
	Timer timer;
	int timerspeed = 15;
	File file = new File("Warriyo - Mortals (feat. Laura Brehm) [NCS Release].wav");
	AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
	Clip Mortals = AudioSystem.getClip();
	static int panW = 1000, panH = 800;
	int newCX = player.x;
	int newCY = player.y;
	DashCircle circle = new DashCircle(newCX,newCY,0);
	DashCircle dmgcircle = new DashCircle(player.x,player.y,0);
	
	FinalGame() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		for (int i = 0; i<enemyL.length; i++) {
			enemyL[i] = new EnemyObjectLogic("Rectangle",true, 0,0,1,1,0,1,false,false,0,false,false);
		}
		for (int i = 0; i<trail.length; i++) {
			trail[i] = new PlayerTrail(i,player.x,player.y);
		}
		window = new JFrame("OnLy PoLyGons AnD SouNDWaVeS (OPaS)");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new DrawingPanel();
		panel.setBackground(new Color(13, 18, 31));
		window.add(panel); //the panel will control the size
		window.pack();	   //therefore we need to pack
		window.setVisible(true);
		timer = new Timer(timerspeed, new MyTimer());
		timer.start();
		Mortals();
	}
	 void Mortals() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		 levelName = "Mortals";
		 Mortals.open(audioStream);
		 FloatControl gainControl = (FloatControl) Mortals.getControl(FloatControl.Type.MASTER_GAIN);
		 gainControl.setValue((float) -audioFade);
		 Mortals.start();
		 LevelMortals.Mortals();
	}
	private class DrawingPanel extends JPanel{
		DrawingPanel() {
			this.setBackground(Color.white);
			this.setPreferredSize(new Dimension(panW,panH));
			this.addKeyListener(mainKL);
			this.setFocusable(true); //need something like this to get focus
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//enemy blocks
			g.setColor(new Color(255, 0, 0, 100));
			for(int i = 0; i<enemyL.length; i++) {
				if (enemyL[i].indiActive) {
					if (enemyL[i].shape.equals("Rectangle")) {
						g.fillRect(enemyL[i].x1, enemyL[i].y1, enemyL[i].x2, enemyL[i].y2);
					}
					else {
						g.fillArc(enemyL[i].x1, enemyL[i].y1, enemyL[i].x2, enemyL[i].y2, 0 , 360);
					}
				}
			}
			g.setColor(Color.red);
			for(int i = 0; i<enemyL.length; i++) {
				if (enemyL[i].active) {
					if (enemyL[i].shape.equals("Rectangle")) {
						g.fillRect(enemyL[i].x1, enemyL[i].y1, enemyL[i].x2, enemyL[i].y2);
					}
					else {
						g.fillArc(enemyL[i].x1, enemyL[i].y1, enemyL[i].x2, enemyL[i].y2, 0 , 360);
					}
				}
			}
			//player code
			if (activeD==0) {
				if (tick%5 == 0) {
					trailPosX = player.x;
					trailPosY = player.y;
					trail[0] = new PlayerTrail(0,trail[1].x,trail[1].y);
					trail[1] = new PlayerTrail(1,trail[2].x,trail[2].y);
					trail[2] = new PlayerTrail(2,trail[3].x,trail[3].y);
					trail[3] = new PlayerTrail(3, trailPosX,trailPosY);
				}
				for (int i = 0; i<trail.length; i++) {
					g.setColor(new Color(0, 0, 255, trail[i].fade));
					g2.setStroke(new BasicStroke(3));
					g.drawRect(trail[i].x+6, trail[i].y+6, player.width-12, player.height-12);
				}
			}
			if (activeD!= 0) {
				for (int i = 0; i<trail.length; i++) {
					trail[i] = new PlayerTrail(i,player.x,player.y);
				}
			}
			if (player.x >panW-player.width) {
				player.x = panW-player.width;
			}
			if (player.x <0) {
				player.x = 0;
			}
			if (player.y >panH-player.height) {
				player.y = panH-player.height;
			}
			if (player.y <0) {
				player.y = 0;
			}
			//player shadow
			g.setColor(Color.black);
			g.fillRect(player.x+3, player.y+3, player.width, player.height);
			
			//player boosting
			if (activeD!=0 || playerInv && playerHP != 0) {
				g.setColor(new Color(178, 247, 242));
				g.fillRect(player.x-3, player.y-3, player.width+6, player.height+6);
			}
			if (!dash) {
				g.setColor(new Color(0, 0, 255, circle.fade));
				g2.setStroke(new BasicStroke(25));
				g.drawArc(circle.x, circle.y,circle.width, circle.height, 0, 360);
			}
			if (dmgCircleA) {
				g.setColor(new Color(255, 0, 0, dmgcircle.fade));
				g2.setStroke(new BasicStroke(25));
				g.drawArc(dmgcircle.x, dmgcircle.y,dmgcircle.width, dmgcircle.height, 0, 360);
			}
			//Player square
			g.setColor(Color.blue);
			g.fillRect(player.x, player.y, player.width, player.height);
			
			//player HP graphics
			g.setColor(new Color(13, 18, 31, 180));
			if (playerHP <= 3) {
				g.fillRect((player.x+player.width/2)+1, player.y+player.width/2, player.width-player.width/2-1, player.height-player.height/2);
			}
			if (playerHP <= 2) {
				g.fillRect(player.x, player.y+player.width/2, player.width-player.width/2, player.height-player.height/2);
			}
			if (playerHP <= 1) {
				g.fillRect((player.x+player.width/2)+1, player.y, player.width-player.width/2-1, player.height-player.height/2-1);
			}
			if (playerHP == 0){
				g.fillRect(player.x, player.y-1, player.width-player.width/2, player.height-player.height/2);
				for (int i = 0; i<enemyL.length; i++) {
					enemyL[i] = new EnemyObjectLogic("Rectangle",true, 0,0,1,1,0,1,false,false,0,false,false);
				}
				dashMulti = 0;
				player.x = panW/2;
				player.y = panH/2;
				Mortals.stop();
			}
		}
	} 
	
	class MyKL implements KeyListener {
		private boolean[] keys = new boolean[256];

		boolean isKeyDown(int n) {
			return keys[n];
		}
		@Override
		public void keyPressed(KeyEvent e) {
			keys[e.getKeyCode()] = true;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			keys[e.getKeyCode()] = false;
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		} 
	}
	void checkOverlap() {
		for(int i = 0; i<enemy.length;i++) {
			if (player.intersects(enemy[i])) {
				if (enemyL[i].active) {
					if (!playerInv) {
						playerHP--;
						dmgcircle = new DashCircle(player.x+(player.width/2),player.y+(player.height/2),0);
						playerInv = true;
						dmgCircleA = true;
					}
				}
			}
		}
	}
	int invTimer = 0;
	class MyTimer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tick > 5750 && levelName.equals("Mortals")) {
				if (audioFade<76) {
					audioFade += 0.2;
				}
				if (audioFade > 56) {
					Mortals.stop();
				}
				FloatControl gainControl = (FloatControl) Mortals.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue((float) -audioFade);
			}
			for(int i = 0; i < enemyL.length; i++) {
				if (tick == enemyL[i].timeStart-50) {
					if (enemyL[i].indicator) {
						enemyL[i].indiActive = true;
					}
				}
				if (tick>enemyL[i].timeStart && tick<enemyL[i].timeEnd) {
					enemyL[i].active = true;
					enemyL[i].indiActive = false;
				}
				else {
					enemyL[i].active = false;
				}
				if (enemyL[i].moveX) {
					if(enemyL[i].active) {
						enemyL[i].x1 += enemyL[i].moveSpeed;
						enemy[i].x += enemyL[i].moveSpeed;
					}
				}
				if (enemyL[i].moveY) {
					if(enemyL[i].active) {
						enemyL[i].y1 += enemyL[i].moveSpeed;
						enemy[i].y += enemyL[i].moveSpeed;
					}
				}
			}
			if (playerInv && invTimer==0) {
				if (playerDashInv) {
					invTimer = tick+15;
				}
				else {
					invTimer = tick+100;
				}
			}
			if (tick>invTimer) {
				playerDashInv = false;
				playerInv = false;
				invTimer = 0;
			}
			if (dashCircleA) {
				circle.radius = circle.increase;
				circle.recalc();
				circle.increase();
			}
			if (dmgCircleA) {
				dmgcircle.radius = dmgcircle.increase;
				dmgcircle.recalc();
				dmgcircle.increase();
			}
			if (mainKL.isKeyDown(' ') && dash) {
				newCX = player.x;
				newCY = player.y;
				circle = new DashCircle(newCX+(player.width/2),newCY+(player.height/2),0);
				dash = false;
				dashCircleA = true;
				if (activeD == 0) {
					activeD = tick+5;
				}
				if (tick<activeD) {
					dashMulti = 5;
					playerInv = true;
					playerDashInv = true;
				}
				cooldown = activeD+20;
			}
			if (tick>activeD&& playerHP !=0) {
				dashMulti = 1;
				activeD = 0;
			}
			if (tick>cooldown) {
				dash = true;
			}
			if (mainKL.isKeyDown('W') && player.y > 0)player.y-=(6*dashMulti);
			if (mainKL.isKeyDown('A') && player.x > 0)player.x-=(6*dashMulti);
			if (mainKL.isKeyDown('S') && player.y + player.height < panH)player.y+=(6*dashMulti);
			if (mainKL.isKeyDown('D') && player.x + player.width < panW)player.x+=(6*dashMulti);	
  			panel.repaint();
 			checkOverlap();
			tick++;
		}
	}
}

