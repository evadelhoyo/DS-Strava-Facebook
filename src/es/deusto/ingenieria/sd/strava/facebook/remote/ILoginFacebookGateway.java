package es.deusto.ingenieria.sd.strava.facebook.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILoginFacebookGateway extends Remote {
	public String getMail() throws RemoteException;
	public String getContrasena() throws RemoteException;
}
