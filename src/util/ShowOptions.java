package util;
abstract public class ShowOptions {
    
    public static void showOptions(int option) {
        // Clears Console
        if (option != 1) {
            System.out.print("\033[H\033[2J");
            System.out.flush();            
            System.out.println("--Welcome to the Expense Tracker-- ");
        }

        System.out.println();
        System.out.println("1 - Add an expense");
        System.out.println("2 - Delete an expense");
        System.out.println("3 - View all expenses");
        System.out.println("4 - View summary of all expenses");
        System.out.println("5 - View summary of all expenses for a specific month");
        System.out.println();
    }

}
