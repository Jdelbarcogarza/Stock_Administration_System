import java.util.*;
import java.util.Scanner;

public class ProyectoFinal {

public static void main(String[] args) {
    
//se declaran variables para el programa
Scanner kb = new Scanner (System.in);
String opcion;
boolean optionSelection = false;
ArrayList<Integer> clave = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9,10));

ArrayList<String> colorCubrebocas = new ArrayList<>(Arrays.asList("AZUL", "ROJO", "VERDE", "MORADO","AMARILLO","MAGENTA","ROSA","BLANCO","CELESTE","NEGRO"));

ArrayList<Double> precio = new ArrayList<>(Arrays.asList(9.99, 9.99, 14.99, 14.99, 19.99, 19.99,24.99,24.99,29.99,29.99));

ArrayList<Integer> cantidad = new ArrayList<>(Arrays.asList(13,26,24,23,11,3,32,44,20,22));
boolean SystemOn = true;


//el primer "do" es para repetir todo el programa mientras SystemOn sea true, si se selecciona "F" se apaga el código.
do{
// se despliega menú
    do{

            System.out.println();
            System.out.println("ProMaskMx: Stock Administration System");
            System.out.println("----------------------------------------------");
            System.out.println();

            System.out.println("Menú de operaciones del sistema:");
            System.out.println();
            System.out.println("A) Altas");
            System.out.println("B) Bajas");
            System.out.println("C) Cambios");
            System.out.println("D) Listado");
            System.out.println("E) Venta");
            System.out.println("F) Salir");
            System.out.println();
            System.out.println("Elige una de las letras anteriores");

            opcion = kb.nextLine();
            opcion = opcion.toUpperCase();
            
        if (opcion.equals("A") || opcion.equals("B") || opcion.equals("C") || opcion.equals("D") || opcion.equals("E") || opcion.equals("F")){
            optionSelection = true;
        }else optionSelection = false;

        }while(optionSelection == false);
    // se accesa a los métodos
    switch(opcion){
            case "A": altas(kb, clave, colorCubrebocas, precio, cantidad); break;
            case "B": bajas(kb, clave, colorCubrebocas, precio, cantidad); break; //aqui la arrayLength ya no se necesita pq no se puede modificar
            case "C": cambios(kb, clave, colorCubrebocas, precio, cantidad); break;                                     
            case "D": listado(kb, clave, colorCubrebocas, precio, cantidad); break;
            case "E": venta(kb, clave, colorCubrebocas, precio, cantidad); break;
            case "F": System.out.println("Gracias, hasta pronto"); SystemOn = false; break;
                
            default: System.out.println("Intenta con un número del 1 al 5");

            }

        }while(SystemOn);

}// cierra main

// sección de métodos

public static void altas(Scanner kb, ArrayList<Integer> clave, ArrayList<String> colorCubrebocas, ArrayList<Double> precio, ArrayList<Integer> cantidad){

    int new_clave;
    String new_colorCubrebocas;
    double new_precio;
    int new_cantidad;
    String exit;
    
    do{
    
        System.out.println("Agregar productos al inventario");
        System.out.println("-------------------------------");
        System.out.println();

        System.out.println("Llene los datos para dar de alta el producto");
        System.out.println();

    System.out.println("Clave: "); 
    
        new_clave = kb.nextInt();
        clave.add(new_clave);
        kb.nextLine();
    
    System.out.println("Nombre:");
    
        new_colorCubrebocas = kb.nextLine();
        new_colorCubrebocas = new_colorCubrebocas.toUpperCase();
        colorCubrebocas.add(new_colorCubrebocas);
    
    System.out.println("Precio:");
    
        new_precio =kb.nextDouble();
        precio.add(new_precio);
    
    System.out.println("Cantidad:");
    
        new_cantidad = kb.nextInt();
        cantidad.add(new_cantidad);
    
    
    kb.nextLine();
    System.out.println();
    
    System.out.println("El producto ha sido dado de alta");
    System.out.println();
    System.out.println("¿Desea añadir otro producto al inventario? (S/N)");
    
    exit = kb.nextLine();
    exit = exit.toUpperCase();
    
    
    }while(exit.equals("S"));
        

    
    }

public static void bajas(Scanner kb, ArrayList<Integer> clave, ArrayList<String> colorCubrebocas, ArrayList<Double> precio, ArrayList<Integer> cantidad){
    
    String exit;
    int optionSelection;
    int claveDeElemento;
    String nombreDeElemento;

    do{
        System.out.println("Eliminar un producto del inventario");
        System.out.println("----------------------------------");
        System.out.println();
        
        System.out.println("Buscar producto por:");
        System.out.println("1) Clave");
        System.out.println("2) Nombre");
        System.out.println("3) Regresar al menú");
    
        
        do{
            optionSelection = kb.nextInt();
                kb.nextLine();
            
            if(optionSelection == 1){

                System.out.println("Ingrese la clave del elemento a borrar (solo numeros):");
                System.out.println();
                claveDeElemento = kb.nextInt();
                kb.nextLine();

                for(int i = 0; i<clave.size();i++){

                    if(clave.get(i) == claveDeElemento){

                        clave.remove(i);
                        colorCubrebocas.remove(i);
                        precio.remove(i);
                        cantidad.remove(i);

                        System.out.println("El producto ha sido eliminado con éxito");
                        System.out.println();
                        break;
                            
                    } else
                        System.out.println("Analizando...");
                        
                }

             
                
            }else if(optionSelection==2){
                
                System.out.println("Ingrese el nombre del producto a borrar:");
                System.out.println();
                    nombreDeElemento = kb.nextLine();
                    
                    nombreDeElemento = nombreDeElemento.toUpperCase();

                        for(int i = 0; i<colorCubrebocas.size();i++){

                            if(colorCubrebocas.get(i).equals(nombreDeElemento)){
                                
                                clave.remove(i);
                                colorCubrebocas.remove(i);
                                precio.remove(i);
                                cantidad.remove(i);

                                System.out.println("El producto ha sido eliminado con éxito");
                                break;
                            }else 

                                System.out.println("Analizando...");

                        }
                    

            }else if(optionSelection == 3) {
                exit="N";
            }
    
            if(!(optionSelection == 1 || optionSelection == 2 || optionSelection == 3)){
                System.out.println("Debes de elegir una de las 3 opciones");
            }
    
        }while(!(optionSelection == 1 || optionSelection == 2 || optionSelection == 3));


        System.out.println("¿Desea eliminar otro producto del inventario? (S/N)");
        exit = kb.nextLine();
        exit = exit.toUpperCase();

    }while(exit.equals("S"));
}

public static void cambios(Scanner kb, ArrayList<Integer> clave, ArrayList<String> colorCubrebocas, ArrayList<Double> precio, ArrayList<Integer> cantidad){
    
   
    String exit;
    int optionSelection;
    int new_clave;
    String new_colorCubrebocas;
    double new_precio;
    int new_cantidad;
    int claveDeElemento;
    String nombreDeElemento;

    do{
        System.out.println("Cambiar la información de un producto");
        System.out.println();
        System.out.println("Buscar producto por:");
        System.out.println("1) Clave");
        System.out.println("2) Nombre");
        System.out.println("3) Regresar al menú");

        do{
            optionSelection = kb.nextInt();
                kb.nextLine();
            
            if(optionSelection == 1){

                System.out.println("Ingrese la clave del elemento para modificar los datos (solo numeros):");
                System.out.println();
              
                claveDeElemento = kb.nextInt();

                for(int i = 0; i<clave.size();i++){

                    if(clave.get(i) == claveDeElemento){

                        System.out.println("Modifique los datos del producto");

                                System.out.println();

                            System.out.println("Clave: "); 
                            
                                new_clave = kb.nextInt();
                                clave.add(i,new_clave);
                                kb.nextLine();
                            
                            System.out.println("Nombre:");
                            
                                new_colorCubrebocas = kb.nextLine();
                                new_colorCubrebocas = new_colorCubrebocas.toUpperCase();
                                colorCubrebocas.add(i,new_colorCubrebocas);
                            
                            System.out.println("Precio:");
                            
                                new_precio =kb.nextDouble();
                                precio.add(i,new_precio);
                            
                            System.out.println("Cantidad:");
                            
                                new_cantidad = kb.nextInt();
                                cantidad.add(i,new_cantidad);
                            
                            
                            kb.nextLine();
                            System.out.println();
                            
                            System.out.println("El producto ha sido dado de alta");
                            System.out.println();

                        break;
                            
                    } else
                        System.out.println("Analizando...");
                        
                }

             
                
            }else if(optionSelection==2){
                
                System.out.println("Ingrese el nombre del producto a modificar:");
                System.out.println();
                    
                    nombreDeElemento = kb.nextLine();
                    kb.nextLine();

                for(int i = 0; i<clave.size();i++){

                    if(colorCubrebocas.get(i).equals(nombreDeElemento)){

                        System.out.println("Modifique los datos del producto");

                                System.out.println();

                            System.out.println("Clave: "); 
                            
                                new_clave = kb.nextInt();
                                clave.add(i,new_clave);
                                kb.nextLine();
                            
                            System.out.println("Nombre:");
                            
                                new_colorCubrebocas = kb.nextLine();
                                new_colorCubrebocas = new_colorCubrebocas.toUpperCase();
                                colorCubrebocas.add(i,new_colorCubrebocas);
                            
                            System.out.println("Precio:");
                            
                                new_precio =kb.nextDouble();
                                precio.add(i,new_precio);
                            
                            System.out.println("Cantidad:");
                            
                                new_cantidad = kb.nextInt();
                                cantidad.add(i,new_cantidad);
                            
                            
                            kb.nextLine();
                            System.out.println();
                            
                            System.out.println("El producto ha sido dado de alta");
                            System.out.println();

                        break;
                            
                    } else
                        System.out.println("Analizando...");
                        
                }
                       
                    

            }else if(optionSelection == 3) {
                exit="N";
            }
    
            if(!(optionSelection == 1 || optionSelection == 2 || optionSelection == 3)){
                System.out.println("Debes de elegir una de las 3 opciones");
            }
    
        }while(!(optionSelection == 1 || optionSelection == 2 || optionSelection == 3));

        System.out.println("¿Desea cambiar datos otro producto? (S/N)");
        exit = kb.nextLine();
        exit = exit.toUpperCase();

    }while(exit.equals("S"));
    
}

public static void listado(Scanner kb, ArrayList<Integer> clave, ArrayList<String> colorCubrebocas, ArrayList<Double> precio, ArrayList<Integer> cantidad){
    
    String exit;
    int optionSelection;

    do{

        System.out.println("Visualizar inventario en un orden específico");
        System.out.println();
        System.out.println("Ordenar productos por:");
        System.out.println("1) Clave");
        System.out.println("2) Nombre");
        System.out.println("3) Regresar al menú");

        optionSelection = kb.nextInt();
        kb.nextLine();
        do{
        
            
        if(optionSelection == 1){
            for(int i = 0; i<clave.size();i++){
            System.out.println("Clave: "+"\""+clave.get(i)+"\""+" Nombre:   "+"\""+colorCubrebocas.get(i)+"\""+"    Precio:    "+"\""+ precio.get(i)+"\""+"     Cantidad:  "+"\""+cantidad.get(i)+"\"");
            }
        }else if(optionSelection==2){
            for(int i = 0; i<clave.size();i++){
                System.out.println("Nombre: "+"\""+colorCubrebocas.get(i)+"\""+" Clave:   "+"\""+clave.get(i)+"\""+"    Precio:    "+"\""+ precio.get(i)+"\""+"     Cantidad:   "+"\""+cantidad.get(i)+"\"");
                }
        }else if(optionSelection == 3) {
            exit="N";
        }

        if(!(optionSelection == 1 || optionSelection == 2 || optionSelection == 3)){
            System.out.println("Debes de elegir una de las 3 opciones");
        }

    }while(!(optionSelection == 1 || optionSelection == 2 || optionSelection == 3));

        System.out.println("¿Desea ver los datos en otro orden? (S/N)");
        exit = kb.nextLine();
        exit = exit.toUpperCase();

    }while(exit.equals("S"));

}


public static void venta(Scanner kb, ArrayList<Integer> clave, ArrayList<String> colorCubrebocas, ArrayList<Double> precio, ArrayList<Integer> cantidad){

    String exit;
    int optionSelection;
    int claveDeElemento;
    String nombreDeElemento;
    int cuantosProductos;
    ArrayList<String> queProductos = new ArrayList<String>();
    ArrayList<Double> preciosTotales = new ArrayList<Double>();
    ArrayList<Integer> cuantosProductosArray = new ArrayList<Integer>();
    double dineroRecibido;
    double dineroDeCambio;
    double costoTotal = 0;
    int nuevaCantidad;
    double costoAcumulado = 0;



    do{

        System.out.println("Venta de objetos en el inventario");
        System.out.println();
        System.out.println("Seleccionar producto a vender por:");
        System.out.println("1) Clave");
        System.out.println("2) Nombre");
        System.out.println("3) Regresar al menú");

        optionSelection = kb.nextInt();
        kb.nextLine();

        if(optionSelection == 1){

            do{

                System.out.println("Ingrese la clave del elemento a vender (solo numeros):");
                System.out.println();
                claveDeElemento = kb.nextInt();
                kb.nextLine();

            //por aqui en medio debohacer la actualizacion del inventario si no no va a jalar.

            for(int i = 0; i<clave.size();i++){

                if(clave.get(i) == claveDeElemento){

                    do{

                        System.out.println("El cubrebocas: "+colorCubrebocas.get(i)+"   ("+cantidad.get(i)+" en existencia)"+" tiene un precio de "+precio.get(i));



                        System.out.println("Cuantos quiere?");
                        cuantosProductos = kb.nextInt();
                        kb.nextLine();

                        if(cuantosProductos>cantidad.get(i)){
                            System.out.println();
                            System.out.println("No tenemos tantos productos en existencia");
                            System.out.println();
                        }

                }while(cuantosProductos>cantidad.get(i));

                    cuantosProductosArray.add(cuantosProductos);
                    costoTotal = cuantosProductos*precio.get(i);
                    preciosTotales.add(costoTotal);
                    queProductos.add(colorCubrebocas.get(i));
                    System.out.println("El producto ha sido agregado al carrito");

                    //aqui se actualiza el inventario.
                    nuevaCantidad = cantidad.get(i)-cuantosProductos;
                    cantidad.add(i,nuevaCantidad);
                    
                    break;
        
                } else
                    System.out.println("Analizando...");
                    
            }

            System.out.println("¿Desea añadir otro producto al carrito? (S/N)");
    
            exit = kb.nextLine();
            exit = exit.toUpperCase();
    
        }while(exit.equals("S"));

        System.out.println("Los productos a comprar son:");
        System.out.println();
        for(int i = 0; i<queProductos.size();i++){
            System.out.println("* "+queProductos.get(i)+" cantidad: "+cuantosProductosArray.get(i)+ " total por este producto "+preciosTotales.get(i));
        }

    for(int i = 0; i<preciosTotales.size();i++){
        costoAcumulado += preciosTotales.get(i);
    }


        do{

            System.out.println("Su total de compra es: $"+costoAcumulado);
            System.out.println();
            System.out.println("Con cuanto va a pagar?");
            dineroRecibido = kb.nextDouble();
            kb.nextLine();
            if(dineroRecibido>=costoAcumulado){

            dineroDeCambio = Math.abs(dineroRecibido-costoAcumulado);
            System.out.println("Su cambio es: "+dineroDeCambio);

            }else if(dineroRecibido<costoAcumulado){
                System.out.println("Le faltan "+Math.abs(costoAcumulado-dineroRecibido)+" pesos a pagar");
            }

        }while(dineroRecibido<costoAcumulado);
//opcion 2 por nombre
        }else if(optionSelection==2){
            
            do{

                System.out.println("Ingrese el nombre del elemento a vender:");
                System.out.println();
                nombreDeElemento = kb.nextLine();
                nombreDeElemento = nombreDeElemento.toUpperCase();


            for(int i = 0; i<clave.size();i++){

                if(colorCubrebocas.get(i).equals(nombreDeElemento)){
                    
                    do{

                        System.out.println("El cubrebocas: "+colorCubrebocas.get(i)+"   ("+cantidad.get(i)+" en existencia)"+" tiene un precio de "+precio.get(i));



                        System.out.println("Cuantos quiere?");
                        cuantosProductos = kb.nextInt();
                        kb.nextLine();

                        if(cuantosProductos>cantidad.get(i)){
                            System.out.println();
                            System.out.println("No tenemos tantos productos en existencia");
                            System.out.println();
                        }

                }while(cuantosProductos>cantidad.get(i));



                    cuantosProductosArray.add(cuantosProductos);
                    costoTotal = cuantosProductos*precio.get(i);
                    preciosTotales.add(costoTotal);
                    queProductos.add(colorCubrebocas.get(i));
                    System.out.println("El producto ha sido agregado al carrito");

                    //aqui se actualiza el inventario.
                    nuevaCantidad = cantidad.get(i)-cuantosProductos;
                    cantidad.add(i,nuevaCantidad);
                    
                    break;
        
                } else
                    System.out.println("Analizando...");
                    
            }

            System.out.println("¿Desea añadir otro producto al carrito? (S/N)");
    
            exit = kb.nextLine();
            exit = exit.toUpperCase();
    
        }while(exit.equals("S"));

        System.out.println("Los productos a comprar son:");
        System.out.println();
        for(int i = 0; i<queProductos.size();i++){
            System.out.println("* "+queProductos.get(i)+" cantidad: "+cuantosProductosArray.get(i)+ " total por este producto "+preciosTotales.get(i));
        }

    for(int i = 0; i<preciosTotales.size();i++){
        costoAcumulado += preciosTotales.get(i);
    }


        do{

            System.out.println("Su total de compra es: $"+costoAcumulado);
            System.out.println();
            System.out.println("Con cuanto va a pagar?");
            dineroRecibido = kb.nextDouble();
            kb.nextLine();
            if(dineroRecibido>=costoAcumulado){

            dineroDeCambio = Math.abs(dineroRecibido-costoAcumulado);
            System.out.println("Su cambio es: "+dineroDeCambio);

            }else if(dineroRecibido<costoAcumulado){
                System.out.println("Le faltan "+Math.abs(costoAcumulado-dineroRecibido)+" pesos a pagar");
            }

        }while(dineroRecibido<costoAcumulado);


                
        }else if(optionSelection == 3) {
            exit="N";
        }

    }while(!(optionSelection ==  1 || optionSelection == 2 || optionSelection == 3));

}

}// cierra clase