import React, { Component } from 'react';
import { Nav, Navbar, NavbarBrand, NavItem } from 'reactstrap';
import { Container } from 'reactstrap';

export default class AppFooter extends Component {
	render() {
		return(
            <div className="fixed-bottom">
                <Navbar color="dark">
                     <div className="navbar-footer">Points Interview Test | Emily Popovic</div>
                </Navbar>
            </div>
		);
	}
}
