import React, { Component } from 'react';
import { Nav, Navbar, NavbarBrand, NavItem } from 'reactstrap';
import { Container } from 'reactstrap';

export default class AppFooter extends Component {
	render() {
		return(
            <div className="footer-spacing">
                <div className="fixed-bottom">
                    <Navbar color="dark">
                         <div className="navbar-footer">Points Test | Emily Popovic</div>
                    </Navbar>
                </div>
            </div>
		);
	}
}
