package de.unistuttgart.dsass2016.ex00.p2;
/**
 * 
 * @author 3133783 Wilhelm Buchmüller
 * @author 3149308 Daniel Wanner
 * @author 2736424 Artur Frenzen
 *
 * @param <T>
 */
public class VariableStorage<T> implements IVariableStorage<T> {
	private T var;

	@Override
	public void set(T var) {
		this.var = var;
	}

	@Override
	public T get() {
		return this.var;
	}
	
	

}
