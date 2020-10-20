package fairtility;

import java.util.Map;
/**
 * The class represent the compare engine between two CSV's
 * @author Shlomi
 */
@SuppressWarnings({ "javadoc", "static-access", "static-method", "unused" })
public class CompareEngine {

	private String excpectedPath;
	private SourceFactory SFactory = new SourceFactory();

	/* constructor */
	public CompareEngine(String expectedPath) {
		this.excpectedPath = expectedPath;
	}

	/* function to get maps of the actual and expected data from CSV and to calculate the diffs */
	public void FromFile(String path) throws Exception {
		Map<String, EmpData> tested = SFactory.getMap(path, "file");
		Map<String, EmpData> expected = SFactory.getMap(excpectedPath, "file");
		getDiffValues(tested, expected);
	}

	/* get the CSV as map from API */
	public void FromApi(String path) throws Exception {
		Map<String, EmpData> tested = SFactory.getMap(path, "api");
		Map<String, EmpData> expected = SFactory.getMap(excpectedPath, "file");
	}

	/* function to compare the differences from the two CSV's */
	public void getDiffValues(Map<String, EmpData> tested, Map<String, EmpData> expected) {
		for (String key : expected.keySet()) {
			if (tested.get(key) != null) {
				if (tested.get(key).equals(expected.get(key))) {
					System.out.println("Rows are the same");
				} else {
					String testedRow = tested.get(key).toString();
					String expectedRow = expected.get(key).toString();
					System.out.printf("The tested CSV row is: %s\n",testedRow);
					System.out.printf("The expected CSV row is: %s\n",expectedRow);
				}
			}
		}
	}
}