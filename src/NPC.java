import java.util.ArrayList;

public class NPC extends Interactable {
    private Item objKunci;
    private boolean isKenal = false;

    public NPC() {
        nama = "NPC";

        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");

    }

    @Override
    public void prosesAksi(int pil) {
        if (pil == 1) {
            System.out.println("Halo saya penjaga pintu ini");
            isKenal = true;
        } else if (pil == 2) {
            if (isKenal) {
                if (objKunci==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else
                {
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);
                    objKunci = null;
                }

            } else {
                System.out.println("Siapa anda? kenalan dulu dong");
            }
        }
    }

    @Override
    public void setObjGameInfo(GameInfo objGameInfo) {
        super.setObjGameInfo(objGameInfo);
        objKunci.setObjGameInfo(objGameInfo);
    }

}
