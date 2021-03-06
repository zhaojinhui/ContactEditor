/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.contacteditor;

import contacteditor.ContactEditor;
import java.awt.image.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.ServerSocket;
import java.util.Properties;
import javax.imageio.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.ImageIcon;
/**
 *
 * @author Jinhui Zhao
 */
public class ContactEditorUI extends javax.swing.JFrame {
    
    final static String LOGFILENAME = "ContactEditor_"; 
    final static String PROPERTYFILENAME = "configure.properties";
    final static String LOGOFILEPATH = "logo.png";
    static Properties props;
    static Queue<String> fileNames = new LinkedList<String>();
    private static final Object lock = new Object();
    static HashMap<String, String> map; 
    static ContactEditorUI currentObj;
    static BufferedWriter logWriter;
    static Logger logger = Logger.getLogger(ContactEditorUI.class.getName());
    static FileHandler fileHandler;
    static SimpleFormatter formatter;
    
    public ContactEditorUI() {
        try {
            // init the logger object
            //try{
                //Date date = new Date(); 
                //String yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd").format(date);
                //String logFileName = LOGFILENAME + yyyyMMdd + ".log"; 
    		//fileHandler =new FileHandler(logFileName, true);
                //logger.addHandler(fileHandler);
                //formatter = new SimpleFormatter();  
                //fileHandler.setFormatter(formatter);
            //}catch(IOException e){
            //    e.printStackTrace();
            //}
            currentObj = this;
            fileNames = new LinkedList<String>();
            map = new HashMap<String, String>();
            // init content in the configure.properties file
            props = new Properties();
            InputStream is;
            try {
                is = new FileInputStream(new File(PROPERTYFILENAME));
            } catch(Exception e) {
                is = null;
            }
            try {
                if(is == null)
                    is = getClass().getResourceAsStream(PROPERTYFILENAME);
                props.load(is);
                logger.info("properties load successfully.\n");
            } catch(Exception e) {
                logger.warning(e.getMessage()+"\n");
            }
            initComponents();
        
            rightRotateDegree.addItem("0");
            rightRotateDegree.addItem("90");
            rightRotateDegree.addItem("180");
            rightRotateDegree.addItem("270");

            leftRotateDegree.addItem("0");
            leftRotateDegree.addItem("90");
            leftRotateDegree.addItem("180");
            leftRotateDegree.addItem("270");
            
            ImageIcon imgicon = new ImageIcon("logo.png");
            
            this.setIconImage(imgicon.getImage());
        
            inputPath.setText(props.getProperty("inputPath"));
            outputPath.setText(props.getProperty("outputPath"));
            leftRotateDegree.select(props.getProperty("lRotateDegree"));
            leftPicturePath.setText(props.getProperty("leftPicPath"));
            rightRotateDegree.select(props.getProperty("rRotateDegree"));
            rightPicturePath.setText(props.getProperty("rightPicPath"));
        } catch(Exception e) {
            logger.warning(e.getMessage()+"\n");
        }       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        inputPathLabel = new javax.swing.JLabel();
        inputPath = new javax.swing.JTextField();
        outputPathLabel = new javax.swing.JLabel();
        outputPath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        leftPicturePath = new javax.swing.JTextField();
        leftRotateDegree = new java.awt.Choice();
        jLabel2 = new javax.swing.JLabel();
        rightPicturePath = new javax.swing.JTextField();
        rightRotateDegree = new java.awt.Choice();
        saveConfiguration = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3D Bean");
        setMaximumSize(new java.awt.Dimension(430, 270));
        setPreferredSize(new java.awt.Dimension(430, 270));
        setResizable(false);

        inputPathLabel.setText("  Input path:");

        outputPathLabel.setText("Output path:");

        jLabel1.setText("L Pic Path:");

        jLabel2.setText("R Pic Path:");

        saveConfiguration.setText("Save Configuration");
        saveConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveConfigurationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(outputPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(inputPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(leftPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leftRotateDegree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(outputPath)
                            .addComponent(inputPath)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rightPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rightRotateDegree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputPathLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(outputPath, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(leftPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(leftRotateDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(rightPicturePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rightRotateDegree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveConfiguration)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("Configurations", jPanel1);

        logInfo.setColumns(20);
        logInfo.setRows(5);
        jScrollPane1.setViewportView(logInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Log Information", jPanel2);

        jTabbedPane1.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//GEN-FIRST:event_saveConfigurationActionPerformed
 
//GEN-LAST:event_saveConfigurationActionPerformed
    
    // create the target image
    static private void mergeImg(String lpathName, String rpathName, String[] strArray) {
        try {
            String filePath = props.getProperty("inputPath");
            String lPicName = filePath + "\\" + lpathName;
            double lRotateDegree = Double.parseDouble(props.getProperty("lRotateDegree"));
            String rPicName = filePath + "\\" + rpathName;
            double rRotateDegree = Double.parseDouble(props.getProperty("rRotateDegree"));         
            BufferedImage lPicture = rotateImage(loadImage(lPicName), lRotateDegree);
            BufferedImage rPicture = rotateImage(loadImage(rPicName), rRotateDegree);
            mergeImage(lPicture, rPicture, 38, strArray);
            logger.info("Iamge created.\n");
        } catch(Exception e) {
            logger.warning(e.getMessage()+"\n");
        }
    }
    
    // rotate target image according to the degree
    static private BufferedImage rotateImage (BufferedImage pic, double degree) {
        int w = pic.getWidth(),
            h = pic.getHeight();
        double  sin = Math.abs(Math.sin(Math.toRadians(degree))),
                cos = Math.abs(Math.cos(Math.toRadians(degree)));
        
        int neww = (int) Math.floor(w*cos + h*sin),
            newh = (int) Math.floor(h*cos + w*sin);
        BufferedImage dst = new BufferedImage(neww, newh, pic.getType());
        Graphics2D g2 = dst.createGraphics();
        g2.translate((neww-w)/2, (newh-h)/2);
        g2.rotate(Math.toRadians(degree), w/2, h/2);
        g2.drawImage(pic, null, 0, 0);
        g2.dispose();
        return dst;
    }
    
    // load image from specific file path
    static private BufferedImage loadImage (String fileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
            logger.warning(e.getMessage());
        }
        return img;
    }
    
    // merge left image and right image
    static private void mergeImage(BufferedImage lPic, BufferedImage rPic, int offSet, String[] strArray) {
        try{
            int w = lPic.getWidth() + rPic.getWidth() + offSet;
            int h = Math.max(lPic.getHeight(), rPic.getHeight());
            BufferedImage dst = new BufferedImage(w, h, lPic.getType());
            Graphics2D g2 = dst.createGraphics();
            g2.drawImage(lPic, null, 0, 0);
            g2.drawImage(rPic, null, lPic.getWidth()+offSet, 0);
            BufferedImage logo = loadImage(LOGOFILEPATH);
            overlayImage(dst, logo, strArray);
            g2.dispose();
        } catch(Exception e) {
            logger.warning(e.getMessage());
        }
    }
    
    // put the logo and text on the top of the merged left picture and right picture
    static private void overlayImage(BufferedImage background, BufferedImage top, String[] strArray) {
        try {
            float alpha = 1.0f;
            AlphaComposite ac;
            BufferedImage overlay = new BufferedImage(background.getWidth(), background.getHeight(),background.getType());
            Graphics2D g2 = overlay.createGraphics();
            ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
            g2.drawImage(background, 0, 0, null);
            //g2.setComposite(ac);
            g2.drawImage(top, 6152, 4918, null);
            //g2.setComposite(ac);
            g2.setPaint(Color.black);
            g2.setFont(new Font("Calibri Light", Font.PLAIN, 90));
            String s = "   [" + strArray[0].substring(2) + "]" + "\n" + strArray[1] + " #" + strArray[2];
            int w = top.getWidth();
            int tw = g2.getFontMetrics().stringWidth("  [" + strArray[0].substring(2) + "]" + "\n");
            int textTop = 6152 + w - tw-20;
            drawString(g2, s, textTop, 4753);
            String desFilePath = props.getProperty("outputPath");
            String rPicDstPath = desFilePath + "\\" + strArray[0] + "\\" + strArray[1] + "\\" + strArray[2] + ".jpg";
            (new File(desFilePath + "\\" + strArray[0] + "\\" + strArray[1])).mkdirs();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String logMsg = "[" + dateFormat.format(date).toString() + "]   " + strArray[1] + " - " + strArray[2] + ".jpg succssfully exported!\n";
            try {
                currentObj.logInfo.setCaretPosition(currentObj.logInfo.getDocument().getLength());
                currentObj.logInfo.append(logMsg);
                logger.info(logMsg);
                ImageIO.write(overlay, "jpg", new File(rPicDstPath));
            } catch (Exception e) {
                logger.warning(e.getMessage());
            } 
            g2.dispose();
        } catch(Exception e) {
            logger.warning(e.getMessage());
        }
    }
    
    // enable the "\n" function in the img
    static private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split("\n"))
            g.drawString(line, x, y += g.getFontMetrics().getHeight()- 20);
    }
    
   private void saveConfigurationActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        saveConfigureProperties();
        InputStream is = null;
        try {
            is = new FileInputStream(new File("configure.properties"));
        } catch(Exception e) {
            is = null;
            currentObj.logInfo.append(e.getMessage());
            //System.out.println(e.getMessage());
        }
        try {
            if(is == null)
                is =  getClass().getResourceAsStream("configure.properties");
            props.load(is);
        } catch(Exception e) {
            currentObj.logInfo.append(e.getMessage());
        }
    }
    private void saveConfigureProperties() {
        try {
            Properties props = new Properties();
            props.setProperty("inputPath", inputPath.getText());
            props.setProperty("outputPath", outputPath.getText());
            props.setProperty("leftPicPath", leftPicturePath.getText());
            props.setProperty("rightPicPath", rightPicturePath.getText());
            props.setProperty("lRotateDegree", leftRotateDegree.getSelectedItem());
            props.setProperty("rRotateDegree", rightRotateDegree.getSelectedItem());
            OutputStream out = new FileOutputStream(new File(PROPERTYFILENAME));
            props.store(out, "Store the configure values");
        } catch(Exception e) {
            currentObj.logInfo.append(e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ContactEditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        Thread mergeImgThread;
        
        mergeImgThread = new Thread() {
            String tempFilePath;
            public void run() {
                try {
                    Runtime.getRuntime().exec("python smartshooter_listen.py");
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                while(true) {
                    synchronized(lock) {
                        if(!fileNames.isEmpty())
                            tempFilePath = fileNames.poll();
                        else 
                            tempFilePath = null;
                    }
                    if(tempFilePath != null) {
                        String[] strArray = tempFilePath.split("\\\\");
                        if(strArray[3].equals(props.getProperty("leftPicPath")) || strArray[3].equals(props.getProperty("rightPicPath"))) {
                            String key = strArray[0] + strArray[1] + strArray[2];
                            logger.info(key);
                            if(map.containsKey(key)) {
                                mergeImg(map.get(key), tempFilePath, strArray);
                                map.remove(key);
                            } else {
                                map.put(key, tempFilePath);
                            }
                        }
                    }
                }
            }
        };
        
        Thread addFileNameThread;
        addFileNameThread = new Thread() {
            public void run() {
                try {
                    ServerSocket s = new ServerSocket(50000);
                    Socket ss = s.accept();
                    
                    BufferedReader in = new BufferedReader(new InputStreamReader(ss.getInputStream()));
                    while(true) {
                        String filePath = in.readLine();
                        synchronized(lock) {
                            fileNames.add(filePath);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }  
        };

        addFileNameThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(ContactEditorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        mergeImgThread.start();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                new ContactEditorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputPath;
    private javax.swing.JLabel inputPathLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField leftPicturePath;
    private java.awt.Choice leftRotateDegree;
    private javax.swing.JTextArea logInfo;
    private javax.swing.JTextField outputPath;
    private javax.swing.JLabel outputPathLabel;
    private javax.swing.JTextField rightPicturePath;
    private java.awt.Choice rightRotateDegree;
    private javax.swing.JButton saveConfiguration;
    // End of variables declaration//GEN-END:variables
}
