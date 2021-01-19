package choose_from;


import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.text.NumberFormatter;
import org.apache.commons.io.FilenameUtils;

public class ShuffleManualEng extends JFrame implements ActionListener {

    JLabel maxNumber,itemsToDraw, successDraw, fileCreated,typeCandidate;
    JPanel panel;
    JTextField item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19,item20,item21,item22,item23,item24,item25,item26,item27,item28,item29,item30,item31,item32,item33,item34,item35,item36,item37,item38,item39,item40,item41,item42,item43,item44,item45,item46,item47,item48,item49,item50;
    JFrame f;
    JButton addLine,addLine2,addLine3,addLine4,addLine5,addLine6,addLine7,addLine8,addLine9,addLine10,addLine11,addLine12,addLine13,addLine14,addLine15,addLine16,addLine17,addLine18,addLine19,addLine20,addLine21,addLine22,addLine23,addLine24,addLine25,addLine26,addLine27,addLine28,addLine29,addLine30,addLine31,addLine32,addLine33,addLine34,addLine35,addLine36,addLine37,addLine38,addLine39,addLine40,addLine41,addLine42,addLine43,addLine44,addLine45,addLine46,addLine47,addLine48,addLine49,addLine50,save, shuffle, restart;
    JButton remLine,remLine2,remLine3,remLine4,remLine5,remLine6,remLine7,remLine8,remLine9,remLine10,remLine11,remLine12,remLine13,remLine14,remLine15,remLine16,remLine17,remLine18,remLine19,remLine20,remLine21,remLine22,remLine23,remLine24,remLine25,remLine26,remLine27,remLine28,remLine29,remLine30,remLine31,remLine32,remLine33,remLine34,remLine35,remLine36,remLine37,remLine38,remLine39,remLine40,remLine41,remLine42,remLine43,remLine44,remLine45,remLine46,remLine47,remLine48,remLine49,remLine50;
    JButton endList,endList2,endList3,endList4,endList5,endList6,endList7,endList8,endList9,endList10,endList11,endList12,endList13,endList14,endList15,endList16,endList17,endList18,endList19,endList20,endList21,endList22,endList23,endList24,endList25,endList26,endList27,endList28,endList29,endList30,endList31,endList32,endList33,endList34,endList35,endList36,endList37,endList38,endList39,endList40,endList41,endList42,endList43,endList44,endList45,endList46,endList47,endList48,endList49,endList50;
    JSpinner area;
    JComboBox jcbo;
    int listSize;
    DefaultComboBoxModel model;
    String listSizeToString;
    JScrollPane scroll;
    ArrayList<String> list = new ArrayList<>();
    GridBagConstraints c;
    String textFieldLine;
    
    int numberOfSelection = 0;
    ArrayList<String> listOfRequiredSelection = new ArrayList<>();   
    String[] array;
    File file;

    public ShuffleManualEng() {
        
        f = new JFrame();
        f.setLayout(null);
        f.setTitle("Fisher-Yates Shuffle (manually provided input)");
        
        maxNumber = new JLabel("Max number of input lines: 50");
        maxNumber.setBounds(177, 90, 300, 80);

        itemsToDraw = new JLabel("Number of required selections");
        itemsToDraw.setBounds(145, 285, 300, 30);
        
        array=listOfRequiredSelection.toArray(new String[listOfRequiredSelection.size()]);
        
        jcbo= new JComboBox();
        jcbo.setBounds(320,288,70,20);
        f.add(jcbo);
        model = new DefaultComboBoxModel(array);
        jcbo.setModel( model );
        
        successDraw = new JLabel();
        successDraw.setBounds(220, 360, 250, 30);

        fileCreated = new JLabel();
        fileCreated.setBounds(127, 420, 357, 30);

        typeCandidate = new JLabel("Type in Candidates");
        System.out.println(typeCandidate.getFont());
        typeCandidate.setFont(new Font("Dialog", Font.BOLD, 16));
        typeCandidate.setHorizontalAlignment(JLabel.CENTER);
        typeCandidate.setBounds(160, 70, 200, 30);
        
        panel = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();

        scroll = new JScrollPane(panel);
        scroll.setBounds(12, 150, 520, 130);
        scroll.setBorder(null);

          item1 = new JTextField();
        drawTextField(item1,0);
        
        remLine= new JButton("x");
        drawButtonRem(remLine,0);
        remLine.setEnabled(false);
        
        addLine= new JButton("✓");
        drawButtonAdd(addLine,0);
        addLine.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item1); //add item to arraylist
                    increaseNumberOfSelection(item1);
                    addNewLine(item2,remLine2,addLine2,endList2); // draw the line and make remBTN visible and hide addBTN
                    remLine.setEnabled(true);
                    remLine.addActionListener(new ActionListener(){
                      @Override
                        public void actionPerformed(ActionEvent ae)
                        {
                            decreaseNumberOfSelection(item1);
                            removeFromList(item1); //add item to arraylist
                            removeLine(item1,remLine,addLine,endList); // draw the line and make remBTN visible and hide addBTN
                            
                        }
                   
                    });
                    
                 }
            });   
        
        endList= new JButton("∎");
        drawButtonEnd(endList,0);
        endList.setEnabled(false);
        
            
        
        item2 = new JTextField();
        drawTextField(item2,1);
        item2.setVisible(false);
        
        remLine2= new JButton("x");
        drawButtonRem(remLine2,1);
        remLine2.setVisible(false);
        remLine2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item2);
                    removeFromList(item2); //add item to arraylist
                    removeLine(item2,remLine2,addLine2,endList2); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine2= new JButton("✓");
        drawButtonAdd(addLine2,1);
        addLine2.setVisible(false);
        addLine2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item1); //add item to arraylist
                    addNewLine(item3,remLine3,addLine3,endList3);
                    increaseNumberOfSelection(item1); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList2= new JButton("∎");
        drawButtonEnd(endList2,1);
        endList2.setVisible(false);
        endList2.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item2); //add item to arraylist
                    increaseNumberOfSelection(item2); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item3 = new JTextField();
        drawTextField(item3,2);
        item3.setVisible(false);
        
        remLine3= new JButton("x");
        drawButtonRem(remLine3,2);
        remLine3.setVisible(false);
        remLine3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item3);
                    removeFromList(item3); //add item to arraylist
                    removeLine(item3,remLine3,addLine3,endList3); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine3= new JButton("✓");
        drawButtonAdd(addLine3,2);
        addLine3.setVisible(false);
        addLine3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item3); //add item to arraylist
                    addNewLine(item4,remLine4,addLine4,endList4);
                    increaseNumberOfSelection(item3); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList3= new JButton("∎");
        drawButtonEnd(endList3,2);
        endList3.setVisible(false);
        endList3.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item3); //add item to arraylist
                    increaseNumberOfSelection(item3); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item4 = new JTextField();
        drawTextField(item4,3);
        item4.setVisible(false);
        
        remLine4= new JButton("x");
        drawButtonRem(remLine4,3);
        remLine4.setVisible(false);
        remLine4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item4);
                    removeFromList(item4); //add item to arraylist
                    removeLine(item4,remLine4,addLine4,endList4); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine4= new JButton("✓");
        drawButtonAdd(addLine4,3);
        addLine4.setVisible(false);
        addLine4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item4); //add item to arraylist
                    addNewLine(item5,remLine5,addLine5,endList5);
                    increaseNumberOfSelection(item4); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList4= new JButton("∎");
        drawButtonEnd(endList4,3);
        endList4.setVisible(false);
        endList4.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item4); //add item to arraylist
                    increaseNumberOfSelection(item4); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        item5 = new JTextField();
        drawTextField(item5,4);
        item5.setVisible(false);
        
        remLine5= new JButton("x");
        drawButtonRem(remLine5,4);
        remLine5.setVisible(false);
        remLine5.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item5);
                    removeFromList(item5); //add item to arraylist
                    removeLine(item5,remLine5,addLine5,endList5); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine5= new JButton("✓");
        drawButtonAdd(addLine5,4);
        addLine5.setVisible(false);
        addLine5.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item5); //add item to arraylist
                    addNewLine(item6,remLine6,addLine6,endList6);
                    increaseNumberOfSelection(item5); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList5= new JButton("∎");
        drawButtonEnd(endList5,4);
        endList5.setVisible(false);
        endList5.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item5); //add item to arraylist
                    increaseNumberOfSelection(item5); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item6 = new JTextField();
        drawTextField(item6,5);
        item6.setVisible(false);
        
        remLine6= new JButton("x");
        drawButtonRem(remLine6,5);
        remLine6.setVisible(false);
        remLine6.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item6);
                    removeFromList(item6); //add item to arraylist
                    removeLine(item6,remLine6,addLine6,endList6); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine6= new JButton("✓");
        drawButtonAdd(addLine6,5);
        addLine6.setVisible(false);
        addLine6.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item6); //add item to arraylist
                    addNewLine(item7,remLine7,addLine7,endList7);
                    increaseNumberOfSelection(item6); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList6= new JButton("∎");
        drawButtonEnd(endList6,5);
        endList6.setVisible(false);
        endList6.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item6); //add item to arraylist
                    increaseNumberOfSelection(item6); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item7 = new JTextField();
        drawTextField(item7,6);
        item7.setVisible(false);
        
        remLine7= new JButton("x");
        drawButtonRem(remLine7,6);
        remLine7.setVisible(false);
        remLine7.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item7);
                    removeFromList(item7); //add item to arraylist
                    removeLine(item7,remLine7,addLine7,endList5); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine7= new JButton("✓");
        drawButtonAdd(addLine7,6);
        addLine7.setVisible(false);
        addLine7.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item7); //add item to arraylist
                    addNewLine(item8,remLine8,addLine8,endList8);
                    increaseNumberOfSelection(item7); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList7= new JButton("∎");
        drawButtonEnd(endList7,6);
        endList7.setVisible(false);
        endList7.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item7); //add item to arraylist
                    increaseNumberOfSelection(item7); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item8 = new JTextField();
        drawTextField(item8,7);
        item8.setVisible(false);
        
        remLine8= new JButton("x");
        drawButtonRem(remLine8,7);
        remLine8.setVisible(false);
        remLine8.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item8);
                    removeFromList(item8); //add item to arraylist
                    removeLine(item8,remLine8,addLine8,endList8); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine8= new JButton("✓");
        drawButtonAdd(addLine8,7);
        addLine8.setVisible(false);
        addLine8.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item8); //add item to arraylist
                    addNewLine(item9,remLine9,addLine9,endList9);
                    increaseNumberOfSelection(item8); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList8= new JButton("∎");
        drawButtonEnd(endList8,7);
        endList8.setVisible(false);
        endList8.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item8); //add item to arraylist
                    increaseNumberOfSelection(item8); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item9 = new JTextField();
        drawTextField(item9,8);
        item9.setVisible(false);
        
        remLine9= new JButton("x");
        drawButtonRem(remLine9,8);
        remLine9.setVisible(false);
        remLine9.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item9);
                    removeFromList(item9); //add item to arraylist
                    removeLine(item9,remLine9,addLine9,endList9); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine9= new JButton("✓");
        drawButtonAdd(addLine9,8);
        addLine9.setVisible(false);
        addLine9.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item9); //add item to arraylist
                    addNewLine(item10,remLine10,addLine10,endList10);
                    increaseNumberOfSelection(item9); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList9= new JButton("∎");
        drawButtonEnd(endList9,8);
        endList9.setVisible(false);
        endList9.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item9); //add item to arraylist
                    increaseNumberOfSelection(item9); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item10 = new JTextField();
        drawTextField(item10,9);
        item10.setVisible(false);
        
        remLine10= new JButton("x");
        drawButtonRem(remLine10,9);
        remLine10.setVisible(false);
        remLine10.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item10);
                    removeFromList(item10); //add item to arraylist
                    removeLine(item10,remLine10,addLine10,endList10); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine10= new JButton("✓");
        drawButtonAdd(addLine10,9);
        addLine10.setVisible(false);
        addLine10.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item10); //add item to arraylist
                    addNewLine(item11,remLine11,addLine11,endList11);
                    increaseNumberOfSelection(item10); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList10= new JButton("∎");
        drawButtonEnd(endList10,9);
        endList10.setVisible(false);
        endList10.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item10); //add item to arraylist
                    increaseNumberOfSelection(item10); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });
        
        item11 = new JTextField();
        drawTextField(item11,10);
        item11.setVisible(false);
        
        remLine11= new JButton("x");
        drawButtonRem(remLine11,10);
        remLine11.setVisible(false);
        remLine11.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item11);
                    removeFromList(item11); //add item to arraylist
                    removeLine(item11,remLine11,addLine11,endList11); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine11= new JButton("✓");
        drawButtonAdd(addLine11,10);
        addLine11.setVisible(false);
        addLine11.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item11); //add item to arraylist
                    addNewLine(item12,remLine12,addLine12,endList12);
                    increaseNumberOfSelection(item11); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList11= new JButton("∎");
        drawButtonEnd(endList11,10);
        endList11.setVisible(false);
        endList11.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item11); //add item to arraylist
                    increaseNumberOfSelection(item11); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });  
        
        item12 = new JTextField();
        drawTextField(item12,11);
        item12.setVisible(false);
        
        remLine12= new JButton("x");
        drawButtonRem(remLine12,11);
        remLine12.setVisible(false);
        remLine12.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item12);
                    removeFromList(item12); //add item to arraylist
                    removeLine(item12,remLine12,addLine12,endList12); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine12= new JButton("✓");
        drawButtonAdd(addLine12,11);
        addLine12.setVisible(false);
        addLine12.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item12); //add item to arraylist
                    addNewLine(item13,remLine13,addLine13,endList13);
                    increaseNumberOfSelection(item12); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList12= new JButton("∎");
        drawButtonEnd(endList12,11);
        endList12.setVisible(false);
        endList12.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item12); //add item to arraylist
                    increaseNumberOfSelection(item12); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        item13 = new JTextField();
        drawTextField(item13,12);
        item13.setVisible(false);
        
        remLine13= new JButton("x");
        drawButtonRem(remLine13,12);
        remLine13.setVisible(false);
        remLine13.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item13);
                    removeFromList(item13); //add item to arraylist
                    removeLine(item13,remLine13,addLine13,endList13); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine13= new JButton("✓");
        drawButtonAdd(addLine13,12);
        addLine13.setVisible(false);
        addLine13.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item13); //add item to arraylist
                    addNewLine(item14,remLine14,addLine14,endList14);
                    increaseNumberOfSelection(item13); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList13= new JButton("∎");
        drawButtonEnd(endList13,12);
        endList13.setVisible(false);
        endList13.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item13); //add item to arraylist
                    increaseNumberOfSelection(item13); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });  
        
        item14 = new JTextField();
        drawTextField(item14,13);
        item14.setVisible(false);
        
        remLine14= new JButton("x");
        drawButtonRem(remLine14,13);
        remLine14.setVisible(false);
        remLine14.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item14);
                    removeFromList(item14); //add item to arraylist
                    removeLine(item14,remLine14,addLine14,endList14); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine14= new JButton("✓");
        drawButtonAdd(addLine14,13);
        addLine14.setVisible(false);
        addLine14.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item14); //add item to arraylist
                    addNewLine(item15,remLine15,addLine15,endList15);
                    increaseNumberOfSelection(item14); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList14= new JButton("∎");
        drawButtonEnd(endList14,13);
        endList14.setVisible(false);
        endList14.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item14); //add item to arraylist
                    increaseNumberOfSelection(item14); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item15 = new JTextField();
        drawTextField(item15,14);
        item15.setVisible(false);
        
        remLine15= new JButton("x");
        drawButtonRem(remLine15,14);
        remLine15.setVisible(false);
        remLine15.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item15);
                    removeFromList(item15); //add item to arraylist
                    removeLine(item15,remLine15,addLine15,endList15); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine15= new JButton("✓");
        drawButtonAdd(addLine15,14);
        addLine15.setVisible(false);
        addLine15.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item15); //add item to arraylist
                    addNewLine(item16,remLine16,addLine16,endList16);
                    increaseNumberOfSelection(item15); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList15= new JButton("∎");
        drawButtonEnd(endList15,14);
        endList15.setVisible(false);
        endList15.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item15); //add item to arraylist
                    increaseNumberOfSelection(item15); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
       
        item16 = new JTextField();
        drawTextField(item16,15);
        item16.setVisible(false);
        
        remLine16= new JButton("x");
        drawButtonRem(remLine16,15);
        remLine16.setVisible(false);
        remLine16.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item16);
                    removeFromList(item16); //add item to arraylist
                    removeLine(item16,remLine16,addLine16,endList16); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine16= new JButton("✓");
        drawButtonAdd(addLine16,15);
        addLine16.setVisible(false);
        addLine16.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item16); //add item to arraylist
                    addNewLine(item17,remLine17,addLine17,endList17);
                    increaseNumberOfSelection(item16); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList16= new JButton("∎");
        drawButtonEnd(endList16,15);
        endList16.setVisible(false);
        endList16.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item16); //add item to arraylist
                    increaseNumberOfSelection(item16); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item17 = new JTextField();
        drawTextField(item17,16);
        item17.setVisible(false);
        
        remLine17= new JButton("x");
        drawButtonRem(remLine17,16);
        remLine17.setVisible(false);
        remLine17.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item17);
                    removeFromList(item17); //add item to arraylist
                    removeLine(item17,remLine17,addLine17,endList17); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine17= new JButton("✓");
        drawButtonAdd(addLine17,16);
        addLine17.setVisible(false);
        addLine17.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item17); //add item to arraylist
                    addNewLine(item18,remLine18,addLine18,endList18);
                    increaseNumberOfSelection(item17); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList17= new JButton("∎");
        drawButtonEnd(endList17,16);
        endList17.setVisible(false);
        endList17.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item17); //add item to arraylist
                    increaseNumberOfSelection(item17); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item18 = new JTextField();
        drawTextField(item18,17);
        item18.setVisible(false);
        
        remLine18= new JButton("x");
        drawButtonRem(remLine18,17);
        remLine18.setVisible(false);
        remLine18.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item18);
                    removeFromList(item18); //add item to arraylist
                    removeLine(item18,remLine18,addLine18,endList18); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine18= new JButton("✓");
        drawButtonAdd(addLine18,17);
        addLine18.setVisible(false);
        addLine18.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item18); //add item to arraylist
                    addNewLine(item19,remLine19,addLine19,endList19);
                    increaseNumberOfSelection(item18); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList18= new JButton("∎");
        drawButtonEnd(endList18,17);
        endList18.setVisible(false);
        endList18.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item18); //add item to arraylist
                    increaseNumberOfSelection(item18); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item19 = new JTextField();
        drawTextField(item19,18);
        item19.setVisible(false);
        
        remLine19= new JButton("x");
        drawButtonRem(remLine19,18);
        remLine19.setVisible(false);
        remLine19.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item19);
                    removeFromList(item19); //add item to arraylist
                    removeLine(item19,remLine19,addLine19,endList19); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine19= new JButton("✓");
        drawButtonAdd(addLine19,18);
        addLine19.setVisible(false);
        addLine19.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item19); //add item to arraylist
                    addNewLine(item20,remLine20,addLine20,endList20);
                    increaseNumberOfSelection(item19); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList19= new JButton("∎");
        drawButtonEnd(endList19,18);
        endList19.setVisible(false);
        endList19.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item19); //add item to arraylist
                    increaseNumberOfSelection(item19); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item20 = new JTextField();
        drawTextField(item20,19);
        item20.setVisible(false);
        
        remLine20= new JButton("x");
        drawButtonRem(remLine20,19);
        remLine20.setVisible(false);
        remLine20.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item20);
                    removeFromList(item20); //add item to arraylist
                    removeLine(item20,remLine20,addLine20,endList20); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine20= new JButton("✓");
        drawButtonAdd(addLine20,19);
        addLine20.setVisible(false);
        addLine20.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item20); //add item to arraylist
                    addNewLine(item21,remLine21,addLine21,endList21);
                    increaseNumberOfSelection(item20); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList20= new JButton("∎");
        drawButtonEnd(endList20,19);
        endList20.setVisible(false);
        endList20.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item20); //add item to arraylist
                    increaseNumberOfSelection(item20); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item21 = new JTextField();
        drawTextField(item21,20);
        item21.setVisible(false);
        
        remLine21= new JButton("x");
        drawButtonRem(remLine21,20);
        remLine21.setVisible(false);
        remLine21.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item21);
                    removeFromList(item21); //add item to arraylist
                    removeLine(item21,remLine21,addLine21,endList21); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine21= new JButton("✓");
        drawButtonAdd(addLine21,20);
        addLine21.setVisible(false);
        addLine21.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item21); //add item to arraylist
                    addNewLine(item22,remLine22,addLine22,endList22);
                    increaseNumberOfSelection(item21); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList21= new JButton("∎");
        drawButtonEnd(endList21,20);
        endList21.setVisible(false);
        endList21.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item21); //add item to arraylist
                    increaseNumberOfSelection(item21); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item22 = new JTextField();
        drawTextField(item22,21);
        item22.setVisible(false);
        
        remLine22= new JButton("x");
        drawButtonRem(remLine22,21);
        remLine22.setVisible(false);
        remLine22.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item22);
                    removeFromList(item22); //add item to arraylist
                    removeLine(item22,remLine22,addLine22,endList22); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine22= new JButton("✓");
        drawButtonAdd(addLine22,21);
        addLine22.setVisible(false);
        addLine22.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item22); //add item to arraylist
                    addNewLine(item23,remLine23,addLine23,endList23);
                    increaseNumberOfSelection(item22); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList22= new JButton("∎");
        drawButtonEnd(endList22,21);
        endList22.setVisible(false);
        endList22.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item22); //add item to arraylist
                    increaseNumberOfSelection(item22); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item23 = new JTextField();
        drawTextField(item23,22);
        item23.setVisible(false);
        
        remLine23= new JButton("x");
        drawButtonRem(remLine23,22);
        remLine23.setVisible(false);
        remLine23.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item23);
                    removeFromList(item23); //add item to arraylist
                    removeLine(item23,remLine23,addLine23,endList23); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine23= new JButton("✓");
        drawButtonAdd(addLine23,22);
        addLine23.setVisible(false);
        addLine23.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item23); //add item to arraylist
                    addNewLine(item24,remLine24,addLine24,endList24);
                    increaseNumberOfSelection(item9); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList23= new JButton("∎");
        drawButtonEnd(endList23,22);
        endList23.setVisible(false);
        endList23.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item23); //add item to arraylist
                    increaseNumberOfSelection(item23); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item24 = new JTextField();
        drawTextField(item24,23);
        item24.setVisible(false);
        
        remLine24= new JButton("x");
        drawButtonRem(remLine24,23);
        remLine24.setVisible(false);
        remLine24.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item24);
                    removeFromList(item24); //add item to arraylist
                    removeLine(item24,remLine24,addLine24,endList24); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine24= new JButton("✓");
        drawButtonAdd(addLine24,23);
        addLine24.setVisible(false);
        addLine24.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item24); //add item to arraylist
                    addNewLine(item25,remLine25,addLine25,endList25);
                    increaseNumberOfSelection(item24); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList24= new JButton("∎");
        drawButtonEnd(endList24,23);
        endList24.setVisible(false);
        endList24.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item24); //add item to arraylist
                    increaseNumberOfSelection(item24); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item25 = new JTextField();
        drawTextField(item25,24);
        item25.setVisible(false);
        
        remLine25= new JButton("x");
        drawButtonRem(remLine25,24);
        remLine25.setVisible(false);
        remLine25.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item25);
                    removeFromList(item25); //add item to arraylist
                    removeLine(item25,remLine25,addLine25,endList25); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine25= new JButton("✓");
        drawButtonAdd(addLine25,24);
        addLine25.setVisible(false);
        addLine25.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item25); //add item to arraylist
                    addNewLine(item26,remLine26,addLine26,endList26);
                    increaseNumberOfSelection(item25); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList25= new JButton("∎");
        drawButtonEnd(endList25,24);
        endList25.setVisible(false);
        endList25.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item25); //add item to arraylist
                    increaseNumberOfSelection(item25); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item26 = new JTextField();
        drawTextField(item26,25);
        item26.setVisible(false);
        
        remLine26= new JButton("x");
        drawButtonRem(remLine26,25);
        remLine26.setVisible(false);
        remLine26.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item26);
                    removeFromList(item26); //add item to arraylist
                    removeLine(item26,remLine26,addLine26,endList26); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine26= new JButton("✓");
        drawButtonAdd(addLine26,25);
        addLine26.setVisible(false);
        addLine26.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item26); //add item to arraylist
                    addNewLine(item27,remLine27,addLine27,endList27);
                    increaseNumberOfSelection(item26); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList26= new JButton("∎");
        drawButtonEnd(endList26,25);
        endList26.setVisible(false);
        endList26.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item26); //add item to arraylist
                    increaseNumberOfSelection(item26); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item27 = new JTextField();
        drawTextField(item27,26);
        item27.setVisible(false);
        
        remLine27= new JButton("x");
        drawButtonRem(remLine27,26);
        remLine27.setVisible(false);
        remLine27.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item27);
                    removeFromList(item27); //add item to arraylist
                    removeLine(item27,remLine27,addLine27,endList27); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine27= new JButton("✓");
        drawButtonAdd(addLine27,26);
        addLine27.setVisible(false);
        addLine27.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item27); //add item to arraylist
                    addNewLine(item28,remLine28,addLine28,endList28);
                    increaseNumberOfSelection(item27); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList27= new JButton("∎");
        drawButtonEnd(endList27,26);
        endList27.setVisible(false);
        endList27.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item27); //add item to arraylist
                    increaseNumberOfSelection(item27); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item28 = new JTextField();
        drawTextField(item28,27);
        item28.setVisible(false);
        
        remLine28= new JButton("x");
        drawButtonRem(remLine28,27);
        remLine28.setVisible(false);
        remLine28.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item28);
                    removeFromList(item28); //add item to arraylist
                    removeLine(item28,remLine28,addLine28,endList28); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine28= new JButton("✓");
        drawButtonAdd(addLine28,27);
        addLine28.setVisible(false);
        addLine28.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item28); //add item to arraylist
                    addNewLine(item29,remLine29,addLine29,endList29);
                    increaseNumberOfSelection(item28); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList28= new JButton("∎");
        drawButtonEnd(endList28,27);
        endList28.setVisible(false);
        endList28.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item28); //add item to arraylist
                    increaseNumberOfSelection(item28); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item29 = new JTextField();
        drawTextField(item29,28);
        item29.setVisible(false);
        
        remLine29= new JButton("x");
        drawButtonRem(remLine29,28);
        remLine29.setVisible(false);
        remLine29.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item29);
                    removeFromList(item29); //add item to arraylist
                    removeLine(item29,remLine29,addLine29,endList29); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine29= new JButton("✓");
        drawButtonAdd(addLine29,28);
        addLine29.setVisible(false);
        addLine29.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item29); //add item to arraylist
                    addNewLine(item30,remLine30,addLine30,endList30);
                    increaseNumberOfSelection(item29); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList29= new JButton("∎");
        drawButtonEnd(endList29,28);
        endList29.setVisible(false);
        endList29.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item29); //add item to arraylist
                    increaseNumberOfSelection(item29); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item30 = new JTextField();
        drawTextField(item30,29);
        item30.setVisible(false);
        
        remLine30= new JButton("x");
        drawButtonRem(remLine30,29);
        remLine30.setVisible(false);
        remLine30.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item30);
                    removeFromList(item30); //add item to arraylist
                    removeLine(item30,remLine30,addLine30,endList30); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine30= new JButton("✓");
        drawButtonAdd(addLine30,29);
        addLine30.setVisible(false);
        addLine30.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item30); //add item to arraylist
                    addNewLine(item31,remLine31,addLine31,endList31);
                    increaseNumberOfSelection(item30); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList30= new JButton("∎");
        drawButtonEnd(endList30,29);
        endList30.setVisible(false);
        endList30.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item30); //add item to arraylist
                    increaseNumberOfSelection(item30); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item31 = new JTextField();
        drawTextField(item31,30);
        item31.setVisible(false);
        
        remLine31= new JButton("x");
        drawButtonRem(remLine31,30);
        remLine31.setVisible(false);
        remLine31.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item31);
                    removeFromList(item31); //add item to arraylist
                    removeLine(item31,remLine31,addLine31,endList31); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine31= new JButton("✓");
        drawButtonAdd(addLine31,30);
        addLine31.setVisible(false);
        addLine31.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item31); //add item to arraylist
                    addNewLine(item32,remLine32,addLine32,endList32);
                    increaseNumberOfSelection(item31); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList31= new JButton("∎");
        drawButtonEnd(endList31,30);
        endList31.setVisible(false);
        endList31.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item31); //add item to arraylist
                    increaseNumberOfSelection(item31); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item32 = new JTextField();
        drawTextField(item32,31);
        item32.setVisible(false);
        
        remLine32= new JButton("x");
        drawButtonRem(remLine32,31);
        remLine32.setVisible(false);
        remLine32.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item32);
                    removeFromList(item32); //add item to arraylist
                    removeLine(item32,remLine32,addLine32,endList32); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine32= new JButton("✓");
        drawButtonAdd(addLine32,31);
        addLine32.setVisible(false);
        addLine32.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item32); //add item to arraylist
                    addNewLine(item33,remLine33,addLine33,endList33);
                    increaseNumberOfSelection(item32); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList32= new JButton("∎");
        drawButtonEnd(endList32,31);
        endList32.setVisible(false);
        endList32.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item32); //add item to arraylist
                    increaseNumberOfSelection(item32); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item33 = new JTextField();
        drawTextField(item33,32);
        item33.setVisible(false);
        
        remLine33= new JButton("x");
        drawButtonRem(remLine33,32);
        remLine33.setVisible(false);
        remLine33.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item33);
                    removeFromList(item33); //add item to arraylist
                    removeLine(item33,remLine33,addLine33,endList33); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine33= new JButton("✓");
        drawButtonAdd(addLine33,32);
        addLine33.setVisible(false);
        addLine33.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item33); //add item to arraylist
                    addNewLine(item34,remLine34,addLine34,endList34);
                    increaseNumberOfSelection(item33); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList33= new JButton("∎");
        drawButtonEnd(endList33,32);
        endList33.setVisible(false);
        endList33.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item33); //add item to arraylist
                    increaseNumberOfSelection(item33); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item34 = new JTextField();
        drawTextField(item34,33);
        item34.setVisible(false);
        
        remLine34= new JButton("x");
        drawButtonRem(remLine34,33);
        remLine34.setVisible(false);
        remLine34.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item34);
                    removeFromList(item34); //add item to arraylist
                    removeLine(item34,remLine34,addLine34,endList34); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine34= new JButton("✓");
        drawButtonAdd(addLine34,33);
        addLine34.setVisible(false);
        addLine34.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item34); //add item to arraylist
                    addNewLine(item35,remLine35,addLine35,endList35);
                    increaseNumberOfSelection(item34); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList34= new JButton("∎");
        drawButtonEnd(endList34,33);
        endList34.setVisible(false);
        endList34.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item34); //add item to arraylist
                    increaseNumberOfSelection(item34); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item35 = new JTextField();
        drawTextField(item35,34);
        item35.setVisible(false);
        
        remLine35= new JButton("x");
        drawButtonRem(remLine35,34);
        remLine35.setVisible(false);
        remLine35.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item35);
                    removeFromList(item35); //add item to arraylist
                    removeLine(item35,remLine35,addLine35,endList35); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine35= new JButton("✓");
        drawButtonAdd(addLine35,34);
        addLine35.setVisible(false);
        addLine35.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item35); //add item to arraylist
                    addNewLine(item36,remLine36,addLine36,endList36);
                    increaseNumberOfSelection(item36); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList35= new JButton("∎");
        drawButtonEnd(endList35,34);
        endList35.setVisible(false);
        endList35.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item35); //add item to arraylist
                    increaseNumberOfSelection(item35); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item36 = new JTextField();
        drawTextField(item36,35);
        item36.setVisible(false);
        
        remLine36= new JButton("x");
        drawButtonRem(remLine36,35);
        remLine36.setVisible(false);
        remLine36.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item36);
                    removeFromList(item36); //add item to arraylist
                    removeLine(item36,remLine36,addLine36,endList36); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine36= new JButton("✓");
        drawButtonAdd(addLine36,35);
        addLine36.setVisible(false);
        addLine36.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item36); //add item to arraylist
                    addNewLine(item37,remLine37,addLine37,endList37);
                    increaseNumberOfSelection(item36); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList36= new JButton("∎");
        drawButtonEnd(endList36,35);
        endList36.setVisible(false);
        endList36.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item36); //add item to arraylist
                    increaseNumberOfSelection(item36); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item37 = new JTextField();
        drawTextField(item37,36);
        item37.setVisible(false);
        
        remLine37= new JButton("x");
        drawButtonRem(remLine37,36);
        remLine37.setVisible(false);
        remLine37.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item37);
                    removeFromList(item37); //add item to arraylist
                    removeLine(item37,remLine37,addLine37,endList37); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine37= new JButton("✓");
        drawButtonAdd(addLine37,36);
        addLine37.setVisible(false);
        addLine37.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item37); //add item to arraylist
                    addNewLine(item38,remLine38,addLine38,endList38);
                    increaseNumberOfSelection(item37); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList37= new JButton("∎");
        drawButtonEnd(endList37,36);
        endList37.setVisible(false);
        endList37.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item37); //add item to arraylist
                    increaseNumberOfSelection(item37); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item38 = new JTextField();
        drawTextField(item38,37);
        item38.setVisible(false);
        
        remLine38= new JButton("x");
        drawButtonRem(remLine38,37);
        remLine38.setVisible(false);
        remLine38.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item38);
                    removeFromList(item38); //add item to arraylist
                    removeLine(item38,remLine38,addLine38,endList38); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine38= new JButton("✓");
        drawButtonAdd(addLine38,37);
        addLine38.setVisible(false);
        addLine38.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item38); //add item to arraylist
                    addNewLine(item39,remLine39,addLine39,endList39);
                    increaseNumberOfSelection(item38); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList38= new JButton("∎");
        drawButtonEnd(endList38,37);
        endList38.setVisible(false);
        endList38.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item38); //add item to arraylist
                    increaseNumberOfSelection(item38); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item39 = new JTextField();
        drawTextField(item39,38);
        item39.setVisible(false);
        
        remLine39= new JButton("x");
        drawButtonRem(remLine39,38);
        remLine39.setVisible(false);
        remLine39.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item39);
                    removeFromList(item39); //add item to arraylist
                    removeLine(item39,remLine39,addLine39,endList39); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine39= new JButton("✓");
        drawButtonAdd(addLine39,38);
        addLine39.setVisible(false);
        addLine39.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item39); //add item to arraylist
                    addNewLine(item40,remLine40,addLine40,endList40);
                    increaseNumberOfSelection(item39); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList39= new JButton("∎");
        drawButtonEnd(endList39,38);
        endList39.setVisible(false);
        endList39.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item39); //add item to arraylist
                    increaseNumberOfSelection(item39); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item40 = new JTextField();
        drawTextField(item40,39);
        item40.setVisible(false);
        
        remLine40= new JButton("x");
        drawButtonRem(remLine40,39);
        remLine40.setVisible(false);
        remLine40.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item40);
                    removeFromList(item40); //add item to arraylist
                    removeLine(item40,remLine40,addLine40,endList40); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine40= new JButton("✓");
        drawButtonAdd(addLine40,39);
        addLine40.setVisible(false);
        addLine40.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item40); //add item to arraylist
                    addNewLine(item41,remLine41,addLine41,endList41);
                    increaseNumberOfSelection(item40); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList40= new JButton("∎");
        drawButtonEnd(endList40,39);
        endList40.setVisible(false);
        endList40.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item40); //add item to arraylist
                    increaseNumberOfSelection(item40); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item41 = new JTextField();
        drawTextField(item41,40);
        item41.setVisible(false);
        
        remLine41= new JButton("x");
        drawButtonRem(remLine41,40);
        remLine41.setVisible(false);
        remLine41.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item41);
                    removeFromList(item41); //add item to arraylist
                    removeLine(item41,remLine41,addLine41,endList41); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine41= new JButton("✓");
        drawButtonAdd(addLine41,40);
        addLine41.setVisible(false);
        addLine41.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item41); //add item to arraylist
                    addNewLine(item42,remLine42,addLine42,endList42);
                    increaseNumberOfSelection(item41); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList41= new JButton("∎");
        drawButtonEnd(endList41,40);
        endList41.setVisible(false);
        endList41.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item41); //add item to arraylist
                    increaseNumberOfSelection(item41); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item42 = new JTextField();
        drawTextField(item42,41);
        item42.setVisible(false);
        
        remLine42= new JButton("x");
        drawButtonRem(remLine42,41);
        remLine42.setVisible(false);
        remLine42.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item42);
                    removeFromList(item42); //add item to arraylist
                    removeLine(item42,remLine42,addLine42,endList42); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine42= new JButton("✓");
        drawButtonAdd(addLine42,41);
        addLine42.setVisible(false);
        addLine42.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item42); //add item to arraylist
                    addNewLine(item43,remLine43,addLine43,endList43);
                    increaseNumberOfSelection(item42); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList42= new JButton("∎");
        drawButtonEnd(endList42,41);
        endList42.setVisible(false);
        endList42.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item42); //add item to arraylist
                    increaseNumberOfSelection(item42); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item43 = new JTextField();
        drawTextField(item43,42);
        item43.setVisible(false);
        
        remLine43= new JButton("x");
        drawButtonRem(remLine43,42);
        remLine43.setVisible(false);
        remLine43.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item43);
                    removeFromList(item43); //add item to arraylist
                    removeLine(item43,remLine43,addLine43,endList43); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine43= new JButton("✓");
        drawButtonAdd(addLine43,42);
        addLine43.setVisible(false);
        addLine43.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item43); //add item to arraylist
                    addNewLine(item44,remLine44,addLine44,endList44);
                    increaseNumberOfSelection(item43); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList43= new JButton("∎");
        drawButtonEnd(endList43,42);
        endList43.setVisible(false);
        endList43.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item43); //add item to arraylist
                    increaseNumberOfSelection(item43); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item44 = new JTextField();
        drawTextField(item44,43);
        item44.setVisible(false);
        
        remLine44= new JButton("x");
        drawButtonRem(remLine44,43);
        remLine44.setVisible(false);
        remLine44.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item44);
                    removeFromList(item44); //add item to arraylist
                    removeLine(item44,remLine44,addLine44,endList44); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine44= new JButton("✓");
        drawButtonAdd(addLine44,43);
        addLine44.setVisible(false);
        addLine44.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item44); //add item to arraylist
                    addNewLine(item45,remLine45,addLine45,endList45);
                    increaseNumberOfSelection(item44); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList44= new JButton("∎");
        drawButtonEnd(endList44,43);
        endList44.setVisible(false);
        endList44.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item44); //add item to arraylist
                    increaseNumberOfSelection(item44); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item45= new JTextField();
        drawTextField(item45,44);
        item45.setVisible(false);
        
        remLine45= new JButton("x");
        drawButtonRem(remLine45,44);
        remLine45.setVisible(false);
        remLine45.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item45);
                    removeFromList(item45); //add item to arraylist
                    removeLine(item45,remLine45,addLine45,endList45); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine45= new JButton("✓");
        drawButtonAdd(addLine45,44);
        addLine45.setVisible(false);
        addLine45.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item45); //add item to arraylist
                    addNewLine(item46,remLine46,addLine46,endList46);
                    increaseNumberOfSelection(item45); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList45= new JButton("∎");
        drawButtonEnd(endList45,44);
        endList45.setVisible(false);
        endList45.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item45); //add item to arraylist
                    increaseNumberOfSelection(item45); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item46 = new JTextField();
        drawTextField(item46,45);
        item46.setVisible(false);
        
        remLine46= new JButton("x");
        drawButtonRem(remLine46,45);
        remLine46.setVisible(false);
        remLine46.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item46);
                    removeFromList(item46); //add item to arraylist
                    removeLine(item46,remLine46,addLine46,endList46); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine46= new JButton("✓");
        drawButtonAdd(addLine46,45);
        addLine46.setVisible(false);
        addLine46.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item45); //add item to arraylist
                    addNewLine(item47,remLine47,addLine47,endList47);
                    increaseNumberOfSelection(item46); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList46= new JButton("∎");
        drawButtonEnd(endList46,45);
        endList46.setVisible(false);
        endList46.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item46); //add item to arraylist
                    increaseNumberOfSelection(item46); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item47 = new JTextField();
        drawTextField(item47,46);
        item47.setVisible(false);
        
        remLine47= new JButton("x");
        drawButtonRem(remLine47,46);
        remLine47.setVisible(false);
        remLine47.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item47);
                    removeFromList(item47); //add item to arraylist
                    removeLine(item47,remLine47,addLine47,endList47); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine47= new JButton("✓");
        drawButtonAdd(addLine47,46);
        addLine47.setVisible(false);
        addLine47.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item47); //add item to arraylist
                    addNewLine(item48,remLine48,addLine48,endList48);
                    increaseNumberOfSelection(item47); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList47= new JButton("∎");
        drawButtonEnd(endList47,46);
        endList47.setVisible(false);
        endList47.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item47); //add item to arraylist
                    increaseNumberOfSelection(item47); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item48 = new JTextField();
        drawTextField(item48,47);
        item48.setVisible(false);
        
        remLine48= new JButton("x");
        drawButtonRem(remLine48,47);
        remLine48.setVisible(false);
        remLine48.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item48);
                    removeFromList(item48); //add item to arraylist
                    removeLine(item48,remLine48,addLine48,endList48); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine48= new JButton("✓");
        drawButtonAdd(addLine48,47);
        addLine48.setVisible(false);
        addLine48.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item48); //add item to arraylist
                    addNewLine(item49,remLine49,addLine49,endList49);
                    increaseNumberOfSelection(item48); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList48= new JButton("∎");
        drawButtonEnd(endList48,47);
        endList48.setVisible(false);
        endList48.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item48); //add item to arraylist
                    increaseNumberOfSelection(item48); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
        
        item49 = new JTextField();
        drawTextField(item49,48);
        item49.setVisible(false);
        
        remLine49= new JButton("x");
        drawButtonRem(remLine49,48);
        remLine49.setVisible(false);
        remLine49.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item49);
                    removeFromList(item49); //add item to arraylist
                    removeLine(item49,remLine49,addLine49,endList49); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine49= new JButton("✓");
        drawButtonAdd(addLine49,48);
        addLine49.setVisible(false);
        addLine49.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    
                    addToList(item49); //add item to arraylist
                    addNewLine(item50,remLine50,addLine50,endList50);
                    increaseNumberOfSelection(item49); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        endList49= new JButton("∎");
        drawButtonEnd(endList49,48);
        endList49.setVisible(false);
        endList49.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item49); //add item to arraylist
                    increaseNumberOfSelection(item49); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
      
       
        item50 = new JTextField();
        drawTextField(item50,49);
        item50.setVisible(false);
        
        remLine50= new JButton("x");
        drawButtonRem(remLine50,49);
        remLine50.setVisible(false);
        remLine50.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    decreaseNumberOfSelection(item50);
                    removeFromList(item50); //add item to arraylist
                    removeLine(item50,remLine50,addLine50,endList50); // draw the line and make remBTN visible and hide addBTN
                     // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame
                    
                    
                 }
            });   
        
        addLine50= new JButton("✓");
        drawButtonAdd(addLine50,49);
        addLine50.setVisible(false);
        addLine50.setEnabled(false);
        
        endList50= new JButton("∎");
        drawButtonEnd(endList50,49);
        endList50.setVisible(false);
        endList50.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    addToList(item50); //add item to arraylist
                    increaseNumberOfSelection(item50); // put the item of the arraylist to the string array converting it to string and updading the jcombobox with the new value and repainting the frame


                 }
            });   
       

        save = new JButton("Save File");
        save.setBounds(177, 390, 180, 30);
        save.addActionListener(this);

        shuffle = new JButton("Shuffle list");
        shuffle.setBounds(177, 335, 180, 30);
        shuffle.addActionListener(this);

        restart = new JButton("Restart");
        restart.setHorizontalAlignment(JLabel.CENTER);
        restart.setBounds(175, 10, 180, 30);
        Color color = Color.decode("#f59042");
        restart.setForeground(color);
        restart.addActionListener(this);
        
        f.add(maxNumber);
        f.add(scroll);
        f.add(itemsToDraw);
        f.add(successDraw);
        f.add(fileCreated);

        
        f.add(save);
        f.add(shuffle);
        f.add(restart);
        f.add(typeCandidate);
        
        maxNumber.setVisible(true);
        //itemsToDraw.setVisible(false);
        //successDraw.setVisible(false);
        fileCreated.setVisible(false);
        //shuffle.setVisible(false);
        save.setVisible(false);

        f.setSize(550, 480);
        
        f.setLocationRelativeTo(null);
        f.setBackground(Color.GRAY);
        f.setVisible(true);
        f.setResizable(false);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
  
    
    public void addToList(JTextField jtf){
        if(!jtf.getText().equals("")){
            textFieldLine = jtf.getText();
            list.add(textFieldLine);
            listSize = list.size();
        }
    }
    
    public void removeFromList(JTextField jtf){
            textFieldLine = jtf.getText();
            list.remove(textFieldLine);
            listSize = list.size();
    }
    
    
    
   public void drawTextField(JTextField jtf,int gridy){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=12;
        c.ipady = 3;
	c.gridx = 0;
	c.gridy = gridy;
	panel.add(jtf, c);
   }
   public void drawButtonRem(JButton jb,int gridy){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=1;
        c.ipady = 3;
	c.gridx = 1;
	c.gridy = gridy;
	panel.add(jb, c);
   }
   
   public void drawButtonAdd(JButton jb,int gridy){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=1;
        c.ipady = 3;
	c.gridx = 2;
	c.gridy = gridy;
	panel.add(jb, c);
   }

   public void drawButtonEnd(JButton jb,int gridy){
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=1;
        c.ipady = 3;
	c.gridx = 3;
	c.gridy = gridy;
	panel.add(jb, c);
   }
   
  public void addNewLine(JTextField jtf,JButton del,JButton addNew,JButton endOf){
        jtf.setVisible(true);
        del.setVisible(true);
        addNew.setVisible(true);
        endOf.setVisible(true);
        panel.validate();  
        panel.repaint();
  }
  
  public void removeLine(JTextField jtf,JButton del, JButton addNew, JButton endOf){
        jtf.setText("");
        jtf.setVisible(false);
        del.setVisible(false);
        addNew.setVisible(false);
        endOf.setVisible(false);
        panel.validate();  
        panel.repaint();
  }

  
 
  
  public void increaseNumberOfSelection(JTextField jtf){
        
            listSize = list.size();
            listSizeToString = String.valueOf(listSize);
            listOfRequiredSelection.add(listSizeToString);
        if(!jtf.getText().equals("")){
            model.addElement(listSizeToString);
            
        }  
        f.repaint();
  }
  
  public void decreaseNumberOfSelection(JTextField jtf){
      if(!jtf.getText().equals("")){
        model.removeElement(listSizeToString);
        }
        f.repaint();
        listSize = list.size();
        listSizeToString = String.valueOf(listSize);
        listOfRequiredSelection.remove(listSizeToString);    
  
  }
    public void actionPerformed(ActionEvent e) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyy-HH.mm.ss");
        Date date = new Date();
        String dateToStr = formatter.format(date);
        
        if (e.getSource() == shuffle) {
            if(list.size()!=0){
                Collections.shuffle(list);
                successDraw.setText("Draw completed");
                successDraw.setVisible(true);
                save.setVisible(true);
            }

            

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
                            new OutputStreamWriter(new FileOutputStream(file, true), Charset.defaultCharset()
                            
                            ));
                    pw = new PrintWriter(br);

                    int index = 0;
                    int value = Integer.parseInt((String)jcbo.getSelectedItem());
                    for (String items : list.subList(0, value)) {
                        ++index;
                        pw.println(index + ". " + items);

                    }
                    
                    pw.println("\n");
                    pw.println("Created on "+dateToStr2);
                    //file.setReadOnly();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ShuffleManualEng.class.getName()).log(Level.SEVERE, null, ex);
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
            new ShuffleManualEng();

        }
    }

    public static void main(String[] args) {

        ShuffleManualEng n = new ShuffleManualEng();
        

    }

}