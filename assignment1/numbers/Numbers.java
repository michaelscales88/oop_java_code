package numbers;
import java.util.Stack;
import java.util.Vector;

class Numbers{

	protected int n, max;
	protected Stack<Integer> list;

	public Numbers(){
		n = 1;
		list = new Stack<>();
	}

	public Numbers(int newN){
		n = newN;
		list = new Stack<>();
	}

	protected String leadZeros(String num){
		while(num.length() < n)
			num = "0" + num;
		return num;
	}

	protected void buildList(){
		while(max > 0)
			list.addElement(--max);
	}
}
