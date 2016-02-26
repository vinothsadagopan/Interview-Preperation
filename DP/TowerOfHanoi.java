class TowerOfHanoi {
	public static void solve(int n, String source, String intermediate, String end) {
		if(n<1) {
			System.out.println("Insufficient disks...");
			return;
		}
		if(n==1) {
			System.out.println("Disk moved from "+source+" to destination "+end);
			return;
		}
		else {
			solve(n-1,source,end,intermediate);
			solve(1, source,intermediate,end);
			solve(n-1,intermediate,source,end);
		}
	}
	public static void main(String[] args) {
		solve(3,"A","B","C");
	}
}