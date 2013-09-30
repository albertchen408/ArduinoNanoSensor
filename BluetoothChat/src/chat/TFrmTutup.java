package chat;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;

public class TFrmTutup extends Form  implements CommandListener {
    private Chat c;
    private char sender;
    public TFrmTutup(final Chat c) {
        super("Tutup");
        this.c = c;
        append("Apakah aplikasi ini akan ditutup?");
        addCommand(new Command("Ya", Command.OK, 0));
        addCommand(new Command("Tidak", Command.BACK, 1));
        setCommandListener(this);
    }
    
    public void show(char sender) {
        this.sender = sender;
        c.display.setCurrent(this);
    }
    
    public void commandAction(Command command, Displayable displayable) {
        if (command.getLabel().equals("Ya")) {
            c.destroyApp(true);
        } else {
            if (sender == 's') {
                
            } else if (sender == 'c') {
                
            } else {
                c.frmMenu.show();
            }
        }
    }
}
