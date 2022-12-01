/*
package net.thevpc.gaming.atom.examples.kombla.main.server.dal;

import net.thevpc.gaming.atom.examples.kombla.main.client.dal.MainClientDAOListener;
import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.ProtocolConstants;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketMainServerDAO implements MainServerDAO{

    private Map<Integer, ClientSession> playerToSocketMap =new HashMap<>();
    private MainClientDAOListener listener;
    private AppConfig properties;

    public SocketMainServerDAO(){

    }


    @Override
    public void start(MainServerDAOListener listener, AppConfig properties) {
        new Thread(()->{
                    try {
                        ServerSocket ss=new ServerSocket(properties.getServerPort());
                        while (true){
                            Socket s=ss.accept();
                            new Thread(
                                    ()->{
                                        try {
                                            processClient(s);
                                        }catch (Exception e){
                                            e.printStackTrace();
                                        }
                                    }
                            ).start();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    @Override
    public void start(MainClientDAOListener listener, AppConfig properties) {

    }

    @Override
    public void sendModelChanged(DynamicGameModel dynamicGameModel) {
        for (Map.Entry<Integer, ClientSession> entry: playerToSocketMap.entrySet()){
            try {
                entry.getValue().oos.writeObject(dynamicGameModel);

            }catch (IOException e){
                Logger.getLogger(SocketMainServerDAO.class.getName()).log(Level.SEVERE,null,e);
            }

        }
    }
    private void processClient(Socket s){
        try {
            ClientSession cs=new ClientSession();
            cs.playerSocket =s;
            cs.oos =new ObjectOutputStream(s.getOutputStream());
            cs.ois = new ObjectInputStream(s.getInputStream());
            cs.ois.readInt();
            cs.playerId =gameInfo.getPlayerId();

            String playerName=cs.ois.readUTF();

            StartGameInfo gameInfo=listener.onReceivePlayerJoined(playerName);
            cs.oos.writeInt(ProtocolConstants.OK);
            cs.oos.writeObject(gameInfo);
            playerToSocketMap.put(cs.playerId,cs);
            while (true){
                switch (cs.ois.readInt()){
                    case ProtocolConstant.UP:
                        listener.onReceiverMoveUp(cs.playerId);
                        break;
                    case ProtocolConstant.DOWN:
                        listener.onReceiverMoveDown(cs.playerId);
                        break;
                    case ProtocolConstant.LEFT:
                        listener.onReceiverMoveLeft(cs.playerId);
                        break;
                    case ProtocolConstant.RIGHT:
                        listener.onReceiverMoveRight(cs.playerId);
                        break;
                    case ProtocolConstant.FIRE:
                        listener.onReceiverReleaseBomb(cs.playerId);
                        break;
                    default:
                        throw new AssertionError();
                }
            }

        }catch (IOException e){
            Logger.getLogger(SocketMainServerDAO.class.getName()).log(Level.SEVERE,null,e);
        }



    }
    public class ClientSession {
        private int playerId;
        private Socket playerSocket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;

    }
}
*/
package net.thevpc.gaming.atom.examples.kombla.main.server.dal;


import net.thevpc.gaming.atom.examples.kombla.main.shared.dal.ProtocolConstants;
import net.thevpc.gaming.atom.examples.kombla.main.shared.engine.AppConfig;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.DynamicGameModel;
import net.thevpc.gaming.atom.examples.kombla.main.shared.model.StartGameInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketMainServerDAO implements MainServerDAO {
    private MainServerDAOListener listener;
    private AppConfig properties;

    class ClientSession {
        private int playerID;
        private Socket playerSocket;
        private ObjectInputStream ois;
        private ObjectOutputStream oos;

        public ClientSession(int playerID, Socket playerSocket, ObjectInputStream ois, ObjectOutputStream oos) {
            this.playerID = playerID;
            this.playerSocket = playerSocket;
            this.ois = ois;
            this.oos = oos;
        }
    }

    private Map<Integer, ClientSession> playerToSocketMap = new HashMap<>();

    @Override
    public void start(MainServerDAOListener listener, AppConfig properties) {
        this.listener = listener;
        this.properties = properties;
        new Thread(() -> {
            try {
                ServerSocket ss = new ServerSocket();
                while (true){
                    Socket s = ss.accept();
                    ObjectInputStream in = (ObjectInputStream) s.getInputStream();
                    ObjectOutputStream out = (ObjectOutputStream) s.getOutputStream();
                    String name = in.readUTF();
                    StartGameInfo startGameInfo = listener.onReceivePlayerJoined(name);
                    ClientSession client = new ClientSession(startGameInfo.getPlayerId(),s,in,out);
                    this.playerToSocketMap.put(startGameInfo.getPlayerId(),client);
                    out.writeObject(startGameInfo);
                    out.writeInt(ProtocolConstants.OK);
                    switch (client.ois.readInt()){
                        case ProtocolConstants.UP:
                            listener.onReceiveMoveUp(client.playerID);
                            break;
                        case ProtocolConstants.DOWN:
                            listener.onReceiveMoveDown(client.playerID);
                            break;
                        case ProtocolConstants.LEFT:
                            listener.onReceiveMoveLeft(client.playerID);
                            break;
                        case ProtocolConstants.RIGHT:
                            listener.onReceiveMoveRight(client.playerID);
                            break;
                        case ProtocolConstants.FIRE:
                            listener.onReceiveReleaseBomb(client.playerID);
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            } catch (IOException e) {
                Logger.getLogger(SocketMainServerDAO.class.getName()).log(Level.SEVERE,null,e);
            }

        }).start();
    }


    @Override
    public void sendModelChanged(DynamicGameModel dynamicGameModel) {
        for(Map.Entry<Integer,ClientSession> entry:this.playerToSocketMap.entrySet()){
            try{
                entry.getValue().oos.writeObject(dynamicGameModel);
            } catch (IOException e) {
                Logger.getLogger(SocketMainServerDAO.class.getName()).log(Level.SEVERE,null,e);
            }
        }
    }
}