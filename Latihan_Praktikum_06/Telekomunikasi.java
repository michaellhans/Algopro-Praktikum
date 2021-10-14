// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Kamis, 14 Oktober 2021
// Topik    : Latihan Praktikum 06 No 3
// Deskripsi: Telekomunikasi

import java.util.Scanner;

abstract class Provider {
    protected int jenis;
    protected double rate;
    protected double durasi;

    public double getDurasi() {
        return durasi;
    }

    public double getRate() {
        return rate;
    }

    public int getJenis() {
        return jenis;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public abstract double hitung_hargaTotal();

    public void print_info() {
        System.out.print("Jenis " + jenis + " ");
        System.out.print("rate " + String.format("%.1f", rate) + " ");
        System.out.println("durasi " + String.format("%.1f", durasi));
    }
}

class Handphone extends Provider {
    private double saldo;

    public Handphone() {
        this.jenis = 0;
        this.durasi = 0;
        this.rate = 0;
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public double hitung_hargaTotal() {
        return rate * durasi;
    }

    public float hitung_durasiMax() {
        if (jenis == 1) {
            return (float) (saldo / rate);
        } else {
            return 0;
        }
    }
}

public class Telekomunikasi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Handphone hp = new Handphone();
        int jenis = sc.nextInt();
        double rate = sc.nextDouble();

        hp.setJenis(jenis);
        hp.setRate(rate);

        double saldo;
        if (jenis == 1) {
            saldo = sc.nextDouble();
            hp.setSaldo(saldo);
        }

        double durasi = sc.nextDouble();
        hp.setDurasi(durasi);
        if (jenis == 1) {
            float durasiMax = hp.hitung_durasiMax();
            if (durasi > durasiMax) {
                System.out.println("durasi Max adalah " + String.format("%.1f", durasiMax) + " menit");
            } else {
                System.out.println(hp.hitung_hargaTotal());
                hp.print_info();
            }

        } else {
            System.out.println(hp.hitung_hargaTotal());
            hp.print_info();
        }

        sc.close();
    }

}
