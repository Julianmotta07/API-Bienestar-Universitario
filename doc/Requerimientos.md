**ESPECIFICACIÓN DEL PROBLEMA**

|**Cliente**|Oficina de Bienestar Universitario Icesi|
| :-: | :- |
|**Usuario**|Usuario de Bienestar universitario Icesi|
|**Requerimientos funcionales**|<p>RF1: Registrar estudiante.</p><p></p><p>RF2: Editar estudiante.</p><p></p><p>RF3: Eliminar estudiante. </p><p></p><p>RF4: Generar reporte con la clasificación de los estudiantes. </p><p></p><p>RF5: Generar reporte de cambios del estado nutricional. </p><p></p><p>RF6: Importar datos de estudiantes.</p><p></p><p>RF6: Guardar la información.</p>|
|**Contexto del problema**|La oficina de bienestar universitario está llevando a cabo un programa de promoción y prevención de enfermedades cardiovasculares en el campus. Desea llevar un control del estado nutricional de los estudiantes de acuerdo con el IMC (índice de masa corporal, BMI en inglés). Por este motivo, necesita un programa que recopile la información de los estudiantes y con base a esta, genere los reportes con la clasificación de los estudiantes registrados.|
|**Requerimientos no funcionales**|RNF1: Para garantizar la integridad de los datos, la aplicación debe contar con persistencia de datos mediante serialización JSON.|

**TABLAS DE REQUERIMIENTOS**


<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF1 - Registrar estudiante</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3">Con el fin de realizar un correcto seguimiento a cada estudiante, el sistema debe permitir el registro de un estudiante con la información correspondiente de cada uno: código, nombre, apellido, edad, estatura, sexo, peso de septiembre de 2022 y el de abril de 2023.</td></tr>
<tr><td colspan="1" rowspan="9"><p></p><p><b>Entradas</b></p><p></p></td><td colspan="1"><b>Nombre de entrada</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Condición o valores válidos</b></td></tr>
<tr><td colspan="1">Código de estudiante</td><td colspan="1">String</td><td colspan="1">Código alfanumérico de 9 caracteres empezando con “A”</td></tr>
<tr><td colspan="1">Nombre</td><td colspan="1">String</td><td colspan="1">Cadena de caracteres</td></tr>
<tr><td colspan="1">Apellido</td><td colspan="1">String</td><td colspan="1">Cadena de caracteres</td></tr>
<tr><td colspan="1">Edad</td><td colspan="1">int</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1">Opción de sexo</td><td colspan="1">int</td><td colspan="1"><p>Debe ser 1 o 2:</p><p>- 1: M</p><p>- 2: F</p></td></tr>
<tr><td colspan="1">Altura</td><td colspan="1">double</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1">Peso de septiembre</td><td colspan="1">double</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1">Peso de abril</td><td colspan="1">double</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Información del estudiante registrada en el sistema.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Estudiante registrado exitosamente”</td></tr>
</table>



<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF2 - Editar estudiante</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3">El sistema debe permitir editar la información de un estudiante ya registrado.</td></tr>
<tr><td colspan="1" rowspan="10"><p></p><p><b>Entradas</b></p><p></p></td><td colspan="1"><b>Nombre de entrada</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Condición o valores válidos</b></td></tr>
<tr><td colspan="1">Código de estudiante</td><td colspan="1">String</td><td colspan="1">Código alfanumérico de 9 caracteres empezando con “A”</td></tr>
<tr><td colspan="1">Items a cambiar</td><td colspan="1">String</td><td colspan="1">Letras asignadas a los items separadas por espacios</td></tr>
<tr><td colspan="1">Nombre</td><td colspan="1">String</td><td colspan="1">Cadena de caracteres</td></tr>
<tr><td colspan="1">Apellido</td><td colspan="1">String</td><td colspan="1">Cadena de caracteres</td></tr>
<tr><td colspan="1">Edad</td><td colspan="1">int</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1">Opción de sexo</td><td colspan="1">int</td><td colspan="1"><p>Debe ser 1 o 2:</p><p>- 1: M</p><p>- 2: F</p></td></tr>
<tr><td colspan="1">Altura</td><td colspan="1">double</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1">Peso de septiembre</td><td colspan="1">double</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1">Peso de abril</td><td colspan="1">double</td><td colspan="1">Enteros positivos</td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Información del estudiante actualizada.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Información del estudiante actualizada exitosamente”</td></tr>
</table>



<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF3 - Eliminar estudiante</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3">El sistema debe permitir que se puedan eliminar registros de estudiantes ya existentes.</td></tr>
<tr><td colspan="1" rowspan="2"><p></p><p><b>Entradas</b></p><p></p></td><td colspan="1"><b>Nombre de entrada</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Condición o valores válidos</b></td></tr>
<tr><td colspan="1">Código de estudiante</td><td colspan="1">String</td><td colspan="1">Código alfanumérico de 9 caracteres empezando con “A”</td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Estudiante eliminado del sistema.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Estudiante eliminado exitosamente”</td></tr>
</table>




<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF4 - Generar reporte de clasificación</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3"><p>Según los datos obtenidos, el sistema debe permitir generar un reporte clasificando a los estudiantes según su IMC en las siguientes categorías: peso bajo, normal, sobrepeso, obesidad yobesidad mórbida.</p><p></p><p>El usuario podra elegir si quiere que el reporte sea mostrado mediante histogramas, con la cantidad de estudiantes por cada una de las categorías o en modo listado, mostrando todos los datos correspondientes a los estudiantes de cada categoria.</p><p></p><p>Para el modo listado, se mostrará ordenado según el IMC aunque el usuario tendrá la opción de generar los listados ordenados por edad o en orden alfabético (apellido – nombre).</p></td></tr>
<tr><td colspan="1" rowspan="3"><p></p><p><b>Entradas</b></p><p></p></td><td colspan="1"><b>Nombre de entrada</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Condición o valores válidos</b></td></tr>
<tr><td colspan="1">Modo </td><td colspan="1">int</td><td colspan="1"><p>Debe ser 1 o 2:</p><p>- 1: Histograma</p><p>- 2: Listado</p><p></p></td></tr>
<tr><td colspan="1">Filtro</td><td colspan="1">int</td><td colspan="1"><p>Debe ser 1, 2 o 3:</p><p>- 1: IMC</p><p>- 2: Edad</p><p>- 3: Apellido</p><p></p></td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Generación de un archivo txt con la información del reporte de clasificación.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Reporte generado”</td></tr>
</table>



<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF5 - Generar reporte de cambios del estado nutricional</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3"><p>El sistema debe permitir generar un reporte de cambios del estado nutricional con el listado de estudiantes cuya clasificación cambió entre septiembre de 2022 y abril de 2023.</p><p></p><p>El usuario podrá seleccionar si el reporte será mostrado en modo indicadores con las cantidades de estudiantes cuyo estado nutricional cambió o en modo listado. </p><p></p><p>El modo listado, además del total, muestra los datos completos de los estudiantes. Los datos serán presentados en orden según el IMC, aunque el usuario también tendrá la opción de generar los listados ordenados por edad o en orden alfabético (apellido – nombre)</p></td></tr>
<tr><td colspan="1" rowspan="3"><p></p><p><b>Entradas</b></p><p></p></td><td colspan="1"><b>Nombre de entrada</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Condición o valores válidos</b></td></tr>
<tr><td colspan="1">Modo </td><td colspan="1">int</td><td colspan="1"><p>Debe ser 1 o 2:</p><p>- 1: Indicadores</p><p>- 2: Listado</p><p></p></td></tr>
<tr><td colspan="1">Filtro</td><td colspan="1">int</td><td colspan="1"><p>Debe ser 1, 2 o 3:</p><p>- 1: IMC</p><p>- 2: Edad</p><p>- 3: Apellido</p><p></p></td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Generación de un archivo txt con la información del reporte de cambios de estado nutricional.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Reporte generado”</td></tr>
</table>



<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF6 - Importar datos de estudiantes</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3">El sistema debe permitir la importación de registros de estudiantes de un archivo csv desde una ruta predefinida.</td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Importación de los registros de estudiantes al sistema.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Datos del csv importados”</td></tr>
</table>



<table><tr><th colspan="1"><b>Identificador</b></th><th colspan="3"><b>RF7 - Guardar información</b></th></tr>
<tr><td colspan="1"><b>Resumen</b></td><td colspan="3">El sistema debe permitir exportar el estado actual del modelo en un archivo JSON hacia una ruta predefinida.</td></tr>
<tr><td colspan="1"><b>Resultado o postcondición</b></td><td colspan="3">Estado actual del modelo exportado a un archivo JSON.</td></tr>
<tr><td colspan="1" rowspan="2"><b>Salidas</b></td><td colspan="1"><b>Nombre de salida</b></td><td colspan="1"><b>Tipo de dato</b></td><td colspan="1"><b>Formato</b></td></tr>
<tr><td colspan="1">Mensaje de confirmación</td><td colspan="1">String</td><td colspan="1">“Estado actual del modelo guardado exitosamente”</td></tr>
</table>
