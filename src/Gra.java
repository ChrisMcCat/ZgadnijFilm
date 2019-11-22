import java.util.Scanner;
import java.util.regex.Pattern;

public class Gra {

    private int numGuess = 0;
    private int numLoops = 0;
    private Boolean alreadyGuessedThatLetter = false;


    public void Start(String selectedMovie) {
        String hidden = new String(new char[selectedMovie.length()]).replace('\0', '_');
        String lettersGuessed = "";
        String fixedMovie = selectedMovie;


        System.out.println("Czy potrafisz zgadnąć tytuł?");


        char[] unwantedCharacters = {':', ' '};
        fixedMovie = fixedMovie.replace(":", "_");
        fixedMovie = fixedMovie.replace(" ", "_");
        fixedMovie = fixedMovie.replace(", ", "_");

        Scanner scanner = new Scanner(System.in);

        for (int i = 20; i > 0; i--) {
            System.out.println("Pozostało Ci " + i + " prób. Podaj literę: ");
            System.out.println("Wpisz literę. Tylko pierwsza wpisana się liczy.");
            System.out.println("Dotąd zgadłeś " + lettersGuessed);
            System.out.println("Dotąd spróbowałes " + numGuess + " razy.");
            System.out.println("Aktualne słowo " + hidden);

            String guess = scanner.nextLine();
            char currentGuess = guess.charAt(0);

            if (Pattern.matches("[a-zA-Z]+", guess)) {
                for (int x = 1; x <= numLoops; x++) {
                    if (currentGuess == lettersGuessed.charAt(x - 1)) {
                        System.out.println("Dotad zgadles " + currentGuess);
                        i++;
                        numGuess++;
                        alreadyGuessedThatLetter = true;
                        break;
                    } else {
                        alreadyGuessedThatLetter = false;
                    }


                }

                if (!alreadyGuessedThatLetter) {


                    for (int r = 0; r <= selectedMovie.length() - 1; r++) {
                        char current = selectedMovie.charAt(r);


                        currentGuess = Character.toLowerCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("Poprawna litera");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }

                        currentGuess = Character.toUpperCase(currentGuess);
                        if (current == currentGuess) {
                            System.out.println("Poprawna litera");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);

                        }
                    }
                    lettersGuessed = lettersGuessed + currentGuess + ", ";
                    numGuess++;
                    numLoops++;
                }

                if (fixedMovie.equals(hidden)) {
                    System.out.println("WYGRAŁEŚ!");
                    System.out.println("Tytuł brzmi " + selectedMovie);
                    break;
                }
            } else {
                System.out.println("Wprowadź litere");
                i++;
            }
        }

        if (!fixedMovie.equals(hidden)) {
            System.out.println("Przegrałeś... :( ");

        }
    }
}
