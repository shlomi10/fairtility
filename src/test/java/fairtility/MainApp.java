package fairtility;
/**
 * The class represent the main application and source of the files to compare
 * @author Shlomi
 */
@SuppressWarnings("javadoc")
public class MainApp {

	public static void main(String[] args) throws Exception {

		/* two sources of the CSV - locals as mock */
		String expected = ".\\sheet.csv";
		String actual = ".\\sheet1.csv";

		CompareEngine compareEngine = new CompareEngine(expected);
		
		/* compare from local CSV */
		compareEngine.FromFile(actual);
		
		/* compare from API */
		// compareEngine.FromApi(ApiPath);

	}
}
