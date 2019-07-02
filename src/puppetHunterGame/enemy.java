
package puppetHunterGame;
public class enemy extends unit{ //ENEMY CLASS
//int health; String name,equipment;
    
    public void gethit (int r , String wp1, String wp2){
        int dmg = r;
        
        if ("Knuckleduster".equals(wp1))
            dmg = dmg + 1;
        else if ("Sword".equals(wp1)) 
            dmg = dmg + 5;
    
        if ("Knuckleduster".equals(wp2))
            dmg = dmg + 1;
        else if ( "Sword".equals(wp2))
            dmg = dmg + 5;
    
        if (armor == true){ //With armor
            if (r<= 1)
                System.out.println("Miss!");
            else if (r>1 && r<=9){
                health = health - (dmg/2) ;
                System.out.println("You dealed "+dmg/2+" damage!");
            }
            else if (r==10){
                health = health - (dmg*2/2) ;
                System.out.println("You dealed "+dmg/2+" damage!");
            }
        } 
        else { //Without armor
            if (r<= 1)
                System.out.println("Miss!");
            else if (r>1 && r<=9){
                health = health - dmg ;
                System.out.println("You dealed "+dmg+" damage!");
            }
            else if (r==10){
                health = health - dmg*2 ;
                System.out.println("You dealed "+dmg+" damage!");
            }   
        }
    } // rand number: 1:miss 1-9:hit 10:critical
     
    enemy (String n, int exp ,String wp1,String wp2, boolean ar){ // enemy constructor
        this.name =n;
        this.experience = exp;
        this.weapon1 = wp1 ; this.weapon2 = wp2;
        this.armor = ar;
    } 
}
