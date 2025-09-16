package com.tarena.fly;
import java.awt.image.BufferedImage;

/** 
 * 英雄機:是飛行物  
 */
public class Hero extends FlyingObject{
	
	private BufferedImage[] images = {};  //英雄機圖片
	private int index = 0;                //英雄機圖片切換索引
	
	private int doubleFire; //火力增倍
	private int life;   //命
	private int time = 0;
	

	/** 初始化資料 */
	public Hero(){
		life = 3;   //初始3條命
		doubleFire = 0;   //初始火力為0 
		images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1}; //英雄機圖片陣列 
		image = ShootGame.hero0;   //初始為hero0圖片
		width = image.getWidth();
		height = image.getHeight();
		x = 150;
		y = 400;
	}
	
	/** 獲取雙倍火力 */
	public int isDoubleFire() {
		return doubleFire;
	}

	/** 設定雙倍火力 */
	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}
	
	/** 增加火力 */
	public void addDoubleFire(){
		if(doubleFire == 0)
			doubleFire = 40;
		else if(doubleFire == 40)
			doubleFire = 60;
		else{
			addLife();
			++time;
			if(time > 2)
				doubleFire = 40;
		}
			
	}
	
	/** 增命 */ 
	public void addLife(){  
		if(life<10)
			life++;
	}
	
	/** 減命 */ 
	public void subtractLife(){  
		life--;
	}
	
	/** 獲取命 */
	public int getLife(){
		return life;
	}
	
	/** 當前物體移動了一下，相對距離，x,y滑鼠位置  */
	public void moveTo(int x,int y){   
		this.x = x - width/2;
		this.y = y - height/2;
	}

	/* 越界處理 */
	@Override
	public boolean outOfBounds() {
		return false;  
	}

	 /** 發射子彈 */ 
	public Bullet[] shoot(){   
		int xStep = width/4;      ///4半 
		int yStep = 20; //步
		if(doubleFire==40){  //雙倍火力 
			Bullet[] bullets = new Bullet[2];
			bullets[0] = new Bullet(x+xStep,y-yStep);  //y-yStep(子彈距飛機的位置)
			bullets[1] = new Bullet(x+3*xStep,y-yStep);
			//bullets[2] = new Bullet(x+2*xStep,y-yStep);
			return bullets;
		}
		else if(doubleFire == 60){ // 增加3倍火力
			Bullet[] bullets = new Bullet[3];
			bullets[0] = new Bullet(x,y-yStep);  //y-yStep(子彈距飛機的位置)
			bullets[1] = new Bullet(x+4*xStep,y-yStep);
			bullets[2] = new Bullet(x+2*xStep,y-yStep);
			return bullets;
		}
		else{      //單倍火力
			Bullet[] bullets = new Bullet[1];
			bullets[0] = new Bullet(x+2*xStep,y-yStep);  
			return bullets;
		}
	}

	/** 移動 */
	@Override
	public void step() {
		if(images.length>0){
			image = images[index++/10%images.length];   //切換圖片hero0，hero1
		}
	}
	
	/** 碰撞演算法 */
	public boolean hit(FlyingObject other){
		
		int x1 = other.x - this.width/2;                 //x座標最小距離
		int x2 = other.x + this.width/2 + other.width;   //x座標最大距離
		int y1 = other.y - this.height/2;                //y座標最小距離
		int y2 = other.y + this.height/2 + other.height; //y座標最大距離
	
		int herox = this.x + this.width/2;               //英雄機x座標中心點距離
		int heroy = this.y + this.height/2;              //英雄機y座標中心點距離
		
		return herox>x1 && herox<x2 && heroy>y1 && heroy<y2;   //區間範圍內為撞上了
	}
	
}










