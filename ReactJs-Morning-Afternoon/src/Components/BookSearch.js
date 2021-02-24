import BookCard from './BookCard'
import bookData from '../books.json';
import {Row, Col, Container, Button} from 'react-bootstrap';

const BookSearch = ({match}) => {
  var query = "";
  if(match.params.query && match.params.query != '*'){
    query = match.params.query.toLowerCase();
  }
  var filteredList = bookData.filter(function (row) {
    if(row.title.toLowerCase().match(query)) {
      return true;
    } else {
      return false;
    }
  });
  var bookList = filteredList.map(data => { return <BookCard data = {data} key = {data.isbn}/>});
  return (
      <Container style={{paddingLeft:"120px"}}>
        <Row>
          {bookList}
        </Row>
    </Container>
  );
}

export default BookSearch;
