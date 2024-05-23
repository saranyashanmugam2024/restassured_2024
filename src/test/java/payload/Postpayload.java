package payload;
import utilities.PayloadReader;

public class Postpayload {
	
	
	

	public static String getUserPayload() {
	    String filePath = "C:\\Users\\eeera\\OneDrive\\Desktop\\TestDataSaranya\\datafile.json";
	    return PayloadReader.getPayloadFromJson(filePath);
	}

	    
	    
	    public static String updatePayload() {
	    	 String filePath = "C:\\Users\\eeera\\OneDrive\\Desktop\\TestDataSaranya\\updatedatafile.json";
		 	    return PayloadReader.getPayloadFromJson(filePath);
	    }
	    

}