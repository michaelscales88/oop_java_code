package numbers;
import java.util.Vector;
import java.util.Enumeration;

class Binary{

	private int k;
	private Vector<String> list;

	public Binary(){
		k = 1;
		list = new Vector<>(k * 10, 5);
	}

	public Binary(int newK){
		k = newK;
		list = new Vector<>(k * 10, 5);
	}

	public void calc(){
		int num = 0, max = getMax();
		boolean valid = true;
		String numString = "";

		while(num < max){
			numString = Integer.toString(num, 2);

			while(numString.length() < k)
				numString = "0" + numString;

			valid = true;
			if(k > 1)
				for(int x = 1; x < numString.length(); x++)
					if((numString.charAt(x-1) == '1') &&
						(numString.charAt(x) == '1'))
						valid = false;

			if(valid)
				list.addElement(numString);
			num++;
		}
	}

	public void show(){
		System.out.println("For k = " + k + ":");
		Enumeration eList = list.elements();

		while(eList.hasMoreElements()){
			System.out.print(eList.nextElement() + " ");
		}
		System.out.println("\n");
	}

	private int getMax(){
		int max = 0;
		for(int x = 0; x <= k; x++)
			max = (int)Math.pow(2, x);
		return max;
	}
}
