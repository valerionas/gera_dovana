package lt.valentinas.pom.pages;

public class CardProduct<Title, Price> {
    private Title title;
    private Price price;

    public CardProduct(Title title, Price price) {
        this.title = title;
        this.price = price;
    }

    public CardProduct() {
        this.title = null;
        this.price = null;
    }

    public Title getTitle() {
        return title;
    }

    public Price getPrice() {
        return price;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: \"" + this.title + "\" Price: " + this.price.toString() + " eur";
    }

}