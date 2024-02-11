// DoctorRegistration.js
import React, { useReducer } from "react";
import "./DoctorRegistration.css";
import { useLocation } from "react-router-dom";
function DoctorRegistration() {
  const location = useLocation();
  console.log(location);

  const init = {
    userName: { value: "", valid: false, touched: false, error: "" },
    password: { value: "", valid: false, touched: false, error: "" },
    firstName: { value: "", valid: false, touched: false, error: "" },
    lastName: { value: "", valid: false, touched: false, error: "" },
    address: { value: "", valid: false, touched: false, error: "" },
    contactNo: { value: "", valid: false, touched: false, error: "" },
    email: { value: "", valid: false, touched: false, error: "" },
    gender: {
      value: "",
      valid: false,
      touched: false,
      error: "Please Select a Gender",
    },
    description: { value: "", valid: false, touched: false, error: "" },
    Specialization: { value: "", valid: false, touched: false, error: "" },
    // Education: { value: "", valid: false, touched: false, error: "" },
    experience: { value: "", valid: false, touched: false, error: "" },
  };

  const reducer = (state, action) => {
    switch (action.type) {
      case "update":
        const { key, value, touched, valid, error, formValid } = action.data;
        return { ...state, [key]: { value, touched, valid, error }, formValid };
      case "reset":
        return init;
      default:
    }
  };

  const [user, dispatch] = useReducer(reducer, init);

  const validateData = (key, val) => {
    let valid = true;
    let error = "";

    switch (key) {
      case "userName":
        let patteruserName = /^[a-zA-Z0-9]+$/;
        if (!patteruserName.test(val)) {
          valid = false;
          error = "Enter Valid User Name";
        }
        break;
      case "password":
        let patternpassword =
          /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        if (!patternpassword.test(val)) {
          valid = false;
          error = "Enter Valid Password";
        }
        break;
      case "firstName":
        let patterfirstName = /^[A-Z]{1}[a-z]{1,}$/;
        if (!patterfirstName.test(val)) {
          valid = false;
          error = "Enter Valid Name - First Letter Capital";
        }
        break;
      case "lastName":
        let patternlastName = /^[A-Z]{1}[a-z]{1,}$/;
        if (!patternlastName.test(val)) {
          valid = false;
          error = "Enter Valid Name - First Letter Capital";
        }
        break;
      case "address":
        let patternaddress = /^[#.0-9a-zA-Z\s,-]+$/;
        if (!patternaddress.test(val)) {
          valid = false;
          error = "Please Enter Valid Address";
        }
        break;
      case "contactNo":
        let patterncontactno = /^\d{10}$/;
        if (!patterncontactno.test(val)) {
          valid = false;
          error = "Please Enter Valid Contact Number";
        }
        break;
      case "email":
        let patternemail = /^[\w._#-]{4,20}@[\w-]{5,15}\.[a-z]{2,3}$/;
        if (!patternemail.test(val)) {
          valid = false;
          error = "Invalid Email ID";
        }
        break;
      case "gender":
        valid = val !== "";
        error = valid ? "" : "Please select a gender";
        break;
      default:
    }
    return { valid: valid, error: error };
  };

  const handleChange = (key, value) => {
    const { valid, error } = validateData(key, value);
    let formValid = true;
    for (let k in user) {
      if (user[k].valid === false) {
        formValid = false;
        break;
      }
    }
    console.log(formValid);

    dispatch({
      type: "update",
      data: { key, value, touched: true, valid, error, formValid },
    });
  };
  return (
    <>
      <legend>Doctor Registration</legend>
      <div className="registration-container">
        <form
          className="form-horizontal needs-validation"
          action=""
          method="POST"
        >
          <table className="table">
            <tbody>
              <tr>
                <td>
                  <label className="control-label" htmlFor="firstName">
                    User Name
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="userName"
                    name="userName"
                    value={user.userName.value}
                    onChange={(e) => {
                      handleChange("userName", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("userName", e.target.value);
                    }}
                    placeholder="rajsharma12"
                    required
                  />

                  <div
                    style={{
                      display:
                        user.userName.touched && !user.userName.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.userName.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="firstName">
                    Password
                  </label>
                </td>
                <td>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    name="password"
                    value={user.password.value}
                    onChange={(e) => {
                      handleChange("password", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("password", e.target.value);
                    }}
                    placeholder="Rajsharma@123"
                    required
                  />

                  <div
                    style={{
                      display:
                        user.password.touched && !user.password.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.password.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="firstName">
                    First Name
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="firstName"
                    name="firstName"
                    value={user.firstName.value}
                    onChange={(e) => {
                      handleChange("firstName", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("firstName", e.target.value);
                    }}
                    placeholder="Raj"
                    required
                  />
                  <div
                    style={{
                      display:
                        user.firstName.touched && !user.firstName.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.firstName.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="lastName">
                    Last Name
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="lastName"
                    name="lastName"
                    value={user.lastName.value}
                    onChange={(e) => {
                      handleChange("lastName", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("lastName", e.target.value);
                    }}
                    placeholder="Patel"
                    required
                  />
                  <div
                    style={{
                      display:
                        user.lastName.touched && !user.lastName.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.lastName.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="address">
                    Address
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="address"
                    name="address"
                    placeholder="123 Main St"
                    value={user.address.value}
                    onChange={(e) => {
                      handleChange("address", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("address", e.target.value);
                    }}
                    required
                  />
                  <div
                    style={{
                      display:
                        user.address.touched && !user.address.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.address.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="contactNo">
                    Contact No
                  </label>
                </td>
                <td>
                  <input
                    type="tel"
                    className="form-control"
                    id="contactNo"
                    name="contactNo"
                    placeholder="9876543210"
                    value={user.contactNo.value}
                    onChange={(e) => {
                      handleChange("contactNo", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("contactNo", e.target.value);
                    }}
                    required
                  />
                  <div
                    style={{
                      display:
                        user.contactNo.touched && !user.contactNo.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.contactNo.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="email">
                    Email
                  </label>
                </td>
                <td>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    name="email"
                    placeholder="RajPatel@gmail.com"
                    value={user.email.value}
                    onChange={(e) => {
                      handleChange("email", e.target.value);
                    }}
                    onBlur={(e) => {
                      handleChange("email", e.target.value);
                    }}
                    required
                  />
                  <div
                    style={{
                      display:
                        user.email.touched && !user.email.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.email.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="gender">
                    Gender
                  </label>
                </td>
                <td>
                  <select
                    className="form-control"
                    id="gender"
                    name="gender"
                    checked={user.gender.value === "f"}
                    onChange={(e) => handleChange("gender", e.target.value)}
                    required
                  >
                    <option value="">Select</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                  </select>
                  <small className="text-help">Required</small>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="description">
                    Description
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="description"
                    name="description"
                    placeholder="Cardiologist"
                    required
                  />
                  <div
                    style={{
                      display:
                        user.gender.touched && !user.gender.valid
                          ? "block"
                          : "none",
                      color: "red",
                    }}
                  >
                    {user.gender.error}
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="Specialization">
                    Specialization
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="Specialization"
                    name="Specialization"
                    placeholder="Heart Surgeon"
                    required
                  />
                  <small className="text-help">Required</small>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="Specialization">
                    Education
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    className="form-control"
                    id="education"
                    name="education"
                    placeholder="MBBS,MD,etc"
                    required
                  />
                  <small className="text-help">Required</small>
                </td>
              </tr>
              <tr>
                <td>
                  <label className="control-label" htmlFor="experience">
                    Experience
                  </label>
                </td>
                <td>
                  <input
                    type="number"
                    className="form-control"
                    id="experience"
                    name="experience"
                    placeholder=""
                    required
                    max="70"
                  />
                  <small className="text-help">Required</small>
                </td>
              </tr>
              <tr>
                <td colSpan="2" className="text-center">
                  <button type="submit" className="btn btn-primary">
                    Register
                  </button>
                </td>
              </tr>
              <tr>
                <td colSpan="2" className="text-center">
                  <button
                    type="reset"
                    className="btn btn-primary"
                    onClick={() => {
                      dispatch({ type: "reset" });
                    }}
                  >
                    Reset
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </form>
      </div>
    </>
  );
}
export default DoctorRegistration;
