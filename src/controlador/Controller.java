package controlador;

import java.util.List;

public class Controller {

    //Arreglo bidimensional de numeros que representan tiros de un dado.
    public double trabajarNumeros(int[][] numeros, char eleccion){
        switch(eleccion){
            case 'a':
                return obtenerModa(numeros);
            case 'b':
                return obtenerPares(numeros);
            case 'c':
                break;
            case 'd':
                break;
            case 'e':
                break;
        }
        //Aqui va una excepcion.
        return 0;
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


    public int obtenerSumaDiagonal(int[][] numeros){
        int sumaDiagonal = 0;

        for(int i = 0; i < numeros.length; i++){
            sumaDiagonal += numeros[i][i];
        }
        return sumaDiagonal;
    }


    public int obtenerMultiplosDe5(int[][] numeros){
        int cantidadMultiplos = 0;

        for(int i = 0; i < numeros.length; i++){
            for(int j = 0; j < numeros[0].length; j++){
                // Si el número es divisible por 5, es un múltiplo
                if(numeros[i][j] % 5 == 0) {
                    cantidadMultiplos++;
                }
            }
        }
        return cantidadMultiplos;
    }
}
