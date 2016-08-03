package task;

public interface Filter<I,O> {

	public O fiter(I in) throws FilterException;
}
