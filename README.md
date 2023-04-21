# evaluacion-individual-Electiva2
## Acceso

http://localhost:8080/

## Rutas
Para GET bills:
- /bills Retorna todos los elementos guardados en bills
- /bills/{id} Retorna el elemento con un id especifico
- /bills/customer/{id} Retorna las facturas de un cliente
- /bills/pay/{id} Retorna las facturas por tipo de pago
- /bills/datebill/{start}/{end} Retorna las facturas en un rango de fechas

Para POST, PUT y DELETE respectivamente
- /bills/{id} Envia y guarda los datos ingresados
- /bills/{id} Actualiza el id con los datos ingresados
- /bills/{id} Elimina los datos con el id ingresado

Para GET customers:
- /customers Retorna todos los elementos guardados en customers
- /customers/{id} Retorna el elemento con un id especifico

Para POST, PUT y DELETE respectivamente
- /customers/{id} Envia y guarda los datos ingresados
- /customers/{id} Actualiza el id con los datos ingresados
- /customers/{id} Elimina los datos con el id ingresado
## Autor
Diego Alejandro Corredor Rojas