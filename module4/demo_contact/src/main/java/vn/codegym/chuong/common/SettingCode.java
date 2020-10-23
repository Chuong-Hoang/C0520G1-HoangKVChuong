package vn.codegym.chuong.common;

import vn.codegym.chuong.model.contact_model.Contact;
import vn.codegym.chuong.model.student_model.Student;

public class SettingCode {
    public static String setUpCode(Student obj){
        String code = null;
        Long id = obj.getStudentId();
        if (id < 10) {
            code = "SV-000" + id;
        } else if (id < 100) {
            code = "SV-00" + id;
        } else if (id < 1000) {
            code = "SV-0" + id;
        } else if(id < 10000) {
            code = "SV-" + id;
        } else {
            code = "SV-9999";
        }
        return code;
    }

    public static String setUpCodeContact(Contact obj){
        String code = null;
        Long id = obj.getContactId();
        if (id < 10) {
            code = "CT-000" + id;
        } else if (id < 100) {
            code = "CT-00" + id;
        } else if (id < 1000) {
            code = "CT-0" + id;
        } else if(id < 10000) {
            code = "CT-" + id;
        } else {
            code = "CT-9999";
        }
        return code;
    }
}
