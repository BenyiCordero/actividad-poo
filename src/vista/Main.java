package vista;

import controlador.Controller;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int seleccion;
        do{
            System.out.print("Ejercicios posibles:\n1. Tiros de un dado (arreglo con numeros)\n2. Arreglos con cadenas\nSeleccion: ");
            seleccion = sc.nextInt();
        }while(seleccion != 1 && seleccion != 2);
        switch (seleccion) {
            case 1:
                Set<Integer> valoresValidos = Set.of(1, 2, 3, 4, 5, 6);
                int llenado = 1;
                List<Integer> numeros = new ArrayList();
                System.out.println("Se analizarán tantos tiros de dados como registres, digita tantos  numeros entre el 1 y el 6, cuando digites un numero diferente se detendrá el llenado");
                while(valoresValidos.contains(llenado)){
                    System.out.print("Numero: ");
                    llenado = sc.nextInt();
                    numeros.add(llenado);
                }
                int[][] matrizNumeros = transformarListaAMatriz(numeros);
                for (int[] fila : matrizNumeros) {
                    System.out.println(Arrays.toString(fila));
                }
        }
    }

    public static int[][] transformarListaAMatriz(List<Integer> numeros){
        int total = numeros.size();
        int n = (int) Math.ceil(Math.sqrt(total)); // próximo entero
        int cantidadFinal = n * n;
        while (numeros.size() < cantidadFinal) {
            numeros.add(0); // o cualquier valor que quieras como relleno
        }
        int[][] matriz = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = numeros.get(index++);
            }
        }
        return matriz;
    }
}