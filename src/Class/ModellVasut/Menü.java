package Class.ModellVasut;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menü implements IMegjeleníthetõ, IKattintható {
	private int szint=1;
	private int sebesség=1;
	Rectangle rect;
	String msg;
	BufferedImage bimg;
	Menü(String message){
		msg = message;
		try {
			bimg = ImageIO.read(new File("Ikonok/menubuttons.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int x = 250;
		int y = 100;
		int w = 600;
		int h = 600;
		rect= new Rectangle(x,y,w,h);
		
		
	}
	
	public void rajzol(Graphics g){
		Graphics2D g2d = (Graphics2D) g;

		
		Font font = new Font("Sans", Font.PLAIN, rect.height/10);
		g2d.setFont(font);

		g2d.drawString(msg, 0, 50);
		//g2d.drawImage(bimg,x,y,w,h,null);
		g2d.drawImage(bimg,rect.x,rect.y,rect.width,rect.height,null);
		//MAGICAL GRAPHIC PLACEMENT
		//x+w*5/8                     y+(i*h*(0.67+i(sor)))

		int x12 = rect.x+rect.width*5/8;
		int y1 = (int) (rect.y+rect.height*1.67/4);
		int y2 = (int) (rect.y+rect.height*2.67/4);


		g2d.drawString(szint+".", x12, y1);
		g2d.drawString(sebesség+"X", x12, y2);
		
	}
	
	public boolean voltKattintva(MouseEvent e){
		
		
		if (rect.contains(e.getPoint())){
			if (e.getY()<rect.y+rect.height/4){
				//kezdés
			}
			else if (e.getY()<rect.y+rect.height*2/4){
				if (szint <5) szint++;
				else szint = 1;
			}
			else if (e.getY()<rect.y+rect.height*3/4){
				if (sebesség <4) sebesség++;
				else sebesség = 1;
			}
			
			return true;
		}	
		return false;
	}
	
	
}
