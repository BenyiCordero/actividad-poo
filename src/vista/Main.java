package vista;

import controlador.Controller;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[][] numeros = {{6,6},{2,5}};

        Controller c = new Controller();


        double pares = c.trabajarNumeros(numeros, 'b');
        System.out.println(pares);
    }
}