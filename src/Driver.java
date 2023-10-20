import java.io.*;
import java.util.*;

public class Driver {
    public static void main (String[] args) throws IOException {
        System.out.println("Welcome!");
        boolean moreAlbumsToAdd = true;
        ArrayList <Album> albums = new ArrayList <>();
        ArrayList <Integer> albumNums = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        do {
            getAlbum(in, albums, albumNums, false);
        } while (getChar(in, "Would you like to add more albums?") == 'y');

        int mainMenuChoice;
        while ((mainMenuChoice = displayMenu(in, 0)) != 3) { // loop until exit
            if (mainMenuChoice == 1) {
                subMenuOne(in,albums);
            } else if (mainMenuChoice == 2) {
                subMenuTwo(in);
            } else {
                System.out.println("Goodbye!");
            }
        }

    }
    public static int displayMenu (Scanner in, int menuNum) {
        if (menuNum == 0) {
            System.out.println ("----------  MAIN MENU  -----------");
            System.out.println ("1) Accessing your list of albums");
            System.out.println ("2) Accessing within a particular album");
            System.out.println ("3) Exit");
            System.out.println ("----------------------------------");
            return getInt(in, "\n\nPlease enter your choice", 1, 3);
        } else if (menuNum == 1) {
            System.out.println ("\n---------  SUB-MENU #1  ----------");
            System.out.println ("1) Display a list of all albums");
            System.out.println ("2) Display info on a particular album");
            System.out.println ("3) Add an album");
            System.out.println ("4) Remove an album");
            System.out.println ("5) Show statistics");
            System.out.println ("6) Return back to main menu.");
            System.out.println ("----------------------------------");
            return getInt(in, "\n\nPlease enter your choice", 1, 6);
        } else {
            System.out.println ("\n---------  SUB-MENU #2  ----------");
            System.out.println ("1) Display all cards (in the last sorted order) ");
            System.out.println ("2) Display info on a particular card");
            System.out.println ("3) Add a card");
            System.out.println ("4) Remove a card (4 options)");
            System.out.println ("5) Edit attack");
            System.out.println ("6) Sort cards (3 options)");
            System.out.println ("7) Return back to main menu");
            System.out.println ("----------------------------------");
            return getInt(in, "\n\nPlease enter your choice", 1, 7);
        }
    }
    public static void subMenuOne (Scanner in, ArrayList <Album> albums) {
        int choice;
        while ((choice = displayMenu(in, 1)) != 6) {
            switch(choice) {
                case 1:
                    System.out.println("Here are all the albums: ");
                    printAllAlbums(albums);
                    break;
                case 2:
                    // code block
                    break;
                case 3:
                    // code block
                    break;
                case 4:
                    // code
                    break;
                case 5:
                    // code
            }
        }
    }

    public static void subMenuTwo (Scanner in) {

    }
    public static void printAllAlbums (ArrayList <Album> albums) {
        for (Album album : albums) {
            System.out.println(album);
        }
    }
    public static void printAlbum(Scanner in, ArrayList <Album> albums) {
        int albumNum = getInt(in, "What is the name of the album you are looking for?",1,albums.size());
        System.out.println(albums.get(albumNum-1));
    }

    public static void addAlbum(BufferedReader br, ArrayList <Album> albums) {

    }
    public static void removeAlbum(BufferedReader br, ArrayList <Album> albums) {

    }
    public static void printStatistics (ArrayList <Album> albums) {

    }
    public static void printCardsOfAlbum(BufferedReader br, ArrayList <Album> albums) {

    }
    public static void printStatsOfCard (BufferedReader br, ArrayList <Album> albums) {

    }
    public static void addCard (BufferedReader br, ArrayList <Album> albums) {

    }
    public static void removeCard (BufferedReader br, ArrayList <Album> albums) {

    }
    public static void editAttack (BufferedReader br, ArrayList <Album> albums) {

    }
    public static String getString (Scanner in, String message) {
        String inputString; // stores the input
        boolean validAnswer;
        do {
            try {
                System.out.print(message + ": ");
                inputString = in.nextLine().trim().toLowerCase();

                if (inputString.isEmpty()) { //input length 0 chars
                    throw new IOException();
                }

                validAnswer = true;
            } catch (IOException e) {
                // input length 0
                System.out.println("ERROR! You did not provide a response.\n");
                inputString = "?";
                validAnswer = false;
            }
        } while (!validAnswer);
        return inputString;
    }
    public static int getInt (Scanner in, String message, int min, int max) {
        double n = -1; // stores the input from the user
        int validInt = 0; // int returned to the user
        boolean validAnswer;
        do {
            try {
                System.out.print (message + ": ");
                n = Double.parseDouble (in.nextLine().trim());
                if (n %1.0 == 0) { // if the remainder after dividing by 1 is 0
                    if (n < min) { //less than min
                        n =  1;
                        throw new NumberFormatException();
                    } else if (n > max) { // more than max
                        n = 2;
                        throw new NumberFormatException();
                    }
                } else {
                    n = -1;
                    throw new NumberFormatException();
                }
                validInt = (int) n;
                validAnswer = true;
            } catch (NumberFormatException e) {
                if (n == -1) { //invalid type
                    System.out.println("ERROR! You entered an Invalid Type. "
                            + "Please enter an integer between " + min + " and " + max + " (inclusive)!");
                } else if (n == 1) { // less than min
                    System.out.println("ERROR! Your number cannot be less than " + min + ". "
                            + "Please enter an integer between " + min + " and " + max + " (inclusive)!");
                } else { // more than max
                    System.out.println("ERROR! Your number cannot be greater than " + max + ". "
                            + "Please enter an integer between " + min + " and " + max + " (inclusive)!");
                }
                n = -1;
                validAnswer = false;
            }
        } while (!validAnswer);

        return validInt;
    }
    public static void getCard (BufferedReader br, Album album) {
    }
    public static char getChar(Scanner in, String message) {
        String fullInput = "?"; // stores the original input from the user
        char charInput = '?'; // stores the user's character response
        boolean validAnswer;
        do {
            try {
                System.out.print (message + ": ");
                fullInput = in.nextLine().toLowerCase();

                if (fullInput.length()>1) { // the input is too long (more than one character)
                    fullInput = "1";
                    throw new IOException();
                } else if (fullInput.isEmpty()) { //input length 0
                    fullInput = "2";
                    throw new IOException();
                } else if (!(fullInput.equals("y") || fullInput.equals("s"))) {
                    fullInput = "3";
                    throw new IOException();
                }
                charInput = fullInput.charAt(0);

                validAnswer = true;
            } catch (IOException e) {
                switch (fullInput) {
                    case "?" -> // invalid type
                            System.out.println("ERROR! You entered an Invalid Type. "
                                    + "Please enter a character!");
                    case "1" ->  // input too long
                            System.out.println("ERROR! Your response was more than one character. "
                                    + "Please enter a character!");
                    case "2" ->  // input length 0
                            System.out.println("ERROR! You did not provide a response. "
                                    + "Please enter a character!");
                    case "3" -> // input is not y or n
                            System.out.println("ERROR! You did not provide a response. "
                                    + "Please enter a character!");
                }
                fullInput = "?";
                validAnswer = false;
            }
        } while (!validAnswer);
        return charInput;
    }

    public static void getAlbum (Scanner in, ArrayList <Album> albums, ArrayList <Integer> albumNums, boolean binarySearch) {
        boolean validFileName = false;
        while (!validFileName) {
            try {
                System.out.print("Please provide the name of the input file (WITHOUT FILE EXTENSION): ");
                String fileName = in.nextLine();
                BufferedReader inFile = new BufferedReader(new FileReader(fileName + ".txt"));
                validFileName = true;
                System.out.println(readFile(inFile, albums, binarySearch, albumNums));
                inFile.close();
            } catch (FileNotFoundException e) {
                System.out.println("File Not Found\n");
            } catch (IOException e) {
                System.out.println("Reading error");
            }
        }

    }
    public static String readFile (BufferedReader inFile, ArrayList <Album> albums, boolean binarySearch, ArrayList <Integer> albumNums) {
        try {
            String line;
            if (duplicateAlbum(inFile.readLine().trim(),binarySearch,albumNums)) {
                return "This is a duplicate album";
            }
            Date albumDate = new Date (inFile.readLine().trim());
            int maxCapacity = Integer.parseInt(inFile.readLine().trim());
            int cardsInAlbum = Integer.parseInt(inFile.readLine().trim());
            ArrayList <Card> cards = new ArrayList <> (cardsInAlbum);
            for (int i = 0; i < cardsInAlbum; i++) {
                String name = inFile.readLine().trim();
                int HP = Integer.parseInt(inFile.readLine().trim());
                String type = inFile.readLine().trim();
                Date thisCardDate = new Date (inFile.readLine().trim());
                int attacksInCard = Integer.parseInt(inFile.readLine());
                ArrayList <Attack> attacks = new ArrayList <>(attacksInCard);
                for (int j = 0; j < attacksInCard; j++) {
                    String attackNameDescription = inFile.readLine().trim();
                    int indexOfHyphen = attackNameDescription.indexOf('-');
                    String attackName, attackDescription;
                    if (indexOfHyphen==-1) { // no hyphen
                        attackName = attackNameDescription;
                        attackDescription = "";
                    } else {
                        attackName = attackNameDescription.substring(0,indexOfHyphen).trim();
                        attackDescription = attackNameDescription.substring(indexOfHyphen+1).trim();
                    }
                    attacks.add(new Attack(attackName,attackDescription,inFile.readLine().trim()));
                }
                cards.add(new Card (name, HP, type, thisCardDate,attacks));
            }
        } catch (IOException e) {
            return "Reading Error";
        }
        return "Album import successful!";
    }
    public static boolean duplicateAlbum (String line, boolean binarySearch, ArrayList <Integer> albumNums) {
        int albumNum = Integer.parseInt(line);
        if (binarySearch) {
            return Collections.binarySearch(albumNums, albumNum) >= 0;
        } else {
            return albumNums.contains(albumNum);
        }
    }
}