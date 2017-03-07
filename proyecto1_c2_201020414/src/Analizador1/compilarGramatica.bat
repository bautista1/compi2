SET JAVA_HOME="C:\javacc\javacc-6.0\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd C:\Users\Alberth\Documents\NetBeansProjects\proyecto1_c2_201020414\src\Analizador1
javacc proyecto1.jj
cd C:\Users\Alberth\Documents\NetBeansProjects\proyecto1_c2_201020414\src\Analizador1
javac *.java
pause
