package ui;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.TLSController;
import util.LoggerUtil;

public class TLSSystemTray {

    private static final Logger logger = LoggerUtil.getLogger(TLSSystemTray.class.getName());

    private boolean systemTrayEnabled;

    private TrayIcon trayIcon;

    private static TLSSystemTray instance;

    public static TLSSystemTray getInstance() {
        if (null == instance) {
            instance = new TLSSystemTray();
        }
        return instance;
    }

    private TLSSystemTray() {
        systemTrayEnabled = checkAWTEnv();
        if (systemTrayEnabled) {
            initSystemTray();
        }
    }

    public void showInfoMessage(String title, String text) {
        if (systemTrayEnabled) {
            trayIcon.displayMessage(title, text, TrayIcon.MessageType.INFO);
        }
    }

    public void showErrorMessage(String title, String text) {
        if (systemTrayEnabled) {
            trayIcon.displayMessage(title, text, TrayIcon.MessageType.ERROR);
        }
    }

    public void showWarningMessage(String title, String text) {
        if (systemTrayEnabled) {
            trayIcon.displayMessage(title, text, TrayIcon.MessageType.WARNING);
        }
    }

    private void initSystemTray() {
        try {
            PopupMenu popupMenu = new PopupMenu();

            MenuItem item1 = new MenuItem("Fuzzing Test 1");
            MenuItem item2 = new MenuItem("Info");
            MenuItem exitItem = new MenuItem("Exit");

            ActionListener tlsFuzzingTest1ActionListener = e -> TLSController.getInstance().mainTest();
            ActionListener infoActionListener = e -> logger.info("TODO");
            item1.addActionListener(tlsFuzzingTest1ActionListener);
            item2.addActionListener(infoActionListener);
            exitItem.addActionListener(e -> System.exit(0));

            popupMenu.add(item1);
            popupMenu.add(item2);
            popupMenu.addSeparator();
            popupMenu.add(exitItem);

            Image image = Toolkit.getDefaultToolkit().getImage("pics/TLSFuzzerLogo.png");

            trayIcon = new TrayIcon(image, "TLSFuzzer", popupMenu);
            trayIcon.setImageAutoSize(true);

            SystemTray tray = SystemTray.getSystemTray();
            tray.add(trayIcon);
        } catch (Exception e) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe("Error on init system tray");
            }
            e.printStackTrace();
        }
    }

    private boolean checkAWTEnv() {
        if (!SystemTray.isSupported()) {
            if (logger.isLoggable(Level.SEVERE)) {
                logger.severe("System tray is not supported!");
            }
            return false;
        }
        return true;
    }
}
