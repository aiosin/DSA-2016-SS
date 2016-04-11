package de.unistuttgart.dsass2016.ex00.p2;
/**
 * 
 * @author zython5
 *
 * @param <T>
 */
public class VariableStorage<T> implements IVariableStorage<T> {
	protected T var;

	@Override
	public void set(T var) {
		this.var = var;
	}

	@Override
	public T get() {
		return this.var;
	}
	
	

}
