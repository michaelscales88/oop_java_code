package numbers;
import java.util.Vector;
//import java.util.Enumeration;

class Binary extends Numbers{

	public Binary(){
		super();
		getMax();
		super.buildList();
	}

	public Binary(int newK){
		super(newK);
		getMax();
		super.buildList();
	}

	private void getMax(){
		max = 0;
		for(int x = 0; x < n; x++)
			max += (int) Math.pow(2, x);
	}

	private String getNumString(int num){
		return super.leadZeros(Integer.toString(num, 2));
	}

	private boolean check(String num){
		if(n > 1)
			for(int x = 1; x < num.length(); x++)
				if((num.charAt(x-1) == '1') &&
					(num.charAt(x) == '1'))
					return false;
		return true;
	}

	public Vector<String> getList(){
		//System.out.println("For k = " + n + ":");
		Vector<String> binList = new Vector<>();
		String num = "";
		while(!list.empty()){
			num = getNumString(list.pop());
			if(check(num))
				binList.addElement(num);
				//System.out.print(num + " ");
		}
		return binList;
		//System.out.println("\n");
	}
}
