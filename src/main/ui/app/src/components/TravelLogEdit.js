import React, { Component } from 'react';
import { Link, withRouter } from 'react-router-dom';
import { Button, Container, Form, FormGroup, Input, Label } from 'reactstrap';
import AppNavbar from './AppNavbar';
import AppFooter from './AppFooter';

class TravelLogEdit extends Component {

  emptyItem = {
    travelLogId: '',
    lane: '',
    position: ''
  };

  constructor(props) {
    super(props);
    this.state = {
      item: this.emptyItem
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  async componentDidMount() {
    if (this.props.match.params.id !== 'new') {
      const travelLog = await (await fetch(`/api/autonomous-car/routes/travel-log/${this.props.match.params.id}`)).json();
      this.setState({item: travelLog});
    }
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let item = {...this.state.item};
    item[name] = value;
    this.setState({item});
  }

  async handleSubmit(event) {
    event.preventDefault();
    const {item} = this.state;

    await fetch('/api/autonomous-car/routes/travel-log' + (item.id ? '/' + item.id : ''), {
      method: (item.id) ? 'PUT' : 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(item),
    });
    this.props.history.push('/travel-logs');
  }

  render() {
    const {item} = this.state;
    const title = <h2>{item.id ? 'Edit Travel Log' : 'Add Travel Log'}</h2>;

    return <div>
      <AppNavbar/>
      <Container>
        {title}
        <Form onSubmit={this.handleSubmit}>
          <FormGroup>
            <Label for="travelLogId">Travel Log Id</Label>
            <Input type="text" name="travelLogId" id="travelLogId" value={item.travelLogId || ''}
                   onChange={this.handleChange} autoComplete="travelLogId"/>
          </FormGroup>
          <FormGroup>
            <Label for="lane">Lane</Label>
            <Input type="text" name="lane" id="lane" value={item.lane || ''}
                   onChange={this.handleChange} autoComplete="lane"/>
          </FormGroup>
          <FormGroup>
            <Label for="position">Position</Label>
            <Input type="text" name="position" id="position" value={item.position || ''}
                   onChange={this.handleChange} autoComplete="position"/>
          </FormGroup>
          <FormGroup>
            <Button color="primary" type="submit">Save</Button>{' '}
            <Button color="secondary" tag={Link} to="/travel-logs">Cancel</Button>
          </FormGroup>
        </Form>
      </Container>
      <AppFooter/>
    </div>
  }
}

export default withRouter(TravelLogEdit);
