package numbers;
import java.util.Stack;
import java.util.Vector;

class Increase extends Numbers{

	public Increase(){
		super();
		getMax();
		super.buildList();
	}

	public Increase(int newN){
		super(newN);
		getMax();
		super.buildList();
	}

	private void getMax(){
		max = (int) Math.pow(10, n);
	}

	private String getNumString(int num){
		return super.leadZeros(Integer.toString(num));
	}

	private boolean check(String numString){
		if(n > 1)
			for(int x = 1; x < numString.length(); x++){
				if(numString.charAt(x-1) >= numString.charAt(x))
					return false;
			}
		return true;
	}

	public Vector<String> getList(){
		//System.out.println("For n = " + n + ":");
		Vector<String> incList = new Vector<>();
		String num = "";
		while(!list.empty()){
			num = getNumString(list.pop());
			if(check(num))
				incList.addElement(num);
				//System.out.print(num + " ");
		}
		return incList;
		//System.out.println("\n");
	}
}
