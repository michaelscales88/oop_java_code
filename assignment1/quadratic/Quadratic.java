package quadratic;
import java.util.Vector;

public class Quadratic
{
			// variables to hold terms a, b, c;
	private Double a, b, c;
	private Complex p, q;
	private Vector<String> results;

			// constructor class for Quadratic
	public Quadratic(Double[] abc){
		a = abc[0];
		b = abc[1];
		c = abc[2];
		results = new Vector<>();
	}

	public void calculate(){
				// discriminant, everything under the square root
		Double discriminant = (b * b) - (4 * a * c);
				// term1, -b / 2a
		Double term1 = (-b / (2 * a));
				// term2, sqrt(b^2 - 4ac)/2a
		Double term2 = Math.sqrt(Math.abs(discriminant)) / (2 * a);

				// two complex roots, p and q are of type Complex
		if( discriminant < 0.0 ){
				// assign complex p to term1 for real and term 2 for imag
			p = new Complex(term1, term2);
				// assign q as conjugate, reversing the sign of imag
			q = new Complex(p.conjugate());
		}
				// one root, q == NULL,
		else if( discriminant == 0.0 )
				// assign single root p to hold one real variable
			p = new Complex(term1);
				// two roots, p and q are type double
		else{
				// assign roots, complex type, of real variable only
			p = new Complex(term1 + term2);
			q = new Complex(term1 - term2);
		}
	}

	public void displayResults(){
		results.addElement("a: " + a + "\n");
		results.addElement("b: " + b + "\n");
		results.addElement("c: " + c + "\n");
		results.addElement("Root 1, p = " + p.showNum() + "\n");
		if( q != null )
			results.addElement("Root 2, q = " + q.showNum() + "\n");
	}

	public void verifyResults(){
		results.addElement("p + q = " + p.add(q).showNum() + "\n");
		results.addElement("- b / a = " + (-(b / a)) + "\n");
		results.addElement("p * q = " + p.multiply(q).showNum() + "\n");
		results.addElement("c / a = " + (c / a) + "\n");
	}

	public Vector<String> getResults(){
		return results;
	}
}
