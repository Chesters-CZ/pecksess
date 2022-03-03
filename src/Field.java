import static java.util.Objects.isNull;

public class Field {

    Karticky[][] herniPole = new Karticky[4][4];

    public Karticky.Obrazek[] seznamKaret = {Karticky.Obrazek.KAREL, Karticky.Obrazek.PAVEL, Karticky.Obrazek.MIKOLAS, Karticky.Obrazek.VITEK, Karticky.Obrazek.ZEDEK, Karticky.Obrazek.LUKAS, Karticky.Obrazek.KUBA, Karticky.Obrazek.HONZA};

    @Override
    public String toString() {
        StringBuilder vec = new StringBuilder();
        for (Karticky[] radek : herniPole) {
            for (Karticky karta : radek) {
                vec.append(karta.toString()).append(" ");
            }
            vec.append("\n");
        }
        return vec.toString();
    }

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
