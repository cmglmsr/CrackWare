import { formatPhoneNumberIntl } from "react-phone-number-input";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import { useState } from "react";
import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationDetails.module.css";

function ApplicationDetails(props) {
  var application = props.application;
  var phoneNumber = formatPhoneNumberIntl(application.phone);

  const schoolChoices = [
    {
      value: "0",
      label: "",
    },
    {
      value: "1",
      label: "Ecole Polytechnique Federale de Lausanne (EPFL)-Switzerland",
    },
    { value: "2", label: "Vrije Universiteit Amsterdam-The Netherlands" },
    {
      value: "3",
      label:
        "Ecole Pour Linformatique Et Les Techniques Avancees (EPITA)-France",
    },
    { value: "4", label: "Kingston University-U.K." },
  ];
  const [pref1, setPref1] = useState("0");
  const [pref2, setPref2] = useState("0");
  const [pref3, setPref3] = useState("0");
  const [pref4, setPref4] = useState("0");
  const [pref5, setPref5] = useState("0");

  const handleSelect = (event) => {
    if (event.target === document.getElementById("pref1")) {
      setPref1(event.target.value);
    }
    if (event.target === document.getElementById("pref2")) {
      setPref2(event.target.value);
    }
    if (event.target === document.getElementById("pref3")) {
      setPref3(event.target.value);
    }
    if (event.target === document.getElementById("pref4")) {
      setPref4(event.target.value);
    }
    if (event.target === document.getElementById("pref5")) {
      setPref5(event.target.value);
    }
  };
  
  var cb;
  const [isSubscribed, setIsSubscribed] = useState(true);
  const handleChange = (event) => {
    if (event.target.checked) {
      var check1 = document.getElementById("check1");
      var check2 = document.getElementById("check2");
      var check3 = document.getElementById("check3");
      if (event.target != check1 && check1.checked === true){
        event.target.value = setIsSubscribed(event.target.value);
          
        console.log(event.target);
        document.getElementById("check1").click();
      }
      if (event.target != check2 && check2.checked === true){
        event.target.value = 2;
        console.log(event.target);
        document.getElementById("check2").click();
      }
      if (event.target != check3 && check3.checked === true){
        event.target.value = true;
        console.log(event.target);
        document.getElementById("check3").click();
      }
    }
    setIsSubscribed((current) => !current);
  };
  return (
    <Card>
      <Form className="form">
        <h3 className={classes.heading}>Application</h3>
        <hr />
        <h6>Contact Information</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Email</td>
              <td>{application.email}</td>
            </tr>
            <tr>
              <td>Address</td>
              <td>{application.address}</td>
            </tr>
            <tr>
              <td>Phone Number</td>
              <td>{phoneNumber}</td>
            </tr>
          </tbody>
        </Table>

        <h6>Erasmus Preferences</h6>
        <hr className={classes.simple} />
        <Form.Group as={Row} className="my-3" controlId="preferredPeriod">
          <Col sm="3">Time Period</Col>
          <Col>
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                id="check1"
                value= "1"
                onChange={handleChange}
              />
              <label className="form-check-label">
              Fal Semester Only
              </label>
            </div>
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                id="check2"
                value="2"
                onChange={handleChange}
              />
              <label className="form-check-label">
              Spring Semester Only
              </label>
            </div>
            <div className="form-check">
              <input
                className="form-check-input"
                type="checkbox"
                id="check3"
                value="3"
                onChange={handleChange}
              />
              <label className="form-check-label">
              Fal & Spring Semesters
              </label>
            </div>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            1st Preference
          </Form.Label>
          <Col>
            <Form.Select value={pref1} onChange={handleSelect} id="pref1">
              {schoolChoices.map((school) => (
                <option key={school.value} value={school.value}>
                  {school.label}
                </option>
              ))}
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            2nd Preference
          </Form.Label>
          <Col>
          <Form.Select value={pref2} onChange={handleSelect} id="pref2">
              {schoolChoices.map((school) => (
                <option key={school.value} value={school.value}>
                  {school.label}
                </option>
              ))}
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            3rd Preference
          </Form.Label>
          <Col>
          <Form.Select value={pref3} onChange={handleSelect} id="pref3">
              {schoolChoices.map((school) => (
                <option key={school.value} value={school.value}>
                  {school.label}
                </option>
              ))}
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            4th Preference
          </Form.Label>
          <Col>
          <Form.Select value={pref4} onChange={handleSelect} id="pref4">
              {schoolChoices.map((school) => (
                <option key={school.value} value={school.value}>
                  {school.label}
                </option>
              ))}
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            5th Preference
          </Form.Label>
          <Col>
          <Form.Select value={pref5} onChange={handleSelect} id="pref5">
              {schoolChoices.map((school) => (
                <option key={school.value} value={school.value}>
                  {school.label}
                </option>
              ))}
            </Form.Select>
          </Col>
        </Form.Group>

        <h6>Documents</h6>
        <hr />
        <Form.Group as={Row} controlId="formFile" className="mb-3">
          <Form.Label column sm="3">
            CV
          </Form.Label>
          <Col>
            <Form.Control type="file" />
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
            <Button variant="primary" className="button-default" type="submit">
              Save Changes
            </Button>
          </Col>
        </Form.Group>
      </Form>
    </Card>
  );
}

export default ApplicationDetails;
