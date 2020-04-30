package pe.municipalidad.plataforma.entidades;

public class ComplexResponse<T> extends Respuesta {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
