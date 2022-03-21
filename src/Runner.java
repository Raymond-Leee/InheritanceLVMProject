import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner user = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to the LVM system! Enter your commands:");
        while (!exit)
        {
            System.out.print("cmd# ");
            String cmd = user.next();
            if (cmd.equalsIgnoreCase("exit"))
            {
                System.out.println("Saving data. Goodbye!");
                exit = true;
            }
        }
    }
}
