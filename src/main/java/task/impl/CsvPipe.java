package task.impl;

import java.io.InputStreamReader;
import java.util.List;

import model.SampleInputEntity;
import task.Filter;
import task.Pipe;

public class CsvPipe<I extends InputStreamReader, O extends List<SampleInputEntity>> extends Pipe<I,O> {

	public CsvPipe(Filter<I, O> filter) {
		super(filter);
	}
}
