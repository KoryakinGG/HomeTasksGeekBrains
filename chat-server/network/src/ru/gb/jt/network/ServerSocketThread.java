package ru.gb.jt.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Vector;

public class ServerSocketThread extends Thread {
    private final int port;
    private final int timeout;
    private final ServerSocketThreadListener listener;
  //  private Vector vectorArray;


    public ServerSocketThread(ServerSocketThreadListener listener, String name, int port, int timeout) {  //конструктор
        super(name);
        this.port = port;
        this.timeout = timeout;
        this.listener = listener;
        start();
    }

    @Override
    public void run() {  //подключаем поток
        listener.onServerStart(this);  //сообщаем листнеру, что в этом Thread, сервер старт
        try (ServerSocket server = new ServerSocket(port)) {  //слушаем порт в трай с ресурсами
            server.setSoTimeout(timeout);    // будет выходить из ассепта и в этот момент ему можно отдать другое распоряжение,но вываливает исключение, поэтому оборачиваем в трай - катч
            listener.onServerSocketCreated(this, server);  //сообщаем листнеру, что в этом Thread, в этом сервере создался сервер сокет
   //         vectorArray = new Vector();
            while (!isInterrupted()) {   //пока цикл не isInterrupted - работаем.
                Socket socket;              //создаем сокет и говорим ему ->
                try {
                    socket = server.accept();   //слушай порт своим серверным методом ассепт, висим всегда, но иногда выходим, с помощью timeout
                } catch (SocketTimeoutException e) {  //ловим исключения вызванные timeout
                    listener.onServerTimeout(this, server); //сообщаем листнеру, что в этом Thread, в этом сервере произошел таймаут
                    continue;
                }
                listener.onSocketAccepted(this, server, socket);//сообщаем листнеру, что в этом Thread, в этом сервере, этот сокет родился
              //  listener.onServerMessageToAll(socket);
            }
        } catch (IOException e) {
            listener.onServerException(this, e); //сообщаем листнеру, что в этом Thread, произошел эксепшн
        } finally {
            listener.onServerStop(this);//сообщаем листнеру, что в этом Thread, произошел стоп сервера
        }
    }


}
