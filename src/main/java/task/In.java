package task;

/**
 * 入力値インターフェース
 * 
 * @author hideki
 *
 * @param <I>
 * @param <O>
 */
public interface In<I,O>  {
	public void put(I in) throws PipeException;
}
