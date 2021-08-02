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
          <Button color="dark"><Link to="/empty-route" style={{ color: '#FFF' }}>Manage Car Routes</Link></Button>
        </Container>
        <AppFooter/>
      </div>
    );
  }
}

export default Home;
