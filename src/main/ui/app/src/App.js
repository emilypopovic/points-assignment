import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import TravelLogList from './components/TravelLogList';
import TravelLogEdit from './components/TravelLogEdit';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/empty-route' exact={true} component={TravelLogList}/>
          <Route path='/travel-logs/:id' component={TravelLogEdit}/>
        </Switch>
      </Router>
    )
  }
}

export default App;