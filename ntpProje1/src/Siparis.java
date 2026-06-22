public class Siparis {
    private String musteriAdi;
    private String telefon;
    private String adres;
    private String paketAdi;
    private String detaylar;
    private double hesaplananKisiUcreti;
    private int davetliSayisi;

    public Siparis(String musteriAdi, String telefon, String adres, String paketAdi, String detaylar, double hesaplananKisiUcreti, int davetliSayisi) {
        this.musteriAdi = musteriAdi;
        this.telefon = telefon;
        this.adres = adres;
        this.paketAdi = paketAdi;
        this.detaylar = detaylar;
        this.hesaplananKisiUcreti = hesaplananKisiUcreti;
        this.davetliSayisi = davetliSayisi;
    }

    public String getMusteriAdi() { return musteriAdi; }
    public String getTelefon() { return telefon; }
    public String getAdres() { return adres; }
    public String getPaketAdi() { return paketAdi; }
    public String getDetaylar() { return detaylar; }
    public double getHesaplananKisiUcreti() { return hesaplananKisiUcreti; }
    public int getDavetliSayisi() { return davetliSayisi; }

    public double toplamTutarHesapla() {
        return hesaplananKisiUcreti * davetliSayisi;
    }
}