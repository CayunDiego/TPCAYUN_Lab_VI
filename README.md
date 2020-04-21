# TPCAYUN_Lab_VI
Trabajo práctico de la materia Laboratorio VI (UTN) Página web de venta de productos cuenta corriente

**Tema 2**

**Consigna**

Un almacén nos solicita un sistema con interfaz web para administrar todas las operaciones
de cuenta corriente (es decir, al fiado) que efectúan sus clientes de confianza.
Para ello dispone de la lista de precios completa de los artículos que tiene a la venta, los
cuales a su vez están categorizados en rubros. Por cada cliente a quien el almacén le da
fiado conoce sus datos generales (nombre, domicilio, teléfono, etc. ) y el saldo adeudado.
Cada vez que un cliente le compra y no le paga, registra todos los datos de la venta, como
en un sistema de facturación, es decir, que registra los datos de la venta (tales como fecha
e importe total) y por cada ítem vendido su código, la cantidad y el precio vigente al día de
la operación. Periódicamente los clientes efectúan pagos para cancelar total o parcialmente
el saldo adeudado. En esa ocasión se debe registrar en el sistema la fecha y el total
abonado, y actualizar el saldo del cliente.
Dado que la inflación perjudica al negocio, ocasionalmente se requiere incluir algún tipo de
actualización en los importes adeudados, entonces el negocio puede seleccionar algunos o
todos los clientes con deuda y aplicarles un interés que se calcula como un porcentaje
simple solbre el total adeudado por cada uno de ellos. En tal ocasión se debe registrar la
fecha, el porcentaje de incremento aplicado y actualizar el saldo de los clientes afectados.
Finalmente, y dado que el sistema va a poseer almacenados los datos completos de los
artículos que hay a la venta, el dueño nos pide ofrecer un catálogo de los mismos, que
pueda ser accesible desde el sitio web sin ingresar con clave. Este catálogo debe mostrar
los artículos incluyendo al menos una foto y permitir filtrarlos por rubro así como efectuar
búsquedas por nombre.
En la sección de administración, la cual sí debe ingresarse con algún mecanismo de
autenticación, deben ofrecerse al menos las siguientes funcionalidades:
- ABMC de artículos.
- ABMC de clientes.
- ABMC de rubros.
- Registración de compras.
- Registración de pagos.
- Actualización de saldos.
* Reportes:
  * Listado de clientes completo (distinguiendo los que tienen el saldo totalmente
  cancelado), incluyendo sumatoria de compras y de pagos.
  * Listado de pagos realizados en los últimos 30 días.
  * Listado de operaciones (compras, pagos y recargos) de un cliente en
particular.
  * Seleccionar un rubro y mostrar el listado de artículos, incluyendo por cada
uno cantidad de veces que fue vendido, cantidad total de unidades vendidas
y cantidad de clientes a los que fue vendido.
