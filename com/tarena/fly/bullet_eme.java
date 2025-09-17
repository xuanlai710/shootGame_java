package com.tarena.fly;
// 敵人子彈
public class EnemyBullet extends FlyingObject {
    private int speed = 3; // 敵人子彈速度

    /** 初始化資料 */
    public EnemyBullet(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ShootGame.enemyBullet; // 使用另一張圖
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    /** 移動 (往下飛) */
    @Override
    public void step() {
        y += speed;
    }

    /** 越界判斷 */
    @Override
    public boolean outOfBounds() {
        return y > ShootGame.HEIGHT;
    }
}