package task.impl;

import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import task.Filter;
import task.FilterException;

public class CsvToBeanFilter<I extends InputStreamReader, T, O extends List<T>> implements Filter<I, O> {

  private final Class<T> cls;
  
  public CsvToBeanFilter(final Class<T> cls) {
    this.cls = cls;
  }
  
	@Override
	public O fiter(I in) throws FilterException {
    try {
      List<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in).getRecords();
      List<T> out = new LinkedList<T>();
      
      for(CSVRecord r : records) {
        out.add(convertToBean(r));
      }
		  return extracted(out);
    }
    catch(Exception e) {
      throw new FilterException(e.getLocalizedMessage());
    }
	}

  private T convertToBean(CSVRecord e) throws NoSuchMethodException, SecurityException, InstantiationException
    , IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    List<String> cols = new LinkedList<>();
    e.forEach(cols::add);
    Class<?>[] params = {String[].class};
    Constructor<T> constructor = cls.getDeclaredConstructor(params);
    return constructor.newInstance(new Object[]{cols.toArray(new String[]{})});
  }

  @SuppressWarnings("unchecked")
  private O extracted(List<T> out) {
    return (O) out;
  }

}
