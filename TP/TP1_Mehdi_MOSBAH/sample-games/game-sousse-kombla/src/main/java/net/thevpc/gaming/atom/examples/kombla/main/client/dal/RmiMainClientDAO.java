package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.server.dal.GameServer;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiMainClientDAO implements MainClientDAO{
    private MainClientDAOListener listener;
    private AppConfig properties;
    private static Registry ns;
    private static GameServer g;

    @Override
    public void start(MainClientDAOListener listener, AppConfig properties) {
        try {
            ns = LocateRegistry.getRegistry(properties.getServerAddress(), properties.getServerPort());

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        this.listener = listener;
        this.properties = properties;


    }

    @Override
    public StartGameInfo connect() {

        StartGameInfo gameInfo;
        try {

            g = (GameServer) ns.lookup("Server");
            gameInfo = g.connect(properties.getPlayerName(), new GameClientImpl(listener));
        } catch (RemoteException | NotBoundException e) {
            throw new RuntimeException(e);
        }
        return gameInfo;
    }

    @Override
    public void sendMoveLeft() {
        try {
            g.moveLeft();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveRight() {
        try {
            g.moveRight();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveUp() {
        try {
            g.moveUp();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveDown() {
        try {
            g.moveDown();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendFire() throws IOException {
        try {
            g.fire();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
