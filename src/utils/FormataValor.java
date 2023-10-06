package utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormataValor {
	
	static NumberFormat formataValor = new DecimalFormat("R$ #,##0.00");
	
	public static String DoubleToString(double valor) {
		return formataValor.format(valor);
	}

}
