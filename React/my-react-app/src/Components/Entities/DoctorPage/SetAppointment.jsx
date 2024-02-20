import React, { useState } from "react";
import "./SetAppointment.css";

function SetAppointment() {
  const [startTime, setStartTime] = useState("");
  const [endTime, setEndTime] = useState("");
  const [slots, setSlots] = useState([]);
  const [sessionDuration, setSessionDuration] = useState(30);
  const [selectedSlots, setSelectedSlots] = useState([]);
  const [date, setDate] = useState("");

  const handleDateChange = (event) => {
    setDate(event.target.value);
  };

  const handleStartTimeChange = (event) => {
    setStartTime(event.target.value);
  };

  const handleEndTimeChange = (event) => {
    setEndTime(event.target.value);
  };

  const handleSessionDurationChange = (event) => {
    console.log("session duration changed" + event.target.value);
    setSessionDuration(parseInt(event.target.value));
  };

  const handleSlotCheckboxChange = (event) => {
    const slotValue = event.target.value;
    setSelectedSlots((prevSelectedSlots) => {
      if (prevSelectedSlots.includes(slotValue)) {
        return prevSelectedSlots.filter((slot) => slot !== slotValue);
      } else {
        return [...prevSelectedSlots, slotValue];
      }
    });
  };

  const calculateSlots = () => {
    const start = new Date(`01/01/2000 ${startTime}`);
    const end = new Date(`01/01/2000 ${endTime}`);
    const slots = [];

    let currentTime = new Date(start);

    while (currentTime <= end) {
      const slotTime = currentTime.toLocaleTimeString("en-US", {
        hour: "2-digit",
        minute: "2-digit",
      });
      slots.push(slotTime);
      currentTime = new Date(currentTime.getTime() + sessionDuration * 60000);
    }

    setSlots(slots);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const loginId = localStorage.getItem("loginId");
    console.log(
      JSON.stringify({ selectedSlots,  loginId, date })
    );
    fetch("http://localhost:8080/verifyLogin", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ selectedSlots, loginId, date }),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Appointment set successfully:", data);
      })
      .catch((error) => {
        console.error("Error setting appointment:", error);
      });
  };

  return (
    <>
      <legend>Set Appointment for {localStorage.getItem("username")}</legend>

      <form onSubmit={handleSubmit}>
        <div className="timeContainer">
          <div className="items">
            <label>
              Date
              <br />
              <input
                type="date"
                value={date}
                onChange={handleDateChange}
                required
              />
            </label>
            <label>
              Starting Time
              <input
                type="time"
                value={startTime}
                onChange={handleStartTimeChange}
                required
              />
            </label>
            <label>
              End Time
              <input
                type="time"
                value={endTime}
                onChange={handleEndTimeChange}
                required
              />
            </label>
          </div>
          <label>
            Session Duration
            <select
              value={sessionDuration}
              onChange={handleSessionDurationChange}
              class="form-select"
            >
              <option value={15}>15 mins</option>
              <option value={30}>30 mins</option>
              <option value={60}>60 mins</option>
              <option value={90}>90 mins</option>
            </select>
          </label>
          <button class="btn btn-outline-primary" onClick={calculateSlots}>
            Get Slots
          </button>
        </div>
        <div>
          <legend>Select Slots</legend>
          <div className="container">
            <div className="row">
              {slots.map((value, index) => (
                <div key={index} className="col-sm-3 ">
                  <span>{value}</span>
                  <input
                    type="checkbox"
                    className="form-check-input"
                    value={value}
                    checked={selectedSlots.includes(value)}
                    onChange={handleSlotCheckboxChange}
                  />
                </div>
              ))}
            </div>
          </div>
        </div>
        <button class="btn btn-primary" type="submit">
          Submit
        </button>
      </form>
    </>
  );
}

export default SetAppointment;
