/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package lab6p1_junniorsauceda;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Junnior Sauceda
 */
public class Lab6P1_JunniorSauceda {
static Scanner sc=new Scanner (System.in);
static Random ran= new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean seguir=true;
        do{
        System.out.println("MENU");
        System.out.println("1.-¿Cuántos primos tienes?");
        System.out.println("2.-Frecuencia de letras");
        System.out.println("3.-Salir");
        int opcion=sc.nextInt();
        switch(opcion){
            case 1:{
                System.out.println("Ingrese el tamaño del ingreso a generar: ");
                int size=sc.nextInt();
                while(size<1){
                    System.out.println("Ingrese un tamaño mayor o 1gual a 1");
                    size=sc.nextInt();
                }
                System.out.println("Ingrese el limite inferior: ");
                int min=sc.nextInt();
                while(min<1){
                    System.out.println("Ingrese un numero positivo");
                    min=sc.nextInt();
                }
                System.out.println("Ingrese el limite superior: ");
                int max=sc.nextInt();
                while(max<=min){
                    System.out.println("El limite superior debe ser mayor que el limite inferior");
                    max=sc.nextInt();
                }
                int [] generada=genRandArray(size,min,max);
                System.out.print("Arreglo generado: ");
                Imprimir(generada);
                System.out.println("");
                System.out.print("No. divisores primos: ");
                int[] ContPrime=getTotalPrimeCount(generada);
                Imprimir(ContPrime);
                System.out.println("");
                
            }
            break;
            case 2:{
                System.out.println("Ingrese la palabra: ");
                String Principal=sc.next();
                boolean validacion=false;
                while(validacion==false){
                for(int i=0;i<Principal.length() ;i++){
                    char a=Principal.charAt(i);
                    int carac=(int)a;
                    if((carac>=97&&carac<=122)||carac==65533){
                        validacion=true;
                    }
                    else{
                        validacion=false;
                        break;
                    }
                }
                
                    if(validacion==false){
                        System.out.println("Ingrese una cadena valida:");
                        Principal=sc.next();
                    }
                }
                Imprimir(Frecuencia(Principal));
                System.out.println("");
                System.out.println("[a][b][c][d][e][f][g][h][i][j][k][l][m][n][o][p][q][r][s][t][u][v][w][x][z][ñ,á,é,í,ó,ú]");
            }
            break;
            case 3:{
                seguir=false;
            }
            break;
            default:{
                System.out.println("Opcion invalida");
            }
            break;
        }
        }while (seguir);
        // TODO code application logic here
    }
    public static void Imprimir (int [] arreglo){
        for(int i=0;i<arreglo.length;i++){
            System.out.print("["+arreglo[i]+"]");
            
        }
        
    }
    public static int [] genRandArray(int tam, int inf, int sup){
        int [] generada= new int [tam];
        for(int i=0;i<tam;i++){
            generada[i]=ran.nextInt(sup-inf)+inf;
        }
        return generada;
    }
    public static boolean isPrime (int numero){
                        int contador_ciclo=1;
                        int resp=0;
                        int contador_cero=0;
                        while (contador_ciclo<=numero){
                            if(numero%contador_ciclo==0){
                            contador_cero++;
                                    }
                            contador_ciclo++;
                        }
                        boolean primito=false;
                        if(contador_cero==2){
                            primito=true;
                        }
                        else{
                            primito=false;
                        }
                        return primito;
    }
    public static int countPrimeFactors(int numero){
        boolean primo;
        int contadorprimos=0;
        for(int i=2;i<=numero;i++){
            primo=isPrime(i);
            if(numero%i==0){
                if(primo){
                   contadorprimos++; 
                }
            }
        }
        return contadorprimos;
    }
    public static int[] getTotalPrimeCount(int[] arreglo){
        int [] totalprimo= new int[arreglo.length];
        for(int i=0;i<arreglo.length;i++){
            totalprimo[i]=countPrimeFactors(arreglo[i]);
        }
        return totalprimo;
    }
    public static int [] Frecuencia(String cadena){
        int [] frecuencia= new int [27];
        int lugar=122;
        int posicion;
        int art=0;
            for(int i=0;i<cadena.length();i++){
                char x=cadena.charAt(i);
                if(x>=97 && x<=122){
                    posicion=x-97;
                    frecuencia[posicion]++;
                }else if(x==65533){
                    frecuencia[26]++;
                }
            
        }
        return frecuencia;
    }
}
