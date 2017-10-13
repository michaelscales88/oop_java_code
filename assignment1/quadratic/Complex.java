package quadratic;

public class Complex
{
	Double real;		// real part of complex number
	Double imag;		//imaginary part of complex number

	public Complex(){
		real = 0.0;
		imag = 0.0;
	}
	public Complex(Double newReal){
		real = newReal;
		imag = 0.0;
	}
	public Complex(Double newReal, Double newImag){
		real = newReal;
		imag = newImag;
	}
	public Complex(Complex newComplex){
		real = newComplex.real;
		imag = newComplex.imag;
	}

	public String showNum(){
		if( imag == 0.0 )
			return ("" + real);
		else{
			if( imag > 0 )
				return( "" + real + " + " + imag + "i");
			else
				return( "" + real + " - " + Math.abs(imag) + "i" );
		}
	}

		// Complex number operations
	public boolean equals(Complex op1, Complex op2){
		if( op1.real == op2.real && op1.imag == op2.imag)
			return true;
		return false;
	}
	public Complex add(Complex op){
		return new Complex(real + op.real, imag + op.imag);
	}
	public Complex multiply(Complex op){
		return new Complex((real * op.real) - (imag * op.imag),
		 						 (real * op.imag) + (op.real * imag));
	}
	public Complex conjugate(){
		return new Complex(real, -imag);
	}
}
