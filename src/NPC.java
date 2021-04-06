import java.util.ArrayList;

public class NPC extends Interactable {
    //kunci dipindahkan dari ruangan
    private Item objKunci;
    private boolean isKenal = false;

    public NPC() {
        nama = "NPC";

        //init kunci
        objKunci = new Item("Kunci");
        objKunci.setDeskripsi("Sebuah kunci kecil yang sudah agak berkarat");

        //aksi npc
        arrAksi.add("Perkenalan dgn NPC");
        arrAksi.add("Minta kunci");

    }

    @Override
    public void prosesAksi(int pil) {
        //1: perkenalan dengan npc
        //2: buka pintu
        if (pil == 1) {
            System.out.println("Halo saya penjaga pintu ini");
            isKenal = true;
        } else if (pil == 2) {
            if (isKenal) {
                //berikan kunci pada player
                if (objKunci==null) {
                    System.out.println("Masa lupa, kunci kan sudah saya berikan!");
                } else
                {
                    System.out.println("Kunci diberikan pada player");
                    objGameInfo.getObjPlayer().addItem(objKunci);     //tambahkan  objek ini pada player
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
