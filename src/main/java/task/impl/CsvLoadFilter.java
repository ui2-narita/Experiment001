package task.impl;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import model.SampleInputEntity;
import task.Filter;
import task.FilterException;

public class CsvLoadFilter<I extends InputStreamReader, O extends List<SampleInputEntity>> implements Filter<I, O> {

	@Override
	public O fiter(I in) throws FilterException {
		try {
			List<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in).getRecords();
			List<SampleInputEntity> out = new LinkedList<>();
			records.forEach(e->{
				List<String> cols = new LinkedList<>();
				e.forEach(cols::add);
				out.add(new SampleInputEntity(cols.toArray(new String[]{})));
			});
			return extracted(out);
		} catch (IOException e) {
			throw new FilterException(e.getLocalizedMessage());
		}
	}

	@SuppressWarnings("unchecked")
	private O extracted(List<SampleInputEntity> out) {
		return (O) out;
	}

}
