/*
	To find minimum array hop or jump to reach the end of the aray.

*/

class ArrayMinimumJump {
	public static String arrayJump(int[] input) {
		int ladder=input[0];
		int stairs = input[0];
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(0));
		
		int jumps =1;
		if(input.length<2) {
			return "failure";
		}
		for (int level=1;level<input.length ;level++ ) {
			if(level== input.length -1) {
				System.out.println(jumps);
				String out = sb.substring(0,jumps);
				sb.setLength(0);
				for(int i=0;i<out.length();i++) {
					sb.append(out.charAt(i));
					sb.append(",");
				}
				sb.append("out");
				return sb.toString();
			}
			if(level+input[level]>ladder) {
				//System.out.println(level);
				sb.append(String.valueOf(level));


				ladder = level+input[level];
			}
			stairs--;
			if(stairs==0) {
				jumps++;
				stairs = ladder - level;
				
				
			}
		}
		System.out.println(jumps);
		String out = sb.substring(0,jumps);
				sb.setLength(0);
				for(int i=0;i<out.length();i++) {
					sb.append(out.charAt(i));
					sb.append(",");
				}
				sb.append("out");
		return sb.toString();
	}
	public static void main(String[] args) {
		int[] input = {5,6,0,4,2,4,1,0,0,4};
		System.out.println("Minimum number of jumps to reach end of an array "+arrayJump(input));
	}
}