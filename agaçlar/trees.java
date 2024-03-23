//lab örnekleri
class agaç{
    int içerik;
    agaç sol;
    agaç sag;
    public  agaç(int içerik){
        this.içerik=içerik;
        sag=null;
        sol=null;
    }
}
class tree{
    agaç kök;
    public tree(){
        kök=null;
    }
    void ekle(agaç yeni){
        agaç önce=null;
        agaç tmp=kök;
        while (tmp!=null){
            önce=tmp;
            if (tmp.içerik< yeni.içerik){
                tmp=tmp.sag;
            }else tmp=tmp.sol;
        }
        if (önce==null){
            kök=yeni;
        }else if (yeni.içerik< önce.içerik){
          önce.sol=yeni;
        }else {
                önce.sag=yeni;
            }}
        void preorder(agaç kök){
            if (kök!=null){
                System.out.println(kök.içerik+" ");
                preorder(kök.sol);
                preorder(kök.sag);
            }
        }
        void inorder(agaç kök){
            if (kök!=null){
                inorder(kök.sol);
                System.out.print(kök.içerik+" ");
                inorder(kök.sag);
            }
        }
        agaç ara(int deger){
            agaç d=kök;
            while (d!=null){
                if (d.içerik==deger){
                    System.out.println("eleman bulundu");
                    return d;
                } else if (deger<d.içerik) {
                        d=d.sol;
                }else {
                    d=d.sag;
                }
            }return null;
        }
    agaç min(){
        agaç tmp=kök;
        while (tmp.sol!=null){
            tmp=tmp.sol;
        }return tmp;
    }
    public boolean yapraksil(int key){
        agaç current=kök;
        agaç parent=null;
        boolean soldügüm=true;
        while (current.içerik!=key) {
            parent = current;
            if (key < current.içerik) {
                soldügüm = true;
                current = current.sol;
            } else {
                soldügüm = false;
                current = current.sag;
            }
            if (current == null) {
                return false;
            }
            if (current.sol == null && current.sag == null) {
                if (current.içerik == key) {
                    kök = null;
                } else if (soldügüm) {
                    parent.sol = null;
                } else {
                    parent.sag = null;
                }
            } else {
                return false;
            }
        }return true;
    }
   /* void göster(){
        kuyruk k=new kuyruk();
        agaç tmp=kök;
        if (tmp!=null){
            k.ekle
        }

    }
}*/
public class trees {
    public static void main(String[] args) {
        tree t=new tree();
        t.ekle(new agaç(12));
        t.ekle(new agaç(3));
        t.ekle(new agaç(23));
        t.ekle(new agaç(25));
        t.ekle(new agaç(10));
        System.out.println("en küçük:"+t.min().içerik);
        System.out.println(t.kök.sol.içerik);
        System.out.println(t.kök.içerik);
        t.inorder(t.kök);
        t.ara(12);
        t.yapraksil(3);
}
}}