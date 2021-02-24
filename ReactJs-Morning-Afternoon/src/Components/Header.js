import React, {useRef} from "react";
import {useHistory} from 'react-router-dom';
import {Form, Row, Col, Container, Button} from 'react-bootstrap';

const Header = () => {
    const inpRef = useRef();
    const history = useHistory();
    const submitClick = () => {
        if(inpRef.current.value.trim() == ""){ 
            inpRef.current.value = "";
            history.push("/search=*");
        }
        else history.push("/search=" + inpRef.current.value.trim());
    }
    const clearClick = () => {
        inpRef.current.value = "";
        history.push("/");
    }
    return (
        <Container style={{marginTop: "10px"}}>
            <Row>
                <Col></Col>
                <h3 style={{color:"gray"}}>Search By Book Name</h3>
                <Col></Col>
            </Row>
            <Row>
                <Col></Col>
                <Form inline>
                <Form.Control type="text" ref={inpRef} placeholder="Book Name" style={{width:"300px"}}/>
                <Button variant="secondary" onClick = {submitClick} style = {{"margin": "10px"}} >Submit</Button>
                <Button variant="danger" onClick = {clearClick} >Clear</Button>
                </Form>
                <Col></Col>
            </Row>
        </Container>
        
    );
};

export default Header;