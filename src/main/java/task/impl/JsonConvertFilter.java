package task.impl;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.SampleOutputEntity;
import task.Filter;
import task.FilterException;

public class JsonConvertFilter implements Filter<List<SampleOutputEntity>, String> {

	@Override
	public String fiter(List<SampleOutputEntity> in) throws FilterException {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(in);
		}
		catch (JsonProcessingException e) {
			throw new FilterException(e.getLocalizedMessage());
		}
	}

}
