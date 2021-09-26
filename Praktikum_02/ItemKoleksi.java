// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 10 September 2021
// Topik praktikum  : Perpustakaan
// Deskripsi        : Design class Koleksi dan ItemKoleksinya

import java.util.ArrayList;

abstract class ItemKoleksi {
    protected int id;
    protected String judul;
    protected int tahunTerbit;

    abstract int HitungBiayaPeminjaman(int lamaPinjam);

    abstract void PrintInfo();

    public int getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
}

class Buku extends ItemKoleksi {
    public Buku(int id, String judul, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    int HitungBiayaPeminjaman(int lamaPinjam) {
        return 500 * lamaPinjam;
    }

    @Override
    void PrintInfo() {
        System.out.println(id + ";" + judul + ";" + tahunTerbit);
    }
}

class Majalah extends ItemKoleksi {
    private int bulanTerbit;

    public Majalah(int id, String judul, int bulanTerbit, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.bulanTerbit = bulanTerbit;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    int HitungBiayaPeminjaman(int lamaPinjam) {
        return lamaPinjam * 1500 * (tahunTerbit + 1) / tahunTerbit;
    }

    @Override
    void PrintInfo() {
        System.out.println(id + ";" + judul + ";" + bulanTerbit + ";" + tahunTerbit);
    }

    public int getBulanTerbit() {
        return bulanTerbit;
    }

    public void setBulanTerbit(int bulanTerbit) {
        this.bulanTerbit = bulanTerbit;
    }
}

class Proceeding extends ItemKoleksi {
    public Proceeding(int id, String judul, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    int HitungBiayaPeminjaman(int lamaPinjam) {
        return 5000;
    }

    @Override
    void PrintInfo() {
        System.out.println(id + ";" + judul + ";" + tahunTerbit);
    }

}

class Koleksi {
    private ArrayList<ItemKoleksi> kumpulanKoleksi;
    private int jumlahSekarang;

    public Koleksi() {
        this.kumpulanKoleksi = new ArrayList<ItemKoleksi>();
        this.jumlahSekarang = 0;
    }

    public void AddItem(ItemKoleksi item) {
        this.kumpulanKoleksi.add(item);
    }

    public void Print() {
        for (ItemKoleksi item : kumpulanKoleksi) {
            item.PrintInfo();
        }
    }

    public int getJumlahSekarang() {
        return jumlahSekarang;
    }

    public void setJumlahSekarang(int jumlahSekarang) {
        this.jumlahSekarang = jumlahSekarang;
    }
}
