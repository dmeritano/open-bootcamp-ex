# Patrones de diseño

----

Se dividen en 3 grupos

## <u>Creacionales</u>

### Singleton

#### Características
* Solo se puede instanciar una vez (single-instance)
* No se debe instanciar si nunca fue utilizada
* Es thread-safe, que quiere decir que sus métodos son accesibles desde diferentes hilos de ejecución, sin crear bloqueos ni excepciones debido a la concurrencia
* No tiene un constructor público, luego el objeto que la usa no puede instanciarla directamente
* Posee un mecanismo para acceder a la instancia que se ha creado (mediante una propiedad estática, por ejemplo)

#### Caso de uso
En una aplicación donde se conectan varios clientes remotos se puede usar singleton para manejar
la instancia de conexión a la BD. El primer cliente que se conecta crea la instancia y los siguientes utilizan dicha instancia. 


### Builder

#### Características
* Permite construir un objecto complejo paso a paso, utilizando y encadenando otros objetos mas simples. 
* Se utiliza en situaciones en las que debe construirse un objeto repetidas veces o cuando este objeto tiene gran cantidad de atributos y objetos asociados, y en donde es incómodo el uso de constructores.

#### Caso de uso
Dada una clase Usuario, con varios métodos y propiedades asociadas que permiten construir el objecto
final, se puede crear una clase UsuarioBuilder para lograrlo de forma más cómoda.
```
public static void main(String[] args) {
    Usuario usuario = new UsuarioBuilder()
        .setEmail("carlos.logpez@gmail.com")
        .setNombre("Carlos", "Lopez")
        .setTelefono("+1 58 54654 13")
        .setDireccion("Ruta 55, No. 10")
        .agregarRol(ROLE_USER)
        .build();   
}
```


### Factory
#### Características
* El patrón Factory describe un enfoque de programación que permite para crear objetos sin tener que especificar su clase exacta. Esto permite que el objeto creado pueda intercambiarse con flexibilidad y facilidad.
#### Caso de uso

Un uso podría ser una tienda virtual que inicia aceptando pagos por Paypal y Mercadopago, pero contempla agregar mas adelante otros medios de pago como Tarjeta de Crédito y Tarjeta de Débito.
La idea es que desde una clase principal se instancie clase Factory, pasando a su contructor la forma de pago:

```
    FactoryPagos pago = new FactoryPagos("Paypal")  o  FactoryPagos pago = new FactoryPagos("Mercadopago") 
```
La clase Factory devuelva una instancia de la pasarela de pago asociada al parametro recibido en el constructor.
A su vez, las clases Paypal y Mercadopago implementarán una interface con un metodo, por ejemplo

```
    hacerPago()
```
Internamente las clases Paypal y Mercadopago implementarán el pago de la forma que corresponda.

Para resumir, desde la clase principal los métodos a llamar serían:

```
FactoryPagos pago = new FactoryPagos("Paypal") 
pago.hacerPago();
```

### Prototype

#### Características

* Permite crear nuevos objetos duplicándolos objetos ya existentes(instanciados). 

#### Caso de uso

Se podría aplicar a un sistema con objetos con datos repetitivos en cuanto a sus atributos: 
por ejemplo, para una tienda de pinturas que posee una gran cantidad de obras de un mismo autor, pais de origen, tipo de pintura.
Al momento de crear una nueva instancia de "Pintura" para un mismo autor, pais, etc, se podría partir
de una instancia ya existente y obtener una copia/clon de Pintura con varios datos ya completados.


## <u>Estructurales</u>

### Adapter
#### Características
* Busca una manera estandarizada de adaptar un objeto a otro. Se utiliza para transformar una interfaz en otra, de tal modo que una clase que no pudiera utilizar la primera, haga uso de ella a través de la segunda. 
* Al patrón Decorator también se lo llama Wrapper, igual que al patrón Decortor.
* Utilizar Adapters hace que nuestro código sea más flexible y tolerante al cambio

#### Caso de uso

Crear una adaptador para serializar o deserializar JSON (AdapterJson), con que cumplen con una interfaz "Serializador", tales como serializar() y deserializar().
Si en algún momento necesitmaos procesar tambien XML, crearemos un AdapterXml que tambien implementará los métodos
serializar() y deserialzar() de la interface Serializador, pero efectuará los procesos de la forma relacionada con XML en vez de JSON. 


### Decorator
#### Características
* Permite añadir responsabilidades a objetos concretos de forma dinámica
* Los decoradores ofrecen una alternativa más flexible que la herencia para extender las funcionalidades

#### Caso de uso
Una concesionaria de automóviles permite al cliente escoger equipamiento opcional (polarizado de vidrios, techo solar, etc), lo cual determinará su precio final.

```
public interface Vehiculo{
    public String getNombreModelo();
    public double getValorDeVenta();
}
public abstract class Auto implements Vehiculo{
    //Atributos propios de los autos
}
public class FordExplorer extends Auto{
    public String getNombreModelo(){
        return "Ford Explorer XLT - 2020"
    }
    public double getValorDeVenta(){
        return 10500.00;
    }
}
public class ChevroletCamaro extends Auto{
    public String getNombreModelo(){
        return "Cheverolet Camaro - 2022"
    }
    public double getValorDeVenta(){
        return 32800.00;
    }
}
public abstract calss VehiculoDecorator implements Vehiculo {
    private Vehiculo vehiculo;
    public VehiculoDecorator(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
}
public class Polarizado extends VehiculoDecorator{
    public Polarizado(Vehiculo vehiculo){
        super(vehiculo);
    }
    public getNombreModelo() {
        return getVehiculo().getNombreModelo() + " + Polarizado de cristales";
    }    
    public double getValorDeVenta(){
        return getVehiculo().getValorDeVenta() + 850;
    }
} 
public class TechoSolar extends VehiculoDecorator{
    public TechoSolar(Vehiculo vehiculo){
        super(vehiculo);
    }
    public getNombreModelo() {
        return getVehiculo().getNombreModelo() + " + Techo solar";
    }    
    public double getValorDeVenta(){
        return getVehiculo().getValorDeVenta() + 1050;
    }
} 
public static void main(String[] args){
    Vehiculo vehiculo = new ChevroletCamaro();
    vehiculo = new TechoSolar(vehiculo);
    vehiculo = new Polarizado(vehiculo);
    System.out.println(vehiculo.getNombreModelo());
    System.out.println("Su valor final es:" + vehiculo.getValorDeVenta();
}
//OUT
Cheverolet Camaro - 2022 + Techo Solar + Polarizado de cristales
Su valor final es: 34700.00
```


### Facade

#### Características
* Es útil cuando se buscan estrategias adecuadas para simplificar un software complejo
* Delega funcionalidades del software a los respectivos subsistemas para que el manejo de los diversos subcomponentes de un programa sea lo más sencillo posible para el usuario que vaya a consumir/usar nuestro sistema.
#### Caso de uso
Está el ejemplo visto en el curso, sobre crear una fachada para la conversión de videos de ogg a mp4 y de mp4 a ogg.  
Los diferentes pasos para realizar la codificación se exponen al usuario final como un método simple (en apariencia) con un par de parametros. La clase Factory se encargará por debajo de realizar todos los pasos y procesos que sean necesarios para realizar la converisón y devolverá simplemente el archivo de video convertido al nuevo formato.



## <u>De Comportamiento</u>

No se han estudiado hasta el momento de presentación de este ejercicio