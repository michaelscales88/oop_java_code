package numbers;
import java.util.Vector;
import java.util.Enumeration;

class Increase{

	private int n;
	private Vector<Integer> list;

	public Increase(){
		n = 1;
		list = new Vector<>(n * 10, 10);
	}

	public Increase(int newN){
		n = newN;
		list = new Vector<>(n * 10, 10);
	}

	public void calc(){
		int num = 0, max = (int) Math.pow(10, n);;
		boolean valid = true;
		String numString = "";

		while(num < max){
			numString = new Integer(num).toString();

			while(numString.length() < n)
				numString = "0" + numString;

			valid = true;
			if(n > 1)
				for(int x = 1; x < numString.length(); x++)
					if(numString.charAt(x-1) >= numString.charAt(x))
						valid = false;

			if(valid)
				list.addElement(num);
			num++;
		}
	}

	public void show(){
		System.out.println("For n = " + n + ":");
		Enumeration eList = list.elements();

		while(eList.hasMoreElements()){
			System.out.print(eList.nextElement() + " ");
		}
		System.out.println();
	}
}
