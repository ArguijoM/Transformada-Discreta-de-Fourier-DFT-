/*
    Generar graficos insertando nuevos valores
    Desarrollado por: Harold Cupitra Hernandez
    13/septiembre/2018
 */
package TDF;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.math.plot.Plot2DPanel;
/**
 *  
 * @author hacu
 */
public class GraficaDiscreta {
    private double N1;//intervalo
    private double N2;//intervalo
    private double[] C;//coeficiente de la función
    
    //Objetos de la vista
    private JTextField funcion,serie;
    private ArrayList list;
    private JButton btnGraficar;
    
    //Objeto que permite graficar
    private Plot2DPanel plot = new Plot2DPanel();
 
    public GraficaDiscreta(double[] c, int n1, int n2){
        this.N1=n1;
        this.N2=n2;
        this.C=c;
        //instancia a los elementos graficos
        funcion = new JTextField(1);
        serie = new JTextField(1);
        btnGraficar = new JButton("Mostrar");

        //Generar Ventana
        JFrame frame =  new JFrame("Grafica de tiempo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.add(construirPanelPrincipal());
        frame.setVisible(true);
        
        //Generar las graficas de las funciones
        btnGraficar.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent ae) {
                double[] arrayXk,arrayYk;
                for(int i=0;i<C.length;i++){               
                    arrayXk = new double[]{i,0};
                    arrayYk = new double[]{i,C[i]};
                    plot.addLinePlot("Funcion",Color.GREEN,arrayXk, arrayYk); 
                    plot.addScatterPlot("Funcion",Color.GREEN,arrayXk, arrayYk);
                }
            }
                
        });
    }
   

    //generar el conteido de la ventana
    private JPanel construirPanelPrincipal(){
        JPanel pPrincipal = new JPanel();
        pPrincipal.setLayout(new BorderLayout());
        pPrincipal.add(plot,BorderLayout.CENTER);
        pPrincipal.add(contruirPanelSur(),BorderLayout.SOUTH);
        return pPrincipal;
    }
    
    private JPanel contruirPanelSur(){
        JPanel pSur = new JPanel();
        serie.setBackground(Color.GREEN);
        pSur.add(new JLabel("f(n): "));
        pSur.add(serie);
        pSur.add(btnGraficar);
        return pSur;
    }
    
    public static void main(String[] args) {
//        Complejo m1 = new Complejo(0,0);
//        Complejo m2 = new Complejo(0,4);
//        Complejo m3 = new Complejo(0,0);
//        Complejo m4 = new Complejo(0,-2);
//        Complejo[] m5 = new Complejo[]{m1,m2,m3,m4};
//        GraficaTDF m = new GraficaTDF(m5,0,4);
//        
//        Complejo c1 = new Complejo(0,0);
//        Complejo c2 = new Complejo(Math.PI/4,Math.sin(Math.PI/4));
//        Complejo c3 = new Complejo(Math.PI/2,Math.sin(Math.PI/2));
//        Complejo c4 = new Complejo(3*Math.PI/4,Math.sin(3*Math.PI/4));
//        Complejo c5 = new Complejo(Math.PI,Math.sin(Math.PI));
//        Complejo c6 = new Complejo(5*Math.PI/4,Math.sin(5*Math.PI/4));
//        Complejo[] c7 = new Complejo[]{c1,c2,c3,c4,c5,c6};
//       GraficaTDF g1 = new GraficaTDF(c7,0,4);
   }   
}