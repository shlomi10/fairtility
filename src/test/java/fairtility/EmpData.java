package fairtility;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
/**
 * The class represent the employee data as object and uses the function to cmpare items
 * @author Shlomi
 */
@SuppressWarnings({"javadoc", "static-method", "unused"})
public class EmpData {
	private String name;
	private String jobSpecification ;
	private String assignedProject ;
	private String lastUpdated;
	private String id;
	private String comments;
	
	/* constructor */
	public EmpData(String name, String jobSpecification, String assignedProject, String lastUpdated, String id, String comments) {
		this.name = name;
		this.jobSpecification = jobSpecification;
		this.assignedProject = assignedProject;
		this.lastUpdated = lastUpdated;
		this.id = id;
		this.comments = comments;
	}
	
	/* getters */
	
	public String getName() {
		return name;
	}


	public String getJobSpecification() {
		return jobSpecification;
	}


	public String getAssignedProject() {
		return assignedProject;
	}


	public String getLastUpdated() {
		return lastUpdated;
	}


	public String getId() {
		return id;
	}


	public String getComments() {
		return comments;
	}

	/* function to compare EmpData object */
	public boolean equals(EmpData other) {
		 if (this == other) return true;
		    if (other == null || getClass() != other.getClass()) return false;
		    return this.name.equals(other.name) &&
		    		this.lastUpdated.equals(other.lastUpdated) &&
		    		this.id.equals(other.id)&& 
		    		this.comments.equals(other.comments); 
//		    		&& 
//		    		deepJSONsEquals(this.jobSpecification, other.jobSpecification) && 
//		    		deepJSONsEquals(this.assignedProject, other.assignedProject);
		}
	
	/* function to compare JSON */
	private boolean deepJSONsEquals(String firstJson, String secondJson) {
	    try {
	        return JSONCompare.compareJSON(firstJson, secondJson, JSONCompareMode.LENIENT).passed();
	    } catch (JSONException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	@Override
	public String toString() {
		return "name: "+name+" "+" jobSpecification: "+jobSpecification+" assignedProject: "+assignedProject+" lastUpdated: "+lastUpdated+" id: "+id+" comments: "+comments;
	}
	
}
