package com.mycompany.crud.soap.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "vehicles", schema = "public")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Vehicles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false)
    @XmlTransient
    private MarcaVehicle brandId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "model_id", nullable = false)
    @XmlTransient
    private ModelVehicles modelId;

    public Vehicles() {
    }

    public Vehicles(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MarcaVehicle getBrandId() {
        return brandId;
    }

    public void setBrandId(MarcaVehicle brandId) {
        this.brandId = brandId;
    }

    public ModelVehicles getModelId() {
        return modelId;
    }

    public void setModelId(ModelVehicles modelId) {
        this.modelId = modelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicles)) {
            return false;
        }
        return Objects.equals(id, ((Vehicles) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vehicles{id=" + id + ", brandId=" + brandId + ", modelId=" + modelId + "}";
    }
}
