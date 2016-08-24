import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
 
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.undo.UndoManager;
 
public class UndoText extends JFrame{
    private JMenuBar menuBar = null;
    private UndoManager um;
    private JTextArea area;
     
    public UndoText () {
        super();
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        area = new JTextArea();
        um = new UndoManager();
        area.getDocument().addUndoableEditListener(um);
        menuBar = new JMenuBar();
        menuBar.setBorder(null);
        setJMenuBar(menuBar);
        JMenu menu;
        JMenuItem menuItem;
         
        menu = new JMenu("编辑");
        menuItem = new JMenuItem("撤销");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK ));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (um.canUndo()) {
                    um.undo();
                }
            }   
        });
        menu.add(menuItem);
        menuItem = new JMenuItem("重做");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK ));
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (um.canRedo()) {
                    um.redo();
                }
            }   
        });
        menu.add(menuItem);
        menuBar.add(menu);
        getContentPane().add(area);
    }
     
    public static void main(String[] args) {
        UndoText text = new UndoText();
        text.setVisible(true);
    }
 
}