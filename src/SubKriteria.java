public class SubKriteria {
    double[][] datamatriks;
    
    public SubKriteria(double[][] matriks){
        this.datamatriks = matriks;
    }
    
    void display(double[] matriks){
        for(double d : matriks){
            System.out.format("%.3f ",d);
        }
        System.out.println("");
    }
    
    public double[] calcJumlahKolom(){
        double[] jumlahkolom = new double[this.datamatriks.length];
        
        int k = 0;
        for(int i = 0;i < this.datamatriks.length; i++){
            double jumlah = 0;
            
            for(int j = 0; j<this.datamatriks.length; j++){
                jumlah += this.datamatriks[j][i];
            }
            
            jumlahkolom[k] = jumlah;
            k++;
        }
        
        return jumlahkolom;
    }
    
    public double[][] normMatriks(double[] jumlahkolom){
        double[][] normalizedmatriks  = new double[this.datamatriks.length][this.datamatriks.length];
        
        for(int i = 0;i < this.datamatriks.length; i++){
            for(int j = 0; j<this.datamatriks.length; j++){
                // System.out.println(this.datamatriks[j][i] + " x " + jumlahkolom[i]);
                normalizedmatriks[j][i] = this.datamatriks[j][i] / jumlahkolom[i];
            }
            
            
        }
        return normalizedmatriks;
        
    }
    
    public double[] calcJumlahBaris(double[][] normalizedmatriks){
        double[] jumlahbaris = new double[normalizedmatriks.length];
        
        int k = 0;
        for(int i = 0;i < normalizedmatriks.length; i++){
            double jumlah = 0;
            
            for(int j = 0; j < normalizedmatriks.length; j++){
                jumlah += normalizedmatriks[i][j];
            }
            
            jumlahbaris[k] = jumlah;
            k++;
        }
        
        return jumlahbaris;
    }
    
    public double[] calcPrioritas(double[] jumlahbaris){
        double[] prioritas = new double[jumlahbaris.length];
        
        for(int i = 0;i < jumlahbaris.length; i++){
            prioritas[i] = jumlahbaris[i] / jumlahbaris.length;
        }
        
        // System.out.println(prioritas[1]);
        
        return prioritas;
    }
    
    public double[] subPrioritas(double[] prioritas, double nilaiMaks) {
        double[] hitungSubKriteria = new double[prioritas.length];
        for (int i = 0; i < hitungSubKriteria.length; i++) {
            hitungSubKriteria[i] = prioritas[i] / nilaiMaks;
        }
        return hitungSubKriteria;
    }




    public double[][] calcMatriksPenjumlahanBaris(double[] prioritas){
        
        double[][] penjumlahanBaris  = new double[this.datamatriks.length][this.datamatriks.length];
        
        for(int i = 0;i < this.datamatriks.length; i++){
            for(int j = 0; j< this.datamatriks.length; j++){
                //                System.out.println("M : " + this.datamatriks[j][i] +" * "+ prioritas[i]);
                penjumlahanBaris[j][i]  =  this.datamatriks[j][i] * prioritas[i];
            }

        }
        return penjumlahanBaris;
    }
    
    public double[] calcPerbandinganRasio(double[] jumlahbaris, double[] prioritas){
        for(int i=0; i<jumlahbaris.length;i++){
            jumlahbaris[i] += prioritas[i]; 
        }
        return jumlahbaris;
    }
    
    public double calcCI() {
        return ((1.296 - 4)) / (4 - 1);
    }
    
    public double calcCR() {
        return ((calcCI()) / 0.90);
    }
    
    
    public void Konsistensi(){
        if (calcCR() < 0.1) {
            System.out.println("'Konsisten'");
        }
        else{
            System.out.println("Tidak Konsisten, Data anda salah");
        }
    }
    
    void display(){
        System.out.print("Hasil CI : ");
        System.out.println(String.format("%.3f", calcCI()));
        System.out.print("Hasil CR : ");
        System.out.println(String.format("%.3f", calcCR()));
    }
    
    //Mencari SubPrioritas
    public double nilaiMaxPrior(double[] prioritas){
        double max = prioritas[0];
        for (int i = 0; i < prioritas.length; i++) {
            if(prioritas[i] > max) {
                max = prioritas[i];
            } 
        }
        System.out.print("Nilai Maksimum adalah ");
        System.out.println(String.format("%.3f", max));
        return max;
        
    }

    
    


    
}
