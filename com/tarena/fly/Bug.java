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
		 // 從畫面上方隨機出現一點高度（避免全部從同一行）
        y = -height - rand.nextInt(150);
		// y =  rand.nextInt(-height,200); // [0,20);          
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
        int xs = Math.max(1, (int)Math.round(xSpeed * ShootGame.enemySpeedMultiplier));
        int ys = Math.max(1, (int)Math.round(ySpeed * ShootGame.enemySpeedMultiplier));
        x += xs;
        y += ys;
    }
}