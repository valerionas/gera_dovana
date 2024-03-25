package lt.valentinas.pom.pages;

public class CardProduct<T, U> {
    private T title;
    private U price;

    public CardProduct(T title, U price) {
        this.title = title;
        this.price = price;
    }

    public T getTitle() {
        return title;
    }

    public U getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Title: \"" + this.title + "\" Price: " + this.price.toString() + " eur";
    }

}