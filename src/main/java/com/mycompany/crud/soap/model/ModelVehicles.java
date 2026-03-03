package com.mycompany.crud.soap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "modelvehicles", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ModelVehicles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "model_name", nullable = false, length = 100)
    private String modelName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false)
    @XmlTransient
    private MarcaVehicle brandId;

    public ModelVehicles() {
    }

    public ModelVehicles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public MarcaVehicle getBrandId() {
        return brandId;
    }

    public void setBrandId(MarcaVehicle brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ModelVehicles)) {
            return false;
        }
        return Objects.equals(id, ((ModelVehicles) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ModelVehicles{id=" + id + ", modelName='" + modelName + "'}";
    }
}
