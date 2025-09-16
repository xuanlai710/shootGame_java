package com.tarena.fly;

import java.awt.image.BufferedImage;

/** 
 * 飛行物(敵機，蜜蜂，子彈，英雄機) 
 */
public abstract class FlyingObject {
	protected int x;    //x座標 
	protected int y;    //y座標 
	protected int width;    //寬
	protected int height;   //高
	protected BufferedImage image;   //圖片

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/** 
     * 檢查是否出界 
     * @return true 出界與否 
     */ 
	public abstract boolean outOfBounds();
	
	/** 
     * 飛行物移動一步 
     */  
	public abstract void step();
	
	/** 
     * 檢查當前飛行物體是否被子彈(x,y)擊(shoot)中 
     * @param Bullet 子彈物件 
     * @return true表示被擊中了 
     */  
	public boolean shootBy(Bullet bullet){
		int x = bullet.x;  //子彈橫座標
		int y = bullet.y;  //子彈縱座標
		return this.x<x && x<this.x+width && this.y<y && y<this.y+height;
	}

}
