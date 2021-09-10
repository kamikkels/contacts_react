import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Contacts from './Contacts';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/contacts' exact={true} component={Contacts}/>
        </Switch>
      </Router>
    )
  }
}

export default App;