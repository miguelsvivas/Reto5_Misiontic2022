package utp.misiontic2022.c2.p21.reto4.modelo.vo;

public class Requerimiento_1 {
    
    private String nombreMaterial;
    private Integer precioUnidad;


    public Requerimiento_1(){

    }


    public String getNombreMaterial(){
        return nombreMaterial;
    }

    public Integer getPrecioUnidad(){
        return precioUnidad;
    }

    public void setNombreMaterial(String nombrematerial){
        this.nombreMaterial = nombrematerial;
    }

    public void setPrecioUnidad(Integer preciounidad){
        this.precioUnidad = preciounidad;
    }


}
