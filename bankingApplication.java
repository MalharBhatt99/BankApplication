import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class bankingApplication extends account implements ActionListener {

    JButton submit;
    JButton new_login;
    JButton clear;

    static myframe frame;
    static JTextField t1;
    static JPasswordField t2;

    public static void main(String[] args) {

        new bankingApplication();

    }

    public bankingApplication() {
        frame = new myframe();
        frame.setLayout(new BorderLayout(20, 20));

        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel("Welcome to Banking Application");
        label1.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));

        panel1.add(label1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);

        JLabel label2 = new JLabel("Email ID :");
        label2.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
        label2.setBounds(20, 20, 130, 60);

        t1 = new JTextField();

        t1.setBounds(160, 35, 150, 30);
        t1.setForeground(Color.BLACK);
        t1.addActionListener(this);

        JLabel label3 = new JLabel("Password :");
        label3.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
        label3.setBounds(20, 75, 130, 60);

        t2 = new JPasswordField();

        t2.setBounds(160, 90, 150, 30);
        t2.setForeground(Color.BLACK);
        t2.addActionListener(this);

        submit = new JButton();
        submit.setText("Submit");
        submit.setBounds(240, 140, 100, 20);
        submit.setFocusable(false);
        submit.addActionListener(this);

        clear = new JButton();
        clear.setText("Clear");
        clear.setBounds(130, 140, 100, 20);
        clear.setFocusable(false);
        clear.addActionListener(this);

        new_login = new JButton();
        new_login.setText("New Login");
        new_login.setBounds(180, 180, 100, 20);
        new_login.setFocusable(false);
        new_login.addActionListener(this);

        panel2.add(label2);
        panel2.add(t1);
        panel2.add(label3);
        panel2.add(t2);
        panel2.add(submit);
        panel2.add(clear);
        panel2.add(new_login);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            checkemail();
            if (type(checkpass(searchemail())) == true) {
                new transaction();
                frame.dispose();
            }
        } else if (e.getSource() == clear) {
            t1.setText("");
            t2.setText("");

        } else if (e.getSource() == new_login) {
            new newlogin();
            frame.dispose();
        }
    }

    public static boolean searchemail() {
        int n = 0;
        for (String a : emailid) {
            if (a.equals(t1.getText())) {

                q = n;
                return true;
            }
            n++;
        }
        return false;

    }

    public static boolean checkpass(boolean a) {
        if (a == true) {

            System.out.println(q);
            return ((password.get(q)).equals(new String(t2.getPassword()))) ? true : false;
        }
        return false;
    }

    public static boolean type(boolean a) {
        t1.setText(searchemail() == true ? "Valid Email" : "Invalid Email");
        t2.setText(checkpass(searchemail()) == true ? "Valid Password" : "Incorrect Password");

        return a == true ? true : false;
    }

    public static void checkemail() {
        if (user_info.isEmpty()) {
            new newlogin();
            frame.dispose();
        }
    }

}