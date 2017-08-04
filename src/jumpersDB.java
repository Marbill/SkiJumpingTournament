
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* @author marbi */
public class jumpersDB {

    private List<Jumper> jumpers;
    private int round;

    public jumpersDB() {
        this.jumpers = new ArrayList<Jumper>();
        this.round = 0;
    }

    public void add(Jumper jumper) {
        jumpers.add(jumper);
    }

    private void setRound() {
        this.round++;
    }

    private void sort() {
        Collections.sort(jumpers);
        //Collections.reverse(jumpers);
    }

    private void print() {
        int i = 1;
        for (Jumper jumper : jumpers) {
            System.out.print("  " + i + ". " + jumper.getName() + " (" + jumper.getTotalScore() + " points)");
            i++;
            System.out.println();
        }
    }

    public void jump() {
        this.setRound();
        System.out.println("Round " + this.round);
        System.out.println();

        this.sort();
        System.out.println("Jumping order:");
        this.print();

        for (Jumper jumper : jumpers) {
            jumper.setjumpLenght();
            jumper.setjudgesVotes();
            jumper.setTotalScore(jumper.subTotal());
        }

        System.out.println();
        System.out.println("Results of round " + this.round);

        for (Jumper jumper : jumpers) {
            System.out.println(jumper);
            //System.out.println(jumper.getTotalScore());
        }

        System.out.println();
    }

    public void printResults() {
        System.out.println();
        System.out.println("Thanks!");
        System.out.println();
        System.out.println("Tournament results:");
        System.out.print("Position    Name\n");
        Collections.sort(jumpers);
        Collections.reverse(jumpers);
        int i = 1;
        for (Jumper jumper : jumpers) {
            System.out.print(i + "           " + jumper.getName() + " (" + jumper.getTotalScore() + ")\n");
            jumper.getJumps();
            i++;
            System.out.println();
        }

    }

}
