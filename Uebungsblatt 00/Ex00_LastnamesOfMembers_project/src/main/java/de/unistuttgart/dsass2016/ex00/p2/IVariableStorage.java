package de.unistuttgart.dsass2016.ex00.p2;

public interface IVariableStorage<T> {

	/** Sets the variable */
	public void set(T var);
	/** Returns the variable */
	public T get();

}
