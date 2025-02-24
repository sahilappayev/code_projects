package solid;

public class BCompanyPayment implements CompanyPayment, GooglePaymentServices,
        ApplePaymentService, PaypalPaymentServices {


    @Override
    public void payWithApple() {
        System.out.println("BCompanyPayment -- Pay With Apple");
    }

    @Override
    public void payWithGoogle() {
        System.out.println("BCompanyPayment -- Pay With Google");
    }

    @Override
    public void payWithPaypal() {
        System.out.println("BCompanyPayment -- Pay With Paypal");
    }


    @Override
    public void pay(PaymentType paymentType) {
        switch (paymentType) {
            case GOOGLE:
                payWithGoogle();
                break;
            case APPLE:
                payWithApple();
                break;
            case PAYPAL:
                payWithPaypal();
                break;
            default:
                System.out.println("Invalid payment type");
        }
    }
}
