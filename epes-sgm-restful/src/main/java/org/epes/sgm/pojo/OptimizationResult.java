package org.epes.sgm.pojo;

public class OptimizationResult {

	String i1, i2, i3, o1, o2;

	public String getI1() {
		return i1;
	}

	public void setI1(String i1) {
		this.i1 = i1;
	}

	public String getI2() {
		return i2;
	}

	public void setI2(String i2) {
		this.i2 = i2;
	}

	public String getI3() {
		return i3;
	}

	public void setI3(String i3) {
		this.i3 = i3;
	}

	public String getO1() {
		return o1;
	}

	public void setO1(String o1) {
		this.o1 = o1;
	}

	public String getO2() {
		return o2;
	}

	public void setO2(String o2) {
		this.o2 = o2;
	}
	
	@Override
	public String toString() {
		return "Optimization Result [i1=" + i1 + ", " +
				"i2=" + i2 + ", i3=" + i3 + ", o1=" + o1 + ", o2=" + o2 + "]";
	}

}
