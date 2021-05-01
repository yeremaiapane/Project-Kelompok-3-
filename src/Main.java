public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=====================================================");
        System.out.println("\tProgram Pendukung Keputusan Beasiswa");
        System.out.println("\t\tMenggunakan Metode AHP");
        System.out.println("=====================================================");

        Kriteria objKriteria = new Kriteria("IPK", 1, "K1");
        Kriteria objKriteria2 = new Kriteria("Jumlah Penghasilan Orang Tua", 2, "K2");
        Kriteria objKriteria3 = new Kriteria("Jumlah Tanggungan Orang Tua", 3, "K3");
        Kriteria objKriteria4 = new Kriteria("Semester", 4, "K4");
        int jumlahKriteria = 4;
        objKriteria.show();
        objKriteria2.show();
        objKriteria3.show();    
        objKriteria4.show();
        

        PB perbandinganMatriks = new PB();
        
        double[][] perbMatriksInput = new double[jumlahKriteria][jumlahKriteria];
        
        perbMatriksInput[0][0] = 1;
        perbMatriksInput[0][1] = 3;
        perbMatriksInput[0][2] = 5;
        perbMatriksInput[0][3] = 7;
        
        perbMatriksInput[1][0] = 0.333;
        perbMatriksInput[1][1] = 1;
        perbMatriksInput[1][2] = 3;
        perbMatriksInput[1][3] = 5;
        
        perbMatriksInput[2][0] = 0.2;
        perbMatriksInput[2][1] = 0.333;
        perbMatriksInput[2][2] = 1;
        perbMatriksInput[2][3] = 5;
        
        perbMatriksInput[3][0] = 0.143;
        perbMatriksInput[3][1] = 0.2;
        perbMatriksInput[3][2] = 0.2;
        perbMatriksInput[3][3] = 1;

        
        System.out.println("\nMatriks yang di-Input : ");
        perbandinganMatriks.display(perbMatriksInput);
    
        
        SubKriteria sub = new SubKriteria(perbMatriksInput);
        
        System.out.println("\nJumlah dari masing-masing Kolom : ");
        double[] jumlahkolom = sub.calcJumlahKolom();
        sub.display(jumlahkolom);

        
        System.out.println("\nSubKriteria Matriks : ");
        double[][] matriksnormalisasi = sub.normMatriks(jumlahkolom);
        perbandinganMatriks.display(matriksnormalisasi);
        
        
        System.out.println("\nJumlah dari masing-masing Baris : ");
        double[] jumlahbaris = sub.calcJumlahBaris(matriksnormalisasi);
        sub.display(jumlahbaris);
        
        
        System.out.println("\nPrioritasnya adalah : ");
        double[] prioritas = sub.calcPrioritas(jumlahbaris);
        sub.display(prioritas);
        
        
        System.out.println("\nMatriks Penjumlahan setiap Baris adalah : ");
        double[][] matrikspenjumlahanbaris = sub.calcMatriksPenjumlahanBaris(prioritas);
        perbandinganMatriks.display(matrikspenjumlahanbaris);
        
        
        System.out.println("\nJumlah Baris dari Matriks Penjumlahan setiap Baris adalah : ");
        double[] jumlahmatrikspnjmlhbaris = sub.calcJumlahBaris(matrikspenjumlahanbaris);
        sub.display(jumlahmatrikspnjmlhbaris);
        
        System.out.println("\nmax prioritas");
        double nilaiMaks = sub.nilaiMaxPrior(prioritas);
        
        System.out.println("Nilai Sub Kriteria ");
        double[] hitungSubKriteria = sub.subPrioritas(prioritas, nilaiMaks);
        sub.display(hitungSubKriteria);

        System.out.println("\nPerbandingan Rasio Konsistensi : ");
        double[] perrasiokonsistensi = sub.calcPerbandinganRasio(jumlahmatrikspnjmlhbaris,prioritas);
        sub.display(perrasiokonsistensi);

        System.out.println("\nKonsistensi Rasio adalah : ");
        sub.display();
        sub.Konsistensi();


        System.out.println("\n======================================");
        System.out.println("\tData Penerima Beasiswa");
        System.out.println("======================================");
        
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Nama    | IPK        | Jlh Penghasilan OrangTua  | Jlh Tanggungan OrangTua   | Semester");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Aceng\t    4.00\t< 1.500.000\t\t\t 3\t\t\t6");
        System.out.println("Mahmud\t  3.00-3.50\t> 3.000.000\t\t\t<=2\t\t\t5");
        System.out.println("Jamal\t  3.00-3.50\t< 1.500.000\t\t\t<=3\t\t\t4");

        Alternatif Aceng = new Alternatif("Aceng",1, 1, 3, 4);
        Alternatif Mahmud = new Alternatif("Mahmud",3, 3, 4, 3);
        Alternatif Jamal = new Alternatif("Jamal",3, 1, 4, 2);
        System.out.println("\n");
        Aceng.display();
        Mahmud.display();
        Jamal.display();

        System.out.println("\nAceng");
        
        double[] AlternatifK1 = Aceng.AlternatifK1(prioritas ,hitungSubKriteria);
        Aceng.display(AlternatifK1);
        
        double[] AlternatifK2 = Aceng.AlternatifK2(prioritas ,hitungSubKriteria);
        Aceng.display(AlternatifK2);
        
        double[] AlternatifK3 = Aceng.AlternatifK3(prioritas ,hitungSubKriteria);
        Aceng.display(AlternatifK3);
        
        double[] AlternatifK4 = Aceng.AlternatifK4(prioritas ,hitungSubKriteria);
        Aceng.display(AlternatifK4);

        System.out.println("\nMahmud");
        double[] AlternatifK1M = Mahmud.AlternatifK1(prioritas ,hitungSubKriteria);
        Mahmud.display(AlternatifK1M);
        
        double[] AlternatifK2M = Mahmud.AlternatifK2(prioritas ,hitungSubKriteria);
        Mahmud.display(AlternatifK2M);
        
        double[] AlternatifK3M = Mahmud.AlternatifK3(prioritas ,hitungSubKriteria);
        Mahmud.display(AlternatifK3M);
        
        double[] AlternatifK4M = Mahmud.AlternatifK4(prioritas ,hitungSubKriteria);
        Mahmud.display(AlternatifK4M);
        
        System.out.println("\nJamal");
        
        double[] AlternatifK1J = Jamal.AlternatifK1(prioritas ,hitungSubKriteria);
        Jamal.display(AlternatifK1J);
        
        double[] AlternatifK2J = Jamal.AlternatifK2(prioritas ,hitungSubKriteria);
        Jamal.display(AlternatifK2J);
        
        double[] AlternatifK3J = Jamal.AlternatifK3(prioritas ,hitungSubKriteria);
        Jamal.display(AlternatifK3J);
        
        double[] AlternatifK4J = Jamal.AlternatifK4(prioritas ,hitungSubKriteria);
        Jamal.display(AlternatifK4J);
        
        System.out.println("\nHasil Akhir");
        System.out.print("Aceng  : ");
        double totalA = Aceng.totalAlternatif(AlternatifK1, AlternatifK2, AlternatifK3, AlternatifK4);
        System.out.format("%.3f ",totalA);
        System.out.print("\nMahmud : ");
        double totalM = Mahmud.totalAlternatif(AlternatifK1M, AlternatifK2M, AlternatifK3M, AlternatifK4M);
        System.out.format("%.3f ",totalM);
        System.out.print("\nJamal  : ");
        double totalJ = Jamal.totalAlternatif(AlternatifK1J, AlternatifK2J, AlternatifK3J, AlternatifK4J);
        System.out.format("%.3f ",totalJ);

        System.out.println("\n\nHasil Pengurutan");
        Double[] sorted = Aceng.sort(totalA, totalJ, totalM);
        System.out.format("Aceng   : %.3f",sorted[0]);
        System.out.format("\nJamal   : %.3f",sorted[1]);
        System.out.format("\nMahmud  : %.3f",sorted[2]);
        
    }


    
}