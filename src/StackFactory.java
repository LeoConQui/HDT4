/**
 * StackFactory es la clase que sirve para implementar el diseno creacional Factory. Esta clase sera la encargada de crear instancias de las implementaciones de 
 * stack. No se declara constructor ya que se usara el constructor por defecto.
 * @author Leonel Contreras 18797
 * @version 1.0
 */


public class StackFactory<T> {

    /**
     * InstanceCreator es un metodo que crea objetos con distintas implementaciones de Stack.  
     * @param opcion es de tipo int e indica la opcion de stack que desea implementar el usuario
     * @return un objeto de tipo AbstractStack.
     */

     public AbstractStack<T> InstanceCreator(int opcionstack) {
        // declaramos un objeto de tipo AbstractStack
        AbstractStack stackaretornar;

        switch (opcionstack) {
            case 1:
                // en el primer caso retornamos un stack usando arraylist
                stackaretornar = new StackUsingArrayList<T>();
                break;

            case 2: 
                // en el segundo caso retornamos un stack usando vector
                stackaretornar = new StackUsingVector<T>();
                break;
            
            case 3:
                // en el tercer caso retornamos un stack usando linkedlist 
                stackaretornar = new StackUsingLinkedList<T>();
                break;

            case 4: 
                // en el caso 4 retornamos un stack usando doublelinkedlist
                stackaretornar = new StackUsingDoubleLinkedList<T>();
                break;

        
            default:
                // por defecto, se retorna un null
                stackaretornar = null;
                break;
        }

        return stackaretornar;
     }
    
}