package edu.propra.bomberman.gameengine.objects;

import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import edu.propra.bomberman.collisionengine.CollisionObject;
import edu.propra.bomberman.gameengine.GameObject;
import edu.propra.bomberman.graphicengine.SGImage;
import edu.propra.bomberman.graphicengine.SGTransform;

public class FixedBlock extends GameObject {
	public static Area collisionArea=null;
	public static Area clipArea=null;
	public static BufferedImage image=null;

	public FixedBlock(int x,int y) {
		
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
		co.setCollisionArea(new Area(trans.createTransformedShape(FixedBlock.collisionArea)));
		co.setPrivot(this);
	
	}
	
	@Override
	public void collisionWith(Object a) {
		if(a instanceof FixedBlock ){
			System.out.println("Movement Collision between "+this.toString()+" and FixedBlock "+ a.toString());
		}else if(a instanceof Player){
			System.out.println("Movement Collision between "+this.toString()+" and Player "+ a.toString());		
		}
	}

	static{
		collisionArea=new Area(new Rectangle(0,0,40,40));
		clipArea=new Area(new Rectangle(0,0,40,40));
		try {
			image = ImageIO.read(new File("src/resources/festerblock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
