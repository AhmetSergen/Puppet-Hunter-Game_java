package puppetHunterGame;
import java.util.Scanner; import java.util.Random;
/* @author Ahmet*/

public class Main {
public static void main(String[] args) { // ________________________________MAİN____________________________________________________________________
    
    Scanner input = new Scanner(System.in); 
    Random r = new Random(); 
    int rand;

    hero Hero = new hero(); Hero.health=100; Hero.armor = false; Hero.experience=0; Hero.weapon1="None"; Hero.weapon2="None"; Hero.alive=true;

    enemy Enemy1 = new enemy("Rookie Puppet " , 1 , "None" , "None", false); Enemy1.health=80;
    enemy Enemy2 = new enemy("Advanced Puppet" , 5 , "Knuckleduster", "None" ,true); Enemy2.health=100;
    enemy Enemy3 = new enemy("Master of the Puppets" , 25 , "Sword","Sword" ,true); Enemy3.health=110;
    
    System.out.println("Enter your hero's name : ");
    Hero.name = input.nextLine();
    
    System.out.println("\nWelcome to the arena,"+ Hero.name + "!\n"
    + "You have to beat your master to be free.But you should earn some experience and weapons or it will crush you! \n"
    + "Lets get to the work1"+"____________________________________________________________________________________________\n");

    boolean win = false; 

    while (Hero.health > 0 && win==false){// If healt is not 0 and game is not won yet, this wile loop continues
        //<editor-fold> 
        if (Hero.experience>= 2 && Hero.experience<5){ 
        Hero.weapon1="Knuckleduster"; 
        System.out.println("Youre now level : 2.\nYou get Knuckleduster.");
        }

        else if (Hero.experience>=5 && Hero.experience <10 ){ 
        Hero.armor= true; System.out.println("Youre now level : 3.\nYou get armor.");
        }
        else if (Hero.experience>= 10 && Hero.experience <20 ){ 
        Hero.weapon2="Sword"; System.out.println("Youre now level : 4.\nYou get a sword. You can use both weapons now.");
        }
        else if (Hero.experience>=20 ){ 
        Hero.weapon1="Sword"; System.out.println("Youre now at max level : 5.\nYou get a sword. You can use dual swords now.");
        }
        //</editor-fold> //Level up if statements  
    
        System.out.println("You have "+Hero.experience+" exp point.\n"
        +"___Select action:___________________________________________________________________________\n"
        +"1- Fight with a Rookie Puppet\n"
        +"2- Fight with a Advanced Puppet\n"
        +"3- Fight with Master of the Puppets\n____________________________________________________________________________________________ "); 
        int act = input.nextInt(); 
    
        switch(act){ // Choice selector start
            case 1: //Rookie Puppet
                System.out.println("Battle starts with Rookie Puppet. It has 90 HP, no weapon and armor.");
                while (Hero.health>0 && Enemy1.health>0){ //Battle borders
                    System.out.println("Its "+Hero.name+"'s turn\n"); 
                    rand = r.nextInt(11); 
                    Enemy1.gethit(rand, Hero.weapon1, Hero.weapon2);
                    if (Enemy1.health>0){ 
                        System.out.println("Its Rookie Puppet's turn\n");
                        rand = r.nextInt(11); Hero.gethit(rand , "None", "None"); 
                    }
                    System.out.println("_____End of raund_________________________\n"+"Your health : "+Hero.health+"\nEnemy health : "+Enemy1.health
                    +"\n__________________________________________"); 
                }
                    if (Hero.health>0){ 
                        System.out.println("You Won! Gained 1 exp."); 
                        Hero.experience++; Hero.health=100; Enemy1.health=80;
                    }
            break; 
        
            case 2: // Advanced Puppet
                System.out.println("Battle starts with Advanced Puppet. It has 100 HP, a knuckleduster and armor.");
                    while (Hero.health>0 && Enemy2.health>0){ //Battle borders
                        System.out.println("Its "+Hero.name+"'s turn\n"); rand = r.nextInt(11); Enemy2.gethit(rand, Hero.weapon1, Hero.weapon2);
                        if (Enemy2.health>0){ System.out.println("Its Advanced Puppet's turn\n");
                            rand = r.nextInt(11); Hero.gethit(rand , "Knuckleduster", "None"); 
                        }
                        System.out.println("_____End of raund_________________________\n"+"Your health : "+Hero.health+"\nEnemy health : "+Enemy2.health
                        +"\n__________________________________________");
                    }
                        if (Hero.health>0){ 
                            System.out.println("You Won! Gained 1 exp."); 
                            Hero.experience = Hero.experience + 5; Hero.health=100; Enemy2.health=100;
                        }
            break; 
        
            case 3: // Master of the Puppets
                System.out.println("Battle starts with Master of the Puppets. It has dual swords,armor and special attack.");
                    while (Hero.health>0 && Enemy3.health>0){ //Battle borders
                    System.out.println("Its "+Hero.name+"'s turn\n"); rand = r.nextInt(11); Enemy3.gethit(rand, Hero.weapon1, Hero.weapon2);
                        if (Enemy3.health>0){ 
                            System.out.println("Its Master's turn\n"); rand = r.nextInt(12); Hero.gethit(rand , "Sword", "Sword"); 
                        }
                        System.out.println("_____End of raund_________________________\n" +"Your health : "+Hero.health+"\nEnemy health : "+Enemy3.health
                        +"\n__________________________________________"); 
                    }
                    if (Hero.health>0){
                        System.out.println("You Won! Gained 1 exp."); Hero.experience = Hero.experience + 25; Hero.health=100; win = true;
                    } 
            break;
        } //Choise selector end
    }// Game over 
 
    if (win==true){ // If player won :
        System.out.println("Congratulation! You have defeated Master of the Puppets. Youre now free to go! :)"); System.exit(0); }
    else    
        System.out.println("Youre dead :("); System.exit(0); } }

