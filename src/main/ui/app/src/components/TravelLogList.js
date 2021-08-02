import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import AppFooter from './AppFooter';
import { Link } from 'react-router-dom';

class TravelLogList extends Component {

  constructor(props) {
    super(props);
    this.state = {routes: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('api/empty-route')
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
          <h3>Travel Log List</h3>
          <Table className="mt-4">
            <thead>
            <tr>
              <th width="20%">Travel Log Id</th>
              <th width="20%">Lane</th>
              <th width="10%">Position</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
          </Table>
        </Container>
        <AppFooter/>
      </div>
    );
  }
}

export default TravelLogList;