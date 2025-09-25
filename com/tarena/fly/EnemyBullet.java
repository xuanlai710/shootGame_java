package com.tarena.fly;
// 發射「敵方子彈」，敵方子彈會與英雄碰撞造成掉血
public class EnemyBullet extends FlyingObject {
    private int vx;
    private int vy;

    public EnemyBullet(int x, int y, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.image = ShootGame.bullet_eme;
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    @Override
    public boolean outOfBounds() {
        return y > ShootGame.HEIGHT || x < -width || x > ShootGame.WIDTH + width;
    }

    @Override
    public void step() {
        x += vx;
        y += vy;
    }
}