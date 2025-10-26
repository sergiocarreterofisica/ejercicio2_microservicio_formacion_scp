# Microservicio formacion

Desarrollar un microservicio formacion que interaccionará con el microservicio de cursos para ofrecer su funcionalidad.

Los datos que caracterizan una formación serán:

- curso (texto)
- asignaturas (numérico entero)
- precio (numérico decimal)

El servicio ofrecerá los siguientes recursos:

- Devuelve la lista de cursos existentes. Como el microservicio de cursos no dispone del de asignaturas, se seguirá el siguiente algoritmo: Si un curso tiene una duración igual o superior a 50 horas, se considera que tiene 10 asignaturas, sino, serán 5 asignaturas

- Alta curso. A partir de los datos de formación recibidos en el cuerpo, se dará de alta el curso a través del microservicio de cursos, siempre que no exista un curso con el mismo nombre, en cuyo caso no se hará nada. La duración del curso se establecerá según la fórmula: asignaturas*10. En cuanto al código del curso, se generará a partir de los tres primeros caracteres del nombre, seguido de la duración. Ejemplo:

<img width="449" height="110" alt="imagen" src="https://github.com/user-attachments/assets/f6877ae9-8d00-48dc-bf75-6eee7c562f1b" />


