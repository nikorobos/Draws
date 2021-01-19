
package choose_from;



import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.text.NumberFormatter;
import org.apache.commons.io.FilenameUtils;

public class Knuth extends JFrame implements ActionListener {

    JLabel listContains, itemsToDraw, successDraw, fileCreated;

    JFrame f;
    JButton open, save, shuffle, restart;
    JSpinner area;
    ArrayList<String> list = new ArrayList<>();

    File file;

    Knuth() {
        f = new JFrame();
        f.setTitle("Durstenfeld-Knuth Shuffle");
        listContains = new JLabel();
        listContains.setBounds(137, 47, 300, 80);

        itemsToDraw = new JLabel();
        itemsToDraw.setBounds(140, 104, 300, 30);

        successDraw = new JLabel();
        successDraw.setBounds(220, 207, 250, 30);

        fileCreated = new JLabel();
        fileCreated.setBounds(147, 327, 357, 30);

        open = new JButton("Open Candidate File");
        open.setBounds(273, 10, 180, 30);
        open.addActionListener(this);

        save = new JButton("Save File");
        save.setBounds(177, 267, 180, 30);
        save.addActionListener(this);

        shuffle = new JButton();
        shuffle.setBounds(177, 157, 180, 30);
        shuffle.addActionListener(this);

        restart = new JButton("Restart");
        restart.setBounds(75, 10, 180, 30);
        Color color = Color.decode("#f59042");
        restart.setForeground(color);
        restart.addActionListener(this);

        f.add(listContains);

        f.add(itemsToDraw);
        f.add(successDraw);

        f.add(fileCreated);

        f.add(open);
        f.add(save);
        f.add(shuffle);
        f.add(restart);

        listContains.setVisible(true);
        itemsToDraw.setVisible(false);
        successDraw.setVisible(false);
        fileCreated.setVisible(false);
        shuffle.setVisible(false);
        save.setVisible(false);

        f.setSize(550, 450);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setBackground(Color.GRAY);
        f.setVisible(true);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyy-HH.mm.ss");
        Date date = new Date();
        String dateToStr = formatter.format(date);
        if (e.getSource() == open) {

            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(new FileNameExtensionFilter("txt", "txt"));
            int answer = chooser.showOpenDialog(this);

            if (answer == JFileChooser.APPROVE_OPTION) {

                try {
                    BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                    while (reader.ready()) {
                        list.add(reader.readLine());
                    }

                } catch (IOException ee) {
                    System.out.println(ee.getMessage());
                }

                if (list.size() == 0) {
                    listContains.setText("<html>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The list is empty. <br/>Please choose a txt file that is not empty</html>");
                } else {
                    listContains.setText("Candidate file contains " + list.size() + " elements");
                    itemsToDraw.setText("Number of required selections");
                    itemsToDraw.setVisible(true);
                    shuffle.setText("Shuffle list");
                    shuffle.setVisible(true);
                    int arrayListSize = list.size();
                    area = new JSpinner(new SpinnerNumberModel(1, 1, arrayListSize, 1));
                    JFormattedTextField txt = ((JSpinner.NumberEditor) area.getEditor()).getTextField();
                    ((NumberFormatter) txt.getFormatter()).setAllowsInvalid(false);
                    area.setBounds(317, 100, 50, 30);
                    area.setVisible(true);
                    f.add(area);

                }
            }
        }
        if (e.getSource() == shuffle) {
            Random r = new Random();
            int value = (Integer) area.getValue();
            int length = list.size();
            for (int i = length - 1; i >= length - value; --i) {
                Collections.swap(list, i, r.nextInt(i + 1)); 
            }

            successDraw.setText("Draw completed");
            successDraw.setVisible(true);
            save.setVisible(true);

        }

        if (e.getSource() == save) {
            SimpleDateFormat formatter2 = new SimpleDateFormat("dd.MM.yyy 'at' HH.mm.ss");
            Date date2 = new Date();
            String dateToStr2 = formatter2.format(date2);
            JFileChooser chooser = new JFileChooser();

            chooser.setFileFilter(new FileNameExtensionFilter("txt", "txt"));

            int answer = chooser.showSaveDialog(this);
            file = chooser.getSelectedFile();
            if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("txt")) {
                file = new File(file.toString() + "-" + dateToStr +   ".txt");
            } else {
                file = new File(file.toString() + "-" + dateToStr +   ".txt");  
                file = new File(file.getParentFile(), FilenameUtils.getBaseName(file.getName()) + ".txt"); 
            }
            PrintWriter pw = null;
            if (answer == JFileChooser.APPROVE_OPTION) {

                try {
                    BufferedWriter br = new BufferedWriter(
                            new OutputStreamWriter(new FileOutputStream(file, true), Charset.defaultCharset()));
                    pw = new PrintWriter(br);              
                    
                    int index = 0;
                    Random r = new Random();
                    int value = (Integer) area.getValue();
                    int length = list.size();
                    
                    for (String items : list.subList(length-value, length)) {
                        ++index;
                        pw.println(index + ". " + items);

                    }
                    pw.println("\n");
                    pw.println("Created on "+dateToStr2);
                    //file.setReadOnly();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Knuth.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    // always close the output stream
                    if (pw != null) {
                        pw.close();
                    }
                }
                fileCreated.setText(file.getName() + " successfully created");
                fileCreated.setVisible(true);

            }
        }

        if (e.getSource() == restart) {
            f.setVisible(false);
            new Knuth();

        }
    }

    public static void main(String[] args) {

        Knuth n = new Knuth();
        n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}