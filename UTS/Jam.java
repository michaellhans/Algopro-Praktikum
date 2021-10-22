// NIM      : 13518056
// Nama     : Michael Hans
// Tanggal  : Jumat, 15 Oktober 2021
// Topik    : UTS Praktikum Jam
// Deskripsi: Implementasi Kelas Jam

public class Jam {
    private int JJ;
    private int MM;
    private int DD;
    private int Zona;

    public Jam(int JJ, int MM, int DD, int Zona) {
        this.JJ = JJ;
        this.MM = MM;
        this.DD = DD;
        this.Zona = Zona;
    }

    public void setJJ(int jJ) {
        JJ = jJ;
    }

    public void setMM(int mM) {
        MM = mM;
    }

    public void setDD(int dD) {
        DD = dD;
    }

    public void setZona(int zona) {
        Zona = zona;
    }

    public int getJJ() {
        return JJ;
    }

    public int getMM() {
        return MM;
    }

    public int getDD() {
        return DD;
    }

    public int getZona() {
        return Zona;
    }

}
