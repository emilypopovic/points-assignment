import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import RouteClient from './components/RouteClient';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/empty-route' exact={true} component={RouteClient}/>
          <Route path='/success-no-obstacles' exact={true} component={RouteClient}/>
          <Route path='/success-with-obstacles' exact={true} component={RouteClient}/>
          <Route path='/failure-out-of-bounds' exact={true} component={RouteClient}/>
          <Route path='/failure-hits-obstacle' exact={true} component={RouteClient}/>
          <Route path='/random' exact={true} component={RouteClient}/>
        </Switch>
      </Router>
    );
  }
}

export default App;