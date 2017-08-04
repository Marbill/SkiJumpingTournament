
import java.util.Scanner;

public class Main {

    public static void getJumpers(Scanner reader, jumpersDB db) {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String name = reader.nextLine();
            if (name.isEmpty()) {
                break;
            }
            Jumper jumper = new Jumper(name);
            db.add(jumper);
        }
        System.out.println();
    }

    public static void tournament(Scanner reader, jumpersDB db) {
        System.out.println("The tournament begins!");
        System.out.println();

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String option = reader.nextLine();
            if (!option.equals("jump")) {
                break;
            } else {
                System.out.println();
                db.jump();
            }
        }

        db.printResults();

    }

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        Scanner in = new Scanner(System.in);
        jumpersDB tournment = new jumpersDB();
        
        getJumpers(in, tournment);
        tournament(in, tournment);

    }
}
