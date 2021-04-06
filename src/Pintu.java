import java.util.ArrayList;

public class Pintu extends Interactable {

    public Pintu() {
        nama = "Pintu";
        arrAksi.add("Deskripsikan pintu");
        arrAksi.add("Coba buka pintu");
    }

    @Override
    public void prosesAksi(int pil) {
        if (pil==1) {
            System.out.println("Pintu berwarna merah dengan tulisan 'EXIT' di atas ");
        } else if (pil==2) {
            if (objGameInfo.getObjPlayer().cariItem("Kunci")) {
                System.out.println("Player menggunakan kunci untuk membuka pintu dan pintu terbuka!");
                objGameInfo.setGameOver(true);
            } else {
                System.out.println("Player mencboa membuka pintu. TERKUNCI!");
            }
        }
    }


}
