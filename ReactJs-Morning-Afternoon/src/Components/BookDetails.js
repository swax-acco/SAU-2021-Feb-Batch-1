import bookData from '../books.json';
import {Card, Row, Button, Col, Container} from 'react-bootstrap';
import {useHistory} from 'react-router-dom';
const BookDetail = ({match}) => {
    console.log( match.params.id);
    const history = useHistory();
    var index = bookData.findIndex(obj => obj.isbn === match.params.id);
    const data = bookData[index];
    return (
        <Container style={{marginTop: "10px"}}>
            <Row>
            <Col></Col>
            <Card style={styles.card}>
            {/* <Card.Img variant="top" src="holder.js/100px180" /> */}
            <Card.Body>
                <Card.Title>{data.title}</Card.Title>
                    <Card.Text>{data.subtitle}</Card.Text>
                    <Card.Text>Discription: {data.description}</Card.Text>
                    <Card.Text>By: {data.author}</Card.Text>
                    <Card.Text>Published on: {data.published}</Card.Text>
                    <Card.Text>Publisher: {data.publisher}</Card.Text>
                    <Button variant="outline-primary" onClick = {() => {if(history.length > 0){history.goBack()} else{history.push("/")}}}>Back</Button>
                </Card.Body>
            </Card>
            <Col></Col>
            </Row>  
        </Container>
    );
};

const styles = {
    card : {
        width: '25rem',
        borderRadius: "6px"
    }
}

export default BookDetail;