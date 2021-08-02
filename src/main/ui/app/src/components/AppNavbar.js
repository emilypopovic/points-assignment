import React, { Component } from 'react';
import logo from '../assets/logo.svg';
import { Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem, NavLink } from 'reactstrap';
import { Link } from 'react-router-dom';

export default class AppNavbar extends Component {
  constructor(props) {
    super(props);
    this.state = {isOpen: false};
    this.toggle = this.toggle.bind(this);
  }

  toggle() {
    this.setState({
      isOpen: !this.state.isOpen
    });
  }

  render() {
    return (
        <Navbar color="dark" dark expand="md">
          <NavbarBrand tag={Link} to="/">
            The Autonomous Car
            <img src={logo} className="App-logo" alt="logo"/>
          </NavbarBrand>

          <NavbarToggler onClick={this.toggle}/>
          <Collapse isOpen={this.state.isOpen} navbar>
            <Nav className="ml-auto" navbar>
              <NavItem>
                <NavLink
                  href="https://www.linkedin.com/in/emilypopovic/">@epopovic</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="https://github.com/emilypopovic">GitHub</NavLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Navbar>
    );
  }
}
