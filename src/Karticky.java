public class Karticky {
    boolean visible;
    Obrazek obrazek;

    public Karticky(Obrazek obr, boolean vis) {
        this.obrazek = obr;
        this.visible = vis;
    }

    public Karticky(Obrazek obr) {
        this.obrazek = obr;
        this.visible = false;
    }

    public enum Obrazek {
    KAREL, PAVEL, MIKOLAS, VITEK, ZEDEK, LUKAS, KUBA, HONZA}
};
