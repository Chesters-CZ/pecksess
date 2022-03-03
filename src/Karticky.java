public class Karticky {
    Viditelnost visible;
    Obrazek obrazek;

    public Karticky(Obrazek obr, Viditelnost vis) {
        this.obrazek = obr;
        this.visible = vis;
    }

    public Karticky(Obrazek obr) {
        this.obrazek = obr;
        this.visible = Viditelnost.NENI;
    }

    @Override
    public String toString() {
        if (visible != Viditelnost.NENI)
            return switch (visible) {
                case JE -> MikolasovyConsoleBarvy.GREEN;
                case TEMP -> MikolasovyConsoleBarvy.YELLOW;
                default -> throw new IllegalStateException("Unexpected value: " + visible);
            } + "{" +
                    switch (obrazek) {
                        case KUBA -> "J";
                        case HONZA -> "H";
                        case KAREL -> "K";
                        case LUKAS -> "L";
                        case PAVEL -> "P";
                        case VITEK -> "V";
                        case ZEDEK -> "Z";
                        case MIKOLAS -> "M";
                    } +
                    '}' + MikolasovyConsoleBarvy.RESET;
        else return "{?}";
    }

    public enum Obrazek {
        KAREL, PAVEL, MIKOLAS, VITEK, ZEDEK, LUKAS, KUBA, HONZA
    }

    public enum Viditelnost {
        NENI, JE, TEMP
    }
}
