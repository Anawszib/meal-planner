package pl.edu.wszib.jwd.mealplanner.model;

import javax.persistence.*;


@Entity
@Table(name = "Dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double energy;
    private Double protein;
    private Double carbohydrates;
    private Double fat;
    private Double fiber;
    private Double salt;
    @Column(length = 400)
    private String image;

    public Dish() {
    }

    public Dish(String name) {
        this.name = name;
    }

    public Dish(Integer id, String name, Double energy, Double protein, Double carbohydrates, Double fat, Double fiber, Double salt, String image) {
        this.id = id;
        this.name = name;
        this.energy = energy;
        this.protein = protein;
        this.carbohydrates = carbohydrates;
        this.fat = fat;
        this.fiber = fiber;
        this.salt = salt;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getFiber() {
        return fiber;
    }

    public void setFiber(Double fiber) {
        this.fiber = fiber;
    }

    public Double getSalt() {
        return salt;
    }

    public void setSalt(Double salt) {
        this.salt = salt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


