package example1;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
import model.SampleInputEntity;
import model.SampleOutputEntity;
import task.Filter;
import task.Pipe;
import task.impl.BeanConvertFilter;
import task.impl.BeanConvertPipe;
import task.impl.CsvPipe;
import task.impl.CsvToBeanFilter;
import task.impl.JsonConvertFilter;
import task.impl.JsonConvertPipe;

@Slf4j
public class PipeTest {

	@Test
	public void normalTest() throws RuntimeException {
		Filter<InputStreamReader, List<SampleInputEntity>> filter = new CsvToBeanFilter<>(SampleInputEntity.class);
		Pipe<InputStreamReader, List<SampleInputEntity>> pipe  = new CsvPipe<>(filter);

		InputStreamReader reader = new InputStreamReader(
				new BufferedInputStream(
						this.getClass().getClassLoader().getResourceAsStream("sample.csv")));
		pipe.put(reader);
		List<SampleInputEntity> result = pipe.get();
		
		result.forEach(s -> {log.info(s.toString());});
		
		Filter<List<SampleInputEntity>, List<SampleOutputEntity>> filter2 = new BeanConvertFilter();
		BeanConvertPipe pipe2 = new BeanConvertPipe(filter2);
		
		pipe2.put(result);
		List<SampleOutputEntity> result2 = pipe2.get();
		
		result2.forEach(s->{log.info(s.toString());});
		
		Filter<List<SampleOutputEntity>, String> filter3 = new JsonConvertFilter();
		JsonConvertPipe pipe3 = new JsonConvertPipe(filter3);
		
		pipe3.put(result2);
		
		String result3 = pipe3.get();
		log.info(result3);
	}
}
