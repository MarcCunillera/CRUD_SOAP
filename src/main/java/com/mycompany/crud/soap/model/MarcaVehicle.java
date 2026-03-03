package com.mycompany.crud.soap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "marcavehicle", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MarcaVehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand_name", nullable = false, length = 100)
    private String brandName;

    public MarcaVehicle() {
    }

    public MarcaVehicle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MarcaVehicle)) {
            return false;
        }
        return Objects.equals(id, ((MarcaVehicle) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MarcaVehicle{id=" + id + ", brandName='" + brandName + "'}";
    }
}
