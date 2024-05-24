var numeroAdivinar=Math.floor((Math.random()*100)+1);
var nintentos=5;

function adivinarNumero(){

    if(nintentos >= 0){
        var numero=document.getElementById("numero").value;
        //Ver si es mayor o menor y escribir si es mayor o menor en p
        var resultado = "";
        if (numero > numeroAdivinar){
            resultado = "El número "+ numero +" es mayor";
        }else if (numero < numeroAdivinar ){
            resultado = "El número "+ numero +" es menor";
        }else{
            resultado = "Felicidades!, has adivinado el número.";
        }
        document.getElementById("demo").innerHTML= resultado + "["+nintentos +" / 5]";
        nintentos--;
    }else{
        document.getElementById("demo").innerHTML= "Superaste el número de intentos!. El número era: "+ numeroAdivinar;
    }
    

}

