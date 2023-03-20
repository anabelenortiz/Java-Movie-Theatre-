/*CSC1 2300
 * Project 2 - Movie Theatre
 * 
 * Done by Ana Belen Ortiz and Valeria Galiano
 * 5/3/23
 */

 import javax.swing.*;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 
 
 public class MovieTheatrePanel extends JFrame {
     private Movie movie1;
     private Movie movie2;
     private Movie movie3;
 
     public MovieTheatrePanel() {
         super("Welcome to my movie theatre");
         // set layout manager
         setLayout(new BorderLayout());
 
          // create Movie objects
          movie1 = new Movie("Pirates of the Caribbean: At The World's End", "action/adventure", new ImageIcon("pirates.jpg"), 168, "May 24, 2007");
          movie2 = new Movie("Shrek The Third", "family", new ImageIcon("shrek.jpg"), 93, "May 18, 2007");
          movie3 = new Movie("Spider Man 3", "action/adventure", new ImageIcon("spiderman.jpg"), 140, "May 4,2007");
         
 
         /*
         * create top panels
         */
         //panel 1
         JPanel panel1 = new JPanel();
         panel1.setLayout(new BorderLayout());
         panel1.add(new JLabel(new ImageIcon("pirates.jpg")), BorderLayout.CENTER);
         panel1.add(new JLabel(new ImageIcon("pirates.jpg")), BorderLayout.CENTER);
         panel1.add(createTextArea("Name: PIRATES OF THE CARIBBEAN", "Genre: action/adventure", "Duration: 168 min", "Release Date: May 24, 2007"), BorderLayout.SOUTH, SwingConstants.CENTER);
         
         //panel 2
         JPanel panel2 = new JPanel();
         panel2.setLayout(new BorderLayout());
         panel2.add(new JLabel(new ImageIcon("shrek.jpg")), BorderLayout.CENTER);
         panel2.add(createTextArea("Name: SHREK THE THIRD", "Genre: family", "Duration: 93 min", "Release Date: May 18, 2007"), BorderLayout.SOUTH, SwingConstants.CENTER);
         
         //panel 3
         JPanel panel3 = new JPanel();
         panel3.setLayout(new BorderLayout());
         panel3.add(new JLabel(new ImageIcon("spiderman.jpg")), BorderLayout.CENTER);
         panel3.add(createTextArea("Name: SPIDERMAN 3", "Genre: action/adventure", "Duration: 140 min", "Release Date: May 4, 2007"), BorderLayout.SOUTH, SwingConstants.CENTER);
 
         //panel 4
         JPanel panel4 = new JPanel();
         panel4.setLayout(new BoxLayout(panel4, BoxLayout.PAGE_AXIS));
         panel4.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
         JLabel label = new JLabel("Choose the movie you want to watch", SwingConstants.CENTER);
         label.setAlignmentX(Component.CENTER_ALIGNMENT);
         panel4.add(label);
 
         /*
          * note: every panel has been added to topPanel at the end
          * of the code
          */
 
         // create checkbox options
         JCheckBox movie1Tickets = new JCheckBox(movie1.getName());
         JCheckBox movie2Tickets = new JCheckBox(movie2.getName());
         JCheckBox movie3Tickets = new JCheckBox(movie3.getName());
 
         JPanel checkboxPanel = new JPanel();
         checkboxPanel.setLayout(new GridLayout(1, 3)); //add checkboxes horizontally
         checkboxPanel.add(movie1Tickets);
         checkboxPanel.add(movie2Tickets);
         checkboxPanel.add(movie3Tickets);
         //add checkboxPanel to panel4
         panel4.add(checkboxPanel);
 
         // create text box for number of tickets
         JPanel ticketsPanel = new JPanel();
         JLabel ticketsLabel = new JLabel("Number of tickets: ");
         JTextField ticketsField = new JTextField(25);
         ticketsPanel.add(ticketsLabel);
         ticketsPanel.add(ticketsField);
         panel4.add(ticketsPanel); //add ticketsPanel to panel4
 
         // create checkbox for student discount
         JLabel studentDiscount = new JLabel("Do you have a student discount?");
         JCheckBox yesCheckBox = new JCheckBox("Yes");
         JCheckBox noCheckBox = new JCheckBox("No");
         panel4.add(studentDiscount);
         panel4.add(yesCheckBox);
         panel4.add(noCheckBox);
 
         // create buy tickets button
         JButton buyTickets = new JButton("Buy Tickets");
         buyTickets.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) { //create if statements for each checkbox
                     // get the quantity for each movie
                     if (movie1Tickets.isSelected()) {
                         movie1.buyTickets(Integer.parseInt(ticketsField.getText())); //convert String from textfield to int
                     }
                     if (movie2Tickets.isSelected()) {
                         movie2.buyTickets(Integer.parseInt(ticketsField.getText()));
                     }
                     if (movie3Tickets.isSelected()) {
                         movie3.buyTickets(Integer.parseInt(ticketsField.getText()));
                     }
         
                     // calculate the total price
                     int totalPrice = (movie1.getTicketsBought() * 8) + (movie2.getTicketsBought() * 8) + (movie3.getTicketsBought() * 8);
                     if (yesCheckBox.isSelected()) {
                         totalPrice = totalPrice - (movie1.getTicketsBought() + movie2.getTicketsBought() + movie3.getTicketsBought()) * 2;
                     }
                     /*
                      * note: non-students = $8, students = $6
                      */
         
                     // create pop up window to display the ticket information
                     String message = "You have purchased the following tickets:\n\n";
                     if (movie1.getTicketsBought() > 0) {
                         message += "Pirates of the Caribbean: " + movie1.getTicketsBought() + "\n";
                     }
                     if (movie2.getTicketsBought() > 0) {
                         message += "Shrek the Third: " + movie2.getTicketsBought() + "\n";
                     }
                     if (movie3.getTicketsBought() > 0) {
                         message += "Spiderman 3: " + movie3.getTicketsBought() + "\n";
                     }
                     message += "\nTotal Price: $" + totalPrice;
         
                     JOptionPane.showMessageDialog(null, message, "Tickets Purchased", JOptionPane.INFORMATION_MESSAGE);
         
                     // clear the ticket fields and checkboxes
                     ticketsField.setText("");
                     movie1Tickets.setSelected(false);
                     movie2Tickets.setSelected(false);
                     movie3Tickets.setSelected(false);
                     yesCheckBox.setSelected(false);
                     noCheckBox.setSelected(false);
                 }
             });
             panel4.add(buyTickets);
         
 
         /*
          * ALL TOGETHER NOW
          */
 
         // add panels to frame
         JPanel topPanel = new JPanel(new GridLayout(1, 3));
         topPanel.add(panel1);
         topPanel.add(panel2);
         topPanel.add(panel3);
         add(topPanel, BorderLayout.NORTH);
         add(panel4, BorderLayout.SOUTH);
 
         // set frame properties
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setSize(1000, 800);
         setLocationRelativeTo(null);
         setVisible(true);
     }
 
     private JTextArea createTextArea(String title, String genre, String minutes, String date) {
         JTextArea textArea = new JTextArea(title + "\n" + genre + "\n" + minutes + "\n" + date);
         textArea.setEditable(false);
         textArea.setOpaque(false);
         textArea.setLineWrap(true);
         textArea.setWrapStyleWord(true);
         return textArea;
     }
 }

   

  
