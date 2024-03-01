//Justin Stauffer
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
        //This is used for if the teacher theoretically wants to pick 5 times.
        int numtimesused = 5;
        Victim firstVictim = new Victim("Justin Stauffer", 1);
        Victim secondVictim = new Victim("Jessie Stauffer", 1);
        Victim thirdVictim = new Victim("Braylon Bailey", 1);
        Victim fourthVictim = new Victim("Jim Smith", 1);
        Victim fifthVictim = new Victim("Knewt Caraway", 1);

        // Create an instance of VictimPicker
        VictimPicker picker = new VictimPicker();

        // Create an ArrayList and add Victims
        ArrayList<Victim> victims = new ArrayList<>();
        victims.add(firstVictim);
        victims.add(secondVictim);
        victims.add(thirdVictim);
        victims.add(fourthVictim);
        victims.add(fifthVictim);
        picker.markAbsent(firstVictim);// tests to see if markabsent is working
        // Call loadList on the picker instance with the victims list
        picker.loadList(victims);
        //simulates five runs during one class period
        for(int i = 0; i < numtimesused; i++){
        ArrayList<Victim> thechosenones = picker.chooseTwo();
        picker.score(1);

        for (Victim victim : thechosenones) {

            System.out.println(victim);
        }

        }
    }}


