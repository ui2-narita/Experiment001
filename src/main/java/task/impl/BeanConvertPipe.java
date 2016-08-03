package task.impl;

import java.util.List;

import model.SampleInputEntity;
import model.SampleOutputEntity;
import task.Filter;
import task.Pipe;

public class BeanConvertPipe extends Pipe<List<SampleInputEntity>, List<SampleOutputEntity>> {

	public BeanConvertPipe(Filter<List<SampleInputEntity>, List<SampleOutputEntity>> filter) {
		super(filter);
	}

}
