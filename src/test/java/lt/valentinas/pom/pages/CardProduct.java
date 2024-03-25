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

    public void setTitle(T title) {
        this.title = title;
    }

    public void setPrice(U price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: \"" + this.title + "\" Price: " + this.price.toString() + " eur";
    }

}