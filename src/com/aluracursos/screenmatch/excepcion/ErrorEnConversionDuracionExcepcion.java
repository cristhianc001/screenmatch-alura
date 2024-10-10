package com.aluracursos.screenmatch.excepcion;
// cambiar Throwable por RuntimeException, porque con Throwable se nos obliga a
// implementar un throw porque extender de Throwable hereda checked exceptions
public class ErrorEnConversionDuracionExcepcion extends RuntimeException {
    private String mensaje;

    public ErrorEnConversionDuracionExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje; // se sobreescribe para usarse en el try catch
    }
}
