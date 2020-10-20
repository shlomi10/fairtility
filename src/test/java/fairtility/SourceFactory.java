package fairtility;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
/**
 * The class represent the source factory, open the files and send back the map of the data
 * @author Shlomi
 */
@SuppressWarnings({"javadoc", "resource"})
public class SourceFactory {

	/* function to switch between the files and to read from them */
	public static Map<String, EmpData> getMap(String path, String source) throws Exception {

		Map<String, EmpData> workers = new HashMap<>();

		switch(source.toUpperCase()) {
		case "API":
			//get from API
			break;
		case "FILE":
			workers =  workersMap(path);
			break;
		default:
			throw new Exception("invalid source");
		}
		return workers;
	}
	
	/* function to read from CSV and to allocate the fields */
	public static Map<String, EmpData> workersMap(String path) throws IOException {

		Map<String, EmpData> workers = new HashMap<>();

		Reader reader = Files.newBufferedReader(Paths.get(path));
		CSVParser csvParser = new CSVParser(reader,
				CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
		{
			for (CSVRecord csvRecord : csvParser) {
				String name = csvRecord.get("name");
				String jobSpecification = csvRecord.get("jobSpecification");
				String assignedProject = csvRecord.get("assignedProject");
				String lastUpdated = csvRecord.get("lastUpdated");
				String id = csvRecord.get("id");
				String comments = csvRecord.get("comments");
				
				EmpData row = new EmpData(name, jobSpecification, assignedProject, lastUpdated, id, comments);
				workers.put(id, row);
			}
		}
		return workers;
	}
}
