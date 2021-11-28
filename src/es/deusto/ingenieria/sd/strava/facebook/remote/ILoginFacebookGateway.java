package es.deusto.ingenieria.sd.strava.facebook.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginFacebookGateway extends Remote {
	public float getUSDRate() throws RemoteException;
	public float getGBPRate() throws RemoteException;
}
