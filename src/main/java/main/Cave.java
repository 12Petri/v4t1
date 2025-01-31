package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Cave implements Serializable {
    private static final long serialVersionUID = 65464020L;
    private ArrayList<Monster> monsters;
    public Player player;
    
    public Cave(Player player) {
        this.player = player;
        this.monsters = new ArrayList<>();
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public void listMonsters() {
        System.out.println("Luolan hirviöt:");
        for (int i = 0; i < monsters.size(); i++) {
            monsters.get(i).printInfo(i + 1);
        } 
    }

    public void hitMonster(int j) {
        Monster target = monsters.get(j);
        player.attack(target);
        if (target.healt <= 0) {
            monsters.remove(j);
        }
    }

    public void saveGame(String fileName) {
        try { ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(fileName));
            save.writeObject(this);
            save.close();
            System.out.println("peli tallennettu tiedostoon " + fileName);
        }
        catch (IOException e) {
            System.out.println("Pelin tallentaminen ei onnistu.");
            e.printStackTrace();
        }  
    }

    public static Cave loadGame(String fileName) {
        try { ObjectInputStream load = new ObjectInputStream(new  FileInputStream(fileName));
            final Cave loadedGame =  (Cave) load.readObject();
            load.close();
            return loadedGame;
        } 
        catch (Exception e) {
            System.out.println("Pelin lataaminen ei onnistu.");
            e.printStackTrace();
            return null;
        }
    }
}
