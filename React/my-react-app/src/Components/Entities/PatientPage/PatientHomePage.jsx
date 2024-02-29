import { React, useEffect, useState } from "react";
import AdminDoctorEntity from "./DoctorEntity";


function PatientHomePage() {
  const [doctors, setDoctors] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/getAllDoctor")
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
      <div className="PatientHomePage">
        <legend></legend>
        <div className="container w-100">
          <div className="row">
            {card.map((value) => (
              <div className="col-lg-6"> {value} </div>
            ))}
          </div>
        </div>
      </div>
    </>
  );
}

export default PatientHomePage;
