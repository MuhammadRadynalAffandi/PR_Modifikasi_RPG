import java.util.ArrayList;

// NOMZ: Berfungsi sebagai parent dari Item, Pintu, NPC

//abstract public class Interactable {
public class Interactable {
    protected String nama;
    protected final ArrayList<String> arrAksi = new ArrayList<>();
    protected GameInfo objGameInfo;

    public void setObjGameInfo(GameInfo objGameInfo) { this.objGameInfo = objGameInfo; }

    public ArrayList<String> getAksi() { return arrAksi; }

    public String getNama() { return nama; }

    // NOMZ: Ini nanti di override, biar gak menimbulkan pertanyaan tentang abstract class
    // jadinya fungsi kosong, kalau pake abstract class uncomment yang bawah sama yang atas
    public void prosesAksi(int pil){ }

    // abstract void prosesAksi(int pil);
}
