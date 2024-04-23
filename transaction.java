import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class transaction extends account implements ActionListener {

  static myframe frame;

  static JTextField t1;
  static JTextField t2;

  static JLabel label1;
  static JLabel label3;
  static JLabel label4;

  JButton deposit;
  JButton withdraw;
  JButton back;
  JButton transfer;

  static JButton confirm;
  static JButton clear;
  static JButton cancel;

  static JOptionPane confirmation;

  private static String am = "0";
  private static String em = "";
  private static int ba;
  private static int p;
  private static int tr = 0;

  public static void main(String[] args) {

    new transaction();

  }

  public transaction() {

    frame = new myframe();
    frame.setLayout(new BorderLayout(10, 10));

    JPanel panel3 = new JPanel();
    panel3.setLayout(new BorderLayout());

    JLabel label2 = new JLabel("Transactions");
    label2.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
    label2.setHorizontalAlignment(JLabel.CENTER);

    panel3.add(label2, BorderLayout.CENTER);

    JPanel panel1 = new JPanel();
    panel1.setLayout(null);

    ba = Integer.parseInt(balance.get(q));

    label3 = new JLabel();
    label3.setText("Total Balance : " + ba);
    label3.setBounds(20, 10, 200, 50);
    label3.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));

    label1 = new JLabel("Enter the Amount :");
    label1.setBounds(80, 100, 225, 20);
    label1.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));

    t1 = new JTextField();
    t1.setBounds(80, 140, 225, 50);
    t1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 25));
    t1.addActionListener(this);

    clear = new JButton("Clear");
    clear.setBounds(140, 200, 100, 40);
    clear.setFocusable(false);
    clear.addActionListener(this);

    label4 = new JLabel("Transfer To :");
    label4.setBounds(80, 100, 225, 20);
    label4.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 20));
    label4.setEnabled(false);
    label4.setVisible(false);

    t2 = new JTextField();
    t2.setBounds(80, 140, 225, 50);
    t2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
    t2.setEnabled(false);
    t2.setVisible(false);
    t2.addActionListener(this);

    confirm = new JButton("Confirm");
    confirm.setBounds(205, 300, 100, 40);
    confirm.setFocusable(false);
    confirm.setEnabled(false);
    confirm.setVisible(false);
    confirm.addActionListener(this);

    cancel = new JButton("Cancel");
    cancel.setBounds(140, 350, 100, 40);
    cancel.setFocusable(false);
    cancel.setEnabled(false);
    cancel.setVisible(false);
    cancel.addActionListener(this);

    panel1.add(label3);
    panel1.add(label1);
    panel1.add(t1);
    panel1.add(label4);
    panel1.add(confirm);
    panel1.add(clear);
    panel1.add(cancel);
    panel1.add(t2);

    JPanel panel2 = new JPanel();
    panel2.setLayout(null);
    panel2.setBackground(Color.lightGray);
    panel2.setBounds(350, 20, 200, 400);

    deposit = new JButton("Deposit");
    deposit.setBounds(20, 10, 100, 40);
    deposit.addActionListener(this);
    deposit.setFocusable(false);

    withdraw = new JButton("Withdraw");
    withdraw.setBounds(20, 60, 100, 40);
    withdraw.addActionListener(this);
    withdraw.setFocusable(false);

    transfer = new JButton("Transfer");
    transfer.setBounds(20, 110, 100, 40);
    transfer.addActionListener(this);
    transfer.setFocusable(false);

    back = new JButton("Go Back");
    back.setBounds(20, 160, 100, 40);
    back.addActionListener(this);
    back.setFocusable(false);

    panel2.add(deposit);
    panel2.add(withdraw);
    panel2.add(transfer);
    panel2.add(back);
    panel1.add(panel2);

    confirm.setFocusable(false);

    frame.add(panel3, BorderLayout.NORTH);
    frame.add(panel1, BorderLayout.CENTER);

    frame.setVisible(true);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    em = t2.getText();
    am = t1.getText();
    if (e.getSource() == t1) {
      bal();

    }
    if (e.getSource() == t2) {
      bal();

    }
    if (e.getSource() == clear) {
      bal();

    }
    if (e.getSource() == deposit) {
      bal();
      deposit();

    } else if (e.getSource() == withdraw) {
      bal();
      withdraw();

    } else if (e.getSource() == transfer) {

      appear();
      bal();

    } else if (e.getSource() == confirm) {
      inappear(transfer(withdraw(searchemail(t2.isEnabled()))));

    } else if (e.getSource() == cancel) {

      inappear(true);

    } else if (e.getSource() == back) {
      new bankingApplication();
      frame.dispose();

    }
  }

  public static int bal() {
    ba = Integer.parseInt(balance.get(q));

    label3.setText("Total Balance : " + ba);

    t1.setText("");
    t1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 25));
    t1.setForeground(Color.black);

    t2.setText("");
    t2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
    t2.setForeground(Color.black);

    return ba;

  }

  public static void appear() {

    label1.setBounds(80, 200, 225, 20);

    t1.setBounds(80, 240, 225, 50);

    clear.setBounds(80, 300, 100, 40);

    label4.setEnabled(true);
    label4.setVisible(true);

    t2.setForeground(Color.black);
    t2.setEnabled(true);
    t2.setVisible(true);

    confirm.setEnabled(true);
    confirm.setVisible(true);

    cancel.setEnabled(true);
    cancel.setVisible(true);

  }

  public static void inappear(boolean a) {
    if (a == true) {
      bal();

      label1.setBounds(80, 100, 225, 20);

      t1.setBounds(80, 140, 225, 50);

      clear.setBounds(150, 200, 100, 40);

      label4.setEnabled(false);
      label4.setVisible(false);

      t2.setVisible(false);

      confirm.setEnabled(false);
      confirm.setVisible(false);

      cancel.setEnabled(false);
      cancel.setVisible(false);

    }
  }

  public static int deposit() {
    int con = JOptionPane.showConfirmDialog(null, "Do you want to deposit " + am + " to " + emailid.get(p),
        "CONFIRMATION", JOptionPane.YES_NO_OPTION);

    if (con == JOptionPane.YES_OPTION) {
      ba = ba + Integer.parseInt(am);
      label3.setText("Total Balance : " + ba);
      user_accout();

    } else if (con == JOptionPane.NO_OPTION) {
      inappear(true);

    }
    return ba;

  }

  public static void withdraw() {

    if ((Integer.parseInt(am) <= 20000) && (Integer.parseInt(am) <= ba) && (ba != 0)) {

      int con = JOptionPane.showConfirmDialog(null, "Do you want to withdraw " + am + " to " + emailid.get(p),
          "CONFIRMATION", JOptionPane.YES_NO_OPTION);

      if (con == JOptionPane.YES_OPTION) {
        ba = ba - Integer.parseInt(am);
        user_accout();

      } else if (con == JOptionPane.NO_OPTION) {
        bal();
      }

    } else if (ba < Integer.parseInt(am) || ba == 0) {
      t1.setText("Insufficient Balance");
      t1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
      t1.setForeground(Color.red);

    } else if (Integer.parseInt(am) > 20000) {

      t1.setText("Minimum Amount is 20000");
      t1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
      t1.setForeground(Color.red);

    }
    label3.setText("Total Balance : " + ba);

  }

  public static boolean withdraw(boolean a) {

    if ((Integer.parseInt(am) <= 20000) && (Integer.parseInt(am) <= ba) && (ba != 0)) {
      int con = JOptionPane.showConfirmDialog(null, "Do you want to transfer " + am + " to " + emailid.get(p),
          "CONFIRMATION", JOptionPane.YES_NO_OPTION);

      if (con == JOptionPane.YES_OPTION) {
        ba = ba - Integer.parseInt(am);
        user_accout();
        return true;

      } else if (con == JOptionPane.NO_OPTION) {
        inappear(true);
      }

    } else if (ba < Integer.parseInt(am) || ba == 0) {
      t2.setText("Insufficient Balance");
      t2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 15));
      t2.setForeground(Color.red);
      t1.setForeground(Color.red);

    } else if (Integer.parseInt(am) > 20000) {
      t2.setText("Minimum Amount is ₹20000");
      t2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
      t2.setForeground(Color.red);
      t1.setForeground(Color.red);

    } else {
      t2.setText("Invalid Email_Id");
    }

    label3.setText("Total Balance : " + ba);
    return false;
  }

  public static int deposit(boolean a) {
    tr = Integer.parseInt(balance.get(p));
    System.out.println(tr);
    if (a == true) {
      tr += Integer.parseInt(am);
      user_accout(true);
      return tr;
    }
    return tr;

  }

  public static boolean searchemail(boolean a) {

    System.out.println(em);
    if (a == true) {
      p = 0;
      int n = 0;
      for (String b : emailid) {
        if (b.equals(em)) {
          p = n;
          return true;
        }
        n++;
      }
    }
    return false;
  }

  public static boolean transfer(boolean a) {
    if (a == true) {
      deposit(true);
      return true;
    }
    return false;
  }

  public static boolean user_accout(boolean a) {
    balance.set(p, Integer.toString(tr));
    System.out.println(user_info);
    return true;
  }

  public static void user_accout() {

    balance.set(q, Integer.toString(ba));
    System.out.println(user_info);
  }
}