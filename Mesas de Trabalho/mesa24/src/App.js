import { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import Swal from 'sweetalert2';
import api from './services/api';
import './App.scss';

export default class App extends Component {
  constructor() {
    super();
    this.state = {
      enderecos: {}
    }
  }

  handleSubmit = async ({ cep }) => {
    if (cep !== '') {
      try {
        const response = await api.get(`./${cep}`);
        this.setState({ enderecos: response.data });
      } catch (error) {
        Swal.fire({
          title: error.response.status,
          icon: 'error',
          text: error.response.data.message
        });
      }
    }
  }

  render() {
    return (
      <>
        <main>
          <div className="col-md-4 col-sm-6 my-3 container text-center">
            <h2>Procure um endereço pelo CEP</h2>
            <Formik initialValues={{ cep: '' }} onSubmit={this.handleSubmit}>
              <Form>
                <Field placeholder="Insira o CEP" required type="text" name="cep" id="cep" className="form-control" />
                <button type="submit" className="btn btn-primary my-4">Pesquisar</button>
              </Form>
            </Formik>
            {this.state.enderecos && (
              <ul>
                <li>CEP: {this.state.enderecos.cep}</li>
                <li>Rua: {this.state.enderecos.logradouro}</li>
                <li>Bairro: {this.state.enderecos.bairro}</li>
                <li>Cidade: {this.state.enderecos.localidade}</li>
                <li>Estado: {this.state.enderecos.uf}</li>
                <li>Serviço: {this.state.enderecos.service}</li>
              </ul>
              )              
            }
          </div>
        </main>
      </>
    );
  }
}