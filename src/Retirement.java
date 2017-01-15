/* Aleksandr Movsesyan
   Retirement.java

   Inputs user's age then how much money they want to invest each month
and finally outputs how much money they will have when they are 65.
*/


import javax.swing.JApplet;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Retirement extends JApplet
{
  public void start()
  {
    String money_string, age_string;
    int age;
    double money, total = 0.0, interest = 0.0, interest_rate = 0.05 / 12;
    DecimalFormat output_money = new DecimalFormat("#,##0.00");

    age_string = JOptionPane.showInputDialog("Welcome to Aleksandr's" +
                                             " Retirement Program!\nHow" +
                                             " old are you?");
    age = Integer.parseInt(age_string);

    if( age >= 65)
      JOptionPane.showMessageDialog(null, "I'm sorry, you are too old to start"
                                    + " saving money");
    else
    {
      money_string = JOptionPane.showInputDialog("How much money would you" +
                                               " like to invest each month");
      money = Double.parseDouble(money_string);

      for ( int years = age; years < 65; years++)
      {
        for ( int month = 0; month < 12; month++)
        {
          interest = total * interest_rate;
          total += money + interest;
        }
      }

      JOptionPane.showMessageDialog(null, "With 5% interest, when you are 65 " +
              "you will have " + output_money.format(total) + " saved");
    }
  }
}