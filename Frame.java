import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener
{
	//buttons
	JButton addition;
	JButton subtraction;
	JButton mult;
	JButton div;
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton zero;
	JButton equal;
	JButton dec;
	JButton clear;
	
	//Text on LCD
	JLabel Output;
	
	//string for input from calculator
	String input = "";
	
	Frame()
	{					
		addition = new JButton("+");
		addition.setBounds(250, 197, 75, 75);
		addition.addActionListener(this);
		
		subtraction = new JButton("-");
		subtraction.setBounds(327, 197, 75, 75);
		subtraction.addActionListener(this);
		
		mult = new JButton("x");
		mult.setBounds(250, 274, 75, 75);
		mult.addActionListener(this);
		
		div = new JButton("/");
		div.setBounds(327, 274, 75, 75);
		div.addActionListener(this);
		
		equal = new JButton("=");
		equal.setBounds(250, 351, 152, 75);
		equal.addActionListener(this);
		
		seven = new JButton("7");
		seven.setBounds(10, 120, 75, 75);
		seven.addActionListener(this);
		
		eight = new JButton("8");
		eight.setBounds(87, 120, 75, 75);
		eight.addActionListener(this);
		
		nine = new JButton("9");
		nine.setBounds(164, 120, 75, 75);
		nine.addActionListener(this);
		
		four = new JButton("4");
		four.setBounds(10, 197, 75, 75);
		four.addActionListener(this);
		
		five = new JButton("5");
		five.setBounds(87, 197, 75, 75);
		five.addActionListener(this);
		
		six = new JButton("6");
		six.setBounds(164, 197, 75, 75);
		six.addActionListener(this);
		
		one = new JButton("1");
		one.setBounds(10, 274, 75, 75);
		one.addActionListener(this);

		two = new JButton("2");
		two.setBounds(87, 274, 75, 75);
		two.addActionListener(this);
		
		three = new JButton("3");
		three.setBounds(164, 274, 75, 75);
		three.addActionListener(this);
		
		zero = new JButton("0");
		zero.setBounds(10, 351, 152, 75);
		zero.addActionListener(this);
		
		dec = new JButton(".");
		dec.setBounds(164, 351, 75, 75);
		dec.addActionListener(this);
		
		clear = new JButton("CE");
		clear.setBounds(250, 120, 152, 75);
		clear.addActionListener(this);
		
		//creates the UI of the calculator
		Output = new JLabel(input);
		Output.setForeground(Color.black);
		Output.setFont(new Font("Bitstream Vera Sans", 0, 40));
		Output.setBounds(10, 15, 468, 100);
		
		JPanel LCD = new JPanel();
		LCD.setBackground(Color.white);
		LCD.setBounds(10, 15, 392, 100);
		
		JFrame frame = new JFrame();
		frame.setTitle("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setSize(425, 500);
		frame.setVisible(true);
		frame.add(addition);
		frame.add(subtraction);
		frame.add(mult);
		frame.add(div);
		frame.add(equal);
		frame.add(seven);
		frame.add(eight);
		frame.add(nine);
		frame.add(four);
		frame.add(five);
		frame.add(six);
		frame.add(one);
		frame.add(two);
		frame.add(three);
		frame.add(zero);
		frame.add(dec);
		frame.add(clear);
		frame.add(Output);
		frame.add(LCD);
		
		//ImageIcon image = new ImageIcon("Calculator.png");
		//frame.setIconImage(image.getImage());
		//frame.getContentPane().setBackground(new Color(63, 67, 77));
		
	}

	//button inputs here
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == one)
		{
			input += "1";
			Output.setText(input);
		}
		
		else if(e.getSource() == two)
		{
			input += "2";
			Output.setText(input);
		}
		
		else if(e.getSource() == three)
		{
			input += "3";
			Output.setText(input);
		}
		
		else if(e.getSource() == four)
		{
			input += "4";
			Output.setText(input);
		}
		
		else if(e.getSource() == five)
		{
			input += "5";
			Output.setText(input);
		}
		
		else if(e.getSource() == six)
		{
			input += "6";
			Output.setText(input);
		}
		
		else if(e.getSource() == seven)
		{
			input += "7";
			Output.setText(input);
		}
		
		else if(e.getSource() == eight)
		{
			input += "8";
			Output.setText(input);
		}
		
		else if(e.getSource() == nine)
		{
			input += "9";
			Output.setText(input);
		}
		
		else if(e.getSource() == zero)
		{
			input += "0";
			Output.setText(input);
		}
		
		else if(e.getSource() == addition)
		{
			input += "+";
			Output.setText(input);
		}
		
		else if(e.getSource() == subtraction)
		{
			input += "-";
			Output.setText(input);
		}
		
		else if(e.getSource() == mult)
		{
			input += "*";
			Output.setText(input);
		}
		
		else if(e.getSource() == div)
		{
			input += "/";
			Output.setText(input);
		}
		
		else if(e.getSource() == dec)
		{
			input += ".";
			Output.setText(input);
		}
		
		else if(e.getSource() == clear)
		{
			input = "";
			Output.setText(input);
		}
		
		//WHERE THE LOGIC AND COMPUTING HAPPENS
		//idea: have the objects in 2 arrays; operands and operators. When looping through the operators, if + or -, just add the numbers to the arraylist,
		//if * or /, do mult or div by taking the last number from arraylist and mult with next number, then replace the last with new.
		//Testing for first 2 numbers is seperate. In the end, you should be left with + and - on the arraylist, and from there, its just chain add/subtract.
		else if(e.getSource() == equal)
		{
			//break the line into the numbers
			StringTokenizer st = new StringTokenizer(input, "+-*/");
			double x[] = new double[st.countTokens()];
			
			for(int i = 0; st.hasMoreTokens(); i++)
			{
				x[i] = Double.parseDouble(st.nextToken());
			}
			
			//break the line into the operators
			StringTokenizer st2 = new StringTokenizer(input, "1234567890.");
			String op[] = new String[st2.countTokens()];
			
			for(int i = 0; st2.hasMoreTokens(); i++)
			{
				op[i] = st2.nextToken();
			}
			
			//now, do BEDMAS operations
			//D and M
			double temp = 0;
			double temp2 = 0;
			ArrayList<String> news = new ArrayList<String>();	
			
			for(int i = 0; i < op.length; i++)
			{
				//first 2 numbers and first operator
				if(i == 0)
				{
					if(op[0].equals("*"))
					{
						temp = x[0] * x[1];
						news.add(String.valueOf(temp));
					}
					
					else if(op[0].equals("/"))
					{
						temp = x[0] / x[1];
						news.add(String.valueOf(temp));
					}
					
					else if(op[0].equals("+") || op[0].equals("-"))
					{
						news.add(String.valueOf(x[0]));
						news.add(op[0]);
						news.add(String.valueOf(x[1]));
					}
					
				}
				
				//numbers and operators the rest of the way
				else
				{	
					if(op[i].equals("+") || op[i].equals("-"))
					{
						news.add(op[i]);
						news.add(String.valueOf(x[i+1]));
					}
					
					else if(op[i].equals("*"))
					{
						temp2 = Double.parseDouble(news.get(news.size() - 1));
						temp = temp2 * x[i+1];
						news.set((news.lastIndexOf(String.valueOf(temp2))), String.valueOf(temp));
					}
					
					else if(op[i].equals("/"))
					{
						temp2 = Double.parseDouble(news.get(news.size() - 1));
						temp = temp2 / x[i+1];
						news.set((news.lastIndexOf(String.valueOf(temp2))), String.valueOf(temp));
					}
					
				}
			}
			
			double ans = 0;
			
			//if no + or -, just print out answer
			if(news.size() == 1)
			{
				ans = Double.parseDouble(news.get(0));
				input = String.valueOf(ans);
				Output.setText(input);
			}
			
			//otherwise, do stuff
			else
			{
				//A and S, do chain math for + and -
				//after every number, theres an operator, either + or -, therefore, every odd number is an operator (2i + 1)
				
				String sign = "";
				
				for(int i = 1; i < news.size(); i += 2)
				{
					sign = (String)news.get(i);
					
					//test for + or -
					//first 2 numbers and operator
					if(i == 1)
					{
						if(sign.equals("+"))
						{
							ans += Double.parseDouble((String)news.get(i-1));
							ans += Double.parseDouble((String)news.get(i+1));
						}
						
						else if(sign.equals("-"))
						{
							ans += Double.parseDouble((String)news.get(i-1));
							ans -= Double.parseDouble((String)news.get(i+1));
						}
					}
					
					else if(i > 1)
					{
						if(sign.equals("+"))
						{
							ans += Double.parseDouble((String)news.get(i+1));
						}
						
						else if(sign.equals("-"))
						{
							ans += Double.parseDouble((String)news.get(i+1));
						}
					}
				}
				
				input = String.valueOf(ans);
			}
			
			Output.setText(input);
		}
	}
}
