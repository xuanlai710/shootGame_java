package com.tarena.fly;

/** 
 * 子彈類:是飛行物 
 */  
public class Bullet extends FlyingObject {
	private int speed = 2;  //移動的速度 
	
	/** 初始化資料 */
	public Bullet(int x,int y){
		this.x = x;
		this.y = y;
		this.image = ShootGame.bullet;
	}
	
	/** 移動 */ 
	@Override
	public void step(){   
		y-=speed;
	}

	/** 越界處理 */
	@Override
	public boolean outOfBounds() {
		return y<-height;
	}

}
