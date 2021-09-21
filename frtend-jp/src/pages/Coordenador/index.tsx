import { useState } from 'react';
import { useHistory } from 'react-router-dom';
import { FiArrowRightCircle, FiArrowLeftCircle } from 'react-icons/fi'
import { Table } from 'react-bootstrap';

import logoImage from 'assets/images/user.png'

import 'pages/Coordenador/style.css'
import NavBar from 'componets/basics/navbar';
import Footer from 'componets/basics/footer';
import API from 'services/API';

const Coordenador: React.FC = () => {

  return (
    <>
    <div>
      <NavBar />
    </div>

    <div className="coordenador-container">
      <header>
        <img src={logoImage} alt="Job Pool" />
        <span>Bem-vindo, <strong>{"COORDENADOR"}</strong>!</span>
      </header>

      <h1>Empresas Cadastradas</h1>

      <Table striped bordered hover className="text-center">
        <thead>
          <tr>
            <th>Nome</th>
            <th>CNPJ</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Endereço</th>
            <th>Area</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {
            <tr>
              <td>Inteligente TI</td>
              <td>00.000.000/0000-01</td>
              <td>inteligente@empresa.com</td>
              <td>(64) 3035-8795</td>
              <td>Rua Oscar Freire,123, Jataí-GO</td>
              <td>Tecnologia</td>
              <td>
                <button type="button">
                  <FiArrowRightCircle size={20} color="#251FC5" />
                </button>
              </td>
            </tr>
          }
        </tbody>

        <tbody>
          {
            <tr>
              <td>Hospital Padre Thiago</td>
              <td>00.000.000/0000-02</td>
              <td>padrethiago@hospital.com</td>
              <td>(64)99392-8877</td>
              <td>R. Castro Alves, 686, Jataí-GO</td>
              <td>Saúde</td>
              <td>
                <button type="button">
                  <FiArrowRightCircle size={20} color="#251FC5" />
                </button>
              </td>
            </tr>
          }
        </tbody>
      </Table>
    </div>
  <div>
  <Footer />
  </div>
    </>
  );
}
export default Coordenador;
