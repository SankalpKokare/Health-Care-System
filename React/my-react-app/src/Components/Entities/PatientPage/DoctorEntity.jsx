import icon from "../icon.jpg";
import "./PatientDoctorEntity.css";
import { useNavigate } from "react-router-dom";

export default function AdminDoctoEntity(prop) {
  const navigate = useNavigate();

  const BookAppointment = () => {
    localStorage.setItem("doctorBookingId", prop.doctorid);
    localStorage.setItem("doctorBookingfName", prop.first_name);
    localStorage.setItem("doctorBookinglname", prop.last_name);

    navigate("/getAppointment");
  };

  return (
    <>
      <div className="PatientDoctorEntity">
        <div className="card w-70 card-max ">
          <div className="card-header text-center">{prop.specialization} </div>
          <img src={icon} alt="" className="rounded mx-auto d-block" />
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
            <button className="btn btn-primary" onClick={BookAppointment}>
              Book Appointment
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
      </div>
    </>
  );
}
