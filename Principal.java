/**
 * Principal es la clase que interactua con el usuario y tiene el metodo main
 * @author Leonel Contreras
 * @version 1.0
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner; 

public class Principal {

    public static void main(String[] args) {
        // declaramos e inicializamos un pbjeto de tipo calculadora 
        Calculadora micalculadora = Calculadora.getInstance();

        // creamos un arraylist de string donde se guardara lo que se lea del archivo de texto
        ArrayList<String> lectura = new ArrayList<String>();

        // creamos un arraylist de string donde se guardaran las expresiones validas
        ArrayList<String> expresionesvalidas = new ArrayList<String>();

        ArrayList<String> expresionespostfix = new ArrayList<String>();

        // leemos el archivo de texto 
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String line;
            while ((line = reader.readLine())!= null) {
                // removemos los espacios en blanco 
                String stringaagregar = line.replaceAll("\\s", "");
                lectura.add(stringaagregar);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (String string : lectura) {
            String conversion = Lectura.In2Post(string);
            conversion = conversion.trim();
            expresionespostfix.add(conversion);
        }

        for (String string : expresionespostfix) {
            System.out.println(string);
        }

       // depuramos la lista de lectura para guardar unicamente las expresiones validas 

       for (String string : expresionespostfix) {
            // declaramos un boolean para indicar si se agrega o no la expresion
            boolean continua = true;
            // recorremos cada string caracter por caracter 
            for (int j = 0; j < string.length(); j++) {
                // convertimos el iesimo dato en caracter
                char caracter = string.charAt(j);
                // validamos que sea un digito o un simbolo de operacion
                if (Character.isDigit(caracter) || caracter == '+' || caracter == '-' || caracter == '*' || caracter == '/' || caracter == '^') {
                    continua = true;
                } else{
                    continua = false;
                    break;
                }

                if (continua== false) {
                    break;
                }
            }

            if (continua==true) {
                expresionesvalidas.add(string);
            }
       }

       

       Scanner scanner = new Scanner(System.in);

       int contador = 1;

       System.out.println("Ingrese una opcion:");
       System.out.println("0. Salir");
      for (String string : expresionesvalidas) {
        System.out.println(contador + ". " + string);
        contador+=1;
      }

      int opcionusuario = scanner.nextInt();

       if (opcionusuario == 0) {
        System.out.println("Usted ha elegido salir");
       }else{
        System.out.println("Ingrese la opcion de stack que desea implementar:");
        System.out.println("1. StackUsingArrayList");
        System.out.println("2. StackUsingVector");
        System.out.println("3. StackUsingLinkedList");
        System.out.println("4. StackUsingDoubleLinkedList");

        int opcionstack = scanner.nextInt();

        // obtenemos la expresion a pasar como parametro del arraylist expresionesvalidas
        String parametro = expresionesvalidas.get(opcionusuario-1);
        // pasamos ambos parametros a la calculadora
        int resultadocalculadora = micalculadora.Calcular(parametro, opcionstack);

        System.out.println("El resultado de la operacion es: " + resultadocalculadora);
       }





    }
    
}