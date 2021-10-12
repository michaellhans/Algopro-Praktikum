// NIM          : 13518056
// Nama         : Michael Hans
// Tanggal      : Jumat, 8 Oktober 2021
// Topik        : Praktikum 6
// Deskripsi    : Provider dan Handphone

import java.util.Scanner;

abstract class Provider {
    protected int jenis;
    protected double rate;
    protected double durasi;

    public void setJenis(int jenis) {
        this.jenis = jenis;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    public int getJenis() {
        return this.jenis;
    }

    public double getRate() {
        return this.rate;
    }

    public double getDurasi() {
        return this.durasi;
    }

    abstract public double hitung_hargaTotal();

    public void print_info() {
        System.out.print("Jenis " + this.jenis + " ");
        System.out.print("rate " + String.format("%.1f", this.rate) + " ");
        System.out.println("durasi " + String.format("%.1f", this.durasi));
    }
}

class Handphone extends Provider {
    private double saldo;

    public Handphone() {
        this.jenis = 0;
        this.rate = 0;
        this.durasi = 0;
        this.saldo = 0;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public double hitung_hargaTotal() {
        return this.rate * this.durasi;
    }

    public float hitung_durasiMax() {
        if (this.jenis == 1) {
            return (float) (this.saldo / this.rate);
        }
        return 0;
    }

}

public class Telekomunikasi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Handphone hp = new Handphone();
        int jenis = sc.nextInt();
        hp.setJenis(jenis);

        double rate = sc.nextDouble();
        hp.setRate(rate);

        double saldo;
        double durasi;

        if (jenis == 1) {
            saldo = sc.nextDouble();
            hp.setSaldo(saldo);
        }

        durasi = sc.nextDouble();
        hp.setDurasi(durasi);
        if (jenis == 1) {
            double durasi_max = hp.hitung_durasiMax();
            if (durasi > durasi_max) {
                System.out.println("durasi Max adalah " + String.format("%.1f", durasi_max) + " menit");
            } else {
                System.out.println(String.format("%.1f", hp.hitung_hargaTotal()));
                hp.print_info();
            }

        } else {
            System.out.println(String.format("%.1f", hp.hitung_hargaTotal()));
            hp.print_info();
        }

        sc.close();
    }
}
