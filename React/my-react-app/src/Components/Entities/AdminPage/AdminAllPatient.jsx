import { React, useState, useEffect } from "react";
import AdminPatientEntity from "./AdminPatientEntity";
import "./AdminDoctorPage.css";

function AdminAllPatient() {
  const [doctors, setDoctors] = useState([]);
  const jwtToken = sessionStorage.getItem("jwtToken");

  useEffect(() => {
    fetch("http://localhost:8080/getAllPatient", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${jwtToken}`,
      },
    })
      .then((resp) => {
        if (resp.ok) {
          return resp.json();
        } else {
          throw new Error("Failed to fetch doctors");
        }
      })
      .then((data) => {
        console.log(data);
        setDoctors(data);
      })
      .catch((error) => {
        alert("Error fetching doctors:", error);
      });
  }, []);

  const card = doctors.map((item) => <AdminPatientEntity {...item} />);
  return (
    <>
      <legend>Admin Patient Management</legend>
      <div className="container-fluid w-70">{card}</div>
    </>
  );
}

export default AdminAllPatient;
