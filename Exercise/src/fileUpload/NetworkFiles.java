package fileUpload;

import java.io.IOException;
import java.net.*;
import java.util.*;
import static java.lang.System.out;

public class NetworkFiles {

	 public static void main(String args[]) throws SocketException {
	        Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
	        for (NetworkInterface netint : Collections.list(nets))
	            displayInterfaceInformation(netint);
	        
	        try {
	        	checkHosts("255.255.255");
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
	        out.printf("Display name: %s\n", netint.getDisplayName());
	        out.printf("Name: %s\n", netint.getName());
	        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
	        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
	            out.printf("InetAddress: %s\n", inetAddress);
	        }
	        out.printf("\n");
	     }

	    public static void checkHosts(String subnet) throws UnknownHostException, IOException{
	    	   int timeout=1000;
	    	   for (int i=1;i<256;i++){
	    	       String host=subnet + "." + i;
	    	       System.out.print(host);
	    	       if (InetAddress.getByName(host).isReachable(timeout)){
	    	           System.out.print(" is reachable "+InetAddress.getByName(host).getAddress());
	    	       }
	    	       System.out.println();
	    	   }
	    	}
}
