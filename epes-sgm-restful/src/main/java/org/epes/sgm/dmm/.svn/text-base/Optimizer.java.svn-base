package org.epes.sgm.dmm;

import org.epes.sgm.pojo.OptimizationResult;

public class Optimizer {

	public static OptimizationResult optimize(OptimizationResult result) {
		
		Integer o1 = Integer.parseInt(result.getO1());
		
		result.setI1(String.valueOf(o1*0.5));
		result.setI2(String.valueOf(o1));
		result.setI3(String.valueOf(o1*1.5));
		result.setO2(String.valueOf(o1*3));
		
		return result;		

	}

}
