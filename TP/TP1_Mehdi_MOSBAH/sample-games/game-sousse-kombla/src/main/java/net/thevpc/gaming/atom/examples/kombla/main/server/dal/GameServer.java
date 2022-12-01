package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.GameClientImpl;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameServer extends Remote {
    public StartGameInfo connect(String player, GameClientImpl gameClient);
    void moveRight() throws RemoteException;
    void moveLeft() throws RemoteException;
    void moveUp() throws RemoteException;
    void moveDown() throws RemoteException;
    void fire() throws RemoteException;


}
