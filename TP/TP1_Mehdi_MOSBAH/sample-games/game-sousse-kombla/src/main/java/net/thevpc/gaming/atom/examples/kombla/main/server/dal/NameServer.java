package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class NameServer {
    public NameServer() {
    }
    public static void main(String[] args) throws InterruptedException {
        try {
            LocateRegistry.createRegistry(1234);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

        Object verrou = new Object();
        synchronized(verrou) {
            verrou.wait();
        }
    }
}
