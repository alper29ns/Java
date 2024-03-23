class trees{
     int içerik;
     trees sag,sol;
     public trees(int içerik){
         this.içerik=içerik;
         sol=null;sag=null;
     }
}
class kelkit{
        trees kök;
        public kelkit(){
            kök=null;
        }
        trees ekle(int data){
            kök=new trees(data);
            System.out.println(data+" eklendi");
            return kök;
        }
        trees insert(trees kök,int data){
            if (kök!=null){
                if (data<kök.içerik){
                    kök.sol=insert(kök.sol,data);
                }else {
                    kök.sag=insert(kök.sag,data);
                }
            }else {
                kök=ekle(data);
            }return kök;
        }
        void preorder(trees kök){
            if (kök!=null){
                System.out.print(kök.içerik+" ");
                preorder(kök.sol);
                preorder(kök.sag);
            }
        }
    void inorder(trees kök){
        if (kök!=null){
            preorder(kök.sol);
            System.out.print(kök.içerik+" ");
            preorder(kök.sag);
        }
    }
    void postorder(trees kök){
        if (kök!=null){
            preorder(kök.sol);
            preorder(kök.sag);
            System.out.print(kök.içerik+" ");

        }
    }
    int height(trees kök){
            if (kök==null){
                return -1;
            }else {
                int sol=0,sag=0;
                sol=height(kök.sol);
                sag=height(kök.sag);
                if (sol>sag){
                    return sol+1;
                }else {
                    return sag+1;
                }
            }
    }
    int size(trees kök){
            if (kök==null){
                return 0;
            }else {
                return size(kök.sol)+1 +size(kök.sag);
            }
    }
    trees delete(trees kök, int data){
            trees t1,t2;
            if (kök==null){
                System.out.println("silinecek elaman yok");
                return null;
            }if (kök.içerik==data){
                if (kök.sol==kök.sag){
                    kök=null;
                    return null;
                } else if (kök.sol==null) {
                    t1=kök.sag;
                    return t1;
                }else if (kök.sag==null) {
                    t1=kök.sol;
                    return t1;
                }else {
                    t1=t2=kök.sag;
                    while (t1.sol!=null){
                        t1=t1.sol;
                    }
                    t1.sol=kök.sol;
                    return t2;
                }
        }else {
                if (data<kök.içerik){
                    kök.sol=delete(kök.sol,data);
                }
                else {
                    kök.sag=delete(kök.sag,data);
                }
        }return kök;
    }
}

public class agaçtan_veri_silme {
    public static void main(String[] args) {
        kelkit k=new kelkit();
        k.kök=k.insert(k.kök,10);
        k.kök=k.insert(k.kök,15);
        k.kök=k.insert(k.kök,8);
        k.kök=k.insert(k.kök,20);
        k.kök=k.insert(k.kök,4);
        k.kök=k.insert(k.kök,12);
        System.out.println("kök:"+k.kök.içerik);
        System.out.println("kök sag:"+k.kök.sag.içerik);
        System.out.println("kök sol:"+k.kök.sol.içerik);
        System.out.print("preorder:");
        k.preorder(k.kök);
        System.out.println();
        System.out.print("inorder:");
        k.inorder(k.kök);
        System.out.println();
        System.out.print("postorder:");
        k.postorder(k.kök);
        System.out.println();
        System.out.println("ağacın yüksekliği:"+k.height(k.kök));
        System.out.println("agaç üzerindeki eleman sayısı:"+k.size(k.kök));
        k.kök=k.delete(k.kök,8);
        k.inorder(k.kök);


    }
}
