package view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.User;


public class imagen extends javax.swing.JPanel {
    private int x, y;
    private User user;
    

    public imagen(JPanel jPanel1, User user) {
        this.user = user;
        this.x = jPanel1.getWidth();
        this.y = jPanel1.getHeight();
        this.setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
        
        ImageIcon Img;
        if(this.user.getRol().equals("Administrador")){
            Img = new ImageIcon(getClass().getResource("/imagenes/admin.png"));
        }else {
            Img = new ImageIcon(getClass().getResource("/imagenes/user.png"));
        }
        g.drawImage(Img.getImage(), 0, 0, x, y, null);
    }    

}
