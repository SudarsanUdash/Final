package com.sudarsanudash.ilamteagarden;

import android.widget.EditText;

class User {

        public String et_FullName, et_Address, et_PhoneNumber, et_Email;

        public User(EditText et_FullName, EditText et_Address, EditText et_PhoneNumber, EditText et_Email){


        }

        public User(String et_FullName, String et_Address, String et_PhoneNumber, String et_Email) {
            this.et_FullName = et_FullName;
            this.et_Address = et_Address;
            this.et_PhoneNumber = et_PhoneNumber;
            this.et_Email = et_Email;
        }
    }


