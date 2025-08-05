import { FormControl, FormGroup, Validators } from "@angular/forms";
import { UserSignup } from "../model/user-signup";

export class AuthUtil {

    public static getSignUpFormGroup(): FormGroup {
        return new FormGroup({
            role: new FormControl('', [Validators.required]),
            firstName: new FormControl('', [Validators.required]),
            middleName: new FormControl(''),
            lastName: new FormControl('', [Validators.required]),
            emailId: new FormControl('', [Validators.required]),
            password: new FormControl('', [Validators.required]),
            confirmPassword: new FormControl('', [Validators.required]),
        });
    }

    public static isValidPassword(signupForm: FormGroup): [boolean, string] {
        const password: string = signupForm.value.password;
        const confirmPassword: string = signupForm.value.confirmPassword;

        if (!password || !confirmPassword) {
            return [false, 'Please add password.'];
        } else if (password != confirmPassword) {
            return [false, 'Password does not match.'];
        } else {
            return [true, '']
        }
    }

    public static createSignUpDetailsFromFormValues(signupForm: FormGroup): UserSignup {
        const formValue: any = signupForm.value;

        const signupDetails: UserSignup = {
            role: formValue.role,
            firstName: formValue.firstName,
            middleName: formValue.middleName,
            lastName: formValue.lastName,
            emailId: formValue.emailId,
            mobile: formValue.mobile,
            password: formValue.password,
        };

        return signupDetails;
    }
}
