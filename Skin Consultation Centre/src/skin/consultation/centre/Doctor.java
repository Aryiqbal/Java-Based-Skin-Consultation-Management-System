/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skin.consultation.centre;

public class Doctor extends Person{
    
    private int licenceNumber;
    private String specialisation;
    
//    public Doctor(String name, String surname, int dateOfBirth, int mobileNumber) {
//        super(name, surname, dateOfBirth, mobileNumber);
//    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public String toString() {
        return "Doctor{" + "licenceNumber=" + licenceNumber + ", specialisation=" + specialisation + '}';
    }
    
    
    
}