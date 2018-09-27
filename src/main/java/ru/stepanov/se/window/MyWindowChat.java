package ru.stepanov.se.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindowChat extends JFrame {

    public MyWindowChat() {
        setBounds(500, 500, 400, 400);
        setTitle("Window chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
         Кнопка для отправки сообещние
         */
        JButton jbs = new JButton("Send");
        add(jbs, BorderLayout.PAGE_END);

        /*
        Label для полей
         */
        JLabel textLabel = new JLabel("Text:");
        textLabel.setForeground(Color.WHITE);
        JLabel messageLabel = new JLabel("Message:");
        messageLabel.setForeground(Color.WHITE);
        /*
        Поля для отправки сообещений
         */
        JTextArea textField = new JTextArea(18, 30);
        JTextField messageField = new JTextField(15);
        textField.setBackground(new Color(243, 246, 185));
        messageField.setToolTipText("Field for message");
        textField.setToolTipText("Field for text");

        /*
        Главная панель
         */
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contents.setBackground(new Color(79, 82, 116));
        contents.add(textLabel);
        contents.add(textField);
        contents.add(messageLabel);
        contents.add(messageField);
        contents.add(jbs, BorderLayout.PAGE_END);
        setContentPane(contents);


        jbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.append(messageField.getText() + "\n");
                messageField.setText(null);
            }
        });
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.append(messageField.getText() + "\n");
                messageField.setText(null);
            }
        });
        setVisible(true);
    }
}

class App {
    public static void main(String[] args) {
        new MyWindowChat();
    }
}
