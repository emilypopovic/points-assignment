import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import AppFooter from './AppFooter';
import { Link } from 'react-router-dom';

class RouteClient extends Component {

  constructor(props) {
    super(props);
    this.state = {routes: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});

    {/* the correct link path is retrieved via the props location object */}
    const pathName = '/api' + this.props.location.pathname;
    fetch(pathName)
      .then(response => response.json())
      .then(data => this.setState({routes: data, isLoading: false}));
  }

  render() {
    const {routes, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <h3>Car Route</h3>
          <div>
          <hr/>
            {this.props.location.pathname}
          <hr/>
          </div>
          <div>
            request payload
          <hr/>
          </div>
          <div>
            <p>Response:</p>
            <pre>{JSON.stringify(routes, null, 2) }</pre>
          </div>
        </Container>
        <AppFooter/>
      </div>
    );
  }
}

export default RouteClient;