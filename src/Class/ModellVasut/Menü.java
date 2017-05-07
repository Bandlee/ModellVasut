package Class.ModellVasut;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Menüt megvalósító osztály.
 */
public class Menü implements IMegjeleníthetõ, IKattintható {
	/** Ezen a szinten fogja elindítani a játékot a menü indításkor */
	private int szint;

	/** Ezzel a sebességgel fogja elindítani a játékot a menü indításkor */
	private int sebesség;

	/** Menü képét befoglaló téglalap */
	private Rectangle rect;

	/** Kiírandó üzenet */
	private String msg;

	/** A menü képe */
	private BufferedImage bimg;

	/** Controller, aminek üzen a menü, ha szükséges */
	private Controller ctrl;


	/**
	 * Konstruktor menü létrehozására.
	 * A megadott szöveg lesz kiírva a bal felsõ sarokba.
	 * @param message kiírandó üzenet.
	 * @param _ctrl Controller, ami létrehozta a menüt
	 */
	Menü(String message, Controller _ctrl){
		ctrl = _ctrl;
		msg = message;
		szint = 1;
		sebesség = 1;
        bimg = Ikonok.getIkon("menubuttons.png");

		int x = 250;
		int y = 100;
		int w = 600;
		int h = 600;
		rect= new Rectangle(x,y,w,h);
	}

	/**
	 * Menü kirajzolása a képernyõre
	 * @param g objektum amivel kirajzolunk a képernyõre.
	 */
	@Override
	public void rajzol(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		/** font beállítása */
		Font font = new Font("Sans", Font.PLAIN, rect.height/10);
		g2d.setFont(font);

		/** üzenet kirajzolása */
		g2d.drawString(msg, 0, 50);


		g2d.drawImage(bimg,rect.x,rect.y,rect.width,rect.height,null);

		/** változtatható értékek helyének meghatározása*/
		int x12 = rect.x+rect.width*5/8;
		int y1 = (int) (rect.y+rect.height*1.67/4);
		int y2 = (int) (rect.y+rect.height*2.67/4);

		/** változtatható értékek kirajzolása*/
		g2d.drawString(szint+".", x12, y1);
		g2d.drawString(sebesség+"X", x12, y2);
		
	}

	/**
	 * Függvény megnézi, hogy a kattintás a menübe történt-e, ha igen pontosan hova,
	 * majd aszerint végzi a következõ müveletet.
	 * @param e kattintást leíró érték
	 * @return kattintás okozott-e változást
	 */
	@Override
	public boolean voltKattintva(MouseEvent e){
		
		/** Menün belül esett-e a kattintás*/
		if (rect.contains(e.getPoint())){
			/** Indítás - játék elindítása */
			if (e.getY()<rect.y+rect.height/4){
				try {
					PályaGeneráló.getInstance().kezdés(szint,sebesség,ctrl);
				} catch (IOException e1) {
					msg = szint + ". pálya nem található :(";
				}
			}
			/** Szint: - játék szintjének növelése */
			else if (e.getY()<rect.y+rect.height*2/4){
				if (szint <5) szint++;
				else szint = 1;
			}
			/** Sebesség: - játék sebességének növelése */
			else if (e.getY()<rect.y+rect.height*3/4){
				if (sebesség <4) sebesség++;
				else sebesség = 1;
			}
			/** Kilépés - kilépés a põrogramból */
			else ctrl.kilépés();
			return true;
		}
		return false;
	}
}
