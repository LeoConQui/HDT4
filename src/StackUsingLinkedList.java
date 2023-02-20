
/**
 * @author MAAG
 *
 */
public class StackUsingLinkedList<T> extends AbstractStack<T>{

	// atributos
	private AbstractLista<T> listaInterna;

	private ListFactory<T> listfactory;
	
	//metodos
	public StackUsingLinkedList()
	{
		listfactory = new ListFactory<T>();
		listaInterna = listfactory.InstanceCreator(1);
	}
	
	@Override
	public int count() {
		return listaInterna.Count();
	}

	@Override
	public boolean isEmpty() {
		return listaInterna.IsEmpty();
	}

	@Override
	public void push(T value) {
		listaInterna.InsertAtStart(value);
	}

	@Override
	public T pull() {
		return listaInterna.Delete(0);
	}

	@Override
	public T peek() {
		return listaInterna.Get(0);
	}

}