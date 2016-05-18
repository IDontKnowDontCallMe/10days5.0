package panels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import gamebutton.JButtonMinus;
import gamebutton.JButtonPlus;
import system.GameFrame;

public class JPanelSetting extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static int length = 10;
	private static int maxturns = 60;
	private static int maxpower = 7;
	private static int rebirthperiods = 12;
	private GameFrame gameFrame;
	ImageIcon icon = new ImageIcon("返回_平时.png");

	Image background = new ImageIcon("设置-2.png").getImage();
	private MouseListener BackMouseListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			gameFrame.getContentPane().removeAll();
			gameFrame.setContentPane(gameFrame.getJPanelHome());
			
		}
	};
	public JPanelSetting(GameFrame gf) {
		gameFrame = gf;
		this.setVisible(true);
		this.setBounds(0, 0, 1366, 768);
		this.setLayout(null);
		
		JButton BackToHome = new JButton(icon);
		BackToHome.addMouseListener(BackMouseListener);
		BackToHome.setBounds(1100, 50, 200, 140);
		BackToHome.setBorder(null);
		this.add(BackToHome);
		
		JButtonPlus LengthPlus = new JButtonPlus(gf,1);
		LengthPlus.setBounds(683, 273, 50, 50);
		this.add(LengthPlus);
		JButtonMinus LengthMinus = new JButtonMinus(gf, 1);
		LengthMinus.setBounds(990, 273, 50, 50);
		this.add(LengthMinus);
		JLabelSetLength l = new JLabelSetLength(gf, 50);
		l.setBounds(790, 273, 150, 50);
		add(l);
		
		JButtonPlus MaxPowerPlus = new JButtonPlus(gf, 2);
		MaxPowerPlus.setBounds(683, 390, 50, 50);
		this.add(MaxPowerPlus);
		JButtonMinus MaxPowerMinus = new JButtonMinus(gf, 2);
		MaxPowerMinus.setBounds(990, 390, 50, 50);
		this.add(MaxPowerMinus);
		JLabelSetPower p = new JLabelSetPower(gf, 50);
		p.setBounds(790,390,150,50);
		add(p);
		
		JButtonPlus MaxTurnsPlus = new JButtonPlus(gf, 3);
		MaxTurnsPlus.setBounds(683, 502, 50, 50);
		this.add(MaxTurnsPlus);
		JButtonMinus MaxTurnsMinus = new JButtonMinus(gf, 3);
		MaxTurnsMinus.setBounds(990, 502, 50, 50);
		this.add(MaxTurnsMinus);
		JLabelSetTurns t = new JLabelSetTurns(gf, 50);
		t.setBounds(790, 502, 150, 50);
		add(t);
		
		JButtonPlus RebirthPeriodPlus = new JButtonPlus(gf, 4);
		RebirthPeriodPlus.setBounds(683, 619, 50, 50);
		this.add(RebirthPeriodPlus);
		JButtonMinus RebirthPeriodMinus = new JButtonMinus(gf, 4);
		RebirthPeriodMinus.setBounds(990, 619, 50, 50);
		this.add(RebirthPeriodMinus);
		JLabelSetRebirthPeriod r = new JLabelSetRebirthPeriod(gf, 50);
		r.setBounds(790, 619, 150, 50);
		add(r);
		
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,1366,768, null);
	}
	

	
	public int getLength() {
		return length;
	}
	public int getMaxTurns() {
		return maxturns;
	}
	public int getMaxPower() {
		return maxpower;
	}
	public int getRebirthPeriod() {
		return rebirthperiods;
	}
	public void setlength(String string) {
		if (string=="+") {
			length = length+1;
		}else {
			length = length - 1;
		}
	}
	public void setMaxPower(String string) {
		if (string=="+") {
			maxpower = maxpower + 1;
		}else {
			maxpower = maxpower - 1;
		}
	}
	public void setMaxTurns(String string) {
		if (string=="+") {
			maxturns = maxturns + 12;
		}else {
			maxturns = maxturns - 12;
		}
	}
	public void setRebirthPeriod(String string) {
		if (string=="+") {
			rebirthperiods = rebirthperiods + 1;
		}else {
			rebirthperiods = rebirthperiods - 1;
		}
	}

}
