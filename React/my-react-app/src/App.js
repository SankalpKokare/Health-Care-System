import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import DoctorRegistration from './Components/Registration component/DoctorRegistration.jsx';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import LoginPage from './Components/LoginPage/LoginPage';
import PatientRegistration from './Components/Registration component/PatientRegistration.jsx';
import NavLinks from './Components/NavBar/NavLinks.jsx';
import AdminHomePage from './Components/Entities/AdminPage/AdminHomePage.jsx';
import DoctorHomePage from './Components/Entities/DoctorPage/DoctorHomePage.jsx';
import PatientHomePage from './Components/Entities/PatientPage/PatientHomePage.jsx';
import ErrorPage from './Components/ErrorPage/ErrorPage.jsx'
import AdminDoctorPage from './Components/Entities/AdminPage/AdminDoctorPage.jsx';
import AdminAllPatient from './Components/Entities/AdminPage/AdminAllPatient.jsx';
// import DoctorProfilePage from './Components/Entities/DoctorPage/DoctorProfilePage.jsx';
function App() {
  return (
    <>
      <BrowserRouter>
        <NavLinks />
        <Routes>
          <Route path="/" element={<LoginPage />} />

          <Route path="/doc-reg" element={<DoctorRegistration />} />
          <Route path="/pat-reg" element={<PatientRegistration />} />
          <Route path="/adminHome" element={<AdminHomePage />} />
          <Route path="/docHome" element={< DoctorHomePage/>} />
          <Route path="/patientHome" element={< PatientHomePage/>} />
          <Route path="/serverError" element={<ErrorPage/>} />
          {/* <Route path="/docProfile" element={<DoctorProfilePage/>} /> */}
          <Route path="/adminDoctor" element={<AdminDoctorPage/>} />
          <Route path="/adminPatient" element={<AdminAllPatient/>} />

          
          
        </Routes>
      </BrowserRouter>
    </>

  );
}

export default App;
