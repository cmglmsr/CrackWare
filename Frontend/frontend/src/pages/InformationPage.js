import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import CourseList from "../components/InformationPage/CourseList";
import UniversityList from "../components/InformationPage/UniversityList";
import { useEffect } from "react";

function InformationPage() {
  useEffect(() => {
    fetch(`https://jsonplaceholder.typicode.com/posts`).then((response) =>
      console.log(response)
    );
  }, []);
  return (
    <section>
      <Row>
        <Col className="mx-4">
          <div>
            <Row>
              <Col className="mx-5">
                <CourseList />
              </Col>
            </Row>
            <Row className="my-4">
              <UniversityList />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default InformationPage;
