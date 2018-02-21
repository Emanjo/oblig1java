import java.awt.Frame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class ScaleWindow extends Frame {
	private BufferedImage bilde;
	private int bildeHoyde = 0;
	private int bildeLengde = 0;

	public ScaleWindow() {
		setTitle("ScaleWindow");
		setSize(900,700);
		String bildeUrlString = "http://evalanche.hbv.no/oo/pics/26815574_835191906649288_7507950488720876851_n.jpg";
		
		try {
			URL bildeUrl = new URL(bildeUrlString);
			bilde = ImageIO.read(bildeUrl);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		bildeHoyde = bilde.getHeight();
		bildeLengde = bilde.getWidth();
		setVisible(true);
	}
	
	public void setBildeHoyde(int bildeHoyde) {
		this.bildeHoyde = bildeHoyde;
	}
	
	public void setBildeLengde(int bildeLengde) {
		this.bildeLengde = bildeLengde;
	}
	
	public int getBildeHoyde() {
		return bildeHoyde;
	}
	
	public int getBildeLengde() {
		return bildeLengde;
	}
	
	public void paint(Graphics g) {
		if (bilde != null) g.drawImage(bilde, 20, 20, bildeLengde, bildeHoyde, this);
	}

}
