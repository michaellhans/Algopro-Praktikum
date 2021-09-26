// NIM              : 13518056
// Nama             : Michael Hans
// Tanggal          : Jumat, 17 September 2021
// Topik praktikum  : Praktikum 3 Soal 3
// Deskripsi        : Perpustakaan - Design class Koleksi dan ItemKoleksinya

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
    public Buku() {
        this.id = -999;
        this.judul = "DUMMY";
        this.tahunTerbit = -999;
    }

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

    public Majalah() {
        this.id = -999;
        this.judul = "DUMMY";
        this.bulanTerbit = -99;
        this.tahunTerbit = -999;
    }

    public Majalah(int id, int bulanTerbit, String judul, int tahunTerbit) {
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
    public Proceeding() {
        this.id = -999;
        this.judul = "DUMMY";
        this.tahunTerbit = -999;
    }

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
    private ItemKoleksi[] kumpulanKoleksi;
    private int jumlahSekarang;

    public Koleksi() {
        this.kumpulanKoleksi = new ItemKoleksi[1000];
        this.jumlahSekarang = 0;
    }

    public void AddItem(ItemKoleksi item) {
        this.jumlahSekarang++;
        this.kumpulanKoleksi[this.jumlahSekarang - 1] = item;
    }

    public void Print() {
        for (int i = 0; i < this.jumlahSekarang; i++) {
            this.kumpulanKoleksi[i].PrintInfo();
        }
    }

    public ItemKoleksi[] getKumpulanKoleksi() {
        return this.kumpulanKoleksi;
    }

    public void setKumpulanKoleksi(ItemKoleksi[] koleksi) {
        this.jumlahSekarang = 0;
        for (ItemKoleksi item : koleksi) {
            this.AddItem(item);
        }
    }

    public int getJumlahSekarang() {
        return jumlahSekarang;
    }

    public void setJumlahSekarang(int jumlahSekarang) {
        this.jumlahSekarang = jumlahSekarang;
    }
}
