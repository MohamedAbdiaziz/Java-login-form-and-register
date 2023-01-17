import java.util.HashMap;

public class UserandPass {
	HashMap<String,String> loginInfo = new HashMap<String,String>();
	
	// constructor
	UserandPass(){
		loginInfo.put("Moha", "1234");
		loginInfo.put("Ali", "123");
	}
	
	protected HashMap<String, String> getLoginInfo(){
		return loginInfo;
	}
}
