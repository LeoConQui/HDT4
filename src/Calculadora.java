/**
 * Calculadora es la clase que modela la calculadora postfix. Implementa el patron creacional singleton.
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class Calculadora {

    // atributos 
    private static boolean instance_flag = false;

    private static Calculadora _theOnlyCalculadora;

    public String textoprueba = "Texto de prueba";

    private AbstractStack<Integer> stack;

    // metodos 

    /***
     * Calculadora hace overloading al constructor de la clase. Lo declaramos privado para restringir el acceso a dicho metodo.
     * @throws SingletonException
     */
    private  Calculadora(){
        instance_flag = true;
    }

    /***
     * getInstance es un metodo que sirve para poder apuntar a la unica instancia de Calculadora
     * @return la unica instancia de calculadora 
     */
    public static Calculadora getInstance() {
        if (instance_flag) {
            // si ya existe una instancia de calculadora, retornamos dicha instancia
            return _theOnlyCalculadora;
        } else {
            // si no se ha creado la unica instancia de calculadora, usamos el constructor privado para crear la instancia
            _theOnlyCalculadora = new Calculadora();
            // retornamos la instancia recien creada
            return _theOnlyCalculadora;
        }
    }

    /**
     * BinaryOperator es un metodo que verifica la existencia de dos operandos en el stack al momento de realizar una operacion.
     * Si no existen al menos dos operandos en el stack, lanza una excepcion
     * @throws Exception
     */

     private void BinaryOperator() throws Exception{
        if (stack.count()<2) {
            throw new Exception("La operacion es binaria y no existen suficientes operandos");
        }
     }

     /**
      * DivisionbyZero es un metodo que verifica si el divisor es cero. En caso que lo sea, lanza una excepcion.
      * @param operandoB es el divisor y es de tipo int
      * @throws Exception
      */

      private void DivisionbyZero(int operandoB) throws Exception{
        if(operandoB==0){
            throw new Exception("Usted esta realizando una division por cero");
        }
      }

    /***
     * Calcular es el metodo que realiza los calculos postfix
     * @param postfix es un String que tiene la expresion postfix a calcular
     * @param tipodestack es un int que indica el tipo de stack que desea implementar el usuario
     * @return un int que es el resultado de la operacion
     */
    public int Calcular(String postfix, int tipodestack) {
        // declaramos un stack factory
        StackFactory factorydestack = new StackFactory<Integer>();
        // declaramos un int que vamos a retornar
        int retorno = -1;
        // hacemos el stack del tipo que desea el usuario mediante el factory
        this.stack = factorydestack.InstanceCreator(tipodestack);

        // recorremos cada caracter del string
        for (int i = 0; i < postfix.length(); i++) {
            // obtenemos el caracter en la iesima posicion 
            Character caracter = postfix.charAt(i);

            // validamos si es alfanumerico
            if (Character.isLetterOrDigit(caracter)) {
                // convertimos el numero a int
                int numero = Character.getNumericValue(caracter);
                // hacemos push al stack
                stack.push(numero);
            } else {
                // validamos si es una multiplicacion
                if (caracter == '*') {
                    try {
                        // verficamos que existan al menos dos operandos
                        this.BinaryOperator();
                        // hacemos pull para obtener los dos operandos
                        int operandoB = stack.pull();
                        int operandoA = stack.pull();
                        // realizamos la operacion
                        int resultado = operandoA*operandoB;
                        // hacemos push al stack
                        stack.push(resultado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }

                // validamos si es una suma
                if (caracter == '+') {
                    try {
                        // validamos que existan al menos dos operandos
                        this.BinaryOperator();
                        // hacemos pull para obtener los operandos
                        int operandoB = stack.pull();
                        int operandoA = stack.pull();
                        // realizamos la operacion 
                        int resultado = operandoA+operandoB;
                        // hacemos push al resultado
                        stack.push(resultado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }

                // validamos si es una resta 
                if (caracter=='-') {
                    try {
                        // validamos que existan al menos dos operandos
                        this.BinaryOperator();
                        // hacemos pull para obtener los dos operandos
                        int operandoB = stack.pull();
                        int operandoA = stack.pull();
                        // realizamos la operacion
                        int resultado = operandoA - operandoB;
                        // hacemos push al resultado
                        stack.push(resultado);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }

                // validamos si es una division
                if (caracter == '/') {
                    try {
                        // validamos que existan al menos dos operandos
                        this.BinaryOperator();
                        // hacemos pull para obtener los dos operandos
                        int operandoB = stack.pull();
                        int operandoA = stack.pull();
                        try {
                            // validamos que el divisor no sea cero
                            this.DivisionbyZero(operandoB);
                            // realizamos la operacion 
                            int resultado = operandoA/operandoB;
                            // hacemos push al resultado 
                            stack.push(resultado);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }

                // validamos si es un exponente
                if (caracter == '^') {
                    try {
                        // validamos que existan al menos dos operandos 
                        this.BinaryOperator();;
                        // hacemos pull para obtener los dos operandos
                        int operandoB = stack.pull();
                        int operandoA = stack.pull();
                        // realizamos la operacion mediante un ciclo for
                        // declaramos una variable resultado
                        int resultado = 1;
                        for (int j = 0; j < operandoB; j++) {
                            resultado *= operandoA;
                        }
                        // hacemos push al resultado
                        stack.push(resultado);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                }
            }
        }

        // hacemos pull al stack para obtener el resultado
        retorno = stack.pull();

        // borramos todo lo que quede en el stack
        for (int i = 0; i < stack.count(); i++) {
            int borrar = stack.pull();
        }

        return retorno;
    }


    
}