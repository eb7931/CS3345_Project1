abstract class AlgMonitor{
	protected String name;
	protected int comparisons = 0;
	protected int movements = 0;
	protected int totalTime = 0;
	public int comparisons() {
		return comparisons;
	}
	public int movements() {
		return comparisons;
	}
	public int totalTime() {
		return comparisons + movements;
	}
	protected AlgMonitor(int[] list) {
		run(list);
	}
	protected AlgMonitor() {}
	abstract void run(int[] list);
}