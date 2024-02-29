import { React, useEffect, useState } from "react";
import AdminDoctorEntity from "./AdminDoctorEntity";
import "./AdminDoctorPage.css";
//import getAllDoctor from "./getAllDoctor";

function AdminDoctorPage() {
  const [doctors, setDoctors] = useState([]);
  const jwtToken = sessionStorage.getItem("jwtToken");

  useEffect(() => {
    fetch("http://localhost:8080/getAllDoctor", {
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

  const card = doctors.map((item) => <AdminDoctorEntity {...item} />);

  return (
    <>
      <legend>Admin's Doctor Management Page</legend>
      <div className="container-fluid w-70">{card}</div>
    </>
  );
}

export default AdminDoctorPage;
