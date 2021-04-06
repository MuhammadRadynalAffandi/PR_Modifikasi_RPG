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

        // init ruangan
        // init pintu, kunci dan roti.
        objPintu = new Pintu();
        objNPC = new NPC();

        Item objRoti  = new Item("Roti");
        objRoti.setDeskripsi("Roti rasa coklat dalam bungkusan plastik");
        objRoti.setObjRuangan(this);

        // Item Selanjutnya Bisa DIletakkan Disini

        // tambah item ke array
        arrItem.add(objRoti);

        // NOMZ: Set Game Info Kepada Semua Interactables
        objPintu.setObjGameInfo(objGameInfo);
        objNPC.setObjGameInfo(objGameInfo);
        for (Item objItem:arrItem) {
            objItem.setObjGameInfo(objGameInfo);
        }

    }

    //aksi yang dapat dilakukan di ruangan
    //agak kompleks tapi jadi fleksibel, logic aksi ada di masing2 item (bukan di game engine)
    //hardcode menu dikurangi
    public void pilihanAksi() {

        // NOMZ: List Interactable diawali dengan item, pintu, dan NPC
        ArrayList<Interactable> interactables = new ArrayList<>(arrItem);
        interactables.add(objPintu);
        interactables.add(objNPC);


        System.out.println("==== Pilihan Aksi pada Ruangan ===");
        int urutPil = 0;  //item, pintu
        int subPil;   //aksinya

        //aksi2 item
        System.out.println("Isi ruangan:");
        // NOMZ: Ubah ArrItem dengan Interactables
        for (Interactable objInteract: interactables) {
            urutPil++;
            subPil = 0;   //sistem penomorannya 11  12  13 dst
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

        //split pilihan dan subpilihan

        int pil    =  Integer.parseInt(strPil.substring(0,1)); //ambil digit pertama, asumsikan jumlah tidak lebih dari 10
        subPil     =  Integer.parseInt(strPil.substring(1,2)); //ambil digit kedua, asumsikan jumlah tidak lebih dari 10

        Interactable objPilih = interactables.get(pil-1);
        objPilih.prosesAksi(subPil); // Aksi Pada Interactable

    }

    // hapus item di ruangan berdasarkan namanya
    // digunakan saat suatu item diambil oleh player misalnya
    public void hapusItem(Item objItem) {
        arrItem.remove(objItem);  //buang item
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
