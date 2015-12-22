import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;


public class FOSSQuiz {
	
	public static void main(String[] args) throws IOException {
		ArrayList selections = new ArrayList();  //Arraylist that will populate with user selections
		Font def = new Font("Baskerville", Font.BOLD, 12);
		
//		try { 
//		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		final JFrame f = new JFrame("FOSS Quiz");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setPreferredSize(new Dimension(600, 300));
		
		JLabel title = new JLabel("Welcome to the FOSS Quiz!");
		title.setFont(new Font("Baskerville", Font.BOLD, 30));
		//title.setFont(title.getFont().deriveFont(30.0f));

		JButton nextButton = new JButton("Next");
		nextButton.setFont(def);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		nextButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		JPanel viewPanel = new JPanel();
		viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

		
		viewPanel.add(title);
		
		viewPanel.add(nextButton);
		viewPanel.validate();
		viewPanel.setOpaque(true);
		viewPanel.setBackground(new Color(255,219,77));
		f.pack();
		
		f.add(viewPanel);

		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.getContentPane().removeAll();
				f.getContentPane().validate();
				f.repaint();
				
				JLabel questiontitle = new JLabel();
				questiontitle.setText("Question 1");

				JLabel questionlabel = new JLabel();
				questionlabel.setText("1. What does FOSS stand for? ");
				questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

				ButtonGroup BG = new ButtonGroup();
				JRadioButton AC1 = new JRadioButton("A) Free and Open Source Software");
				JRadioButton AC2 = new JRadioButton("B) Free and Open Sustainable Software");
				JRadioButton AC3 = new JRadioButton("C) Forward and Open Sustainable Software ");
				JRadioButton AC4 = new JRadioButton("D) Freeware and Open Source Software ");
				AC1.setFont(def);
				AC2.setFont(def);
				AC3.setFont(def);
				AC4.setFont(def);
				
				AC1.setActionCommand("AC1");
				AC2.setActionCommand("AC2");
				AC3.setActionCommand("AC3");
				AC4.setActionCommand("AC4");

				BG.add(AC1);
				BG.add(AC2);
				BG.add(AC3);
				BG.add(AC4);

				JPanel viewPanel = new JPanel();
				viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

				viewPanel.add(questionlabel);
				viewPanel.add(AC1);
				viewPanel.add(AC2);
				viewPanel.add(AC3);
				viewPanel.add(AC4);

				JButton nextButton = new JButton("Next");
				JButton submitButton = new JButton("Submit");
				
				JPanel buttonPanel = new JPanel();
				buttonPanel.add(submitButton);
				buttonPanel.add(nextButton);
				
				JPanel container = new JPanel();
				container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
				
				JPanel resultPanel = new JPanel();
				resultPanel.setPreferredSize(new Dimension(100,100));
				JLabel resultLabel = new JLabel();
				JLabel answerLabel = new JLabel();
				
				resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
				
				resultPanel.add(resultLabel);
				resultPanel.add(answerLabel);
				
				container.add(viewPanel);
				container.add(buttonPanel);
				container.add(resultPanel);
				
				f.add(container);
				f.getContentPane().validate();
				f.repaint();

				submitButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Enumeration<AbstractButton> enumeration = BG.getElements();
						while (enumeration.hasMoreElements()) {
						    enumeration.nextElement().setEnabled(false);
						}
						if(BG.getSelection().getActionCommand().equals("AC1")){
							resultLabel.setText("Correct!");
							resultLabel.setForeground(Color.GREEN);
							resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
						}else{
							resultLabel.setText("Incorrect");
							resultLabel.setForeground(Color.RED);
							resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
							answerLabel.setText("Correct answer is A");
							answerLabel.setForeground(Color.GREEN);
							answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
						}
						
					}
				});
				nextButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Enumeration<AbstractButton> enumeration = BG.getElements();
						if(enumeration.nextElement().isEnabled() == true){
							return;
						}
						selections.add(BG.getSelection().getActionCommand());
						f.getContentPane().removeAll();
						f.getContentPane().validate();
						f.repaint();

						JLabel questiontitle = new JLabel();
						questiontitle.setText("Question 2");

						JLabel questionlabel = new JLabel();
						questionlabel.setText("2. Who founded the Free Software Foundation? ");
						questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

						ButtonGroup BG = new ButtonGroup();
						JRadioButton AC1 = new JRadioButton("A) Linus Torvalds");
						JRadioButton AC2 = new JRadioButton("B) Larry Page");
						JRadioButton AC3 = new JRadioButton("C) Richard Stallman");
						JRadioButton AC4 = new JRadioButton("D) Steve Jobs");
						AC1.setActionCommand("AC1");
						AC2.setActionCommand("AC2");
						AC3.setActionCommand("AC3");
						AC4.setActionCommand("AC4");
						AC1.setFont(def);
						AC2.setFont(def);
						AC3.setFont(def);
						AC4.setFont(def);

						BG.add(AC1);
						BG.add(AC2);
						BG.add(AC3);
						BG.add(AC4);

						JPanel viewPanel = new JPanel();
						viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

						viewPanel.add(questionlabel);
						viewPanel.add(AC1);
						viewPanel.add(AC2);
						viewPanel.add(AC3);
						viewPanel.add(AC4);

						JButton nextButton = new JButton("Next");
						viewPanel.add(nextButton);
						JButton submitButton = new JButton("Submit");
						
						JPanel buttonPanel = new JPanel();
						buttonPanel.add(submitButton);
						buttonPanel.add(nextButton);
						
						JPanel container = new JPanel();
						container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
						
						JPanel resultPanel = new JPanel();
						resultPanel.setPreferredSize(new Dimension(100,100));
						JLabel resultLabel = new JLabel();
						JLabel answerLabel = new JLabel();
						
						resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
						
						resultPanel.add(resultLabel);
						resultPanel.add(answerLabel);
						
						container.add(viewPanel);
						container.add(buttonPanel);
						container.add(resultPanel);
						
						f.add(container);
						f.getContentPane().validate();
						f.repaint();

						submitButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Enumeration<AbstractButton> enumeration = BG.getElements();
								while (enumeration.hasMoreElements()) {
								    enumeration.nextElement().setEnabled(false);
								}
								if(BG.getSelection().getActionCommand().equals("AC3")){
									resultLabel.setText("Correct!");
									resultLabel.setForeground(Color.GREEN);
									resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
								}else{
									resultLabel.setText("Incorrect");
									resultLabel.setForeground(Color.RED);
									resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
									answerLabel.setText("Correct answer is A");
									answerLabel.setForeground(Color.GREEN);
									answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
								}
								
							}
						});
						nextButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								Enumeration<AbstractButton> enumeration = BG.getElements();
								if(enumeration.nextElement().isEnabled() == true){
									return;
								}
								selections.add(BG.getSelection().getActionCommand());
								f.getContentPane().removeAll();
								f.getContentPane().validate();
								f.repaint();

								JLabel questiontitle = new JLabel();
								questiontitle.setText("Question 3");

								JLabel questionlabel = new JLabel();
								questionlabel.setText("3. Which of the following is a free Operating System? ");
								questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

								ButtonGroup BG = new ButtonGroup();
								JRadioButton AC1 = new JRadioButton("A) Windows");
								JRadioButton AC2 = new JRadioButton("B) GNU/Linux");
								JRadioButton AC3 = new JRadioButton("C) MAC OS");
								JRadioButton AC4 = new JRadioButton("D) UNIX");
								
								AC1.setFont(def);
								AC2.setFont(def);
								AC3.setFont(def);
								AC4.setFont(def);
								
								AC1.setActionCommand("AC1");
								AC2.setActionCommand("AC2");
								AC3.setActionCommand("AC3");
								AC4.setActionCommand("AC4");

								BG.add(AC1);
								BG.add(AC2);
								BG.add(AC3);
								BG.add(AC4);

								JPanel viewPanel = new JPanel();
								viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

								viewPanel.add(questionlabel);
								viewPanel.add(AC1);
								viewPanel.add(AC2);
								viewPanel.add(AC3);
								viewPanel.add(AC4);

								JButton nextButton = new JButton("Next");
								JButton submitButton = new JButton("Submit");
								
								JPanel buttonPanel = new JPanel();
								buttonPanel.add(submitButton);
								buttonPanel.add(nextButton);
								
								JPanel container = new JPanel();
								container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
								
								JPanel resultPanel = new JPanel();
								resultPanel.setPreferredSize(new Dimension(100,100));
								JLabel resultLabel = new JLabel();
								JLabel answerLabel = new JLabel();
								
								resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
								
								resultPanel.add(resultLabel);
								resultPanel.add(answerLabel);
								
								container.add(viewPanel);
								container.add(buttonPanel);
								container.add(resultPanel);
								
								f.add(container);
								f.getContentPane().validate();
								f.repaint();

								submitButton.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										Enumeration<AbstractButton> enumeration = BG.getElements();
										while (enumeration.hasMoreElements()) {
										    enumeration.nextElement().setEnabled(false);
										}
										if(BG.getSelection().getActionCommand().equals("AC2")){
											resultLabel.setText("Correct!");
											resultLabel.setForeground(Color.GREEN);
											resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
										}else{
											resultLabel.setText("Incorrect");
											resultLabel.setForeground(Color.RED);
											resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
											answerLabel.setText("Correct answer is A");
											answerLabel.setForeground(Color.GREEN);
											answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
										}
										
									}
								});
								nextButton.addActionListener(new ActionListener() {
									@Override
									public void actionPerformed(ActionEvent e) {
										Enumeration<AbstractButton> enumeration = BG.getElements();
										if(enumeration.nextElement().isEnabled() == true){
											return;
										}
										selections.add(BG.getSelection().getActionCommand());
										f.getContentPane().removeAll();
										f.getContentPane().validate();
										f.repaint();

										JLabel questiontitle = new JLabel();
										questiontitle.setText("Question 4");

										JLabel questionlabel = new JLabel();
										questionlabel.setText("4. What is VLC used for? ");
										questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

										ButtonGroup BG = new ButtonGroup();
										JRadioButton AC1 = new JRadioButton("A) Playing Media Files");
										JRadioButton AC2 = new JRadioButton("B) Editing Pictures");
										JRadioButton AC3 = new JRadioButton("C) Running Games");
										JRadioButton AC4 = new JRadioButton("D) Browsing the Web");
										AC1.setActionCommand("AC1");
										AC2.setActionCommand("AC2");
										AC3.setActionCommand("AC3");
										AC4.setActionCommand("AC4");
										
										AC1.setFont(def);
										AC2.setFont(def);
										AC3.setFont(def);
										AC4.setFont(def);

										BG.add(AC1);
										BG.add(AC2);
										BG.add(AC3);
										BG.add(AC4);

										JPanel viewPanel = new JPanel();
										viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

										viewPanel.add(questionlabel);
										viewPanel.add(AC1);
										viewPanel.add(AC2);
										viewPanel.add(AC3);
										viewPanel.add(AC4);

										JButton nextButton = new JButton("Next");
										JButton submitButton = new JButton("Submit");
										
										JPanel buttonPanel = new JPanel();
										buttonPanel.add(submitButton);
										buttonPanel.add(nextButton);
										
										JPanel container = new JPanel();
										container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
										
										JPanel resultPanel = new JPanel();
										resultPanel.setPreferredSize(new Dimension(100,100));
										JLabel resultLabel = new JLabel();
										JLabel answerLabel = new JLabel();
										
										resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
										
										resultPanel.add(resultLabel);
										resultPanel.add(answerLabel);
										
										container.add(viewPanel);
										container.add(buttonPanel);
										container.add(resultPanel);
										
										f.add(container);
										f.getContentPane().validate();
										f.repaint();

										submitButton.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												Enumeration<AbstractButton> enumeration = BG.getElements();
												while (enumeration.hasMoreElements()) {
												    enumeration.nextElement().setEnabled(false);
												}
												if(BG.getSelection().getActionCommand().equals("AC1")){
													resultLabel.setText("Correct!");
													resultLabel.setForeground(Color.GREEN);
													resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
												}else{
													resultLabel.setText("Incorrect");
													resultLabel.setForeground(Color.RED);
													resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
													answerLabel.setText("Correct answer is A");
													answerLabel.setForeground(Color.GREEN);
													answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
												}
												
											}
										});
										nextButton.addActionListener(new ActionListener() {
											@Override
											public void actionPerformed(ActionEvent e) {
												Enumeration<AbstractButton> enumeration = BG.getElements();
												if(enumeration.nextElement().isEnabled() == true){
													return;
												}
												selections.add(BG.getSelection().getActionCommand());
												f.getContentPane().removeAll();
												f.getContentPane().validate();
												f.repaint();

												JLabel questiontitle = new JLabel();
												questiontitle.setText("Question 5");

												JLabel questionlabel = new JLabel();
												questionlabel.setText("5. What Organization supports the GNU Project? ");
												questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

												ButtonGroup BG = new ButtonGroup();
												JRadioButton AC1 = new JRadioButton("A) The Open Source Initiative");
												JRadioButton AC2 = new JRadioButton("B) The Free Software Foundation");
												JRadioButton AC3 = new JRadioButton("C) Oracle");
												JRadioButton AC4 = new JRadioButton("D) Sun Microsystems");
												
												AC1.setFont(def);
												AC2.setFont(def);
												AC3.setFont(def);
												AC4.setFont(def);
												
												AC1.setActionCommand("AC1");
												AC2.setActionCommand("AC2");
												AC3.setActionCommand("AC3");
												AC4.setActionCommand("AC4");

												BG.add(AC1);
												BG.add(AC2);
												BG.add(AC3);
												BG.add(AC4);

												JPanel viewPanel = new JPanel();
												viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

												viewPanel.add(questionlabel);
												viewPanel.add(AC1);
												viewPanel.add(AC2);
												viewPanel.add(AC3);
												viewPanel.add(AC4);

												JButton nextButton = new JButton("Next");
												JButton submitButton = new JButton("Submit");
												
												JPanel buttonPanel = new JPanel();
												buttonPanel.add(submitButton);
												buttonPanel.add(nextButton);
												
												JPanel container = new JPanel();
												container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
												
												JPanel resultPanel = new JPanel();
												resultPanel.setPreferredSize(new Dimension(100,100));
												JLabel resultLabel = new JLabel();
												JLabel answerLabel = new JLabel();
												
												resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
												
												resultPanel.add(resultLabel);
												resultPanel.add(answerLabel);
												
												container.add(viewPanel);
												container.add(buttonPanel);
												container.add(resultPanel);
												
												f.add(container);
												f.getContentPane().validate();
												f.repaint();

												submitButton.addActionListener(new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														Enumeration<AbstractButton> enumeration = BG.getElements();
														while (enumeration.hasMoreElements()) {
														    enumeration.nextElement().setEnabled(false);
														}
														if(BG.getSelection().getActionCommand().equals("AC2")){
															resultLabel.setText("Correct!");
															resultLabel.setForeground(Color.GREEN);
															resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
														}else{
															resultLabel.setText("Incorrect");
															resultLabel.setForeground(Color.RED);
															resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
															answerLabel.setText("Correct answer is A");
															answerLabel.setForeground(Color.GREEN);
															answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
														}
														
													}
												});
												nextButton.addActionListener(new ActionListener() {
													@Override
													public void actionPerformed(ActionEvent e) {
														Enumeration<AbstractButton> enumeration = BG.getElements();
														if(enumeration.nextElement().isEnabled() == true){
															return;
														}
														selections.add(BG.getSelection().getActionCommand());
														f.getContentPane().removeAll();
														f.getContentPane().validate();
														f.repaint();

														JLabel questiontitle = new JLabel();
														questiontitle.setText("Question 6");

														JLabel questionlabel = new JLabel();
														questionlabel.setText("6. A license that has minimum restrictions is known as: ");
														questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

														ButtonGroup BG = new ButtonGroup();
														JRadioButton AC1 = new JRadioButton("A) tolerant");
														JRadioButton AC2 = new JRadioButton("B) indulgent");
														JRadioButton AC3 = new JRadioButton("C) copyleft");
														JRadioButton AC4 = new JRadioButton("D) permissive");
														
														AC1.setFont(def);
														AC2.setFont(def);
														AC3.setFont(def);
														AC4.setFont(def);
														
														AC1.setActionCommand("AC1");
														AC2.setActionCommand("AC2");
														AC3.setActionCommand("AC3");
														AC4.setActionCommand("AC4");

														BG.add(AC1);
														BG.add(AC2);
														BG.add(AC3);
														BG.add(AC4);

														JPanel viewPanel = new JPanel();
														viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

														viewPanel.add(questionlabel);
														viewPanel.add(AC1);
														viewPanel.add(AC2);
														viewPanel.add(AC3);
														viewPanel.add(AC4);

														JButton nextButton = new JButton("Next");
														JButton submitButton = new JButton("Submit");
														
														JPanel buttonPanel = new JPanel();
														buttonPanel.add(submitButton);
														buttonPanel.add(nextButton);
														
														JPanel container = new JPanel();
														container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
														
														JPanel resultPanel = new JPanel();
														resultPanel.setPreferredSize(new Dimension(100,100));
														JLabel resultLabel = new JLabel();
														JLabel answerLabel = new JLabel();
														
														resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
														
														resultPanel.add(resultLabel);
														resultPanel.add(answerLabel);
														
														container.add(viewPanel);
														container.add(buttonPanel);
														container.add(resultPanel);
														
														f.add(container);
														f.getContentPane().validate();
														f.repaint();

														submitButton.addActionListener(new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																Enumeration<AbstractButton> enumeration = BG.getElements();
																while (enumeration.hasMoreElements()) {
																    enumeration.nextElement().setEnabled(false);
																}
																if(BG.getSelection().getActionCommand().equals("AC4")){
																	resultLabel.setText("Correct!");
																	resultLabel.setForeground(Color.GREEN);
																	resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																}else{
																	resultLabel.setText("Incorrect");
																	resultLabel.setForeground(Color.RED);
																	resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																	answerLabel.setText("Correct answer is A");
																	answerLabel.setForeground(Color.GREEN);
																	answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																}
																
															}
														});
														nextButton.addActionListener(new ActionListener() {
															@Override
															public void actionPerformed(ActionEvent e) {
																Enumeration<AbstractButton> enumeration = BG.getElements();
																if(enumeration.nextElement().isEnabled() == true){
																	return;
																}
																selections.add(BG.getSelection().getActionCommand());
																f.getContentPane().removeAll();
																f.getContentPane().validate();
																f.repaint();

																JLabel questiontitle = new JLabel();
																questiontitle.setText("Question 7");

																JLabel questionlabel = new JLabel();
																questionlabel.setText("7. How many freedoms are protected by free software? ");
																questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

																ButtonGroup BG = new ButtonGroup();
																JRadioButton AC1 = new JRadioButton("A) 1");
																JRadioButton AC2 = new JRadioButton("B) 2");
																JRadioButton AC3 = new JRadioButton("C) 3");
																JRadioButton AC4 = new JRadioButton("D) 4");
																
																AC1.setFont(def);
																AC2.setFont(def);
																AC3.setFont(def);
																AC4.setFont(def);
																
																AC1.setActionCommand("AC1");
																AC2.setActionCommand("AC2");
																AC3.setActionCommand("AC3");
																AC4.setActionCommand("AC4");

																BG.add(AC1);
																BG.add(AC2);
																BG.add(AC3);
																BG.add(AC4);

																JPanel viewPanel = new JPanel();
																viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

																viewPanel.add(questionlabel);
																viewPanel.add(AC1);
																viewPanel.add(AC2);
																viewPanel.add(AC3);
																viewPanel.add(AC4);

																JButton nextButton = new JButton("Next");
																JButton submitButton = new JButton("Submit");
																
																JPanel buttonPanel = new JPanel();
																buttonPanel.add(submitButton);
																buttonPanel.add(nextButton);
																
																JPanel container = new JPanel();
																container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
																
																JPanel resultPanel = new JPanel();
																resultPanel.setPreferredSize(new Dimension(100,100));
																JLabel resultLabel = new JLabel();
																JLabel answerLabel = new JLabel();
																
																resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
																
																resultPanel.add(resultLabel);
																resultPanel.add(answerLabel);
																
																container.add(viewPanel);
																container.add(buttonPanel);
																container.add(resultPanel);
																
																f.add(container);
																f.getContentPane().validate();
																f.repaint();

																submitButton.addActionListener(new ActionListener() {
																	@Override
																	public void actionPerformed(ActionEvent e) {
																		Enumeration<AbstractButton> enumeration = BG.getElements();
																		while (enumeration.hasMoreElements()) {
																		    enumeration.nextElement().setEnabled(false);
																		}
																		if(BG.getSelection().getActionCommand().equals("AC4")){
																			resultLabel.setText("Correct!");
																			resultLabel.setForeground(Color.GREEN);
																			resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																		}else{
																			resultLabel.setText("Incorrect");
																			resultLabel.setForeground(Color.RED);
																			resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																			answerLabel.setText("Correct answer is A");
																			answerLabel.setForeground(Color.GREEN);
																			answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																		}
																		
																	}
																});
																nextButton.addActionListener(new ActionListener() {
																	@Override
																	public void actionPerformed(ActionEvent e) {
																		Enumeration<AbstractButton> enumeration = BG.getElements();
																		if(enumeration.nextElement().isEnabled() == true){
																			return;
																		}
																		selections.add(BG.getSelection().getActionCommand());
																		f.getContentPane().removeAll();
																		f.getContentPane().validate();
																		f.repaint();

																		JLabel questiontitle = new JLabel();
																		questiontitle.setText("Question 8");

																		JLabel questionlabel = new JLabel();
																		questionlabel.setText("8. Audacity, a free software, is used for what main purpose? ");
																		questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

																		ButtonGroup BG = new ButtonGroup();
																		JRadioButton AC1 = new JRadioButton("A) Word Processing");
																		JRadioButton AC2 = new JRadioButton("B) Video Editing");
																		JRadioButton AC3 = new JRadioButton("C) Music Editing");
																		JRadioButton AC4 = new JRadioButton("D) Picture Editing");
																		
																		AC1.setFont(def);
																		AC2.setFont(def);
																		AC3.setFont(def);
																		AC4.setFont(def);
																		
																		AC1.setActionCommand("AC1");
																		AC2.setActionCommand("AC2");
																		AC3.setActionCommand("AC3");
																		AC4.setActionCommand("AC4");

																		BG.add(AC1);
																		BG.add(AC2);
																		BG.add(AC3);
																		BG.add(AC4);

																		JPanel viewPanel = new JPanel();
																		viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

																		viewPanel.add(questionlabel);
																		viewPanel.add(AC1);
																		viewPanel.add(AC2);
																		viewPanel.add(AC3);
																		viewPanel.add(AC4);

																		JButton nextButton = new JButton("Next");
																		JButton submitButton = new JButton("Submit");
																		
																		JPanel buttonPanel = new JPanel();
																		buttonPanel.add(submitButton);
																		buttonPanel.add(nextButton);
																		
																		JPanel container = new JPanel();
																		container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
																		
																		JPanel resultPanel = new JPanel();
																		resultPanel.setPreferredSize(new Dimension(100,100));
																		JLabel resultLabel = new JLabel();
																		JLabel answerLabel = new JLabel();
																		
																		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
																		
																		resultPanel.add(resultLabel);
																		resultPanel.add(answerLabel);
																		
																		container.add(viewPanel);
																		container.add(buttonPanel);
																		container.add(resultPanel);
																		
																		f.add(container);
																		f.getContentPane().validate();
																		f.repaint();

																		submitButton.addActionListener(new ActionListener() {
																			@Override
																			public void actionPerformed(ActionEvent e) {
																				Enumeration<AbstractButton> enumeration = BG.getElements();
																				while (enumeration.hasMoreElements()) {
																				    enumeration.nextElement().setEnabled(false);
																				}
																				if(BG.getSelection().getActionCommand().equals("AC3")){
																					resultLabel.setText("Correct!");
																					resultLabel.setForeground(Color.GREEN);
																					resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																				}else{
																					resultLabel.setText("Incorrect");
																					resultLabel.setForeground(Color.RED);
																					resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																					answerLabel.setText("Correct answer is A");
																					answerLabel.setForeground(Color.GREEN);
																					answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																				}
																				
																			}
																		});
																		nextButton.addActionListener(new ActionListener() {
																			@Override
																			public void actionPerformed(ActionEvent e) {
																				Enumeration<AbstractButton> enumeration = BG.getElements();
																				if(enumeration.nextElement().isEnabled() == true){
																					return;
																				}
																				selections.add(BG.getSelection().getActionCommand());
																				f.getContentPane().removeAll();
																				f.getContentPane().validate();
																				f.repaint();

																				JLabel questiontitle = new JLabel();
																				questiontitle.setText("Question 9");

																				JLabel questionlabel = new JLabel();
																				questionlabel.setText("9. What organization defines Open Source rules? ");
																				questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

																				ButtonGroup BG = new ButtonGroup();
																				JRadioButton AC1 = new JRadioButton("A) The Open Source Initiative");
																				JRadioButton AC2 = new JRadioButton("B) The Open Source Board");
																				JRadioButton AC3 = new JRadioButton("C) The Open Source Institute");
																				JRadioButton AC4 = new JRadioButton("D) The Open Source Committee");
																				
																				AC1.setFont(def);
																				AC2.setFont(def);
																				AC3.setFont(def);
																				AC4.setFont(def);
																				
																				AC1.setActionCommand("AC1");
																				AC2.setActionCommand("AC2");
																				AC3.setActionCommand("AC3");
																				AC4.setActionCommand("AC4");

																				BG.add(AC1);
																				BG.add(AC2);
																				BG.add(AC3);
																				BG.add(AC4);

																				JPanel viewPanel = new JPanel();
																				viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

																				viewPanel.add(questionlabel);
																				viewPanel.add(AC1);
																				viewPanel.add(AC2);
																				viewPanel.add(AC3);
																				viewPanel.add(AC4);

																				JButton nextButton = new JButton("Next");
																				JButton submitButton = new JButton("Submit");
																				
																				JPanel buttonPanel = new JPanel();
																				buttonPanel.add(submitButton);
																				buttonPanel.add(nextButton);
																				
																				JPanel container = new JPanel();
																				container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
																				
																				JPanel resultPanel = new JPanel();
																				resultPanel.setPreferredSize(new Dimension(100,100));
																				JLabel resultLabel = new JLabel();
																				JLabel answerLabel = new JLabel();
																				
																				resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
																				
																				resultPanel.add(resultLabel);
																				resultPanel.add(answerLabel);
																				
																				container.add(viewPanel);
																				container.add(buttonPanel);
																				container.add(resultPanel);
																				
																				f.add(container);
																				f.getContentPane().validate();
																				f.repaint();

																				submitButton.addActionListener(new ActionListener() {
																					@Override
																					public void actionPerformed(ActionEvent e) {
																						Enumeration<AbstractButton> enumeration = BG.getElements();
																						while (enumeration.hasMoreElements()) {
																						    enumeration.nextElement().setEnabled(false);
																						}
																						if(BG.getSelection().getActionCommand().equals("AC1")){
																							resultLabel.setText("Correct!");
																							resultLabel.setForeground(Color.GREEN);
																							resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																						}else{
																							resultLabel.setText("Incorrect");
																							resultLabel.setForeground(Color.RED);
																							resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																							answerLabel.setText("Correct answer is A");
																							answerLabel.setForeground(Color.GREEN);
																							answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																						}
																						
																					}
																				});
																				nextButton.addActionListener(new ActionListener() {
																					@Override
																					public void actionPerformed(ActionEvent e) {
																						Enumeration<AbstractButton> enumeration = BG.getElements();
																						if(enumeration.nextElement().isEnabled() == true){
																							return;
																						}
																						selections.add(BG.getSelection().getActionCommand());
																						f.getContentPane().removeAll();
																						f.getContentPane().validate();
																						f.repaint();

																						JLabel questiontitle = new JLabel();
																						questiontitle.setText("Question 10");

																						JLabel questionlabel = new JLabel();
																						questionlabel.setText("10. Which commercial company put its software in Open Source first?");
																						questionlabel.setFont(new Font("Baskerville", Font.BOLD, 15));

																						ButtonGroup BG = new ButtonGroup();
																						JRadioButton AC1 = new JRadioButton("A) Windows");
																						JRadioButton AC2 = new JRadioButton("B) Netscape");
																						JRadioButton AC3 = new JRadioButton("C) IBM");
																						JRadioButton AC4 = new JRadioButton("D) Apple");
																						
																						AC1.setFont(def);
																						AC2.setFont(def);
																						AC3.setFont(def);
																						AC4.setFont(def);
																						
																						AC1.setActionCommand("AC1");
																						AC2.setActionCommand("AC2");
																						AC3.setActionCommand("AC3");
																						AC4.setActionCommand("AC4");

																						BG.add(AC1);
																						BG.add(AC2);
																						BG.add(AC3);
																						BG.add(AC4);

																						JPanel viewPanel = new JPanel();
																						viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

																						viewPanel.add(questionlabel);
																						viewPanel.add(AC1);
																						viewPanel.add(AC2);
																						viewPanel.add(AC3);
																						viewPanel.add(AC4);

																						JButton nextButton = new JButton("Next");
																						JButton submitButton = new JButton("Submit");
																						
																						JPanel buttonPanel = new JPanel();
																						buttonPanel.add(submitButton);
																						buttonPanel.add(nextButton);
																						
																						JPanel container = new JPanel();
																						container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
																						
																						JPanel resultPanel = new JPanel();
																						resultPanel.setPreferredSize(new Dimension(100,100));
																						JLabel resultLabel = new JLabel();
																						JLabel answerLabel = new JLabel();
																						
																						resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
																						
																						resultPanel.add(resultLabel);
																						resultPanel.add(answerLabel);
																						
																						container.add(viewPanel);
																						container.add(buttonPanel);
																						container.add(resultPanel);
																						
																						f.add(container);
																						f.getContentPane().validate();
																						f.repaint();

																						submitButton.addActionListener(new ActionListener() {
																							@Override
																							public void actionPerformed(ActionEvent e) {
																								Enumeration<AbstractButton> enumeration = BG.getElements();
																								while (enumeration.hasMoreElements()) {
																								    enumeration.nextElement().setEnabled(false);
																								}
																								if(BG.getSelection().getActionCommand().equals("AC2")){
																									resultLabel.setText("Correct!");
																									resultLabel.setForeground(Color.GREEN);
																									resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																								}else{
																									resultLabel.setText("Incorrect");
																									resultLabel.setForeground(Color.RED);
																									resultLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																									answerLabel.setText("Correct answer is A");
																									answerLabel.setForeground(Color.GREEN);
																									answerLabel.setFont(new Font("Baskerville", Font.BOLD, 15));
																								}
																								
																							}
																						});
																						nextButton.addActionListener(new ActionListener() {
																							@Override
																							public void actionPerformed(ActionEvent e) {
																								Enumeration<AbstractButton> enumeration = BG.getElements();
																								if(enumeration.nextElement().isEnabled() == true){
																									return;
																								}
																								selections.add(BG.getSelection().getActionCommand());
																								f.getContentPane().removeAll();
																								f.getContentPane().validate();
																								f.repaint();

																								List<String> key = new ArrayList<>(Arrays.asList("AC1", "AC3", "AC2", "AC1", "AC2", "AC4", "AC4", "AC3", "AC1", "AC2"));

																								int numRight = 0;
																								for(int i=0; i<selections.size(); i++){
																									if(selections.get(i).equals(key.get(i))){
																										numRight++;
																									}
																								}

																								JLabel resultText = new JLabel("This concludes the FOSS Quiz!");
																								resultText.setFont(new Font("Baskerville", Font.BOLD, 30));
																								JLabel result = new JLabel("You got: " + numRight + " out of 10 correct");
																								result.setFont(new Font("Baskerville", Font.BOLD, 20));
																								JLabel percentage = new JLabel((numRight*10)+"%");
																								percentage.setFont(new Font("Baskerville", Font.BOLD, 20));
																								if(numRight >= 8){
																									percentage.setForeground(Color.GREEN);
																								}else if(numRight>5 && numRight<8){
																									percentage.setForeground(Color.YELLOW);
																								}else{
																									percentage.setForeground(Color.RED);
																								}
																								
																								resultText.setAlignmentX(Component.CENTER_ALIGNMENT);
																								result.setAlignmentX(Component.CENTER_ALIGNMENT);
																								percentage.setAlignmentX(Component.CENTER_ALIGNMENT);

																								JPanel viewPanel = new JPanel();
																								viewPanel.setLayout(new BoxLayout(viewPanel, BoxLayout.PAGE_AXIS));

																								viewPanel.add(resultText);
																								viewPanel.add(result);
																								viewPanel.add(percentage);
																								
																								viewPanel.setBackground(Color.WHITE);

																								f.add(viewPanel);


																								f.getContentPane().validate();
																								f.repaint();
																							}
																						});
																					}
																				});
																			}
																		});
																	}
																});
															}
														});
													}
												});
											}
										});
									}
								});			
							}
						});
					}
				});
			};

		});

		f.pack();
		f.setVisible(true);


	}
}

