package QapitolQA.data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;



public class DataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException
	{
		//read json to string
	String JsonContent =FileUtils.readFileToString(new File("C:\\Users\\QQA0325\\eclipse-workspace\\DemoSeleniumFramework\\src\\test\\java\\QapitolQA\\data\\Purchase.json"),StandardCharsets.UTF_8);
	
	// String to hashmap using jackson databind
	ObjectMapper mapper = new ObjectMapper();

	List<HashMap<String, String>> data = mapper.readValue(JsonContent,

	new TypeReference<List<HashMap<String, String>>>() {

	});

	return data;
	
	
	}
	
	
}
