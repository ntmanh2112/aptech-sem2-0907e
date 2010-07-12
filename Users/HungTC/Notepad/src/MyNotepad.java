

    import java.awt.Color;
    import java.awt.Font;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.InputEvent;
    import java.awt.event.KeyEvent;
    import java.awt.event.WindowEvent;
    import java.awt.event.WindowListener;
    import java.io.FileInputStream;
    import java.io.FileOutputStream;
    import java.io.PrintWriter;
    import java.util.Scanner;

    import javax.swing.*;

    public class MyNotepad extends JFrame implements ActionListener{
       JMenuBar menuBar;
       JMenu fileMenu, editMenu;
       JMenuItem openMenuItem, saveMenuItem, exitMenuItem,
       copyMenuItem, cutMenuItem, pasteMenuItem, fontMenuItem;
       JTextArea textArea;
       JPanel panel;

       public MyNotepad(){
          setSize(500, 500);
          creatPane();
          setVisible(true);
          addWindowListener(new WindowListener(){

             @Override
             public void windowActivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
             }

             @Override
             public void windowClosed(WindowEvent e) {
                // TODO Auto-generated method stub
                
             }

             @Override
             public void windowClosing(WindowEvent e) {
                exitNotepad();
                
             }

             @Override
             public void windowDeactivated(WindowEvent e) {
                // TODO Auto-generated method stub
                
             }

             @Override
             public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
             }

             @Override
             public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub
                
             }

             @Override
             public void windowOpened(WindowEvent e) {
                // TODO Auto-generated method stub
                
             }
             
          });
       }
       void creatPane(){
          
          panel=new JPanel();
          panel.setBackground(Color.white);
          getContentPane().add(panel);
          
          textArea=new JTextArea();
          add(textArea);
          
          menuBar=new JMenuBar();
          menuBar.setBackground(Color.pink);
          
          fileMenu=new JMenu("File");
          fileMenu.setBackground(Color.pink);
          menuBar.add(fileMenu);
          
          editMenu=new JMenu("Edit");
          editMenu.setBackground(Color.pink);
          menuBar.add(editMenu);
          
          openMenuItem=new JMenuItem("Open");
          KeyStroke openKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK);
          openMenuItem.setAccelerator(openKeyStroke);
          openMenuItem.setBackground(Color.pink);
          openMenuItem.addActionListener(this);
          fileMenu.add(openMenuItem);
          
          saveMenuItem=new JMenuItem("Save");
          KeyStroke saveKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
          saveMenuItem.setBackground(Color.pink);
          saveMenuItem.setAccelerator(saveKeyStroke);
          saveMenuItem.addActionListener(this);
          fileMenu.add(saveMenuItem);
          
          exitMenuItem= new JMenuItem("Exit");
          exitMenuItem.setBackground(Color.pink);
          KeyStroke exitKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK);
          exitMenuItem.setAccelerator(exitKeyStroke);
          exitMenuItem.addActionListener(this);
          fileMenu.add(exitMenuItem);
          
          copyMenuItem=new JMenuItem("Copy");
          KeyStroke copyKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK);
          copyMenuItem.setBackground(Color.pink);
          copyMenuItem.setAccelerator(copyKeyStroke);
          copyMenuItem.addActionListener(this);
          editMenu.add(copyMenuItem);
          
          cutMenuItem=new JMenuItem("Cut");
          KeyStroke cutKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK);
          cutMenuItem.setBackground(Color.pink);
          cutMenuItem.setAccelerator(cutKeyStroke);
          cutMenuItem.addActionListener(this);
          editMenu.add(cutMenuItem);
          
          pasteMenuItem=new JMenuItem("Paste");
          KeyStroke pasteKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK);
          pasteMenuItem.setBackground(Color.pink);
          pasteMenuItem.setAccelerator(pasteKeyStroke);
          pasteMenuItem.addActionListener(this);
          editMenu.add(pasteMenuItem);
          
          fontMenuItem=new JMenuItem("Font");
          KeyStroke fontKeyStroke=KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK);
          fontMenuItem.setBackground(Color.pink);
          fontMenuItem.setAccelerator(fontKeyStroke);
          fontMenuItem.addActionListener(this);
          editMenu.add(fontMenuItem);
          
                
          setJMenuBar(menuBar);
       
       }
       private void openFile(){
          JFileChooser file= new JFileChooser();
          if(file.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
             try {
                String selFile=file.getSelectedFile().getAbsolutePath();
                Scanner scanner=new Scanner(new FileInputStream(selFile), "UTF-8");
                String line="";
                while(scanner.hasNextLine()){
                   line+=scanner.nextLine();
                   textArea.setText(line);
                   scanner.close();
                }
             } catch (Exception e) {
                e.printStackTrace();
             }
          }
       }
       private void saveFile() {
          JFileChooser file=new JFileChooser();
          if(file.showSaveDialog(this)==JFileChooser.APPROVE_OPTION);
          try {
             String selFile=file.getSelectedFile().getAbsolutePath()+".txt";
             PrintWriter out=new PrintWriter(new FileOutputStream(selFile), true);
             out.print(textArea.getText());
             out.close();
          } catch (Exception e) {
             e.printStackTrace();
          }
          
       }

       private void exitNotepad() {
          if(textArea.getText().length()<1){
             System.exit(1);
          }else if(textArea.getText()!=null) {
             int temp=JOptionPane.showConfirmDialog(null, "are you want to save?");
             if(temp==0){
                saveFile();
             }else if(temp==1){
                System.exit(1);
             }
          }
       }

       @Override
       public void actionPerformed(ActionEvent e) {
          Object o=e.getSource();
          if(o.equals(exitMenuItem)){
             exitNotepad();
          }else if (o.equals(openMenuItem)) {
             openFile();
          }else if (o.equals(saveMenuItem)) {
             saveFile();
          }else if (o.equals(copyMenuItem)) {
             textArea.copy();
          }else if (o.equals(cutMenuItem)) {
             textArea.cut();
          }else if (o.equals(pasteMenuItem)) {
             textArea.paste();
          }else if (o.equals(fontMenuItem)) {
    //         fontNotepad(); chua lam!
          }
       
       }
       
       public static void main(String[] args) {
          JFrame frame=new MyNotepad();
       }

    }