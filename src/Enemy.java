public class Enemy {

    int health = 100;
    int damage;

    public Enemy(int health, int damage){
        this.health = health;
        this.damage = damage;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
