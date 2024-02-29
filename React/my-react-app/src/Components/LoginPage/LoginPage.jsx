import React, { useReducer, useState } from "react";
import "./LoginPage.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";

function LoginPage() {
  //inital object
  const init = {
    username: "",
    password: "",
  };

  //function for dispatcher
  const reducer = (state, action) => {
    switch (action.type) {
      case "update":
        return { ...state, [action.fld]: action.val };
      case "reset":
        return init;
      default:
    }
  };

  const navigate = useNavigate();

  //dispatch to modify info object
  const [info, dispatch] = useReducer(reducer, init);
  const [msg, setMsg] = useState("");
  const sendData = (e) => {
    e.preventDefault();
    const reqOptions = {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify(info),
    };
    fetch("http://localhost:8080/verifyLogin", reqOptions)
      .then((resp) => {
        if (resp.ok) {
          return resp.text();
        } else {
          throw new Error("Service Error");
        }
      })
     //  .then((resp) => console.log(resp))
      // .then((resp) => resp.text())
      .then((text) => (text.length ? JSON.parse(text) : {}))
      .then((obj) => {
        if (Object.keys(obj).length === 0) {
          setMsg("Account not found");
        } else {
          localStorage.setItem('loginId', obj.login_id); 
          localStorage.setItem('username', obj.username);
          if (obj.id_approved === false) {
           setMsg("Request not approved");
          } else {
            if (obj.role_id.roleid === 1) {
              navigate("/adminDoctor");
            } else if (obj.role_id.roleid === 2) {
              navigate("/docHome");
            } else if (obj.role_id.roleid === 3) {
              navigate("/patientHome");
            }
          }
        }
      })
      .catch((error) => {
        navigate("/serverError");
      });
    //.then((obj)=>{console.log(obj)})
  };

  return (
    <>
      <div className="form-Container">
        <span id="login-label">Login</span>

        <form method="POST">
          <div className="form-group">
            <label htmlFor="">User id</label>
            <input
              type="text"
              name="username"
              id="username"
              className="form-control"
              value={info.username}
              onChange={(e) => {
                dispatch({
                  type: "update",
                  fld: "username",
                  val: e.target.value,
                });
              }}
            />
          </div>

          <div className="form-group">
            <label htmlFor="">Password</label>
            <input
              type="password"
              name="password"
              id="password"
              className="form-control"
              value={info.password}
              onChange={(e) => {
                dispatch({
                  type: "update",
                  fld: "password",
                  val: e.target.value,
                });
              }}
            />
          </div>
          

          <div className="button-container">
            <button
              type=""
              className="btn btn-primary"
              onClick={(e) => sendData(e)}
            >
              Login
            </button>
          </div>

          <div className="error">{msg}</div>
        </form>
      </div>
    </>
  );
}

export default LoginPage;
