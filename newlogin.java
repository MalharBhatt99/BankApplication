import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class newlogin extends account implements ActionListener {

    static myframe frame;
    static JTextField t1;
    static JTextField t2;
    static JTextField t3;
    static JTextField t4;

    private static String captcha = "";

    static JLabel label6;

    JButton submit;

    private static int n = 0;

    static String em;
    static String p;
    private static String bals = "0";

    public static void main(String[] args) {

        new newlogin();
    }

    public newlogin() {
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

        t2 = new JTextField();
        t2.setBounds(160, 90, 150, 30);
        t2.setForeground(Color.BLACK);
        t2.addActionListener(this);

        JLabel label4 = new JLabel("Re - Type :");
        label4.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
        label4.setBounds(20, 130, 130, 60);

        t3 = new JTextField();
        t3.setBounds(160, 145, 150, 30);
        t3.setForeground(Color.BLACK);
        t3.addActionListener(this);

        JLabel label5 = new JLabel("Captcha :");
        label5.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
        label5.setBounds(20, 185, 130, 60);

        captcha = "";
        Captcha();

        label6 = new JLabel();
        label6.setText(captcha);
        label6.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
        label6.setBounds(30, 235, 100, 50);
        label6.setBackground(Color.black);

        t4 = new JTextField();
        t4.setBounds(160, 200, 150, 30);
        t4.setForeground(Color.BLACK);
        t4.addActionListener(this);

        submit = new JButton();
        submit.setText("Submit");
        submit.setBounds(185, 270, 100, 20);
        submit.addActionListener(this);

        panel2.add(label2);
        panel2.add(t1);
        panel2.add(label3);
        panel2.add(t2);
        panel2.add(label4);
        panel2.add(t3);
        panel2.add(label5);
        panel2.add(label6);
        panel2.add(t4);
        panel2.add(submit);

        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            userinfo(configure_Email(), configure_password(),
                    configure_captcha());
        }

    }

    public static Boolean configure_Email() {

        em = t1.getText();
        p = t2.getText();

        System.out.println("\n" + em + "\n" + p);

        if (((em.replaceAll("@gmail.com", "")).isEmpty()) == false && em.contains("@gmail.com")) {
            System.out.println("Valid email");
            t1.setBackground(Color.GREEN);
            return true;

        } else

        {
            System.out.println("Invalid email");
            t1.setBackground(Color.red);
            return false;

        }
    }

    public static boolean configure_password() {

        boolean l = false;
        boolean u = false;
        boolean lo = false;
        boolean n = false;
        boolean s = false;
        boolean w = true;

        if (p.length() >= 6) {

            l = true;
            for (char c : p.toCharArray()) {

                if (Character.isUpperCase(c)) {
                    u = true;
                } else if (Character.isLowerCase(c)) {
                    lo = true;
                } else if (Character.isDigit(c)) {
                    n = true;
                } else if (!p.matches("[a-zA-Z0-9]*")) {
                    s = true;
                }
                if (Character.isWhitespace(c)) {
                    w = false;
                }

            }
            if (l == true && u == true && lo == true && n == true && s == true && w == true) {

                System.out.println("Valid pass");
                t2.setBackground(Color.GREEN);
                String rp = t3.getText();

                if (!rp.isEmpty()) {
                    if (rp.equals(p)) {
                        t3.setBackground(Color.green);
                        return true;
                    } else {
                        System.out.println("Re-Pass is Invalid.");
                        t3.setBackground(Color.red);
                    }
                } else {
                    t3.setBackground(Color.white);
                }

            }

            if (l == lo == n == s == true && u != true) {
                System.out.println("Pass should contains atleast 1 UpperCase character.");
                t2.setBackground(Color.red);
                t3.setBackground(Color.WHITE);

            }
            if (u == l == n == s == true && lo != true) {
                System.out.println("Pass should contains atleast 1 LowerCase character.");
                t2.setBackground(Color.red);
                t3.setBackground(Color.WHITE);

            }
            if (u == l == lo == s == true && n != true) {
                System.out.println("Pass should contains atleast 1 Digit.");
                t2.setBackground(Color.red);
                t3.setBackground(Color.WHITE);

            }
            if (u == l == n == lo == true && s != true) {
                System.out.println("Pass should contains atleast 1 Symbol.");
                t2.setBackground(Color.red);
                t3.setBackground(Color.WHITE);

            }
            if (u == l == n == lo == s == true && w != true) {
                System.out.println("Pass shouldnot contain Spaces.");
                t2.setBackground(Color.red);
                t3.setBackground(Color.WHITE);

            }
        } else {
            System.out.println("Pass should be atleast of 6 character.");
            t2.setBackground(Color.red);
            t3.setBackground(Color.WHITE);
        }
        return false;
    }

    public static void Captcha() {
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int n = r.nextInt(0, 3);
            switch (n) {
                case 0:
                    upp_low();
                    break;
                case 1:
                    num();
                    break;
                case 2:
                    low();
                    break;
                default:
                    break;
            }

        }
        System.out.println(captcha);

    }

    public static boolean configure_captcha() {
        if ((t4.getText()).equals(captcha)) {
            System.out.println("Valid Capcha.");
            t4.setBackground(Color.green);
            return true;
        }
        System.out.println("Invalid Capcha.");
        t4.setBackground(Color.red);
        return false;
    }

    public static void upp_low() {
        String A[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
                "T", "U", "V", "W", "X", "Y", "Z" };
        Random r = new Random();
        int N = r.nextInt(0, 24);
        captcha += A[N];

    }

    public static void low() {
        String a[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
                "t", "u", "v", "w", "x", "y", "z" };
        Random r = new Random();
        int n = r.nextInt(0, 24);
        captcha += a[n];

    }

    public static void num() {
        Random r = new Random();
        int num = r.nextInt(0, 11);
        captcha += Integer.toString(num);
    }

    public static void userinfo(boolean a, boolean b, boolean c) {
        if (a == true && b == true && c == true) {
            emailid.add(em);
            Collections.sort(emailid);
            password.add(emailid.indexOf(em), p);
            balance.add(emailid.indexOf(em), bals);

            if (n == 0) {
                user_info.add(emailid);
                user_info.add(password);
                user_info.add(balance);

                n++;
            }
            new bankingApplication();
            frame.dispose();
        }
        System.out.println(user_info);
    }

}
