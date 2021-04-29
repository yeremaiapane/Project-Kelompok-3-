public class Kriteria {
    public int jumlahKriteria;
    String namaKriteria;
    String kodeKriteria;
    int nomorKriteria;

    public Kriteria(String namaKriteria, int nomorKriteria, String kodeKriteria) {
        this.namaKriteria = namaKriteria;
        this.nomorKriteria = nomorKriteria;
        this.kodeKriteria = kodeKriteria;
    }

    public void setBanyakKriteria(int jumlahKriteria) {
        this.jumlahKriteria = jumlahKriteria;
    } 
    
    public int getBanyakKriteria() {
        return this.jumlahKriteria;
    }

    void setNamaKriteria(String namaKriteria) {
        this.namaKriteria = namaKriteria;
    }

    void getNamaKriteria() {
        System.out.println("Nama Kriteria " + nomorKriteria + " : " + this.namaKriteria);
    }

    void setKode_Kriteria(String kode_Kriteria) {
        this.kodeKriteria = kode_Kriteria;
    }

    void getKode_Kriteria() {
        System.out.println("Kode Kriteria" + nomorKriteria + " : " + this.kodeKriteria);
    }
    void show(){
        getNamaKriteria();
        getKode_Kriteria();
        
    }

    
}