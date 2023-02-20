/**
 * Lectura es la clase que se va a encargar de traducir la operacion infix a posfix y de dar las precedencias de las operaciones para tal conversion. 
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class Lectura {

    // metodos
    
    /**
     * Precedencia es un metodo que da valores numericos para indicar la precedencia de los operadores
     * @param caracter es el caracter que se desea saber su precedencia 
     * @return un int que da una jerarquia de los operadores 
     */

     public static int Precedencia(char caracter) {
        // varificamos si es una suma o resta 
        if (caracter == '+' || caracter == '-') {
            return 1;
        }else if(caracter == '*' || caracter == '/'){ // la multiplicacion y division van segundo en nuestra jerarquia
            return 2;
        }else if(caracter == '^'){ // la potencia va en lo mas alto de nuestra jerarquia
            return 3;
        }
        return -1;
     }

    

     /**
      * In2Post es un metodo que convierte una expresion infix a una expresion postifix. Se declara static para poderla utilizar sin necesidad 
      * de una instancia de la clase
      * @param expresion es un objeto de tipo String que representa la expresion, en infix, a convertir
      * @return un String que es la expresion en postfix
      */

      public static String In2Post(String expresion) {
        // declaramos e instanciamos un objeto de tipo StackUsingArrayList
        StackUsingArrayList stack = new StackUsingArrayList<Character>();
        // declaramos un String que es el resultado a retornar
        String retorno = " ";

        // recorremos cada caracter de la expresion
        for (int i = 0; i < expresion.length(); i++) {
            // obtenemos el caracter en la iesima posicion
            char caracter = expresion.charAt(i);
            // verificamos si el caracter es alfanumerico con el metodo isLetterorDigit de la clase Character
            if (Character.isLetterOrDigit(caracter)) {
                // lo agregamos al string a retornar
                retorno +=caracter;
            }else if(caracter == '('){ // verificamos si es un '('
                // le hacemos push al stack
                stack.push(caracter);
            }else if(caracter == ')'){ // verificamos si es un ')'
                // mientras el stack no este vacio y el top no sea el parentesis '('
                while (!stack.isEmpty() && !stack.peek().equals('(')) {
                    // agregamos el caracter en top al string a retornar
                    retorno +=stack.peek();
                    // eliminamos este caracter del stack para pasar al siguiente
                    stack.pull();
                }
                stack.pull();
            }else{ // el ultimo caso es cuando encontramos un operador
                while (! stack.isEmpty() && Precedencia(caracter)<=Precedencia((char) stack.peek())) {
                   retorno += stack.peek();
                   stack.pull();
                }
                stack.push(caracter);
            }
        }
        while (!stack.isEmpty()) {
            if ((Character) stack.peek() == '(') {
                return "Expresion no valida";
            }
            retorno += stack.peek();
            stack.pull();
        }
        
        return retorno;
      }

    
}