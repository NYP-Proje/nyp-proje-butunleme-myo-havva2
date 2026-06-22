import java.util.ArrayList;
import java.util.List;

public class Main {
    private List<YemekMenusu> hazirMenuListesi = new ArrayList<>();
    private List<Siparis> siparisListesi = new ArrayList<>();
    private List<String> pastaListesi = new ArrayList<>();

    private List<Yemek> dugunAraSicaklar = new ArrayList<>();
    private List<Yemek> dugunAnaYemekler = new ArrayList<>();
    private List<Yemek> dugunTatlilar = new ArrayList<>();

    private List<Yemek> sunnetAperatifler = new ArrayList<>();
    private List<Yemek> sunnetAnaYemekler = new ArrayList<>();
    private List<Yemek> sunnetTatlilar = new ArrayList<>();

    private List<Yemek> nisanAraSicaklar = new ArrayList<>();
    private List<Yemek> nisanAnaYemekler = new ArrayList<>();
    private List<Yemek> nisanTatlilar = new ArrayList<>();

    private List<Yemek> dogumGunuAperatifler = new ArrayList<>();
    private List<Yemek> dogumGunuAnaYemekler = new ArrayList<>();
    private List<Yemek> dogumGunuTatlilar = new ArrayList<>();

    public Main() {
        pastaListesi.add("Çikolatalı Pasta");
        pastaListesi.add("Meyveli Pasta");
        pastaListesi.add("Orman Meyveli Pasta");

        List<String> hazirDugunIcerik = new ArrayList<>();
        hazirDugunIcerik.add("Geleneksel Dana Kavurma");
        hazirDugunIcerik.add("Şehriyeli Pirinç Pilavı");
        hazirDugunIcerik.add("Mevsim Salata");

        List<String> kokteylIcerik = new ArrayList<>();
        kokteylIcerik.add("Mini Burger");
        kokteylIcerik.add("Karışık Sıcak Kanepeler");

        List<String> hazirDogumGunuIcerik = new ArrayList<>();
        hazirDogumGunuIcerik.add("Karışık Pizza Dilimleri");
        hazirDogumGunuIcerik.add("Parmak Patates & Soğan Halkası");
        hazirDogumGunuIcerik.add("Mini Ekler Çeşitleri");

        hazirMenuListesi.add(new YemekMenusu("Düğün Paketi", 450.0, hazirDugunIcerik));
        hazirMenuListesi.add(new YemekMenusu("Kokteyl Menüsü", 250.0, kokteylIcerik));
        hazirMenuListesi.add(new YemekMenusu("Doğum Günü Paketi", 320.0, hazirDogumGunuIcerik));

        dugunAraSicaklar.add(new Yemek("Avcı Böreği", 70.0));
        dugunAraSicaklar.add(new Yemek("Arnavut Ciğeri", 85.0));
        dugunAraSicaklar.add(new Yemek("Paçanga Böreği", 65.0));

        dugunAnaYemekler.add(new Yemek("Fırında Kuzu Tandır", 280.0));
        dugunAnaYemekler.add(new Yemek("Hünkar Beğendi", 260.0));
        dugunAnaYemekler.add(new Yemek("Dana Kavurma", 240.0));

        dugunTatlilar.add(new Yemek("Cevizli Ev Baklavası", 85.0));
        dugunTatlilar.add(new Yemek("Fıstıklı Şöbiyet", 95.0));
        dugunTatlilar.add(new Yemek("Vezir Parmağı", 60.0));

        sunnetAperatifler.add(new Yemek("Çıtır Patates Sepeti", 45.0));
        sunnetAperatifler.add(new Yemek("Sosis & Soğan Halkası İkilisi", 55.0));
        sunnetAperatifler.add(new Yemek("Karışık Atıştırmalık Tabağı", 65.0));

        sunnetAnaYemekler.add(new Yemek("Izgara Kasap Köfte ve Patates", 160.0));
        sunnetAnaYemekler.add(new Yemek("Piliç Nugget ve Pilav", 130.0));
        sunnetAnaYemekler.add(new Yemek("Misket Köfte", 150.0));

        sunnetTatlilar.add(new Yemek("Fırın Sütlaç", 50.0));
        sunnetTatlilar.add(new Yemek("Profiterol", 65.0));
        sunnetTatlilar.add(new Yemek("Supangle", 55.0));

        nisanAraSicaklar.add(new Yemek("Paçanga Böreği", 65.0));
        nisanAraSicaklar.add(new Yemek("Dış Karışık İçli Köfte", 75.0));
        nisanAraSicaklar.add(new Yemek("Fırında Mücver", 55.0));

        nisanAnaYemekler.add(new Yemek("Soslu Biftek", 250.0));
        nisanAnaYemekler.add(new Yemek("Mantarlı Piliç Topkapı", 170.0));
        nisanAnaYemekler.add(new Yemek("Sebzeli Et Güveç", 200.0));

        nisanTatlilar.add(new Yemek("Balkan Trileçesi", 65.0));
        nisanTatlilar.add(new Yemek("Magnolia", 60.0));
        nisanTatlilar.add(new Yemek("Fıstıklı Kadayıf", 80.0));

        dogumGunuAperatifler.add(new Yemek("Mini Karışık Pizza Çubukları", 50.0));
        dogumGunuAperatifler.add(new Yemek("Çıtır Mozzarella Sticks", 60.0));
        dogumGunuAperatifler.add(new Yemek("Nachos ve Peynir Sosu", 55.0));

        dogumGunuAnaYemekler.add(new Yemek("Özel Soslu Cheddarlı Burger", 180.0));
        dogumGunuAnaYemekler.add(new Yemek("Kremalı Mantarlı Tavuk Lokum", 165.0));
        dogumGunuAnaYemekler.add(new Yemek("BBQ Soslu Kanat ve Elma Dilim Patates", 170.0));

        dogumGunuTatlilar.add(new Yemek("Renkli Kremalı Cupcake Üçlüsü", 55.0));
        dogumGunuTatlilar.add(new Yemek("Bol Çikolatalı Mini Waffle", 70.0));
        dogumGunuTatlilar.add(new Yemek("Meyveli Panç & Çilekli Donut", 60.0));
    }

    public List<YemekMenusu> getHazirMenuListesi() { return hazirMenuListesi; }
    public List<Siparis> getSiparisListesi() { return siparisListesi; }
    public List<String> getPastaListesi() { return pastaListesi; }

    public List<Yemek> getDugunAraSicaklar() { return dugunAraSicaklar; }
    public List<Yemek> getDugunAnaYemekler() { return dugunAnaYemekler; }
    public List<Yemek> getDugunTatlilar() { return dugunTatlilar; }

    public List<Yemek> getSunnetAperatifler() { return sunnetAperatifler; }
    public List<Yemek> getSunnetAnaYemekler() { return sunnetAnaYemekler; }
    public List<Yemek> getSunnetTatlilar() { return sunnetTatlilar; }

    public List<Yemek> getNisanAraSicaklar() { return nisanAraSicaklar; }
    public List<Yemek> getNisanAnaYemekler() { return nisanAnaYemekler; }
    public List<Yemek> getNisanTatlilar() { return nisanTatlilar; }

    public List<Yemek> getDogumGunuAperatifler() { return dogumGunuAperatifler; }
    public List<Yemek> getDogumGunuAnaYemekler() { return dogumGunuAnaYemekler; }
    public List<Yemek> getDogumGunuTatlilar() { return dogumGunuTatlilar; }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new Arayuz().setVisible(true);
        });
    }
}