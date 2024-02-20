import React from "react";
import "./AdminDoctorEntity.css";

export default function AdminDoctoEntity(prop) {
  const handleButtonClick = (e) => {
    e.preventDefault();
    const linkString = prop.doctor_login_id.id_approved
      ? "http://localhost:8080/disapprove/"
      : `http://localhost:8080/approve/`;
    const reqOptions = {
      method: "GET",
      headers: { "content-type": "application/json" },
    };
    console.log(reqOptions);
  //  alert(linkString + prop.doctor_login_id.login_id);
    fetch(linkString + prop.doctor_login_id.login_id, reqOptions).then(
      (resp) => {
        window.location.reload();
      }
    );
  };

  const fetchDelete = () => {
    fetch(`http://localhost:8080/deleteDoctor/${prop.doctorid}`, {
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
        <div className="card-header text-center">{prop.specialization} </div>

        <div className="card-body ">
          <h5 className="card-title text-center">
            {prop.first_name} {prop.last_name}{" "}
            <span className="text-muted ">
              <span>(</span>
              {prop.education}
              <span>)</span>
            </span>
          </h5>
          <p className="card-text">
            {prop.description}
            <br />
          </p>
          <hr />
          <button
            onClick={handleButtonClick}
            className={`btn ${
              prop.doctor_login_id.id_approved ? "btn-danger" : "btn-success"
            }`}
          >
            {prop.doctor_login_id.id_approved ? "Disable" : "Approve"}
          </button>
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
          {prop.phonenumber}
          <i className="bi bi-envelope-at-fill"></i>
          {prop.email}
          <i className="bi bi-geo-alt-fill"></i>
          {prop.city} {prop.pincode}
        </div>
      </div>
    </>
  );
}
