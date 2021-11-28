package es.deusto.ingenieria.sd.strava.facebook.server;

import java.rmi.Naming;

import es.deusto.ingenieria.sd.strava.facebook.remote.LoginFacebookGateway;
import es.deusto.ingenieria.sd.strava.facebook.remote.ILoginFacebookGateway;

public class LoginFacebookServer {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			ILoginFacebookGateway remoteObject = LoginFacebookGateway.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * Currency Exchange Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.out.println(" # Currency Exchange Server: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}