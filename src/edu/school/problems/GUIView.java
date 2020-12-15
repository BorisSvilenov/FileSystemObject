package edu.school.problems;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JComponent;

public class GUIView extends JComponent
{
	final int line1X=30;
	final int line1Y=80;
	final int line1Width=60;
	final int line1Height=80;
	final int line2X=30;
	final int line2Y=60;
	final int line2Width=30;
	final int line2Height=80;
	final int folderX=60;
	final int folderY=80;
	final int folderWidth=30;
	final int folderHeight=40;
	final int fileX=60;
	final int fileY=60;
	final int fileWidth=30;
	final int fileHeight=35;
	final int stringX=100;
	final int stringY=80;
	private Folder f;
	private int changer=0;
	
	public GUIView() {
		f=new Folder();
    }

	public GUIView(Folder f) {
		if(f!=null) {
		this.f=f;
		}
    }
	@Override
	public void paintComponent(Graphics graphics) 
	{
		super.paintComponent(graphics);
		Graphics2D g=(Graphics2D) graphics;
		g.setColor(Color.black);
		drawFolder(10,10,40,30,graphics);
		g.setColor(Color.black);
		
		
		FileSystemObject[] files=f.getFiles();
		for(int i=0;i<files.length;i++) {
			if(files[i]!=null) {
				if(files[i].getClass().equals(Folder.class)) {
					g.setColor(Color.black);
					g.drawLine(line1X, line1Y+changer,line1Width, line1Height+changer);
					g.drawLine(line2X,line2X+changer, line2Width,line2Height+changer);
					g.drawString(files[i].getName(), stringX, stringY+changer);
					drawFolder(folderX,folderY+changer,folderWidth,folderHeight,graphics);
				}
				if(files[i].getClass().equals(File.class)) {
					g.setColor(Color.black);
					g.drawLine(line1X, line1Y+changer,line1Width, line1Height+changer);
					g.drawLine(line2X,line2X+changer, line2Width,line2Height+changer);
					g.drawString(files[i].getName(), stringX, stringY+changer);
					drawFile(fileX,fileY+changer,fileWidth,fileHeight,graphics);
				}
				changer+=40;
			}
			
		}
		
		
		
	}
	public void drawFile(int x, int y,int width,int height,Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g=(Graphics2D) graphics;
		g.setColor(Color.BLACK);
		g.fill(new Rectangle2D.Double(x,y,width,height));
		g.draw(new Rectangle2D.Double(x,y,width,height));
		
	}
	public void drawFolder(int x, int y,int width,int height,Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g=(Graphics2D) graphics;
		g.setColor(Color.YELLOW);
		g.fill(new Rectangle2D.Double(x,y,width,height));
		g.draw(new Rectangle2D.Double(x,y,width,height));
	
	}
	
	

}
