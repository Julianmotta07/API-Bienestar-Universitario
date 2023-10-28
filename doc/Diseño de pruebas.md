Diseño de pruebas 

Configuración de los escenarios


| Nombre        | Clase                 |Escenario                                                                                            |
|------------   | -----------           | ----------                                                                                           |
| setUpStage1   | BienestarController   | Una lista que contiene los datos de un archivo CSV  con 34 objetos de tipo "Student  con
|               |                       | los parametros correspondientes                                                                      |
| setUpStage2   | BienestarController   | Una lista contiene los datos de un archivo CSV  con 34 objetos de tipo "student" con los            | 
                                          parametros correspondientes y cinco estudiantes agregados de manera "manual":                        |
                                          1. Un objeto de la clase Student con studentCode = "A00369076",name = “Juan”, lastName = "Tobar", age = 23, sex = 'M', weightS = 80, weightA = 78, height = 1.83

                                         2. Un objeto de la clase Student con 
                                         studentCode = "A00370234", name = “Juliana”, lastName = "Parra", age = 22, sex = 'F',weightS = 55,weightS = 50,height = 1.60
 
                                         3. Un objeto de la clase Student con 
                                         studentCode = "A00356473", name = “Jose”, lastName = "Perez", age = 24,  sex = 'M', weightS = 50, weightA = 57, height = 1.70 

                                         4. Un objeto de la clase Student con
                                         studentCode = "A00380345", name = “Pablo”, lastName = "Blandon",age = 20, sex = 'M', weightS = 75, weightA = 73,height = 1.71

                                         5. Un objeto de la clase Student con studentCode = "A00370768",name = “Ana”, lastName = "Gomez", age = 21,sex = 'F', weightS =65 , weightA = 66, height = 1,70
                                                                                                    |
| setUpStage3   | BienestarController   |   Una lista de 5 estudiantes : 

                                         1. Un objeto de la clase Student con studentCode = "A00408965" , name = “Martina”, lastName = "Perez",|age = 18, sex = 'F', weightS = 60, weightA = 66, height = 1.64                                        |

                                         2. Un objeto de la clase Student con studentCode = "A00387964" , name = “Yeison”, lastName =          |"Rodriguez", age = 20, sex = 'M', weightS = 74, weightA = 74, height = 1.70                           |
 
                                         3. Un objeto de la clase Student con studentCode = "A00397065" , name = “Camilo”, lastName = "Barona", age = 19, sex = 'M', weightS = 72, weightA = 70, height = 1.82

                                         4. Un objeto de la clase Student con studentCode = "A00345231" , name = “Pedro”, lastName = "Aguirre", age = 24, sex = 'M', weightS = 76, weightA = 76, height = 1.78

                                         5. Un objeto de la clase Student con studentCode = "A00386954" , name = “Cristina”, lastName = "Mendoza", age = 21, sex = 'F', weightS = 65, weightA = 66, height = 1.62
          
| setUpStage4   | BienestarController   | Una lista de 2 estudiantes:                                                                          |
                                          1. Un objeto de la clase Student con studentCode = "A00154324" , name = “Ronny”, lastName = "Rios",  |age = 20, sex = 'M', weightS = 78, weightA = 78, height = 1.80                                       |

                                         2. Un objeto de la clase Student con studentCode = "A00986756" , name = “Valeria”, lastName =          "Espinosa", age = 23, sex = 'F', weightS = 76, weightA = 75, height = 1.65                            |
| setUpStage1   | DataWriter            | Se crea una instancia de la clase "DataWriter"


Diseño casos de prueba

| Objetivo de la Prueba : verificar que los reportes sean guardados de manera correcta en un txt

| Clase       | Método                 | Escenario | Valores de Entrada          | Resultado         |
|-------------|--------------          |-----------|-----------------------------|---------------    |
| DataWriter  | testBytesToTxTReport   |setUpStage1|                             | Report generated! |


| Objetivo de la Prueba : Verificar que los archivos del csv han sido cargados y añadidos de manera exitosa

| Clase | Método                       | Escenario | Valores de Entrada          | Resultado     |
|----------------------|-------|-------|-----------|-----------------------------|---------------|
| BienestarController  | addStudentsFromCSV   |setUpStage1| getStudents.size()          | 34            |
| BienestarController  | addStudentsFromCSV   |setUpStage1| getStudents.get(0).getName  |"Maria"        |
| BienestarController  | addStudentsFromCSV   |setUpStage1| getStudents.get(0).getName  |"Karen"        |
| BienestarController  | addStudentsFromCSV   |setUpStage1| getStudents.get(0).getName  |"Juan Jose"    |


| Objetivo de la Prueba : Verificar que el registro manual de usuarios funciona de manera exitosa.
Valiendando si el usuario pudo ser agregado o no. En caso de registrar un estudiante que ya se 
encontraba registrado debera informarsele al usuario que el id asociado al usuario ya existe y 
no agregarlo nuevamente. Al agregar un nuevo usuario, el tamaño de la lista debera aumentar segun la cantidad de 
usuarios nuevos qye se registren. Ademas se valida que el BMI se calcule de manera correcta segun la informacion del usuario

| Clase                | Metodo          | Escenario | Valores de Entrada                                            |Resultado               |
|----------------------|------- -------  |-----------|-----------------------------                                  |---------------         |
| BienestarController  | testAddStudents |setUpStage1| Student = "A00350678","Alejandro", "Arteaga",23,'M',60,62,1.78| The size must change the
                                                       Student = "A00350678","Alejandro", "Arteaga",23,'M',60,62,1.78   size in + 1 

                                                                                                                        The user was successfully inserted into the system

                                                                                                                        The second input value must not be registered
                                                                                                                        and size should not be updated 



| Objetivo de la Prueba : Las excepciones se capturan desde "Main". Sin embargo, el objetivo de la prueba es validar que estas serán lanzadas 
según corresponda 

| Clase                | Método        | Escenario | Valores de Entrada| Resultado                   |
|----------------------|------- -------|-----------|-------------------|---------------              |
| BienestarController  |validateAge    |setUpStage1| -3                |"Invalid age range."         | 
| BienestarController  |validateWeight |setUpStage1| -52               |Invalid weight range.        |
| BienestarController  |validateHeight |setUpStage1| -1.71             |"Invalid height range."      |
| BienestarController  |validateID     |setUpStage1| "B00345674"       |"The code must begin with A."|


| Objetivo de la Prueba : Verificar que el metodo editStudents actualiza la informacion de los estudiantes segun corresponda 

| Clase                | Método         | Escenario | Valores de Entrada                                             | Resultado              |
|----------------------|------- ------- |-----------|-----------------------------                                   |---------------         |
| BienestarController  | testEditStudent|setUpStage2| Student = "A00369076", "Juan", "Toledo", 23, 'M', 80, 78, 1.87 | "Student information  
                                                                                                                        succesfully edited!
                                                                                                                      
                                                                                                                      updated user information


 Objetivo de la Prueba : Verificar que el metodo deleteStudents elimina correctamente a los usuarios. El estudiante debe existir en el sistema, en caso de no existir, el metodo le dirá al usuario que el ingrese un id valido 

| Clase                | Método          | Escenario | Valores de Entrada                                             | Resultado              |
|----------------------|------- -------  |-----------|-----------------------------                                   |---------------         |
| BienestarController  |testdeleteStudent|setUpStage2| studentCode = "A00370234"                                    | The size must change the
                                                       studentCode = "A00370234"                                      | size in - 1

                                                                                                                       User is no longer registered in the system

                                                                                                                       for the second input value: A student with the entered ID does not exist


Objetivo de la Prueba : Se eliminan los elementos presentes en el sistema, validando que al hacerlo el tamaño es cero

| Clase                | Método         | Escenario | Valores de Entrada                                             | Resultado              |
|----------------------|------- ------- |-----------|-----------------------------                                   |---------------         |
| BienestarController  | testEditStudent|setUpStage2| studentCode = "A00154324"                                      | The size is equal to 
                                                      studentCode = "A00986756"                                             zero

                                                                                                                       User is no longer registered in the system

                                                                                                                       the arrayList is empty 




Objetivo de la Prueba :  Se validará que los usuarios se agrupen según la categoria que corresponda:

       0 = Peso bajo
       1 = Peso normal
       2 = Sobrepeso
       3 = Obesidad
       4 = Obesidad morbida

| Clase                | Método            | Escenario | Valores de Entrada                                         | Resultado              |
|----------------------|------- -------    |-----------|-----------------------------                               |---------------         |
| BienestarController  | testgetBmiCategory|setUpStage1| the first five elements of the csv                         |{2,1,2,21} Respectively


Objetivo de la prueba: Segun una cantidad dada de estudiantes, se agruparan en categorias dependiendo de su BMI, al final se mostrara el histograma correspondiente segun la cantidad de estudiantes por categoria. En caso de que ningun estudiante pertenezca a la categoria, esta se mostrara vacia 

| Clase                | Método              | Escenario | Valores de Entrada                                         | Resultado              |
|----------------------|------- -------      |-----------|-----------------------------                               |---------------         |
| BienestarController  |testGenerateHistogram|setUpStage1| the first five elements of the csv                         |     lowWeightH
                                                                                                                        +   normalWeightH
                                                                                                                        ++  overweightH
                                                                                                                        ++" obesityH
                                                                                                                          morbidObesityH


Objetivo de la prueba : El usuario podra escoger el orden en que quiere ver sus informes, por lo cual, se valida que el metodo encargado de 
reordenar los usuarios segun el requerimiento del usuario, funcione correctamente (en este caso por edad, de menor a mayor) :

| Clase                | Método              | Escenario | Valores de Entrada                                         | Resultado              |
|----------------------|------- -------      |-----------|-----------------------------                               |---------------         |
| BienestarController  |testSelectionSortByAge|setUpStage3|Arraylist of the Students                                    Martina - Edad : 18
                                                                                                                        Camilo - Edad : 19
                                                                                                                        Yeison - Edad : 20
                                                                                                                        Cristina - Edad : 21
                                                                                                                        Pedro - Edad :24                    
                                                                                                                     

Objetivo de la prueba : El usuario podra escoger el orden en que quiere ver sus informes, por lo cual, se valida que el metodo encargado de 
reordenar los usuarios segun el requerimiento del usuario, funcione correctamente (en este caso por apellido, orden lexicografico) :

| Clase                | Método                  | Escenario | Valores de Entrada                               | Resultado                   |
|----------------------|------- -------          |-----------|-----------------------------                     |---------------              |
| BienestarController  |testSelectionSortLastname|setUpStage3|Arraylist of the Students                           Pedro Aguirre
                                                                                                                  Camilo Barona
                                                                                                                  Cristina Mendoza
                                                                                                                  Martina Perez
                                                                                                                  Yeison Rodriguez                
                                                                                                                     
Objetivo de la prueba : El usuario podra escoger el orden en que quiere ver sus informes, por lo cual, se valida que el metodo encargado de 
reordenar los usuarios segun el requerimiento del usuario, funcione correctamente (en este caso por el bmi calculado en el mes de septiembre) :

| Clase                | Método                 | Escenario  | Valores de Entrada                               | Resultado               |
|----------------------|------- -------         |----------- |-----------------------------                     |---------------          |
| BienestarController  |testSelectionSortByBMISep|setUpStage3|Arraylist of the Students                         Camilo Barona - BMI : 21.74
                                                                                                                Martina Perez - BMI : 22.31
                                                                                                                Pedro Aguirre - BMI : 23.99
                                                                                                                Cristina Mendoza - BMI : 24.77
                                                                                                                Yeison Rodriguez - BMI : 25.61                   
                                                                                                                     
Objetivo de la prueba : El usuario podra escoger el orden en que quiere ver sus informes, por lo cual, se valida que el metodo encargado de 
reordenar los usuarios segun el requerimiento del usuario, funcione correctamente (en este caso por el bmi calculado en el mes de abril) :

| Clase                | Método                  | Escenario  | Valores de Entrada                          | Resultado                     |
|----------------------|------- -------          |----------- |-----------------------------                |---------------                |
| BienestarController  |testSelectionSortByBMIApr|setUpStage3 |Arraylist of the Students                     Camilo Barona - BMI : 21.13
                                                                                                             Pedro Aguirre - BMI : 23.99
                                                                                                             Martina Perez - BMI : 24.54
                                                                                                             Cristina Mendoza - BMI : 25.15
                                                                                                             Yeison Rodriguez - BMI : 25.61                 
                                                                                                                     
Objetivo de la prueba: Según una cantidad dada de usuarios, es necesario validar quienes tuvieron un cambio significativo, bien sea bueno o malo, para ello se comparan  el bmi de septiembre como el bmi de abril y se indican quienes tuvieron un cambio significativo y la categoria a la que pertenecen ahora 

| Clase                | Método                         | Escenario  | Valores de Entrada               | Resultado                     |
|----------------------|------- -------                 |----------- |-----------------------------     |---------------                |
| BienestarController  |testnutriotionalReportListByBMI | setUpStage3| arraylist of the students         Students sorted by BMI (april):
                                
                                                                                                            - Code: A00386954
                                                                                                            Name: Cristina Mendoza
                                                                                                            Age: 21
                                                                                                            Sex: F
                                                                                                            Height: 1.62
                                                                                                            Sep. Weight: 65.0
                                                                                                            Apr. weight: 66.0
                                                                                                            Sep. BMI: 24.77
                                                                                                            Apr. BMI: 25.15
                                                                                                                                    
                                                                                                            A total of 1 students had change in their nutritional status.

Objetivo de la prueba: En este caso, ningun estudiante tuvo un cambio significativo, se mantuvieron en su categoria, por lo que se espera que ninguno sea presentado en el reporte

| Clase                | Método                                 | Escenario  | Valores de Entrada         | Resultado                     |
|----------------------|------- -------                         |----------- |--------------------------- |---------------                |
| BienestarController  |testnutriotionalReportListByBMIUnchanged| setUpStage4| arraylist of the students    Students sorted by BMI (april):
        
                                                                                                            A total of 0 students had change in their nutritional status.      


Objetivo de la prueba: Comprobar que el reporte nutricional generado muestra los estudiantes ordenados segun su edad 

| Clase                | Método                                 | Escenario  | Valores de Entrada         | Resultado                     |
|----------------------|------- -------                         |----------- |--------------------------- |---------------                |
| BienestarController  |testnutriotionalReportListByAge         | setUpStage2| arraylist of the students    Students sorted by age:
                                
                                                                                                            - Code: A00380779
                                                                                                            Name: Maria Carmen Hernandez
                                                                                                            Age: 19
                                                                                                            Sex: F
                                                                                                            Height: 1.62
                                                                                                            Sep. Weight: 72.0
                                                                                                            Apr. weight: 59.0
                                                                                                            Sep. BMI: 27.43
                                                                                                            Apr. BMI: 22.48
                                                                                                                            
                                                                                                            - Code: A00380776
                                                                                                            Name: Maria Garcia
                                                                                                            Age: 20
                                                                                                            Sex: F
                                                                                                            Height: 1.72
                                                                                                            Sep. Weight: 97.0
                                                                                                            Apr. weight: 86.0
                                                                                                            Sep. BMI: 32.79
                                                                                                            Apr. BMI: 29.07
                                                                                                                            
                                                                                                            - Code: A00370864
                                                                                                            Name: Jose Antonio Munoz
                                                                                                            Age: 20
                                                                                                            Sex: O
                                                                                                            Height: 1.69
                                                                                                            Sep. Weight: 53.0
                                                                                                            Apr. weight: 52.0
                                                                                                            Sep. BMI: 18.56
                                                                                                            Apr. BMI: 18.21
                                                                                                                            
                                                                                                            - Code: A00380345
                                                                                                            Name: Pablo Blandon
                                                                                                            Age: 20
                                                                                                            Sex: M
                                                                                                            Height: 1.71
                                                                                                            Sep. Weight: 75.0
                                                                                                            Apr. weight: 73.0
                                                                                                            Sep. BMI: 25.65
                                                                                                            Apr. BMI: 24.96
                                                                                                                            
                                                                                                            - Code: A00370987
                                                                                                            Name: Josefa Lopez
                                                                                                            Age: 21
                                                                                                            Sex: F
                                                                                                            Height: 1.74
                                                                                                            Sep. Weight: 93.0
                                                                                                            Apr. weight: 88.0
                                                                                                            Sep. BMI: 30.72
                                                                                                            Apr. BMI: 29.07
                                                                                                                            
                                                                                                            - Code: A00347601
                                                                                                            Name: Cristina Moreno
                                                                                                            Age: 24
                                                                                                            Sex: F
                                                                                                            Height: 1.66
                                                                                                            Sep. Weight: 68.0
                                                                                                            Apr. weight: 69.0
                                                                                                            Sep. BMI: 24.68
                                                                                                            Apr. BMI: 25.04
                                                                                                                            
                                                                                                            - Code: A00356473
                                                                                                            Name: Jose Perez
                                                                                                            Age: 24
                                                                                                            Sex: M
                                                                                                            Height: 1.7
                                                                                                            Sep. Weight: 50.0
                                                                                                            Apr. weight: 57.0
                                                                                                            Sep. BMI: 17.3
                                                                                                            Apr. BMI: 19.72
                                                                                                                            
                                                                                                            A total of 7 students had change in their nutritional status.



Objetivo de la prueba: Comprobar que el reporte de clasificacion generado muestre los estudiantes ordenados segun su edad y categoria 

| Clase                | Método                                 | Escenario  | Valores de Entrada         | Resultado                     |
|----------------------|------- -------                         |----------- |--------------------------- |---------------                |
| BienestarController  |testclasificationReportListByAge         | setUpStage3| arraylist of the students  | Students sorted by age:
                
                                                                                                            B:
                                                                                                            - Code: A00408965
                                                                                                            Name: Martina Perez
                                                                                                            Age: 18
                                                                                                            Sex: F
                                                                                                            Height: 1.64
                                                                                                            Sep. Weight: 60.0
                                                                                                            Apr. weight: 66.0
                                                                                                            Sep. BMI: 22.31
                                                                                                            Apr. BMI: 24.54

                                                                                                            - Code: A00397065
                                                                                                            Name: Camilo Barona
                                                                                                            Age: 19
                                                                                                            Sex: M
                                                                                                            Height: 1.82
                                                                                                            Sep. Weight: 72.0
                                                                                                            Apr. weight: 70.0
                                                                                                            Sep. BMI: 21.74
                                                                                                            Apr. BMI: 21.13

                                                                                                            - Code: A00386954
                                                                                                            Name: Cristina Mendoza
                                                                                                            Age: 21
                                                                                                            Sex: F
                                                                                                            Height: 1.62
                                                                                                            Sep. Weight: 65.0
                                                                                                            Apr. weight: 66.0
                                                                                                            Sep. BMI: 24.77
                                                                                                            Apr. BMI: 25.15

                                                                                                            - Code: A00345231
                                                                                                            Name: Pedro Aguirre
                                                                                                            Age: 24
                                                                                                            Sex: M
                                                                                                            Height: 1.78
                                                                                                            Sep. Weight: 76.0
                                                                                                            Apr. weight: 76.0
                                                                                                            Sep. BMI: 23.99
                                                                                                            Apr. BMI: 23.99

                                                                                                            C:
                                                                                                            - Code: A00387964
                                                                                                            Name: Yeison Rodriguez
                                                                                                            Age: 20
                                                                                                            Sex: M
                                                                                                            Height: 1.7
                                                                                                            Sep. Weight: 74.0
                                                                                                            Apr. weight: 74.0
                                                                                                            Sep. BMI: 25.61
                                                                                                            Apr. BMI: 25.61



Objetivo de la prueba: Comprobar que el reporte de clasificacion generado muestre los estudiantes ordenados segun su apellido y categoria 

| Clase                | Método                                 | Escenario  | Valores de Entrada         | Resultado                     |
|----------------------|------- -------                         |----------- |--------------------------- |---------------                |
| BienestarController  |testclasificationByLastname             | setUpStage3| arraylist of the students  | Students sorted by last name:
                
                                                                                                                B:
                                                                                                                - Code: A00345231
                                                                                                                Name: Pedro Aguirre
                                                                                                                Age: 24
                                                                                                                Sex: M
                                                                                                                Height: 1.78
                                                                                                                Sep. Weight: 76.0
                                                                                                                Apr. weight: 76.0
                                                                                                                Sep. BMI: 23.99
                                                                                                                Apr. BMI: 23.99

                                                                                                                - Code: A00397065
                                                                                                                Name: Camilo Barona
                                                                                                                Age: 19
                                                                                                                Sex: M
                                                                                                                Height: 1.82
                                                                                                                Sep. Weight: 72.0
                                                                                                                Apr. weight: 70.0
                                                                                                                Sep. BMI: 21.74
                                                                                                                Apr. BMI: 21.13

                                                                                                                - Code: A00386954
                                                                                                                Name: Cristina Mendoza
                                                                                                                Age: 21
                                                                                                                Sex: F
                                                                                                                Height: 1.62
                                                                                                                Sep. Weight: 65.0
                                                                                                                Apr. weight: 66.0
                                                                                                                Sep. BMI: 24.77
                                                                                                                Apr. BMI: 25.15
                                                                                                                
                                                                                                                - Code: A00408965
                                                                                                                Name: Martina Perez
                                                                                                                Age: 18
                                                                                                                Sex: F
                                                                                                                Height: 1.64
                                                                                                                Sep. Weight: 60.0
                                                                                                                Apr. weight: 66.0
                                                                                                                Sep. BMI: 22.31
                                                                                                                Apr. BMI: 24.54

                                                                                                                C:
                                                                                                                - Code: A00387964
                                                                                                                Name: Yeison Rodriguez
                                                                                                                Age: 20
                                                                                                                Sex: M
                                                                                                                Height: 1.7
                                                                                                                Sep. Weight: 74.0
                                                                                                                Apr. weight: 74.0
                                                                                                                Sep. BMI: 25.61
                                                                                                                Apr. BMI: 25.61


Objetivo de la prueba : Validar que el reporte de clasificacion por histograma funciona de manera correcta 


Objetivo de la prueba: Comprobar que el reporte de clasificacion generado muestre los estudiantes ordenados segun su apellido y categoria 

| Clase                | Método                                 | Escenario  | Valores de Entrada         | Resultado                     |
|----------------------|------- -------                         |----------- |--------------------------- |---------------                |
| BienestarController  |testClassificationReportHistogram       | setUpStage3| arraylist of the students  | Distribution:
                                                                                                            A: 0 students
                                                                                                            B: 4 students
                                                                                                            C: 1 students
                                                                                                            D: 0 students
                                                                                                            E: 0 students
                                                                                                            
                                                                                                            Histogram:
                                                                                                            A
                                                                                                            B ++++
                                                                                                            C +
                                                                                                            D
                                                                                                            E


Objetivo de la prueba: Verificar que el metodo search funcione de manera correcta y encuentre el codigo del usuario que se desea encontrar. 
El método retorna "null" en caso de encontrar al estudiante asociado al codigo digitado 

| Clase                | Método              | Escenario | Valores de Entrada                      | Resultado              |
|----------------------|------- -------      |-----------|-----------------------------            |---------------         |
| BienestarController  |testSearch           |setUpStage2| StudentCode = A00360987                 | the student was     
                                                                                                     identified 

                                                            StudentCode = A00897654                   student not found ==            
                                                                                                      null


Objetivo de la prueba: Comprobar que el reporte nutricional generado muestra los estudiantes ordenados segun su edad 

| Clase                | Método                                 | Escenario  | Valores de Entrada         | Resultado                     |
|----------------------|------- -------                         |----------- |--------------------------- |---------------                |
| BienestarController  |testnutriotionalReportListByLastname    | setUpStage2| arraylist of the students    Students sorted by last name:
                                
                                                                                                            - Code: A00380345
                                                                                                            Name: Pablo Blandon
                                                                                                            Age: 20
                                                                                                            Sex: M
                                                                                                            Height: 1.71
                                                                                                            Sep. Weight: 75.0
                                                                                                            Apr. weight: 73.0
                                                                                                            Sep. BMI: 25.65
                                                                                                            Apr. BMI: 24.96
                                                                                                            
                                                                                                            - Code: A00380776
                                                                                                            Name: Maria Garcia
                                                                                                            Age: 20
                                                                                                            Sex: F
                                                                                                            Height: 1.72
                                                                                                            Sep. Weight: 97.0
                                                                                                            Apr. weight: 86.0
                                                                                                            Sep. BMI: 32.79
                                                                                                            Apr. BMI: 29.07
                                                                                                                            
                                                                                                            - Code: A00380779
                                                                                                            Name: Maria Carmen Hernandez
                                                                                                            Age: 19
                                                                                                            Sex: F
                                                                                                            Height: 1.62
                                                                                                            Sep. Weight: 72.0
                                                                                                            Apr. weight: 59.0
                                                                                                            Sep. BMI: 27.43
                                                                                                            Apr. BMI: 22.48
                                                                                                            
                                                                                                            - Code: A00370987
                                                                                                            Name: Josefa Lopez
                                                                                                            Age: 21
                                                                                                            Sex: F
                                                                                                            Height: 1.74
                                                                                                            Sep. Weight: 93.0
                                                                                                            Apr. weight: 88.0
                                                                                                            Sep. BMI: 30.72
                                                                                                            Apr. BMI: 29.07
                                                                                                                            
                                                                                                            - Code: A00347601
                                                                                                            Name: Cristina Moreno
                                                                                                            Age: 24
                                                                                                            Sex: F
                                                                                                            Height: 1.66
                                                                                                            Sep. Weight: 68.0
                                                                                                            Apr. weight: 69.0
                                                                                                            Sep. BMI: 24.68
                                                                                                            Apr. BMI: 25.04
                                                                                                            
                                                                                                            - Code: A00370864
                                                                                                            Name: Jose Antonio Munoz
                                                                                                            Age: 20
                                                                                                            Sex: O
                                                                                                            Height: 1.69
                                                                                                            Sep. Weight: 53.0
                                                                                                            Apr. weight: 52.0
                                                                                                            Sep. BMI: 18.56
                                                                                                            Apr. BMI: 18.21
                                                                                                            
                                                                                                            - Code: A00356473
                                                                                                            Name: Jose Perez
                                                                                                            Age: 24
                                                                                                            Sex: M
                                                                                                            Height: 1.7
                                                                                                            Sep. Weight: 50.0
                                                                                                            Apr. weight: 57.0
                                                                                                            Sep. BMI: 17.3
                                                                                                            Apr. BMI: 19.72
                                                                                                                            
                                                                                                            A total of 7 students had change in their nutritional status