package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.GameClientImpl;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.rmi.RemoteException;

public class GameServerImpl implements GameServer{
    MainServerDAOListener listener;
    StartGameInfo gameInfo;
    @Override
    public StartGameInfo connect(String player, GameClientImpl gameClient) {
        gameInfo=listener.onReceivePlayerJoined(player);

        return this.gameInfo;    }

    @Override
    public void moveRight() throws RemoteException {
        listener.onReceiveMoveRight(gameInfo.getPlayerId());

    }

    @Override
    public void moveLeft() throws RemoteException {
        listener.onReceiveMoveLeft(gameInfo.getPlayerId());

    }

    @Override
    public void moveUp() throws RemoteException {
        listener.onReceiveMoveUp(gameInfo.getPlayerId());

    }

    @Override
    public void moveDown() throws RemoteException {
        listener.onReceiveMoveDown(gameInfo.getPlayerId());

    }

    @Override
    public void fire() throws RemoteException {
        listener.onReceiveReleaseBomb(gameInfo.getPlayerId());

    }
}
