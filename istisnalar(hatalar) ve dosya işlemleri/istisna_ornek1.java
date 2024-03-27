public class istisna_ornek1 {
    public static void main(String[] args) {
        int []sayılar={1,2,3,4};
        System.out.println("başla");
        try {
            int a=5/0;             //0'a bölünme hatası
        for (int i=0;i<=5;i++){
            System.out.println(sayılar[i]);        //dizi boyutunu aştı hatası
        }
        }catch (ArithmeticException e){
            System.out.println("hata:"+e.getLocalizedMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("hata oluştu:"+e.getMessage());
        }
        System.out.println("bitti");
    }
}
