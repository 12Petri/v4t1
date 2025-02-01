//Valikko rakenne pitkälti edellisistä tehtävistä.
//Muut kurssimateriaalin mukaan.

package main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Syötä pelaajan nimi:");
        Player player = new Player(sc.nextLine());
        Cave cave = new Cave(player);
    
        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää luolaan hirviö\r\n" + //
                                "2) Listaa hirviöt\r\n" + //
                                "3) Hyökkää hirviöön\r\n" + //
                                "4) Tallenna peli\r\n" + //
                                "5) Lataa peli\r\n" + //
                                "0) Lopeta peli");
    
    if(sc.hasNext()) {
            int i = 0;
            String stringInput = sc.nextLine();
            i = Integer.parseInt(stringInput);
                                
        switch (i) {
            case 1:
                System.out.println("Anna hirviön tyyppi:");
                String type = sc.nextLine();
                System.out.println("Anna hirviön elämän määrä numerona:");
                int hitpoints = sc.nextInt();
                sc.nextLine();
                cave.addMonster(new Monster(type, hitpoints));
                break;
            case 2:
                cave.listMonsters();
                break;
            case 3:
                cave.listMonsters();
                System.out.println("Valitse hirviö, johon hyökätä:");
                int j = sc.nextInt() - 1;
                sc.nextLine();
                cave.hitMonster(j);
                break;
            case 4:
                System.out.println("Anna tiedoston nimi, johon peli tallentaa:");
                String fileNameSave = sc.nextLine();
                cave.saveGame(fileNameSave);
                break;
            case 5:
                System.out.println("Anna tiedoston nimi, josta peli ladataan:");
                String fileNameLoad = sc.nextLine();
                Cave loadedGame = Cave.loadGame(fileNameLoad);
                if (loadedGame != null) {
                    cave = loadedGame;
                    System.out.println("Peli ladattu tiedostosta " + fileNameLoad + ". Tervetuloa takaisin, " + cave.player.name + ".");
                }
                break;
            case 0:
                System.out.println("Peli päättyy. Kiitos pelaamisesta!");
                exit = true;
                break;
            default:
                System.out.println("Syöte oli väärä");
                break;
            }
        }

    }
    sc.close();
    } 
}
