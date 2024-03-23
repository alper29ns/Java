// agaç yapısına eleman ekleme
class node{
        int içerik;
        node sag,sol;
        public node(int içerik){
            this.içerik=içerik;
            sol=null;sag=null;
        }
}
class Btree{
    node kök;
    public Btree(){
        kök=null;
    }
     node ekle(int data){
        kök=new node(data);
         System.out.println(data+" eleman eklendi");
         return kök;
    }
    node insert(node kök,int data) {
        if (kök != null) {
            if (kök.içerik > data) {
                kök.sol=insert(kök.sol, data);
            }else {
                kök.sag=insert(kök.sag,data);
            }
        }
        else {
            kök=ekle(data);
        }return kök;
    }
}
public class mucit_agaçlar {
    public static void main(String[] args) {
        Btree t=new Btree();
        t.kök=t.insert(t.kök,10);
        t.kök=t.insert(t.kök,15);
        t.kök=t.insert(t.kök,8);
        t.kök=t.insert(t.kök,20);
        t.kök=t.insert(t.kök,4);
        t.kök=t.insert(t.kök,12);
        System.out.println("kök:"+t.kök.içerik);
        System.out.println("kökün sagında:"+t.kök.sag.içerik);
        System.out.println("kökün solunda:"+t.kök.sol.içerik);



    }
}
