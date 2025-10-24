/**
* OOD midterm
* @author frank ziegler
* @version 1.0.1
*
* For right now this is a service that generates license plates of the following format: LNNLLL
* where L is letter A-Z and N is number 0-9. This is a basic NJ license plate.
* 
* This does not accurately reflect the NJMVC standards for license plates. Different plate formats belong to different vehicles. 
* This service should extended to look like the following:
* https://en.wikipedia.org/wiki/Vehicle_registration_plates_of_New_Jersey
* 
* For the purposes of this midterm, it's not pertinent to extend it any further. If I have time, I will.
*/
package service;

import java.util.Random;

public class LicensePlateService {

    /**
     * For a given extension, this method could take the parameter of the transaction or the vehicle and determine the appropriate
     * license plate to generate. 
     * An even better version would check to see if it exists in the database.
     * Again, not pertinent for this midterm.
     */
    public static String generate() {
        Random rng = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i == 1 || i == 2) {
                sb.append(rng.nextInt(10));
            } else {
                char c = (char) (rng.nextInt(91 - 65) + 65);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}