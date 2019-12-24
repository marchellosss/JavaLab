import java.util.Map;
import java.util.Scanner;

public class DictionaryTest {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner scanner = new Scanner(System.in);
        addWords(dictionary, scanner);
        translateWords(dictionary, scanner);
        translatePhrase(dictionary, scanner);
    }

    public static void addWords(Dictionary dictionary, Scanner scanner) {
        String foreignWord, translateWord;
        boolean isInput = true;
        int next = 0;
        while (isInput) {
            System.out.println("Add word foreign word:");
            foreignWord = scanner.next();
            System.out.println("Add translate word:");
            translateWord = scanner.next();
            dictionary.addWord(foreignWord, translateWord);
            while (next == 0) {
                System.out.println("Enter 1 for add another one word or enter 2 to skip:");
                try {
                    next = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Incorrect input! Try again");
                    scanner.skip(".*\n");
                }
            }
            if (next == 2) {
                isInput = false;
            }
            next=0;
        }
    }

    public static void translateWords(Dictionary dictionary, Scanner scanner) {
        String foreignWord;
        boolean isInput = true;
        int next = 0;

        while (isInput) {
            System.out.println("Enter word to translate:");
            try {
                foreignWord = scanner.next();
                System.out.println("Translate word: " + dictionary.translateWord(foreignWord));

            } catch (IllegalArgumentException e) {
                System.out.println(" No such word in directory");
            } finally {
                next = 0;
                while (next == 0) {
                    System.out.println("Enter 1 to translate another one word or enter 2 to skip:");
                    try {
                        next = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Incorrect input! Try again");
                        scanner.skip(".*\n");
                    }
                }
                if (next == 2) {
                    isInput = false;
                }
                next=0;
            }
        }
    }

    public static void translatePhrase(Dictionary dictionary, Scanner scanner) {
        String foreignPhrase;
        scanner.skip(".*\n");
        int next = 0;
        boolean isInput = true;
        while (isInput) {
            System.out.println(" Enter phrase to translate:");
            try {
                foreignPhrase = scanner.nextLine();
                System.out.println("Translate phrase: " + dictionary.translatePhrase(foreignPhrase));
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                next = 0;
                while (next == 0) {
                    System.out.println("Enter 1 to translate another one phrase or enter 2 to skip:");
                    try {
                        next = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Incorrect input! Try again");
                        scanner.skip(".*\n");
                    }
                }
                if (next == 2) {
                    isInput = false;
                }

            }
        }
        scanner.close();
    }
}

