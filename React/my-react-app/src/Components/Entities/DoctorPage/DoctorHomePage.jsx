import React, { useState } from "react";
function DoctorHomePage() {
  const [data, setData] = useState([]);
  const [date, setDate] = useState("");
  const loginID = localStorage.getItem("loginId");
  const [updatedPrescription, setUpdatedPrescription] = useState("");

  const handleDateChange = (event) => {
    setDate(event.target.value);
  };

  const fetchData = () => {
    fetch(
      `http://localhost:8080/appointments/getAscAppointments/${loginID}/${date}`,
      {
        method: "GET",
        headers: {
          "Content-Type": "application/json",
        },
      }
    )
      .then((resp) => {
        if (resp.ok) {
          return resp.json();
        } else {
          throw new Error("Failed to get appointment");
        }
      })
      .then((data) => {
        console.log(data);
        setData(data);
      })
      .catch((error) => {
        alert("Error Getting appointment:", error);
      });
  };

  const handleButtonClick = (e) => {
    console.log(
      `http://localhost:8080/appointments/getAscAppointments/${loginID}/${date}`
    );

    fetchData();
  };

  const handleStatusChange = (appointmentId, newStatus) => {
    console.log(
      `http://localhost:8080/appointments/updatetstatus/${appointmentId}` +
        JSON.stringify({ status: newStatus })
    );
    fetch(`http://localhost:8080/appointments/updatetstatus/${appointmentId}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: newStatus,
    })
      .then((resp) => {
        if (!resp.ok) {
          throw new Error("Failed to update appointment status");
        } else {
        }
      })
      .catch((error) => {
        alert("Error updating appointment status:", error);
      });
    alert("Status updated");

    handleButtonClick();
  };

  const updatePrescription = (appointmentId) => {
    fetch(`http://localhost:8080/appointments/${appointmentId}/prescription`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: updatedPrescription,
    })
      .then((resp) => {
        if (!resp.ok) {
          throw new Error("Failed to update prescription");
        }
      })
      .catch((error) => {
        alert("Error updating prescription:", error);
      });

    fetchData();
    handleButtonClick();
  };

  return (
    <div className="DoctorHomePage container">
      <legend>View Appointments</legend>
      <div className="w-60">
        <div className="mb-3">
          <label htmlFor="date" className="form-label">
            Date
          </label>
          <input
            type="date"
            className="form-control"
            id="date"
            value={date}
            onChange={handleDateChange}
            required
          />
        </div>
        <button className="btn btn-primary mb-3" onClick={handleButtonClick}>
          Check Appointments
        </button>
        <div className="table-responsive">
          <table className="table table-striped">
            <thead>
              <tr>
                <th>Appointment ID</th>
                <th>Patient ID</th>
                <th>Phone Number</th>
                <th>Appointment Date</th>
                <th>Appointment Time</th>
                <th colSpan="2">Notes</th>
                <th>Status</th>
                <th colSpan="2">Prescription</th>
                <th>Update</th>
              </tr>
            </thead>
            <tbody>
              {data.map((appointment) => (
                <tr key={appointment.id}>
                  <td>{appointment.id}</td>
                  <td>
                    {appointment.patientId.first_name}{" "}
                    {appointment.patientId.last_name}
                  </td>
                  <td>{appointment.patientId.phone_number}</td>
                  <td>{appointment.appointmentDate}</td>
                  <td>{appointment.appointmentTime}</td>
                  <td colSpan="2">{appointment.notes}</td>
                  <td>
                    <select
                      value={appointment.status}
                      onChange={(event) =>
                        handleStatusChange(appointment.id, event.target.value)
                      }
                    >
                      <option value="Not Visited">Not Visited</option>
                      <option value="Visited">Visited</option>
                    </select>
                  </td>
                  <td colSpan="2">
                    <input
                      defaultValue={appointment.prescription}
                      //placeholder={appointment.prescription}
                      onChange={(event) =>
                        setUpdatedPrescription(event.target.value)
                      }
                    />
                  </td>
                  <td>
                    <button
                      type="button"
                      className="btn btn-outline-primary"
                      onClick={() => updatePrescription(appointment.id)}
                    >
                      Update
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}

export default DoctorHomePage;
