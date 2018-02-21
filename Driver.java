import java.util.Scanner;

import java.io.InputStream;
import java.io.*;

public class Driver {



    public static void main(String[] args)

    {
        Scanner input = new Scanner(System.in);
        boolean breakloop = false;
        Employee[] arrEmployees = new Employee[4];
        int i = 0;


        /* to me, it seemed like this was the easiest way to work with the input of hours worked.  */
        Hworked hours = new Hworked();



        //this is the initial while loop to actually keep the program going.
        while (breakloop == false) {

            System.out.println("Select from the following options:");
            System.out.println("1. Load Employee Information (from file)");
            System.out.println("2. Exit Program");
            System.out.print("Enter Your Selection: ");


            String menuinput = input.nextLine();

            try {
                String number = menuinput;
                //this will essentially "convert" a string to an int value, if applicable.
                int result = Integer.parseInt(number);

                if (result != 1 && result != 2) {
                    System.out.println("Error! Please enter either 1 or 2!");
                }


                if (result == 1) {


                    try {


                        InputStream inputStream = new FileInputStream("pharmacystaff.txt");
                        /* if the file is able to be read, the program will read it in  */
                        InputStreamReader reader = new InputStreamReader(inputStream);
                        BufferedReader buffer = new BufferedReader(reader);
                        //the following statement reads the first line of the file, which we do not need, and more or less ignores it.

                        buffer.readLine();
                        String line = null;
                        //this next statement will ignore the first line, because we already read it above
                        while ((line = buffer.readLine()) != null) {
                            String sampleString = line;
                            String[] employeeData = sampleString.split(",");
                            String jobIDstr = employeeData[0];
                            String empID = employeeData[1];
                            String fName = employeeData[2];
                            String lName = employeeData[3];

                            
                            //below, I'm doing the same as above as far as converting the string values to ints

                            int jobID = Integer.parseInt(jobIDstr);
                           // int empID = Integer.parseInt(empIDstr);

                            /* if the jobid meets these conditions, the following will create an instance of each of these classes, which inherits everything from employee. so it is like creating an instance of
                             * employee.  */
                            if (jobID == 1) {

                                PharmacyManager Man = new PharmacyManager(empID, fName, lName);
                                arrEmployees[i++] = Man;

                            }


                            if (jobID == 2) {
                                StaffPharmacist pharm = new StaffPharmacist(empID, fName, lName);
                                arrEmployees[i++] = pharm;

                            }


                            if (jobID == 3) {
                                StaffTechnician Tech = new StaffTechnician(empID, fName, lName);
                                arrEmployees[i++] = Tech;


                            }


                            if (jobID == 4) {
                                SeniorTechnician Sen = new SeniorTechnician(empID, fName, lName);
                                arrEmployees[i++] = Sen;

                            }


                        }
                        System.out.println("File Successfully loaded!\n");
                        buffer.close();
                        breakloop = true;
                    }
                    //like the last program, this will exit the program if the file cannot be read.
                    catch (FileNotFoundException ex) {
                        System.out.print("File load Failed! \n Program Exiting....");
                        System.exit(0);
                    }


                }

                if (result == 2) {
                    System.out.println("Program Exiting...");
                    breakloop = true;
                    System.exit(0);
                }


            } catch (Exception e) {
                System.out.println("Error! Not a number. Please enter an integer between 1 and 2!");
            }

        }


        boolean breakloop2 = false;
        while (breakloop2 == false) {


            System.out.print("1. Print Employee information \n2. Enter Hours Worked \n3. Calculate Paychecks \n4. Exit Program \n \nEnter Your Selection:");
            String meninput2 = input.nextLine();



            try {

                String num2 = meninput2;
                //this will essentially "convert" a string to an int value, if applicable.
                int result2 = Integer.parseInt(num2);

                if (result2 > 4)
                {
                    System.out.println("Error! Please enter a number between 1 and 4!");
                }

                if (result2 == 1) {
                    for (int a = 0; a < i; a++) {
                    /* the following assigns a string value to each of these employee methods. then, the systems will use
                     * the for loop to increment through the array and print the results of each of these methods. and because of polymorphism, It has all of the
                      * unique attributes to each subclass.*/

                        String employeenames = arrEmployees[a].printEmployee();
                        String employeeatts = arrEmployees[a].printAttributes();
                        System.out.println(employeenames + employeeatts);
                    }
                }

                if (result2 == 4) {
                    System.out.println("Program Exiting....");
                    System.exit(0);
                }





                if (result2 == 2) {
                    System.out.print("\nEnter Hours Worked: ");
                    String hoursstr = input.nextLine();


                    try {

                        String hourinput = hoursstr;
                        //this will essentially "convert" a string to an int value, if applicable.
                        double temphWorked = Double.parseDouble(hourinput);
                        //this will feed in the double taken in by the user into the Hworked class
                        hours.setHour(temphWorked);


                    }

                    //like above, this will throw an exception if the user does not enter a double value.
                    catch (Exception e)
                    {
                        System.out.println("Error! Not a number. Please input a number. ");

                    }
                }



                if (result2 == 3)
                {
                    /* this for loop will get each employee value stored in arrEmployees that this if statement needs, and print it out on the console */
                    for (int a = 0; a < i; a++) {

                        String empIDnum = arrEmployees[a].getEmployeeID();
                        double empHrate = arrEmployees[a].returnRate();

                        //this gets the value stored earlier so that we can multiply it to find the money earned.
                        double hourdouble = hours.getHour();
                        System.out.println(hourdouble * empHrate);

                    }
                }



            }



            catch(Exception e)
            {
                System.out.println("Error! not a number. Please enter an integer between 1 and 4");
            }


        }


    }

}
