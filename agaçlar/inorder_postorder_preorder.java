class sınıf{
    int data;
    sınıf sol,sag;
    public sınıf(int data){
        this.data=data;
        sol=null;sag=null;
    }
}
class Nod{
    sınıf root;
    public Nod(){
        root=null;
    }
    sınıf ekle(int data){
        root=new sınıf(data);
        System.out.println(" eklendi");
        return root;
    }
    sınıf insert(sınıf root,int data){
        if (root!=null){
            if (root.data>data){
                root.sol=insert(root.sol,data);
            } else {
                root.sag=insert(root.sag,data);
            }
        }else
            root=ekle(data);
        return root;
    }
    public void preorder(sınıf root){
        if (root!=null){
            System.out.println(root.data+" ");
            preorder(root.sol);
            preorder(root.sag);
        }
    }
    public void inorder(sınıf root){
        if (root!=null){
            preorder(root.sol);
            System.out.print(root.data+" ");
            preorder(root.sag);
        }
    }
    public void postorder(sınıf root){
        if (root!=null){
            preorder(root.sol);
            preorder(root.sag);
            System.out.print(root.data+" ");
        }
    }
}
public class inorder_postorder_preorder {
    public static void main(String[] args) {
        Nod n=new Nod();
        n.root=n.insert(n.root,3);
        n.root=n.insert(n.root,2);
        n.root=n.insert(n.root,1);
        n.root=n.insert(n.root,4);
        n.root=n.insert(n.root,5);
        n.preorder(n.root);
        n.inorder(n.root);
    }
}
