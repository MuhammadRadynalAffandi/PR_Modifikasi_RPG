import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Ruangan {

    private final Pintu objPintu;
    private final NPC objNPC;
    private final ArrayList<Item> arrItem = new ArrayList<>();
    private String deskripsi;
    private final GameInfo objGameInfo;
    private final Scanner sc = new Scanner(System.in);

    public Ruangan(GameInfo objGameInfo) {
        this.objGameInfo = objGameInfo;

        objPintu = new Pintu();
        objNPC = new NPC();

        Item objRoti  = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        arrItem.add(objRoti);

        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }

    }

    public void pilihanAksi() {

        ArrayList<Interactable> interactables = new ArrayList<>(arrItem);
        interactables.add(objPintu);
        interactables.add(objNPC);


        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;
        int subPil;

        System.out.println("Isi ruangan:");
        for (Interactable objInteract: interactables) {
            urutPil++;
            subPil = 0;
            System.out.println(objInteract.getNama());

            //ambil pilihannya
            ArrayList <String> arrPil = objInteract.getAksi();

            //print pilihan
            for (String strPil: arrPil) {
                subPil++;
                System.out.printf("%d%d. %s %n", urutPil, subPil, strPil);
            }
        }


        System.out.print("Pilihan anda?");
        String strPil = sc.next();
        System.out.println("--");

        int pil    =  Integer.parseInt(strPil.substring(0,1));
        subPil     =  Integer.parseInt(strPil.substring(1,2));

        Interactable objPilih = interactables.get(pil-1);
        objPilih.prosesAksi(subPil);

    }

    public void hapusItem(Item objItem) {
        arrItem.remove(objItem); 
    }

    public void addItem(Item objItem) {
        arrItem.add(objItem);
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

}
