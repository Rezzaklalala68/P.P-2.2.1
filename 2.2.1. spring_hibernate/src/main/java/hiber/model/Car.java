package hiber.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;

    private int series;

    @OneToOne(mappedBy = "User_car", cascade = CascadeType.ALL)
    private User user;
    public Car() {}

    public int getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                ", user=" + user +
                '}';
    }
}
