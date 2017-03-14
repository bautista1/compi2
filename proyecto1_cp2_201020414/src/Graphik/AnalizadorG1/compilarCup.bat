SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_77\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd C:\Users\Alberth\Documents\GitHub\compi2\proyecto1_cp2_201020414\src\Graphik\AnalizadorG1
java -classpath C:\Fuentes\ java_cup.Main -parser sinG -symbols sGF1 parser1.cup
pause