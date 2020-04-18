package com.uca.capas.tareamvc.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@RequestMapping("/parametroAlumno")
	public @ResponseBody String alumno(HttpServletRequest request) {
		String nombre = request.getParameter("name");
		String apellido = request.getParameter("last");
		String carnet = request.getParameter("carnet");
		String carrera = request.getParameter("career");
		String anio = request.getParameter("year");
		
		String cadena = "Nombres: " + nombre + "<br>Apellidos: " + apellido + "<br>Carnet: " + carnet + "<br>Carrera: " + carrera + "<br>Año Cursado: " + anio;
		
		return cadena;
	}
	
	@RequestMapping("/parametroFecha")
	public @ResponseBody String fechas(HttpServletRequest request) {
		Calendar c = Calendar.getInstance();
		int diaParametro = Integer.parseInt(request.getParameter("dia"));
		int mesParametro = Integer.parseInt(request.getParameter("mes"));
		int anioParametro = Integer.parseInt(request.getParameter("anio"));
		c.set(anioParametro,(mesParametro-1),diaParametro);
		int diaN =  c.get(Calendar.DAY_OF_WEEK);
		String dia;
		switch (diaN) {
		case Calendar.SUNDAY: 
			dia = "Domingo";
			break;
		case Calendar.MONDAY: 
			dia = "Lunes";
			break;
		case Calendar.TUESDAY: 
			dia = "Martes";
			break;
		case Calendar.WEDNESDAY: 
			dia = "Miercoles";
			break;
		case Calendar.THURSDAY: 
			dia = "Jueves";
			break;
		case Calendar.FRIDAY: 
			dia = "Viernes";
			break;
		case Calendar.SATURDAY: 
			dia = "Sabado";
			break;
		default:
			dia = "Ningun dia seleccionado";
			break;
		}
		
		return "El dia de la semana en la fecha "+String.valueOf(diaParametro)+"/"+String.valueOf(mesParametro)+"/"+String.valueOf(anioParametro)+": " + dia;
	}
	
}
