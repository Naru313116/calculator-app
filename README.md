# Calculator App

## About
Calculator is able to to perform:
* add
* subtract
* multiply
* divide
* power


## Setup
In order to run this project follow the following steps:
```
$ Download project
$ Run your terminal
$ change path to where you have unzipped project (cd<path>\calculator-app)
$ build a .jar file first (mvn clean install), or you can use prepared .jar file which includes all dependencies(cd out\artifacts\StorwareCalculator_jar) 
$ if you created a .jar file go to the target folder (cd target)
$ Run .jar file (target path -> java -jar StorwareCalculator-1.0-SNAPSHOT.jar <inputFilePath>, StorwareCalculator_jar path -> java -jar StorwareCalculator.jar <inputFilePath>)
```
#### In `src\main\resources` you can use file `test.txt` for testing.

#### Additionaly if you want to run tests use command `mvn test`
