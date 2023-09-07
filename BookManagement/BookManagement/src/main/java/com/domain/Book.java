package com.domain;

import java.text.DecimalFormat;

public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
    private String price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(float price) {
        DecimalFormat df1 = new DecimalFormat("#.00");//保留两位小数，如果是零点几，则小数点前的0不显示，小数点后几个零就保留几位

        this.price = df1.format(price);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
