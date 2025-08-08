package controlador;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    //Arreglo bidimensional de numeros que representan tiros de un dado.
    public double trabajarNumeros(int[][] numeros, char eleccion) throws Exception {
        switch(eleccion){
            case 'a':
                return obtenerModa(numeros);
            case 'b':
                return obtenerPares(numeros);
            case 'c':
                return obtenerImpares(numeros);
            case 'd':
                return obtenerSumaDiagonal(numeros);
            case 'e':
                return obtenerMultiplosDe5(numeros);
        }
        throw new Exception("Escribe una opcion valida.");
    }

    //Funciones complementarias.
    public int obtenerModa(int[][] numeros){
        int[] numerosPosibles = {1,2,3,4,5,6};
        int[][] cantidadVeces = new int[6][2];

        for(int i = 0; i < numerosPosibles.length; i++){
            int cantidad = 0;
            for (int j = 0; j < numeros.length; j++){
                for(int k = 0; k < numeros[0].length; k++){
                    if(numeros[j][k] == numerosPosibles[i]) cantidad++;
                }
            }
            cantidadVeces[i][0] = numerosPosibles[i];
            cantidadVeces[i][1] = cantidad;
        }
        int moda = -1;
        int maxRepeticiones = -1;

        for (int i = 0; i < cantidadVeces.length; i++) {
            if (cantidadVeces[i][1] > maxRepeticiones) {
                maxRepeticiones = cantidadVeces[i][1];
                moda = cantidadVeces[i][0];
            }
        }
        return moda;
    }

    public int obtenerPares(int[][] numeros){
        int cantidadPares = 0;

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[0].length; j++){
                if(numeros[i][j] == 0) break;
                if(numeros[i][j] % 2 == 0) cantidadPares++;
            }
        }
        return cantidadPares;
    }
    public int obtenerImpares(int[][] numeros){
        int cantidadImpares = 0;

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[0].length; j++){
                if(numeros[i][j] % 2 != 0) {
                    cantidadImpares++;
                }
            }
        }
        return cantidadImpares;
    }
//metodo para obtener suma diagonal

    public int obtenerSumaDiagonal(int[][] numeros){
        int sumaDiagonal = 0;

        for(int i = 0; i < numeros.length; i++){
            sumaDiagonal += numeros[i][i];
        }
        return sumaDiagonal;
    }

//metodo para obtener multiplos de 5
    public int obtenerMultiplosDe5(int[][] numeros){
        int cantidadMultiplos = 0;

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[0].length; j++){
                if(numeros[i][j] == 0) break;
                // Si el número es divisible por 5, es un múltiplo
                if(numeros[i][j] % 5 == 0) {
                    cantidadMultiplos++;
                }
            }
        }
        return cantidadMultiplos;
    }

    public static List<String> obtenerCadenasQueComienzanConO(String[][] matriz) {
        List<String> resultado = new ArrayList<>();

        for (String[] fila : matriz) {
            for (String palabra : fila) {
                if (palabra.toLowerCase().startsWith("o")) {
                    resultado.add(palabra);
                }
            }
        }

        return resultado;
    }
}
