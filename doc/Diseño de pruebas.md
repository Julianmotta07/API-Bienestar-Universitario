Diseño de pruebas 


Configuración de los Escenarios

Nombre	     Clase	                Escenario
setUpStage1	 Student	            Un objeto de la clase Student con name = "Lina", lastName = "Andrade", age = 19, weightS = 58, weightA = 56, height = 1,57 , IMCS = 23,5, IMCA = 22,7 ,  sex = "f"
setUpStage2  Student	            Un objeto de la clase Student con name = “Julian”, lastName = "Motta",age = 18, weightS = 60, weightA 
                                    = 60 height =  1,68 , IMCS = 21,3, IMCA = 21,3 gender = "masculino"

setUpStage3  BienestarController	Una lista de 5 estudiantes con el peso e IMC de septiembre de 2022: 

 1. Un objeto de la clase Student con name = “Juan”, lastName = "Tobar", age = 23, weight = 80,height = 1,78 , IMC = 25,2 gender = "masculino"

 2. Un objeto de la clase Student con name = “Juliana”, lastName = "Parra", age = 22, weight = 55,height = 1,60, IMC = 21,5, gender = "femenino"
 
 3. Un objeto de la clase Student con name = “Jose”, lastName = "Perez", age = 24, weight = 50 height = 1,70 , IMC = 17,3, gender = "masculino"

 4. Un objeto de la clase Student con name = “Pablo”, lastName = "Blandon",age = 20, weight = 75,height = 1,71, IMC = 25,6, gender = "masculino"

 5. Un objeto de la clase Student con name = “Ana”, lastName = "Gomez", age = 21, weight =65 , height = 1,70,IMC = 22,5 gender = "femenino"

Prueba

Objetivo de la Prueba: Probar que el método editRecord, funciona de manera correcta 
 Clase	               Método	    Escenario	    Valores de Entrada	                                   Resultado esperado
BienestarController	editRecord      setUpStage1	    optionToChange = "name", userChanges = "Mariana"       name = "Mariana"
BienestarController	editRecord      setUpStage1	    optionToChange = "name", userChanges = 33              throw new invalidDataException
BienestarController	editRecord      setUpStage2	    optionToChange = "age", userChanges = 22               age = 22
BienestarController	editRecord      setUpStage2     optionToChange = "age", userChanges = 3,3              throw new NumberFormatException


Objetivo de la Prueba: Probar que el método deleteRecord elimina un registro
 Clase	               Método	    Escenario	    Valores de Entrada	                            Resultado esperado
BienestarController	deleteRecord    setUpStage3	    studentToDelete = "Catalina"                    throw new invalidStudentException
BienestarController	editRecord      setUpStage3	    studentToDelete = "Lina"                        students.Size() == 4 


Objetivo de la prueba: Verificar que el método generateReport genera los reportes (HISTOGRAMA) de manera correcta : 
 Clase	               Método	    Escenario	    Valores de Entrada	                            Resultado esperado
BienestarController	generateReport  setUpStage3	          N/A                                       ============================
                                                                                                    Reporte de Septiembre de 2022
                                                                                                    ============================
                                                                                                    Categoría A (peso bajo): 1 estudiante
                                                                                                    Categoría B (normal): 2 estudiantes
                                                                                                    Categoría C (sobrepeso): 2 estudiantes

                                                                                                    Distribución:

                                                                                                      +
                                                                                                    A +

                                                                                                      ++ 
                                                                                                    B ++

                                                                                                      ++
                                                                                                    C ++
                    

Objetivo de la prueba: Verificar que el método generateReport genera los reportes (MODO LISTADO) de manera correcta : 
 Clase	               Método	          Escenario	      Valores de Entrada	                    Resultado esperado
BienestarController	   generateReport    setUpStage3	          N/A                               ============================
                                                                                                    Reporte de Septiembre de 2022
                                                                                                    ============================
                                                                                                    Categoría A (peso bajo): 1 estudiante
                                                                                                    
                                                                                                    name = “Jose”, lastName = "Perez", age = 24, weight = 50 height = 1,70 , IMC = 17,3, gender = "masculino"

                                                                                                    Categoría B (normal): 2 estudiantes

                                                                                                    name = “Juliana”, lastName = "Parra", age = 22, weight = 55,height = 1,60, IMC = 21,5, gender = "femenino"

                                                                                                    name = “Ana”, lastName = "Gomez", age = 21, weight =65 , height = 1,70,IMC = 22,5 gender = "femenino"

                                                                                                    Categoría C (sobrepeso): 2 estudiantes 

                                                                                                    name = “Pablo”, lastName = "Blandon",age = 20, weight = 75,height = 1,71, IMC = 25,6, gender = "masculino"

                                                                                                    name = “Juan”, lastName = "Tobar", age = 23, weight = 80,height = 1,78 , IMC = 25,2 gender = "masculino"


Objetivo de la Prueba: Probar que el método sortingByAge ordena los datos por edad (de menor a mayor)
 Clase	               Método	    Escenario	    Valores de Entrada	                            Resultado esperado
BienestarController	deleteRecord    setUpStage3	     N/A                                        ============================
                                                                                                    Reporte de Septiembre de 2022
                                                                                                    ============================

                                                                                                     name = “Pablo”, lastName = "Blandon",age = 20, weight = 75,height = 1,71, IMC = 25,6, gender = "masculino"
                                                                                                    
                                                                                                    name = “Ana”, lastName = "Gomez", age = 21, weight =65 , height = 1,70,IMC = 22,5 gender = "femenino"
                                                                                                    
                                                                                                    name = “Juliana”, lastName = "Parra", age = 22, weight = 55,height = 1,60, IMC = 21,5, gender = "femenino"

                                                                                                    name = “Juan”, lastName = "Tobar", age = 23, weight = 80,height = 1,78 , IMC = 25,2 gender = "masculino"

                                                                                                    name = “Jose”, lastName = "Perez", age = 24, weight = 50 height = 1,70 , IMC = 17,3, gender = "masculino"

                                                                                                   

                                                                                                    



                                                                                                   




                                                                                                    



