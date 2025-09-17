package com.tarena.fly;

import java.util.Random;

/** 蜜蜂 */
public class Bee extends FlyingObject implements Award{
	private int xSpeed = 2;   ///x座標移動速度 
	private int ySpeed = 2;   //y座標移動速度
	private int awardType;    //獎勵型別
	
	/** 初始化資料 */
	public Bee(){
		this.image = ShootGame.bee;
		width = image.getWidth();
		height = image.getHeight();
		y = -height;
		Random rand = new Random();
		x = rand.nextInt(ShootGame.WIDTH - width);
		awardType = rand.nextInt(2);   ///初始化時給獎勵
	}
	
	/* 獲得獎勵型別 */
	public int getType(){
		return awardType;
	}

	/* 越界處理 */
	@Override
	public boolean outOfBounds() {
		return y>ShootGame.HEIGHT;
	}

	// /* 移動，可斜著飛 */
	// @Override
	// public void step() {      
	// 	x -= xSpeed;
	// 	y += ySpeed;
	// 	if(x > ShootGame.WIDTH-width){  
	// 		xSpeed = 2;
	// 	}
	// 	if(x < 0){
	// 		xSpeed = -3;
	// 	}
	// }
	@Override
    public void step() {
        int xs = (int)Math.round(xSpeed * ShootGame.enemySpeedMultiplier);
        int ys = (int)Math.round(ySpeed * ShootGame.enemySpeedMultiplier);
        if (xs == 0) xs = xSpeed < 0 ? -1 : 1;
        if (ys == 0) ys = 1;

        x -= xs;
        y += ys;

        if (x > ShootGame.WIDTH - width) {
            xSpeed = Math.abs(xSpeed);
        }
        if (x < 0) {
            xSpeed = -Math.abs(xSpeed);
        }
	}
}