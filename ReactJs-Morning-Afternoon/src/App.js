import React, {useState} from "react";
import Header from "./Components/Header";
import BookDetail from "./Components/BookDetails";
import BookSearch from "./Components/BookSearch";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";


function App() {
  return (
    <Router>
        <Header />
        <Switch>
          <Route path = "/" exact component = {BookSearch} />
          <Route path = "/search=:query" component = {BookSearch} />
          <Route path = "/bookDetail/:id" exect component = {BookDetail} />
        </Switch>
    </Router>
  );
}

export default App;
