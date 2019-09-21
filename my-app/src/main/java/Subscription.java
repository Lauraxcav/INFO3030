public class Subscription {

    private int price;
    /*
        length of subscription, in months
    */
    private int length;

    // constructor
    public Subscription(int price, int length) {
        this.price = price;
        this.length = length;
    }

    /**
     * Calculate monthly price in euro
     * this is an intentional bug
     */
    public double pricePerMonth() {
       return (double) price/(double) length;
    }

    /*
     * Cancel the subscription
     */
    public void cancel() { length=0; }

}