/**
 * AbstractStack es la clase padre de todas las implementaciones a utilizar de stack. Esta es necesaria para el patron de creacion factory, ya que
 * el factory retorna objetos de tipo AbstractStack. Esta clase implementa la interfaz IStack y se declaran todos los metodos abstractos para delegar
 * la implementacion de dichos metodos a las subclases.
 * @author Leonel Contreras 18797
 * @version 1.0
 */
public abstract class AbstractStack<T> implements  IStack<T>{

    public abstract int count();

    public abstract boolean isEmpty();

    public abstract void push(T value);

    public abstract T pull();

    public abstract T peek();
     


    
    
}  
