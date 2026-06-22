import java.util.List;

public class YemekMenusu {
    private String menuAdi;
    private double kisiUcreti;
    private List<String> yemekIcerigi;

    public YemekMenusu(String menuAdi, double kisiUcreti, List<String> yemekIcerigi) {
        this.menuAdi = menuAdi;
        this.kisiUcreti = kisiUcreti;
        this.yemekIcerigi = yemekIcerigi;
    }

    public String getMenuAdi() { return menuAdi; }
    public double getKisiUcreti() { return kisiUcreti; }

    // Arayuz.java'da küçük 'ı' harfiyle çağrıldığı için metoda bu ismi verdik
    public List<String> getYemekİcerigi() { return yemekIcerigi; }
}