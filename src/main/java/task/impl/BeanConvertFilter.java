package task.impl;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import model.SampleInputEntity;
import model.SampleOutputEntity;
import task.Filter;
import task.FilterException;

public class BeanConvertFilter implements Filter<List<SampleInputEntity>, List<SampleOutputEntity>> {

	@Override
	public List<SampleOutputEntity> fiter(List<SampleInputEntity> in) throws FilterException {
		List<SampleOutputEntity> out = new LinkedList<>();
		int seq = 0;
		for(SampleInputEntity e: in) {
			SampleOutputEntity o = new SampleOutputEntity(seq++, 
					StringUtils.join(
							new String[] {e.getColumn1(), e.getColumn2(), e.getColumn3()},"-"));
			out.add(o);
		}
		return out;
	}

}
