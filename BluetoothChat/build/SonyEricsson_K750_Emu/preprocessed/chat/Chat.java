package chat;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Chat extends MIDlet {
    public TFrmMenu frmMenu;
    public TFrmTutup frmTutup;
    public TFrmBantuan frmBantuan;
    public TFrmInformasi frmInformasi;
    public TFrmServer frmServer;
    public TFrmServerMessage frmServerMessage;
    public TFrmServerMessageSend frmServerMessageSend;
    
    public TFrmClient frmClient;
    public TFrmClientMessage frmClientMessage;
    public TFrmClientMessageSend frmClientMessageSend;
    
    public BluetoothServer server;
    public BluetoothClient client;
    
    public Display display;
    public void startApp() {
        display = Display.getDisplay(this);
        frmMenu = new TFrmMenu(this);
        frmTutup = new TFrmTutup(this);
        frmBantuan = new TFrmBantuan(this);
        frmInformasi = new TFrmInformasi(this);
        
        frmServer = new TFrmServer(this);
        frmServerMessage = new TFrmServerMessage(this);
        frmServerMessageSend = new TFrmServerMessageSend(this);
        
        frmClient = new TFrmClient(this);
        frmClientMessage = new TFrmClientMessage(this);
        frmClientMessageSend=  new TFrmClientMessageSend(this);
        
        frmMenu.show();
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
        notifyDestroyed();
    }
    
    public void sleep(long delay) {
        try {
            Thread.sleep(delay);
        } catch (Exception e) {            
        }
    }
}
