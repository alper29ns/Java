public class istisna_örenk2 {
    public static void main(String[] args) {
        String str="alper nas";
       try {
        for(int i=0;i<=10;i++){
        System.out.println(str.charAt(i));

        }
       }catch (StringIndexOutOfBoundsException e){
           System.out.println("hata:"+e.getLocalizedMessage());
       }finally {
           System.out.println(3);
       }
    }
}
