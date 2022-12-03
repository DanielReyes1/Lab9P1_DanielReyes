package lab9p1_danielreyes;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab9P1_DanielReyes {

    static Scanner leer = new Scanner(System.in);
    static Random aleatorio = new Random();
    static Game g = new Game();
    
    public static void main(String[] args) {
        
        
        int resp = menu();
        while (resp != 2) {
            if (resp == 1){
                
                System.out.println("Bienvenido al Game of Life");
                System.out.print("Ingrese la cantidad de rondas: ");
                int rondas = leer.nextInt();
                int [][] tablero = new int [10][10];
                int [][] next = new int [10][10];
                ArrayList<String> lista = new ArrayList<>();
                tablero = llenar(tablero ,next, lista);
                System.out.println("Tablero inicial:");
                g.setmatriz(tablero);
                g.setmatriz2(next);
                g.setRondas(rondas);
                System.out.println(g.getLista());
                System.out.println(g.Print(g.getLista()));
                g.jugar(g.getRondas());
            }
            resp = menu();
        }
    }// main
    
    public static int menu() {
        System.out.println("----------- Menu -----------");
        System.out.println("1- Game of Life");
        System.out.println("2- Salir del sistema");
        System.out.print("Ingrese una opción: ");
        int temporal = leer.nextInt();
        return temporal;
    }
    public static int [][] llenar(int [][] matriz, int [][] matriz2, ArrayList<String> arraylist){
        int [][] temporal = new int [10][10];
        for(int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz.length; j++){
                if (j == 0 || i == 0 || i== matriz.length-1 || j == matriz.length-1){
                    temporal[i][j] = 0;
                }
                else{
                    temporal[i][j] =  aleatorio.nextInt(2);
                    if (temporal[i][j] == 1){
                        arraylist.add(Integer.toString(i)+":"+ Integer.toString(j));
                    }
                }
            }
        }
        g.setLista(arraylist);
        return temporal;
    }
    
}
