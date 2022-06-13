package com.example.javabase;

import lombok.Getter;
import lombok.Setter;

/**
 * Author saino
 * LastModify 0:47
 */
class fruit {
    public String name;
    public int price;

    public fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}

class apple extends fruit {
    public apple(String name, int price) {
        super(name, price);
    }
    public int getPrice() {
        return super.getPrice();
    }
}

class Jonathan extends apple {
    public Jonathan(String name, int price) {
        super(name, price);
    }
}

class banana extends fruit {
    public banana(String name, int price) {
        super(name, price);
    }
}

class orange extends fruit {
    public orange(String name, int price) {
        super(name, price);
    }
}