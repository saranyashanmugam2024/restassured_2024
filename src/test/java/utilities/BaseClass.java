package utilities;



public class BaseClass {
	public static String getBaseUrl() {
        return ConfigReader.getProperty("base_url");
    }

    public static String getUsername() {
        return ConfigReader.getProperty("username");
    }

    public static String getPassword() {
        return ConfigReader.getProperty("password");
    }

    public static String getAllUsersEndpoint () {
        return ConfigReader.getProperty("get_all_users_endpoint");
    }
    public static String  createUserEndpoint() {
    	return ConfigReader.getProperty("create_User_Endpoint");
    }
    
    public static String updateUserEndpoint(int userId) {
        String updateendpoint = ConfigReader.getProperty("update_User_Endpoint");
        return updateendpoint.replace("{userId}", String.valueOf(userId));
    }
    public static String getUserEndpoint(int userId) {
        String Getendpoint = ConfigReader.getProperty("get_User_Endpoint");
        return Getendpoint.replace("{userId}", String.valueOf(userId));
    }
    public static String getUserFristnameEndpoint(String userfirstname) {
        String Getendpoint = ConfigReader.getProperty("get_User_firstnme_Endpoint");
        return Getendpoint.replace("{userFirstName}", String.valueOf(userfirstname));
    }
    
    public static String deleteUserEndpoint(int userId) {
        String Getendpoint = ConfigReader.getProperty("delete_User_Endpoint");
        return Getendpoint.replace("{userId}", String.valueOf(userId));
    }
}