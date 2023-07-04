package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "{nameBlank}")
    private String name;

    @NotBlank(message = "{imageBlank}")
    @Column(name = "image")
    private String image;

    @NotNull(message = "{priceNull}")
    @Min(value = 0, message = "{priceMin}")
    @Column(name = "price")
    private Integer price;

    @Valid
    @ManyToOne
    @JoinColumn(name="Categoryid")
    Category category;

    @Temporal(TemporalType.DATE)
    @Column(name = "Createdate", nullable = false)
    private Date createdate = new Date();

    @NotNull(message = "{quantityNull}")
    @Min(value = 0, message = "{quantityMin}")
    @Column(name = "available")
    private Integer available;

}
