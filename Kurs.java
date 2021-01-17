package udemyKursPlayer;

import java.util.ArrayList;

public class Kurs {
    private String kursAdi;
    private ArrayList<Ders> kurstakiDersler;
    private ArrayList<Egitmen> kursEgitmenleri;
    private ArrayList<Ogrenci> kursOgrencileri;
    private boolean yayinda;

    public Kurs(String kursAdi,Egitmen basEgitmen){
        this.kursAdi=kursAdi;
        this.kurstakiDersler=new ArrayList<>();
        this.kursEgitmenleri=new ArrayList<>();
        this.kursOgrencileri=new ArrayList<>();
        kursEgitmenleri.add(0,basEgitmen);
        this.yayinda=false;
    }

    public ArrayList<Ogrenci> getKursOgrencileri() {
        return kursOgrencileri;
    }

    public ArrayList<Ders> getKurstakiDersler() {
        return kurstakiDersler;
    }

    public String getKursAdi() {
        return kursAdi;
    }

    public void kursEgitmeniEkle(Egitmen yeniEgitmen){
        if(!kursEgitmenleri.contains(yeniEgitmen)){
            kursEgitmenleri.add(yeniEgitmen);
            System.out.println(yeniEgitmen.getIsim()+" Kursa eğitmen olarak eklendi");
        }else
            System.out.println(yeniEgitmen.getIsim()+" zaten kursa tanımlı bir eğitmen.");
    }
    public void kursEgitmeniSil(Egitmen egitmenSil){
        if (egitmenSil.getIsim().equals(kursEgitmenleri.get(0).getIsim())){
            System.out.println("Baş Eğitmen Silinemez!");
        }else{
            kursEgitmenleri.remove(egitmenSil);
            System.out.println(egitmenSil.getIsim()+" Kurs eğitmenliğinden çıkarıldı.");
        }

    }
    public void kursaDersEkle(Ders eklenecekDers){
        kurstakiDersler.add(eklenecekDers);
    }
    public int kurstakiDersSayisi(){
        return kurstakiDersler.size();
    }
    public double kurstakiToplamDerslerinDakikaSuresi(){
        double toplamSure=0;
        for (Ders temp:kurstakiDersler){
            toplamSure=toplamSure+ temp.getDakika();
        }
        return toplamSure;
    }
    public boolean kursYayinda(){
        if (kurstakiDersSayisi()>=5 && kurstakiToplamDerslerinDakikaSuresi()>=60){
            yayinda=true;
            return true;
        }else return false;
    }
}
