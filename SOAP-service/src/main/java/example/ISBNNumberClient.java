package example;

import consumed.ISBNServiceLocator;
import consumed.ISBNServiceSoapType;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

public class ISBNNumberClient {

    public static void main(String[] argv) {

        boolean isValidISBN10;
        boolean isValidISBN13;

        // this ISBN number is taken from a math formula collection book
        // TODO: change the ISBN number to test the service
        final String ISBN10_NUMBER = "87-88751-59-7";
        // this ISBN number is taken from the book "An Embarrassment of Witches"
        // TODO: change the ISBN number to test the service
        final String ISBN13_NUMBER = "978-1-60309-462-7";


        try {
            ISBNServiceLocator locator = new ISBNServiceLocator();
            ISBNServiceSoapType service = locator.getISBNServiceSoap();


            isValidISBN10 = service.isValidISBN10(ISBN10_NUMBER);
            isValidISBN13 = service.isValidISBN13(ISBN13_NUMBER);

            System.out.println();
            System.out.println("--------------------- ISBN NUMBER CHECK -----------------------");
            System.out.println("The book with ISBN number: " + ISBN10_NUMBER + " is " + (isValidISBN10 ? "valid" : "invalid"));
            System.out.println("The book with ISBN number: " + ISBN13_NUMBER + " is " + (isValidISBN13 ? "valid" : "invalid"));
            System.out.println("---------------------------------------------------------------");

        } catch (ServiceException | RemoteException ex) {
            ex.printStackTrace();
        }

  }

}
