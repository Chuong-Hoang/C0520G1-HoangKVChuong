 // Validate input
        boolean isValidALL = false;

        boolean isValid_c = Validation.checkDouble(c);
        boolean isValid_d = Validation.checkDouble(d);

        if (!isValid_c) {
            String msgInvalid_c = "The name not valid";
            request.setAttribute("msg_invalid_c", msgInvalid_c);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The ID card number is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }

        

 // Validate input
        boolean isValidALL = false;
        boolean isValid_id = Validation.checkCode(id);
        boolean isValid_a = Validation.checkName(a);
        boolean isValid_b = Validation.checkBirthday(b);
        boolean isValid_d = Validation.checkIdCard(d);
        boolean isValid_e = Validation.checkPhoneNumber(e);
        boolean isValid_f = Validation.checkEmail(f);


        if (!isValid_id) {
            String msgInvalid_id = "The ID must be as format 'KH-XXXX'";
            request.setAttribute("msg_invalid_id", msgInvalid_id);
        }
        if (!isValid_a) {
            String msgInvalid_a = "The name not valid";
            request.setAttribute("msg_invalid_a", msgInvalid_a);
        }
        if (!isValid_b) {
            String msgInvalid_b = "The birthday must made the age not less than 18";
            request.setAttribute("msg_invalid_b", msgInvalid_b);
        }
        if (!isValid_d) {
            String msgInvalid_d = "The ID card number is not valid";
            request.setAttribute("msg_invalid_d", msgInvalid_d);
        }
        if (!isValid_e) {
            String msgInvalid_e = "The phone number must have 9 or 10 digits";
            request.setAttribute("msg_invalid_e", msgInvalid_e);
        }
        if (!isValid_f) {
            String msgInvalid_f = "The email is not valid";
            request.setAttribute("msg_invalid_f", msgInvalid_f);
        }

        isValidALL = isValid_id && isValid_a && isValid_b && isValid_d && isValid_e && isValid_f;
        if (isValidALL) {
            Customer el = new Customer(id, a, b, c, d, e, f, g, h);
            this.customerBO.create(el);
            //request.setAttribute("el", el);
            request.setAttribute("msg_create", msg_create);
        } else {
            request.setAttribute("msg_create", "Input not valid!");
        }
        forwardJSP(request, response, createJSP);
        // validate ends here...........