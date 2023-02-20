import java.util.Vector;

public class StackUsingVector<T> extends AbstractStack<T> {
    // atributos
    protected Vector<T> data;

    // metodos
    /**
     * StackUsingVector es el constructor de la clase. No tiene parametros y al ser constructor tampoco tiene retorno.
     * Inicializa el vector que tiene como atributo la clase 
     */
    public  StackUsingVector() {
        data = new Vector<T>();
    }

    @Override
    public int count(){

        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.count() == 0;
    }

    @Override
    public void push(T value) {
        // usamos el metodo add de la clase vector
        data.add(value);
    }

    @Override
    public T pull() {
        // devolvemos el ultimo elemento del vector usando los metodos remove y size de la clase vector
        if (data.size() > 0)
            return data.remove(data.size()-1);
        else
            return null;
    }

    @Override
    public T peek() {
        return data.get(data.size()-1);
    }
}