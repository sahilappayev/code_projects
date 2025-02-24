package solid;

public class ACompanyPayment implements CompanyPayment, GooglePaymentServices, ApplePaymentService {


    @Override
    public void payWithApple() {
        System.out.println("ACompanyPayment -- Pay With Apple");
    }

    @Override
    public void payWithGoogle() {
        System.out.println("ACompanyPayment -- Pay With Google");
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
            default:
                System.out.println("Invalid payment type");
        }
    }
}
