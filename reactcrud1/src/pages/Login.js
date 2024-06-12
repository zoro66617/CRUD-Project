import axios from "axios";
import React, { useRef, useState } from "react";
import { useNavigate } from "react-router-dom";

export default function Login() {
  let navigate = useNavigate();
  const emailRef = useRef();
  const passwordRef = useRef();

  const [alertMessage, setAlertMessage] = useState("");
  const [alertType, setAlertType] = useState("");

  const onSubmit = async (e) => {
    e.preventDefault();
    const AdminDTO = {
      email: emailRef.current.value,
      password: passwordRef.current.value,
    };

    console.log("Email:", AdminDTO.email);
    console.log("Password:", AdminDTO.password);

    try {
      const response = await axios.post('http://localhost:8080/loginAdmin', AdminDTO);
      if (response.data === "valid") {
        setAlertMessage("Login successful");
        setAlertType("success");
        setTimeout(() => {
          navigate("/home");
        }, 1000);
      } else {
        setAlertMessage(response.data);
        setAlertType("danger");
      }
    } catch (error) {
      console.error('There was an error logging in!', error);
      setAlertMessage('An error occurred. Please try again.');
      setAlertType("danger");
    }
  };

  return (
    <div className="container mt-5 ">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Login</h2>

          {alertMessage && (
            <div className={`alert alert-${alertType}`} role="alert">
              {alertMessage}
            </div>
          )}

          <form onSubmit={onSubmit}>
            <div className="mb-3">
              <label htmlFor="Email" className="form-label">Email</label>
              <input
                type="email"
                className="form-control"
                placeholder="Enter your email"
                ref={emailRef}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Password" className="form-label">Password</label>
              <input
                type="password"
                className="form-control"
                placeholder="Enter your password"
                ref={passwordRef}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">Login</button>
            <button
              type="button"
              className="btn btn-outline-danger mx-2"
              onClick={() => navigate("/")}
            >
              Cancel
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
