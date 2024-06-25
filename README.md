# Practica Quarkus + CRUD

Este proyecto usa el Framework de Quarkus en su version 3.11.3, utilizando Java 17.
Contiene un api basica asociado a Libros, contiene las operaciones basicas:

- Guardar
- Listar
- Buscar objeto por identificador
- Actualizar
- Borrar

## Caracteristicas
En el proyecto se encuentra escrito, un servicio generico que contiene las operaciones de CRUD, permitiendo la reutilizacion de codigo.
Para usar este servicio generico, es necesario crear un Entity, un DTO, un Mapper (convertir Entity a DTO y viceversa) y un repositorio.

Reutilizando este servicio generico, nuestro servicio a crear estara mas limpio, evitando crear estos metodos recurrentes.

### Para iniciar la aplicacion en modo dev

Tu puedes iniciar la aplicacion en modo dev con cambios automaticos usando el siguiente codigo
```shell script
./mvnw compile quarkus:dev
```

