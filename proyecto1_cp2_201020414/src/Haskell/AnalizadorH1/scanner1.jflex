package Haskell.AnalizadorH1;

import java_cup.runtime.Symbol;
import java.util.ArrayList;
//import logica.*;
//import principal.*;
//import tecumhuman_p1compi2_cliente.*;
%%

%public
%class HAnalizador1
%cupsym sHF1
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


//comentarioMultiple="/"[*] [^*]+[*]"/" 
//comentarioLinea="/"{2} ([^\r\n\t])+

//lo utilizado es esto de abajo
num  = {digito}+
ent=[-]?{num}
deci = [-]?{num}+["."]{num}+

id={caracter} ({caracter}|{num}|"_")*
path1="/"? ({id} "/")* {id}".upg"
//path2="C:/"? ({id} "/")* {id}".upg"
//path=({path1}|{path2})
//arUlx={id} ".ulx"
caracterC=["'"]{caracter}["'"]
cadena  =   [\"][^\n\"]*[\"]
//pip="&"
//comentario=({comentarioMultiple}|{comentarioLinea})
//lo utilizado es esto de arriba

%%


"case"           {return new Symbol(sHF1.terminalfi, yycolumn+1,yyline+1,new String(yytext()));}


"else"           {return new Symbol(sHF1.deLoContrario, yycolumn+1,yyline+1,new String(yytext()));}
"then"           {return new Symbol(sHF1.entonces, yycolumn+1,yyline+1,new String(yytext()));}

"if"           {return new Symbol(sHF1.si, yycolumn+1,yyline+1,new String(yytext()));}
"end"           {return new Symbol(sHF1.fin, yycolumn+1,yyline+1,new String(yytext()));}

"length"           {return new Symbol(sHF1.lista, yycolumn+1,yyline+1,new String(yytext()));}
"desc"           {return new Symbol(sHF1.descendente, yycolumn+1,yyline+1,new String(yytext()));}

"asc"           {return new Symbol(sHF1.ascendente, yycolumn+1,yyline+1,new String(yytext()));}
"par"           {return new Symbol(sHF1.pares, yycolumn+1,yyline+1,new String(yytext()));}

"impr"           {return new Symbol(sHF1.impares, yycolumn+1,yyline+1,new String(yytext()));}
"revers"           {return new Symbol(sHF1.alreves, yycolumn+1,yyline+1,new String(yytext()));}

"product"           {return new Symbol(sHF1.por, yycolumn+1,yyline+1,new String(yytext()));}
"sum"           {return new Symbol(sHF1.mas, yycolumn+1,yyline+1,new String(yytext()));}

"max"           {return new Symbol(sHF1.maximo, yycolumn+1,yyline+1,new String(yytext()));}
"min"           {return new Symbol(sHF1.minimo, yycolumn+1,yyline+1,new String(yytext()));}

"decc"           {return new Symbol(sHF1.decremento, yycolumn+1,yyline+1,new String(yytext()));}
"succ"           {return new Symbol(sHF1.incremento, yycolumn+1,yyline+1,new String(yytext()));}

"calcular"           {return new Symbol(sHF1.calculo, yycolumn+1,yyline+1,new String(yytext()));}
"let"           {return new Symbol(sHF1.tLet, yycolumn+1,yyline+1,new String(yytext()));}

"mod"           {return new Symbol(sHF1.modulo, yycolumn+1,yyline+1,new String(yytext()));}
"pot"           {return new Symbol(sHF1.potencia, yycolumn+1,yyline+1,new String(yytext()));}
"sqrt"           {return new Symbol(sHF1.raiz, yycolumn+1,yyline+1,new String(yytext()));}

"\."        {return new Symbol(sHF1.punto, yycolumn+1,yyline+1,new String(yytext()));}
"("        {return new Symbol(sHF1.parA, yycolumn+1,yyline+1,new String(yytext()));}
")"         {return new Symbol(sHF1.parC, yycolumn+1,yyline+1,new String(yytext()));}

"{"        {return new Symbol(sHF1.llaveA, yycolumn+1,yyline+1,new String(yytext()));}
"}"         {return new Symbol(sHF1.llaveC, yycolumn+1,yyline+1,new String(yytext()));}

"["        {return new Symbol(sHF1.corA, yycolumn+1,yyline+1,new String(yytext()));}
"]"         {return new Symbol(sHF1.corC, yycolumn+1,yyline+1,new String(yytext()));}



","        {return new Symbol(sHF1.coma, yycolumn+1,yyline+1,new String(yytext()));}
":"        {return new Symbol(sHF1.dosPuntos, yycolumn+1,yyline+1,new String(yytext()));}
"="        {return new Symbol(sHF1.asignacion, yycolumn+1,yyline+1,new String(yytext()));}
//";"        {return new Symbol(sHF1.puntoComa, yycolumn+1,yyline+1,new String(yytext()));}


"&&"        {return new Symbol(sHF1.yLogico, yycolumn+1,yyline+1,new String(yytext()));}
"||"        {return new Symbol(sHF1.oLogico, yycolumn+1,yyline+1,new String(yytext()));}


"=="        {return new Symbol(sHF1.comparacion, yycolumn+1,yyline+1,new String(yytext()));}
"!="        {return new Symbol(sHF1.distinto, yycolumn+1,yyline+1,new String(yytext()));}
">="        {return new Symbol(sHF1.mayorIgual, yycolumn+1,yyline+1,new String(yytext()));}
"<="        {return new Symbol(sHF1.menorIgual, yycolumn+1,yyline+1,new String(yytext()));}
">"        {return new Symbol(sHF1.mayor, yycolumn+1,yyline+1,new String(yytext()));}
"<"        {return new Symbol(sHF1.menor, yycolumn+1,yyline+1,new String(yytext()));}

"+"        {return new Symbol(sHF1.suma, yycolumn+1,yyline+1,new String(yytext()));}
"-"        {return new Symbol(sHF1.resta, yycolumn+1,yyline+1,new String(yytext()));}
"*"        {return new Symbol(sHF1.por, yycolumn+1,yyline+1,new String(yytext()));}
"/"        {return new Symbol(sHF1.div, yycolumn+1,yyline+1,new String(yytext()));}
"^"        {return new Symbol(sHF1.pot, yycolumn+1,yyline+1,new String(yytext()));}
"%"        {return new Symbol(sHF1.mod, yycolumn+1,yyline+1,new String(yytext()));}
"++"        {return new Symbol(sHF1.concat, yycolumn+1,yyline+1,new String(yytext()));}
"!!"        {return new Symbol(sHF1.indice, yycolumn+1,yyline+1,new String(yytext()));}
"$"        {return new Symbol(sHF1.dolar, yycolumn+1,yyline+1,new String(yytext()));}

//{pip}    {return new Symbol(sHF1.pip, yycolumn+1,yyline+1,new String(yytext()));}
//{ent}    {return new Symbol(sHF1.num, yycolumn+1,yyline+1,new String(yytext()));}
{deci}    {return new Symbol(sHF1.decimal, yycolumn+1,yyline+1,new String(yytext()));}
{id}    {return new Symbol(sHF1.id, yycolumn+1,yyline+1,new String(yytext()));}
{caracterC}    {return new Symbol(sHF1.caracter, yycolumn+1,yyline+1,new String(yytext()));}
//{path}    {System.out.println("path -->" +yytext()); return new Symbol(sHF1.path, yycolumn+1,yyline+1,new String(yytext()));}
//{arUlx}   {return new Symbol(sHF1.arTerminales, yycolumn+1,yyline+1,new String(yytext()));}
{cadena}   {return new Symbol(sHF1.cadena, yycolumn+1,yyline+1,new String(yytext()));}
//{comentario}   {}


/* BLANCOS */
[" "|\t|\r|\f|\n]+  {}

.                   {
                        System.out.println("Error Lexico -> Simbolo: \""+yytext()+"\" Linea: "+(yyline+1)+" Columna: "+(yycolumn+1) );
                    //    pantallaPincipal.errorLexLienzo(yytext(),""+ yycolumn,""+ yyline, "Lexico");
                     //tabla_Errores.add(new TokenError("Lexico","Lexema no pertenece al lenguaje",yytext(),String.valueOf(yyline+1),String.valueOf(yycolumn+1)));
//ventanaPrincipal.errorGlobal(yytext(),String.valueOf(yychar),String.valueOf(yyline),"Lexico");                      
}
