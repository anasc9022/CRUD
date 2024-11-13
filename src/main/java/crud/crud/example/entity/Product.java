package crud.crud.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name="product")
@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "in_stock")
    private Boolean inStock;

    @Column(name = "description")
    private String description;

}
