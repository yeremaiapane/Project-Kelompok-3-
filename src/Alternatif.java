import java.util.Arrays;
import java.util.Collections;
public class Alternatif {
    String nim;
    String nama;
    Kriteria[] kriteria;
    SubKriteria[] subkriteria;
    float hasilAhir = 0f;
    int IPK; 
    int JumlahPenghasilanOrtu; 
    int JumlahTanggunganOrtu; 
    int semester; 
    public Alternatif(String nama,int IPK, int JumlahPenghasilanOrtu, int JumlahTanggunganOrtu, int semester){
        this.nama = nama;
        this.IPK = IPK;
        this.JumlahTanggunganOrtu = JumlahTanggunganOrtu;
        this.JumlahPenghasilanOrtu = JumlahPenghasilanOrtu;
        this.semester = semester;
    }

    public void setName(String nama) {
        nama = this.nama;
    }

    void getName() {
        System.out.println("Nama : " + this.nama);
    }

    public void setIPK(int iPK) {
        IPK = this.IPK;
    }

    void getIPK() {
        System.out.println("Nilai Prioritas IPK = " + (this.IPK));
    }

    public void setJumlahPenghasilanOrtu(int JumlahPenghasilanOrtu) {
        JumlahPenghasilanOrtu = this.JumlahPenghasilanOrtu;
    }

    void getJumlahPenghasilanOrtu() {
        System.out.println("Nilai Prioritas JumlahPenghasilanOrtu = " + (this.JumlahPenghasilanOrtu));
    }
    public void setJumlahTanggunganOrtu(int JumlahTanggunganOrtu) {
        JumlahTanggunganOrtu = this.JumlahTanggunganOrtu;
    }

    void getJumlahTanggunganOrtu() {
        System.out.println("Nilai Prioritas JumlahTanggunganOrtu = " + (this.JumlahTanggunganOrtu));
    }
    public void setsemester(int semester) {
        semester = this.semester;
    }

    void getSemester() {
        System.out.println("Nilai Prioritas Semester = " + (this.semester));
    }

    void display() {
        System.out.println("Urutan Sesuai dengan Tabel \n");
        getName();
        getIPK();
        getJumlahPenghasilanOrtu();
        getJumlahTanggunganOrtu();
        getSemester();
        
    }
    
    void display(double[] Alternatif){
        for(double d : Alternatif){
            System.out.format("%.3f ",d);
        }
        System.out.println("");
    }

    public double[] AlternatifK1(double [] prioritas, double [] hitungSubKriteria){
        double[] K1 = new double[this.IPK - (this.IPK - 1)];
        for (int i = 0; i < K1.length; i++) {
            K1[i] = hitungSubKriteria [this.IPK - 1]* prioritas[0];
        }
        return K1;
    }   

    public double[] AlternatifK2(double [] prioritas, double [] hitungSubKriteria){
        double[] K2 = new double[this.JumlahPenghasilanOrtu - (this.JumlahPenghasilanOrtu - 1)];
        for (int i = 0; i < K2.length; i++) {
            K2[i] = hitungSubKriteria [this.JumlahPenghasilanOrtu - 1] * prioritas[1];
        }
         return K2;
    }   

    public double[] AlternatifK3(double [] prioritas, double [] hitungSubKriteria){
        double[] K3 = new double[this.JumlahTanggunganOrtu - (this.JumlahTanggunganOrtu - 1)];
        for (int i = 0; i < K3.length; i++) {
            K3[0] = hitungSubKriteria[this.JumlahTanggunganOrtu -1] * prioritas[2];
        }
         return K3;
    }  
     
    public double[] AlternatifK4(double [] prioritas, double [] hitungSubKriteria){
        double[] K4 = new double[this.semester - (this.semester - 1)];
        for (int i = 0; i < K4.length; i++) {
            K4[0] = hitungSubKriteria[this.semester - 1] * prioritas[3];
        }
         return K4;
    }   

    public double totalAlternatif(double[] K1, double[] K2, double[] K3, double[] K4){
        double total = 0;
        for (int i = 0; i < 1; i++) {
            total = K1[i] + K2[i] + K3[i] + K4[i];
        }
        return total;
    }
    // }
    public Double[] sort (double totalA, double totalM, double totalJ){
        Double[] UL = new Double[3];
        UL [0] =  totalA;
        UL [1] =  totalM;
        UL [2] =  totalJ;
        Arrays.sort(UL, Collections.reverseOrder());
        return UL;
    }
}
