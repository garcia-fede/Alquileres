## Sistema de Alquileres
Proyecto realizado con Java, Springboot, Rest API. Modelo MVC

# Objetivos a cumplir

----------------------------------------------------------------------------------------------------------------

Gestion de alquileres de viviendas

La Sociedad Publica de Alquiler dependiente del Ministerio de la Vivienda necesita una base de datos para gestionar los alquileres de las viviendas de particulares. Los requisitos de esta base de datos son los que se detallan a continuación.

+ Es necesario almacenar informacion sobre la duración de cada uno de los
alquileres de una vivienda con el fin de conocer el histórico de alquileres.

+ La información que se guarda de cada alquiler es un identificador único de
alquiler, fecha de inicio, fecha de fin, importe mensual, fianza y fecha de la
firma.

+ Se quiere almacenar información sobre la renovación de un alquiler de una
vivienda. Es necesario saber si un alquiler es una renovación de otro alquiler
anterior o no, con el fin de poder seguir fácilmente la secuencia de
alquileres de una vivienda con la misma persona.

+ Un alquiler es realizado por un inquilino y de cada inquilino se alamacena un identificador único, NIF, nombre, apellidos, fecha de nacimiento y teléfono
de contacto.

+ Es necesario almacenar información sobre las agencias inmobiliarias que
gestionan los alquileres de las viviendas.

+ De cada agencia inmobiliaria se almacena un identificador de agencia, CIF,
dirección y teléfono.

+ Una vivienda solo se oferta en una única agencia inmobiliaria. Una
agencia solo puede gestionar los alquileres de las viviendas ofertadas por
ella.

----------------------------------------------------------------------------------------------------------------

Otros requerimientos:

+ Crear módulo de seguridad
+ Los roles serán ADMIN, USER, Empleado, para definir quien accede a qué opciones  menú.

