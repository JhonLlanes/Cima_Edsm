package com.edu.ec.Util;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ValidacionesUtil {

	public Date fechaactual() {
		
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		String cadenaFecha = formato.format(fechaActual);
		System.out.println(cadenaFecha);
		return fechaActual;
	}
}
