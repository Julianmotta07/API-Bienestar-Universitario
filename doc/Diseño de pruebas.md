CONFIGURACIÓN DE LOS ESCENARIOS

|**Nombre**|**Clase**|**Escenario**|
| :- | :- | :- |
|**setUpStage1**|**BienestarController** |Una lista que contiene los datos de un archivo CSV  con 34 objetos de tipo "Student” con los parámetros correspondientes.|
|**setUpStage2**|**BienestarController** |<p>Una lista que contiene los datos de un archivo CSV  con 34 objetos de tipo "student" con los parámetros correspondientes y cinco estudiantes agregados de manera "manual":</p><p></p><p>1. Un objeto de la clase Student con : studentCode = "A00369076",name = “Juan”, lastName = "Tobar", age = 23, sex = 'M', weightS = 80, weightA = 78, height = 1.83.</p><p>2. Un objeto de la clase Student con : studentCode = "A00370234", name = “Juliana”, lastName = "Parra", age = 22, sex = 'F',weightS = 55,weightS = 50,height = 1.60</p><p>3. Un objeto de la clase Student con : studentCode = "A00356473", name = “Jose”, lastName = "Perez", age = 24,  sex = 'M', weightS = 50, weightA = 57, height = 1.70</p><p>4. Un objeto de la clase Student con : studentCode = "A00380345", name = “Pablo”, lastName = "Blandon",age = 20, sex = 'M', weightS = 75, weightA = 73,height = 1.71</p><p>5. Un objeto de la clase Student con : studentCode = "A00370768",name = “Ana”, lastName = "Gomez", age = 21,sex = 'F', weightS =65 , weightA = 66, height = 1,70</p>|
|**setUpStage3**|**BienestarController**  |<p>Una lista de 5 estudiantes :</p><p></p><p>1. Un objeto de la clase Student con : studentCode = "A00408965", name = “Martina”, lastName = "Perez", age = 18, sex = 'F', weightS = 60, weightA = 66, height = 1.64      </p><p></p><p>2. Un objeto de la clase Student con : studentCode = "A00387964", name = “Yeison”, lastName ="Rodriguez", age = 20, sex = 'M', weightS = 74, weightA = 74, height = 1.70</p><p></p><p>3. Un objeto de la clase Student con : studentCode = "A00397065" , name = “Camilo”, lastName = "Barona", age = 19, sex = 'M', weightS = 72, weightA = 70, height = 1.82</p><p></p><p>4. Un objeto de la clase Student con : studentCode = "A00345231" , name = “Pedro”, lastName = "Aguirre", age = 24, sex = 'M', weightS = 76, weightA = 76, height = 1.78</p><p></p><p>5. Un objeto de la clase Student con : studentCode = "A00386954" , name = “Cristina”, lastName = "Mendoza", age = 21, sex = 'F', weightS = 65, weightA = 66, height = 1.62</p>|
|**setUpStage4**|**BienestarController**  |<p>Una lista de 2 estudiantes:     </p><p></p><p>1. Un objeto de la clase Student con : studentCode = "A00154324" , name = “Ronny”, lastName = "Rios", age = 20, sex = 'M', weightS = 78, weightA = 78, height = 1.80</p><p></p><p>2. Un objeto de la clase Student con:  studentCode = "A00986756" , name = “Valeria”, lastName = "Espinosa", age = 23, sex = 'F', weightS = 76, weightA = 75, height = 1.65**   </p><p></p>|
|**SetUpStage1**|**DataWriter**|Se crea una instancia de la clase "DataWriter"|


DISEÑO CASOS DE PRUEBA

**1. Objetivo de la prueba:** La prueba realiza una simulación de lo que debe suceder cuando el usuario requiera el reporte. Se crea un archivo con contenido cualquiera y luego se lo convierte a un txt. Finalmente, el archivo creado se elimina, evitando tener múltiples archivos de prueba dentro del programa.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|**DataWriter**|**testBytesToTxTReport**|**setUpStage1**||<p>Report generated</p><p></p>|


**2. Objetivo de la prueba:**  Verificar que los archivos del csv han sido cargados y añadidos de manera exitosa.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p><p>**BienestarController**</p><p></p><p></p><p></p><p>**BienestarController**</p><p></p><p>**BienestarController**</p><p></p>|<p>**testAddStudentsFromCSV**</p><p>**testAddStudentsFromCSV**</p><p>**testAddStudentsFromCSV**</p><p>**testAddStudentsFromCSV**</p>|<p>**setUpStage1**</p><p>**setUpStage1**</p><p></p><p>**setUpStage1**</p><p>**setUpStage1**</p>|<p>**getStudents.size()**</p><p>**getStudents.get(0).getName** </p><p></p><p>**getStudents.get(33).getName** </p><p>**getStudents.get(23).getName**  </p>|<p></p><p>34</p><p></p><p></p><p>“Maria”</p><p></p><p></p><p>“Karen”</p><p></p><p></p><p>“Juan Jose”</p><p></p>|

**3. Objetivo de la prueba:** Validar que el método que agrega a los estudiantes de manera manual, funcione correctamente. A medida que se agreguen usuarios incrementará el tamaño del arrayList. Sin embargo, si el usuario agrega un usuario ya existente, este no será agregado y se le notificará al usuario la razón por la cual no pudo ser agregado.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p><p></p><p></p><p></p><p></p><p></p><p>**BienestarController**</p>|<p>**testAddStudents**</p><p></p><p></p><p>**testAddStudents**</p>|<p>**setUpStage1**</p><p></p><p></p><p>**setUpStage1**</p>|<p>**Student = "A00350678","Alejandro","Arteaga",23,'M',60,62,1.78**</p><p></p><p>**Student = "A00350678","Alejandro","Arteaga",23,'M',60,62,1.78**</p>|<p>The size must change in + 1</p><p>The user was successfully inserted into the system</p><p> </p><p>The second input value must not be register and size should not be updated                                                                                                           </p><p></p><p></p>|

**4. Objetivo de la prueba:** Las excepciones se capturan en “Main”. Sin embargo,  la prueba está hecha para verificar que cada una de las excepciones en caso de requerirse. Es decir, el programa no acepta valores negativos para parámetros como la edad, el peso…

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p></p><p>**BienestarController**</p><p></p><p></p><p></p><p>**BienestarController**</p><p></p><p></p><p></p><p>**BienestarController**</p><p></p><p></p><p></p><p>**BienestarController**</p><p></p>|<p>**testExceptions** </p><p></p><p>**testExceptions**</p><p></p><p>**testExceptions** </p><p></p><p>**testExceptions**</p>|<p>**setUpStage1**</p><p></p><p>**setUpStage1**</p><p></p><p>**setUpStage1**</p><p></p><p>**setUpStage1**</p>|<p>**age = -3**</p><p></p><p></p><p>**height =  -1.70**</p><p></p><p>**weightS = -52**</p><p></p><p></p><p>**studentCode = "B00345674"**</p>|<p>"Invalid age range."                                                                                             </p><p></p><p></p><p>“Invalid height range.”</p><p></p><p>“Invalid weight range.”</p><p></p><p></p><p>“The code must begin with A”</p>|

**5. Objetivo de la prueba:**  Verificar que el método edit Students actualiza de manera correcta la información de los estudiantes, según los parámetros a modificar.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p></p><p>**BienestarController**</p><p></p>|**testEditStudent**|**setUpStage2**|**Student = "A00369076", "Juan", "Toledo", 23, 'M', 80, 78, 1.87**|<p>"Student information successfully edited”   </p><p>                                         </p><p></p>|


**6. Objetivo de la prueba:** Verificar que el método editStudent2 funcione correctamente al editar la información de varios estudiantes con diferentes datos de entrada.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testEditStudent2**|**setUpStage2**|<p>**names: {"Mara","Yeison", "Cristian", "Pedro", "Cristina"}**</p><p>**last Names: {"Guerrero","Rodriguez", "Barrera", "Aguirre", "Mendoza"}**</p><p>**ages: {23,25, 19, 24, 28}**</p><p>**sex: {'F','O', 'M', 'M', 'F'}**</p><p>**sep. Weights: {60,72, 72, 78, 65}**</p><p>**apr. Weights: {66, 70, 75, 76, 65}**</p><p>**heights: {1.74,1.71, 1.82, 1.78, 1.64}**</p>|<p>*Student 0:*</p><p>Code: A00408965</p><p>Name: Martina Perez</p><p>Age: 18</p><p>Sex: F</p><p>Height: 1.64</p><p>Sep. Weight: 60.0</p><p>Apr. weight: 66.0</p><p>Sep. BMI: 22.31</p><p>Apr. BMI: 24.54 </p><p>*Student 1:*</p><p>Code: A00387964</p><p>Name: Yeison Rodriguez</p><p>Age: 25</p><p>Sex: O</p><p>Height: 1.71</p><p>Sep. Weight: 72.0</p><p>Apr. weight: 70.0</p><p>Sep. BMI: 24.62</p><p>Apr. BMI: 23.94</p><p>*Student 2:*</p><p>Sep. BMI: 21.74</p><p>*Student 3:*</p><p>Sep. Weight: 76</p><p>*Student 4:*</p><p>Apr. Weight: 66                   </p>|


**7. Objetivo de la prueba:** Verificar que el método “deleteStudents” elimina correctamente a los usuarios deseados. El estudiante debe existir en el sistema, en caso de no existir, el método le informará al usuario que el estudiante asociado a ese id no existe, por lo cual, no puede ser eliminado.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p></p><p>**BienestarController**</p><p></p><p></p><p></p><p></p><p></p><p>**BienestarController**</p><p></p>|<p>**testdeleteStudent**</p><p></p><p></p><p></p><p>**testdeleteStudent**</p>|<p>**setUpStage2**</p><p></p><p></p><p>**setUpStage2**</p>|<p>**studentCode = "A00370234"**</p><p></p><p></p><p>**studentCode = "A00370234"**     </p>|<p>The size must change the change in -1</p><p>User is no longer registered in the system</p><p></p><p>for the second input value: A student with the entered ID does not exist</p>|


**8. Objetivo de la prueba:** Se eliminan los elementos presentes en el sistema, validando que al hacerlo el tamaño es cero.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p></p><p>**BienestarController**</p><p></p><p></p><p></p><p></p><p></p><p>**BienestarController**</p>|<p>**testdeleteStudent2**</p><p></p><p>**testdeleteStudent2**</p>|<p>**setUpStage4**</p><p></p><p></p><p>**setUpStage4**</p>|<p>**studentCode = "A00154324"** </p><p></p><p>**studentCode = "A00986756"**      </p>|<p>The size is equal to zero</p><p>User is no longer registered in the system</p><p></p><p>User is no longer registered in the system </p>|                                                         


**9. Objetivo de la prueba:** Se validará que los usuarios se agrupen según la categoría que corresponda:</p><p>- 0 = Peso bajo</p><p>- 1 = Peso normal</p><p>- 2 = Sobrepeso</p><p>- 3 = Obesidad</p><p>- 4 = Obesidad mórbida.


|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testgetBmiCategory**|**setUpStage1**|**the first five elements of the csv**    |<p>Estudiante 1: Maria - Categoría BMI Abril: 2</p><p>Estudiante 2: Maria Carmen - Categoría BMI Abril: 1</p><p>Estudiante 3: Carmen - Categoría BMI Abril: 2</p><p>Estudiante 4: Josefa - Categoría BMI Abril: 2</p><p>Estudiante 5: Ana Maria - Categoría BMI Abril: 1</p>|



**10. Objetivo de la prueba:** los estudiantes serán agrupados en categorías según su BMI, al final se mostrará el histograma correspondiente a la cantidad de estudiantes por categoría. En caso de que ningún estudiante pertenezca a la categoría, esta se mostrará vacía.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testGenerateHistogram**|**setUpStage1**|**the first five elements of the csv**    |<p>lowWeightH</p><p>+   normalWeightH</p><p>++  overweightH</p><p>++ obesityH</p><p>morbidObesityH </p>|



**11. Objetivo de la prueba:** El usuario podrá escoger el orden en que quiere ver sus informes, por lo cual, se valida que el método encargado de reordenar los estudiantes según el requerimiento del usuario, funcione correctamente (en este caso por edad, de menor a mayor).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testSelectionSortByAge**|**setUpStage3**|**Arraylist of the Students**      |<p>Martina - Edad : 18</p><p>Camilo - Edad : 19</p><p>Yeison - Edad : 20</p><p>Cristina - Edad : 21</p><p>Pedro - Edad :24</p>|

**12. Objetivo de la prueba:** El usuario tendrá la opción de escoger el orden en que quiere ver sus informes, por lo cual, se valida que el método encargado de reordenar los estudiantes según el requerimiento del usuario, funcione correctamente (en este caso por apellido, orden lexicográfico).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testSelectionSortLastname**|**setUpStage3**|**Arraylist of the Students**|<p>Pedro Aguirre</p><p>Camilo Barona</p><p>Cristina Mendoza</p><p>Martina Perez</p><p>Yeison Rodriguez</p><p></p>|


**13. Objetivo de la prueba:**  El usuario podrá escoger el orden en que quiere ver sus informes, por lo cual, se valida que el método encargado de reordenar los estudiantes según el requerimiento del usuario, funcione correctamente (en este caso por el bmi calculado en el mes de septiembre).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testSelectionSortByBMISep**|**setUpStage3**|**Arraylist of the Students**      |<p>Camilo Barona - BMI : 21.74</p><p>Martina Perez - BMI : 22.31</p><p>Pedro Aguirre - BMI : 23.99</p><p>Cristina Mendoza - BMI : 24.77</p><p>Yeison Rodriguez - BMI : 25.61</p>|

**14. Objetivo de la prueba:** El usuario podrá escoger el orden en que quiere ver sus informes, por lo cual, se valida que el método encargado de reordenar los estudiantes según el requerimiento del usuario, funcione correctamente (en este caso por el bmi calculado en el mes de abril).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testSelectionSortByBMIApr**|**setUpStage3**|**Arraylist of the Students**      |<p>Camilo Barona - BMI : 21.13</p><p>Pedro Aguirre - BMI : 23.99</p><p>Martina Perez - BMI : 24.54</p><p>Cristina Mendoza - BMI : 25.15</p><p>Yeison Rodriguez - BMI : 25.61                                                  </p>|


**15. Objetivo de la prueba:** Según una cantidad dada de estudiantes, es necesario validar quienes tuvieron un cambio significativo, bien sea bueno o malo, para ello se comparan  el bmi de septiembre como el bmi de abril y se indican quienes tuvieron un cambio significativo y la categoría a la que pertenecen ahora.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testnutriotionalReportIndicators**|**setUpStage1**|**the first five elements of the csv**|<p>3 students had a change in their nutritional status.</p><p>3 students presented a favorable change in their health, distributed as follows:</p><p>0 changed from low weight to normal weight.</p><p>1 changed from overweight to normal weight.</p><p>2 changed from obesity to overweight or normal weight.</p><p>0 changed from morbid weight to overweight or normal weight.</p><p>0 students presented an unfavorable change in their health, distributed as follows:</p><p></p><p>0 changed from normal weight to low weight.</p><p>0 changed from normal weight to overweight or obesity.</p><p>0 changed from overweight to obesity or morbid obesity.</p><p>0 changed from obesity to morbid obesity.</p>|

**16. Objetivo de la prueba:** Según una cantidad dada de estudiantes, se muestra la información de cada estudiante que tuvo un cambio de estado, es decir, cambio de categoría en el intervalo de tiempo seleccionado (septiembre 2022 - abril 2023 ). El usuario podrá elegir el orden en que quiere que se muestre la información de los estudiantes. En este caso, el reporte de cambios en modo listado será ordenado según el BMI (de menor a mayor).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p></p><p>**BienestarController**</p><p></p>|**testnutriotionalReportListByBMI**|**setUpStage3**|**Arraylist of the Students**      |<p>Students sorted by BMI (april):</p><p>- Code: A00386954</p><p>Name: Cristina Mendoza</p><p>Age: 21</p><p>Sex: F</p><p>Height: 1.62</p><p>Sep. Weight: 65.0</p><p>Apr. weight: 66.0</p><p>Sep. BMI: 24.77</p><p>Apr. BMI: 25.15</p><p>A total of 1 student had change in their nutritional status. </p>|


**17. Objetivo de la prueba:** Dado el caso en que ningún estudiante presente cambios significativos, es decir, todos los estudiantes se mantuvieron en su categoría, se espera que ninguno sea presentado en el reporte.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|**testnutriotionalReportListByBMIUnchanged**|**setUpStage4**|**Arraylist of the Students**|<p>Students sorted by BMI (april):</p><p>A total of 0 students had changed in their nutritional status.</p>|


**18. Objetivo de la prueba:** Según una cantidad dada de estudiantes, se muestra la información de cada estudiante que tuvo un cambio de estado, es decir, cambio de categoría en el intervalo de tiempo seleccionado (septiembre 2022 - abril 2023 ). El usuario podrá elegir el orden en que quiere que se muestre la información de los estudiantes. En este caso, el reporte de cambios en modo listado será ordenado por edad (de menor a mayor).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|<p>**testnutriotionalReportListByAge**<p>|<p>**setUpStage2**<p>|<p>Arraylist of the Students<p>|<p>Students sorted by age:</p><p>- Code: A00380779</p><p>Name: Maria Carmen Hernandez</p><p>Age: 19</p><p>Sex: F</p><p>Height: 1.62</p><p>Sep. Weight: 72.0</p><p>Apr. weight: 59.0</p><p>Sep. BMI: 27.43</p><p>Apr. BMI: 22.48</p><p>- Code: A00380776</p><p>Name: Maria Garcia</p><p>Age: 20</p><p>Sex: F</p><p>Height: 1.72</p><p>Sep. Weight: 97.0</p><p>Apr. weight: 86.0</p><p>Sep. BMI: 32.79</p><p>Apr. BMI: 29.07</p><p>- Code: A00370864</p><p>Name: Jose Antonio Munoz</p><p>Age: 20</p><p>Sex: O</p><p>Height: 1.69</p><p>Sep. Weight: 53.0</p><p>Apr. weight: 52.0</p><p>Sep. BMI: 18.56</p><p>Apr. BMI: 18.21</p><p>- Code: A00380345</p><p>Name: Pablo Blandon</p><p>Age: 20</p><p>Sex: M</p><p>Height: 1.71</p<p>Sep. Weight: 75.0</p><p>Apr. weight: 73.0</p><p>Sep. BMI: 25.65</p><p>Apr. BMI: 24.96</p><p>- Code: A00370987</p><p>Name: Josefa Lopez</p><p>Age: 21</p><p>Sex:F</p><p>Height: 1.74</p><p>Sep. Weight: 93.0</p><p>Apr. weight: 88.0</p><p>Sep. BMI: 30.72</p><p>Apr. BMI: 29.07</p><p>- Code: A00347601</p><p>Name: Cristina Moreno</p><p>Age: 24</p><p>Sex: F</p><p>Height: 1.66</p><p>Sep. Weight: 68.0</p><p>Apr. weight: 69.0</p><p>Sep. BMI: 24.68</p><p>Apr. BMI: 25.04</p><p>- Code: A00356473</p><p>Name: Jose Perez</p><p>Age: 24</p><p>Sex: M</p><p>Height: 1.70</p><p>Sep. Weight: 50.0</p><p>Apr. weight: 57.0</p><p>Sep. BMI: 17.3</p><p>Apr. BMI: 19.72</p><p>A total of 7 students had changed in their nutritional status.</p>|

**19. Objetivo de la prueba:** Según una cantidad dada de estudiantes, se muestra la información de cada estudiante que tuvo un cambio de estado, es decir, cambio de categoría en el intervalo de tiempo seleccionado (septiembre 2022 - abril 2023 ). El usuario podrá elegir el orden en que quiere que se muestre la información de los estudiantes. En este caso, el reporte de cambios en modo listado será ordenado por apellido (orden lexicográfico).

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|<p>**testnutriotionalReportListByAge**<p>|<p>**setUpStage2**<p>|<p>Arraylist of the Students<p>|<p>Students sorted by last name:</p><p>- Code: A00380345</p><p>Name: Pablo Blandon</p><p>Age: 20</p><p>Sex: M</p><p>Height: 1.71</p><p>Sep. Weight: 75.0</p><p>Apr. weight: 73.0</p><p>Sep. BMI:25.65</p<p>Apr. BMI: 24.96</p><p>- Code: A00380776</p><p>Name: Maria Garcia</p><p>Age: 20</p><p>Sex: F</p><p>Height: 1.72</p><p>Sep. Weight: 97.0</p><p>Apr. weight: 86.0</p><p>Sep. BMI: 32.79</p><p>Apr. BMI: 29.07</p><p>- Code: A00380779</p><p>Name: Maria Carmen Hernandez</p><p>Age: 19</p><p>Sex: F</p><p>Height: 1.62</p><p>Sep. Weight: 72.0</p><p>Apr. weight: 59.0</p><p>Sep. BMI: 27.43</p><p>Apr. BMI: 22.48</p><p>- Code: A00370987</p><p>Name: Josefa Lopez</p><p>Age: 21</p><p>Sex: F</p><p>Height: 1.74</p><p>Sep. Weight: 93.0</p><p>Apr. weight: 88.0</p><p>Sep. BMI: 30.72</p><p>Apr. BMI: 29.07</p>|


**20. Objetivo de la prueba:** Para el reporte de clasificación el usuario  puede escoger el orden en cómo quiere que se muestre la información. En este caso, se verifica que el reporte generado muestre en modo listado a los estudiantes por edad (de menor a mayor) según la categoría a la que corresponda.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|<p>**testclasificationByAge**</p>|<p>**setUpStage3**</p>|<p>**Arraylist of the Students**</p>|<p>Students sorted by age:</p><p>B: </p><p>- Code: A00408965 </p><p>Name: Martina Perez </p><p>Age: 18</p><p>Sex: F</p><p>Height: 1.6</p><p>Sep. Weight: 60.0</p><p>Apr. weight: 66.0</p><p>Sep. BMI: 22.31</p><p>Apr. BMI: 24.54</p><p>- Code: A00397065 </p><p>Name: Camilo Baron</p><p>Age: 19</p><p>Sex: M</p><p>Height: 1.82</p><p>Sep. Weight: 72.0</p><p>Apr. weight: 70.0</p><p>Sep. BMI: 21.74</p><p>Apr. BMI: 21.13</p><p>- Code: A00386954 </p><p>Name: Cristina Mendoza</p><p>Age: 21</p><p>Sex: F</p><p>Height: 1.62</p><p>Sep. Weight: 65.0</p><p>Apr. weight: 66.0</p><p>Sep. BMI: 24.77</p><p>Apr. BMI: 25.15</p><p>- Code: A00345231 </p><p>Name: Pedro Aguirre</p><p>Age: 24</p><p>Sex: M</p><p>Height: 1.78</p><p>Sep. Weight: 76.0</p><p>Apr. weight:76.0</p><p>Sep. BMI: 23.99</p><p>Apr. BMI: 23.99</p><p>**C:**</p><p>- Code: A00387964 </p><p>Name: Yeison Rodriguez</p><p>Age: 20</p><p>Sex: M</p><p>Height: 1.7</p><p>Sep. Weight: 74.0</p><p>Apr. weight: 74.0</p><p>Sep. BMI: 25.61</p><p>Apr. BMI: 25.61</p>|

**21. Objetivo de la prueba:** Para el reporte de clasificación el usuario  puede escoger el orden en cómo quiere que se muestre la información. En este caso, se verifica que el reporte generado muestre en modo listado a los estudiantes por apellido (orden lexicográfico) según la categoría a la que corresponda.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p>|<p>**testclasificationByLastname**</p>|<p>**setUpStage3**</p>|<p>**Arraylist of the Students**</p>|<p>Students sorted by last name:</p><p>B:</p><p>- Code: A00345231  </p><p>Name: Pedro Aguirre</p><p>Age: 24</p><p>Sex: M</p><p>Height: 1.78</p><p>Sep. Weight: 76.0</p><p>Apr. weight: 76.0</p><p>Sep. BMI: 23.99</p><p>Apr. BMI: 23.99</p><p>- Code: A00397065 </p><p>Name: Camilo Barona</p><p>Age: 19</p><p>Sex: M</p><p>Height: 1.82</p><p>Sep. Weight: 72.0</p><p>Apr. weight: 70.0</p><p>Sep. BMI: 21.74</p><p>Apr. BMI: 21.13</p><p>- Code: A00386954  </p><p>Name: Cristina Mendoza</p><p>Age: 21</p><p>Sex: F</p><p>Height: 1.62</p><p>Sep. Weight: 65.0</p><p>Apr. weight: 66.0</p><p>Sep. BMI: 24.77</p><p>Apr. BMI: 25.15</p><p>- Code: A00408965 </p><p>Name: Martina Perez</p><p>Age: 18</p><p>Sex: F</p><p>Height: 1.6</p><p>Sep. Weight: 60.0</p<p>Apr. weight: 66.0</p><p>Sep. BMI: 22.31</p><p>Apr. BMI: 24.54</p><p>C:</p><p>- Code: A00387964 </p><p>Name: Yeison Rodriguez</p><p>Age: 20</p><p>Sex: M</p><p>Height: 1.7</p><p>Sep. Weight: 74.0</p><p>Apr. weight: 74.0</p><p>Sep. BMI: 25.61</p><p>Apr. BMI: 25.61</p>|

**22. Objetivo de la prueba:** Para el reporte de clasificación el usuario  puede escoger el orden en cómo quiere que se muestre la información. En este caso, se verifica que el reporte generado muestre en un histograma a los estudiantes según corresponda. Es decir, sean ubicados de manera correcta en la categoría a la cual pertenecen.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p>|<p>**testClassificationReportHistogram**</p><p></p>|<p>**setUpStage3**</p>|<p>Arraylist of the Students</p>|<p>Distribution:</p><p></p><p>A: 0 students</p><p>B: 4 students</p><p>C: 1 students</p><p>D: 0 students</p><p>E: 0 students</p><p>Histogram:</p><p></p><p>A</p><p>B ++++</p><p>C +</p><p>D</p><p>E</p><p></p>|


**23. Objetivo de la prueba:** Verificar que el método search funcione de manera correcta y encuentre el código del usuario que se desea encontrar. El método retorna "null" en caso de encontrar al estudiante asociado al código digitado.

|**Clase**|**Método**|**Escenario**|**Valores de entrada**|**Resultado esperado**|
| :- | :- | :- | :- | :- |
|<p>**BienestarController**</p><p></p><p></p><p>**BienestarController**</p>|<p>**testSearch** </p><p>**testSearch** </p>|<p>**setUpStage2**</p><p>**setUpStage2**</p>|<p>**StudentCode = A00360987**</p><p>**StudentCode = A00897654**</p>|<p>The student was identified</p><p>Student not found == null </p><p></p>|


