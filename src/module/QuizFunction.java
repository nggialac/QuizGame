package module;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuizFunction implements ActionListener {

	String[] questions = { "Cong ty sang lap java ?", "java ra doi nam nao ?", "Phien ban hien tai cua java sdk ?",
			"Toi thich an cai gi nhat ?" };

	String[][] options = { { "Sun microsystem", "Microsoft", "Startad", "Alphabet" },
			{ "Sun microsystem", "Microsoft", "Startad", "Alphabet" },
			{ "Sun microsystem", "Microsoft", "Startad", "Alphabet" },
			{ "Sun microsystem", "Microsoft", "Startad", "Alphabet" } };

	char[] answers = { 'A', 'B', 'C', 'D' };

	char guess;
	char answer;
	int index;
	int correct_guess = 0;
	int totalQuestions = questions.length;
	int result;
	int seconds = 10;

	JFrame frame = new JFrame();
	JTextField tf = new JTextField();
	JTextArea ta = new JTextArea();
	JButton btA = new JButton();
	JButton btB = new JButton();
	JButton btC = new JButton();
	JButton btD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds <= 0) {
				displayAnswer();
			}
		}
	});
	
	

	public QuizFunction() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(null);
		frame.setResizable(false);

		tf.setBounds(0, 0, 650, 50);
		tf.setBackground(new Color(25, 25, 25));
		tf.setForeground(new Color(25, 250, 0));
		tf.setFont(new Font("Ink Free", Font.BOLD, 30));
		tf.setBorder(BorderFactory.createBevelBorder(1));
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setEditable(false);
		tf.setText("Testing");

		ta.setBounds(0, 50, 650, 50);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		ta.setBackground(new Color(25, 25, 25));
		ta.setForeground(new Color(25, 250, 0));
		ta.setFont(new Font("MV Boli", Font.BOLD, 25));
		ta.setBorder(BorderFactory.createBevelBorder(1));
		ta.setEditable(false);
		ta.setText("Testing TEXT");

		btA.setBounds(0, 100, 100, 100);
		btA.setFont(new Font("MV Boli", Font.BOLD, 25));
		btA.setFocusable(false);
		btA.addActionListener(this);
		btA.setText("A");

		btB.setBounds(0, 200, 100, 100);
		btB.setFont(new Font("MV Boli", Font.BOLD, 25));
		btB.setFocusable(false);
		btB.addActionListener(this);
		btB.setText("B");

		btC.setBounds(0, 300, 100, 100);
		btC.setFont(new Font("MV Boli", Font.BOLD, 25));
		btC.setFocusable(false);
		btC.addActionListener(this);
		btC.setText("C");

		btD.setBounds(0, 400, 100, 100);
		btD.setFont(new Font("MV Boli", Font.BOLD, 25));
		btD.setFocusable(false);
		btD.addActionListener(this);
		btD.setText("D");

		answer_labelA.setBounds(125, 100, 500, 100);
		answer_labelA.setBackground(new Color(50, 50, 50));
		answer_labelA.setForeground(new Color(25, 255, 0));
		answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
		answer_labelA.setText("Testing");

		answer_labelB.setBounds(125, 200, 500, 100);
		answer_labelB.setBackground(new Color(50, 50, 50));
		answer_labelB.setForeground(new Color(25, 255, 0));
		answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
		answer_labelB.setText("Testing");

		answer_labelC.setBounds(125, 300, 500, 100);
		answer_labelC.setBackground(new Color(50, 50, 50));
		answer_labelC.setForeground(new Color(25, 255, 0));
		answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
		answer_labelC.setText("Testing");

		answer_labelD.setBounds(125, 400, 500, 100);
		answer_labelD.setBackground(new Color(50, 50, 50));
		answer_labelD.setForeground(new Color(25, 255, 0));
		answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
		answer_labelD.setText("Testing");

		seconds_left.setBounds(535, 510, 100, 100);
		seconds_left.setBackground(new Color(25, 25, 25));
		seconds_left.setForeground(new Color(255, 0, 0));
		seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));

		time_label.setBounds(535, 475, 100, 25);
		time_label.setBackground(new Color(50, 50, 50));
		time_label.setForeground(new Color(255, 0, 0));
		time_label.setFont(new Font("MV Boli", Font.PLAIN, 20));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer");

		number_right.setBounds(225, 225, 200, 100);
		number_right.setBackground(new Color(25, 25, 25));
		number_right.setForeground(new Color(25, 255, 0));
		number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);

		percentage.setBounds(225, 325, 200, 100);
		percentage.setBackground(new Color(25, 25, 25));
		percentage.setForeground(new Color(25, 255, 0));
		percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

//		frame.add(percentage);
//		frame.add(number_right);
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(btA);
		frame.add(btB);
		frame.add(btC);
		frame.add(btD);
		frame.add(ta);
		frame.add(tf);
		frame.setVisible(true);

		nextQuestion();
	}

	public void nextQuestion() {
		if (index >= totalQuestions) {
			result();
		} else {
			tf.setText("Question " + (index + 1));
			ta.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btA.setEnabled(false);
		btB.setEnabled(false);
		btC.setEnabled(false);
		btD.setEnabled(false);

		if (e.getSource() == btA) {
			answer = 'A';
			if (answer == answers[index]) {
				correct_guess++;
			}
		}

		if (e.getSource() == btB) {
			answer = 'B';
			if (answer == answers[index]) {
				correct_guess++;
			}
		}

		if (e.getSource() == btC) {
			answer = 'C';
			if (answer == answers[index]) {
				correct_guess++;
			}
		}

		displayAnswer();
	}

	public void displayAnswer() {

		timer.stop();
		
		btA.setEnabled(false);
		btB.setEnabled(false);
		btC.setEnabled(false);
		btD.setEnabled(false);

		if (answers[index] != 'A') {
			answer_labelA.setForeground(new Color(255, 0, 0));
		}
		if (answers[index] != 'B') {
			answer_labelB.setForeground(new Color(255, 0, 0));
		}
		if (answers[index] != 'C') {
			answer_labelC.setForeground(new Color(255, 0, 0));
		}
		if (answers[index] != 'D') {
			answer_labelD.setForeground(new Color(255, 0, 0));
		}

		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				answer_labelA.setForeground(new Color(25, 255, 0));
				answer_labelB.setForeground(new Color(25, 255, 0));
				answer_labelC.setForeground(new Color(25, 255, 0));
				answer_labelD.setForeground(new Color(25, 255, 0));

				answer = ' ';
				seconds = 10;
				seconds_left.setText(String.valueOf(seconds));
				btA.setEnabled(true);
				btB.setEnabled(true);
				btC.setEnabled(true);
				btD.setEnabled(true);

				index++;

				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}

	public void result() {
		btA.setEnabled(false);
		btB.setEnabled(false);
		btC.setEnabled(false);
		btD.setEnabled(false);

		result = (int) (correct_guess / (double) totalQuestions) * 100;

		tf.setText("Result!");
		ta.setText("");
		answer_labelA.setText("");
		answer_labelA.setText("");
		answer_labelA.setText("");
		answer_labelA.setText("");

		number_right.setText("(" + correct_guess + "/" + totalQuestions + ")");
		percentage.setText(result + "%");

		frame.add(percentage);
		frame.add(number_right);

	}

}
