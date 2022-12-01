package net.thevpc.gaming.atom.examples.kombla.main.client.dal;

import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.ProtocolConstants;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class SocketMainClientDAO implements MainClientDAO {
    private MainClientDAOListener listener;
    private AppConfig properties;

    public Socket socket;

    ObjectInputStream ois;
    public ObjectOutputStream oos;

    public StartGameInfo o;

    public DynamicGameModel model;


    @Override
    public void start(MainClientDAOListener listener, AppConfig properties) {
        this.listener = listener;
        this.properties = properties;
    }

    @Override
    public StartGameInfo connect() {
        try {
            socket = new Socket(                         //newSeverSocket+accept
                    properties.getServerAddress(),
                    properties.getServerPort());

            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());

            oos.writeInt(ProtocolConstants.CONNECT);          //readInt

            oos.writeUTF(properties.getPlayerName());        //readUTF

            o = (StartGameInfo) ois.readObject();
            new Thread(()->waitForServer()).start();

            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void waitForServer(){
        try {
            while (true){
                model=(DynamicGameModel) ois.readObject();     //writeObject
            }

        }
        catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveLeft() {
        try {
            oos.writeInt(ProtocolConstants.LEFT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveRight() {
        try {
            oos.writeInt(ProtocolConstants.RIGHT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveUp() {
        try {
            oos.writeInt(ProtocolConstants.UP);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendMoveDown() {
        try {
            oos.writeInt(ProtocolConstants.DOWN);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendFire() throws IOException {
        oos.writeInt(ProtocolConstants.FIRE);
    }

}
