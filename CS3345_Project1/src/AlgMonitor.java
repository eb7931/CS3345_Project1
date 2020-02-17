abstract class AlgMonitor{
	protected String name;
	protected int comparisons = 0;
	protected int movements = 0;
	protected long startTime = 0;
	protected long endTime = 0;
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
	public long runTime() {
		return endTime - startTime;
	}
	protected void move() {
		movements++;
	}
	protected void compare() {
		comparisons++;
	}
	protected AlgMonitor() {}
	abstract void run(int[] list);
}