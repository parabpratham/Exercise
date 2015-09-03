package fileUpload;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Program to display current computer name, IP Address and network interfaces
 * 
 * @author sahir maredia (Kotia Solutions)
 * 
 */
public class ComputerName {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			InetAddress ipaddress = InetAddress.getLocalHost();
			System.out.println("Computer Host Name : "
					+ ipaddress.getHostName());
			System.out.println("IP Address of Localhost : "
					+ ipaddress.getHostAddress());
			Properties p = System.getProperties();
			String os = p.getProperty("os.name");
			String home = p.getProperty("user.home");
			System.out.println(os+"--"+home);
			
			/*SmbFile[] domains;
	        try {
	            domains = (new SmbFile("smb://")).listFiles();
	            for (int i = 0; i < domains.length; i++) {
	                System.out.println(domains[i]);
	                SmbFile[] servers = domains[i].listFiles();
	                for (int j = 0; j < servers.length ; j++) {
	                    System.out.println("\t"+servers[j]);
	                }
	            }
	        } catch (SmbException e) {
	            e.printStackTrace();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }*/

			// getting list of network interfaces
			Enumeration<NetworkInterface> interfaces = NetworkInterface
			.getNetworkInterfaces();

			System.out.println();
			System.out
			.println("================ Following are the available network interfaces ===============");
			System.out.println();
			if (interfaces == null) {
				System.out.println("No network interfaces found");
			} else {

				for (NetworkInterface netIf : Collections.list(interfaces)) {
					System.out.println("Display Name : "
							+ netIf.getDisplayName());
					System.out.println("Name : " + netIf.getName());
					System.out.println();
				}
			}
		} catch (UnknownHostException ex) {
			System.out.println("Error Occured : " + ex.getMessage());
		} catch (SocketException e) {
			System.out.println("Error Occured : " + e.getMessage());
		}
	}

}
