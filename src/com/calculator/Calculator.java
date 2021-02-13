package com.calculator;

import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;

 class Calculator implements  ActionListener{

     JFrame frame;
     JTextField textField;
     JButton[] numberButtons=new JButton[10];
     JButton[] functionButtons=new JButton[8];
     JButton addBtn, subBtn, mulBtn, divBtn, decBtn, equBtn, delBtn, clrBtn;
     JPanel panel;

     Font myFont=new Font("Courier New", Font.BOLD, 25);
     double num1=0, num2=0, result=0;
     char operator;


    Calculator(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setResizable(false);
        ImageIcon image=new ImageIcon("src/com/calculator/calculator.png");
        frame.setIconImage(image.getImage());
        frame.setLayout(null);

        //set the text field
        textField=new JTextField();
        textField.setBounds(45,50,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //set buttons
        addBtn=new JButton("+");
        subBtn=new JButton("-");
        mulBtn=new JButton("*");
        divBtn=new JButton("/");
        decBtn=new JButton(".");
        equBtn=new JButton("=");
        delBtn=new JButton("Delete");;
        clrBtn=new JButton("Clear");

        functionButtons[0]=addBtn;
        functionButtons[1]=subBtn;
        functionButtons[2]=mulBtn;
        functionButtons[3]=divBtn;
        functionButtons[4]=decBtn;
        functionButtons[5]=equBtn;
        functionButtons[6]=delBtn;
        functionButtons[7]=clrBtn;

        for(int i=0; i< 8; ++i){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0 ; i<10; ++i){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        delBtn.setBounds(35, 430, 154, 50);
        clrBtn.setBounds(205, 430, 145, 50);

        //set the panel
        panel=new JPanel();
        panel.setBounds(45,120, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10 ,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(equBtn);
        panel.add(divBtn);
        panel.add(divBtn);


        frame.add(panel);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(textField);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10 ; ++i){
            if (e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decBtn){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource()==addBtn){
            num1=Double.parseDouble((textField.getText()));
            operator='+';
            textField.setText("");
        }
        if (e.getSource()==subBtn){
            num1=Double.parseDouble((textField.getText()));
            operator='-';
            textField.setText("");
        }
        if (e.getSource()==mulBtn){
            num1=Double.parseDouble((textField.getText()));
            operator='*';
            textField.setText("");
        }
        if (e.getSource()==divBtn){
            num1=Double.parseDouble((textField.getText()));
            operator='/';
            textField.setText("");
        }
        if (e.getSource()==equBtn){
            num2=Double.parseDouble((textField.getText()));

            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if (e.getSource()==clrBtn){
            textField.setText("");
        }
        if (e.getSource()==delBtn){
            String string=textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; ++i){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}
