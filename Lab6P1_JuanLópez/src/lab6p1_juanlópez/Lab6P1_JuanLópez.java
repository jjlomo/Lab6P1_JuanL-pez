/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_juanlópez;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author jjlm1
 */
public class Lab6P1_JuanLópez {
static Scanner leer=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("1. Conjuntos");
        System.out.println("2. Cuantos primos tienes");
        System.out.println("");
        System.out.println("3. Salir");
        System.out.println("INgrese opcion");
        int opcion=leer.nextInt();
        while (opcion<3&&opcion>0){
            switch(opcion){
                case 1:
                    System.out.println("INgrese tamaño del primer arreglo:");
                    int tamaño=leer.nextInt();
                    int [] set1=new int[tamaño];
                    System.out.println("INgrese tamaño del segundo arreglo:");
                    int tamaño1=leer.nextInt();
                    System.out.println("");
                    int [] set2=new int[tamaño1];
                    char [] setchar1=new char[tamaño];
                    char [] setchar2=new char[tamaño];
                    setchar1=Llenadochar(tamaño);
                    System.out.println("Primer conjunto generado:");
                    imprimir(setchar1);
                    System.out.println("");
                    setchar2=Llenadochar(tamaño1);
                    System.out.println("Segundo arreglo generado");
                    imprimir(setchar2);
                    System.out.println("Operaciones disponibles");
                    System.out.println("");
                    System.out.println("1. Intersección");
                    System.out.println("2. Diferencia");
                    
                    int operacion=leer.nextInt();
                    if (operacion<3&&operacion>0)
                        switch (operacion){
                            case 1:
                                int mayor;
                                int menor;
                            if (setchar1.length>=setchar2.length){
                                mayor=setchar1.length;
                                menor=setchar2.length;
                                char[]interseccion=interseccion(menor,setchar2,mayor,setchar1);
                                System.out.println("Intersección");
                                imprimirinter(interseccion);
                            }else{
                                mayor=setchar2.length;
                                menor=setchar1.length;
                                char[]interseccion=interseccion(menor,setchar1,mayor,setchar2);
                                System.out.println("Interseccion");
                                imprimirinter(interseccion);
                            }
                            
                                break;
                            case 2:
                                
                                char[]diferencia=diferencia(setchar1,setchar2);
                                    System.out.println("Diferencia");
                                imprimirinter(diferencia);
                            
                                break;
                        }
                    break;
//                    FIN DEL PROBLEMA 1
                case 2:
                    System.out.println("INgrese tamaño del arreglo:");
                    int largo=leer.nextInt();
                    System.out.println("Ingresar minimo:");
                    int min=leer.nextInt();
                    System.out.println("Ingresar máximo:");
                    int max=leer.nextInt();
                    if(max>min&&largo>1){
                    int []arreglo=arreglo(largo,min,max);
                    imprimir(arreglo);
                    arreglo=arreglo(arreglo);
                    imprimir(arreglo);
                    }else{
                        System.out.println("No ingresó valores válidos");
                        System.out.println("");
                    }
                    
                    break;
            }
            //                    FIN DEL PROBLEMA 2
            System.out.println("1. Conjuntos");
        System.out.println("2. Cuantos primos tienes");
        System.out.println("");
            System.out.println("3. Salir");
        System.out.println("INgrese opcion");
        opcion=leer.nextInt();
        }
        
    }
    public static char[] Llenadochar(int tamaño){
        int [] set1=new int[tamaño];
        char [] set2=new char[tamaño];
        for (int i=0;i<set1.length;i++){
                        set1[i]=new Random().nextInt(25-0)+65;
                        int num=set1[i];
                        char x=(char)num;
                        set2[i]=x;
                    }
        return set2;
    }
    public static void imprimir(char []set1){
        for (int i=0;i<set1.length;i++){
            if(set1[i]!=0){            
            System.out.print("[ "+set1[i]+" ]");
                    }
        }
        System.out.println("");
        System.out.println("");
    }
    public static void imprimirinter(char []set1){
       
        for (int i=0;i<set1.length;i++){
            if(set1[i]!=0){            
            System.out.print("[ "+set1[i]+" ]");
        }
        }
        System.out.println("");
        System.out.println("");
    }
    
    public static char[]interseccion(int menor, char[] setmenor,int mayor,char[]setmayor){
         char[]interseccion=new char[menor];
             for (int i =0;i<menor;i++){
                  for(int j=0;j<mayor;j++){
                      if(setmenor[i]==setmayor[j]){
                          interseccion[i]=setmenor[i];
                      }
                  }
             }
        
        return interseccion;
}
    public static char[]diferencia( char[] set1,char[]set2){
        int control=0;     
        char[]diferencia=new char[set1.length];
             for (int i =0;i<set1.length;i++){
                 control=0;
                 for(int j=0;j<set2.length;j++){
                      if(set1[i]==set2[j]){
                          control++;
                      }
                  }
                  if(control==0){
                          diferencia[i]=set1[i];
                  }
                  }
             
             
        
        return diferencia;
}
//    FIN METODOS DEL EJERCICIO 1
    
    public static int[] arreglo(int size, int min, int max){
        int [] arreglo=new int [size];
        for (int i=0;i<arreglo.length;i++){
            arreglo[i]=new Random().nextInt((max-min)+1)+min;
        }
        return arreglo;
    }
    public static void imprimir(int []set1){
        for (int i=0;i<set1.length;i++){
            System.out.print("[ "+set1[i]+" ]");
        }
        System.out.println("");
        System.out.println("");
}
    public static boolean primo(int numero){
        
        boolean primo;
                int contdiv;
                contdiv=1;
                int contquo;
                contquo=0;
                int divisores;
                divisores=0;
                while (contdiv<=numero){
                contquo=numero%contdiv;
                
                if (contquo==0){
                    divisores=divisores+1; 
                }
                contdiv=1+contdiv;
        }
                if (divisores==2){
                    return primo=true;
                }else{
                return primo=false;
                }
    }
    public static int contarprimos(int num){
        int contp=0;
        for (int i=1;i<=num;i++){
        if(num%i==0){
            boolean primo=primo(i);
        if (primo==true){
            contp++;
        }
        }
    }
        return contp;
    }
    public static int[] arreglo(int[] arreglo){
        int [] arregloprim=new int [arreglo.length];
        for (int i=0;i<arregloprim.length;i++){
            int num=arreglo[i];
            int primos=contarprimos(num);
            arregloprim[i]=primos;
        }
        return arregloprim;
    }
//    FIN METODOS PROBLEMA 2
}