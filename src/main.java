
/**
 /@Title: Rekenmachine
 /@Author: Amer Zahirovic
 /@Group: IS109 SQUAD D
 /@Description: Het programma vraagt de gebruiker om een operator(+, -,*, / of %)
 */

import java.util.Scanner;

public class main {

    // Define + - / *
    final static char PLUS = '+';
    final static char SUBTRACT = '-';
    final static char DIVIDE = '/';
    final static char MULTIPLY = '*';
    final static char EXIT = 's';

    static void PrintCalculation(char operator, double num1, double num2) {
        // Calculates

        switch (operator) {
            case PLUS:
                double sumPlus = num1 + num2;
                System.out.println(num1 + " + " + num2 + " = " + sumPlus);
                break;

            case SUBTRACT:
                double sumSubtract = num1 - num2;
                System.out.println(num1 + " - " + num2 + " = " + sumSubtract);
                break;

            case DIVIDE:
                double sumDivide = num1 / num2;
                System.out.println(num1 + " / " + num2 + " = " + sumDivide);
                break;

            case MULTIPLY:
                double sumMultiply = num1 * num2;
                System.out.println(num1 + " * " + num2 + " = " + sumMultiply);
                break;
        }
    }

    static boolean IsValidOperator(char character) {
        // Status code to exit program
        final int STATUS = 0;

        if (character == PLUS || character == SUBTRACT || character == DIVIDE || character == MULTIPLY) {
            return true;

        } else if (character == EXIT) {
            System.out.println("Bedankt voor het gebruiken van mijn rekenmachine!");
            System.exit(STATUS);
        } else {
            System.out.println("Operator is ongeldig!");
            System.out.println();
        }

        return false;
    }

    public static void main(String[] args) {
        // The defines the first position for getting the char
        final int FIRST_POSITION = 0;

        // Repeats everything till user stops the calculator when pressing s
        while (true) {
            Scanner input = new Scanner(System.in);

            // Asks for input and puts it to lower case
            System.out.print("Kies een operator (S = stoppen): ");
            String c = input.nextLine().toLowerCase();
            System.out.println("De karakter die u heeft ingevuld: " + c);

            // While an empty string is given when choosing an operator it will repeat
            // itself
            while (c.isEmpty()) {
                System.out.print("Kies een geldige operator (S = stoppen): ");
                c = input.nextLine().toLowerCase();
                System.out.println(c);
            }

            System.out.println();

            // Gets the first char
            char firstChar = c.charAt(FIRST_POSITION);

            // While the operator is not valid repeat
            while (!IsValidOperator(firstChar)) {
                System.out.print("Kies een geldige operator (S = stoppen): ");
                String newC = input.next().toLowerCase();
                firstChar = newC.charAt(FIRST_POSITION);
                System.out.println();
                System.out.println("De karakter die u heeft ingevuld: " + firstChar);
            }

            // Enter num1 and num2
            System.out.print("Eerste getal: ");
            double num1 = input.nextDouble();
            System.out.print("Tweede getal: ");
            double num2 = input.nextDouble();

            // Calculates sum
            PrintCalculation(firstChar, num1, num2);
            System.out.println();
        }

    }
}
