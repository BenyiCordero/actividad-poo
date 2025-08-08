package vista;

import controlador.Controller;

import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Controller controlador = new Controller();

    public static void main(String[] args) throws Exception {
        int seleccion;
        do{
            System.out.print("Ejercicios posibles:\n1. Tiros de un dado (arreglo con numeros)\n2. Arreglos con cadenas\nSeleccion: ");
            seleccion = sc.nextInt();
        }while(seleccion != 1 && seleccion != 2);
        switch (seleccion) {
            case 1:
                Set<Integer> valoresValidos = Set.of(1, 2, 3, 4, 5, 6);
                Set<Character> opcionesIncisos = Set.of('a', 'b', 'c', 'd', 'e');
                int llenado = 1;
                List<Integer> numeros = new ArrayList();
                System.out.println("Se analizarán tantos tiros de dados como registres, digita tantos  numeros entre el 1 y el 6, cuando digites un numero diferente se detendrá el llenado");
                while(valoresValidos.contains(llenado)){
                    System.out.print("Numero: ");
                    llenado = sc.nextInt();
                    if(valoresValidos.contains(llenado)){
                        numeros.add(llenado);
                    }
                }
                int[][] matrizNumeros = transformarListaAMatriz(numeros);
                char seleccionIncisos;
                do{
                    System.out.print("Selecciona la opcion a calcular:\na) Obtener el numero que mas se repite\nb) Obtener la cantidad de numeros pares\nc) Obtener la cantidad de numeros impares\nd) Obtener la suma de numeros en diagonal\ne) Obtener la cantidad de numeros multiplos de 5\nSeleccion: ");
                    seleccionIncisos = sc.next().charAt(0);
                }while(!opcionesIncisos.contains(seleccionIncisos));
                for (int[] fila : matrizNumeros) {
                    System.out.println(Arrays.toString(fila));
                }
                double resultado = controlador.trabajarNumeros(matrizNumeros, seleccionIncisos); //Nunca llegará a la excepcion.
                switch(seleccionIncisos){
                    case 'a' :
                        System.out.println("El numero que mas se repite es: " + resultado); break;
                    case 'b' :
                        System.out.println("La cantidad de numeros pares es: " + resultado); break;
                    case 'c' :
                        System.out.println("La cantidad de numeros impares es: " + resultado); break;
                    case 'd' :
                        System.out.println("La suma en diagonal es: " + resultado); break;
                    case 'e' :
                        System.out.println("La cantidad de numeros multiplos de 5 es: " + resultado); break;
                }
            case 2:
                break; //Aqui va el llamado al caso 2.
        }
    }

    public static int[][] transformarListaAMatriz(List<Integer> numeros){
        int total = numeros.size();
        // Calcula la raíz cuadrada
        double raiz = Math.sqrt(total);
        int n;
        if (raiz == Math.floor(raiz)) {
            n = (int) raiz;
        } else {
            // Si no es un número entero, n es el siguiente entero.
            n = (int) Math.ceil(raiz);
        }
        int cantidadFinal = n * n;
        while (numeros.size() < cantidadFinal) {
            numeros.add(0);
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