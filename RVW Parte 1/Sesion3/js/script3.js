      //Declaracion de variables
	        var num1 = 0;
	        var num2 = 0;
	        var opera;
            var flag = false;

        //Función que concatena el número presionado. Luego refresca el texto
        function darNumero(numero){
            var pantalla = document.querySelector(".cajita_valor");
            if(pantalla.value == 0 && flag === false){refrescar("");}
            refrescar(pantalla.value+numero);
        }

        //Función que coloca la coma al presionar dicho botón. Luego refresca el texto
        function darComa(){
            if(flag != true){
                var pantalla = document.querySelector(".cajita_valor");
                refrescar(pantalla.value+".");
                flag = true;
            }
        }

        //Función que coloca la C al presionar dicho botón. Luego refresca el texto
        function darC(){
            refrescar("0");
            flag = false;
        }

        //Esta función realiza las distintas operaciones aritméticas en función del botón pulsado
        function operar(valor){
            switch (valor){
                case 1:
                    opera="+";
                    break;
                case 2:
                    opera="-";
                    break;
                case 3:
                    opera="*";
                    break;
                case 4:
                    opera="/";
                    break;
                case 5:
                    opera="**";
                    break;
            }

            var pantalla = document.querySelector(".cajita_valor");
            num1 = pantalla.value;
            darC();
            flag = false;
        }

        //Función para pulsar igual. Al final llama a refrescar()
            /*
        	suma = 1
        	resta = 2
        	multiplicacion = 3
        	division = 4
        	potencia = 5
        */

        function esIgual(){
            var pantalla = document.querySelector(".cajita_valor");
            num2 = pantalla.value;
            darC();
            var resultado = eval(num1+" "+opera+" "+num2).toFixed(2);
            refrescar(resultado);
        }
        //Muestra en el cuadro de texto el valor
        function refrescar(valor){
            var pantalla = document.querySelector(".cajita_valor");
            pantalla.value = valor;
        }
