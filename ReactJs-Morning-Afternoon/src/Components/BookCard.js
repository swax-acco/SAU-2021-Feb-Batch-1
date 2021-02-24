import {Link} from 'react-router-dom';
import {Card, Button} from 'react-bootstrap';
import {useHistory} from 'react-router-dom';
const BookCard = ({data}) => {
    const cardClick = () => {
        console.log(data.name + "Card Clicked");
    }
    const history = useHistory();
    return (
        <Card style={styles.card}>
            <Card.Body>
                <Card.Title>{data.title}</Card.Title>
                <Card.Text>
                {data.description.substring(0, 250) + "..."}
                </Card.Text>
                <Button variant="outline-primary" onClick = {() => history.push('/bookDetail/'+data.isbn)} >Details</Button>
            </Card.Body>
        </Card>
    );
};

const styles = {
    card : {
        "margin": "10px",
        width: '18rem',
        borderRadius: "6px"
    }
}
export default BookCard;