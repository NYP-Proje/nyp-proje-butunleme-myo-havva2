public class Yemek {
    private String ad;
    private double fiyat;

    public Yemek(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public String getAd() { return ad; }
    public double getFiyat() { return fiyat; }

    @Override
    public String toString() {
        return ad + " (" + fiyat + " TL)";
    }
}