import java.util.Scanner;

interface Billable {
     double calculateTotal();
 }

 class ElectricityBill implements Billable {
    String name;
    int currentReading;
    int previousReading;
    int unitsConsumed;
    int tax = 5;

    ElectricityBill(String name, int prev, int curr) {
        this.name= name;
        this.previousReading=prev;
        this.currentReading=curr;
        this.unitsConsumed=curr-prev;
    }
     public double calculateTotal(){
        double billAmount=0;
        if(unitsConsumed <= 100){
            billAmount=unitsConsumed*1.0;
        }
        else if(unitsConsumed <= 300){
            billAmount = (100 * 1.0) + ((unitsConsumed-100)*2.0);
        }
        else {
            billAmount=(100*1.0)+(200*2.0)+((unitsConsumed-300)*5.0);
        }
        return billAmount;
     }
     double taxamount() {
        return calculateTotal() * tax / 100;
     }
     double getTotal() {
        return calculateTotal() + taxamount();
     }

     void billRecipt(){
        System.out.println("   ELECTRICITY BILL RECIPT   ");
        System.out.println("---------------------------");
        System.out.println("Custome Name : " + name);
        System.out.println("Previous Reading : " + previousReading);
        System.out.println("Present Reading : " + currentReading);
        System.out.println("Units Consumed : " + unitsConsumed);
        System.out.println("Bill : " + calculateTotal());
        System.out.println("Tax(5%) : " + taxamount());
        System.out.println(" Total Bill : " + getTotal());
     }

 }

class WaterBill implements Billable{
        String name;
        int liters;
        int tax=3;

        WaterBill(String name,int liters){
            this.name=name;
            this.liters=liters;
        }
        public double calculateTotal(){
            double bill=0;
            if(liters<=500){
                bill=liters*0.5;
            }
            else if(liters<=1000){
                bill=(500*0.3)+((liters-500)*1.0);
            }
            else {
                bill = (500*0.5)+(500*1.0)+((liters-1000)*5.0);
            }
            return bill;
        }
        double taxAmount(){
            return calculateTotal()*tax/100;
        }
        void printRecipt(){
            System.out.println("\n--- WATER BILL ---");
            System.out.println("Name: " + name);
            System.out.println("Liters Used: " + liters);
            System.out.println("Bill: " + calculateTotal());
            System.out.println("Tax: " + taxAmount());
            System.out.println("Total: " + (calculateTotal() + taxAmount()));
        }
    }


public class UtilityBillGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("------UTILITY BILL SYSTEM------");
            System.out.println("1.Electricity Bill");
            System.out.println("2.Water Bill");
            System.out.println("3.Exit");
            System.out.println("Choose an option");
            int choice = sc.nextInt();
            sc.nextLine();

            if(choice==3){
                System.out.println("Exiting system");
                break;
            }

            System.out.println("Enter Name:");
            String name = sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Previous Reading");
                    int prev = sc.nextInt();

                    System.out.println("Enter current reading");
                    int curr = sc.nextInt();
                    sc.nextLine();

                    if (prev > curr) {
                        System.out.println("Invalid Readings");
                        break;
                    }
                    ElectricityBill eb = new ElectricityBill(name, prev, curr);
                    eb.billRecipt();
                    break;
                case 2:
                    System.out.println("Enter water usage");
                    int liters = sc.nextInt();
                    sc.nextLine();

                    WaterBill wb = new WaterBill(name, liters);
                    wb.printRecipt();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }
        }

        sc.close();

    }
}
