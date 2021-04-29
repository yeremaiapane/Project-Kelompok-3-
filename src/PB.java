public class PB {
    int jlhMatriks;
    double[][] matriksBerpasangan;
    
    
    public double [][] inputPerbMatriks(int jumlah, String[] Kriteria){
        double[][] perbMatriksInput = new double[jumlah][jumlah];
        for (int i = 0; i < jumlah; i++) {
            for (int j = 0; j < jumlah; j++) {
                System.out.print(Kriteria[i] + " dengan " + Kriteria[j] + " : ");
            }
        }
        return perbMatriksInput;
    }

    void display(double[][] perbMatriksInput){
        for(double[] d : perbMatriksInput){
            for(double j : d){
                System.out.format("%.3f ",j);
            }
            System.out.println("");
        }
    }
    
    // void display(double[] matriks){
    //     for(double d : matriks){
    //         System.out.format("%.3f ",d);
    //     }
    //     System.out.println("");
    // }


//    public double[][] calcPerbMatriks(double[] Perbandingan, int jumlah){
//        double kriteria[][]  = new double[jumlah][jumlah];
//        int k = 0;
//        for (int i = 0; i < jumlah; i++) {
//            for (int j = i + 1; j < jumlah; j++){
//                if (i == j) {
//                    kriteria[i][j] = 1;
//                }
//                else if (i < j) {
//                    kriteria[i][j] = Perbandingan[k];
//                    k++;
//                } 
//                else if (i > j) {
//                    kriteria[i][j] = 1 / kriteria[j][i];
//                }
//            }            
//        }
//        return kriteria;
//    }

}
