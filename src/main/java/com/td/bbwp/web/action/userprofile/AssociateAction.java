package com.td.bbwp.web.action.userprofile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.witchcraft.seam.action.UserUtilAction;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.td.bbwp.TaskData;

//@Scope(ScopeType.CONVERSATION)
@Name("associateAction")
public class AssociateAction extends AssociateActionBase implements
		java.io.Serializable {

	public static final String URL = "http://localhost:8095/jbpmngwebexample/rest/json/";
	
	@In(create=true)
	UserUtilAction userUtilAction;

	public List<TaskData> getPotentialTasks() {
		return getTasks(true);
	}

	public List<TaskData> getMyTasks() {
		return getTasks(false);
	}

	public String claimTask(String taskId) {
		Client client = Client.create();
		
		WebResource webResource = client.resource(URL);
		
		String myURL  = URL  +  "tasks/claim";

		webResource = webResource.path(myURL);
		
		webResource = webResource.queryParam("user", userUtilAction.getCurrentUser().getUserName());
		webResource = webResource.queryParam("taskId", taskId);
		//webResource = webResource.queryParam("outcome", user);
		
		String output = webResource.get(String.class);
		List<TaskData> tasks =parse(output);
		
		return "success";
		
	}
	
	public String completeTask(String taskId, String outcome){
		String user = userUtilAction.getCurrentUser().getUserName();

		Client client = Client.create();
		
		WebResource webResource = client.resource(URL);
		
		String myURL  = URL  +  "tasks/complete";

		webResource = webResource.path(myURL);
		
		webResource = webResource.queryParam("user", user);
		webResource = webResource.queryParam("taskId", taskId);
		webResource = webResource.queryParam("outcome", outcome);
		
		String output = webResource.get(String.class);
		List<TaskData> tasks =parse(output);
		
		return "success";
	}

	public List<TaskData> getTasks(boolean potential) {

		Client client = Client.create();

		String user = userUtilAction.getCurrentUser().getUserName();
		
		String myURL  = URL  +  "tasks/"+ (!potential ? "my" : "potential") + "tasks";


		// Client client = ClientBuilder.newClient();
		WebResource webResource = client.resource(myURL);
		

//		List<TaskData> tasks = Client.create().resource(myURL)
//				.get(new GenericType<List<TaskData>>() {
//				});

		//webResource = webResource.path(myURL);
		webResource = webResource.queryParam("user", user);

		String output = webResource.get(String.class);
		List<TaskData> tasks =parse(output);

		//List<TaskData> tasks = new ArrayList<TaskData>(); // webResource.get(new
															// GenericType<List<TaskData>>(){});

		// ClientResponse response = webResource.accept("application/json")
		// .get(ClientResponse.class);

		// if (response.getStatus() != 200) {
		// throw new RuntimeException("Failed : HTTP error code : "
		// + response.getStatus());
		// }

		return tasks;
	}
	
	
	public List<TaskData> parse(String s){
		s = s.replace("[", "");
		s = s.replace("]", "");
		s = s.replace("{", "");
		s = s.replace("\"", "");
		
		List<TaskData> tasks = new ArrayList<TaskData>();

		// System.out.println(s);
		String data[] = s.split("}");
		
		for (String record : data) {
			String flds[] = record.split(",");

			TaskData td = new TaskData();

			Arrays.asList(flds).forEach(fld -> {

				String fldNamVal[] = fld.split(":");

				if (fldNamVal.length > 1) {

					try {
						BeanUtils.setProperty(td, fldNamVal[0], fldNamVal[1]);
					} catch (Exception e) {
					e.printStackTrace();
					}

			}
				
			

		});
			
		tasks.add(td);

		}
		
		return tasks;

	}

}
