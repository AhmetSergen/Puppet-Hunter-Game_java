package puppetHunterGame;
/*@author Ahmet*/
public class hero extends unit{ //HERO CLASS
    boolean alive ;
 
    public void gethit (int r , String wp1 , String wp2){ //int health; int experience; String name,weapon1,weapon2; boolean armor;
        int dmg = r;
        if ("Knuckleduster".equals(wp1)) dmg = dmg + 1;
        else if ("Sword".equals(wp1)) dmg = dmg + 5;
        if ("Knuckleduster".equals(wp2)) dmg = dmg + 1;
        else if ("Sword".equals(wp2)) dmg = dmg + 5;
        if (armor == true){ 
            if (r<= 1) System.out.println("Miss!");
            else if (r>1 && r<=9){ health = health - (dmg/2) ; System.out.println("Dealed "+dmg/2+" damage to you!"); }
            else if (r==10){ health = health - (dmg*2/2) ; System.out.println("Dealed "+dmg/2+" to you!"); }
            else if (r==11){ health = health - (dmg*4)/2 ; System.out.println("Master used special ability!!! Dealed "+dmg+" to you!"); }
        } 
        else {
            if (r<= 1) System.out.println("Miss!");
            else if (r>1 && r<=9){ health = health - dmg ; System.out.println("Dealed "+dmg+" damage to you!"); }
            else if (r==10){ health = health - dmg*2 ; System.out.println("Dealed "+dmg+" to you!"); }
            else if (r==11){ health = health - dmg*4 ; System.out.println("Master used special ability!!! Dealed "+dmg+" to you!"); }
        }
    } //rand number: 1:miss 1-9:hit 10:critical 11:master special 
}
