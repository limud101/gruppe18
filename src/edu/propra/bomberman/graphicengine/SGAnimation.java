/**
 * 
 */
package edu.propra.bomberman.graphicengine;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 * @author Nadescha
 *
 */
public class SGAnimation extends SGLeaf {

	private  BufferedImage[] images;
	private  long aniTime;
	private boolean repeat;
	
	
//Hilfsvariable 
	private  long startTime;
    private  double imagesPerSecond;
    
	
	
	

	
	/**
	 * 
	 */
	public SGAnimation(BufferedImage[] images ,long aniTime) {
		this.startTime=0;
		
		this.images = images;
		this.aniTime = aniTime;
		this.imagesPerSecond = this.images.length/(this.aniTime);
		this.repeat = false;	
		
	}
	
	
	
	public void  start() {
		startTime = System.currentTimeMillis();	
		
	}
	public void stop(){
		startTime = 0;
	}
	/* (non-Javadoc)
	 * @see edu.propra.bomberman.graphicengine.SGLeaf#paint(java.awt.geom.AffineTransform, java.awt.Graphics2D)
	 */
	@Override
	public void paint(AffineTransform transform, Graphics2D g2d) {
		int index;
		
		if (startTime >0 ){
			long duration = System.currentTimeMillis()- startTime;	
			if (duration > aniTime){
				if(repeat){
					duration=duration%aniTime;
				}else{
					stop();
					duration=0;
				}
			}
			index = (int)(((double)duration) * imagesPerSecond);
		}else{
			index = 0;
		}
		g2d.drawImage((Image)images[index], transform, null);
		
		
	}
	
	

}
