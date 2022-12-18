import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./WaitingList.module.css";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";
import WaitingListContext from "../../context/WaitingListContext/WaitingListContext";

function WaitingList() {
  const waitingList = useContext(WaitingListContext);
  //const navigate = useNavigate();

  function handleInput(e) {
    console.log(e.target.value);
    const id = e.target.value;
    //navigate(`/coordinator/applications/${uid}`)
  };
  
  return (
    <Card>
      <h3 className="heading my-3">Waiting List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th>Fullname</th>
              <th>ID </th>
              <th>CGPA</th>
              <th>Placement</th>
              <th>Status</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {waitingList.map((application) => (
              <tr key={application.id}>
                <td>{application.fullname}</td>
                <td>{application.id}</td>
                <td>{application.cgpa}</td>
                <td>{application.school ? application.school : "Not Determined"}</td>
                <td>{application.status}</td>
                <td>
                  <Button key={application.id} value={application.id} className={classes.button} onClick={e => handleInput(e, "value")}>Reject</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default WaitingList;
