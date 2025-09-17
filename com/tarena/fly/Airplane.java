// package com.tarena.fly;

// import java.util.Random;

// public class Airplane extends FlyingObject implements Enemy {
// 	 private int speed = 3;   //移動步驟
	
// 	/* 初始化資料 */
// 	public Airplane(){
// 		this.image = ShootGame.airplane;
// 		width = image.getWidth();
// 		height = image.getHeight();
// 		y = -height;          
// 		Random rand = new Random();
// 		x = rand.nextInt(ShootGame.WIDTH - width);
// 	}
// 	/*加速
// 	public void speedup(){
// 		speed = 5;
// 	}*/
// 	/** 獲取分數 */
// 	@Override
// 	public int getScore() {  
// 		return 5;
// 	}

// 	/*越界處理 */
// 	@Override
// 	public 	boolean outOfBounds() {   
// 		return y>ShootGame.HEIGHT;
// 	}

// 	/** 移動 */
// 	@Override
// 	public void step() {   
// 		y += speed;
// 	}
// }
package com.tarena.fly;

import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
    private int speed = 3;   // 基礎速度

    public Airplane(){
        this.image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
    }
	/* 獲取分數 */
    @Override
    public int getScore() {
        return 5;
    }
	/*越界處理 */
    @Override
    public boolean outOfBounds() {
        return y > ShootGame.HEIGHT;
    }
	/*移動 */
    @Override
    public void step() {
        int dy = Math.max(1, (int)Math.round(speed * ShootGame.enemySpeedMultiplier));
        y += dy;

        // 小機率衝刺（增加不可預期性）
        if (y > 60 && new Random().nextInt(1000) < 8) {
            y += Math.max(2, (int)Math.round(2 * ShootGame.enemySpeedMultiplier));
        }
    }
}


