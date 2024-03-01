//Justin Stauffer,Nate Bittle, Chuckie Koch
import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class VictimPicker {
   public ArrayList<Victim> victims;
    public ArrayList<Victim> pickedToday;
   public  ArrayList<Victim> absentToday;
    Random random;
    public VictimPicker() {
         victims = new ArrayList<>();
         pickedToday = new ArrayList<>();
         absentToday = new ArrayList<>();
        random = new Random();
    }


    public ArrayList<Victim> chooseTwo(){
        int size = this.victims.size();
        pickedToday.clear();
        //Ensure there are at least two victims to choose from
        if (size < 2) {
            throw new IllegalStateException("There needs to be at least two victims to choose from.");
        }
        int firstIndex = random.nextInt(size);
        int secondIndex = firstIndex;
        // This makes sure the second person picked is not the same as the first.
        while (secondIndex == firstIndex) {
            secondIndex = random.nextInt(size);
        }

        // Add the randomly selected victims to the list
        pickedToday.add(this.victims.get(firstIndex));
        pickedToday.add(this.victims.get(secondIndex));

        return pickedToday;

    }
    public void score(int points){
        for(Victim victim : pickedToday){
                if(!victim.getAbsent()) {
                    victim.setScore(victim.getScore()+ points);
                }//do not increment score if they are absent, only record date.

            victim.setLastPicked(new Date());
        }

    }
    public void markAbsent(Victim absentvictim){

        absentvictim.setAbsent(absentvictim.getAbsent());
            ArrayList<Date> absentdates = new ArrayList<>();
        this.absentToday.add(absentvictim);
            absentdates.add(new Date());
        absentvictim.setAbsences(absentdates);
    }
    public void loadList(ArrayList<Victim> victims){
        this.victims.addAll(victims);



    }
}
