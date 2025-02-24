package solid;

public class Main {

    public static void main(String[] args) {

        // SOLID
        // Single Responsibilty

        // Open-closed

        // Liskov sub-situation

        // Interface segregartion

        // Dependency inversion


//        Rectangle rectangle = new Rectangle();
//        rectangle.setX(5);
//        rectangle.setY(10);
//
//        printArea(rectangle);
//
//
//        Square square = new Square();
//        square.setX(5);
//
//        printArea(square);

        ACompanyPayment companyPayment = new ACompanyPayment();

        pay(companyPayment, PaymentType.APPLE);

        BCompanyPayment bCompanyPayment = new BCompanyPayment();

        pay(bCompanyPayment, PaymentType.PAYPAL);


    }


    public static void printArea(Shape shape) {
        System.out.println(shape.getArea());
    }

    public static void pay(CompanyPayment companyPayment, PaymentType paymentType) {
        companyPayment.pay(paymentType);
    }


}
