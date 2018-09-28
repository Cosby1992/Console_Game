import java.util.Scanner;

public class MainGame {

    public static void main(String[] args) {
// Initialize Scanner
        Scanner scan = new Scanner(System.in);
// Player name statement
        System.out.println("\nWelcome Sir.. What should i call you?\n" +
                "Enter your name here: ");
// Define player and player name
        Player player = new Player(100, 0, 100, 2, scan.nextLine());

// Deciding to help Dublin (yes or no)
        System.out.println("\nNice to meet you " + player.playerName + ".");

        System.out.println("My name is Dublin, i could really use your help!\n" +
                "Will you please help me? (yes or no)");
// While key Dublin
        boolean helpDublin = false;
// Helping Dublin (While loop)
        while (player.respect > 0 && player.health > 0 && helpDublin == false) {
            //help Dublin (yes or no)
            String answerDublinHelp = scan.nextLine();
            // if help dublin = no = -10 respect
            if (answerDublinHelp.equalsIgnoreCase("no")) {
                player.setRespect(player.respect - 25);
                System.out.println("You disappointing Dublin caused your respect to decrease by 25.\n" +
                        "Your respect is now " + player.getRespect() + ". Don't let it drop to zero!\n");
                helpDublin = true;
            }
            //if help dublin = yes = initialize enemy + first enemy attack
            else if (answerDublinHelp.equalsIgnoreCase("yes")) {
                System.out.println("Oh thank you " + player.getPlayerName() + ".\n" +
                        "I have a monster in my basement! It's too strong and scary\n " +
                        "for me to fight, I need you to take him down for me!\n" +
                        "\nYou go to the basement and the monster quickly attacks you!");
                //initialize enemy (basementMonster) + random attack
                Enemy basementMonster = new Enemy(50, (int) (Math.random() * 9) + 1);
                //player take damage
                player.setHealth(player.health - basementMonster.getDamage());
                //Initial monster attack
                System.out.println("The monster hits you with an attack of " + basementMonster.getDamage() + "\n" +
                        "Your health is now " + player.getHealth());
                //initialize battle loop
                boolean battleKeyBasementmonster = true;

                while (player.respect > 0 && player.health > 0 && basementMonster.getHealth() > 0 && battleKeyBasementmonster == true) {
//Battle choice
                    System.out.println("Press 'Enter' to attack, or press 'P' to use a health potion \n" +
                            "(you currently have " + player.getHealthPotion() + " health potions)");
                    String battlekey = scan.nextLine();


                    if (battlekey.equalsIgnoreCase("") && basementMonster.getHealth() > 0) {

                        player.setDamage((int) ((Math.random() * 19) + 6));
                        basementMonster.setHealth(basementMonster.health - player.getDamage());

                        System.out.println("You attack with " + player.getDamage() + " damage.\n" +
                                "The Monster's health is now " + basementMonster.getHealth() + "\n");
                        if (basementMonster.getHealth() > 0) {
                            basementMonster.setDamage((int) (Math.random() * 9) + 1);
                            player.setHealth(player.health - basementMonster.getDamage());
                            System.out.println("The monster hits you with an attack of " + basementMonster.getDamage() + "\n" +
                                    "Your health is now " + player.getHealth() + "\n");

                        }
                    } else if (battlekey.equalsIgnoreCase("p")) {
                        if (player.getHealthPotion() >= 1) {
                            player.setHealthPotion(player.getHealthPotion() - 1);
                            if (player.getHealth() < 75) {
                                player.setHealth(player.getHealth() + 25);
                                System.out.println("Your health is now " + player.getHealth());
                            } else if (player.getHealth() >= 75) {
                                player.setHealth(100);
                                System.out.println("You now have full health! (" + player.getHealth() + ")");
                            }
                        } else if (player.getHealthPotion() < 1) {
                            System.out.println("You don't have enough health potions!");
                        }


                    } else {
                        System.out.println("Invalid input, try again.");
                    }


                    if (basementMonster.getHealth() <= 0) {
                        System.out.println("You did it! You killed my basement Monster!\n" +
                                "I am forever in you debt " + player.getPlayerName() + "\n" +
                                "All i can give you is this health potion, use it with care!\n");
                        player.setHealthPotion(player.getHealthPotion() + 1);
                        player.setRespect(player.getRespect() + 10);
                        System.out.println("Your health potion increased to " + player.getHealthPotion() + "\n" +
                                "And your respect increased to " + player.getRespect());

                        helpDublin = true;
                    }
                }

            } else {
                System.out.println("Sorry, I think I might have misheard you. Can you please repeat your answer?");
            }

        }

        System.out.println("You follow the road to the city of Tannum");

        boolean helpCityOfTannum = false;

        while (player.respect > 0 && player.health > 0 && helpCityOfTannum == false) {
            System.out.println("You are now in the city of Tannum");

            helpCityOfTannum = true;
        }


        if (player.respect > 0 && player.health > 0) {
            System.out.println("Congratulations! You survived the journey!\n" +
                    "Your final stats are as follows:\n" +
                    "Health         = " + player.getHealth() + "\n" +
                    "Respect        = " + player.getRespect() + "\n" +
                    "Health potions = " + player.getHealthPotion() + "\n" +
                    "You are a true hero " + player.getPlayerName());
        } else if (player.respect <= 0) {
            System.out.println("You got killed by villagers, cause your respect went too low!!" +
                    "\nYou ended up with " + player.getRespect() + " respect..");
        } else if (player.health <= 0) {
            System.out.println("You died!! Your health got too low!!" + "\n" +
                    "You ended up with " + player.getHealth() + " health..");
        }

    }


}



