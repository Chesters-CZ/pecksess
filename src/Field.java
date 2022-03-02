import static java.util.Objects.isNull;

public class Field {

    Karticky[][] herniPole = new Karticky[4][4];

    public Karticky.Obrazek[] seznamKaret = {Karticky.Obrazek.KAREL, Karticky.Obrazek.PAVEL, Karticky.Obrazek.MIKOLAS, Karticky.Obrazek.VITEK, Karticky.Obrazek.ZEDEK, Karticky.Obrazek.LUKAS, Karticky.Obrazek.KUBA, Karticky.Obrazek.HONZA};

    public void generate() {

        int x;
        int y;
        for (int i = 0; i < seznamKaret.length * 2; i++) {
            x = (int) (Math.random() * 4);
            y = (int) (Math.random() * 4);

            if (isNull(herniPole[x][y]))
                herniPole[x][y] = new Karticky(seznamKaret[i % seznamKaret.length]);
            else
                i--;
        }
    }
}
