package udemyKursPlayer;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ogrenci ogr1=new Ogrenci("ali","alinin tanıtım yazısı","ali_udemy");
        Egitmen emre=new Egitmen("emre","emre java","emre1234");
        Egitmen deneme=new Egitmen("deneme","deneme java","deneme_udemy");
        System.out.println(ogr1);
        System.out.println(emre);

        Ders d1=new Ders(1,"giris",3.5);
        Ders d2=new Ders(2,"java nedir",9.5);
        Ders d3=new Ders(3,"primitive",22.9);
        Ders d4=new Ders(4,"Diziler",15.9);
        Ders d5=new Ders(5,"Methodlar",15.9);

        Kurs javaKursu=new Kurs("Java",emre);
        javaKursu.kursaDersEkle(d1);
        javaKursu.kursaDersEkle(d2);
        javaKursu.kursaDersEkle(d3);
        javaKursu.kursaDersEkle(d4);
        javaKursu.kursaDersEkle(d5);
        javaKursu.kursEgitmeniEkle(deneme);
        javaKursu.kursEgitmeniSil(deneme);

        ogr1.kursaKatil(javaKursu);
        ogr1.izlenecekDersEkle(d1);
        ogr1.izlenecekDersEkle(d2);
        ogr1.izlenecekDersEkle(d3);
        ogr1.izlenecekDersEkle(d4);

        listeyiOynat(ogr1.getIzlenecekDErsListesi());
    }
    public static void listeyiOynat (LinkedList<Ders> izlenecekDersler){
        Scanner tara=new Scanner(System.in);
        boolean cıkıs=false;
        boolean ileriDogruHareket=true;
        ListIterator<Ders> iterator=izlenecekDersler.listIterator();
        if(izlenecekDersler.size()==0){
            System.out.println("Henüz Ders Eklenmemiş.");
        }else {
            Ders ilkDers=iterator.next();
            System.out.println("Şuan izlenen ders "+ilkDers.getDersBaslik()+" süre: "+ilkDers.getDakika());
        }
        menuGoster();
        while (!cıkıs){
            System.out.println("İşleminizi Seçiniz.");
            int kullaniciSecimi= tara.nextInt();
            switch (kullaniciSecimi){
                case 0:
                    System.out.println("Uygulamadan çıkılıyor...");
                    cıkıs=true;
                    break;
                case 1:
                    if (!ileriDogruHareket){
                        ileriDogruHareket=true;
                        if (iterator.hasNext()){
                            iterator.next();
                        }
                    }
                    if (iterator.hasNext()){
                    Ders ilkDers= iterator.next();
                        System.out.println("====================================================");
                    System.out.println("Ders No "+ilkDers.getDersNo()+" Başlık: "+ilkDers.getDersBaslik()+" süre: "+ilkDers.getDakika());
                        System.out.println("====================================================");
                }else
                        System.out.println("Listenin Sonuna Geldiniz.");
                    break;
                case 2:
                    if (ileriDogruHareket){
                        ileriDogruHareket=false;
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    }
                    if (iterator.hasPrevious()){
                        Ders ilkDers= iterator.previous();
                        System.out.println("====================================================");
                        System.out.println("Ders No "+ilkDers.getDersNo()+" Başlık: "+ilkDers.getDersBaslik()+" süre: "+ilkDers.getDakika());
                        System.out.println("====================================================");
                    }else
                        System.out.println("Listenin Başına Geldiniz.");
                    break;
                case 3:
                    izlenecekDerslerListesi(izlenecekDersler);
                    break;
                case 9:
                    menuGoster();
                    break;
            }
        }

    }

    private static void izlenecekDerslerListesi(LinkedList<Ders> izlenecekDersler) {
    ListIterator<Ders> iterator=izlenecekDersler.listIterator();
    if (izlenecekDersler.size()==0){
        System.out.println("Henüz Ders Eklenmemiş :(");
        return;
    }else {
        while (iterator.hasNext()){
            Ders ilkDers= iterator.next();
            System.out.println("Ders No "+ilkDers.getDersNo()+" Başlık: "+ilkDers.getDersBaslik()+" süre: "+ilkDers.getDakika());
        }
    }

    }

    public static void menuGoster(){
        System.out.println("*******************MENU*************");
        System.out.println("0- çıkış");
        System.out.println("1- Bir Sonraki Derse Git");
        System.out.println("2- Bir Önceki Derse Git");
        System.out.println("3- Tüm Listeyi göster");
        System.out.println("9- Menü");
    }
}
