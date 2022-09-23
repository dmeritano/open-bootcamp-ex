# MEDIDAS DE SEGURIDAD EN SPRING

## CSRF

Cross-Site Request Forgery



## XSS

Secuencia de comandos entre sitios

Se inyecta una secuencia de comando malintencionados en un sitio web por lo general 
a través de un input para enviar un código malicioso

### Medidas  (Spring las agrega por defecto)
* Control de Cache
* Opciones de tipo de contenido
* Seguridasd de transporte estricta de HTTP
* Opciones X-Frame
* Proteccion X-XSS


### SQL Injection

```sql
update ....
delte .....
```
Spring Data JPA lo controla, pero si se trabajase mas a bajo nivel (Como por ejemplo con JDBC) ...
ahí si habría que controlarlo.

 
