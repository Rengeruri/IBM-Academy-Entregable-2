package com.ibm.academia.apirest.datos;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Direccion;
import com.ibm.academia.apirest.entities.Empleado;
import com.ibm.academia.apirest.entities.Pabellon;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.enums.Pizarron;
import com.ibm.academia.apirest.enums.TipoEmpleado;

public class DatosDummy 
{
	public static Carrera carrera01() 
	{
		return new Carrera(null, "Ingenieria en Sistemas", 50, 5); 
	}

	public static Carrera carrera02() 
	{
		return new Carrera(null, "Licenciatura en Sistemas", 45, 4);
	}

	public static Carrera carrera03() 
	{
		return new Carrera(null, "Ingenieria Industrial", 60, 5);
	}
	
	public static Carrera carrera04() 
	{
		return new Carrera(null, "Licenciatura arte", 10, 1);
	}
	
	public static Persona empleado01() 
	{
		return new Empleado(null, "Lautaro", "Lopez", "25174036", new Direccion(), 46750.70, TipoEmpleado.ADMINISTRATIVO);
	}

	public static Persona empleado02() 
	{
		return new Empleado(null, "Lenadro", "Lopez", "25174630", new Direccion(), 46750.70, TipoEmpleado.MANTENIMIENTO);
	}
	
	public static Persona profesor01() 
	{
		return new Profesor(null, "Martin", "Lugone", "33908461", new Direccion(), 60000.00);
	}
	
	public static Persona profesor02() 
	{
		return new Profesor(null, "Steve", "Jobs", "33908461", new Direccion(), 50000.00);
	}
	
	public static Persona alumno01() 
	{
		return new Alumno(null, "Jhon", "Benitez", "45233715", new Direccion());
	}

	public static Persona alumno02() 
	{
		return new Alumno(null, "Andres", "Benitez", "45233891", new Direccion());
	}

	public static Persona alumno03() 
	{
		return new Alumno(null, "Joaquin", "Leon", "45233012", new Direccion());
	}
	
	public static Pabellon pabellon01() 
	{
		return new Pabellon(null, 20.5, "Pabellon guapos", new Direccion());
	}
	
	public static Pabellon pabellon02() 
	{
		return new Pabellon(null, 25.5, "Pabellon feos", new Direccion());
	}
	
	public static Pabellon pabellon03() 
	{
		return new Pabellon(null, 5.5, "Pabellon sexy", new Direccion());
	}
	
	public static Aula aula01()
	{
		return new Aula(null, 1, "25x25", 30, Pizarron.PIZARRA_BLANCA);
	}
	
	public static Aula aula02()
	{
		return new Aula(null, 2, "50x50", 60, Pizarron.PIZARRA_TIZA);
	}
	
	public static Aula aula03()
	{
		return new Aula(null, 3, "53x53", 60, Pizarron.PIZARRA_TIZA);
	}
	
}