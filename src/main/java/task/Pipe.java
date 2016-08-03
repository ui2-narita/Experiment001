package task;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Pipe<I,O> implements In<I, O>, Out<I, O> {

	private BlockingQueue<I> queue;
	private final Filter<I,O> filter;
	
	public Pipe(final Filter<I,O> filter) {
	  this.queue = new ArrayBlockingQueue<>(8);
	  this.filter = filter;
	}
	
	@Override
	public void put(I in) throws PipeException {
		try {
			queue.put(in);
		}
		catch(InterruptedException e) {
			throw new PipeException(e.getLocalizedMessage());
		}
	}

	@Override
	public void end() {
		try {
			queue.put(null);
		}
		catch(InterruptedException e) {
			throw new PipeException(e.getLocalizedMessage());
		}
	}

	@Override
	public O get() throws PipeException {
		O out = null;
		try {
			I in  = queue.take();
			out   = filter.fiter(in);
		}
		catch(InterruptedException e) {
			throw new PipeException(e.getMessage());
		}
		return out;
	}

}
