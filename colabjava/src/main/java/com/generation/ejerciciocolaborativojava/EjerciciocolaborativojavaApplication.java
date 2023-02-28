package com.generation.ejerciciocolaborativojava;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;



@SpringBootApplication
public class EjerciciocolaborativojavaApplication {
/*Ejercicio
vamos a pedir al usuario que ingrese la cantidad alumnos a los cuales les asignará 
una nota, luego de que ingrese la catidad de notas de cada alumnos, se va a 
desplegar un menú.
las opciones del menú serán la siguentes:
1.- mostrar el promedio de notas
2.- mostrar si la nota es aprobatoria o reprobatoria
3.- mostrar si la nota está por sobre o por debajo del promedio del curso


//Entrada
Cantidad de alumnos 
Nombre de alumnos
Cantidad de notas
Notas por alumno 

//Procesamiento 
- Definir la nota aprobatoria.
- Calcular el promedio por alumnos y general .
- Verificar si el promedio de alumnos esta por sobre o por
	debajo del promedio general.
- Verificar si la nota aprueba o reprueba.
- Hacer el manú con solo 3 opciones con cero finalizando el
	menú. 
- Hacer validaciones sobre las notas y la cantidad de 
	alumnos. 
- Verificar que el promedio se calcule previamente antes de 
	las operaciones que lo requieren.



//Salida
- Promedio de notas por alumno.
- La nota aprueba o reprueba.
- 

*/

/*funcion para sacar el promedio */
public static Double promedioNotas(ArrayList<Double> notas){  //función que entrega un double como salida. 
	Double suma = 0.0;
	for (int i = 0; i < notas.size(); i++) {  //i menor a cantidad de notas.
		//suma = suma + notas.get(i) -> es lo mismo :D.
		suma += notas.get(i);
	}
	return suma/notas.size();  //la suma de la notas dividido en la cantidad de notas.
}
/*funcion que verifica si el promedio del alumno está aprobado o reprobado */

public static Boolean aprobado(ArrayList<Double> notas, Double notaAprobatoria){ //función que netrega como resultado un booelano.
	Double promedio = promedioNotas(notas); //se define promedio como un double, y es igual a = se hace llamado a la función promedioNotas
	if(promedio >= notaAprobatoria){           //y se le entrega el arrayList notas.
		return true;
	}else{
		return false;     //Retorna True or False.
	}
}

/*funcion que verifica si el promedio del alumno es mayor al promedio general */
public static void sobrePromedio(Double promedioGeneral, ArrayList<Double> notas, String nombreAlum){  //Se le entrega un double, un arrayList de double llamado notas
	Double promedioAlumno = promedioNotas(notas);	//Se llama a la función promedioNotas y se le entrega el arrayList. 							// y un string. 
	if(promedioAlumno>promedioGeneral){
		System.out.println("El alumno "+nombreAlum+" está sobre el promedio");
	}else if(promedioAlumno == promedioGeneral){
		System.out.println("El alumno "+nombreAlum+" es igual al promedio general");
	}else{
		System.out.println("El alumno "+nombreAlum+" está bajo el promedio");
	}
}




	public static void main(String[] args) {

	
		Scanner teclado = new Scanner(System.in);
		String nomAlum = "";
		Double notaAprobatoria = 4.0;
		HashMap <String, ArrayList<Double>> libroClase = new HashMap<String, ArrayList<Double>>();  //Se abre un hashMap de String y arrayList de double
		// llamado libroClase, para abrirlo es con new HashMap y se le indica que lo primero serán Strings y lo segundo un ArrayList de double.

		int cantAlum; //Se definen que estas variables serán Int. 
		int cantNotas;
		do{    //Se hace este do While para que el número de alumnos sea correcto.
			System.out.print("Indique la cantidad de alumnos que va a ingresar: ");
			cantAlum = teclado.nextInt();
			if(cantAlum <= 0){
				System.out.print("La cantidad de alumnos debe ser mayor a cero, porfavor intente denuevo");
			}

		}while(cantAlum <= 0);

		do{   //Se hace este do while para que sea correcta la cantidad de notas por alumno. 
			System.out.print("Indique la cantidad de notas por alumnos: ");
			cantNotas = teclado.nextInt();
			if(cantNotas <= 0){
				System.out.print("La cantidad de notas debe ser mayor a cero, por favor entente mas tarde");
			}
		}while(cantNotas <= 0);

		for(int i = 1; i <= cantAlum; i++){
			teclado.nextLine();
			ArrayList <Double> notasAlumnos = new ArrayList<Double>();
			System.out.print("Ingresa nombre del alumno: ");
			nomAlum = teclado.nextLine();
			for(int x = 1; x <= cantNotas; x++){
				System.out.print("Ingresa nota " +x+ " del alumno "+ nomAlum +": ");
				Double nota = teclado.nextDouble();
				notasAlumnos.add(nota);
			}
			libroClase.put(nomAlum, notasAlumnos); //Se agrega al HashMap el nombre del alumno recíen ingresado y las notas que se agregan en el for. 
			//desafio, verificar donde deberia o como deberia limpíar el arreglo para que funcione
			//con la declaración de manera global
			//notasAlumnos.clear();
		}

		int opcion = 1; 

		while(opcion != 0){

			do{
				System.out.println("**************Comienzo de Menú***************");
				System.out.println("Bienvenido/a");
				System.out.println("Seleccione 1 si quiere obtener el promedio de las notas por alumno.");
				System.out.println("Seleccione 2 si quiere ver si el alumno aprueba o reprueba");
				System.out.println("Seleccione 3 para ver si la nota está sobre o por debajo del promedio general");
				System.out.println("Seleccione 0 para salir del menú");
				System.out.print("Seleccione su opción: ");
				opcion = teclado.nextInt();
				
			}while(opcion < 0 || opcion > 3);

			if(opcion == 1){
				for(String i : libroClase.keySet()){
					//cada vez que ocupemos un for opara hashmap
					//el valor de la llave (en este caso el array)
					//está contenido dentro de la sintaxis nomHasmap.get(i)
					Double promAlum = promedioNotas(libroClase.get(i));
					System.out.println("El promedio del alumno: "+ i +" es de: " + promAlum);
				}
			}else if (opcion == 2){
				for(String i : libroClase.keySet()){
					Boolean aprobar = aprobado(libroClase.get(i), notaAprobatoria);
					//es lo mismo que poner if (aprobar == true)
					if(aprobar){
						System.out.println("El alumno/a "+i+" está aprobado");
					}else{
						System.out.println("El alumno/a "+i+" está reprobado");
					}
					
				}
			}else if (opcion == 3){
				Double sumaPromedio = 0.0;
				for (String i : libroClase.keySet()){
					sumaPromedio = sumaPromedio + promedioNotas(libroClase.get(i));
				}
				Double promedioGeneral = sumaPromedio / cantAlum;
				for (String i : libroClase.keySet()){   //Se puede volver a ocupar i porque esta fuera del for anterior.
					sobrePromedio(promedioGeneral, libroClase.get(i), i);  //en i se está guardando los nombres de las keys.
				}
			
			}else{
				System.out.println("Gracias por cerrar el menú, hasta pronto :D");
			}
		}

		




	}

}
