import java.util.*;
class ParanthesisCombination {
	public static List<String> generateParenthesis(int n) {
        //List<Character> pList = new ArrayList<Character>();
        StringBuffer sb = new StringBuffer();
        List<String> finalResult = new ArrayList<String>(); 
        printBrackets(n,sb,finalResult,0,0);
        return finalResult;
    }
    private static void printBrackets(int N, StringBuffer list,List<String>finalResult, int open, int close) {
        if (list.length() == 2*N) {
            //print(list);
            finalResult.add(list.toString());
            return;
        }
        if (open < N) {
            list.append("(");
            printBrackets(N, list,finalResult, open + 1, close);
            list.deleteCharAt(list.length()-1);
        }
        if (close < open) {
            list.append(")");
            printBrackets(N, list,finalResult, open, close + 1);
            list.deleteCharAt(list.length()-1);
        }
    }


	public static void main(String[] args) {
		List<String> finalResult = generateParenthesis(3);
		for(String n:finalResult) {
			System.out.print(n+" ");
		}

	}
}