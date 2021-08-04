import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavbar';
import AppFooter from './AppFooter';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <div className="div-spacing">
            <Button spacing color="dark"><Link to="/empty-route" style={{ color: '#FFF'}}>Empty Route</Link></Button>
          </div>
          <div className="div-spacing">
            <Button spacing color="dark"><Link to="/success-no-obstacles" style={{ color: '#FFF' }}>Success No Obstacles Route</Link></Button>
          </div>
          <div className="div-spacing">
            <Button spacing color="dark"><Link to="/success-with-obstacles" style={{ color: '#FFF' }}>Success With Obstacles Route</Link></Button>
          </div>
          <div className="div-spacing">
            <Button spacing color="dark"><Link to="/failure-out-of-bounds" style={{ color: '#FFF' }}>Failure Out of Bounds Route</Link></Button>
          </div>
          <div className="div-spacing">
            <Button spacing color="dark"><Link to="/failure-hits-obstacle" style={{ color: '#FFF' }}>Failure Hits Obstacle Route</Link></Button>
          </div>
          <div className="div-spacing">
            <Button spacing color="dark"><Link to="/random" style={{ color: '#FFF' }}>Random Route</Link></Button>
          </div>
        </Container>
        <AppFooter/>
      </div>
    );
  }
}

export default Home;
