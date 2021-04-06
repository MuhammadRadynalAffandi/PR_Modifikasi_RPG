import java.util.ArrayList;

public class Item extends Interactable{
    private String deskripsi;
    private Ruangan objRuangan;
    
    public Item(String nama) {
        this.nama = nama;
    }

    @Override
    public void prosesAksi(int pil) {
        if (pil==1) {
            System.out.println(deskripsi);
        } else  if (pil==2) { 
            if (objRuangan==null) {
                dibuang();
            } else {
                diambil();
            }
        }
    }

    private void dibuang() {
        System.out.println("Item dibuang player ke ruangan");
        objGameInfo.getObjPlayer().hapusItem(this);
        objGameInfo.getObjRuangan().addItem(this);
        objRuangan = objGameInfo.getObjRuangan();
    }


    private void diambil() {
        System.out.println("Item diambil player");
        objGameInfo.getObjPlayer().addItem(this);
        objRuangan.hapusItem(this);
        objRuangan = null;
    }


    public void printItem() {
        System.out.println(deskripsi);
    }

    @Override
    public ArrayList<String> getAksi() {
        ArrayList<String> arrOut = new ArrayList<>();
        if (objRuangan==null) {
            arrOut.add("Deskripsi Item");
            arrOut.add("Buang item");
        } else {
            arrOut.add("Deskripsi Item");
            arrOut.add("Ambil item");
        }
        return(arrOut);
    }

    public void setObjRuangan(Ruangan objRuangan) {
        this.objRuangan = objRuangan;
    }
    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


}
