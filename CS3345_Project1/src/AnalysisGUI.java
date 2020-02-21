import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AnalysisGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	protected ListManager lists = new ListManager(0);
	protected Buttons buttons = new Buttons();
	protected Text text = new Text();
	protected ListManager list;
	protected int selectedAlg = 0;
	private String dataType = "";
	protected int length = 0;

	//Everything  needed to create the window in the format I want

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == buttons.create) {
				int l = Integer.parseInt(text.sizeField.getText());
				if(buttons.inOrder.isSelected()) {
					list = new InOrder(l);
					dataType = "In order";
				}
				else if(buttons.reverseOrder.isSelected()) {
					list = new ReverseOrder(l);
					dataType = "Reverse order";
				}
				else if(buttons.random.isSelected()) {
					list = new RandomOrder(l);
					dataType = "Random order";
				}
				else if(buttons.almostOrder.isSelected()) {
					list = new AlmostOrder(l);
					dataType = "Almost order";
				}
				length = l;
			}
			else if(e.getSource() == buttons.insertion) {
				selectedAlg = 0;
			}
			else if(e.getSource() == buttons.selection) {
				selectedAlg = 1;
			}
			else if(e.getSource() == buttons.quick) {
				selectedAlg = 2;
			}
			else if(e.getSource() == buttons.merge) {
				selectedAlg = 3;
			}
			else if(e.getSource() == buttons.heap) {
				selectedAlg = 4;
			}
			else if(e.getSource() == buttons.radix) {
				selectedAlg = 5;
			}
			else if(e.getSource() == buttons.bucket) {
				selectedAlg = 6;
			}
			
			updateOutput();
			}
		catch(Exception err) {
			err.printStackTrace();
		}
	}
	protected void updateOutput() {
		
		text.NField.setText(Integer.toString(length));
		text.DataTypeField.setText(dataType);
		try {
		text.SortField.setText(list.operations[selectedAlg].name());
		text.ComparisonsField.setText(Integer.toString(list.operations[selectedAlg].comparisons()));
		text.MovementsField.setText(Integer.toString(list.operations[selectedAlg].movements()));
		text.TotalTimeField.setText(Long.toString(list.operations[selectedAlg].runTime()));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		text.winner.setText(winner());
	}
	protected String winner() {
		String alg = "";
		long[] times = new long[7];
		for(int i = 0; i < 7; i++) {
			times[i] = list.operations[i].runTime();
		}
		long min = times[0];
		int win = 0;
		for(int i = 1; i < 7; i++) {
			if(min > times[i]) {
				min = times[i];
				win = i;
			}
			times[i] = list.operations[i].runTime();
		}
		switch(win) {
		case 0:	alg = "Insertion Sort";
				break;
		case 1:	alg = "Selection Sort";
				break;
		case 2:	alg = "Quick Sort";
				break;
		case 3:	alg = "Merge Sort";
				break;
		case 4:	alg = "Heap Sort";
				break;
		case 5:	alg = "Radix Sort";
				break;
		case 6:	alg = "Bucket Sort";
				break;
		}
		return alg;
	}
	public class Text{
		//winner section
		JTextField winner = new JTextField("");
		//All fields in the Properties Section
		JTextField sizeField = new JTextField("");
		//Results section	
		JTextField NField = new JTextField("");
		JTextField DataTypeField = new JTextField("");
		JTextField SortField = new JTextField("");
		JTextField ComparisonsField = new JTextField("");
		JTextField MovementsField = new JTextField("");
		JTextField TotalTimeField = new JTextField("");

		JTextField N = new JTextField("N: ");
		JTextField DataType = new JTextField("Data type: ");
		JTextField Sort = new JTextField("Sort: ");
		JTextField Comparisons = new JTextField("Comparisons: ");
		JTextField Movements = new JTextField("Movements: ");
		JTextField TotalTime = new JTextField("Total time: ");
		JTextField heading1 = new JTextField("Winning Algorithm");
		JTextField heading2 = new JTextField("List Properties");
		JTextField heading3 = new JTextField("Experimental Results:");
		JTextField sizeLabel = new JTextField("List Length");
		
		public Text() {
			NField.setEditable(false);
			DataTypeField.setEditable(false);
			SortField.setEditable(false);
			ComparisonsField.setEditable(false);
			MovementsField.setEditable(false);
			TotalTimeField.setEditable(false);
			
			N.setBackground(Styles.backgroundColor);
			N.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	        N.setHorizontalAlignment(JTextField.RIGHT);
	        N.setEditable(false);

			DataType.setBackground(Styles.backgroundColor);
			DataType.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	        DataType.setHorizontalAlignment(JTextField.RIGHT);
	        DataType.setEditable(false);

			Sort.setBackground(Styles.backgroundColor);
			Sort.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	        Sort.setHorizontalAlignment(JTextField.RIGHT);
	        Sort.setEditable(false);
	        
			Comparisons.setBackground(Styles.backgroundColor);
			Comparisons.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	        Comparisons.setHorizontalAlignment(JTextField.RIGHT);
	        Comparisons.setEditable(false);

			Movements.setBackground(Styles.backgroundColor);
			Movements.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	        Movements.setHorizontalAlignment(JTextField.RIGHT);
	        Movements.setEditable(false);

			TotalTime.setBackground(Styles.backgroundColor);
			TotalTime.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	        TotalTime.setHorizontalAlignment(JTextField.RIGHT);
	        TotalTime.setEditable(false);

			winner.setBackground(Styles.lightButton);
	        winner.setEditable(false);

			heading1.setBackground(Styles.backgroundColor);
			heading1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			heading1.setFont(Styles.largePlainTextFont);
	        heading1.setHorizontalAlignment(JTextField.CENTER);
	        heading1.setEditable(false);

			heading2.setBackground(Styles.backgroundColor);
			heading2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			heading2.setFont(Styles.largePlainTextFont);
	        heading2.setHorizontalAlignment(JTextField.CENTER);
	        heading2.setEditable(false);
			
			heading3.setBackground(Styles.backgroundColor);
			heading3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			heading3.setFont(Styles.largePlainTextFont);
	        heading3.setHorizontalAlignment(JTextField.CENTER);
	        heading3.setEditable(false);

			sizeLabel.setBackground(Styles.backgroundColor);
			sizeLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			sizeLabel.setFont(Styles.plainTextFont);
			sizeLabel.setHorizontalAlignment(JTextField.CENTER);
	        sizeLabel.setEditable(false);
		}
		
	}
	public class Buttons{
		//a container for all of the buttons to keep everything neat
		//properties section buttons
		ButtonGroup properties = new ButtonGroup();
		JRadioButton inOrder = new JRadioButton("In Order");
		JRadioButton reverseOrder = new JRadioButton("Reverse Order");
		JRadioButton almostOrder = new JRadioButton("Almost Order");
		JRadioButton random = new JRadioButton("Random");
		//Sort buttons in the left panel
		JButton insertion = new JButton("Insertion Sort");
		JButton selection = new JButton("Selection Sort");
		JButton quick = new JButton("Quick Sort");
		JButton merge = new JButton("Merge Sort");
		JButton heap = new JButton("Heap Sort");
		JButton radix = new JButton("Radix Sort");		
		JButton bucket = new JButton("Bucket Sort");		
		JButton create = new JButton("Create this List");
		public Buttons() {
			//upon calling, it sets the format of each button
			//mostly to keep code neater
			insertion.setBackground(Styles.darkButton);
			insertion.setFont(Styles.plainTextFont);
			insertion.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			
			selection.setBackground(Styles.darkButton);
			selection.setFont(Styles.plainTextFont);
			selection.setBorder(javax.swing.BorderFactory.createEmptyBorder());

			quick.setBackground(Styles.darkButton);
			quick.setFont(Styles.plainTextFont);
			quick.setBorder(javax.swing.BorderFactory.createEmptyBorder());

			merge.setBackground(Styles.darkButton);
			merge.setFont(Styles.plainTextFont);
			merge.setBorder(javax.swing.BorderFactory.createEmptyBorder());

			heap.setBackground(Styles.darkButton);
			heap.setFont(Styles.plainTextFont);
			heap.setBorder(javax.swing.BorderFactory.createEmptyBorder());

			radix.setBackground(Styles.darkButton);
			radix.setFont(Styles.plainTextFont);
			radix.setBorder(javax.swing.BorderFactory.createEmptyBorder());

			bucket.setBackground(Styles.darkButton);
			bucket.setFont(Styles.plainTextFont);
			bucket.setBorder(javax.swing.BorderFactory.createEmptyBorder());

			almostOrder.setBackground(Styles.backgroundColor);
			random.setBackground(Styles.backgroundColor);
			reverseOrder.setBackground(Styles.backgroundColor);
			inOrder.setBackground(Styles.backgroundColor);
			create.setBackground(Styles.darkButton);
			create.setFont(Styles.plainTextFont);
			create.setBorder(javax.swing.BorderFactory.createEmptyBorder());
			

			properties.add(inOrder);
			properties.add(reverseOrder);
			properties.add(random);
			properties.add(almostOrder);			
		}
		
	}
	public static class Styles{
		//just a place to keep track of style components
		static Dimension defaultSize = new Dimension(500,500);
		static Color lightButton = new Color(250,250,250);
		static Color darkButton = new Color(240,240,240);
		static Color backgroundColor = new Color(230,230,230);
		static Font plainTextFont = new Font("Segoe UI", Font.PLAIN, 14);
		static Font largePlainTextFont = new Font("Segoe UI", Font.PLAIN, 18);
	}
	public void addActionListeners() {
		//Sort buttons in the left panel
		buttons.insertion.addActionListener(this);
		buttons.selection.addActionListener(this);
		buttons.quick.addActionListener(this);
		buttons.merge.addActionListener(this);
		buttons.heap.addActionListener(this);
		buttons.radix.addActionListener(this);	
		buttons.bucket.addActionListener(this);			
		buttons.create.addActionListener(this);
		
	}	public void init() {
		setSize(Styles.defaultSize);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setMinimumSize(Styles.defaultSize);
		setLayout(new GridBagLayout());
		setBackground(Styles.backgroundColor);
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Styles.backgroundColor));
		this.getContentPane().setBackground(Styles.backgroundColor);
		addSortButtons();
		addWinnerSection();
		addPropertiesSection();
		addResultsSection();
		addActionListeners();
		
	}
	public void addWinnerSection() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets = new Insets(2, 2, 2, 2);
		JPanel winnerSection = new JPanel();
		winnerSection.setLayout(new GridBagLayout());
		winnerSection.setBackground(Styles.backgroundColor);
		c.gridwidth = 2;
		c.weighty = 1;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;
		JTextField heading = new JTextField("Winning Algorithm");
		heading.setBackground(Styles.backgroundColor);
		heading.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		heading.setFont(Styles.largePlainTextFont);
        heading.setHorizontalAlignment(JTextField.CENTER);
        heading.setEditable(false);
		winnerSection.add(heading, c);
		c.gridy++;
		winnerSection.add(text.winner, c);
		c.gridx = 1;
		c.gridy = 0;
		c.weighty = .15;
		add(winnerSection, c);
	}
	
	public void addPropertiesSection() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets = new Insets(2, 2, 2, 2);
		c.weightx = 1;
		c.weighty = 1;
		JPanel propertiesSection = new JPanel();
		propertiesSection.setLayout(new GridBagLayout());
		propertiesSection.setBackground(Styles.backgroundColor);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		propertiesSection.add(text.heading2,c);
		c.gridwidth = 1;
		c.gridy++;
		propertiesSection.add(buttons.inOrder, c);
		c.gridx++;
		propertiesSection.add(buttons.reverseOrder, c);
		c.gridy++;
		propertiesSection.add(buttons.random, c);
		c.gridx--;
		propertiesSection.add(buttons.almostOrder, c);		
		c.gridwidth = 2;
		c.weightx = 2;
		c.gridy++;
		propertiesSection.add(text.sizeLabel, c);
		c.gridy++;
		propertiesSection.add(text.sizeField, c);
		c.gridy++;
		propertiesSection.add(buttons.create, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.weighty = .4;
		add(propertiesSection, c);
	}
	public void addResultsSection() {
		GridBagConstraints c = new GridBagConstraints();
		c.fill=GridBagConstraints.BOTH;
		c.insets = new Insets(2, 2, 2, 2);
		c.weightx = 1;
		c.weighty = 1;
		JPanel resultsSection = new JPanel();
		resultsSection.setLayout(new GridBagLayout());
		resultsSection.setBackground(Styles.backgroundColor);
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;
		resultsSection.add(text.heading3,c);
		c.gridwidth = 1;
		c.weightx = .3;
		c.gridy++;
		resultsSection.add(text.N,c);
		c.gridy++;
		resultsSection.add(text.DataType,c);
		c.gridy++;
		resultsSection.add(text.Sort,c);
		c.gridy++;
		resultsSection.add(text.Comparisons,c);
		c.gridy++;
		resultsSection.add(text.Movements,c);
		c.gridy++;
		resultsSection.add(text.TotalTime,c);
		c.gridy = 1;
		c.weightx = .7;
		c.gridx++;
		resultsSection.add(text.NField,c);
		c.gridy++;
		resultsSection.add(text.DataTypeField,c);
		c.gridy++;
		resultsSection.add(text.SortField,c);
		c.gridy++;
		resultsSection.add(text.ComparisonsField,c);
		c.gridy++;
		resultsSection.add(text.MovementsField,c);
		c.gridy++;
		resultsSection.add(text.TotalTimeField,c);		
		
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = .45;
		add(resultsSection, c);
	}
	public void addSortButtons() {
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.weighty = 1;
		c.fill=GridBagConstraints.BOTH;
		c.insets = new Insets(2, 2, 2, 2);
		JPanel sortButtons = new JPanel();
		sortButtons.setLayout(new GridBagLayout());
		sortButtons.setBackground(Styles.backgroundColor);
		c.gridx = 0;
		c.gridy = 0;
		sortButtons.add(buttons.insertion, c);
		c.gridy++;
		sortButtons.add(buttons.selection, c);
		c.gridy++;		
		sortButtons.add(buttons.quick, c);
		c.gridy++;		
		sortButtons.add(buttons.merge, c);
		c.gridy++;		
		sortButtons.add(buttons.heap, c);
		c.gridy++;
		sortButtons.add(buttons.radix, c);
		c.gridy++;
		sortButtons.add(buttons.bucket, c);
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 3;
		add(sortButtons, c);
	}
}