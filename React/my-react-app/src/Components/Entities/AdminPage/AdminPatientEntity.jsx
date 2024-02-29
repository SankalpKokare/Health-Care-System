import React from "react";
import "./AdminDoctorEntity.css";

function AdminPatientEntity(prop) {

  const handleButtonClick = (e) => {
    e.preventDefault();
    const status = prop.patient_login_id.id_approved ? "approve" : "disapprove";
    const reqOptions = {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify({
        is_approved: status,
        patient_login_id: prop.patient_login_id.login_id,
      }),
    };
    console.log(reqOptions);
    fetch("http://localhost:8080/approveDoctor", reqOptions)
      .then((resp) => {
        if (resp.ok) {
          return resp.json();
        } else {
          throw new Error("Cannot change status");
        }
      })
      .then((obj) => {
        console.log(obj);
        alert("Status Changed");
      })
      .catch((error) => alert("Server Error"));
  };

  const fetchDelete = () => {
    console.log(`http://localhost:8080/deletePatient/${prop.patient_id}`);
    fetch(`http://localhost:8080/deletePatient/${prop.patient_id}`, {
      method: "DELETE",
      headers: { "content-type": "application/json" },
    }).then((resp) => {
      alert("Deleted");
      window.location.reload();
    });
  };

  const handleDelete = (e) => {
    e.preventDefault();
    /* eslint-disable no-restricted-globals */
    const result = confirm("Do you want to proceed?");
    /* eslint-enable no-restricted-globals */
    if (result) {
      fetchDelete();
    }
  };
  return (
    <>
      <div className="card w-70 card-max ">
        <div className="card-header text-center">
          {" "}
          Id: {prop.patient_id}, Login-id: {prop.patient_login_id.login_id}{" "}
        </div>

        <div className="card-body ">
          <h5 className="card-title text-center">
            {prop.first_name} {prop.last_name}
            <span className="text-muted ">
              <span> (</span>
              {prop.patient_login_id.username}
              <span>)</span>
            </span>
          </h5>
          <hr />
          <button
            className="btn btn-sm btn-outline-danger"
            onClick={handleDelete}
          >
            <i class="bi bi-trash3"></i>Delete
          </button>

          {prop.address}
        </div>
        <div className="card-footer text-muted text-center">
          <i className="bi bi-telephone-fill"></i>
          {prop.phone_number}
          <i className="bi bi-envelope-at-fill"></i>
          {prop.email_id}
        </div>
      </div>
    </>
  );
}

export default AdminPatientEntity;
