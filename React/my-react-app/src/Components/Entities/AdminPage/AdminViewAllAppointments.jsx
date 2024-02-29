import React, { useState, useEffect } from "react";

function AdminViewAllAppointments() {
  const [data, setData] = useState([]);
  const loginID = localStorage.getItem("loginId");

  useEffect(() => {
    fetchData();
  }, []);

  const fetchData = () => {
    console.log(
      `http://localhost:8080/appointments/getall`
    );
    fetch(`http://localhost:8080/appointments/getall`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
      },
    })
      .then((resp) => {
        if (resp.ok) {
          return resp.json();
        } else {
          throw new Error("Failed to get appointment");
        }
      })
      .then((data) => {
        setData(data);
        console.log(data);
      })
      .catch((error) => {
        console.log("Error Getting appointment:", error);
      });
  };

  return (
    <div className="container mt-4">
      <legend>View Appointments</legend>
      <div className="table-responsive">
        <table className="table table-striped">
          <thead>
            <tr>
              <th className="text-center">Appointment ID</th>
              <th className="text-center">Doctor Name</th>
              <th className="text-center">Patient Name</th>
              <th className="text-center">Appointment Date</th>
              <th className="text-center">Appointment Time</th>
              <th className="text-center">Notes</th>
              <th className="text-center">Status</th>
              <th className="text-center">Prescription</th>
            </tr>
          </thead>
          <tbody>
            {data.map((appointment) => (
              <tr key={appointment.id}>
                <td className="text-center">{appointment.id}</td>
                <td className="text-center">
                  {appointment.doctorId.first_name}{" "}
                  {appointment.doctorId.last_name}
                </td>
                <td className="text-center">
                  {appointment.patientId.first_name}{" "}{appointment.patientId.last_name}
                </td>
                <td className="text-center">{appointment.appointmentDate}</td>
                <td className="text-center">{appointment.appointmentTime}</td>
                <td className="text-center">{appointment.notes}</td>
                <td className="text-center">{appointment.status}</td>
                <td className="text-center">{appointment.prescription}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default AdminViewAllAppointments;
