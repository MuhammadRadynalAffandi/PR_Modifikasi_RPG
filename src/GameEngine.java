import java.util.Scanner;

public class GameEngine {

    Scanner sc = new Scanner(System.in);
    Player objPlayer;
    Ruangan objRuangan;
    GameInfo objGameInfo = new GameInfo();

    public static void main(String[] args) {
        GameEngine objGameEngine;
        objGameEngine = new GameEngine();
        objGameEngine.mulai();
    }

    public GameEngine() {

        objPlayer = new Player(objGameInfo);

        objRuangan = new Ruangan(objGameInfo);

        objRuangan.setDeskripsi("Ruangan kecil, dengan satu pintu dan jendela");

        objPlayer.setRuanganAktif(objRuangan);
        
        objGameInfo.setObjPlayer(objPlayer);
        objGameInfo.setObjRuangan(objRuangan);
    }


    private void aksi() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("1. Aksi yang dapat dilakukan di ruangan");
        System.out.println("2. Aksi terhadap player");
        System.out.println("3. Keluar");
        System.out.println("==============================================");
        System.out.print("Pilihan anda?");
        int pil = sc.nextInt();
        System.out.println("--");
        if (pil==3) {
            objGameInfo.setGameOver(true);
        } else if (pil==1) {
            objRuangan.pilihanAksi(); //
        } else if (pil==2) {
            objPlayer.pilihanAksi();
        }
    }

    public void mulai() {
        while (!objGameInfo.getGameOver()) {
            aksi();
        }
    }
}
