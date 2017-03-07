package Graphik.AnalizadorG1;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
//import logica.*;
//import principal.*;
//import tecumhuman_p1compi2_cliente.*;
%%

%public
%class GAnalizador1
%cupsym sGF1
%cup
%unicode
%line
%column
%char
%ignorecase

%{
//VARIALES Y METODOS DEL SCANER
/*public ArrayList<TokenError> tabla_Errores;

//public void setTablaErrores(ArrayList<TokenError> tabla){
  //  tabla_Errores = tabla;
//}
*/
private void ErrorScan(String simboloEd, String columna, String linea, String descripcion){
//ventanaPrincipal.errorGlobal(simboloEd,columna,linea,"Error lexico"); 
System.err.println("Error lexico "+simboloEd);
}

%}

digito  = [0-9]
caracter=[a-zA-Z]


comentarioMultiple="#"[/] [^/]+[/]"#" 
comentarioLinea="#"{1} ([^\r\n\t])+

//lo utilizado es esto de abajo
num  = {digito}+
ent=[-]?{num}
deci = [-]?{num}+["."]{num}+

id={caracter} ({caracter}|{num}|"_")*
ext1=".gk"
ext2=".dk"
//path=({path1}|{path2})
//arUlx={id} ".ulx"
caracterC=["'"]{caracter}["'"]
cadena  =   [\"][^\n\"]*[\"]
//pip="&"
comentario=({comentarioMultiple}|{comentarioLinea})
//lo utilizado es esto de arriba

%%


"var"           {return new Symbol(sGF1.varL, yycolumn+1,yyline+1,new String(yytext()));}
"entero"           {return new Symbol(sGF1.enteroL, yycolumn+1,yyline+1,new String(yytext()));}
"decimal"           {return new Symbol(sGF1.decimalL, yycolumn+1,yyline+1,new String(yytext()));}
"caracter"           {return new Symbol(sGF1.caracterL, yycolumn+1,yyline+1,new String(yytext()));}
"cadena"           {return new Symbol(sGF1.cadenaL, yycolumn+1,yyline+1,new String(yytext()));}
"bool"           {return new Symbol(sGF1.boolL, yycolumn+1,yyline+1,new String(yytext()));}
"vacio"           {return new Symbol(sGF1.vacioL, yycolumn+1,yyline+1,new String(yytext()));}

"publico"           {return new Symbol(sGF1.publicoL, yycolumn+1,yyline+1,new String(yytext()));}
"protegido"           {return new Symbol(sGF1.protegidoL, yycolumn+1,yyline+1,new String(yytext()));}
"privado"           {return new Symbol(sGF1.privadoL, yycolumn+1,yyline+1,new String(yytext()));}


"importar"           {return new Symbol(sGF1.import, yycolumn+1,yyline+1,new String(yytext()));}
"als"           {return new Symbol(sGF1.alsL, yycolumn+1,yyline+1,new String(yytext()));}
"llamar"           {return new Symbol(sGF1.llamarL, yycolumn+1,yyline+1,new String(yytext()));}
"nuevo"           {return new Symbol(sGF1.newL, yycolumn+1,yyline+1,new String(yytext()));}

"llamarhk"           {return new Symbol(sGF1.llamarhkL, yycolumn+1,yyline+1,new String(yytext()));}
"hereda"           {return new Symbol(sGF1.heredaL, yycolumn+1,yyline+1,new String(yytext()));}
"retornar"           {return new Symbol(sGF1.retornarL, yycolumn+1,yyline+1,new String(yytext()));}

"inicio"           {return new Symbol(sGF1.mainL, yycolumn+1,yyline+1,new String(yytext()));}
"incluir_hk"           {return new Symbol(sGF1.incluirHK, yycolumn+1,yyline+1,new String(yytext()));}

"llamarhk"           {return new Symbol(sGF1.llamarHKL, yycolumn+1,yyline+1,new String(yytext()));}
"si"           {return new Symbol(sGF1.ifL, yycolumn+1,yyline+1,new String(yytext()));}

"sino"           {return new Symbol(sGF1.elseL, yycolumn+1,yyline+1,new String(yytext()));}
"seleccion"           {return new Symbol(sGF1.switchL, yycolumn+1,yyline+1,new String(yytext()));}

"caso"           {return new Symbol(sGF1.caseL, yycolumn+1,yyline+1,new String(yytext()));}
"defecto"           {return new Symbol(sGF1.defaultL, yycolumn+1,yyline+1,new String(yytext()));}

"para"           {return new Symbol(sGF1.forL, yycolumn+1,yyline+1,new String(yytext()));}
"mientras"           {return new Symbol(sGF1.whileL, yycolumn+1,yyline+1,new String(yytext()));}

"hacer"           {return new Symbol(sGF1.doL, yycolumn+1,yyline+1,new String(yytext()));}
"continuar"           {return new Symbol(sGF1.continueL, yycolumn+1,yyline+1,new String(yytext()));}

"terminar"           {return new Symbol(sGF1.breakL, yycolumn+1,yyline+1,new String(yytext()));}
"graphikar_funcion"           {return new Symbol(sGF1.graficar, yycolumn+1,yyline+1,new String(yytext()));}

"void"           {return new Symbol(sGF1.voidL, yycolumn+1,yyline+1,new String(yytext()));}
"columna"           {return new Symbol(sGF1.columnaL, yycolumn+1,yyline+1,new String(yytext()));}
"donde"           {return new Symbol(sGF1.dondeL, yycolumn+1,yyline+1,new String(yytext()));}
"dondecada"           {return new Symbol(sGF1.dondeCadaL, yycolumn+1,yyline+1,new String(yytext()));}
"dondetodo"           {return new Symbol(sGF1.dondeTodoL, yycolumn+1,yyline+1,new String(yytext()));}
"imprimir"           {return new Symbol(sGF1.printL, yycolumn+1,yyline+1,new String(yytext()));}

"\."        {return new Symbol(sGF1.punto, yycolumn+1,yyline+1,new String(yytext()));}
"("        {return new Symbol(sGF1.parA, yycolumn+1,yyline+1,new String(yytext()));}
")"         {return new Symbol(sGF1.parC, yycolumn+1,yyline+1,new String(yytext()));}

"{"        {return new Symbol(sGF1.llaveA, yycolumn+1,yyline+1,new String(yytext()));}
"}"         {return new Symbol(sGF1.llaveC, yycolumn+1,yyline+1,new String(yytext()));}

"["        {return new Symbol(sGF1.corA, yycolumn+1,yyline+1,new String(yytext()));}
"]"         {return new Symbol(sGF1.corC, yycolumn+1,yyline+1,new String(yytext()));}



","        {return new Symbol(sGF1.coma, yycolumn+1,yyline+1,new String(yytext()));}
":"        {return new Symbol(sGF1.dosPuntos, yycolumn+1,yyline+1,new String(yytext()));}
"="        {return new Symbol(sGF1.asignacion, yycolumn+1,yyline+1,new String(yytext()));}
"?"        {return new Symbol(sGF1.delimitador, yycolumn+1,yyline+1,new String(yytext()));}


"&&"        {return new Symbol(sGF1.yLogico, yycolumn+1,yyline+1,new String(yytext()));}
"||"        {return new Symbol(sGF1.oLogico, yycolumn+1,yyline+1,new String(yytext()));}
"&|"        {return new Symbol(sGF1.xorLogico, yycolumn+1,yyline+1,new String(yytext()));}
"!"        {return new Symbol(sGF1.notLogico, yycolumn+1,yyline+1,new String(yytext()));}


"=="        {return new Symbol(sGF1.comparacion, yycolumn+1,yyline+1,new String(yytext()));}
"!="        {return new Symbol(sGF1.distinto, yycolumn+1,yyline+1,new String(yytext()));}
">="        {return new Symbol(sGF1.mayorIgual, yycolumn+1,yyline+1,new String(yytext()));}
"<="        {return new Symbol(sGF1.menorIgual, yycolumn+1,yyline+1,new String(yytext()));}
">"        {return new Symbol(sGF1.mayor, yycolumn+1,yyline+1,new String(yytext()));}
"<"        {return new Symbol(sGF1.menor, yycolumn+1,yyline+1,new String(yytext()));}

"+"        {return new Symbol(sGF1.suma, yycolumn+1,yyline+1,new String(yytext()));}
"-"        {return new Symbol(sGF1.resta, yycolumn+1,yyline+1,new String(yytext()));}
"*"        {return new Symbol(sGF1.por, yycolumn+1,yyline+1,new String(yytext()));}
"/"        {return new Symbol(sGF1.div, yycolumn+1,yyline+1,new String(yytext()));}
"^"        {return new Symbol(sGF1.pot, yycolumn+1,yyline+1,new String(yytext()));}
"%"        {return new Symbol(sGF1.mod, yycolumn+1,yyline+1,new String(yytext()));}
"--"        {return new Symbol(sGF1.disminucion, yycolumn+1,yyline+1,new String(yytext()));}
"++"        {return new Symbol(sGF1.aumento, yycolumn+1,yyline+1,new String(yytext()));}
"!!"        {return new Symbol(sGF1.indice, yycolumn+1,yyline+1,new String(yytext()));}
"$"        {return new Symbol(sGF1.dolar, yycolumn+1,yyline+1,new String(yytext()));}

{ext1}    {return new Symbol(sGF1.archivoGK, yycolumn+1,yyline+1,new String(yytext()));}
{num}    {return new Symbol(sGF1.num, yycolumn+1,yyline+1,new String(yytext()));}
{deci}    {return new Symbol(sGF1.decimal, yycolumn+1,yyline+1,new String(yytext()));}
{id}    {return new Symbol(sGF1.id, yycolumn+1,yyline+1,new String(yytext()));}
{caracterC}    {return new Symbol(sGF1.caracter, yycolumn+1,yyline+1,new String(yytext()));}
//{path}    {System.out.println("path -->" +yytext()); return new Symbol(sGF1.path, yycolumn+1,yyline+1,new String(yytext()));}
//{arUlx}   {return new Symbol(sGF1.arTerminales, yycolumn+1,yyline+1,new String(yytext()));}
{cadena}   {return new Symbol(sGF1.cadena, yycolumn+1,yyline+1,new String(yytext()));}
{comentario}   {}


/* BLANCOS */
[" "|\t|\r|\f|\n]+  {}

.                   {
                        System.out.println("Error Lexico -> Simbolo: \""+yytext()+"\" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1) );
                    //    pantallaPincipal.errorLexLienzo(yytext(),""+ yycolumn,""+ yyline, "Lexico");
                     //tabla_Errores.add(new TokenError("Lexico","Lexema no pertenece al lenguaje",yytext(),String.valueOf(yyline+1),String.valueOf(yycolumn+1)));
//ventanaPrincipal.errorGlobal(yytext(),String.valueOf(yychar),String.valueOf(yyline),"Lexico");                      
}
