package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.GameClient;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServerDAO implements MainServerDAO{
    private static Registry ns;

    @Override
    public void start(MainServerDAOListener listener, AppConfig properties) {
        try {
            ns = LocateRegistry.getRegistry(properties.getServerAddress(), properties.getServerPort());
            ns.bind("gameserver",  new GameServerImpl());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sendModelChanged(DynamicGameModel dynamicGameModel) {
        GameClient client = null;
        try {
            client.modelChanged(dynamicGameModel);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
