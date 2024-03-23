class  agl{
    int içerik;
    agl sol,sag;
    public agl(int içerik){
        this.içerik=içerik;
        sol=null;
        sag=null;
    }
}
class agçç{
        agl kök;
        public agçç(){
            kök=null;
        }

    void ekle(agl yeni){
        agl önceki=null;
        agl tmp=kök;
        while (tmp!=null){
            önceki=tmp;
            if (tmp.içerik>yeni.içerik){
                tmp=tmp.sol;
            }else
                tmp=tmp.sag;
        }
        if (önceki==null) {
            kök=yeni;
        } else if (önceki.içerik< yeni.içerik) {
            önceki.sag=yeni;
        }else
            önceki.sol=yeni;
    }
    void aranan(agl deger){
            agl tmp=kök;
            while (tmp!=null){
                if (tmp.içerik==deger.içerik){
                    if (tmp!=null) {
                        preorder(tmp);
                    }
                }
                if (tmp.içerik>deger.içerik){
                    tmp=tmp.sol;
                }else {
                    tmp=tmp.sag;
                }
            }
    }
    agl min(){
            agl tmp=kök;
            while (tmp.sol!=null){
                tmp=tmp.sol;
            }return tmp;
    }

    public void preorder(agl tmp){
            if (tmp!=null){
                System.out.println(tmp.içerik);
                preorder(tmp.sol);
                preorder(tmp.sag);
            }
    }
    public boolean delete(int key){
            agl current=kök;
            agl parent=kök;
            boolean solchild=true;
            if (kök==null){
                return false;
            }
            while (current.içerik!=key){
                parent=current;
                if (current.içerik>key){
                    current=current.sol;
                    solchild=true;
                } else {
                    current=current.sag;
                    solchild=false;
                }
                if (current==null){
                    return false;
                }
            }
            if (current.sol==null && current.sag==null){
                if (current==kök){
                    current=null;
                } else if (solchild) {
                    parent.sol=null;
                }else {
                    parent.sag=null;
                }
            }
            else if (current.sag==null){
                if (current==kök){
                    kök=current.sol;
                } else if (solchild) {
                    parent.sol=current.sol;
                }else {
                    parent.sag=current.sol;
                }
            } else if (current.sol==null) {
                if (current==kök){
                    kök=current.sag;
                } else if (solchild) {
                    parent.sol=current.sag;
                }else {
                    parent.sag=current.sag;
                }
            }else {

                if (current==kök){
                    kök=current.sag;
                } else if (solchild) {
                    parent.sol=current.sag;
                    current.sag.sag=current.sol;
                }else {
                    parent.sag=current.sag;
                    current.sag.sag=current.sol;
                }
            }return true;
    }
}
public class agç {
    public static void main(String[] args) {
    agçç a=new agçç();
    a.ekle(new agl(13));
    a.ekle(new agl(17));
        a.ekle(new agl(10));
        a.ekle(new agl(12));
        a.ekle(new agl(5));
        a.ekle(new agl(11));
        a.ekle(new agl(18));

        a.aranan(new agl(10));
        System.out.println("kök:"+a.kök.içerik);
        System.out.println("kökün solu:"+a.kök.sol.içerik);
        System.out.println("kökün sagı:"+a.kök.sag.içerik);
        System.out.println("en küçük:"+a.min().içerik);
        a.delete(5);
        a.delete(12);
        a.preorder(a.kök);
        System.out.println("10 un sagı:"+a.kök.sol.sag.içerik);

    }
}
