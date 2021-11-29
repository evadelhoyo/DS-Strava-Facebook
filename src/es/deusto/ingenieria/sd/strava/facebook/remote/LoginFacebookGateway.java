package es.deusto.ingenieria.sd.strava.facebook.remote;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginFacebookGateway extends UnicastRemoteObject implements ILoginFacebookGateway {
	private static final long serialVersionUID = 1L;

	public static String EMAIL = "eva@gmail.com";
	public static String CONTRASENA = "abc123!";
	
	//Attribute for the Singleton pattern
	public static LoginFacebookGateway instance;
			
	private LoginFacebookGateway() throws RemoteException {
		super();
		getConversionRates();
	}
	
	public static LoginFacebookGateway getInstance() {
		if (instance == null) {
			try {
				instance = new LoginFacebookGateway();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}

	private static final void getConversionRates() {
		/*System.out.println(" - Getting exchange rates from 'free.currconv.com'....");
		
		try {			
			HttpURLConnection con = (HttpURLConnection) (new URL(URL).openConnection());			
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			
			con.disconnect();

			inputLine = response.toString();
			USD_RATE = Float.parseFloat(inputLine.substring(inputLine.indexOf(":")+1, inputLine.indexOf(",")));
			GBP_RATE = Float.parseFloat(inputLine.substring(inputLine.lastIndexOf(":")+1, inputLine.indexOf("}")));
		} catch(Exception ex) {
			System.out.println("  # Error getting conversion rates(): " + ex.getMessage());
		}
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/YYYY - HH:mm");
		
		
		System.out.println(" - Exchange rates obtained (" + dateFormatter.format(Calendar.getInstance().getTime()) + ")!!");
		System.out.println("\t- EURO to USD rate: " + USD_RATE);
		System.out.println("\t- EURO to GBP rate: " + GBP_RATE);
		*/
	}
	
	public String getMail() throws RemoteException {
		getConversionRates();
		return EMAIL;
	}

	public String getContrasena() throws RemoteException {
		getConversionRates();
		return CONTRASENA;
	}
}