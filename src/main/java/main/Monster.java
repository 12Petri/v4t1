package main;

import java.io.Serializable;

public class Monster implements Serializable {
    private static final long serialVersionUID = 54345021L;
    String type;
    int healt;
    
    public Monster(String type, int healt) {
        this.type = type;
        this.healt = healt;
    }

    public void printInfo(int number) {
        System.out.println(number + ": " + type + " / " + healt + "HP");
    }

    public boolean takeDamage(int dmg) {
        healt = healt - dmg;
        if (healt > 0) {
            System.out.println("Hirviöllä on " + healt + " elämää jäljellä.");
            return true;
        }
        return false;
    }

}
