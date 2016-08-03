package task;

public interface Out<I, O> {

	public O get() throws PipeException;
	public void end() throws PipeException;
}
