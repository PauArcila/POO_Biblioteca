# POO_Biblioteca

Aplicación Java que permite acceder a un sistema de reservas de libros y películas

Funcionalidades:
1. Inicio de sesión con rut y claves existentes en archivo excel
2. Al iniciar sesión correctamente se accede al menú que permite:
2.1. Reservar un artículo: Se ingresa el código del artículo y se genera la reserva siempre que su estado sea "disponible" o "no reservado". 
2.2. Buscar un artículo: se muestran libros y películas que contengan en su nombre el texto buscado.
2.0. Salir

Se aplican conceptos de POO y patrón sigleton para la sincronización de reservas.
Una vez realizadas las operaciones de reserva, se actualiza el archivo excel con los nuevos estados de los artículos.

