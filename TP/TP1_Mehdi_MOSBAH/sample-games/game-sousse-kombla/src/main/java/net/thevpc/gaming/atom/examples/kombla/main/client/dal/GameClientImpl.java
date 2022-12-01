package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;

import java.rmi.RemoteException;

public class GameClientImpl implements GameClient{
    MainClientDAOListener listener;
    protected GameClientImpl(MainClientDAOListener listener) throws RemoteException {
        this.listener=listener;
    }
    @Override
    public void modelChanged(DynamicGameModel dynamicGameModel) throws RemoteException {
        listener.onModelChanged(dynamicGameModel);

    }
}
