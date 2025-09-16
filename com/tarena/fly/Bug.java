package com.tarena.fly;
import java.util.Random;

public class Bug extends FlyingObject implements Enemy {
	 private int xSpeed = 4;   ///x座標移動速度 
     private int ySpeed = 3;   //y座標移動速度
	
	/* 初始化資料 */
	public Bug(){
		this.image = ShootGame.bug;
		width = image.getWidth();
		height = image.getHeight();
        Random rand = new Random();
		y =  rand.nextInt(-height,200); // [0,20);          
		//x = rand.nextInt(ShootGame.WIDTH - width);
        x = -5;
	}
	/** 獲取分數 */
	@Override
	public int getScore() {  
		return 10;
	}

	/*越界處理 */
	@Override
	public 	boolean outOfBounds() {   
		return y>ShootGame.HEIGHT;
	}

	/** 移動 */
	@Override
	public void step() {   
		x += xSpeed;
		y += ySpeed;

	}
}