/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDF;

/**
 *
 * @author manuel
 */
public class TDF {
    double[] Xn;//función principal
    Complejo[] Xk;//Transformada discreta de Fourier
    double fun;//valor de la función dentro del intérvalo
    int N1;//Limite inferior del intérvalo
    int N2;//Limite superior del intérvalo
    int dim;//Dimensión de los arreglos

    public TDF(int N1, int N2) {
        this.N1= N1;
        this.N2= N2;
        this.dim = N2-N1;
        this.Xn = new double[dim];
        this.Xk = new Complejo[dim];     
    }
     public TDF(){
         
     }


    public int getN1() {
        return N1;
    }

    public int getN2() {
        return N2;
    }

    public void setN1(int N1) {
        this.N1 = N1;
    }

    public void setN2(int N2) {
        this.N2 = N2;
    }

    public double[] getXn() {
        return Xn;
    }

    public void setXn(double[] Xn) {
        this.Xn = Xn;
    }

    public Complejo[] getXk() {
        return Xk;
    }

    public void setXk(Complejo[] Xk) {
        this.Xk = Xk;
    }

    //Rellenar el arreglo función
//    public void rellenarXn(){
//        for(int i=0;i<dim;i++){
//            Xn[i] = Math.pow(0.5,i);
//        }
//    }
    public void rellenarSenoXn(){
        double ang=0, part = 2*Math.PI/dim;
        for(int i=0;i<dim;i++){
            Xn[i] = Math.sin(ang);
            ang = ang + part;
        }
    }
    //Función principal que llenará el arreglo solución
    public void serieDiscreta(){
        for(int k=0;k<dim;k++){
            Xk[k] = calcularSerie(k);
        }
        
    }
    //Función que realizará la TDF al arreglo función 
    public Complejo calcularSerie(int k){
        double w,m;
        double re=0,im=0;
        Complejo c= new Complejo(0,0);
        for(int n=0;n<dim;n++){
            m=2*Math.PI/dim;
            w = -m*k*n; 
            re += Xn[n]*Math.cos(w);
            im += Xn[n]*Math.sin(w); 
        }
        c.setReal(re);
        c.setImaginario(im);
        return c;
    }
     public void rellenarXn(String aux){
         String[] xn;
         xn=aux.split("\\,");
         for(int i=0;i<xn.length;i++){
             Xn[i] = Double.parseDouble(xn[i]);
         }
    }
    
     public static void main(String[] args) {
        TDF t1 = new TDF(0,8);//Funciín || Intérvalo inferior || Intérvalo superior
        t1.serieDiscreta();
        for(int i=0;i<t1.getXn().length;i++){
            System.out.println(t1.getXk()[i].getReal()+"\n");
        }
        GraficaTDF g1= new GraficaTDF(t1.getXk(),0,8);
        GraficaDiscreta g2= new GraficaDiscreta(t1.getXn(),0,8);
    }
   
}
