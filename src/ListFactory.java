/**
 * ListFactory es la clase que sirve para implementar el diseno creacional factory. Esta clase es la encargada de crear instancias de las listas.
 * No se declara un constructor ya que se usara el constructor por defecto.
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public class ListFactory <T> {

    public AbstractLista<T> InstanceCreator(int opcionlista) {

        // declaramos un objeto de tipo AbstractList
        AbstractLista<T> listaaretornar;

        switch (opcionlista) {
            case 1:
                // en el primer caso, retornamos una lista simplemente encadenada
                listaaretornar = new SingleLinkedList<T>();
                break;

            case 2:
                // en el segundo caso, retornamos una lista doblemente encadenada
                listaaretornar = new DoubleLinkedList<T>();
                break;
        
            default:
                // po defecto, se retorna null
                listaaretornar = null;
                break;
        }
        
        return listaaretornar;
    }
}