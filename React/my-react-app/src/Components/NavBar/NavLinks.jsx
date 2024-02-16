import React from "react";
import { Link, useLocation, useNavigate } from "react-router-dom";
import "./NavLinks.css";

function NavLinks() {
  const location = useLocation();
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("username");
    localStorage.removeItem("loginId");
    // Redirect to the login page after logout
    navigate("/");
  };

  return (
    <>
      <nav className="navbar navbar-expand-lg sticky-top  navbar-dark bg-dark">
        <div>
          <Link className="navbar-brand" to="/">
           HealthCare System
          </Link>
        </div>

        <div>
          {location.pathname === "/" && (
            <>
              <div className="right-block">
                <Link className="navbar-text" to="/doc-reg">
                  Register Doctor
                </Link>
                <Link className="navbar-text" to="/pat-reg">
                  Register Patient
                </Link>
              </div>
            </>
          )}
          {location.pathname === "/doc-reg" && (
            <>
              <Link className="navbar-text" to="/">
                Login
              </Link>
            </>
          )}
          {location.pathname === "/pat-reg" && (
            <>
              <Link className="navbar-text" to="/">
                Login
              </Link>
            </>
          )}

          {location.pathname === "/docHome" && (
            <>
              <a href="/docProfile" className="navbar-text" >
                Profile
              </a>
            </>
          )}

          {location.pathname === "/docProfile" && (
            <>
              <Link className="navbar-text" to="/docHome">
                Home
              </Link>

              <button className="btn btn-danger" onClick={handleLogout}>
                Logout
              </button>
            </>
          )}

          {location.pathname.endsWith("Home") && (
            <>
              <button className="btn btn-danger" onClick={handleLogout}>
                Logout
              </button>
            </>
          )}
        </div>
      </nav>
    </>
  );
}

export default NavLinks;
