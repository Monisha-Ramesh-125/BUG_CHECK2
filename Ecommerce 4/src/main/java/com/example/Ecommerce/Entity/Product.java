package com.example.Ecommerce.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products",

      uniqueConstraints = { @UniqueConstraint(
                name = "sku_unique",
                columnNames = "stock keeping unit"
        )}
)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="stock keeping unit",nullable = false)
    private String sku;
  //  @NotNull// is for Bean Validation to ensure that a field value is not null.
    @NotBlank//is for Bean Validation to ensure that a string value is not null and not just whitespace.
    private String name;
    @NotBlank
    @Size(min = 6, message = "Product description must contain atleast 6 characters")
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    private double discount;
    private double specialPrice;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JsonIgnore
//    private User seller;

    @ManyToOne
    @JoinColumn(name="category_id",referencedColumnName = "id")
    private Category category;
}
