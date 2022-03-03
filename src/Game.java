import java.io.IOException;
import java.util.Scanner;

public class Game {
    Field field = new Field();

    public void start() {
        field.generate();
        gameLoop();
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void gameLoop() {
        int selectedX;
        int selectedY;
        int Xprvni = -1;
        int Yprvni = -1;
        boolean otaciDruhouKartu = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println(field);
        turns:
        while (!isGameOver()) {
            xloop:
            while (true) {
                System.out.println("Zadej vertikální pozici políčka, které chceš otočit");
                try {
                    selectedX = scanner.nextInt();
                    if (selectedX < field.herniPole.length && selectedX >= 0)
                        break xloop;
                    else throw new Exception("ignored");
                } catch (Exception e) {
                    System.out.println("Platné hodnoty jsou celá čísla od 0 do " + (field.herniPole.length - 1));
                }
            }
            yloop:
            while (true) {
                System.out.println("Zadej horizontální pozici políčka, které chceš otočit");
                try {
                    selectedY = scanner.nextInt();
                    if (selectedY < field.herniPole[0].length && selectedY >= 0)
                        break yloop;
                    else throw new Exception("ignored");
                } catch (Exception e) {
                    System.out.println("Platné hodnoty jsou celá čísla od 0 do " + (field.herniPole[0].length - 1));
                }
            }
            if (field.herniPole[selectedX][selectedY].visible != Karticky.Viditelnost.NENI) {
                System.out.println("Tahle kartička už je otočená");
                continue turns;
            } else if (selectedX == Xprvni && selectedY == Yprvni) {
                System.out.println("Nemůžeš dvakrát otočit tu samou kartičku.");
                continue turns;
            } else {
                field.herniPole[selectedX][selectedY].visible = Karticky.Viditelnost.TEMP;
                if (!otaciDruhouKartu) {
                    Xprvni = selectedX;
                    Yprvni = selectedY;
                    System.out.println(field);
                    otaciDruhouKartu = true;
                } else {
                    if (field.herniPole[selectedX][selectedY].obrazek == field.herniPole[Xprvni][Yprvni].obrazek) {
                        System.out.println("Dobře ty! Našels správnou kombinaci.");
                        field.herniPole[selectedX][selectedY].visible = Karticky.Viditelnost.JE;
                        field.herniPole[Xprvni][Yprvni].visible = Karticky.Viditelnost.JE;
                        System.out.println(field);
                    } else {
                        System.out.println("Kartičky, který jsi otočil nejdou do páru.");
                        System.out.println(field);
                        System.out.println("POKRAČUJ ENTEREM");
                        try {
                            System.in.read();
                        } catch (IOException ignored) {
                        }
                        field.herniPole[selectedX][selectedY].visible = Karticky.Viditelnost.NENI;
                        field.herniPole[Xprvni][Yprvni].visible = Karticky.Viditelnost.NENI;
                        System.out.println(field);
                    }
                    otaciDruhouKartu = false;
                    Xprvni = -1;
                    Yprvni = -1;
                }
            }
        }
    }

    public boolean isGameOver() {
        for (Karticky[] radek : this.field.herniPole)
            for (Karticky policko : radek)
                if (policko.visible != Karticky.Viditelnost.JE) return false;

        return true;
    }
}
