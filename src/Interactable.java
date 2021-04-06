import java.util.ArrayList;

public class Interactable {
    protected String nama;
    protected final ArrayList<String> arrAksi = new ArrayList<>();
    protected GameInfo objGameInfo;

    public void setObjGameInfo(GameInfo objGameInfo) { this.objGameInfo = objGameInfo; }

    public ArrayList<String> getAksi() { return arrAksi; }

    public String getNama() { return nama; }

    public void prosesAksi(int pil){ }

}
