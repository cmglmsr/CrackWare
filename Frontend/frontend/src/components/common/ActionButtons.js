import Card from "../UI/Card";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import { Link } from "react-router-dom";

const ActionButtons = ({role}) => {
    let buttons = [];
    if (role === "ROLE_STUDENT") {
        buttons[0] = <Button className="button-default" key="application" as={Link} to="/student/getApplication">My Application</Button>;
        buttons[1] = <Button className="button-default" key="createCourseWishlist" as={Link} to="/student/createCourseWishlist">Course Wishlist</Button>;
        buttons[2] = <Button className="button-default" key="uploadPreApproval" as={Link} to="/student/preApproval">Upload Pre-Approval</Button>;
        buttons[3] = <Button className="button-default" key="uploadLearningAgreement" as={Link} to="/student/learningAgreement">Upload Learning Agreement</Button>;
    }
    else if (role === "ROLE_ISO") {
        buttons[0] = <Button className="button-default" key="transcripts" as={Link} to="/iso/transcripts">Transcripts</Button>;
    }
    else if (role === "ROLE_INSTRUCTOR") {
        buttons[4] = <Button className="button-default" key="view-wishlists" as={Link} to="/instructor/wishlists">View Wishlists</Button>;
    }
    else if (role === "ROLE_FACULTY_BOARD_MEMBER") {
        buttons[0] = <Button className="button-default" key="application" as={Link} to="/fbm/preApprovals">PreApprovals</Button>;
    }
    if (role === "ROLE_COORDINATOR") {
        buttons[0] = <Button className="button-default" key="application-list" as={Link} to="/coordinator/applications">Applications</Button>;
        buttons[1] = <Button className="button-default" key="placements" as={Link} to="/coordinator/placements">Placements</Button>;
        buttons[3] = <Button className="button-default" key="course-transfer-list" as={Link} to="/coordinator/learningAgreements">Learning Agreements</Button>;
        buttons[2] = <Button className="button-default" key="wait-list" as={Link} to="/coordinator/waitinglist">Waitlist</Button>;
        buttons[4] = <Button className="button-default" key="final-course-transfer" as={Link} to="/coordinator/finalCourseTransferList">Final Course Transfer</Button>;
    }

    const results= []
    buttons.forEach(button => {
        results.push(
            <Row  className="m-2" key={button.key}>
                {button}
            </Row>
        );
    })

    return(
        <Card>
            {results}
        </Card>
    )
}

export default ActionButtons;