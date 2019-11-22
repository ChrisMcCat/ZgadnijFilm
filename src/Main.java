import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        int numOfMovies = 0;
        int randomMovie = 0;
        String selectedMovie ="";
        String movies = "";


        File movieFile = new File("filmy.txt");
        Scanner scanner = new Scanner(movieFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            movies += (line + "\n");
            numOfMovies++;
        }


        System.out.println("Liczba filmow: " + numOfMovies);


        randomMovie = (int) (Math.random() * numOfMovies);

        System.out.println("Numer filmu: " + randomMovie);


        File movieFile2 = new File("filmy.txt");
        Scanner scanner2 = new Scanner(movieFile2);
        int i = 0;
        while(i <= randomMovie) {
            selectedMovie = scanner2.nextLine();
            i++;
        }


        Gra game = new Gra();
        game.Start(selectedMovie);

    }
}
