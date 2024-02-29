import React, { useState } from "react";
//import data from "./appointment-timedata.js";

function PatientBookAppointment() {
  const doctorId = localStorage.getItem("doctorBookingId");
  const doctorFname = localStorage.getItem("doctorBookingfName");
  const doctorLname = localStorage.getItem("doctorBookinglname");
  const patientId = localStorage.getItem("loginId");

  const [data, setData] = useState([]);
  const [date, setDate] = useState("");
  const [selectedSlot, setSelectedSlot] = useState("");
  const [reason, setReason] = useState("");
  const [isSlotSelected, setIsSlotSelected] = useState(false);

  const handleDateChange = (event) => {
    setDate(event.target.value);
    setSelectedSlot("");
    setIsSlotSelected(false);
  };

  const handleSlotChange = (event) => {
    setSelectedSlot(event.target.value);
    setIsSlotSelected(true);
  };

  const handleReasonChange = (event) => {
    setReason(event.target.value);
  };

  const handleFormSubmit = (event) => {
    event.preventDefault();

    // if (!date || new Date(date) <= new Date()) {
    //   alert("Please select a valid future date");
    //   return;
    // }

    if (!isSlotSelected) {
      alert("Please select a slot");
      return;
    } else {
      console.log(
        JSON.stringify({
          doctorId: doctorId,
          appointmentDate: date,
          appointmentTime: selectedSlot,
          patientId: patientId,
          notes: reason,
        })
      );

      fetch("http://localhost:8080/appointments/bookSlot", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          doctorId: doctorId,
          appointmentDate: date,
          appointmentTime: selectedSlot,
          patientId: patientId,
          notes: reason,
        }),
      })
        .then((response) => response.json())
        .then((data) => {
          alert("Appointment booked successfully:", data);
        })
        .catch((error) => {
         // alert("Error booking appointment:", error);
        });
        window.location.reload();
    }
  };

  const filteredAppointments = data.filter(
    (appointment) => appointment.flag === 1
  );

  const fetchAvailableSlots = () => {
    console.log(`http://localhost:8080/getAllDoctor/${date}/${doctorId}`);

    fetch(`http://localhost:8080/getAllDoctor/${date}/${doctorId}`)
      .then((resp) => {
        if (resp.ok) {
          return resp.json();
        } else {
          throw new Error("Failed to fetch doctors");
        }
      })
      .then((data) => {
        console.log(data);
        setData(data);
      })
      .catch((error) => {
        alert("Error fetching doctors:", error);
      });
  };

  return (
    <div className="PatientBookAppointment">
      <form onSubmit={handleFormSubmit}>
        <legend>
          Book slots for Dr. {doctorFname} {doctorLname}
        </legend>
        <label>
          Date
          <br />
          <input
            type="date"
            value={date}
            onChange={handleDateChange}
            //min={new Date()}
            min={new Date().toISOString().split("T")[0]}
            required
          />
        </label>
        <button type="button" onClick={fetchAvailableSlots}>
          Check Available Slots
        </button>
        <br />
        <div>
          <div className="container">
            <div className="row">
              {filteredAppointments.map((appointment) => (
                <div key={appointment.id} className="col-sm-3 ">
                  <input
                    type="radio"
                    id={appointment.slotStart}
                    className="form-check-input"
                    name="appointmentSlot"
                    value={appointment.slotStart}
                    checked={selectedSlot === appointment.slotStart}
                    onChange={handleSlotChange}
                  />
                  <label htmlFor={appointment.slotStart}>
                    {appointment.slotStart}
                  </label>
                </div>
              ))}
            </div>
          </div>
        </div>
        <br />
        <label>
          Reason
          <br />
          <input type="text" value={reason} onChange={handleReasonChange} />
        </label>
        <button type="submit">Book Appointment</button>
      </form>
    </div>
  );
}

export default PatientBookAppointment;
