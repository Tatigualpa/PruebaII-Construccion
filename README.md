# PruebaII-Construccion
# API de Inventario
Este proyecto implementa una API de inventario utilizando Spring Boot que permite consultar productos, agregar nuevos productos y actualizar las cantidades en stock. La API incluye validaciones para manejar entradas no válidas, y utiliza programación defensiva, por contrato y aserciones para garantizar la correcta ejecución del código.

## Requisitos
Antes de ejecutar el proyecto, asegúrate de tener los siguientes programas instalados:
    Java
    Apache Maven

## Clonar el Proyecto:
Si aún no tienes el proyecto, clónalo.

## Ejecutar la Aplicación:
Abre una terminal y navega al directorio raíz del proyecto.
Ejecuta el siguiente comando para compilar y arrancar la aplicación:
    mvn spring-boot:run
La aplicación estará disponible en http://localhost:8080.

## Endpoints de la API:
    GET /producto/{id_producto}: Consulta un producto por su ID, devolviendo su nombre y cantidad disponible.
    POST /producto: Agrega un nuevo producto al inventario. El cuerpo de la solicitud debe contener el nombre del producto y la cantidad inicial.
    PUT /producto/{id_producto}: Actualiza la cantidad de un producto existente. El cuerpo de la solicitud debe contener la nueva cantidad.
    
## Pruebas:
Para ejecutar las pruebas unitarias del proyecto, usa el siguiente comando:
    mvn test

## Tecnologías Utilizadas
Spring Boot: Framework para crear aplicaciones Java.
Maven: Herramienta de gestión de dependencias.
Java: Lenguaje de programación.
