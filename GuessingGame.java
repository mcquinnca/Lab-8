import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener {


JTextField userGuessBox = new JTextField(10);
JButton guessButton = new JButton("Guess");  
JButton playButton = new JButton("Play Again");  
JLabel topLabel = new JLabel("Enter your guess:");
JLabel leftLabel = new JLabel("");
JLabel rightLabel = new JLabel("");
Random r = new Random();
int rand;
int lastGuess;

GuessingGame(){
rand = r.nextInt(100)+1;
JFrame f = new JFrame("GuessingGame");
f.setSize(240,120);  
f.setLayout(new FlowLayout(FlowLayout.CENTER));
f.add(topLabel);  
f.add(userGuessBox);
f.add(guessButton);
f.add(leftLabel);
f.add(rightLabel);
f.add(playButton);

f.setVisible(true);

guessButton.addActionListener(this);
playButton.addActionListener(this);  
userGuessBox.addActionListener(this);
}  
 public void actionPerformed(ActionEvent e) {
   if(e.getSource() == guessButton){
     //line to make it easy to troubleshoot
     //System.out.println(rand);
      int guess = Integer.parseInt(userGuessBox.getText());
      if(guess == rand);{
        leftLabel.setText("You Got it!");
        rightLabel.setText("Last guess was: " +lastGuess);
      }
      if (guess > rand){
        lastGuess = guess;
        leftLabel.setText("Too High!");
        rightLabel.setText("Last guess was: " +lastGuess);
      }
      if (guess < rand){
        lastGuess = guess;
        leftLabel.setText("Too Low!");
        rightLabel.setText("Last guess was: " +lastGuess);
      }

   }
   //play Again is pressed
if(e.getSource() == playButton){
    rand = r.nextInt(100)+1;
    leftLabel.setText("");
    rightLabel.setText("");
}

if(e.getSource() == userGuessBox){
  leftLabel.setText("You pressed Enter. Please press the Guess Button.");
}

 }
}