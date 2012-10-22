package Praktikum1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateToPNG
 */
public class DateToPNG extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String text=getTodaysDate();
	private int textsize = 16;
	private String fc = "#000000";
	private String bc = "#aaaaaa";
	private int h = 32;
    int w = 0;
    private String fontName = "Sans-serif";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage image = getImage();
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		ImageIO.write(image, "png", outputStream);
		outputStream.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	public BufferedImage getImage() {	
		BufferedImage image = null;
		Font font = new Font(fontName, Font.BOLD, textsize);
		if (w == 0)
		    w = (text.length()+2)*8;
		int textColor = 0;
		int imageColor = 0;
		try { 
	         if (fc.startsWith("#")) 
	        	 fc = fc.substring(1);
	         textColor = (int)(Long.parseLong(fc, 16) & 0x0fffffff);
	         if (bc.startsWith("#")) 
	        	 bc = bc.substring(1);
	         imageColor = (int)(Long.parseLong(bc, 16) & 0x0fffffff);
	    } catch (Exception excep) { 
	    	return null;
	    }
	    
		try {
			image = new BufferedImage(w, h,
					BufferedImage.TYPE_INT_RGB);
			for (int i=0;i<w;i++) {
				for (int j=0;j<h;j++) {
					image.setRGB(i,j,imageColor);
				}
			}
			Graphics2D g = image.createGraphics();
			// add text string
			Color c = new Color(textColor, (((textColor >> 24) & 0xff) != 0));
			g.setColor(c);		
			g.setFont(font);
			g.drawString(text, textsize / 2, (textsize * 5) / 4);
			g.dispose();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
		return image;
	}
	private String getTodaysDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd"); 
		String todaysDate = dateFormat.format(System.currentTimeMillis());
		return todaysDate;       } 
}
