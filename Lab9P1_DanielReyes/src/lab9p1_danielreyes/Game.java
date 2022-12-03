
package lab9p1_danielreyes;

import java.util.ArrayList;

public class Game {
    int [][] matriz;
    int [][] matriz2;
    int rondas;
    ArrayList<String> lista;
    
    public Game(){
    }
    
    // GETS Y SETS
    public int[][] getmatriz(){
        return matriz;
    }
    public void setmatriz(int [][] matriz){
        this.matriz = matriz;
    }
    public int [][] getmatriz2(){
        return matriz2;
    }
    public void setmatriz2( int [][] matriz2){
        this.matriz2 = matriz2;
    }
    public int getRondas() {
        return rondas;
    }
    public void setRondas(int rondas) {
        this.rondas = rondas;
    }
    public ArrayList<String> getLista() {
        return lista;
    }
    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }
    public String Print(ArrayList<String> arraylist){
        String temporal = "";
        int [][] provisional = new int [10][10]; 
        for (int i = 0; i < arraylist.size(); i++) {
            String [] arreglo = arraylist.get(i).split(":");
            int x = Integer.parseInt(arreglo[0]);
            int y = Integer.parseInt(arreglo[1]);
            
            provisional[x][y] = 1;
            
        }
        for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    temporal += "[" + Integer.toString(provisional[j][k]) + "]";
                }
                temporal += "\n";
            }
      return temporal;  
    }
    public void nextGen(){
        //vecinos
        for (int i = 0; i < matriz2.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                int cont = 0;
                if(matriz[i][j] == 1){
                    for (int k = i-1; k <= i+1; k++) {
                        for (int l = j-1; l <= j+1; l++) {
                            if(matriz[k][l]== 1){
                                cont++;
                            }
                        }
                    }
                    if(cont<2){
                        matriz[i][j] = 0;
                    }else if (cont > 3){
                        matriz[i][j] = 0;
                    }else if (cont == 3 || cont == 2){
                        matriz[i][j] = 1;
                        lista.add((Integer.toString(i)+":"+ Integer.toString(j)));
                    }
                }
                else{
                    if(i!= 0 && j!=0 && j!=matriz.length-1 && i!=matriz.length-1){
                        for (int k = i-1; k <= i+1; k++) {
                            for (int l = j-1; l <= j+1; l++) {
                                if(matriz[k][l]== 1){
                                    cont++;
                                }
                            }
                        }
                        if(cont == 3){
                            matriz[i][j]= 1;
                            lista.add((Integer.toString(i)+":"+ Integer.toString(j)));
                        }
                    }
                }
            }
        }
        // swap
        int [][] nuevo = matriz;
        matriz = matriz2;
        matriz2 = nuevo;
    }
    
    public void jugar(int rondas){
        int cont = 0;
        for (int i = 0; i < rondas; i++) {
            cont++;
            System.out.println("Ronda "+ cont + " : ");
            nextGen();
            System.out.println(lista);
            System.out.println(Print(lista));
        }
        
        
    }
    
}
