package edu.propra.bomberman.gameengine.objects;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.propra.bomberman.collisionengine.CollisionObject;
import edu.propra.bomberman.graphicengine.SGImage;
import edu.propra.bomberman.graphicengine.SGTransform;

public class Wall extends GameObject {

	
	
	public static Area collisionArea=null;
	public static Area clipArea=null;
	public static BufferedImage image=null;

	public Wall(int x,int y) {
		
		AffineTransform trans=new AffineTransform();
		trans.setToTranslation(x, y);
		//Construct Graphics Subgraph for Player Object
		this.go=new SGTransform();
		((SGTransform)this.go).getTransform().setTransform(trans);
		SGImage leaf=new SGImage(image);
		leaf.setClipArea(clipArea);
		((SGTransform)this.go).setChild(leaf);
	
		//Construct Collision Object for Player Object
		this.co=new CollisionObject();
		co.setPrivot(this);
	
		this.absTransform=(AffineTransform) trans.clone();
	}
	
	@Override
	public void collisionWith(Object a) {
		if(a instanceof FixedBlock ){
			//System.out.println("Movement Collision between "+this.toString()+" and FixedBlock "+ a.toString());
		}else if(a instanceof Player){
			//System.out.println("Movement Collision between "+this.toString()+" and Player "+ a.toString());		
		}else{
			//System.out.println("Collision between "+this.toString()+" and "+ a.toString());			
		}
	}
	
	@Override
	public void initializeCollisions() {
		if(this.isAbsIntialized){
			this.co.setCollisionArea(collisionArea.createTransformedArea(this.absTransform));
			this.collisionsInitialized=true;
		}else{
			System.err.println("Wall.initializeCollisions()");
			System.err.println("  Absolute positions are not initialized");
		}
		
	}
	

	static{
		collisionArea=new Area(new Rectangle(0,0,800,600));
		collisionArea.subtract(new Area(new Rectangle(21,21,767,567)));
		clipArea=new Area(new Rectangle(0,0,800,600));
		clipArea.subtract(new Area(new Rectangle(21,21,767,567)));
		try {
			image = ImageIO.read(new File("src/resources/aussenwand.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
