import javax.swing.*;
public class RuntimeAnalyzer{
	public static void main(String args[]) {
		AnalysisGUI window = new AnalysisGUI();
		window.setTitle("Runtime Analyzer");
		window.init();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}