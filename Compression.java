import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
 

import java.awt.*;
import java.awt.event.*;

class Compression extends Frame implements ActionListener,WindowListener
{
 FileInputStream fis;
 FileOutputStream fos;
 GZIPOutputStream df;
 GZIPInputStream  ff;
 byte[] buffer;
 int len;
           
 Label l,l2,l3;
 Button b,b2;
 TextField t,t2;
 Compression()
 {
 setLayout(null);
 l2=new Label("Source path");
 l=new Label("File Compression and Decompression");
 l3=new Label("Destinaton");
 b=new Button("COMPRESS");
 b2=new Button("DECOMPRESS");
 t=new TextField(100);
 t2=new TextField(100);
 setVisible(true);
 setSize(500,500);
 setBackground(Color.ORANGE);
 addWindowListener(this);
 b.addActionListener(this);
 b2.addActionListener(this);
 l.setBounds(60,20,350,50);
 l2.setBounds(25,75,75,50);
 l3.setBounds(25,150,75,50);
 t.setBounds(110,75,200,30);
 t2.setBounds(110,150,200,30);
 b.setBounds(110,225,100,25);
 b2.setBounds(255,225,100,25);
 add(l);
 add(b);
 add(t); 
 add(t2);
 add(l2);
 add(l3);
 add(b2);
}

 public void windowClosed(WindowEvent ev){}
 public void windowOpened(WindowEvent ev){}
 public void windowActivated(WindowEvent ev){}
 public void windowDeactivated(WindowEvent ev){}
 public void windowIconified(WindowEvent ev){}
 public void windowDeiconified(WindowEvent ev){}
 public void windowClosing(WindowEvent ev)
 {
  System.exit(0);
 }


 public void actionPerformed(ActionEvent e1)
 {
 if(e1.getSource()==b)
 {
  try {
            fis = new FileInputStream(t.getText());
            fos = new FileOutputStream(t2.getText());
            df = new GZIPOutputStream(fos);
            buffer = new byte[2048];
            int len;
            while((len=fis.read(buffer)) != -1){
                df.write(buffer, 0, len);
            }
            //close resources
            df.close();
            fos.close();
            fis.close();
        } catch (Exception ee) 
           {
             t.setText("file not found enter valid location");
           
        } 

 t.setText("File Successfully Compressed");  
    }
 
 

 else if(e1.getSource()==b2)
 {
try {
            fis = new FileInputStream(t.getText());
            ff  = new GZIPInputStream(fis);
            fos = new FileOutputStream(t2.getText());
            
            buffer = new byte[2048];
            int len;
            while((len=ff.read(buffer)) != -1){
                fos.write(buffer, 0, len);
            }
            //close resources
            ff.close();
            fos.close();
            fis.close();
        } catch (Exception eg) 
           {
             t.setText("file not found enter valid location");
           
        } 
t.setText("File Successfully deCompressed");
    } 
}

 
 
 public static void main(String args[])
 {
 Compression a1 = new Compression();
 }
}  