public class Main {
    public static void main(String[] Args) {
        System.out.println("Vítej v pecksessu, retardované verzi pexesa pro jednoho hráče");
        Game game = new Game();
        game.start();
        System.out.println("Vypadá to, žes vyhrál. GG.");
    }
}
