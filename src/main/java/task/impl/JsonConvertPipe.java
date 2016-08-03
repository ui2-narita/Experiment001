package task.impl;

import java.util.List;

import model.SampleOutputEntity;
import task.Filter;
import task.Pipe;

public class JsonConvertPipe extends Pipe<List<SampleOutputEntity>, String> {

	public JsonConvertPipe(Filter<List<SampleOutputEntity>, String> filter) {
		super(filter);
	}

}
