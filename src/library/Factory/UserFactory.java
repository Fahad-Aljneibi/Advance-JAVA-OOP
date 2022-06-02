/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.Factory;

import library.Model.Admin;
import library.Model.Employee;
import library.Model.Student;
import library.Model.User;

/**
 *
 * @author fahad
 */
public class UserFactory {

    public User createUser(String user) {
        
        if (user.toLowerCase() == "admin") {
            return new Admin();
        } else if (user.toLowerCase() == "employee") {
            return new Employee();
        } else if (user.toLowerCase() == "student") {
            return new Student();
        }
        return null;
    }
}
