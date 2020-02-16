abstract class AlgMonitor{
	protected String name;
	protected int comparisons;
	protected int movements;
	protected int totalTime;
	public int comparisons() {
		return comparisons;
	}
	public int movements() {
		return comparisons;
	}
	public int totalTime() {
		return comparisons + movements;
	}
}