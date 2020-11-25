/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ltmail.ltmailclient;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JFrame;
import ltmail.ltmailclient.forms.LoginForm;

/**
 *
 * @author qquan
 */
public class Application {
    
    public static final String SERVER_ADDRESS = "127.0.0.1";
    public static final int SERVER_PORT = 5000;
    
    public static void init() throws IOException {
        instance = new Application();
    }
    
    public static Application getInstance() throws NullPointerException {
        return instance;
    }
    
    public void run() {
        mainWindow.add(loginForm);
        loginForm.setEnabled(true);
    }

    private Application() throws IOException {
        
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        
        mainWindow = new JFrame();
        mainWindow.setLayout(new BorderLayout());
        mainWindow.setEnabled(true);
        mainWindow.setVisible(true);
        
        loginForm = new LoginForm();
    }
    
    private static Application instance;
    private final Socket socket;
    private final JFrame mainWindow;
    
    private final LoginForm loginForm;
    
}
