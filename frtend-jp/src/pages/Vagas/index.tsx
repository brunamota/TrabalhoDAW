import { useState } from 'react';
import { useHistory } from 'react-router-dom';
import { FiArrowRightCircle, FiArrowLeftCircle } from 'react-icons/fi'
import { Table } from 'react-bootstrap';

import logoImage from 'assets/images/user.png'

import 'pages/Vagas/style.css'
import NavBar from 'componets/basics/navbar';
import Footer from 'componets/basics/footer';
import API from 'services/API';

interface iVagas {


}

const Vagas: React.FC = () => {

  const [vagas, setvagas] = useState<iVagas[]>([]);
  const [page, setPage] = useState(0);

  const username = localStorage.getItem('username');
  const token = localStorage.getItem('token');

  const history =  useHistory();

  async function lodVagas() {}
  

  return (
    <>
    <div>
      <NavBar />
    </div>

    <div className="vagas-container">
      <header>
        <img src={logoImage} alt="Job Pool" />
        <span>Bem-vindo, <strong>{"NOME"}</strong>!</span>
      </header>

    

      <h1>Vagas de estágios disponíveis</h1>

      <Table striped bordered hover className="text-center">
        <thead>
          <tr>
            <th>Nome</th>
            <th>Empresa</th>
            <th>Quantidade</th>
            <th>Porcentagem</th>
            <th>Período</th>
            <th>Remuneração</th>
            <th>Horas Semanais</th>
            <th>Candidatar</th>
          </tr>
        </thead>
        <tbody>
          {
            <tr>
              <td>Desenvolvedor de Sistemas</td>
              <td>Inteligente TI</td>
              <td>02</td>
              <td>65%</td>
              <td>Matutino</td>
              <td>R$400,00</td>
              <td>20h</td>
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
              <td>Enfermagem obstétrica</td>
              <td>Hospital Padre Tiago</td>
              <td>03</td>
              <td>70%</td>
              <td>Noturno</td>
              <td>R$1000,00</td>
              <td>20h</td>
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
export default Vagas;
