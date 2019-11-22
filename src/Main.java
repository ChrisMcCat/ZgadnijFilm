import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        int liczbaFilm = 0;
        int randomFilm = 0;
        String wybrany ="";
        String filmy = "";


        File filmFile = new File("filmy.txt");
        Scanner scanner = new Scanner(filmFile);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            filmy += (line + "\n");
            liczbaFilm++;
        }


        System.out.println("Liczba filmow: " + liczbaFilm);


        randomFilm = (int) (Math.random() * liczbaFilm);

        System.out.println("Numer filmu: " + randomFilm);


        File filmFile2 = new File("filmy.txt");
        Scanner scanner2 = new Scanner(filmFile2);
        int i = 0;
        while(i <= randomFilm) {
            wybrany = scanner2.nextLine();
            i++;
        }


        Gra game = new Gra();
        game.Start(wybrany);

    }
}
