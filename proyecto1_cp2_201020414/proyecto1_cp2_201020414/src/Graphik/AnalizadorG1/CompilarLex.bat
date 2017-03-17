SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_101\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
SET JFLEX_HOME= C:\Fuentes
cd C:\Users\Alberth\Documents\NetBeansProjects\proyecto1_cp2_201020414\src\Graphik\AnalizadorG1
java -jar %JFLEX_HOME%\JFlex.jar scanner1.jflex
pause