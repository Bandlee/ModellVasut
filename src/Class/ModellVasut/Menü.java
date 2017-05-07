package Class.ModellVasut;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Men�t megval�s�t� oszt�ly.
 */
public class Men� implements IMegjelen�thet�, IKattinthat� {
	/** Ezen a szinten fogja elind�tani a j�t�kot a men� ind�t�skor */
	private int szint;

	/** Ezzel a sebess�ggel fogja elind�tani a j�t�kot a men� ind�t�skor */
	private int sebess�g;

	/** Men� k�p�t befoglal� t�glalap */
	private Rectangle rect;

	/** Ki�rand� �zenet */
	private String msg;

	/** A men� k�pe */
	private BufferedImage bimg;

	/** Controller, aminek �zen a men�, ha sz�ks�ges */
	private Controller ctrl;


	/**
	 * Konstruktor men� l�trehoz�s�ra.
	 * A megadott sz�veg lesz ki�rva a bal fels� sarokba.
	 * @param message ki�rand� �zenet.
	 * @param _ctrl Controller, ami l�trehozta a men�t
	 */
	Men�(String message, Controller _ctrl){
		ctrl = _ctrl;
		msg = message;
		szint = 1;
		sebess�g = 1;
        bimg = Ikonok.getIkon("menubuttons.png");

		int x = 250;
		int y = 100;
		int w = 600;
		int h = 600;
		rect= new Rectangle(x,y,w,h);
	}

	/**
	 * Men� kirajzol�sa a k�perny�re
	 * @param g objektum amivel kirajzolunk a k�perny�re.
	 */
	@Override
	public void rajzol(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		/** font be�ll�t�sa */
		Font font = new Font("Sans", Font.PLAIN, rect.height/10);
		g2d.setFont(font);

		/** �zenet kirajzol�sa */
		g2d.drawString(msg, 0, 50);


		g2d.drawImage(bimg,rect.x,rect.y,rect.width,rect.height,null);

		/** v�ltoztathat� �rt�kek hely�nek meghat�roz�sa*/
		int x12 = rect.x+rect.width*5/8;
		int y1 = (int) (rect.y+rect.height*1.67/4);
		int y2 = (int) (rect.y+rect.height*2.67/4);

		/** v�ltoztathat� �rt�kek kirajzol�sa*/
		g2d.drawString(szint+".", x12, y1);
		g2d.drawString(sebess�g+"X", x12, y2);
		
	}

	/**
	 * F�ggv�ny megn�zi, hogy a kattint�s a men�be t�rt�nt-e, ha igen pontosan hova,
	 * majd aszerint v�gzi a k�vetkez� m�veletet.
	 * @param e kattint�st le�r� �rt�k
	 * @return kattint�s okozott-e v�ltoz�st
	 */
	@Override
	public boolean voltKattintva(MouseEvent e){
		
		/** Men�n bel�l esett-e a kattint�s*/
		if (rect.contains(e.getPoint())){
			/** Ind�t�s - j�t�k elind�t�sa */
			if (e.getY()<rect.y+rect.height/4){
				try {
					P�lyaGener�l�.getInstance().kezd�s(szint,sebess�g,ctrl);
				} catch (IOException e1) {
					msg = szint + ". p�lya nem tal�lhat� :(";
				}
			}
			/** Szint: - j�t�k szintj�nek n�vel�se */
			else if (e.getY()<rect.y+rect.height*2/4){
				if (szint <5) szint++;
				else szint = 1;
			}
			/** Sebess�g: - j�t�k sebess�g�nek n�vel�se */
			else if (e.getY()<rect.y+rect.height*3/4){
				if (sebess�g <4) sebess�g++;
				else sebess�g = 1;
			}
			/** Kil�p�s - kil�p�s a p�rogramb�l */
			else ctrl.kil�p�s();
			return true;
		}
		return false;
	}
}
