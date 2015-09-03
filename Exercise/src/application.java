
public class application {

	public static void main(String[] args) throws Exception {
		
		
		        String fileName = "c:/RHDSetup.log";
		        String[] commands = {"cmd", "/c", "start", "\"DummyTitle\"",fileName};
		        Runtime.getRuntime().exec(commands);
		   
		//process.waitFor();		
	}
	
}
