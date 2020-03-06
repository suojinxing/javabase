package lambda;

public class BarcodeTest {
    public static void main(String[] args) {
        String endBarcode = "";
        String beginBarcode = "";
        addBarcode(endBarcode,beginBarcode);
    }

    public static void addBarcode(String endBarcode, String beginBarcode){
        if (endBarcode == null && beginBarcode != null) {
            System.out.println(1);
        } else if (endBarcode != null && beginBarcode == null) {
            System.out.println(2);
        } else if (endBarcode != null) {
            System.out.println(3);
        }
    }


}
