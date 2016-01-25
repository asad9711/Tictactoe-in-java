import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class Tic implements ActionListener
{
JFrame f;
JButton b1,b2,b3;
JLabel l;
JButton b[][]=new JButton[3][3];
String x1,x2;
int counter=0;
public Tic(String x)
{
f=new JFrame(x);
 for(int i=0;i<3;i++)
 {
 for(int j=0;j<3;j++)
 {
	 b[i][j]=new JButton();
	 b[i][j].setBounds(80+100*j,30+100*i,100,100);
	 b[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
     f.add(b[i][j]);
	 b[i][j].addActionListener(this);
 }
 }
 b1=new JButton("player1");
 b2=new JButton("player2");
 b3=new JButton("refresh");
 
 b1.addActionListener(this);
 b1.setBounds(100,360,100,50);
 b1.setFont(new Font("Arial", Font.PLAIN, 20));
 b2.addActionListener(this);
 b2.setBounds(220,360,100,50);
 b2.setFont(new Font("Arial", Font.PLAIN, 20));
 b3.setBounds(130,500,200,50);
 b3.setFont(new Font("Arial", Font.PLAIN, 20));
 b3.addActionListener(this);
 l=new JLabel();
 l.setFont(new Font("Arial", Font.PLAIN, 60));
 l.setBounds(100,420,350,70);
 l.setOpaque(true);
 f.add(l);
 f.add(b1);
 f.add(b2);
 f.add(b3);
 f.setSize(500,700);
 f.setLayout(null);
     l.setText(" ");
	 f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 f.setVisible(true);
}
public static void main(String s[])
{
new Tic("tic tac toe");
}
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
		x1=b1.getText();
		
	}
	else if(e.getSource()==b2)
	{
		x1=b2.getText();
	}
	else if(e.getSource()==b3)
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				b[i][j].setText(" ");
			}
		}
		counter=0;
		l.setText(" ");
	}
	else
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
		if(e.getSource()==b[i][j])
		{
			counter++;
			if(x1.equals("player1"))
		{
			b[i][j].setText("0");
		}
		else
		{
			b[i][j].setText("X");
		}
			checkrow();
		 checkcol();
		  checkdiag();
		  if(counter==9)
			  l.setText("TIE");
		}
			}
		}
	}
	
}
public void checkrow()
{
	for(int i=0;i<3;i++)
	{
		if(b[0][i].getText().equals("0")&&b[1][i].getText().equals("0")&&b[2][i].getText().equals("0"))
			l.setText("player1 won");
		else if(b[0][i].getText().equals("X")&&b[1][i].getText().equals("X")&&b[2][i].getText().equals("X"))
			l.setText("player2 won");
	}
}
public void checkcol()
{
	
	for(int i=0;i<3;i++)
	{
		if(b[i][0].getText().equals("0")&&b[i][1].getText().equals("0")&&b[i][2].getText().equals("0"))
			l.setText("player1 won");
		else if(b[i][0].getText().equals("X")&&b[i][1].getText().equals("X")&&b[i][2].getText().equals("X"))
			l.setText("player2 won");
	}
}
public void checkdiag()
{
	
	if(b[0][0].getText().equals("0")&&b[1][1].getText().equals("0")&&b[2][2].getText().equals("0"))
		l.setText("player1 won");
	
	if(b[0][0].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][2].getText().equals("X"))
		l.setText("player2 won");
	
	if(b[0][2].getText().equals("0")&&b[1][1].getText().equals("0")&&b[2][0].getText().equals("0"))
		l.setText("player1 won");
	
	if(b[0][2].getText().equals("X")&&b[1][1].getText().equals("X")&&b[2][0].getText().equals("X"))
		l.setText("player2 won");
}
}
