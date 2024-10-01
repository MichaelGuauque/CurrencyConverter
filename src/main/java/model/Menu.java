package model;

import java.util.Scanner;

public class Menu {

    public void imprimirOpciones(){
        System.out.println("""
                    1) Peso Colombiano (COP).
                    2) Peso Argentino  (ARS).
                    3) Peso Chileno (CLP).
                    4) Real brasilenio (BRL).
                    5) Boliviano Boliviano (BOB).
                    6) Dolar Estadounidense (USD).
                    7) Otra moneda.
                    0) Salir.
                    """);
    }

    public String validarOpcion(int opcion){
        Scanner lectura = new Scanner(System.in);
        if (opcion == 1){
            return "COP";
        }else if (opcion == 2){
            return "ARS";
        }else if (opcion == 3){
            return "CLP";
        }else if (opcion == 4){
            return "BRL";
        }else if (opcion == 5){
            return "BOB";
        }else if (opcion == 6){
            return "USD";
        }else if (opcion == 7){
            System.out.println("Ingrese la moneda base (EJ: USD)");
            String monedaAlternativa = lectura.nextLine();
            return monedaAlternativa;
        }
        return "";
    }

    public void lecturaUsuario(){
        Change change = new Change();
        ConverterApi converterApi = new ConverterApi();
        Scanner lectura = new Scanner(System.in);
        int opcion = 1;


        while (opcion != 0){
            try {
                System.out.println("****************************************************************");
                System.out.println("Seleccione las opcion de la moneda base:");
                imprimirOpciones();
                opcion = Integer.valueOf(lectura.nextLine());
                if (opcion == 0) {
                    break;
                }
                change.setMonedaBase(validarOpcion(opcion));

                System.out.println("Seleccione las opcion de la moneda a convertir:");
                imprimirOpciones();
                opcion = Integer.valueOf(lectura.nextLine());
                if (opcion == 0) {
                    break;
                }
                change.setMonedaCambiar(validarOpcion(opcion));

                System.out.println("Ingrese el monto a convertir(separador de decimales . ):");
                double monto = Double.valueOf(lectura.nextLine());
                change.setMontoAConvertir(monto);

                change.setConversion(converterApi.changeCurrency(change));
                System.out.println("Detalle del Resultado:");
                System.out.println(change);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("""
                    ¿Desea continuar?:
                    0) Finalizar.
                    1) Continuar.
                    """);
            opcion = Integer.valueOf(lectura.nextLine());
        }
        System.out.println("Fin de la aplicacion.");
    }
}
