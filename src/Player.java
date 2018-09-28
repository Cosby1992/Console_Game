public class Player {

    int health;
    int damage;
    String playerName;
    int respect;
    int healthPotion;

    public Player(int health, int damage, int respect, int healthPotion , String playerName) {
        this.health = health;
        this.damage = damage;
        this.respect = respect;
        this.healthPotion = healthPotion;
        this.playerName = playerName;
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

    public int getHealthPotion() {
        return healthPotion;
    }

    public void setHealthPotion(int healthPotion) {
        this.healthPotion = healthPotion;
    }

    public int getRespect(){
        return respect;
    }

    public void setRespect(int respect){
        this.respect = respect;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
