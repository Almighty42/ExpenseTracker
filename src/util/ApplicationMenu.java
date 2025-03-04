package util;

import java.util.Scanner;

abstract public class ApplicationMenu {
    
    public static void showOptions(boolean option) {
        // Clears Console
        if (option) {
            clearConsole();
            System.out.println("--Welcome to the Expense Tracker-- ");
        }

        System.out.println();
        System.out.println("1 - Add an expense");
        System.out.println("2 - Delete an expense");
        System.out.println("3 - Update an expense");
        System.out.println("4 - View all expenses");
        System.out.println("5 - View summary of all expenses");
        System.out.println("6 - View summary of all expenses for a specific month");
        System.out.println("7 - Exit program");
        System.out.println();
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();       
    }

    public static void clearCommand(Scanner scanner) {
        System.out.println("\nPress any button to continue...\n");
        scanner.nextLine();
        ApplicationMenu.clearConsole();
        ApplicationMenu.showOptions(true);
    }

    public static void clearCommand(Scanner scanner, Boolean nextScanner) {
        System.out.println("\nPress any button to continue...\n");
        scanner.nextLine();
        if (nextScanner) scanner.nextLine();
        ApplicationMenu.clearConsole();
        ApplicationMenu.showOptions(true);
    }

}
