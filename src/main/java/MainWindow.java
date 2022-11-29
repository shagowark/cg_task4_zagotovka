import javax.swing.*;

public class MainWindow extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel drawPanel;
    private DrawPanel dp;

    public MainWindow() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
    }

    public static void main(String[] args) {
        MainWindow dialog = new MainWindow();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        drawPanel = dp = new DrawPanel();
        // TODO: place custom component creation code here
    }
}
