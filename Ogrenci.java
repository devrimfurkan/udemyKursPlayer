package udemyKursPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public class Ogrenci extends Kisi{

    private ArrayList<Kurs> katildigiKurslar;
    private LinkedList<Ders> izlenecekDErsListesi;

    public Ogrenci(String isim,String tanitimYazisi,String kullaniciAdi){
        super(isim,tanitimYazisi,kullaniciAdi);
        katildigiKurslar=new ArrayList<>();
        izlenecekDErsListesi=new LinkedList<>();
    }

    public void kursaKatil(Kurs javaKursu) {
        if (javaKursu.kursYayinda()){
            javaKursu.getKursOgrencileri().add(this);
            katildigiKurslar.add(javaKursu);
            System.out.println(this.getIsim()+"Kullanıcısı "+javaKursu.getKursAdi()+" isimli kursa katıldı.");
        }else
            System.out.println(javaKursu.getKursAdi()+" Aktif değil katılamazsınız.");
    }

    public LinkedList<Ders> getIzlenecekDErsListesi() {
        return izlenecekDErsListesi;
    }

    public void izlenecekDersEkle(Ders izlenecekDers){
        boolean dersBulundu=false;
        if(katildigiKurslar.size()>0) {
            for (Kurs gecic : katildigiKurslar) {
                if (gecic.getKurstakiDersler().contains(izlenecekDers)) {
                    System.out.println("İzlenecekelr listesine " + gecic.getKursAdi() + " Kursunda Bulunan " + izlenecekDers.getDersBaslik() + " dersi Eklendi.");
                    dersBulundu=true;
                    izlenecekDErsListesi.add(izlenecekDers);
                    break;
                }
            }
            if (!dersBulundu) {
                System.out.println("Girilen Ders kurslarda bulunamadı veya yetkisiz erişim.");
            }
        }
    }

    @Override
    public String toString() {
        return super.toString()+"Ogrenci{" +
                "katildigiKurslar=" + katildigiKurslar +
                '}';
    }
}
