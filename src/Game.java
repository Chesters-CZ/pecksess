public class Game {
    Field field = new Field();

    public void start() {
        field.generate();
    }

    public void gameLoop() {
        int selectedX=0;
        int selectedY=0
        while(isGameOver())
        System.out.println("Zadej souřadnici X políčka, které chceš otočit");
    }

    public boolean isGameOver() {
        for (Karticky[] radek : this.field.herniPole)
            for (Karticky policko : radek)
                if (!policko.visible) return false;

        return true;
    }
}
