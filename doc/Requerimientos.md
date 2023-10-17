Integrantes:

Julian Motta A00400438

Lina Andrade A00380779


Requerimientos TI 2 :

Cliente: 	
Oficina de bienestar universitario
Usuario:
Estudiantes de la universidad Icesi
Bienestar universitario Icesi
Requerimientos funcionales:

RF1: Registrar usuario: El sistema debe permitir ingresar la información correspondiente a un estudiante.
RF2:  Editar usuario: El sistema debe permitir editar los datos de un usuario ya registrado.
RF3:  Eliminar registros: El sistema debe permitir la eliminación de un registro existente.
RF4: Generar reporte con la clasificación de los estudiantes: Según la clasificación dada por la OMS se deben categorizar a los estudiantes según su índice de masa corporal, una vez hecha la categorización, se generará el reporte con los datos obtenidos.
RF5: Generar reporte de cambios del estado nutricional:  Se debe generar un reporte con el listado de estudiantes cuya clasificación cambió entre septiembre de 2022 y abril de 2023.
RF6: Guardar la información: se debe exportar el estado actual del modelo usando un archivo JSON.

Contexto del problema:
La oficina de bienestar universitario está llevando a cabo un programa de promoción y prevención de enfermedades cardiovasculares en el campus. Por lo que, se requiere llevar un control del estado nutricional de los estudiantes de acuerdo con el IMC (índice de masa corporal, BMI en inglés). Motivo por el cual se necesita un programa que recopile la información de los estudiantes y con base en esto, genere los reportes con la clasificación de los estudiantes registrados.

Requerimientos no funcionales:
RNF1: El sistema debe proporcionar al usuario mensajes de error informativos para guiarlo, en caso de que se produzca algún error inesperado.
RNF2: Para garantizar la integridad de los datos, la aplicación debe contar con persistencia de datos mediante serialización JSON.


Especificación de los requerimientos:

Identificador y nombre:

RF1: Registrar usuario

Resumen	:

Con el fin de realizar un correcto seguimiento a cada estudiante, se debe obtener la información correspondiente de cada uno: nombre, apellido, código, edad, estatura, sexo, peso (kg), índice de masa corporal (BMI).

Para ello, se puede obtener la información de dos formas: cargar el archivo con la información correspondiente o agregar la información del estudiante al programa.

Entradas:
Nombre entrada	Tipo de dato	Condición valores válidos
userName	    String 	        Cadena de caracteres
lastName 	    String 	        Cadena de caracteres
studentCode	    String 	        Cadena de caracteres
age	            Int 	        Números enteros positivos
Height	        Double 	        Números positivos
Gender 	        String 	        Cadena de caracteres
WeightS	        Double 	        Números positivos
WeightA	        Double 	        Números positivos
IMCS            Double          Números positivos
IMCA            Double          Números positivos

Resultado o Postcondición:

Información del estudiante registrada en el sistema.

Salidas:
Nombre salida	Tipo de dato	Formato
msg	            String 	        Cadena de caracteres (indicando si el usuario fue registrado o no de manera exitosa).



Identificador y nombre:

RF2: Editar usuario
Resumen:
El sistema debe permitir editar la información de un estudiante ya registrado  
Entradas:
Nombre entrada	Tipo de dato	Condición valores válidos
userChanges	    String 	        Cadena de caracteres

Resultado o Postcondición:
Información del usuario actualizada.

Salidas:
Nombre salida	Tipo de dato	Formato
msg	            String	        Cadena de caracteres (Indicando si la información fue modificada con éxito).



Identificador y nombre:
RF3: Eliminar usuario

Resumen	:
El sistema debe permitir que se puedan eliminar registros ya existentes.

Entradas:

Nombre entrada	Tipo de dato	Condición valores válidos
student 	    Student 	    Objeto de la clase “Student”

Resultado o Postcondición:
Usuario eliminado

Salidas:
Nombre salida	Tipo de dato	Formato
msg	            String 	        Cadena de caracteres (Mensaje indicando que el usuario fue eliminado con éxito).




Identificador y nombre:
RF4: Generar reporte de clasificación
Resumen:

Según los datos obtenidos, se debe generar un reporte clasificando a los estudiantes según su IMC en las siguientes categorías: (peso bajo, normal, sobrepeso, obesidad, obesidad mórbida).

El reporte generado será mostrado mediante histogramas, con la cantidad de estudiantes por cada una de las categorías o en modo listado, mostrando todos los datos correspondientes a los estudiantes de cada categoria.

Para el modo listado, se mostrará ordenado según el IMC, además, el usuario tiene la opción de generar los listados ordenados por edad o en orden alfabético por apellido y nombre.

Entradas:

Nombre entrada	Tipo de dato	Condición valores válidos
N/A

Resultado o Postcondición:
Reporte generado

Salidas:

Nombre salida	     Tipo de dato	Formato
reportGenerated.txt  txt	        Archivo de texto




Identificador y nombre:
RF5:  Generar reporte de cambios del estado nutricional
Resumen:
Se generará un reporte de cambios del estado nutricional con el listado de estudiantes cuya clasificación cambió entre septiembre de 2022 y abril de 2023.
El reporte será mostrado en el modo de indicadores con las cantidades de estudiantes cuyo estado nutricional cambió o en modo listado.
El modo listado además del total muestra los datos completos de los estudiantes. Los datos serán presentados en orden según el IMC, con la opción de generar los listados ordenados por edad o en orden alfabético por apellido y nombre
Entradas:
Nombre entrada	Tipo de dato	Condición valores válidos
N/A		
Resultado o Postcondición:
Reporte de cambios del estado nutricional generado.
Salidas:
Nombre salida	    Tipo de dato	Formato
ReportCambios.txt	txt	            Texto sin formato





Identificador y nombre:

RF6:  Guardar la información
Resumen:
Se debe exportar el estado actual del modelo usando un archivo JSON

Entradas:
Nombre entrada	Tipo de dato	Condición valores válidos
N/A		
Resultado o Postcondición:
Reporte de cambios del estado nutricional generado.
Salidas:
Nombre salida	    Tipo de dato	Formato
information.json	Json	        Json file 
